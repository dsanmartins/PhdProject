package br.ufscar.sas.transformation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import org.apache.commons.collections4.map.HashedMap;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IEqualityHelperFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.EqualityHelper;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

import com.google.common.cache.LoadingCache;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.structurizr.Workspace;
import com.structurizr.model.Container;
import com.structurizr.model.DeploymentNode;
import com.structurizr.model.Element;
import com.structurizr.model.Location;
import com.structurizr.model.Model;
import com.structurizr.model.Relationship;
import com.structurizr.model.SoftwareSystem;
import com.structurizr.view.DeploymentView;
import com.structurizr.view.ViewSet;

public class ComputeModelDiff {

	List<String> lstPackageMove = new ArrayList<String>();
	List<String> lstPackageDelete = new ArrayList<String>();
	List<String> lstPackageAdd = new ArrayList<String>();

	Multimap<String, Dependency> multimapDependencyMove = ArrayListMultimap.create();
	Multimap<String, Dependency> multimapDependencyDelete = ArrayListMultimap.create();
	Multimap<String, Dependency> multimapDependencyAdd= ArrayListMultimap.create();

	Map<String, String> mappingMap = new HashedMap<String, String>();
	LinkedListMultimap<String,String> dependenciesList;
	LinkedListMultimap<String,String>  packagedList;
	private static final String END_NODE = "End Node";

	public void checkDifferences(IFile current, IFile planned) {

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();

		resourceSet1.getResource(URI.createURI(current.getFullPath().toString()), true);
		resourceSet2.getResource(URI.createURI(planned.getFullPath().toString()), true);

		IEqualityHelperFactory helperFactory = new DefaultEqualityHelperFactory() {
			@Override
			public org.eclipse.emf.compare.utils.IEqualityHelper createEqualityHelper() {

				final LoadingCache<EObject, URI> cache = EqualityHelper.createDefaultCache(getCacheBuilder());
				return new EqualityHelper(cache) {
					@Override
					public boolean matchingValues(Object object1, Object object2) {

						if (object1 instanceof Package && object2 instanceof Package) {
							Package package1 = (Package) object1;
							Package package2 = (Package) object2;
							if (package1.getName().equals(package2.getName()))
								return true;
							else 
								return false;
						}
						return super.matchingValues(object1, object2);
					}
				};
			}
		};

		// Configure EMF Compare
		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(helperFactory);
		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);

		// Compare the two models
		IComparisonScope scope = new DefaultComparisonScope(resourceSet1, resourceSet2, null);
		Comparison comparison = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build().compare(scope);

		EList<Diff> differences = comparison.getDifferences();



