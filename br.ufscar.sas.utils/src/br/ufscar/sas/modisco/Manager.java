package br.ufscar.sas.modisco;
/*
 *   Copyright 2013 Daniel Gustavo San Martín Santibáñez

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.Close;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.DropDB;
import org.basex.core.cmd.Export;
import org.basex.core.cmd.Open;
import org.basex.query.QueryException;
import org.basex.query.QueryProcessor;
import org.basex.query.iter.Iter;
import org.basex.query.value.item.Item;


public class Manager   {

	Context context; 
	CreateDB createDB;
	String path;
	Open openDb;
	Close closeDb;
	DropDB dropDB;
	Export export;

	/*
	 * Esse método cria um novo banco de dados. Persiste o arquivo XML.
	 */
	public Manager(String path, String file, String dbName) throws BaseXException
	{
		// Create a database from a local or remote XML document or XML String
		context = new Context();
		createDB = new CreateDB(dbName, path + file);
		createDB.execute(context);
		this.path = path + file; 
		openDb = new Open(dbName);
		closeDb = new Close();
		export = new Export(this.path); 
		dropDB = new DropDB(dbName);
	}

	/*
	 * Esse método cria um novo banco de dados. Persiste o arquivo XML.
	 */
	public void createDB(String path, String file, String dbName) throws BaseXException {
		// TODO Auto-generated method stub
		context = new Context();
		createDB = new CreateDB(dbName, path + file);
		createDB.execute(context);
		openDb = new Open(dbName);
	}

	/*
	 * Esse método abre uma nova conexão com o banco de dados.
	 */
	public void openDB() throws BaseXException
	{
		openDb.execute(context);
	}

	/*
	 * Esse método encerra uma conexão com o banco de dados.
	 */
	public void closeDB() throws BaseXException
	{
		closeDb.execute(context);
	}

	/*
	 * Esse método exporta um banco de dados.
	 */
	public void exportDB() throws BaseXException
	{
		export.execute(context);
	}

	/*
	 * Esse método apaga um banco de dados.
	 */
	public void dropDB() throws BaseXException
	{
		dropDB.execute(context);
	}

	public String createModiscoPathDynamically(String code, String type) throws QueryException, SQLException{

		String query = PropertyFileManager.getQuery(type);
		query = query + code;
		QueryProcessor proc = new QueryProcessor(query, context);
		Iter iter = proc.iter();
		String str = "";
		for(Item item; (item = iter.next()) != null;)
			str = item.toJava().toString();
		proc.close();
		if (str.length() !=0)
		{
			str=str.replaceAll("Q\\{}", "").split("Segment")[1].substring(4).replaceAll("\\[", ".").replaceAll("\\]", "");
			String newStr[] = str.split("\\/");
			String finalString = "/0/";
			for (String character: newStr)
			{ 
				String name = character.split("\\.")[0];
				String number = String.valueOf(Integer.valueOf(character.split("\\.")[1])-1);
				finalString = finalString + "@" + name + "." + number + "/";
			}
			finalString = finalString.substring(0,finalString.length()-1);
			return finalString;
		}
		else
			return null;
	}

	public String createModiscoPath(String codeElement, String type) throws QueryException, SQLException{

		String query = PropertyFileManager.getQuery(type);
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("name1", codeElement);
		Iter iter = proc.iter();
		String str = "";
		for(Item item; (item = iter.next()) != null;)
			str = item.toJava().toString();
		proc.close();
		if (str.length() !=0)
		{
			str=str.replaceAll("Q\\{}", "").split("Segment")[1].substring(4).replaceAll("\\[", ".").replaceAll("\\]", "");
			String newStr[] = str.split("\\/");
			String finalString = "/0/";
			for (String character: newStr)
			{ 
				String name = character.split("\\.")[0];
				String number = String.valueOf(Integer.valueOf(character.split("\\.")[1])-1);
				finalString = finalString + "@" + name + "." + number + "/";
			}
			finalString = finalString.substring(0,finalString.length()-1);
			return finalString;
		}
		else
			return null;
	}

	public String getMethodName(String propertyName) throws SQLException, QueryException, BaseXException
	{
		String query = PropertyFileManager.getQuery("getMethodName");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("name1", propertyName);
		String value = proc.value().toString().replaceAll("\"", "");
		proc.close();
		return value;
	}

	public ArrayList<String> getPropertyName() throws SQLException, QueryException, BaseXException
	{
		ArrayList<String> arrMethods = new ArrayList<String>();
		String query = PropertyFileManager.getQuery("getPropertyName");
		QueryProcessor proc = new QueryProcessor(query, context);
		Iter iter = proc.iter();
		Item item;
		while ((item = iter.next()) != null) 
		{
			arrMethods.add(item.toJava().toString());
		}
		proc.close();
		return arrMethods;
	}

	public void createNode(String methodName) throws SQLException, QueryException{

		String query = PropertyFileManager.getQuery("insertNodeReturn");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("name1", methodName);
		proc.value();
		proc.close();
	}

	public void createAttributeOfNode(String methodName, String var1, String var2) throws SQLException, QueryException{

		if (var2 != null)
		{
			String query = PropertyFileManager.getQuery("insertAttributesReturn");
			QueryProcessor proc = new QueryProcessor(query, context);
			proc.bind("name1", methodName);
			proc.bind("var1", var1);
			proc.bind("var2", var2);
			proc.value();
			proc.close();
		}
	}

	public boolean checkPropertyBelongToClass(String propertyName) throws SQLException, QueryException{

		String value = "";
		String query = PropertyFileManager.getQuery("checkPropertyBelongToClass");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("name1", propertyName);
		value = proc.value().toString().replaceAll("\"", "");
		proc.close();
		if (value.equals("code:ClassUnit"))
			return true;
		else
			return false;
	}

	public boolean checkActionRelationReturn(String methodName) throws SQLException, QueryException{

		String value = "";
		String query = PropertyFileManager.getQuery("checkActionRelationReturn");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("name1", methodName);
		value = proc.value().toString();
		proc.close();
		if (value.equals("actionRelation"))
			return true;
		else
			return false;
	}

	public void createLine(String predicate) throws SQLException, QueryException {
		String query = PropertyFileManager.getQuery("query-3");
		QueryProcessor proc = new QueryProcessor(query + predicate, context);
		proc.value();
		proc.close();
	}

	/*
	 * Esse método transforma os paths obtidos pela xquery em nomes de pacotes, classes e métodos dinâmicamente.
	 */
	public List<String> getArtifactName(List<String> fromTo) throws SQLException, QueryException, IOException
	{
		List<String> fromToFiltered = null;
		List<String> from = new ArrayList<String>();
		List<String> to = new ArrayList<String>();
		List<String> action = new ArrayList<String>();
		List<String> type = new ArrayList<String>();

		for (int k = 0; k< fromTo.size(); k++)
		{
			String line[] = fromTo.get(k).split(Pattern.quote("-"));
			for (int j =0; j< line.length-1;j++ )
			{
				from.add(line[j].split(Pattern.quote("|"))[1]);
				to.add(line[j].split(Pattern.quote("|"))[0]);
				action.add(this.getModiscoPathActionElement((line[j].split(Pattern.quote("|"))[2])));
				type.add(line[j].split(Pattern.quote("|"))[3]);
			}
		}

		List<String> arrayList1 = this.resolvePathNames(from);
		List<String> arrayList2 = this.resolvePathNames(to);
		List<String> newFromTo= new ArrayList<String>();

		int size = arrayList1.size();
		for (int i = 0; i < size; i++)
			newFromTo.add(arrayList1.get(i) + "|" + arrayList2.get(i) + "|" + action.get(i) + "|"+ type.get(i));

		fromToFiltered = newFromTo.stream().distinct().collect(Collectors.toList());
		return fromToFiltered;
	}

	private String getModiscoPathActionElement(String xqueryPath)
	{
		List<String> lst = new ArrayList<String>();
		String string ="";
		for (int i= 1; i<xqueryPath.split(Pattern.quote(".")).length; i++)
		{			
			String mydata = xqueryPath.split(Pattern.quote("."))[i];
			Pattern pattern = Pattern.compile("^[0-9][^/]*");
			Matcher matcher = pattern.matcher(mydata);
			if (matcher.find())
			{
				int val = Integer.valueOf(matcher.group(0)) -1;
				lst.add(xqueryPath.split(Pattern.quote("."))[i].replaceFirst("^[0-9][^/]*", String.valueOf(val)));
			}
		}

		for(String str:lst)
			string = string + "." + str;
		string = "//@model" + string;
		return string;
	}

	private String convertModiscoPathAbstraction(String path) {

		String newString = "";
		List<String> lst = new ArrayList<String>();
		String line[] = path.split(Pattern.quote("."));
		for (int i = 1; i < line.length; i++)
		{
			Pattern pattern = Pattern.compile("^[0-9][^/]*");
			Matcher matcher = pattern.matcher(line[i]);
			if (matcher.find())
			{
				int val = Integer.valueOf(matcher.group(0)) -1;
				lst.add(line[i].replaceFirst("^[0-9][^/]*", String.valueOf(val)));
			}
		}
		for(String str:lst)
			newString = newString + "." + str;

		newString = line[0] + newString;
		return newString;
	}

	public ArrayList<String> resolvePathNames(List<String> path) throws SQLException, QueryException
	{
		ArrayList<String> arrayList = new ArrayList<String>();	
		String iString = " let $prod := //kdm:Segment/";	
		String mString = " let $rtn1 := $prod[@xsi:type='code:StorableUnit' or @xsi:type='code:MethodUnit' or @xsi:type='code:ClassUnit' or @xsi:type='code:Package']/@name ";
		String nString = " let $rtn2 := $prod/@xsi:type ";
		String fString = " return concat(data($rtn1),'-',data($rtn2)) ";
		String result = "";
		String modelE = "";
		String f1 = "";

		for (int i=0; i<path.size(); i++)
		{
			//Get path for each element of the array
			String line = path.get(i);
			String[] element = line.split(Pattern.quote("/"));
			for (int j=0; j<element.length; j++)
			{ 
				if (j==2)
				{
					String[] modelElement = element[j].split(Pattern.quote("."));
					String mElement = modelElement[0].substring(1);
					int nElement = Integer.parseInt(modelElement[1]) + 1;
					modelE = mElement+"["+nElement+"]/";
				}	 
				if (j>2)
				{
					String[] codeElement = element[j].split(Pattern.quote("."));
					String sElement = codeElement[0].substring(1);
					int nElement = Integer.parseInt(codeElement[1]) + 1;
					String f1Element = sElement+"["+nElement+"]";
					String query = PropertyFileManager.getQuery("query-3");
					query = query + iString + modelE + f1 + f1Element + mString + nString + fString;

					String rtn = this.executeQueryPath(query);
					String name = rtn.split(Pattern.quote("-"))[0];
					String type = rtn.split(Pattern.quote("-"))[1];

					if (!name.equals(""))
						result = result+"."+name;	
					f1 = f1 + f1Element + "/";

					if (type.equals("code:StorableUnit"))
						break;
				}
			}
			arrayList.add(result.substring(1)); 
			result = "";
			f1 = "";
		}
		return arrayList;
	}	

	public String getActionRelation(String action) throws SQLException, QueryException
	{
		String rtn = "";
		String query = PropertyFileManager.getQuery("getActionRelation");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("action", action);
		rtn = proc.value().toString();
		proc.close();
		return rtn;		
	}

	public String executeQueryPath(String query) throws QueryException
	{
		String rtn = "";
		QueryProcessor proc = new QueryProcessor(query, context);
		Iter iter = proc.iter();
		for(Item item; (item = iter.next()) != null;)
			rtn = item.toJava().toString();
		proc.close();
		return rtn;		
	}

	public String getClassAnnotationPath(String className) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("getPathOfClassAnnotation");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("className", className);
		String value = proc.value().toString().replaceAll("\"", "");
		proc.close();
		return value;
	}

	public List<String> getMethodAnnotationPath(String className) throws SQLException, QueryException
	{
		List<String> arrMethods = new ArrayList<String>();
		String query = PropertyFileManager.getQuery("getPathOfMethodAnnotation");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("className", className);
		Iter iter = proc.iter();
		Item item;
		while ((item = iter.next()) != null) 
		{
			arrMethods.add(item.toJava().toString().replaceAll("\"", ""));
		}
		proc.close();
		return arrMethods;
	}

	public void createModel() throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("createModel");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.value();
		proc.close();
	}

	public void createModelAttr(String xsiType, String modelName) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("createModelAttr");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("xsiType", xsiType);
		proc.bind("modelName", modelName);
		proc.value();
		proc.close();
	}

	public void createStructureElement(String componentName, String parent) throws SQLException, QueryException
	{
		String stereotype = this.getStereotype(componentName.split(Pattern.quote("_"))[0]);
		String typeAbstraction="";
		if (componentName.contains("Managing") || componentName.contains("Managed"))
			typeAbstraction = "structure:Subsystem";
		else
			typeAbstraction = "structure:Component";

		String query = PropertyFileManager.getQuery("createStructureElement");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("component_name", componentName);
		proc.bind("parent", parent);
		proc.bind("typeAbstraction",typeAbstraction);
		proc.bind("stereotype", stereotype);
		proc.value();
		proc.close();
	}

	public void createStructureElementAttr(String var, String name) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("createStructureElementAttr");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("var", var);
		proc.bind("name", name);
		proc.value();
		proc.close();
	}

	public boolean checkComponentExist(String componentName) throws QueryException, SQLException {

		String query = PropertyFileManager.getQuery("checkComponentExist");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		boolean value = false;
		if (proc.value().toString().equals("true()"))
			value = true;
		else
			value = false;
		proc.close();
		return value;
	}

	public String getComponentImplementations(String componentName) throws QueryException, SQLException {

		String query = PropertyFileManager.getQuery("getComponentImplementations");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		String value = proc.value().toString().replaceAll("\"", "");
		proc.close();
		return value;
	}

	public void updateStructureElementAttr(String attr, String componentName) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("updateStructureElementAttr");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("attr", attr);
		proc.bind("componentName", componentName);
		proc.value();
		proc.close();
	}

	public String getPathofAbstraction(String componentName) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("getPathofAbstraction");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		String value = proc.value().toString().replaceAll("\"", "");
		value = this.convertModiscoPathAbstraction(value);
		proc.close();
		return value;
	}

	public boolean checkAggragationExist(String componentName, String from, String to) throws SQLException, QueryException {

		String query = PropertyFileManager.getQuery("checkAggregatedElement");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		proc.bind("from_",from);
		proc.bind("to_",to);

		boolean value = false;
		if (proc.value().toString().equals("true()"))
			value = true;
		else
			value = false;
		proc.close();
		return value;

	}

	public void createAggregatedElement(String componentName, String from, String to, String relation) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("createAggregatedElement");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("component_name", componentName);
		proc.bind("from_", from);
		proc.bind("to_", to);
		proc.bind("relation", relation);
		proc.value();
		proc.close();
	}

	public String getAggregatedData(String componentName, String from, String to) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("getAggregatedData");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		proc.bind("from_", from);
		proc.bind("to_", to);
		String value = proc.value().toString().replaceAll("\"", "");
		proc.close();
		return value;
	}

	public void updateAggregatedRelationAndDensity(String componentName, String from, String to, String relation, String density) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("updateStructureElementRelation");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		proc.bind("from_", from);
		proc.bind("to_", to);
		proc.bind("relation", relation);
		proc.value();
		proc.close();

		query = PropertyFileManager.getQuery("updateStructureElementDensity");
		proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		proc.bind("from_", from);
		proc.bind("to_", to);
		proc.bind("density", density);
		proc.value();
		proc.close();

	}

	public String getPathOfAggregated(String componentName,String from, String to) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("getPathOfAggregated");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		proc.bind("from_", from);
		proc.bind("to_", to);
		String value = proc.value().toString().replaceAll("\"", "");
		value = this.convertModiscoPathAbstraction(value);
		proc.close();
		return value;
	}

	public String getOutAggregated(String componentName) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("getOutAggregated");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		String value = proc.value().toString().replaceAll("\"", "");
		proc.close();
		return value;
	}

	public void updateOutAggregated(String componentName, String outAggregated) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("updateOutAggregated");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		proc.bind("outAggregated", outAggregated);
		proc.value();
		proc.close();
	}

	public String getInAggregated(String componentName) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("getInAggregated");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		String value = proc.value().toString().replaceAll("\"", "");
		proc.close();
		return value;
	}

	public void updateInAggregated(String componentName, String inAggregated) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("updateInAggregated");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("componentName", componentName);
		proc.bind("inAggregated", inAggregated);
		proc.value();
		proc.close();
	}

	public void addAbstractionTag() throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("addAbstractionTag");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.value();
		proc.close();
	}

	public void addAbstraction(String predicate) throws SQLException, QueryException
	{
		String query = PropertyFileManager.getQuery("query-3");
		query = query + predicate;
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.value();
		proc.close();
	}

	public void generateStereotype() throws SQLException, QueryException {

		String query = PropertyFileManager.getQuery("createStereotype");
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.value();
		proc.close();
	}

	public String getStereotype(String name) {

		switch (name) {
		case "Monitor" : return "/0/@extension.0/@stereotype.0";
		case "Analyzer" : return "/0/@extension.0/@stereotype.1";
		case "Planner" : return "/0/@extension.0/@stereotype.2";
		case "Executor" : return "/0/@extension.0/@stereotype.3";
		case "Knowledge" : return "/0/@extension.0/@stereotype.4";
		case "Reference Input" : return "/0/@extension.0/@stereotype.5";
		case "Measured Output" : return "/0/@extension.0/@stereotype.6";
		case "CL Manager" : return "/0/@extension.0/@stereotype.7";
		case "Control Loop" : return "/0/@extension.0/@stereotype.8";
		case "Sensor" : return "/0/@extension.0/@stereotype.9";
		case "Effector" : return "/0/@extension.0/@stereotype.10";
		case "Managing" : return "/0/@extension.0/@stereotype.11";
		case "Managed" : return "/0/@extension.0/@stereotype.12";
		default: return "";
		}
	}
}
