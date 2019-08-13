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
		mydb.executeStmt("create table IF NOT EXISTS existence (project_name text, abstraction text, result integer) ");
		mydb.executeStmt("create table IF NOT EXISTS composite (project_name text, abstraction text, result integer) ");
		mydb.executeStmt("create table IF NOT EXISTS access (project_name text, abstraction1 text, abstraction2 text, result integer) ");
		mydb.executeStmt("create table IF NOT EXISTS drifts (project_name text, component integer, subsystem integer, association integer) ");
		mydb.executeStmt("delete from existence"); 
		mydb.executeStmt("delete from composite"); 
		mydb.executeStmt("delete from access"); 
		mydb.closeConnection();
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

	private List<String> resultSetToArrayList1(ResultSet rs) throws SQLException {

		List<String> list = new ArrayList<String>();
		if (rs == null)
			return new ArrayList<String>();
		else
			while (rs.next()) {
				list.add(rs.getObject(1).toString());
			}
		return list;
	}

	public List<String> getAbstractions() throws Exception {

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select annotation from abstractions order by id");
		lst = this.resultSetToArrayList1(rs);
		mydb.closeConnection();
		return lst;
	}

	public List<String> selectAnnotationPackage(String projectName, String name, String file) throws Exception {

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select annotation || '|' || belongs from package_annotation  where project_name= '" +
				projectName + "' and name = '" + name + "';");	
		lst = this.resultSetToArrayList1(rs);
		mydb.closeConnection();
		return lst;
	}

	
	
	
	public List<String> getPackageAnnotations() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select * from package_annotation ;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString()+"|"+rs.getObject(4).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	public List<String> getClassAnnotations() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select * from class_annotation ;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString()+"|"+rs.getObject(4).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	public List<String> getFieldClassAnnotations() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select * from field_annotation ;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString()+"|"+rs.getObject(4).toString()+"|"+rs.getObject(5).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	public List<String> getMethodAnnotations() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select * from method_annotation ;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString()+"|"+rs.getObject(4).toString()+"|"+rs.getObject(5).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	public List<String> getVariableAnnotations() throws Exception
	{
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select * from variable_annotation ;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString()+"|"+rs.getObject(4).toString()+"|"+rs.getObject(5).toString()+"|"+rs.getObject(6).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	public void insertRelations(List<String> relations) throws Exception
	{
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		for (int i=0; i < relations.size(); i++)
			mydb.executeStmt("insert into relation (from_, to_, modisco_path, type_relation) values "
					+ " ('" + relations.get(i).split(Pattern.quote("|"))[0] + "'," +
					"'" + relations.get(i).split(Pattern.quote("|"))[1] + "'," +
					"'" + relations.get(i).split(Pattern.quote("|"))[2] + "'," +
					"'" + relations.get(i).split(Pattern.quote("|"))[3] + "');"); 
		mydb.closeConnection();
	}

	public String selectAbstraction (String abstraction, String instance) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select id from abstractions where annotation= '" + abstraction + "';");	
		String str = "";

		while (rs.next()) {

			str = rs.getObject(1).toString();
		}
		mydb.closeConnection();
		return str;
	}

	public void insertInstance(String abstraction, String instance) throws Exception {

		String value = this.selectAbstraction(abstraction, instance);
		if (!value.equals(""))
		{
			SqliteDb mydb = new SqliteDb(dbDriver,url);
			mydb.executeStmt("insert into instances (abstraction_id, annotation) values"
					+ " ('" + value + "','" +   instance + "');"); 
			mydb.closeConnection();
		}
	}

	public void deleteInstance(String instance) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("delete from instances where annotation = '" +   instance + "';"); 
		mydb.closeConnection();
	}

	public List<String> selectInstance(int op) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		List<String> lst = new ArrayList<String>();
		ResultSet rs = null;
		if (op == 1)
		{
			rs = mydb.executeQry("select a.annotation, b.annotation "
					+ "from abstractions a inner join instances b on "
					+ "a.id = b.abstraction_id "
					+ "order by a.id;");

			while (rs.next())
				lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString());
		}
		else
		{
			if (op == 2)
			{
				rs = mydb.executeQry("select b.annotation "
						+ "from abstractions a inner join instances b on "
						+ "a.id = b.abstraction_id "
						+ "order by a.id;");

				while (rs.next())
					lst.add(rs.getObject(1).toString());

				lst.add(0,"None");
			}
		}
		mydb.closeConnection();
		return lst;
	}

	public boolean isUsingData(String instance) throws Exception
	{
		boolean rtn = false;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select annotation from package_annotation where annotation = '" + instance + 
				"' UNION ALL \n" + 
				"select annotation from class_annotation where annotation = '" + instance + 
				"' UNION ALL \n" + 
				"select annotation from field_annotation where annotation = '" + instance + 
				"' UNION ALL \n" + 
				"select annotation from method_annotation where annotation = '" + instance + 
				"' UNION ALL\n" + 
				"select annotation from variable_annotation where annotation = '" + instance +  "';");		

		if (!rs.next())
			rtn = false; 
		else
			rtn = true;
		mydb.closeConnection();
		return rtn;
	}

	public List<String> selectAnnotationBelong() throws Exception
	{
		List<String> rtn = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select T.A from ("
				+ "select (annotation || '|' || belongs) A from package_annotation where annotation <> 'None' " + 
				" UNION ALL\n" + 
				"select (annotation || '|' || belongs) A from class_annotation where annotation <> 'None' " +
				" UNION ALL\n" + 
				"select (annotation || '|' || belongs) from field_annotation where annotation <> 'None' " +
				" UNION ALL\n" + 
				"select (annotation || '|' || belongs) from method_annotation where annotation <> 'None' " +
				" UNION ALL\n" + 
				"select (annotation || '|' || belongs) from variable_annotation where annotation <> 'None') T "
				+ " ORDER BY "
				+ "CASE\n" + 
				"        WHEN T.A LIKE '%|None' THEN 1\n" + 
				"        ELSE 2\n" + 
				"END;");		

		while (rs.next())
			rtn.add(rs.getString(1));

		mydb.closeConnection();
		return rtn;
	}

	public boolean selectDifferentBelongToInstance() throws Exception{

		boolean rtn = false;
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("Select t.annotation , count(Distinct T.belongs ) from ( \n" + 
				"select annotation, belongs from package_annotation where annotation <> 'None' \n" + 
				"UNION ALL  \n" + 
				"select annotation, belongs from class_annotation where annotation <> 'None'  \n" + 
				"UNION ALL  \n" + 
				"select annotation, belongs from field_annotation where annotation <> 'None'  \n" + 
				"UNION ALL  \n" + 
				"select annotation, belongs from method_annotation where annotation <> 'None'  \n" + 
				"UNION ALL  \n" + 
				"select annotation, belongs from variable_annotation where annotation <> 'None') T    \n" + 
				" Where T.annotation in (   \n" + 
				"    select T.annotation  \n" + 
				"    from (\n" + 
				"    select annotation, belongs from package_annotation where annotation <> 'None'   \n" + 
				"    UNION ALL  \n" + 
				"    select annotation, belongs from class_annotation where annotation <> 'None' \n" + 
				"    UNION ALL  \n" + 
				"    select annotation, belongs from field_annotation where annotation <> 'None'   \n" + 
				"    UNION ALL  \n" + 
				"    select annotation, belongs from method_annotation where annotation <> 'None'  \n" + 
				"    UNION ALL \n" + 
				"    select annotation, belongs from variable_annotation where annotation <> 'None') T  \n" + 
				"    Group by T.annotation  \n" + 
				"    HAVING COUNT(*) > 1 )  \n" + 
				" group by t.annotation \n" + 
				" having count(Distinct T.belongs) > 1; ");		
		if (!rs.next())
			rtn = false; 
		else
			rtn = true;
		mydb.closeConnection();
		return rtn;
	}

	public boolean checkIfBelongsExistAsInstance() throws Exception {

		boolean rtn = false;
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select belongs from (\n" + 
				"    select belongs from package_annotation \n" + 
				"    UNION ALL\n" + 
				"    select belongs from class_annotation\n" + 
				"    UNION ALL\n" + 
				"    select belongs from field_annotation \n" + 
				"    UNION ALL \n" + 
				"    select belongs from method_annotation\n" + 
				"    UNION ALL \n" + 
				"    select belongs from variable_annotation \n" + 
				") where belongs<> 'None' and belongs not in (\n" + 
				"\n" + 
				"select annotation from (\n" + 
				"    select annotation from package_annotation \n" + 
				"    UNION ALL\n" + 
				"    select annotation from class_annotation\n" + 
				"    UNION ALL\n" + 
				"    select annotation from field_annotation \n" + 
				"    UNION ALL \n" + 
				"    select annotation from method_annotation\n" + 
				"    UNION ALL \n" + 
				"    select annotation from variable_annotation \n" + 
				") );");

		if (!rs.next())
			rtn = true; 
		else
			rtn = false;
		mydb.closeConnection();
		return rtn;

	}

	public boolean checkRecursiveRelations() throws Exception {

		boolean rtn = false;
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select count(*) From\n" + 
				"(select annotation A, belongs B from annotations) T1, \n" + 
				"(select belongs A, annotation B from annotations) T2\n" + 
				"where T1.A = T2.A and T1.B=T2.B;");

		while (rs.next())
		{
			int quantity = (Integer) rs.getObject(1);
			if ( quantity == 0)
				rtn = true; 
			else
				rtn = false;
		}
		mydb.closeConnection();
		return rtn;

	}
	
	public void deleteRelation() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("delete from relation;"); 
		mydb.closeConnection();
	}
	
	public List<String> getActionRelation() throws Exception {
		
		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select DISTINCT b.annotation, a.from_, (select annotation from summary_annotation where name = a.to_), a.to_, a.modisco_path, a.type_relation\n" + 
				"from relation a inner join summary_annotation b on a.from_ = b.name \n" + 
				"where a.to_ in (select name from summary_annotation) \n" + 
				"order by b.annotation;");		
		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString()+"|"+rs.getObject(4).toString()+"|"+rs.getObject(5).toString()+"|"+rs.getObject(6).toString());
		}
		mydb.closeConnection();
		return lst;	
	}
	
}