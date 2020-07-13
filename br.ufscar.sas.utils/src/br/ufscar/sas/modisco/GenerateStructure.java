package br.ufscar.sas.modisco;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.basex.core.BaseXException;
import org.basex.query.QueryException;

import br.ufscar.sas.database.QueryClass;
import br.ufscar.sas.structuretree.Tree;


public class GenerateStructure {

	private Tree tree = null;

	public GenerateStructure() {

		tree = new Tree();
	}

	public void createTree(String path_) throws Exception
	{
		QueryClass queryClass = new QueryClass(path_);
		List<String> annotation = new ArrayList<String>();
		List<String> belong = new ArrayList<String>();
		List<String> db = queryClass.selectAnnotationBelong();
		List<String> roots = new ArrayList<String>();
		for (String str: db)
		{
			String child = str.split(Pattern.quote("|"))[0];
			String parent = str.split(Pattern.quote("|"))[1];

			annotation.add(child);
			belong.add(parent);

			if (parent.equals("None"))
				roots.add(child);
		}
		tree.addNode("roots", roots);

		for (int i=0; i<annotation.size(); i++) 
		{
			List<String> children = new ArrayList<String>();
			for (int j=0; j<belong.size(); j++) 
				if (annotation.get(i).equals(belong.get(j)))
					children.add(annotation.get(j));
			Set<String> childrenNonDuplicate = new LinkedHashSet<>(children);
			children.clear();
			children.addAll(childrenNonDuplicate);
			tree.addNode(annotation.get(i), children);
		}

	}

	public void createStructureElementFromTree(Manager baseXManager, String path_) throws BaseXException, QueryException, SQLException
	{
		List<String> memory1 = new ArrayList<String>();
		List<String> memory2 = new ArrayList<String>();
		List<String> rootList = tree.getChildren("roots"); 
		memory1.addAll(rootList);
		memory2.addAll(rootList);
		while (!memory1.isEmpty())
		{
			String child = memory1.get(0);
			rootList = tree.getChildren(child);
			Set<String> set = new HashSet<>(rootList);
			rootList.clear();
			rootList.addAll(set);
			if (!rootList.isEmpty())
			{
				for (int i = rootList.size()-1; i >= 0; i--)
				{
					if (i == rootList.size()-1 )
					{
						String parent = memory1.remove(0);
						if (memory2.contains(new String(parent)))
						{
							memory2.remove(new String(parent));
							this.createStructureElement(baseXManager, null, parent, path_);
						}
						memory1.add(0,rootList.get(i));
					}
					else
						memory1.add(0,rootList.get(i));
					this.createStructureElement(baseXManager, child, memory1.get(0),path_);
				}
			}
			else
				memory1.remove(0);

		}
		for (String memory: memory2)
			this.createStructureElement(baseXManager, null, memory, path_);
	}

