package br.ufscar.sas.transformation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

public class Uml2PlantUML {

	public void createPlantComponentDiagram(Resource r, String path, String projectName)  {


		List<Package> memory1 = new ArrayList<Package>();
		List<String> roots = new ArrayList<String>();

		for (int z=1; z<r.getContents().size(); z++ )
		{
			if (r.getContents().get(z) instanceof Package)
			{
				memory1.add((Package)r.getContents().get(z));
				roots.add(((Package) r.getContents().get(z)).getName());
			}
		}
		MultiValuedMap<String,String> dependenciesList =new ArrayListValuedHashMap<String, String>();
		MultiValuedMap<String,String> packagedList =new ArrayListValuedHashMap<String, String>();

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

		List<String> closure = new ArrayList<String>();
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("@startuml").append("\n").append("\n");

		while (!roots.isEmpty()) {

			String root = roots.remove(0);
			Collection<String> lDependencies = dependenciesList.get(root);

			//Check Dependency
			if (!lDependencies.isEmpty())
				for (String str : lDependencies)
					strBuilder.append("[").append(root).append("]").append(" --> ").append("[").append(str).append("]").append("\n");
			else
			{
				//Check if the component is called.
				Collection<Map.Entry<String, String>> entries = dependenciesList.entries();
				List<Map.Entry<String, String>> entry = new ArrayList<Map.Entry<String, String>>(entries);
				for (Map.Entry<String, String> ent : entry) {

					if (ent.getValue().equals(root))
					{
						strBuilder.append("[").append(ent.getKey()).append("]").append(" --> ").append("[").append(ent.getValue()).append("]").append("\n");
						dependenciesList.removeMapping(ent.getKey(), ent.getValue());
					}
				}
			}
			Collection<String> children = packagedList.get(root);
			List<String> lChildren = new ArrayList<String>(children);
			Collections.reverse(lChildren);
			if (!lChildren.isEmpty()){

				strBuilder.append("package " + root + " {" ).append("\n");
				for (int i=0; i< lChildren.size() ; i++){
					roots.add(0,lChildren.get(i));
				}
				closure.add(0,lChildren.get(0));
			}
			else
			{
				strBuilder.append("[").append(root).append("]").append("\n");
				if (!closure.isEmpty())
				{	
					if (root.equals(closure.get(0))){
						closure.remove(0);
						strBuilder.append("}").append("\n");
					}
				}
			}
		}
		strBuilder.append("@enduml");
		
		try {
			Files.write(Paths.get(path + "/CurrentArchitecture/ComponentDiagram.txt"), strBuilder.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
