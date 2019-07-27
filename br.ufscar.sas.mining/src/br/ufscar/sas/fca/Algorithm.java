package br.ufscar.sas.fca;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.basex.core.BaseXException;
import org.basex.query.QueryException;

import br.ufscar.xquery.Manager;

public class Algorithm 
{
	String kdmFilefolder = "";
	String projectName = "";
	String kdmFile = "";

	public Algorithm(String kdmFilefolder, String projectName, String kdmFile)
	{
		this.kdmFilefolder = kdmFilefolder;
		this.kdmFile = kdmFile;
		this.projectName = projectName;
	}

	public List<String>  getFanIn() 
	{
		List<String> nodes = null;
		try {
			nodes = this.getCalls();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (QueryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return nodes;
	}

	public List<Object>  getArchitecture() 
	{
		List<Object> container = new ArrayList<Object>();

		Map<String,List<String>> abstractions = null;
		try {
			abstractions = this.getAbstractions();
			List<String> relations = this.getRelations();
			List<String> relationWithNames = this.getNamesOfRelations(relations);
			container.add(abstractions);
			container.add(relationWithNames);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (QueryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return container;
	}

	private List<String> getCalls() throws SQLException, QueryException, IOException
	{
		Manager manager = new Manager(kdmFilefolder,kdmFile,kdmFile);
		manager.openDB();
		List<String> nodes = manager.getArtifactName(manager.getCallsFromTo());
		manager.closeDB();
		manager.dropDB();
		return nodes;
	}

	private Map<String, List<String>> getAbstractions()  throws SQLException, QueryException, IOException {

		Map<String,List<String>> map = new HashMap<String,List<String>>();
		List<String> memoryName = new ArrayList<String>();
		List<String> memoryPath = new ArrayList<String>();
		List<String> root = new ArrayList<String>();
		String structurePath = "/structureElement";
		String endQuery = "/@name return data($a)";

		try 
		{
			Manager baseXManager = new Manager(kdmFilefolder,kdmFile,kdmFile);
			baseXManager.openDB();

			List<String> paths = baseXManager.getPathsofStructure();
			memoryPath.addAll(paths);
			for (String path:paths)
			{
				List<String> name = baseXManager.getStructureElementName(" let $a:=" + path + endQuery);
				memoryName.addAll(name);
				root.addAll(name);
				map.put(name.get(0),new ArrayList<String>());
			}			
			
			while (!memoryName.isEmpty()) {

				String parent = memoryName.remove(0);
				String parentPath = memoryPath.remove(0);
				List<String> children = baseXManager.getStructureElementName(" let $a:=" + parentPath + structurePath + endQuery);
				Collections.reverse(children);
				if (!children.isEmpty()) {

					List<String> container = map.get(parent);
					for (int i=0;i < children.size(); i++)
					{
						container.add(children.get(i));
						memoryName.add(0,children.get(i));
						memoryPath.add(0,parentPath + structurePath + "[" + (children.size() -i) + "]");
						//To each child add a new empty array of children.
						map.put(children.get(i), new ArrayList<String>());
					}
					//The parent has a new non empty array of children
					map.replace(parent, container);
				}
				else
				{
					map.put(parent, new ArrayList<String>());
				}
			}
			
			map.put("root", root);
			baseXManager.closeDB();

		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}

	private List<String> getRelations() throws SQLException, QueryException
	{
		List<String> relations = null;
		try 
		{
			Manager baseXManager = new Manager(kdmFilefolder,kdmFile,kdmFile);
			baseXManager.openDB();
			relations = baseXManager.getRelations();

			baseXManager.closeDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return relations;
	}

	private List<String> getNamesOfRelations(List<String> relations) throws BaseXException, SQLException, QueryException
	{
		Manager manager = new Manager(kdmFilefolder,kdmFile,kdmFile);
		List<String> relationWithNames = new ArrayList<String>();
		manager.openDB();
		for (String relation: relations)
		{
			String line[] = relation.split(Pattern.quote("-"));
			String predicate = "for $a in " + line[0] + "/data(@name) return $a";
			String from = manager.getFromToRelation(predicate);
			predicate = "for $a in " + line[1] + "/data(@name) return $a";
			String to  = manager.getFromToRelation(predicate);
			String typeRelation[] = line[2].split(Pattern.quote(" "));

			String nameRelation = "";
			for (int i=0; i< typeRelation.length; i++ )
			{
				predicate = "for $a in " + typeRelation[i] + "/data(@xsi:type) return tokenize($a,':')[2]";
				nameRelation = nameRelation + " " + manager.getFromToRelation(predicate);
			}
			nameRelation = nameRelation.trim();
			String result = from + "-" + to + "-" + nameRelation; 
			relationWithNames.add(result);
		}
		manager.closeDB();
		return relationWithNames;
	}
}