	public void annotationPackage(File projectDir, String path_) {

		Manager baseXManager=null;

		try {
			baseXManager = new Manager(projectDir.getPath() + "/", projectDir.getName() +"_KDM" + ".xmi", projectDir.getName() + "_KDM");
			baseXManager.openDB();
		} catch (BaseXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		QueryClass queryClass = null;
		try {

			queryClass = new QueryClass(path_);
			List<String> lst = queryClass.getPackageAnnotations();
			String initString = " for $a in path(//kdm:Segment/model[@xsi:type=\"code:CodeModel\" and @name != \"externals\"]";

			for (String data: lst)
			{
				String projectName = data.split(Pattern.quote("|"))[0];
				String packageName = data.split(Pattern.quote("|"))[1];
				String annotation = data.split(Pattern.quote("|"))[3];
				String packagePath = "//codeElement[@xsi:type='code:Package' and @name='" + 
						packageName.split("\\.")[packageName.split("\\.").length-1] + "'])" + " return data($a)";
				String query = initString + packagePath;

				if (!annotation.equals("None"))
				{
					try {this.addImplementations(baseXManager, query, annotation);} 
					catch (BaseXException e) {e.printStackTrace();}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			baseXManager.closeDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void annotationClass(File projectDir, String path_) {

		Manager baseXManager=null;

		try {
			baseXManager = new Manager(projectDir.getPath() + "/", projectDir.getName() +"_KDM" + ".xmi", projectDir.getName() + "_KDM");
		} catch (BaseXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			baseXManager.openDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		QueryClass queryClass = null;
		try {

			queryClass = new QueryClass(path_);
			List<String> lst = queryClass.getClassAnnotations();
			String initString = " for $a in path(//kdm:Segment/model[@xsi:type=\"code:CodeModel\" and @name != \"externals\"]";

			for (String data: lst)
			{
				String projectName = data.split(Pattern.quote("|"))[0];
				String className = data.split(Pattern.quote("|"))[2];
				String file = data.split(Pattern.quote("|"))[3];
				String annotation = data.split(Pattern.quote("|"))[4];
				String packages = file.split("\\/src/")[1];
				String packageCode[] = packages.split("\\/");
				String packagePath = "/codeElement[@xsi:type='code:Package' and @name='";
				String code = "";

				if (!annotation.equals("None"))
				{
					//Create packages path	
					for (int i=0; i<packageCode.length-1; i++)
						code = code + packagePath + packageCode[i] + "']";
					code = initString + code + "/codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "'])" + " return data($a)";
					try {this.addImplementations(baseXManager, code, annotation);} 
					catch (BaseXException e) {e.printStackTrace();}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			baseXManager.closeDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void annotationFieldClass(File projectDir, String path_) {

		Manager baseXManager=null;

		try {
			baseXManager = new Manager(projectDir.getPath() + "/", projectDir.getName() +"_KDM" + ".xmi", projectDir.getName() + "_KDM");
		} catch (BaseXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			baseXManager.openDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		QueryClass queryClass = null;
		try {

			queryClass = new QueryClass(path_);
			List<String> lst = queryClass.getFieldClassAnnotations();
			String initString = " for $a in path(//kdm:Segment/model[@xsi:type=\"code:CodeModel\" and @name != \"externals\"]";

			for (String data: lst)
			{
				String projectName = data.split(Pattern.quote("|"))[0];
				String className = data.split(Pattern.quote("|"))[1];
				String fieldName = data.split(Pattern.quote("|"))[2];
				String file = data.split(Pattern.quote("|"))[3];
				String annotation = data.split(Pattern.quote("|"))[4];
				String packages = file.split("\\/src/")[1];
				String packageCode[] = packages.split("\\/");
				String packagePath = "/codeElement[@xsi:type='code:Package' and @name='";
				String code = "";

				if (!annotation.equals("None"))
				{
					//Create packages path	
					for (int i=0; i<packageCode.length-1; i++)
						code = code + packagePath + packageCode[i] + "']";
					code = initString + code + "/codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "']"
							+ "/codeElement[@xsi:type='code:StorableUnit' and @name='" + fieldName + "'])" + " return data($a)";
					try {this.addImplementations(baseXManager, code, annotation);} 
					catch (BaseXException e) {e.printStackTrace();}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			baseXManager.closeDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void annotationMethod(File projectDir, String path_) {

		Manager baseXManager=null;

		try {
			baseXManager = new Manager(projectDir.getPath() + "/", projectDir.getName() +"_KDM" + ".xmi", projectDir.getName() + "_KDM");
		} catch (BaseXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			baseXManager.openDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		QueryClass queryClass = null;
		try {

			queryClass = new QueryClass(path_);
			List<String> lst = queryClass.getMethodAnnotations();
			String initString = " for $a in path(//kdm:Segment/model[@xsi:type=\"code:CodeModel\" and @name != \"externals\"]";

			for (String data: lst)
			{
				String projectName = data.split(Pattern.quote("|"))[0];
				String className = data.split(Pattern.quote("|"))[1];
				String methodName = data.split(Pattern.quote("|"))[2];
				String file = data.split(Pattern.quote("|"))[3];
				String annotation = data.split(Pattern.quote("|"))[4];
				String packages = file.split("\\/src/")[1];
				String packageCode[] = packages.split("\\/");
				String packagePath = "/codeElement[@xsi:type='code:Package' and @name='";
				String code = "";

				if (!annotation.equals("None"))
				{
					//Create packages path	
					for (int i=0; i<packageCode.length-1; i++)
						code = code + packagePath + packageCode[i] + "']";
					code = initString + code + "/codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "']"
							+ "/codeElement[@xsi:type='code:MethodUnit' and @name='" + methodName + "'])" + " return data($a)";
					try {this.addImplementations(baseXManager, code, annotation);} 
					catch (BaseXException e) {e.printStackTrace();}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			baseXManager.closeDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void annotationVariable(File projectDir, String path_) {

		Manager baseXManager=null;

		try {
			baseXManager = new Manager(projectDir.getPath() + "/", projectDir.getName() +"_KDM" + ".xmi", projectDir.getName() + "_KDM");
		} catch (BaseXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			baseXManager.openDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		QueryClass queryClass = null;
		try {

			queryClass = new QueryClass(path_);
			List<String> lst = queryClass.getVariableAnnotations();
			String initString = " for $a in path(//kdm:Segment/model[@xsi:type=\"code:CodeModel\" and @name != \"externals\"]";

			for (String data: lst)
			{
				String projectName = data.split(Pattern.quote("|"))[0];
				String className = data.split(Pattern.quote("|"))[1];
				String methodName = data.split(Pattern.quote("|"))[2];
				String variableName = data.split(Pattern.quote("|"))[3];
				String file = data.split(Pattern.quote("|"))[4];
				String annotation = data.split(Pattern.quote("|"))[5];
				String packages = file.split("\\/src/")[1];
				String packageCode[] = packages.split("\\/");
				String packagePath = "/codeElement[@xsi:type='code:Package' and @name='";
				String code = "";

				if (!annotation.equals("None"))
				{
					//Create packages path	
					for (int i=0; i<packageCode.length-1; i++)
						code = code + packagePath + packageCode[i] + "']";
					code = initString + code + "/codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "']"
							+ "/codeElement[@xsi:type='code:MethodUnit' and @name='" + methodName + "']"
							+ "//codeElement[@xsi:type='code:StorableUnit' and @name='" + variableName +"'])" + " return data($a)";
					try {this.addImplementations(baseXManager, code, annotation);} 
					catch (BaseXException e) {e.printStackTrace();}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			baseXManager.closeDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createModel(File path, String file, String dbName, String path_)
	{
		Manager baseXManager=null;

		try {
			baseXManager = new Manager(path.getPath()+ "/", file, dbName);
		} catch (BaseXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			baseXManager.openDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			baseXManager.createModel();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String attr = "xsi:type";
			String value = "structure:StructureModel";
			baseXManager.createModelAttr(attr, value);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String attr = "name";
			String value = "ArchitecturalView_" + file.split("\\_")[0];
			baseXManager.createModelAttr(attr, value);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			baseXManager.exportDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Creates archtype of model
		try 
		{
			this.createTree(path_);
			this.createStructureElementFromTree(baseXManager, path_);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		try {
			baseXManager.closeDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createStructureElement(Manager baseXManager, String parent, String componentName, String path_) throws QueryException, SQLException, BaseXException {

		boolean check = baseXManager.checkComponentExist(componentName);
		if (!check)
		{
			//Root Parent
			if (parent == null)
			{
				//Create Structure element with name
				baseXManager.createStructureElement(componentName, "parent");
				//Export DB
				baseXManager.exportDB();
			}
			else
			{
				//Create Structure element with name for children
				baseXManager.createStructureElement(componentName, parent);
				//Export DB
				baseXManager.exportDB();
			}
		}
	}

	public void addImplementations(Manager baseXManager, String code, String componentName) throws QueryException, SQLException, BaseXException {

		boolean check = baseXManager.checkComponentExist(componentName);
		if (check)
		{
			//Update implementations
			String implementation = baseXManager.getComponentImplementations(componentName);
			String pathElement = baseXManager.createModiscoPathDynamically(code,"query-3");
			pathElement = pathElement.replaceFirst("/0/", "//");
			implementation = implementation + " " + pathElement;
			implementation = implementation.trim();
			baseXManager.updateStructureElementAttr(implementation, componentName);
			//Export DB
			baseXManager.exportDB();
		}
	}

	public void discoverRelationShip(File projectDir, String path_) throws Exception  
	{
		Manager baseXManager=null;
		List<String> relations = new ArrayList<String>();

		try {
			baseXManager = new Manager(projectDir.getPath() + "/", projectDir.getName() +"_KDM" + ".xmi", projectDir.getName() + "_KDM");

		} catch (BaseXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		QueryClass queryClass = new QueryClass(path_);
		queryClass.deleteRelation();
		String rtn = "";
		List<String> relation = new ArrayList<String>();
		try {baseXManager.openDB();} catch (BaseXException e1) {e1.printStackTrace();}
		rtn = baseXManager.getActionRelation("action:Calls");
		if (!rtn.equals(""))
			relation.add(rtn);

		rtn = baseXManager.getActionRelation("action:UsesType");
		if (!rtn.equals(""))
			relation.add(rtn);

		rtn = baseXManager.getActionRelation("action:Creates");
		if (!rtn.equals(""))
			relation.add(rtn);
		
		rtn = baseXManager.getActionRelation("action:ExceptionFlow");
		if (!rtn.equals(""))
			relation.add(rtn);
		
		rtn = baseXManager.getActionRelation("action:Throws");
		if (!rtn.equals(""))
			relation.add(rtn);
		
		rtn = baseXManager.getActionRelation("action:Addresses");
		if (!rtn.equals(""))
			relation.add(rtn);
		
		rtn = baseXManager.getActionRelation("action:Writes");
		if (!rtn.equals(""))
			relation.add(rtn);
		
		rtn = baseXManager.getActionRelation("action:Reads");
		if (!rtn.equals(""))
			relation.add(rtn);

		rtn = baseXManager.getCodeRelation("code:Extends");
		if (!rtn.equals(""))
			relation.add(rtn);

		rtn = baseXManager.getCodeRelation("code:Implements");
		if (!rtn.equals(""))
			relation.add(rtn);

		rtn = baseXManager.getCodeRelation("code:HasValue");
		if (!rtn.equals(""))
			relation.add(rtn);

		rtn = baseXManager.getCodeRelation("code:Imports");
		if (!rtn.equals(""))
			relation.add(rtn);

		rtn = baseXManager.getCodeRelation("code:HasType");
		if (!rtn.equals(""))
			relation.add(rtn);

		List<String> nodes = new ArrayList<String>();

		if (!relation.isEmpty())
			nodes.addAll(baseXManager.getArtifactName(relation));

		if (!nodes.isEmpty())
		{
			for (String path: nodes)
			{
				
				String from = path.split(Pattern.quote("|"))[0];
				String to = path.split(Pattern.quote("|"))[1];
				String action = path.split(Pattern.quote("|"))[2];
				String type = path.split(Pattern.quote("|"))[3];

				String package_from = this.checkPathType(baseXManager,from, "package");
				String class_from = this.checkPathType(baseXManager,from, "class");
				String field_from= this.checkPathType(baseXManager,from, "field");
				String method_from= this.checkPathType(baseXManager,from, "method");
				String variable_from= this.checkPathType(baseXManager,from, "variable");

				String package_to = this.checkPathType(baseXManager,to, "package");
				String class_to = this.checkPathType(baseXManager,to, "class");
				String field_to= this.checkPathType(baseXManager,to, "field");
				String method_to= this.checkPathType(baseXManager,to, "method");
				String variable_to= this.checkPathType(baseXManager,to, "variable");

				String rel = package_from + "|" + class_from + "|" + field_from  + "|" + method_from  + "|" + variable_from  + "|" 
						+ package_to  + "|" + class_to  + "|" + field_to  + "|" + method_to  + "|" + variable_to + "|" +action  + "|" + type;

				relations.add(rel);
			}
			queryClass.insertRelations(relations);
			relations.clear();
		}
		
		List<String> annotations = queryClass.getSummaryAnnotation();
		for (String annotation : annotations) {
			
			String element = annotation.split(Pattern.quote("|"))[0];
			String abstraction = annotation.split(Pattern.quote("|"))[1];
			
			String package_ = this.checkPathType(baseXManager,element, "package");
			String class_ = this.checkPathType(baseXManager,element, "class");
			String field_= this.checkPathType(baseXManager,element, "field");
			String method_= this.checkPathType(baseXManager,element, "method");
			String variable_= this.checkPathType(baseXManager,element, "variable");
			
			String rel = package_ + "|" + class_ + "|" + field_  + "|" + method_  + "|" + variable_  + "|" 	+ abstraction;
			relations.add(rel);
		}
		
		queryClass.insertSummaryAnnotation(relations);
		relations.clear();
		
		try {baseXManager.closeDB();} catch (BaseXException e) {e.printStackTrace();}
	}

	public String checkPathType(Manager baseXManager, String path, String type) throws Exception {

		String preamble =  "declare namespace xmi='http://www.omg.org/XMI'; \n" +
							"declare namespace xsi='http://www.w3.org/2001/XMLSchema-instance'; \n" +
							"declare namespace action='http://www.eclipse.org/MoDisco/kdm/action'; \n" +
							"declare namespace code='http://www.eclipse.org/MoDisco/kdm/code'; \n" +
							"declare namespace kdm='http://www.eclipse.org/MoDisco/kdm/kdm'; \n" +
							"declare namespace source='http://www.eclipse.org/MoDisco/kdm/source'; \n\n";
	
		String rtn="";
		String newStr = "";
		String lstString[] = path.split(Pattern.quote("."));
		if (type.equals("package"))
		{
			String query = "let $a:= //kdm:Segment/model[@xsi:type='code:CodeModel' ]";
			for (String str: lstString)
			{
				query = query + "/codeElement[@name = '" + str + "']";
				rtn = baseXManager.rtnType(preamble + query + " return $a/data(@xsi:type)");
				if (rtn.equals("code:Package")) {
					newStr = newStr + "." + str;
				}
				else
				{
					if (newStr.length()>0)
						newStr = newStr.substring(1);
					break;
				}
			}
			if (newStr.startsWith("."))
				newStr = newStr.substring(1);
			
			return newStr;
		}
		else 
		{
			if (type.equals("class"))
			{
				String query = "let $a:= //kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']";
				for (String str: lstString)
				{
					query = query + "/codeElement[@name = '" + str + "']";
					rtn = baseXManager.rtnType(preamble + query + " return $a/data(@xsi:type)");
					if (rtn.equals("code:Package")) {

					}
					else
						if (rtn.equals("code:ClassUnit"))
							newStr = str;
						else
							break;
				}

				return newStr;
			}
			else 
			{
				if (type.equals("field"))
				{
					String old = "";
					String query = "let $a:= //kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']";
					for (String str: lstString)
					{	
						query = query + "/codeElement[@name = '" + str + "']";
						rtn = baseXManager.rtnType(preamble + query + " return $a/data(@xsi:type)");
						if (rtn.equals("code:Package")) {

						}
						else
						{
							if (rtn.equals("code:ClassUnit"))
								old = "class";
							else
							{
								if (rtn.equals("code:StorableUnit") && old.equals("class"))
									newStr = str;
								else
									break;
							}
						}
					}

					return newStr;
				}
				else 
				{
					if (type.equals("method"))
					{
						String query = "let $a:= //kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']";
						for (String str: lstString)
						{
							query = query + "/codeElement[@name = '" + str + "']";
							rtn = baseXManager.rtnType(preamble + query + " return $a/data(@xsi:type)");
							if (rtn.equals("code:Package")) {

							}
							else
							{
								if (rtn.equals("code:ClassUnit")) {

								}
								else
								{
									if (rtn.equals("code:MethodUnit"))
										newStr = str;
									else
										break;
								}
							}
						}
						return newStr;
					}
					else 
					{
						if (type.equals("variable"))
						{
							String old = "";
							String query = "let $a:= //kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']";
							for (int i=0; i< lstString.length ; i++)
							{
								String str = lstString[i];
								if (i+1 == lstString.length)
									query = query + "//codeElement[@name = '" + str + "']";
								else
									query = query + "/codeElement[@name = '" + str + "']";
								rtn = baseXManager.rtnType(preamble + query + " return $a/data(@xsi:type)");
								if (rtn.equals("code:Package")) {
								}
								else
								{
									if (rtn.equals("code:ClassUnit")) {
									}
									else {
										if (rtn.equals("code:MethodUnit"))
											old = "method";
										else
											if (rtn.equals("code:StorableUnit") && old.equals("method"))
												newStr = str;
											else
												break;
									}
								}
							}
							return newStr;
						}
					}
				}
			}
		}
		return null;
	}

	public void addAggregatedRelationShip(File projectDir, String path_) throws Exception {

		Manager baseXManager=null;

		try {
			baseXManager = new Manager(projectDir.getPath() + "/", projectDir.getName() +"_KDM" + ".xmi", projectDir.getName() + "_KDM");

		} catch (BaseXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		QueryClass queryClass = new QueryClass(path_);
		List<String> lstActionRelation = queryClass.getActionRelationClass();
		lstActionRelation.addAll(queryClass.getActionRelationMethod());
		if (lstActionRelation.size() != 0)
		{

			//If it exists then update relation and density else
			//create an aggregated relationship with attributes
			//Create or update outAggregated and inAggregated

			for (String line: lstActionRelation)
			{
				String fromAbstraction = line.split(Pattern.quote("|"))[0];
				String fromImplement = line.split(Pattern.quote("|"))[1];
				String toAbstraction = line.split(Pattern.quote("|"))[2];
				String toImplement = line.split(Pattern.quote("|"))[3];
				String modiscoPathRelation = line.split(Pattern.quote("|"))[4];
				String outAggregated = "";
				String inAggregated = "";

				//Find Paths of architecture elements (from, to)
				String modiscoPathFrom = baseXManager.getPathofAbstraction(fromAbstraction);
				String modiscoPathTo = baseXManager.getPathofAbstraction(toAbstraction);

				boolean check = baseXManager.checkAggragationExist(fromAbstraction, modiscoPathFrom, modiscoPathTo);
				if (!check)
				{
					//insert an aggregated relationship.
					baseXManager.createAggregatedElement(fromAbstraction, modiscoPathFrom, modiscoPathTo, modiscoPathRelation);

					//create outAggregated
					String pathAggregated = baseXManager.getPathOfAggregated(fromAbstraction, modiscoPathFrom, modiscoPathTo);
					outAggregated = baseXManager.getOutAggregated(fromAbstraction);

					if (!outAggregated.contains(pathAggregated))
						outAggregated = outAggregated + " " + pathAggregated; 

					outAggregated = outAggregated.trim();
					baseXManager.updateOutAggregated(fromAbstraction, outAggregated);
					outAggregated = "";

					//create inAggregated
					inAggregated = baseXManager.getInAggregated(toAbstraction);
					inAggregated = inAggregated.trim();

					if (!inAggregated.contains(pathAggregated))
						inAggregated = inAggregated + " " + pathAggregated; 

					inAggregated = inAggregated.trim();
					baseXManager.updateInAggregated(toAbstraction, inAggregated);
					inAggregated = "";
				}
				else
				{
					//If it exists then update relation and density
					//Create a function to catch relation and density. Concatenate relations and sum 1 to density
					String relationAndDensity = baseXManager.getAggregatedData(fromAbstraction, modiscoPathFrom, modiscoPathTo);
					String relation = relationAndDensity.split(Pattern.quote("-"))[0];
					String density = String.valueOf(Integer.parseInt(relationAndDensity.split(Pattern.quote("-"))[1]) + 1);
					relation = relation + " " + modiscoPathRelation;
					baseXManager.updateAggregatedRelationAndDensity(fromAbstraction, modiscoPathFrom, modiscoPathTo, relation, density);
				}

				//Export DB
				baseXManager.exportDB();
			}
		}

		try {baseXManager.closeDB();} catch (BaseXException e) {e.printStackTrace();}
	}
}
