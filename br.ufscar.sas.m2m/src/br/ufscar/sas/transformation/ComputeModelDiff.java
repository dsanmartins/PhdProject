package br.ufscar.sas.transformation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IFile;
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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;

import com.google.common.cache.LoadingCache;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ComputeModelDiff {

	List<String> lstPackageMove = new ArrayList<String>();
	List<String> lstPackageDelete = new ArrayList<String>();
	List<String> lstPackageAdd = new ArrayList<String>();

	Multimap<String, Dependency> multimapDependencyMove = ArrayListMultimap.create();
	Multimap<String, Dependency> multimapDependencyDelete = ArrayListMultimap.create();
	Multimap<String, Dependency> multimapDependencyAdd= ArrayListMultimap.create();
	List<String> result = null;

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

								if (referenceChange.getMatch().getLeft() instanceof Package && referenceChange.getMatch().getRight() instanceof Package )
								{
									Package package2 = (Package) referenceChange.getMatch().getLeft();
									if (!lstPackageMove.contains(package2.getName()))
										lstPackageMove.add(package2.getName());
								}
								
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

										if (referenceChange.getMatch().getLeft() instanceof Package && referenceChange.getMatch().getRight() instanceof Package )
										{
											Package package2 = (Package) referenceChange.getMatch().getLeft();
											if (!lstPackageMove.contains(package2.getName()))
												lstPackageMove.add(package2.getName());
										}
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

	public void compute(IFile current, IFile planned, String plannedArchitecture, String pathDifference)  {

		this.checkDifferences(current, planned);
		Path path = Paths.get(plannedArchitecture);
		if(Files.exists(path,new LinkOption[]{ LinkOption.NOFOLLOW_LINKS}))
		{
			try (Stream<String> lines = Files.lines(Paths.get(path.toUri()))) {
				result = lines.collect(Collectors.toList());
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			this.checkDependencies();
			this.deleteEqualsAbstractions();
			
			String newString = "";
			for (String line: result)
				newString = newString + line +"\n";
			
		   newString = Pattern.compile("(3498db)").matcher(newString).replaceAll("FF0000");
		   newString = Pattern.compile("(707070)").matcher(newString).replaceAll("FF0000");
		   newString = Pattern.compile("(This is the planned architecture of project)").matcher(newString).replaceAll("Differences between planned and current architectures");
			
			try {
				Files.write(Paths.get(pathDifference + "differences.txt"), newString.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING );
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}


	public void checkDependencies() {

		//Remove from move all component names that must be preserved
		List<Dependency> lstDependenies = new ArrayList<Dependency>(multimapDependencyDelete.values());
		for (Dependency dependency : lstDependenies)
		{
			lstPackageMove.remove(dependency.getClients().get(0).getName());
			lstPackageMove.remove(dependency.getSuppliers().get(0).getName());
		}
	}

	public void deleteEqualsAbstractions() {

		for (String move : lstPackageMove)
		{
			int initPos = this.getLinePosition(move);
			if (initPos != -1) {
				int closePos = this.getClosePosition(initPos);
				result.remove(initPos);
				result.remove(closePos-1);
			}
		}
	}

	public int getLinePosition(String abstraction) {

		int pos = -1;
		for (int i=0; i< result.size(); i++) {
			if (result.get(i).contains(abstraction))
			{
				pos = i;
				break;
			}
		}
		return pos;
	}

	public int getClosePosition(int initPos) {

		int pos = -1;
		int mark = 1;
		for (int i=initPos + 1; i<result.size(); i++)
		{
			String line = result.get(i);
			if (!StringUtils.isBlank((CharSequence) line))
			{
				if (line.contains("{"))
					mark++;
				else 
				{
					if (line.contains("}"))
					{
						mark--;
						if (mark == 0)
						{
							pos = i;
							break;
						}
					}
				}
			}
		}
		return pos;
	}
}
