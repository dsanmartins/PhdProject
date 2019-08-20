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
		mydb.executeStmt("create table IF NOT EXISTS existence (project_name text, abstraction text, result integer)");
		mydb.executeStmt("create table IF NOT EXISTS composite (project_name text, abstraction text, result integer)");
		mydb.executeStmt("create table IF NOT EXISTS access (project_name text, abstraction1 text, abstraction2 text, result integer) ");
		mydb.executeStmt("create table IF NOT EXISTS drifts (project_name text, component integer, subsystem integer, association integer) ");
		mydb.executeStmt("create table IF NOT EXISTS existence_rules (project_name text, _key text, rule text, result integer)");
		mydb.executeStmt("create table IF NOT EXISTS composite_rules (project_name text, _key text, rule text, result integer)");
		mydb.executeStmt("create table IF NOT EXISTS access_rules (project_name text, _key text, rule text, result integer)");
		mydb.executeStmt("create table IF NOT EXISTS architectural_anomaly (id integer, anomaly_type text, name text, description text, constraint_type text, _from text, _to text)");
		mydb.executeStmt("create table IF NOT EXISTS mapping(id integer, _key text)");
		mydb.executeStmt("delete from existence"); 
		mydb.executeStmt("delete from composite"); 
		mydb.executeStmt("delete from access");
		mydb.executeStmt("delete from existence_rules"); 
		mydb.executeStmt("delete from composite_rules"); 
		mydb.executeStmt("delete from access_rules"); 
		mydb.executeStmt("delete from drifts"); 
		mydb.closeConnection();
		this.insertAnomalies();
	}

	public void insertAnomalies() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs1 = mydb.executeQry("select count(*) from architectural_anomaly");
		ResultSet rs2 = mydb.executeQry("select count(*) from mapping");

		if ((Integer) rs1.getObject(1) == 0 && (Integer) rs2.getObject(1)==0)
		{
			mydb.executeStmt("insert into architectural_anomaly(id, anomaly_type, name, description, constraint_type, _from, _to) "
					+ "values(1,'smell','Scattered Reference Input','This smell arises when Reference Inputs do not have a dedicated Knowledge to store them.','composite','Reference Input','Knowledge')");
			mydb.executeStmt("insert into mapping(id, _key) values(1,'composite_ReferenceInput')");
			mydb.executeStmt("insert into architectural_anomaly(id, anomaly_type, name, description, constraint_type, _from, _to) "
					+ "values(2,'smell','Mixed Executors and Effectors','This smell occurs when Executors and Effectors are not evident in the architecture of the AS.','exist','Effector','null')");
			mydb.executeStmt("insert into mapping(id, _key) values(2,'exist_Effector')");
			mydb.executeStmt("insert into architectural_anomaly(id, anomaly_type, name, description, constraint_type, _from, _to) "
					+ "values(3,'smell','Obscured Self-Healing Alternatives','This smell arises when the set of alternatives of a self-healing system is not implemented as a first class entities.','exist','Self-Healing Alternative','null')");
			mydb.executeStmt("insert into mapping(id, _key) values(3,'composite_SelfHealingAlt')");
		}
		mydb.closeConnection();
	}

	public void deleteTables() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("delete from existence"); 
		mydb.executeStmt("delete from composite"); 
		mydb.executeStmt("delete from access"); 
		mydb.executeStmt("delete from existence_rules"); 
		mydb.executeStmt("delete from composite_rules"); 
		mydb.executeStmt("delete from access_rules"); 
		mydb.executeStmt("delete from drifts"); 
	}

	public void insertExistence(String projectName, String abstraction, int result) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into existence(project_name, abstraction, result) values"
				+ " ('" + projectName + "','" +   abstraction + "',"  + result + ");"); 
		mydb.closeConnection();
	}

	public void insertExistenceRules(String projectName, String key, String rule, int result) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into existence_rules(project_name, _key, rule, result) values"
				+ " ('" + projectName + "','" +   key + "','" +   rule + "',"  + result + ");"); 
		mydb.closeConnection();
	}

	public void insertComposite(String projectName, String abstraction, int result) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into composite(project_name, abstraction, result) values"
				+ " ('" + projectName + "','" +   abstraction + "',"  + result + ");"); 
		mydb.closeConnection();
	}

	public void insertCompositeRules(String projectName, String key, String rule, int result) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into composite_rules(project_name, _key, rule, result) values"
				+ " ('" + projectName + "','" +   key + "','" +   rule + "',"  + result + ");"); 
		mydb.closeConnection();
	}

	public void insertAccess(String projectName, String abstraction1, String abstraction2, int result) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into access(project_name, abstraction1, abstraction2, result) values"
				+ " ('" + projectName + "','" +   abstraction1 + "','"  +   abstraction2 + "',"+ result + ");"); 
		mydb.closeConnection();
	}

	public void insertAccessRules(String projectName, String key, String rule, int result) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into access_rules(project_name, _key, rule, result) values"
				+ " ('" + projectName + "','" +   key + "','" +   rule + "',"  + result + ");"); 
		mydb.closeConnection();
	}

	public void insertDrifts(String projectName, int nComponent, int nSubsystem, int nAssociation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into drifts(project_name, component, subsystem, association) values"
				+ " ('" + projectName + "','" +   nComponent + "','"  +   nSubsystem + "',"+ nAssociation + ");"); 
		mydb.closeConnection();
	}

	public List<String> getExistenceRules() throws Exception{

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select _key, rule, result from existence_rules;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+","+rs.getObject(2).toString()+","+rs.getObject(3).toString());
		}
		mydb.closeConnection();
		return lst;

	}

	public List<String> getAccessRules() throws Exception{

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select _key, rule, result from access_rules;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+","+rs.getObject(2).toString()+","+rs.getObject(3).toString());
		}
		mydb.closeConnection();
		return lst;

	}

	public List<String> getCompositeRules() throws Exception{

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select _key, rule, result from composite_rules;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+","+rs.getObject(2).toString()+","+rs.getObject(3).toString());
		}
		mydb.closeConnection();
		return lst;

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

	public List<String> getAnomalies() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select anomaly_type, name, description from architectural_anomaly;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	public List<String> getAnomaliesIdentified() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select A._key, ifnull(C.name,'Please Set it up')\n" + 
				"from\n" + 
				"(\n" + 
				"    select *\n" + 
				"    from composite_rules  where result = 0\n" + 
				"    UNION ALL\n" + 
				"    select * \n" + 
				"    from existence_rules  where result = 0\n" + 
				"    UNION ALL\n" + 
				"    select * \n" + 
				"    from access_rules  where result = 0\n" + 
				") A  left join mapping B  ON A._key LIKE  B._key || '%' left join architectural_anomaly C on  C.id = B.id ;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString());
		}
		mydb.closeConnection();
		return lst;
	}
	
	public List<String> getAnomaliesIdentifiedReport() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select A._key, C.name \n" + 
				"from\n" + 
				"(   select * from composite_rules  where result = 0\n" + 
				"    UNION ALL\n" + 
				"	select * from existence_rules  where result = 0\n" + 
				"    UNION ALL\n" + 
				"	select * from access_rules  where result = 0\n" + 
				") A  inner join mapping B  ON A._key LIKE  B._key || '%' inner join architectural_anomaly C on  C.id = B.id ;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString());
		}
		mydb.closeConnection();
		return lst;
	}

}