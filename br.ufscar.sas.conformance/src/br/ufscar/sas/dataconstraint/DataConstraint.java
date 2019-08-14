package br.ufscar.sas.dataconstraint;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DataConstraint {

	String projectName;
	String dbDriver;
	String database;
	String url;


	public DataConstraint(String projectName) throws SQLException {

		this.projectName = projectName;
		this.dbDriver = Property.getProperty("dbdriver");
		this.database = Property.getProperty("db");
		this.url = projectName + this.database;
	}

	public void createTables() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("create table IF NOT EXISTS existence (project_name text, abstraction text, result integer) ");
		mydb.executeStmt("create table IF NOT EXISTS composite (project_name text, abstraction text, result integer) ");
		mydb.executeStmt("create table IF NOT EXISTS access (project_name text, abstraction1 text, abstraction2 text, result integer) ");
		mydb.executeStmt("create table IF NOT EXISTS drifts (project_name text, component integer, subsystem integer, association integer) ");
		mydb.executeStmt("delete from existence"); 
		mydb.executeStmt("delete from composite"); 
		mydb.executeStmt("delete from access"); 
		mydb.executeStmt("delete from drifts"); 
		mydb.closeConnection();
	}

	public void deleteTables() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("delete from existence"); 
		mydb.executeStmt("delete from composite"); 
		mydb.executeStmt("delete from access"); 
		mydb.executeStmt("delete from drifts"); 
	}

	public void insertExistence(String projectName, String abstraction, int result) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into existence(project_name, abstraction, result) values"
				+ " ('" + projectName + "','" +   abstraction + "',"  + result + ");"); 
		mydb.closeConnection();
	}

	public void insertComposite(String projectName, String abstraction, int result) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into composite(project_name, abstraction, result) values"
				+ " ('" + projectName + "','" +   abstraction + "',"  + result + ");"); 
		mydb.closeConnection();
	}

	public void insertAccess(String projectName, String abstraction1, String abstraction2, int result) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into access(project_name, abstraction1, abstraction2, result) values"
				+ " ('" + projectName + "','" +   abstraction1 + "','"  +   abstraction2 + "',"+ result + ");"); 
		mydb.closeConnection();
	}

	public void insertDrifts(String projectName, int nComponent, int nSubsystem, int nAssociation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into drifts(project_name, component, subsystem, association) values"
				+ " ('" + projectName + "','" +   nComponent + "','"  +   nSubsystem + "',"+ nAssociation + ");"); 
		mydb.closeConnection();
	}

	public List<Integer> getExistenceAbstractions() throws Exception{

		List<Integer> lst = new ArrayList<Integer>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select A.false, B.total from "
				+ "(select count(*) as false from existence where result = 0) as A, "
				+ "(select count(*) as total from existence) as B;\n" );
		lst = resultSetToArrayList(rs);
		mydb.closeConnection();
		return lst;

	}

	public List<Integer> getCompositionAbstractions() throws Exception{

		List<Integer> lst = new ArrayList<Integer>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select A.false, B.total from "
				+ "(select count(*) as false from composite where result = 0) as A, "
				+ "(select count(*) as total from composite) as B;\n" );
		lst = resultSetToArrayList(rs);
		mydb.closeConnection();
		return lst;
	}
	
	public List<Integer> getAccessAbstractions() throws Exception{

		List<Integer> lst = new ArrayList<Integer>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select A.false, B.total from "
				+ "(select count(*) as false from access where result = 0) as A, "
				+ "(select count(*) as total from access) as B;\n" );
		lst = resultSetToArrayList(rs);
		mydb.closeConnection();
		return lst;
	}

	private List<Integer> resultSetToArrayList(ResultSet rs) throws SQLException {

		List<Integer> list = new ArrayList<Integer>();
		if (rs == null)
			return new ArrayList<Integer>();
		else
		{
			list.add((Integer) rs.getObject(1));
			list.add((Integer) rs.getObject(2));
		}
		return list;
	}
	
	public List<Integer> getUntestedValues() throws Exception {
		
		List<Integer> lst = new ArrayList<Integer>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select component, subsystem, association from drifts");
		lst.add((Integer)rs.getObject(1));
		lst.add((Integer)rs.getObject(2));
		lst.add((Integer)rs.getObject(3));
		mydb.closeConnection();
		return lst;
		
	}

}