		for (Diff difference : differences)
		{
			if (difference instanceof ReferenceChange)
			{
				ReferenceChange referenceChange = (ReferenceChange) difference;

				if (referenceChange.getReference() instanceof EReference) 
				{
					EReference reference = referenceChange.getReference();
					if (!reference.getName().equals("client") && !reference.getName().equals("supplier")) {

						if (referenceChange.getValue() instanceof Package)
						{	
							Package package1 = (Package) referenceChange.getValue() ;
							if (referenceChange.getKind().toString().equals("DELETE")) {

								System.out.println("The package: "+package1.getName() + " does not exist!.");
								lstPackageDelete.add(package1.getName());

							}
							else {

								if (referenceChange.getKind().toString().equals("ADD")) {

									System.out.println("The package: "+package1.getName() + " does not exist!.");
									lstPackageAdd.add(package1.getName());

								}
								else {

									if (referenceChange.getKind().toString().equals("MOVE")) {

										System.out.println("The package: "+package1.getName() + " exist!.");
										lstPackageMove.add(package1.getName());
									}
								}
							}
						}

						if (referenceChange.getValue() instanceof Dependency)
						{
							Dependency dependency = (Dependency) referenceChange.getValue() ;
							System.out.println("The relation: "+dependency.getClients().get(0).getName()  + " -> "+dependency.getSuppliers().get(0).getName() + " does not exist!.");
							if (referenceChange.getKind().toString().equals("DELETE")) 
								multimapDependencyDelete.put(dependency.getClients().get(0).getName(), dependency);

							else {

								if (referenceChange.getKind().toString().equals("ADD")) 
									multimapDependencyAdd.put(dependency.getClients().get(0).getName(), dependency);
								else {

									if (referenceChange.getKind().toString().equals("MOVE")) 
										multimapDependencyMove.put(dependency.getClients().get(0).getName(), dependency);
								}
							}
						}
					}
				}
			}
		}
	}

	public void compute(IFile current, IFile planned, String txtDifferences, String mappingPath, Resource r, String title) {

		this.checkDifferences(current, planned);
		DeploymentView view =  this.createPlantComponentDiagram(r,mappingPath,title);


	}

	private void loadMappings(String mappingPath) {

		Path path = Paths.get(mappingPath);
		try{
			List<String> contents = Files.readAllLines(path);
			for(String content:contents) 
				mappingMap.put(content.split(Pattern.quote(","))[0],content.split(Pattern.quote(","))[1]);

		}catch(IOException ex){
			ex.printStackTrace();//handle exception here
		}
	}


	public DeploymentView createPlantComponentDiagram(Resource r, String mappingPath, String title) {

		Workspace workspace = new Workspace("Deployment Diagram", title);
		Model model = workspace.getModel();
		ViewSet views = workspace.getViews();
		SoftwareSystem adaptiveSystem = model.addSoftwareSystem(Location.Internal, "Adaptive System Architecture", "Allows customers to view information about their bank accounts, and make payments.");

		List<Package> memory1 = new ArrayList<Package>();
		List<String> roots = new ArrayList<String>();

		for (int z=0; z<r.getContents().get(0).eContents().size(); z++ )
		{
			if (r.getContents().get(0).eContents().get(z) instanceof Package)
			{
				Package package1 = (Package)r.getContents().get(0).eContents().get(z);
				memory1.add(package1);
				roots.add(package1.getName());
			}
		}
		dependenciesList =  LinkedListMultimap.create();  
		packagedList = LinkedListMultimap.create();

		while (!memory1.isEmpty())
		{
			Package node = memory1.remove(0);
			EList<Package> children = node.getNestedPackages();
			ECollections.reverse(children);
			if (!children.isEmpty()){

				for (int i =0; i< children.size(); i++){
					packagedList.put(node.getName(), children.get(i).getName());
					memory1.add(0, children.get(i));
				}
			}

			EList<Dependency> deps = node.getClientDependencies();
			if (!deps.isEmpty()){
				for (int i=0 ; i< deps.size(); i++)	{

					Dependency dependency = deps.get(i);
					EList<NamedElement> suppliers = dependency.getSuppliers();
					for (int j=0; j< suppliers.size(); j++)
					{
						NamedElement element = dependency.getSuppliers().get(j);
						dependenciesList.put(node.getName(), element.getName());
					}
				}
			}
		}

		this.loadMappings(mappingPath);
		DeploymentNode parent = null;
		for (String key : packagedList.keySet()) {

			DeploymentNode node = null;
			//Check if it is a root node
			if (roots.contains(key))
			{
				node = model.addDeploymentNode(key, key, key, mappingMap.get(key));
				roots.remove(key);
			}
			else 
			{
				//We have to obtain the parent of the node
				if (parent.getDeploymentNodeWithName(key) != null)			
					node = parent.getDeploymentNodeWithName(key);
			}

			List<String> children = new ArrayList<String>(packagedList.get(key));
			for (String child : children) {

				if (this.hasChildren(child))
					node.addDeploymentNode(child, child,  mappingMap.get(child));
				else 
				{
					DeploymentNode nNode = node.addDeploymentNode(child, child,  mappingMap.get(child));
					nNode.addTags(END_NODE);
					Container container = adaptiveSystem.addContainer("c"+child, "c"+child, "");
					nNode.add(container);
				}
			}
			parent = node;
		}
		//Root nodes without children
		for (int i = 0; i< roots.size(); i++)
		{
			DeploymentNode node= model.addDeploymentNode(roots.get(i), roots.get(i), roots.get(i), mappingMap.get(roots.get(i)));
			Container container = adaptiveSystem.addContainer("NULL_"+i, "NULL", "NULL"); 
			node.add(container);
		}

		List<Relationship> lRelationships = new ArrayList<Relationship>();

		for (Element element : model.getElements())
		{
			if (element instanceof DeploymentNode || element instanceof Container )
			{
				List<String> dependencies = dependenciesList.get(element.getName());
				for (String dependency : dependencies)
				{
					Optional<Element> oElement = model.getElements().stream().filter(e -> (e instanceof DeploymentNode || e instanceof Container) && (e.getName().equals(dependency))).findFirst();;
					Element e = oElement.get();
					if (e instanceof DeploymentNode && element instanceof DeploymentNode)
					{
						DeploymentNode d1 = (DeploymentNode) element;
						DeploymentNode d2 = (DeploymentNode) e;
						Relationship relationship = d1.uses(d2, "must-use","");
						lRelationships.add(relationship);
					}
				}
			}
		}

		DeploymentView developmentView = views.createDeploymentView(adaptiveSystem, "LiveDeployment", title);
		developmentView.setEnvironment("");
		for (DeploymentNode node : model.getDeploymentNodes())	
			developmentView.add(node);

		for (Relationship relation : lRelationships)	
			developmentView.add(relation);

		return developmentView;
	}

	private boolean hasChildren(String parent) {

		if (packagedList.get(parent).isEmpty())
			return false;
		else 
			return true;
	}


}
