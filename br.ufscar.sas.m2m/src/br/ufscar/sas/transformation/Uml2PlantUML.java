package br.ufscar.sas.transformation;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import org.apache.commons.collections4.map.HashedMap;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

import com.google.common.collect.LinkedListMultimap;
import com.structurizr.Workspace;
import com.structurizr.io.plantuml.PlantUMLWriter;
import com.structurizr.model.Container;
import com.structurizr.model.DeploymentNode;
import com.structurizr.model.Element;
import com.structurizr.model.Location;
import com.structurizr.model.Model;
import com.structurizr.model.Relationship;
import com.structurizr.model.SoftwareSystem;
import com.structurizr.view.DeploymentView;
import com.structurizr.view.ViewSet;

public class Uml2PlantUML {

	LinkedListMultimap<String,String> dependenciesList;
	LinkedListMultimap<String,String>  packagedList;
	Map<String, String> mappingMap = new HashedMap<String, String>();
	private static final String END_NODE = "End Node";
	
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

	public void createPlantComponentDiagram(Resource r, String path, String projectName, String mappingPath, String title) {

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
				memory1.add((Package)r.getContents().get(0).eContents().get(z));
				roots.add(((Package) r.getContents().get(0).eContents().get(z)).getName());
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
				node = model.addDeploymentNode(key, key, key, mappingMap.get(key));
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

		StringWriter stringWriter = new StringWriter();
		PlantUMLWriter plantUMLWriter = new PlantUMLWriter();
		plantUMLWriter.write(workspace, stringWriter);

		String diagram = stringWriter.toString();
		diagram = diagram.replaceAll("(?m)rectangle.*", "");
		diagram = diagram.replaceAll("(?m)@enduml.*", "");
		
		String style = "skinparam node {\n" + 
						"\n" + 
					   "	backgroundColor<<Reference Input>> #3498db\n" + 
					   "	backgroundColor<<Measured Output>> #3498db\n" + 
					   "	backgroundColor<<Executor>> #3498db\n" + 
					   "	backgroundColor<<Sensor>> #3498db\n" + 
					   "	backgroundColor<<Monitor>> #3498db\n" + 
					   "	backgroundColor<<Analyzer>> #3498db\n" + 
					   "	backgroundColor<<Planner>> #3498db\n" + 
					   "	backgroundColor<<Effector>> #3498db\n" + 
					   "	FontColor<<Reference Input>> white\n" + 
					   "	FontColor<<Measured Output>> white\n" + 
					   "	FontColor<<Executor>> white\n" + 
					   "	FontColor<<Sensor>> white\n" + 
					   "	FontColor<<Monitor>> white\n" + 
					   "	FontColor<<Analyzer>> white\n" + 
					   "	FontColor<<Planner>> white\n" + 
					   "	FontColor<<Effector>> white\n" + 
					   "}\n" +
					   "@enduml";
		
		diagram = diagram + style;
		
		try {
			Files.write(Paths.get(path + "ComponentDiagram.txt"), diagram.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING );
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private boolean hasChildren(String parent) {

		if (packagedList.get(parent).isEmpty())
			return false;
		else 
			return true;
	}
}
