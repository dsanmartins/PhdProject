package br.ufscar.sas.dataconstraint;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


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
		mydb.executeStmt("create table IF NOT EXISTS domain (project_name text, abstraction1 text, abstraction2 text, result integer) ");
		mydb.executeStmt("create table IF NOT EXISTS drifts (project_name text, component integer, subsystem integer, association integer, domain integer) ");
		mydb.executeStmt("create table IF NOT EXISTS existence_rules (project_name text, _key text, rule text, result integer, id integer)");
		mydb.executeStmt("create table IF NOT EXISTS composite_rules (project_name text, _key text, rule text, result integer, id integer)");
		mydb.executeStmt("create table IF NOT EXISTS access_rules (project_name text, _key text, rule text, result integer, id integer)");
		mydb.executeStmt("create table IF NOT EXISTS domain_rules (project_name text, _key text, rule text, result integer, id integer)");
		mydb.executeStmt("create table IF NOT EXISTS architectural_anomaly (id integer, anomaly_type text, name text, description text, constraint_type text, _from text, _to text)");
		mydb.executeStmt("create table IF NOT EXISTS mapping(id integer, _key text)");
		mydb.executeStmt("delete from existence"); 
		mydb.executeStmt("delete from composite"); 
		mydb.executeStmt("delete from access");
		mydb.executeStmt("delete from domain"); 
		mydb.executeStmt("delete from existence_rules"); 
		mydb.executeStmt("delete from composite_rules"); 
		mydb.executeStmt("delete from access_rules"); 
		mydb.executeStmt("delete from domain_rules"); 
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
					+ "values(1,'drift','Scattered Reference Input','This drift arises when Reference Inputs do not have a dedicated Knowledge to store them.','composite','Reference Input','Knowledge')");
			mydb.executeStmt("insert into mapping(id, _key) values(1,'composite_ReferenceInput')");
			mydb.executeStmt("insert into architectural_anomaly(id, anomaly_type, name, description, constraint_type, _from, _to) "
					+ "values(2,'drift','Mixed Executors and Effectors','This drift occurs when Executors and Effectors are not evident in the architecture of the AS.','exist','Effector','null')");
			mydb.executeStmt("insert into mapping(id, _key) values(2,'exist_Effector')");
			mydb.executeStmt("insert into architectural_anomaly(id, anomaly_type, name, description, constraint_type, _from, _to) "
					+ "values(3,'drift','Obscure Alternatives','This drift arises when the set of alternatives is not implemented as a first class entities.','exist','Alternative','null')");
			mydb.executeStmt("insert into mapping(id, _key) values(3,'composite_Alternative')");
		}
		mydb.closeConnection();
	}

	public void deleteTables() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("delete from existence"); 
		mydb.executeStmt("delete from composite"); 
		mydb.executeStmt("delete from access"); 
		mydb.executeStmt("delete from domain"); 
		mydb.executeStmt("delete from existence_rules"); 
		mydb.executeStmt("delete from composite_rules"); 
		mydb.executeStmt("delete from access_rules"); 
		mydb.executeStmt("delete from domain_rules"); 
		mydb.executeStmt("delete from drifts"); 
	}

	public int insertExistence(String projectName, String abstraction, int result) throws Exception {

		int rtn =-1;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into existence(project_name, abstraction, result) values"
				+ " ('" + projectName + "','" +   abstraction + "',"  + result + ");"); 
		
		ResultSet rs = mydb.executeQry("select last_insert_rowid()"); 
		while (rs.next()) {
			rtn = Integer.valueOf(rs.getObject(1).toString());
		}
		
		mydb.closeConnection();
		return rtn;
	}

	public void insertExistenceRules(String projectName, String key, String rule, int result, int id) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into existence_rules(project_name, _key, rule, result, id) values"
				+ " ('" + projectName + "','" +   key + "','" +   rule + "',"  + result + ","  + id + ");"); 
		mydb.closeConnection();
	}

	public int insertComposite(String projectName, String abstraction, int result) throws Exception {

		int rtn =-1;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into composite(project_name, abstraction, result) values"
				+ " ('" + projectName + "','" +   abstraction + "',"  + result + ");"); 
		ResultSet rs = mydb.executeQry("select last_insert_rowid()"); 
		while (rs.next()) {
			rtn = Integer.valueOf(rs.getObject(1).toString());
		}
		
		mydb.closeConnection();
		return rtn;
	}

	public void insertCompositeRules(String projectName, String key, String rule, int result, int id) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into composite_rules(project_name, _key, rule, result, id) values"
				+ " ('" + projectName + "','" +   key + "','" +   rule + "',"  + result +  ","  + id + ");"); 
		mydb.closeConnection();
	}

	public int insertAccess(String projectName, String abstraction1, String abstraction2, int result) throws Exception {

		int rtn = -1;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into access(project_name, abstraction1, abstraction2, result) values"
				+ " ('" + projectName + "','" +   abstraction1 + "','"  +   abstraction2 + "',"+ result + ");"); 
		ResultSet rs = mydb.executeQry("select last_insert_rowid()"); 
		while (rs.next()) {
			rtn = Integer.valueOf(rs.getObject(1).toString());
		}
		
		mydb.closeConnection();
		return rtn;
	}

	public void insertAccessRules(String projectName, String key, String rule, int result, int id) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into access_rules(project_name, _key, rule, result, id) values"
				+ " ('" + projectName + "','" +   key + "','" +   rule + "',"  + result + ","  + id + ");"); 
		mydb.closeConnection();
	}

	public int insertDomain(String projectName, String abstraction1, String abstraction2, int result) throws Exception {

		int rtn = -1;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into domain(project_name, abstraction1, abstraction2, result) values"
				+ " ('" + projectName + "','" +   abstraction1 + "','"  +   abstraction2 + "',"+ result + ");"); 
		ResultSet rs = mydb.executeQry("select last_insert_rowid()"); 
		while (rs.next()) {
			rtn = Integer.valueOf(rs.getObject(1).toString());
		}
		
		mydb.closeConnection();
		return rtn;
	}

	public void insertDomainRules(String projectName, String key, String rule, int result, int id) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into domain_rules(project_name, _key, rule, result, id) values"
				+ " ('" + projectName + "','" +   key + "','" +   rule + "',"  + result + ","  + id + ");"); 
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

	public List<String> getDomainRules() throws Exception{

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select _key, rule, result from domain_rules;");		
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
				+ "(select count(*) as total from composite where result = 0 or result = 1) as B;\n" );
		lst = resultSetToArrayList(rs);
		mydb.closeConnection();
		return lst;
	}

	public List<Integer> getAccessAbstractions() throws Exception{

		List<Integer> lst = new ArrayList<Integer>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select A.false, B.total from "
				+ "(select count(*) as false from access where result = 0) as A, "
				+ "(select count(*) as total from access where result = 0 or result = 1) as B;\n" );
		lst = resultSetToArrayList(rs);
		mydb.closeConnection();
		return lst;
	}

	public List<Integer> getDomainAbstractions() throws Exception{

		List<Integer> lst = new ArrayList<Integer>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select A.false, B.total from "
				+ "(select count(*) as false from domain where result = 0) as A, "
				+ "(select count(*) as total from domain where result = 0 or result = 1) as B;\n" );
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
		ResultSet rs = mydb.executeQry("select component, subsystem, association, domain from drifts");
		lst.add((Integer)rs.getObject(1));
		lst.add((Integer)rs.getObject(2));
		lst.add((Integer)rs.getObject(3));
		lst.add((Integer)rs.getObject(4));
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

	public List<String> getAnomaliesIdentifiedExistence() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select A._key,CASE A.result WHEN 0 THEN ifnull(C.name,'Please Set it up') ELSE '' END, A.result \n" + 
				"from\n" + 
				"(\n" + 
				"    select * \n" + 
				"    from existence_rules  \n" + 
				") A  left join mapping B  ON A._key LIKE  B._key || '%' left join architectural_anomaly C on  C.id = B.id Order by A.result;");		
		while (rs.next()) {
			lst.add(this.setTextExist(rs.getObject(1).toString())+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	public List<String> getAnomaliesIdentifiedComposition() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select A._key, CASE A.result WHEN 0 THEN ifnull(C.name,'Please Set it up') ELSE '' END, A.result \n" + 
				"from\n" + 
				"(\n" + 
				"    select * \n" + 
				"    from composite_rules  \n" + 
				") A  left join mapping B  ON A._key LIKE  B._key || '%' left join architectural_anomaly C on  C.id = B.id  Where A.result <> -1 Order by A.result;");		
		while (rs.next()) {
			lst.add(this.setTextComposition(rs.getObject(1).toString())+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	public List<String> getAnomaliesIdentifiedAccess() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select A._key, CASE A.result WHEN 0 THEN ifnull(C.name,'Please Set it up') ELSE '' END, A.result \n" + 
				"from\n" + 
				"(\n" + 
				"    select * \n" + 
				"    from access_rules  \n" + 
				") A  left join mapping B  ON A._key LIKE  B._key || '%' left join architectural_anomaly C on  C.id = B.id  Where A.result <> -1 Order by A.result;");		
		while (rs.next()) {
			lst.add(this.setTextAccess(rs.getObject(1).toString())+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	public List<String> getAnomaliesIdentifiedDomain() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select A._key, CASE A.result WHEN 0 THEN ifnull(C.name,'Please Set it up') ELSE '' END, A.result \n" + 
				"from\n" + 
				"(\n" + 
				"    select * \n" + 
				"    from domain_rules  \n" + 
				") A  left join mapping B  ON A._key LIKE  B._key || '%' left join architectural_anomaly C on  C.id = B.id  Where A.result <> -1 Order by A.result;");		
		while (rs.next()) {
			lst.add(this.setTextDomain(rs.getObject(1).toString())+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString());
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
				"    UNION ALL\n" + 
				"	select * from domain_rules  where result = 0\n" + 
				") A  inner join mapping B  ON A._key LIKE  B._key || '%' inner join architectural_anomaly C on  C.id = B.id ;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	private String setTextExist(String text) {

		String part1 = text.split(Pattern.quote("_"))[0];
		String part2 = text.split(Pattern.quote("_"))[1];
		String part3 = text.split(Pattern.quote("_"))[2];
		return part1.toUpperCase()+ " " + part2+"_" + part3;
	}

	private String setTextComposition(String text) {

		String part2 = text.split(Pattern.quote("_"))[1];
		String part3 = text.split(Pattern.quote("_"))[2];
		return "ISCOMPOSING " + part2+"_" + part3;
	}

	private String setTextAccess(String text) {

		if (text.split(Pattern.quote("_")).length == 5)
		{
			String part2 = text.split(Pattern.quote("_"))[1];
			String part3 = text.split(Pattern.quote("_"))[2];
			String part4 = text.split(Pattern.quote("_"))[3];
			String part5 = text.split(Pattern.quote("_"))[4];
			return part2 + "_"+ part3 + " MUST-USE " + part4 + "_"+ part5;

		}			
		else 
		{
			String part3 = text.split(Pattern.quote("_"))[2];
			String part4 = text.split(Pattern.quote("_"))[3];
			String part5 = text.split(Pattern.quote("_"))[4];
			String part6 = text.split(Pattern.quote("_"))[5];
			return part3 + "_"+ part4 + " MUST-NOT-USE " + part5 + "_"+ part6;
		}

	}

	private String setTextDomain(String text) {

		if (text.split(Pattern.quote("_")).length == 6)
		{
			String part3 = text.split(Pattern.quote("_"))[2];
			String part4 = text.split(Pattern.quote("_"))[3];
			String part5 = text.split(Pattern.quote("_"))[4];
			String part6 = text.split(Pattern.quote("_"))[5];
			return part3 + "_"+ part4 + " MUST-USE " + part5 + "_"+ part6;

		}			
		else 
		{
			String part4 = text.split(Pattern.quote("_"))[3];
			String part5 = text.split(Pattern.quote("_"))[4];
			String part6 = text.split(Pattern.quote("_"))[5];
			String part7 = text.split(Pattern.quote("_"))[6];
			return part4 + "_"+ part5 + " MUST-NOT-USE " + part6 + "_"+ part7;
		}

	}

	public String getTotalViolations() throws Exception
	{
		String result= "";
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select ifnull(count(*),0)\n" + 
				"from (\n" + 
				"select result from existence_rules\n" + 
				"UNION ALL\n" + 
				"select result from composite_rules\n" + 
				"UNION ALL\n" + 
				"select result from access_rules\n" + 
				"UNION ALL\n" + 
				"select result from domain_rules\n" + 
				")\n" + 
				"where result = 0;\n");		
		while (rs.next()) {
			result = rs.getObject(1).toString();
		}
		mydb.closeConnection();
		return result;
		
	}
	
	public String getTotalPassed() throws Exception
	{
		String result= "";
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select ifnull(count(*),0)\n" + 
				"from (\n" + 
				"select result from existence_rules\n" + 
				"UNION ALL\n" + 
				"select result from composite_rules\n" + 
				"UNION ALL\n" + 
				"select result from access_rules\n" + 
				"UNION ALL\n" + 
				"select result from domain_rules\n" + 
				")\n" + 
				"where result = 1;\n");		
		while (rs.next()) {
			result = rs.getObject(1).toString();
		}
		mydb.closeConnection();
		return result;
		
	}
	
	public void checkRealConstraints() throws Exception {
		
		
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update composite \n" + 
				"set result = -1\n" + 
				"where \n" + 
				"     abstraction not in \n" + 
				"     (select abstraction from existence where result = 1);"); 
		
		mydb.executeStmt("update composite_rules\n" + 
				"set result = -1\n" + 
				"where id in (select rowid from composite where result = -1);");
		
		
		mydb.executeStmt("update access \n" + 
				"set result = -1\n" + 
				"where \n" + 
				"     (abstraction1 not in (select abstraction from existence where result = 1) or \n" + 
				"      abstraction2 not in (select abstraction from existence where result = 1) );");
		
		
		mydb.executeStmt("update access_rules\n" + 
				"set result = -1\n" + 
				"where id in (select rowid from access where result = -1);");
		
		
		mydb.executeStmt("update domain \n" + 
				"set result = -1\n" + 
				"where \n" + 
				"     (abstraction1 not in (select abstraction from existence where result = 1) or \n" + 
				"      abstraction2 not in (select abstraction from existence where result = 1) );");
		
		mydb.executeStmt("update domain_rules\n" + 
				"set result = -1\n" + 
				"where id in (select rowid from domain where result = -1);");
		
		mydb.closeConnection();
		
	}
	
	public List<String> getIgnoredRules() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		lst.addAll(this.getIgnoredRulesComposition());
		lst.addAll(this.getIgnoredRulesAccess());
		lst.addAll(this.getIgnoredRulesDomain());
		return lst;
	}

	public List<String> getIgnoredRulesComposition() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select _key,'Composite' from composite_rules where result = -1;");		
		while (rs.next()) { 
			lst.add(this.setTextComposition(rs.getObject(1).toString())+"|"+rs.getObject(2).toString());
		}
		mydb.closeConnection();
		return lst;
	}
	
	public List<String> getIgnoredRulesAccess() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select _key, 'Access' from access_rules where result = -1;");		
		while (rs.next()) {
			lst.add(this.setTextAccess(rs.getObject(1).toString())+"|"+rs.getObject(2).toString());
		}
		mydb.closeConnection();
		return lst;
	}
	
	public List<String> getIgnoredRulesDomain() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select _key, 'Domain' from domain_rules where result = -1;");		
		while (rs.next()) {
			lst.add(this.setTextDomain(rs.getObject(1).toString())+"|"+rs.getObject(2).toString());
		}
		mydb.closeConnection();
		return lst;
	}


}