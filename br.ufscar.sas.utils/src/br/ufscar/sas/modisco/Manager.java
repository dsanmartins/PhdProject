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


import java.sql.SQLException;
import java.util.regex.Pattern;

import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.Close;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.DropDB;
import org.basex.core.cmd.Export;
import org.basex.core.cmd.Open;
import org.basex.query.QueryException;
import org.basex.query.QueryProcessor;

import br.ufscar.sas.database.QueryClass;

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

	public void createLine(String predicate) throws SQLException, QueryException {
		String query = PropertyFileManager.getQuery("query-3");
		QueryProcessor proc = new QueryProcessor(query + predicate, context);
		proc.value();
		proc.close();
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

	public void createStructureElement(String componentName, String parent, String path_) throws Exception
	{
		QueryClass queryClass = new QueryClass(path_);
		String stereotype = this.getStereotype(queryClass.selectAbstractionByInstance(componentName));
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

	public String getStereotype(String name) {

		switch (name) {
		case "Monitor" : return "/0/@extension.0/@stereotype.0";
		case "Analyzer" : return "/0/@extension.0/@stereotype.1";
		case "Planner" : return "/0/@extension.0/@stereotype.2";
		case "Executor" : return "/0/@extension.0/@stereotype.3";
		case "Knowledge" : return "/0/@extension.0/@stereotype.4";
		case "ReferenceInput" : return "/0/@extension.0/@stereotype.5";
		case "MeasuredOutput" : return "/0/@extension.0/@stereotype.6";
		case "LoopManager" : return "/0/@extension.0/@stereotype.7";
		case "Loop" : return "/0/@extension.0/@stereotype.8";
		case "Sensor" : return "/0/@extension.0/@stereotype.9";
		case "Effector" : return "/0/@extension.0/@stereotype.10";
		case "Managing" : return "/0/@extension.0/@stereotype.11";
		case "Managed" : return "/0/@extension.0/@stereotype.12";
		case "Alternative" : return "/0/@extension.0/@stereotype.13";
		default: return "";
		}
	}
}
