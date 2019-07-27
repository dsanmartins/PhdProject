package br.ufscar.sas.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class QueryClass {

	String projectName;
	String dbDriver;
	String database;
	String url;


	public QueryClass(String projectName) throws SQLException {

		this.projectName = projectName;
		this.dbDriver = Property.getProperty("dbdriver");
		this.database = Property.getProperty("db");
		this.url = projectName + this.database;
	}

	public void createTables() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("create table IF NOT EXISTS package_annotation (project_name text, name text, file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS class_annotation (project_name text, name text, file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS field_annotation (project_name text, class_name text, field_name text, file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS method_annotation (project_name text, class_name text, method_name text,file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS variable_annotation (project_name text, class_name text, method_name text, variable_name, file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS abstractions (id integer primary key, annotation text) ");
		mydb.executeStmt("create table IF NOT EXISTS instances (id INTEGER PRIMARY KEY AUTOINCREMENT, abstraction_id integer, annotation text, FOREIGN KEY(abstraction_id) REFERENCES abstractions(id)) ");
		mydb.executeStmt("create table IF NOT EXISTS relation (from_ text, to_ text, modisco_path text, type_relation text) ");
		mydb.executeStmt("CREATE VIEW IF NOT EXISTS annotations(annotation,belongs)  AS " +
				"    select T.A, T.B from (\n" + 
				"        select annotation A ,belongs B from package_annotation \n" + 
				"        UNION ALL\n" + 
				"        select annotation A ,belongs B from class_annotation\n" + 
				"        UNION ALL\n" + 
				"        select annotation A ,belongs B from field_annotation \n" + 
				"        UNION ALL \n" + 
				"        select annotation A ,belongs B from method_annotation\n" + 
				"        UNION ALL \n" + 
				"        select annotation A ,belongs B from variable_annotation ) \n" + 
				" T where T.A <> 'None' and T.B <> 'None' ;");
		mydb.executeStmt("CREATE VIEW IF NOT EXISTS summary_annotation(name,annotation)  AS\n" + 
				"select name AS name, annotation from package_annotation where annotation <> 'None'\n" + 
				"UNION ALL\n" + 
				"select REPLACE(SUBSTR(file,INSTR(file,'src/')+4),'/','.') name, annotation from class_annotation where annotation <> 'None'\n" + 
				"UNION ALL\n" + 
				"select (REPLACE(SUBSTR(file,INSTR(file,'src/')+4),'/','.') || '.' || field_name) name, annotation from field_annotation where annotation <> 'None'\n" + 
				"UNION ALL\n" + 
				"select (REPLACE(SUBSTR(file,INSTR(file,'src/')+4),'/','.') || '.' || method_name) name, annotation from method_annotation where annotation <> 'None'\n" + 
				"UNION ALL\n" + 
				"select (REPLACE(SUBSTR(file,INSTR(file,'src/')+4),'/','.') || '.' || method_name || '.' ||variable_name) name, annotation from variable_annotation where annotation <> 'None';");
		mydb.executeStmt("delete from abstractions"); 
		mydb.executeStmt("delete from relation"); 
		mydb.closeConnection();
	}

	public void populateAbstractions() throws SQLException, Exception
	{
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into abstractions(id,annotation) values ('1','Managed');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('2','Managing');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('3','CL Manager');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('4','Control Loop');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('5','Monitor');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('6','Analyzer');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('7','Planner');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('8','Executor');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('9','Knowledge');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('10','Sensor');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('11','Effector');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('12','Measured Output');");
		mydb.executeStmt("insert into abstractions(id,annotation) values ('13','Reference Input');");
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

	public void insertAnnotationPackage(String projectName, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into package_annotation(project_name, name, file, annotation, belongs) values"
				+ " ('" + projectName + "','" +   name + "','"  + file + "','" + annotation + "','None');"); 
		mydb.closeConnection();
	}

	public void updateAnnotationPackage(String projectName, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update package_annotation set  annotation= '" + annotation + 
				"' where project_name = '" + projectName + "' and name = '" + name + "';");		
		mydb.closeConnection();
	}

	public void updateBelongPackage(String projectName, String name, String file, String belong) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update package_annotation set  belongs= '" + belong + 
				"' where project_name = '" + projectName + "' and name = '" + name + "';");		
		mydb.closeConnection();
	}

	public List<String> selectAnnotationClass(String projectName, String name, String file) throws Exception {

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select annotation || '|' || belongs from class_annotation  where project_name= '" +
				projectName + "' and name = '" + name + "' and file = '" + file + "';");		
		lst = this.resultSetToArrayList1(rs);
		mydb.closeConnection();
		return lst;
	}

	public void insertAnnotationClass(String projectName, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into class_annotation(project_name, name, file, annotation, belongs) values"
				+ " ('" + projectName + "','" +   name + "','"  + file + "','" + annotation + "','None');"); 
		mydb.closeConnection();
	}

	public void updateAnnotationClass(String projectName, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update class_annotation set  annotation= '" + annotation + 
				"' where project_name = '" + projectName + "' and name = '" + name + "' and file = '" + file + "';");		
		mydb.closeConnection();
	}

	public void updateBelongClass(String projectName, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update class_annotation set  belongs= '" + annotation + 
				"' where project_name = '" + projectName + "' and name = '" + name + "' and file = '" + file + "';");		
		mydb.closeConnection();
	}

	public List<String> selectAnnotationFieldClass(String projectName, String className, String name, String file) throws Exception {

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select annotation || '|' || belongs from field_annotation where project_name= '" +
				projectName + "' and class_name = '" + className + "' and field_name = '" + name + "' and file = '" + file + "';");		
		lst = this.resultSetToArrayList1(rs);
		mydb.closeConnection();
		return lst;
	}

	public void insertAnnotationFieldClass(String projectName, String className, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into field_annotation(project_name, class_name, field_name, file, annotation, belongs) values"
				+ " ('" + projectName + "','" +   className + "','" + name + "','" + file + "','" + annotation + "','None');"); 
		mydb.closeConnection();
	}

	public void updateAnnotationFieldClass(String projectName, String className, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update field_annotation set  annotation= '" + annotation + 
				"' where project_name = '" + projectName + "' and class_name = '" + className + "' and field_name = '" + name + "' and file = '" + file + "';");		
		mydb.closeConnection();
	}

	public void updateBelongFieldClass(String projectName, String className, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update field_annotation set  belongs= '" + annotation + 
				"' where project_name = '" + projectName + "' and class_name = '" + className + "' and field_name = '" + name + "' and file = '" + file + "';");		
		mydb.closeConnection();
	}
	public List<String> selectAnnotationMethod(String projectName, String className, String methodName, String file) throws Exception {

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select annotation || '|' || belongs from method_annotation where project_name= '" +
				projectName + "' and class_name = '" + className + "' and method_name = '" + methodName + "' and file = '" + file + "';");	
		lst = this.resultSetToArrayList1(rs);
		mydb.closeConnection();
		return lst;
	}

	public void insertAnnotationMethod(String projectName, String className, String methodName, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into method_annotation(project_name, class_name, method_name, file, annotation, belongs) values"
				+ " ('" + projectName + "','" +   className + "','" + methodName + "','" + file + "','" + annotation + "','None');"); 
		mydb.closeConnection();
	}

	public void updateAnnotationMethod(String projectName, String className, String methodName, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update method_annotation set  annotation= '" + annotation + 
				"' where project_name = '" + projectName + "' and class_name = '" + className + "' and method_name = '" + methodName + "' and file = '" + file + "';");		
		mydb.closeConnection();
	}

	public void updateBelongMethod(String projectName, String className, String methodName, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update method_annotation set  belongs= '" + annotation + 
				"' where project_name = '" + projectName + "' and class_name = '" + className + "' and method_name = '" + methodName + "' and file = '" + file + "';");		
		mydb.closeConnection();
	}

	public List<String> selectAnnotationVariable(String projectName, String className, String methodName, String name, String file) throws Exception {

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select annotation || '|' || belongs from variable_annotation where project_name= '" +
				projectName + "' and class_name = '" + className + "' and method_name = '" +
				methodName + "' and variable_name = '" + name + "' and file = '" + file + "';");		
		lst = this.resultSetToArrayList1(rs);
		mydb.closeConnection();
		return lst;
	}

	public void insertAnnotationVariable(String projectName, String className, String methodName, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into variable_annotation(project_name, class_name, method_name, variable_name, file, annotation, belongs) values"
				+ " ('" + projectName + "','" +   className + "','" + methodName + "','" + name + "','" + file + "','" + annotation + "','None');"); 
		mydb.closeConnection();
	}

	public void updateAnnotationVariable(String projectName, String className, String methodName, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update variable_annotation set  annotation= '" + annotation + 
				"' where project_name = '" + projectName + "' and class_name = '" + 
				className + "' and method_name = '" + methodName + "' and variable_name = '" +
				name + "' and file = '" + file + "';");		
		mydb.closeConnection();
	}

	public void updateBelongVariable(String projectName, String className, String methodName, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update variable_annotation set  belongs= '" + annotation + 
				"' where project_name = '" + projectName + "' and class_name = '" + 
				className + "' and method_name = '" + methodName + "' and variable_name = '" +
				name + "' and file = '" + file + "';");		
		mydb.closeConnection();
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