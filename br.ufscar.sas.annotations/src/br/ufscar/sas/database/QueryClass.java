package br.ufscar.sas.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.ufscar.sas.model.CodeClass;
import br.ufscar.sas.model.CodeField;
import br.ufscar.sas.model.CodeMethod;
import br.ufscar.sas.model.CodePackage;
import br.ufscar.sas.model.CodeVariable;

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
		mydb.executeStmt("create table IF NOT EXISTS class_annotation (project_name text, package_name text, name text, file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS interface_annotation (project_name text, package_name text, name text, file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS field_annotation (project_name text, class_name text, field_name text, file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS method_annotation (project_name text, class_name text, method_name text,file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS variable_annotation (project_name text, class_name text, method_name text, variable_name, file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS abstraction_type (id integer primary key, type text)");
		mydb.executeStmt("create table IF NOT EXISTS abstractions (id integer primary key, annotation text, abstraction_type integer, FOREIGN KEY(abstraction_type) REFERENCES abstraction_type(id)) ");
		mydb.executeStmt("create table IF NOT EXISTS generic_abstractions (id integer primary key, annotation text, abstraction_type integer, FOREIGN KEY(abstraction_type) REFERENCES abstraction_type(id)) ");
		mydb.executeStmt("create table IF NOT EXISTS instances (abstraction_id integer, annotation text, FOREIGN KEY(abstraction_id) REFERENCES abstractions(id)) ");
		mydb.executeStmt("create table IF NOT EXISTS generic_instances (abstraction_id integer, annotation text, FOREIGN KEY(abstraction_id) REFERENCES generic_abstractions(id)) ");
		mydb.executeStmt("create table IF NOT EXISTS domain_rules(abstraction1 text, access_type text, abstraction2 text, switch text)");
		mydb.executeStmt("delete from abstractions");
		mydb.executeStmt("delete from generic_abstractions");
		mydb.executeStmt("delete from abstraction_type"); 
		mydb.closeConnection();
	}

	public void populateAbstractions() throws SQLException, Exception
	{
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into abstraction_type(id,type) values ('1','Adaptive System');");
		mydb.executeStmt("insert into abstraction_type(id,type) values ('2','Generic');");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('1','Managed',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('2','Managing',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('3','LoopManager',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('4','Loop',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('5','Monitor',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('6','Analyzer',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('7','Planner',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('8','Executor',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('9','Knowledge',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('10','Sensor',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('11','Effector',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('12','MeasuredOutput',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('13','ReferenceInput',1);");
		mydb.executeStmt("insert into abstractions(id,annotation,abstraction_type) values ('14','Alternative',1);");
		mydb.executeStmt("insert into generic_abstractions(id,annotation,abstraction_type) values ('1','subSystem',2);");
		mydb.executeStmt("insert into generic_abstractions(id,annotation,abstraction_type) values ('2','component',2);");
		mydb.executeStmt("insert into generic_abstractions(id,annotation,abstraction_type) values ('3','layer',2);");
		mydb.executeStmt("insert into generic_abstractions(id,annotation,abstraction_type) values ('4','module',2);");
		mydb.executeStmt("insert into generic_abstractions(id,annotation,abstraction_type) values ('5','interface',2);");
		mydb.closeConnection();
	}

	public void populateDomainRules() throws SQLException, Exception
	{
		SqliteDb mydb = new SqliteDb(dbDriver,url);                  
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Monitor', '\u219B','Planner', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Monitor', '\u219B','Executor', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Analyzer', '\u219B','Monitor', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Analyzer', '\u219B','Executor', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Planner', '\u219B','Monitor', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Planner', '\u219B','Analyzer', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Executor', '\u219B','Monitor', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Executor', '\u219B','Analyzer', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Executor', '\u219B','Planner', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Knowledge', '\u219B','Monitor', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Knowledge', '\u219B','Analyzer', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Knowledge', '\u219B','Planner', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Knowledge', '\u219B','Executor', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Monitor', '\u2192','Analyzer', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Monitor', '\u2192','Knowledge', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Analyzer', '\u2192','Planner', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Analyzer', '\u2192','Knowledge', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Planner', '\u2192','Executor', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Planner', '\u2192','Knowledge', 'true');");
		mydb.executeStmt("insert into domain_rules(abstraction1, access_type, abstraction2, switch) values ('Executor', '\u2192','Knowledge', 'true');");
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

	public void insertAnnotationClass(String projectName, String package_name ,String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into class_annotation(project_name, package_name, name, file, annotation, belongs) values"
				+ " ('" + projectName + "','" +  package_name + "','" +   name + "','"  + file + "','" + annotation + "','None');"); 
		mydb.closeConnection();
	}

	public void updateAnnotationClass(String projectName, String package_name, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update class_annotation set  annotation= '" + annotation + 
				"' where project_name = '" + projectName + "' and package_name = '" + package_name + "' and name = '" + name + "' and file = '" + file + "';");		
		mydb.closeConnection();
	}

	public void updateBelongClass(String projectName, String package_name, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update class_annotation set  belongs= '" + annotation + 
				"' where project_name = '" + projectName + "' and package_name = '" + package_name + "' and name = '" + name + "' and file = '" + file + "';");		
		mydb.closeConnection();
	}

	public List<String> selectAnnotationInterface(String projectName, String name, String file) throws Exception {

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select annotation || '|' || belongs from interface_annotation  where project_name= '" +
				projectName + "' and name = '" + name + "' and file = '" + file + "';");		
		lst = this.resultSetToArrayList1(rs);
		mydb.closeConnection();
		return lst;
	}

	public void insertAnnotationInterface(String projectName, String package_name ,String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into interface_annotation(project_name, package_name, name, file, annotation, belongs) values"
				+ " ('" + projectName + "','" +  package_name + "','" +   name + "','"  + file + "','" + annotation + "','None');"); 
		mydb.closeConnection();
	}

	public void updateAnnotationInterface(String projectName, String package_name, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update interface_annotation set  annotation= '" + annotation + 
				"' where project_name = '" + projectName + "' and package_name = '" + package_name + "' and name = '" + name + "' and file = '" + file + "';");		
		mydb.closeConnection();
	}

	public void updateBelongInterface(String projectName, String package_name, String name, String file, String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update interface_annotation set  belongs= '" + annotation + 
				"' where project_name = '" + projectName + "' and package_name = '" + package_name + "' and name = '" + name + "' and file = '" + file + "';");		
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

	public void updateRuleState(int id, boolean value) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update domain_rules set switch= '" + value + "' where rowid = '" + id + "';");		
		mydb.closeConnection();
	}

	public List<CodePackage> getPackageAnnotations() throws Exception
	{
		List<CodePackage> lst = new ArrayList<CodePackage>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select a.project_name, a.name, a.file, a.annotation, b.abstraction_id "
				+ "from package_annotation a inner join instances b on a.annotation = b.annotation;\n" + 
				" ;");		
		while (rs.next()) {

			String packages[] = rs.getObject(2).toString().split(Pattern.quote("."));
			CodePackage codePackage = new CodePackage(rs.getObject(1).toString(), 
					rs.getObject(2).toString(),
					packages[packages.length-1], 
					rs.getObject(4).toString(),
					(Integer) rs.getObject(5));


			lst.add(codePackage);
		}
		mydb.closeConnection();
		return lst;
	}

	public List<CodeClass> getClassAnnotations() throws Exception
	{
		List<CodeClass> lst = new ArrayList<CodeClass>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select a.project_name, a.package_name, a.name, a.file, a.annotation, a.belongs, b.abstraction_id "
				+ "from class_annotation a inner join instances b on a.annotation = b.annotation;\n");		
		while (rs.next()) {

			CodeClass codeClass = new CodeClass(rs.getObject(1).toString(),
					rs.getObject(2).toString(),
					rs.getObject(3).toString(),
					rs.getObject(5).toString(),
					(Integer) rs.getObject(7));

			lst.add(codeClass);
		}
		mydb.closeConnection();
		return lst;
	}

	public List<CodeClass> getInterfaceAnnotations() throws Exception
	{
		List<CodeClass> lst = new ArrayList<CodeClass>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select a.project_name, a.package_name, a.name, a.file, a.annotation, a.belongs, b.abstraction_id "
				+ "from interface_annotation a inner join instances b on a.annotation = b.annotation;\n");		
		while (rs.next()) {

			CodeClass codeClass = new CodeClass(rs.getObject(1).toString(),
					rs.getObject(2).toString(),
					rs.getObject(3).toString(),
					rs.getObject(5).toString(),
					(Integer) rs.getObject(7));

			lst.add(codeClass);
		}
		mydb.closeConnection();
		return lst;
	}

	public List<CodeField> getFieldClassAnnotations() throws Exception
	{
		List<CodeField> lst = new ArrayList<CodeField>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select a.project_name, a.class_name, a.field_name, a.file, a.annotation, a.belongs, b.abstraction_id "
				+ "from field_annotation a inner join instances b on a.annotation = b.annotation;\n" );		
		while (rs.next()) {

			String packages = rs.getObject(4).toString().split("\\/src/")[1];
			String packageCode[] = packages.split("\\/");
			String fieldPath = "";
			for (int i=0; i<packageCode.length-1; i++)
			{
				if (i==0)
					fieldPath = fieldPath + packageCode[i] ;
				else 
					fieldPath = fieldPath + "." + packageCode[i] ;
			}

			CodeField codeField = new CodeField(rs.getObject(1).toString(),
					fieldPath, 
					rs.getObject(2).toString(), 
					rs.getObject(3).toString(), 
					rs.getObject(5).toString(), 
					(Integer) rs.getObject(7));
			lst.add(codeField);
		}
		mydb.closeConnection();
		return lst;
	}

	public List<CodeMethod> getMethodAnnotations() throws Exception
	{
		List<CodeMethod> lst = new ArrayList<CodeMethod>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select a.project_name, a.class_name, a.method_name, a.file, a.annotation, a.belongs, b.abstraction_id "
				+ "from method_annotation a inner join instances b on a.annotation = b.annotation;\n");		
		while (rs.next()) {

			String packages = rs.getObject(4).toString().split("\\/src/")[1];
			String packageCode[] = packages.split("\\/");
			String fieldPath = "";
			for (int i=0; i<packageCode.length-1; i++)
			{
				if (i==0)
					fieldPath = fieldPath + packageCode[i] ;
				else 
					fieldPath = fieldPath + "." + packageCode[i] ;
			}

			CodeMethod codeMethod = new CodeMethod(rs.getObject(1).toString(),
					fieldPath, 
					rs.getObject(2).toString(), 
					rs.getObject(3).toString(), 
					rs.getObject(5).toString(), 
					(Integer) rs.getObject(7));
			lst.add(codeMethod);
		}
		mydb.closeConnection();
		return lst;
	}

	public List<CodeVariable> getVariableAnnotations() throws Exception
	{
		List<CodeVariable> lst = new ArrayList<CodeVariable>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select a.project_name, a.class_name, a.method_name, a.variable_name, a.file, a.annotation, a.belongs, b.abstraction_id "
				+ "from variable_annotation a inner join instances b on a.annotation = b.annotation;");		
		while (rs.next()) {

			String packages = rs.getObject(5).toString().split("\\/src/")[1];
			String packageCode[] = packages.split("\\/");
			String fieldPath = "";
			for (int i=0; i<packageCode.length-1; i++)
			{
				if (i==0)
					fieldPath = fieldPath + packageCode[i] ;
				else 
					fieldPath = fieldPath + "." + packageCode[i] ;
			}

			CodeVariable codeVariable = new CodeVariable(rs.getObject(1).toString(),
					fieldPath, rs.getObject(2).toString(),
					rs.getObject(3).toString(), 
					rs.getObject(4).toString(), 
					rs.getObject(6).toString(), 
					(Integer) rs.getObject(8));
			lst.add(codeVariable);
		}
		mydb.closeConnection();
		return lst;
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
	
	public String selectGenericAbstraction (String abstraction, String instance) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select id from generic_abstractions where annotation= '" + abstraction + "';");	
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

	public void insertGenericInstance(String abstraction, String instance) throws Exception {

		String value = this.selectGenericAbstraction(abstraction, instance);
		if (!value.equals(""))
		{
			SqliteDb mydb = new SqliteDb(dbDriver,url);
			mydb.executeStmt("insert into generic_instances (abstraction_id, annotation) values"
					+ " ('" + value + "','" +   instance + "');"); 
			mydb.closeConnection();
		}
	}

	public void deleteInstance() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("delete from instances;"); 
		mydb.closeConnection();
	}

	public void deleteGenericInstance() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("delete from generic_instances;"); 
		mydb.closeConnection();
	}

	public String selectAbstractionByInstance(String annotation) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);

		ResultSet rs = null;
		rs = mydb.executeQry("select a.annotation "
				+ "from abstractions a inner join instances b "
				+ "where b.abstraction_id = a.id and b.annotation='"+ annotation + "';");

		while (rs.next())
			return rs.getObject(1).toString();

		return null;
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
			else
			{

				if (op == 0)
				{
					rs = mydb.executeQry("select abstraction_id, annotation from instances order by annotation;");
					while (rs.next())
						lst.add(rs.getObject(1).toString() + "|" + rs.getObject(2).toString());
				}
			}
		}
		mydb.closeConnection();
		return lst;
	}

	public List<String> selectGenericInstance() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		List<String> lst = new ArrayList<String>();
		ResultSet rs = mydb.executeQry("select b.annotation "
				+ "from generic_abstractions a inner join generic_instances b on "
				+ "a.id = b.abstraction_id "
				+ "order by a.id;");

		while (rs.next())
			lst.add(rs.getObject(1).toString());

		lst.add(0,"None");

		mydb.closeConnection();
		return lst;
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
				"select (annotation || '|' || belongs) A from interface_annotation where annotation <> 'None' " +
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

	public void variableBelongsTo() throws Exception {

		List<String> values = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select DISTINCT A.*, \n" + 
				"       ifnull(METHOD.annotation,'None') As Method, \n" + 
				"       ifnull(CLASS.annotation,'None') As Class, \n" + 
				"       ifnull(PACKAGE.annotation,'None') As Package\n" + 
				"from variable_annotation A \n" + 
				"left join method_annotation METHOD on METHOD.project_name = A.project_name  AND\n" + 
				"                                      METHOD.class_name  =  A.class_name   AND\n" + 
				"                                      METHOD.method_name =  A.method_name  AND\n" + 
				"                                      METHOD.file  = A.file \n" + 
				"left join class_annotation CLASS on CLASS.project_name = A.project_name  AND\n" + 
				"                                                  CLASS.name =  A.class_name  AND\n" + 
				"                                                  CLASS.file =  A.file\n" + 
				"left join package_annotation PACKAGE on PACKAGE.project_name = A.project_name  AND\n" + 
				"                                                        REPLACE(A.file,'/','.') like '%' || PACKAGE.name || '%';\n" + 
				"                  ");		

		while (rs.next()) 
			values.add(rs.getObject(1).toString() + "|" + rs.getObject(2).toString() + "|" + rs.getObject(3).toString()+ "|" + rs.getObject(4).toString()+ "|" + rs.getObject(5).toString()+ "|" + 
					rs.getObject(8).toString()+ "|" + rs.getObject(9).toString()+ "|" + rs.getObject(10).toString());


		for (String line: values) {
			if (!line.split(Pattern.quote("|"))[5].equals("None")) {
				mydb.executeStmt("update variable_annotation set belongs= '" + line.split(Pattern.quote("|"))[5] + 
						"' where project_name = '" + line.split(Pattern.quote("|"))[0] + "' and class_name = '" + line.split(Pattern.quote("|"))[1] + "' and method_name = '" + line.split(Pattern.quote("|"))[2] + "' and variable_name = '" + line.split(Pattern.quote("|"))[3] + "' and file = '" + line.split(Pattern.quote("|"))[4] +"';");
			}
			else {
				if (!line.split(Pattern.quote("|"))[6].equals("None")) {
					mydb.executeStmt("update variable_annotation set belongs= '" + line.split(Pattern.quote("|"))[6] + 
							"' where project_name = '" + line.split(Pattern.quote("|"))[0] + "' and class_name = '" + line.split(Pattern.quote("|"))[1] + "' and method_name = '" + line.split(Pattern.quote("|"))[2] + "' and variable_name = '" + line.split(Pattern.quote("|"))[3] + "' and file = '" + line.split(Pattern.quote("|"))[4] +"';");		
				}
				else {
					if (!line.split(Pattern.quote("|"))[7].equals("None")) {
						mydb.executeStmt("update variable_annotation set belongs= '" + line.split(Pattern.quote("|"))[7] + 
								"' where project_name = '" + line.split(Pattern.quote("|"))[0] + "' and class_name = '" + line.split(Pattern.quote("|"))[1] + "' and method_name = '" + line.split(Pattern.quote("|"))[2] + "' and variable_name = '" + line.split(Pattern.quote("|"))[3] + "' and file = '" + line.split(Pattern.quote("|"))[4] +"';");		
					}
				}
			}
		}

		mydb.closeConnection();
	}

	public void fieldBelongsTo() throws Exception {

		List<String> values = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select DISTINCT A.*, \n" + 
				"       ifnull(CLASS.annotation,'None') As Class, \n" + 
				"       ifnull(INTER.annotation,'None') As Interface, \n" + 
				"       ifnull(PACKAGE.annotation,'None') As Package\n" + 
				"from field_annotation A \n" + 
				"left join class_annotation CLASS on CLASS.project_name = A.project_name AND\n" + 
				"                                                             CLASS.name =  A.class_name AND\n" + 
				"                                                             CLASS.file = A.file \n" + 
				"left join interface_annotation INTER on INTER.project_name = A.project_name AND\n" + 
				"                                                             INTER.name =  A.class_name AND\n" + 
				"                                                             INTER.file = A.file \n" + 
				"left join package_annotation PACKAGE on PACKAGE.project_name = A.project_name  AND\n" + 
				"                                                        REPLACE(A.file,'/','.') like '%' || PACKAGE.name || '%';");		
		while (rs.next()) 
			values.add(rs.getObject(1).toString() + "|" + rs.getObject(2).toString() +"|" + rs.getObject(3).toString() + "|" + 
					rs.getObject(4).toString() + "|"+ rs.getObject(7).toString() + "|" + rs.getObject(8).toString()+ "|" + rs.getObject(9).toString());

		for (String line: values)
		{
			if (!line.split(Pattern.quote("|"))[4].equals("None")) {

				mydb.executeStmt("update field_annotation set belongs= '" + line.split(Pattern.quote("|"))[4] + 
						"' where project_name = '" + line.split(Pattern.quote("|"))[0] + "' and class_name = '" + line.split(Pattern.quote("|"))[1] + "' and field_name = '" + line.split(Pattern.quote("|"))[2] + "' and file = '" + line.split(Pattern.quote("|"))[3] +"';");		
			}
			else {
				if (!line.split(Pattern.quote("|"))[5].equals("None")) {

					mydb.executeStmt("update field_annotation set belongs= '" + line.split(Pattern.quote("|"))[5] + 
							"' where project_name = '" + line.split(Pattern.quote("|"))[0] + "' and class_name = '" + line.split(Pattern.quote("|"))[1] + "' and field_name = '" + line.split(Pattern.quote("|"))[2] + "' and file = '" + line.split(Pattern.quote("|"))[3] +"';");		
				}
				else {
					if (!line.split(Pattern.quote("|"))[6].equals("None")) {

						mydb.executeStmt("update field_annotation set belongs= '" + line.split(Pattern.quote("|"))[6] + 
								"' where project_name = '" + line.split(Pattern.quote("|"))[0] + "' and class_name = '" + line.split(Pattern.quote("|"))[1] + "' and field_name = '" + line.split(Pattern.quote("|"))[2] + "' and file = '" + line.split(Pattern.quote("|"))[3] +"';");		
					}
				}
			}
		}


		mydb.closeConnection();
	}

	public void methodBelongsTo() throws Exception {

		List<String> values = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select DISTINCT A.*, \n" + 
				"       ifnull(CLASS.annotation,'None') As Class, \n" + 
				"       ifnull(INTER.annotation,'None') As Interface, \n" + 
				"       ifnull(PACKAGE.annotation,'None') As Package\n" + 
				"from method_annotation A \n" + 
				"left join class_annotation CLASS on CLASS.project_name = A.project_name  AND\n" + 
				"                                                         CLASS.name  = A.class_name AND\n" + 
				"                                                         CLASS.file  = A.file \n" + 
				"left join interface_annotation INTER on INTER.project_name = A.project_name  AND\n" + 
				"                                                         INTER.name  = A.class_name AND\n" + 
				"                                                         INTER.file  = A.file \n" + 
				"left join package_annotation PACKAGE on PACKAGE.project_name = A.project_name  AND\n" + 
				"                                                        REPLACE(A.file,'/','.') like '%' || PACKAGE.name || '%';");		
		while (rs.next()) 
			values.add(rs.getObject(1).toString() + "|" + rs.getObject(2).toString() +"|" + rs.getObject(3).toString() + "|" 
					+ rs.getObject(4).toString() + "|"+ rs.getObject(7).toString() + "|" + rs.getObject(8).toString() +  "|" + rs.getObject(9).toString());


		for (String line: values)
		{

			if (!line.split(Pattern.quote("|"))[4].equals("None")) {

				mydb.executeStmt("update method_annotation set belongs= '" + line.split(Pattern.quote("|"))[4] + 
						"' where project_name = '" + line.split(Pattern.quote("|"))[0] + "' and class_name = '" + line.split(Pattern.quote("|"))[1] + "' and method_name = '" + line.split(Pattern.quote("|"))[2] + "' and file = '" + line.split(Pattern.quote("|"))[3] +"';");		
			}
			else {
				if (!line.split(Pattern.quote("|"))[5].equals("None")) {

					mydb.executeStmt("update method_annotation set belongs= '" + line.split(Pattern.quote("|"))[5] + 
							"' where project_name = '" + line.split(Pattern.quote("|"))[0] + "' and class_name = '" + line.split(Pattern.quote("|"))[1] + "' and method_name = '" + line.split(Pattern.quote("|"))[2] + "' and file = '" + line.split(Pattern.quote("|"))[3] +"';");		
				}
				else
				{
					if (!line.split(Pattern.quote("|"))[6].equals("None")) {

						mydb.executeStmt("update method_annotation set belongs= '" + line.split(Pattern.quote("|"))[6] + 
								"' where project_name = '" + line.split(Pattern.quote("|"))[0] + "' and class_name = '" + line.split(Pattern.quote("|"))[1] + "' and method_name = '" + line.split(Pattern.quote("|"))[2] + "' and file = '" + line.split(Pattern.quote("|"))[3] +"';");		
					}
				}
			}
		}

		mydb.closeConnection();
	} 

	public void classBelongsTo() throws Exception {

		List<String> values = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select A.*, \n" + 
				"       ifnull(PACKAGE.annotation,'None') As Package\n" + 
				"from class_annotation A \n" + 
				"left join package_annotation PACKAGE on PACKAGE.project_name = A.project_name  AND\n" + 
				"                                        PACKAGE.name = A.package_name;");

		while (rs.next()) 
			values.add(rs.getObject(1).toString()+ "|" + rs.getObject(2).toString() + "|" + rs.getObject(3).toString() + "|" +rs.getObject(7).toString());


		for (String line: values)
		{
			if (!line.split(Pattern.quote("|"))[3].equals("None")) {

				mydb.executeStmt("update class_annotation set belongs= '" + line.split(Pattern.quote("|"))[3] + 
						"' where project_name = '" + line.split(Pattern.quote("|"))[0] + "' and name = '" + line.split(Pattern.quote("|"))[2] + "' and package_name = '" + line.split(Pattern.quote("|"))[1] +"';");		
			}
		}

		mydb.closeConnection();
	}

	public void interfaceBelongsTo() throws Exception {

		List<String> values = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select A.*, \n" + 
				"       ifnull(PACKAGE.annotation,'None') As Package\n" + 
				"from interface_annotation A \n" + 
				"left join package_annotation PACKAGE on PACKAGE.project_name = A.project_name  AND\n" + 
				"                                        PACKAGE.name = A.package_name;");

		while (rs.next()) 
			values.add(rs.getObject(1).toString()+ "|" + rs.getObject(2).toString() + "|" + rs.getObject(3).toString() + "|" +rs.getObject(7).toString());


		for (String line: values)
		{
			if (!line.split(Pattern.quote("|"))[3].equals("None")) {

				mydb.executeStmt("update interface_annotation set belongs= '" + line.split(Pattern.quote("|"))[3] + 
						"' where project_name = '" + line.split(Pattern.quote("|"))[0] + "' and name = '" + line.split(Pattern.quote("|"))[2] + "' and package_name = '" + line.split(Pattern.quote("|"))[1] +"';");		
			}
		}

		mydb.closeConnection();
	}

	public List<String> getDomainRules() throws Exception{

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select rowid, abstraction1, access_type, abstraction2, switch from domain_rules;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString()+"|"+rs.getObject(4).toString()+"|"+rs.getObject(5).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	public List<String> ruleIsActive(String abstraction1, String abstraction2) throws Exception {

		List<String> lstRule = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select rowid, switch from domain_rules where abstraction1='" + abstraction1 + "' and abstraction2='" + abstraction2 + "' ;");	
		while (rs.next()) {
			lstRule.add(String.valueOf(rs.getObject(1)));
			lstRule.add((String) rs.getObject(2));
		}
		mydb.closeConnection();
		return lstRule;
	}

	public String getRuleIsActiveForGeneration(String abstraction1, int access, String abstraction2) throws Exception {

		String isActive = "false";
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select switch from domain_rules where abstraction1='" + abstraction1 + "' and unicode(access_type)=" + access + " and abstraction2='" + abstraction2 + "' ;");	
		while (rs.next()) {
			isActive = String.valueOf(rs.getObject(1));
		}
		mydb.closeConnection();
		return isActive;


	}

	public int getInnerAnnotationClass(String package_name, String class_name, String path , String annotation) throws Exception{

		int max = 0;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry(" select sum(cantidad)\n" + 
				"from (\n" + 
				"select count(*) as cantidad\n" + 
				"from package_annotation a where a.name = '" + package_name + "' and a.annotation = '" + annotation + "' and a.annotation <> 'None' \n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad \n" + 
				"from field_annotation a where a.file = '" +  path +"'  and a.class_name = '" +  class_name +"' and a.annotation = '" + annotation + "' and a.annotation <> 'None' \n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad\n" + 
				"from method_annotation a where a.file = '" +  path +"' and a.class_name = '" +  class_name +"' and a.annotation = '" + annotation + "' and a.annotation <> 'None' \n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad\n" + 
				"from variable_annotation a where a.file = '" +  path +"' and a.class_name = '" +  class_name +"' and a.annotation = '" + annotation + "' and a.annotation <> 'None' \n" + 
				");");	
		while (rs.next()) {
			max = Integer.valueOf(String.valueOf(rs.getObject(1)));
		}
		mydb.closeConnection();
		return max;
	}

	public int getInnerAnnotationInterface(String package_name, String class_name, String path , String annotation) throws Exception{

		int max = 0;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry(" select sum(cantidad)\n" + 
				"from (\n" + 
				"select count(*) as cantidad\n" + 
				"from package_annotation a where a.name = '" + package_name + "' and a.annotation = '" + annotation + "' and a.annotation <> 'None' \n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad \n" + 
				"from field_annotation a where a.file = '" +  path +"'  and a.class_name = '" +  class_name +"' and a.annotation = '" + annotation + "' and a.annotation <> 'None' \n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad\n" + 
				"from method_annotation a where a.file = '" +  path +"' and a.class_name = '" +  class_name +"' and a.annotation = '" + annotation + "' and a.annotation <> 'None' \n" + 
				");");	
		while (rs.next()) {
			max = Integer.valueOf(String.valueOf(rs.getObject(1)));
		}
		mydb.closeConnection();
		return max;
	}

	public int getInnerAnnotationMethod(String class_name, String method_name, String newRealPath, String path , String annotation) throws Exception{

		int max = 0;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry(" select sum(cantidad)\n" + 
				"from (\n" + 
				"select count(*) as cantidad from (\n" + 
				"select substr(file, 1, (select length(file) from package_annotation where file='" + newRealPath + "' and annotation <> 'None' and annotation = '" + annotation + "')) as method_file\n" + 
				"from method_annotation where method_name = '" + method_name + "') a inner join package_annotation b on a.method_file = b.file \n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad\n" + 
				"from class_annotation a inner join method_annotation b on a.name = b.class_name \n" + 
				"where a.annotation = '" + annotation + "' and a.annotation <> 'None' and a.name = '" + class_name + "' and b.method_name = '" + method_name + "' and a.file = '" + path + "' " + 
				"UNION ALL\n" + 
				"select count(*) as cantidad\n" + 
				"from variable_annotation a where a.annotation = '" + annotation + "' and a.annotation <> 'None' and a.method_name = '" + method_name + "' and a.file = '" + path  +"');");	
		while (rs.next()) {
			max = Integer.valueOf(String.valueOf(rs.getObject(1)));
		}
		mydb.closeConnection();
		return max;
	}

	public int getInnerAnnotationField(String class_name, String field_name, String newRealPath, String path , String annotation) throws Exception{

		int max = 0;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry(" select sum(cantidad)\n" + 
				"from (\n" + 
				"select count(*) as cantidad from (\n" + 
				"select substr(file, 1, (select length(file) from package_annotation where file='"+ newRealPath + "' and annotation <> 'None' and annotation = '" + annotation +"')) as field_file\n" + 
				"from field_annotation where field_name = '"+ field_name +"') a inner join package_annotation b on a.field_file = b.file \n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad\n" + 
				"from class_annotation a inner join field_annotation b on a.name = b.class_name \n" + 
				"where a.annotation = '" + annotation + "' and a.annotation <> 'None' and a.name = '" + class_name + "' and b.field_name = '" + field_name + "' and a.file = '" + path +"');");	
		while (rs.next()) {
			max = Integer.valueOf(String.valueOf(rs.getObject(1)));
		}
		mydb.closeConnection();
		return max;
	}

	public int getInnerAnnotationVariable(String class_name, String method_name, String variable_name, String newRealPath, String path , String annotation) throws Exception{

		int max = 0;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select sum(cantidad)\n" + 
				"from (\n" + 
				"select count(*) as cantidad from (\n" + 
				"select substr(file, 1, (select length(file) from package_annotation where file='"+ newRealPath +"' and annotation <> 'None' and annotation = '" + annotation +"')) as variable_file\n" + 
				"from variable_annotation where variable_name = '"+ variable_name + "') a inner join package_annotation b on a.variable_file = b.file\n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad\n" + 
				"from class_annotation a inner join variable_annotation b on a.name = b.class_name \n" + 
				"where a.annotation = '" + annotation +"' and a.annotation <> 'None' and a.name = '" + class_name + "' and b.variable_name = '" + variable_name + "' and a.file = '" +  path + "'\n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad\n" + 
				"from method_annotation a where a.method_name = '" + method_name +"' and a.annotation <> 'None' and a.file = '" + path +"');");	
		while (rs.next()) {
			max = Integer.valueOf(String.valueOf(rs.getObject(1)));
		}
		mydb.closeConnection();
		return max;
	}

	public int getInnerAnnotationPackage(String package_name, String annotation) throws Exception{

		int max = 0;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry(" select sum(cantidad)\n" + 
				"from (\n" + 
				"select count(*) as cantidad from (\n" + 
				"select annotation, substr(file, 1, (select length(file) from package_annotation where name='" + package_name +"')) as field_file\n" + 
				"from field_annotation) a inner join package_annotation b on a.field_file = b.file where a.annotation = '" + annotation + "' and a.annotation <> 'None' \n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad from (\n" + 
				"select annotation, substr(file, 1, (select length(file) from package_annotation where name='" + package_name +"')) as class_file\n" + 
				"from class_annotation) a inner join package_annotation b on a.class_file = b.file where a.annotation = '" + annotation + "' and a.annotation <> 'None' \n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad from (\n" + 
				"select annotation, substr(file, 1, (select length(file) from package_annotation where name='" + package_name +"')) as method_file\n" + 
				"from method_annotation) a inner join package_annotation b on a.method_file = b.file where a.annotation = '"+ annotation + "' and a.annotation <> 'None' \n" + 
				"UNION ALL\n" + 
				"select count(*) as cantidad from (\n" + 
				"select annotation, substr(file, 1, (select length(file) from package_annotation where name='" + package_name +"')) as variable_file\n" + 
				"from variable_annotation) a inner join package_annotation b on a.variable_file = b.file where a.annotation = '" + annotation + "' and a.annotation <> 'None');");	
		while (rs.next()) {
			max = Integer.valueOf(String.valueOf(rs.getObject(1)));
		}
		mydb.closeConnection();
		return max;
	}

	public void deleteBelongsTo() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update package_annotation set belongs='None';");	
		mydb.executeStmt("update class_annotation set belongs='None';");	
		mydb.executeStmt("update interface_annotation set belongs='None';");	
		mydb.executeStmt("update field_annotation set belongs='None';");	
		mydb.executeStmt("update method_annotation set belongs='None';");	
		mydb.executeStmt("update variable_annotation set belongs='None';");		
		mydb.closeConnection();
	}

}