package br.ufscar.xquery;
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

	public String createModiscoPath(String methodName, String type) throws QueryException, SQLException{

		String query = PropertyFileManager.getQuery(type);
		QueryProcessor proc = new QueryProcessor(query, context);
		proc.bind("name1", methodName);
		String str = proc.value().toString();
		str=str.substring(0, str.length()-1).replaceAll("Q\\{}", "").split("Segment")[1].substring(4).replaceAll("\\[", ".").replaceAll("\\]", "");
		String newStr[] = str.split("\\/");
		String finalString = "/0/";
		for (String character: newStr)
		{ 
			String name = character.split("\\.")[0];
			String number = String.valueOf(Integer.valueOf(character.split("\\.")[1])-1);
			finalString = finalString + "@" + name + "." + number + "/";
		}
		finalString = finalString.substring(0,finalString.length()-1);
		proc.close();
		return finalString;
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

	public ArrayList<String> getCallsFromTo() throws SQLException, QueryException
	{
		ArrayList<String> arrayFromTo = new ArrayList<String>();
		String query = PropertyFileManager.getQuery("getFromTo");
		QueryProcessor proc = new QueryProcessor(query, context);
		// Execute the query
		Iter iter = proc.iter();
		Item item;

		while ((item = iter.next()) != null) 
		{
			arrayFromTo.add(item.toJava().toString());
		}
		proc.close();
		return arrayFromTo;
	}

	/*
	 * Esse método transforma os paths obtidos pela xquery em nomes de pacotes, classes e métodos dinâmicamente.
	 */
	public List<String> getArtifactName(ArrayList<String> fromTo) throws SQLException, QueryException, IOException
	{
		List<String> fromToFiltered = null;
		List<String> from = new ArrayList<>();
		List<String> to = new ArrayList<>();

		for (int k = 0; k< fromTo.size(); k++)
		{
			String line[] = fromTo.get(k).split("\\-");
			for (int j =0; j< line.length;j++ )
			{
				from.add(line[j].split("\\|")[1]);
				to.add(line[j].split("\\|")[0]);
			}
		}

		ArrayList<String> arrayList1 = this.resolvePathNames(from);
		ArrayList<String> arrayList2 = this.resolvePathNames(to);
		List<String> newFromTo= new ArrayList<String>();

		int size = arrayList1.size();
		for (int i = 0; i < size; i++)
		{
			//Equal strings are filtered
			if (!arrayList1.get(i).equals(arrayList2.get(i)))
				newFromTo.add(arrayList1.get(i) + "|" + arrayList2.get(i));
		}
		fromToFiltered = newFromTo.stream().distinct().collect(Collectors.toList());

		return fromToFiltered;
	}

	public ArrayList<String> resolvePathNames(List<String> path) throws SQLException, QueryException
	{
		ArrayList<String> arrayList = new ArrayList<String>();	
		String iString = " let $prod := //kdm:Segment/";	
		String mString = " let $rtn1 := $prod[@xsi:type='code:MethodUnit' or @xsi:type='code:ClassUnit' or @xsi:type='code:Package']/@name ";
		String nString = " let $rtn2 := $prod/@xsi:type ";
		String fString = " return concat(data($rtn1),'-',data($rtn2)) ";
		String result = "";
		String modelE = "";
		String f1 = "";

		for (int i=0; i<path.size(); i++)
		{
			//Get path for each element of the array
			String line = path.get(i);
			String[] element = line.split("\\/");
			for (int j=0; j<element.length; j++)
			{ 
				if (j==2)
				{
					String[] modelElement = element[j].split("\\.");
					String mElement = modelElement[0].substring(1);
					int nElement = Integer.parseInt(modelElement[1]) + 1;
					modelE = mElement+"["+nElement+"]/";
				}	 
				if (j>2)
				{
					String[] codeElement = element[j].split("\\.");
					String sElement = codeElement[0].substring(1);
					int nElement = Integer.parseInt(codeElement[1]) + 1;
					String f1Element = sElement+"["+nElement+"]";
					String query = PropertyFileManager.getQuery("queryHeader");
					query = query + iString + modelE + f1 + f1Element + mString + nString + fString;

					String rtn = this.executeQueryPath(query);
					String name = rtn.split("\\-")[0];
					String type = rtn.split("\\-")[1];

					if (!name.equals(""))
						result = result+"."+name;	
					f1 = f1 + f1Element + "/";

					if (type.equals("code:MethodUnit"))
						break;
				}
			}
			arrayList.add(result.substring(1)); 
			result = "";
			f1 = "";
		}
		return arrayList;
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

	public ArrayList<String> getPathsofStructure() throws SQLException, QueryException{

		ArrayList<String> arrMethods = new ArrayList<String>();
		String query = PropertyFileManager.getQuery("getPathsofStructure");
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

	public List<String> getStructureElementName(String predicate) throws SQLException, QueryException {

		ArrayList<String> arrMethods = new ArrayList<String>();
		String query = PropertyFileManager.getQuery("queryHeader");
		QueryProcessor proc = new QueryProcessor(query + predicate, context);
		String value = proc.value().toJava().toString();
		Iter iter = proc.iter();
		Item item;

		while ((item = iter.next()) != null) 
		{
			arrMethods.add(item.toJava().toString());
		}
		proc.close();
		
		proc.close();
		return arrMethods;
	}

	private String convertXqueryPath(String path) {

		String newString = "";
		List<String> lst = new ArrayList<String>();
		String line[] = path.split(Pattern.quote("/"));
		for (int i = 0; i < line.length; i++)
		{
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(line[i]);
			if (matcher.find())
			{
				int val = Integer.valueOf(matcher.group(0)) +1;
				lst.add(line[i].replaceFirst("\\d+", String.valueOf(val)));
			}
		}
		for(String str:lst)
			newString = newString + "/" + str;

		newString = "/" + newString;
		return newString;
	}


	public List<String> getRelations() throws SQLException, QueryException{

		List<String> arrMethods = new ArrayList<String>();
		String query = PropertyFileManager.getQuery("getRelations");
		QueryProcessor proc = new QueryProcessor(query, context);
		Iter iter = proc.iter();
		Item item;
		String newRelation = "";
		while ((item = iter.next()) != null) 
		{
			String line = item.toJava().toString();
			String lines[] = line.split(Pattern.quote("-"));
			String from = this.convertXqueryPath(lines[0].substring(2));
			String to = this.convertXqueryPath(lines[1].substring(2));
			String relations[] = lines[2].split(Pattern.quote(" "));
			for (int i=0; i< relations.length; i++)
				newRelation = newRelation + " " + this.convertXqueryPath(relations[i]);

			newRelation = newRelation.trim();
			arrMethods.add(from + "-" + to + "-" + newRelation);
		}
		proc.close();
		return arrMethods;

	}
	
	public String getFromToRelation(String predicate) throws SQLException, QueryException{
		
		String query = PropertyFileManager.getQuery("queryHeader");
		QueryProcessor proc = new QueryProcessor(query + predicate, context);
		String value = proc.value().toJava().toString();
		proc.close();
		return value;
	}
}
