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
		mydb.executeStmt("create table IF NOT EXISTS field_annotation (project_name text, class_name text, field_name text, file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS method_annotation (project_name text, class_name text, method_name text,file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS variable_annotation (project_name text, class_name text, method_name text, variable_name, file text, annotation text, belongs text) ");
		mydb.executeStmt("create table IF NOT EXISTS abstractions (id integer primary key, annotation text, quantity integer) ");
		mydb.executeStmt("create table IF NOT EXISTS instances (abstraction_id integer, annotation text, FOREIGN KEY(abstraction_id) REFERENCES abstractions(id)) ");
		mydb.executeStmt("create table IF NOT EXISTS relation (package_from text, class_from text, field_from text, method_from text, variable_from text, "
				+ "package_to text, class_to text, field_to text, method_to text, variable_to text, modisco_path text, type_relation text) ");
		mydb.executeStmt("create table IF NOT EXISTS domain_rules(abstraction1 text, access_type text, abstraction2 text, switch text)");
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

		mydb.executeStmt("CREATE VIEW IF NOT EXISTS relation_class (abstraction_from, from_, abstraction_to, to_, modisco_path)\n" + 
				"AS \n" + 
				"select abstraction1, package_from || '.' ||  class_from, abstraction2, package_to || '.' ||class_to, a.modisco_path  \n" + 
				"from (\n" + 
				"        select DISTINCT (select annotation from summary_annotation where class = a.class_from) abstraction1,\n" + 
				"			           a.package_from, \n" + 
				"			           a.class_from, \n" + 
				"			           (select annotation from summary_annotation where class = a.class_to) abstraction2,\n" + 
				"				           a.package_to, \n" + 
				"				           a.class_to,\n" + 
				"				           a.modisco_path\n" + 
				"				    from relation a inner join summary_annotation  b on  a.class_to = b.class                                                 \n" + 
				"				    where a.class_from <> a.class_to \n" + 
				"				    ) a\n" + 
				"where a.class_from in (select class from summary_annotation)\n" + 
				"Order by abstraction1;");
		mydb.executeStmt("CREATE VIEW IF NOT EXISTS relation_method (abstraction_from, from_, abstraction_to, to_, modisco_path) AS \n" + 
				"select abstraction1, package_from || '.' ||  class_from || '.' || method_from , abstraction2, package_to || '.' ||class_to || '.' || method_to, modisco_path  \n" + 
				"from ( 				\n" + 
				"select DISTINCT (select annotation \n" + 
				"                 from summary_annotation \n" + 
				"                 where class = a.class_from and\n" + 
				"                       package = a.package_from) abstraction1,  \n" + 
				"                    a.package_from,   \n" + 
				"					a.class_from,\n" + 
				"					a.field_from,\n" + 
				"					a.method_from,\n" + 
				"					a.variable_from,\n" + 
				"					(select annotation \n" + 
				"					 from summary_annotation \n" + 
				"					 where method = a.method_to and \n" + 
				"                           class = a.class_to and\n" + 
				"                           package = a.package_to) abstraction2,  \n" + 
				"                    a.package_to,   \n" + 
				"					a.class_to, \n" + 
				"					a.field_to,\n" + 
				"					a.method_to,\n" + 
				"					'',\n" + 
				"					a.modisco_path  \n" + 
				"from relation a inner join summary_annotation  b on  a.method_to = b.method and\n" + 
				"                                                     a.class_to = b.class and\n" + 
				"                                                     a.package_to = b.package\n" + 
				"where abstraction1 <> abstraction2\n" + 
				");");
		mydb.executeStmt("create table IF NOT EXISTS summary_annotation(package text,class text, field text ,method text,variable text,annotation text) ");	
		mydb.executeStmt("delete from abstractions"); 
		mydb.executeStmt("delete from relation"); 
		mydb.executeStmt("delete from summary_annotation"); 
		mydb.closeConnection();
	}

	public void populateAbstractions() throws SQLException, Exception
	{
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('1','Managed', 0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('2','Managing',0 );");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('3','LoopManager',0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('4','Loop',0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('5','Monitor',0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('6','Analyzer',0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('7','Planner',0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('8','Executor',0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('9','Knowledge',0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('10','Sensor',0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('11','Effector',0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('12','MeasuredOutput',0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('13','ReferenceInput',0);");
		mydb.executeStmt("insert into abstractions(id,annotation,quantity) values ('14','Alternative',0);");
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

	public List<String> getAbstractions() throws Exception {

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select c.id, c.annotation, ifnull(d.quantity,c.quantity), c.quantity \n" + 
				"from abstractions c left join \n" + 
				"\n" + 
				"    (\n" + 
				"        select (select annotation \n" + 
				"                from abstractions \n" + 
				"                where id = a.abstraction_id) as annotation, \n" + 
				"            count(*) as quantity\n" + 
				"        from instances a left join abstractions b on a.abstraction_id  = b.id \n" + 
				"        group by a.abstraction_id \n" + 
				"    ) d\n" + 
				"    on c.annotation = d.annotation\n" + 
				"order by c.id;");
		while (rs.next()) {
			lst.add(rs.getObject(1).toString() + "|" + rs.getObject(2).toString() + "|" + rs.getObject(3).toString()+ "|" + rs.getObject(4).toString());
		}
		mydb.closeConnection();
		return lst;
	}

	public void updateAbstraction(String abstraction, String quantity) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update abstractions set  quantity= " + Integer.valueOf(quantity) + 
				" where annotation = '" + abstraction + "';");		
		mydb.closeConnection();
	}

	public boolean checkAbstractionExist(String abs) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select annotation from instances where annotation='" + abs + "';");	
		if (rs.next() == false) {

			mydb.closeConnection();
			return false;
		}

		else {

			mydb.closeConnection();
			return true;
		}
	}

	public void UpdateInstance(String newValue, String oldValue) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("update instances set  annotation= '" + newValue + 
				"' where annotation = '" + oldValue + "';");		
		mydb.closeConnection();
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

	public void insertRelations(List<String> relations) throws Exception
	{
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		for (int i=0; i < relations.size(); i++) {

			mydb.executeStmt("insert into relation (package_from, class_from, field_from, method_from, variable_from, " + 
					" package_to, class_to, field_to, method_to, variable_to, modisco_path, type_relation) values (" +
					"CASE WHEN LENGTH('" + relations.get(i).split(Pattern.quote("|"))[0] + "') = 0 THEN NULL ELSE '" + relations.get(i).split(Pattern.quote("|"))[0] + "' END," +
					"CASE WHEN LENGTH('" + relations.get(i).split(Pattern.quote("|"))[1] + "') = 0 THEN NULL ELSE '" + relations.get(i).split(Pattern.quote("|"))[1] + "' END," +
					"CASE WHEN LENGTH('" + relations.get(i).split(Pattern.quote("|"))[2] + "') = 0 THEN NULL ELSE '" + relations.get(i).split(Pattern.quote("|"))[2] + "' END," +
					"CASE WHEN LENGTH('" + relations.get(i).split(Pattern.quote("|"))[3] + "') = 0 THEN NULL ELSE '" + relations.get(i).split(Pattern.quote("|"))[3] + "' END," +
					"CASE WHEN LENGTH('" + relations.get(i).split(Pattern.quote("|"))[4] + "') = 0 THEN NULL ELSE '" + relations.get(i).split(Pattern.quote("|"))[4] + "' END," +
					"CASE WHEN LENGTH('" + relations.get(i).split(Pattern.quote("|"))[5] + "') = 0 THEN NULL ELSE '" + relations.get(i).split(Pattern.quote("|"))[5] + "' END," +
					"CASE WHEN LENGTH('" + relations.get(i).split(Pattern.quote("|"))[6] + "') = 0 THEN NULL ELSE '" + relations.get(i).split(Pattern.quote("|"))[6] + "' END," +
					"CASE WHEN LENGTH('" + relations.get(i).split(Pattern.quote("|"))[7] + "') = 0 THEN NULL ELSE '" + relations.get(i).split(Pattern.quote("|"))[7] + "' END," +
					"CASE WHEN LENGTH('" + relations.get(i).split(Pattern.quote("|"))[8] + "') = 0 THEN NULL ELSE '" + relations.get(i).split(Pattern.quote("|"))[8] + "' END," +
					"CASE WHEN LENGTH('" + relations.get(i).split(Pattern.quote("|"))[9] + "') = 0 THEN NULL ELSE '" + relations.get(i).split(Pattern.quote("|"))[9] + "' END," +
					"'" + relations.get(i).split(Pattern.quote("|"))[10] + "'," +
					"'" + relations.get(i).split(Pattern.quote("|"))[11] + "');");
		}
		mydb.closeConnection();
	}

	public void insertSummaryAnnotation(List<String> summary) throws Exception
	{
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		for (int i=0; i < summary.size(); i++) {

			String query = "insert into summary_annotation (package, class, field, method, variable, annotation) values (" +
					"CASE WHEN LENGTH('" + summary.get(i).split(Pattern.quote("|"))[0] + "') = 0 THEN NULL ELSE '" + summary.get(i).split(Pattern.quote("|"))[0] + "' END," +
					"CASE WHEN LENGTH('" + summary.get(i).split(Pattern.quote("|"))[1] + "') = 0 THEN NULL ELSE '" + summary.get(i).split(Pattern.quote("|"))[1] + "' END," +
					"CASE WHEN LENGTH('" + summary.get(i).split(Pattern.quote("|"))[2] + "') = 0 THEN NULL ELSE '" + summary.get(i).split(Pattern.quote("|"))[2] + "' END," +
					"CASE WHEN LENGTH('" + summary.get(i).split(Pattern.quote("|"))[3] + "') = 0 THEN NULL ELSE '" + summary.get(i).split(Pattern.quote("|"))[3] + "' END," +
					"CASE WHEN LENGTH('" + summary.get(i).split(Pattern.quote("|"))[4] + "') = 0 THEN NULL ELSE '" + summary.get(i).split(Pattern.quote("|"))[4] + "' END," +
					"'" + summary.get(i).split(Pattern.quote("|"))[5]+ "');";

			mydb.executeStmt(query);
		}
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

	public void deleteInstance() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("delete from instances;"); 
		mydb.executeStmt("update abstractions set quantity = 0;"); 
		mydb.closeConnection();
	}

	public void deleteInstance(String instance, int id) throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("delete from instances where annotation = '" + instance + "';"); 
		mydb.executeStmt("update abstractions set quantity = (select count(*)-1 from abstractions where id=" + id + ") where id =" + id + ";"); 
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

	public void deleteRelation() throws Exception {

		SqliteDb mydb = new SqliteDb(dbDriver,url);
		mydb.executeStmt("delete from relation;"); 
		mydb.closeConnection();
	}

	public List<String> getActionRelationClass() throws Exception {

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select * from relation_class;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString()+"|"+rs.getObject(4).toString()+"|"+rs.getObject(5).toString());
		}
		mydb.closeConnection();
		return lst;	
	}
	
	public List<String> getActionRelationMethod() throws Exception {

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select * from relation_method;");		
		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2).toString()+"|"+rs.getObject(3).toString()+"|"+rs.getObject(4).toString()+"|"+rs.getObject(5).toString());
		}
		mydb.closeConnection();
		return lst;	
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
				"       ifnull(PACKAGE.annotation,'None') As Package\n" + 
				"from field_annotation A \n" + 
				"left join class_annotation CLASS on CLASS.project_name = A.project_name AND\n" + 
				"                                                             CLASS.name =  A.class_name AND\n" + 
				"                                                             CLASS.file = A.file \n" + 
				"left join package_annotation PACKAGE on PACKAGE.project_name = A.project_name  AND\n" + 
				"                                                        REPLACE(A.file,'/','.') like '%' || PACKAGE.name || '%';");		
		while (rs.next()) 
			values.add(rs.getObject(1).toString() + "|" + rs.getObject(2).toString() +"|" + rs.getObject(3).toString() + "|" + rs.getObject(4).toString() + "|"+ rs.getObject(7).toString() + "|" + rs.getObject(8).toString());

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
			}
		}


		mydb.closeConnection();
	}

	public void methodBelongsTo() throws Exception {

		List<String> values = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select DISTINCT A.*, \n" + 
				"       ifnull(CLASS.annotation,'None') As Class, \n" + 
				"       ifnull(PACKAGE.annotation,'None') As Package\n" + 
				"from method_annotation A \n" + 
				"left join class_annotation CLASS on CLASS.project_name = A.project_name  AND\n" + 
				"                                                         CLASS.name  = A.class_name AND\n" + 
				"                                                         CLASS.file  = A.file \n" + 
				"left join package_annotation PACKAGE on PACKAGE.project_name = A.project_name  AND\n" + 
				"                                                        REPLACE(A.file,'/','.') like '%' || PACKAGE.name || '%';");		
		while (rs.next()) 
			values.add(rs.getObject(1).toString() + "|" + rs.getObject(2).toString() +"|" + rs.getObject(3).toString() + "|" + rs.getObject(4).toString() + "|"+ rs.getObject(7).toString() + "|" + rs.getObject(8).toString());


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

	public List<String> getSummaryAnnotation() throws Exception{

		List<String> lst = new ArrayList<String>();
		SqliteDb mydb = new SqliteDb(dbDriver,url);	
		ResultSet rs = mydb.executeQry("select name AS name, annotation from package_annotation where annotation <> 'None'\n" + 
				"UNION ALL\n" + 
				"select REPLACE(SUBSTR(file,INSTR(file,'src/')+4),'/','.') name, annotation from class_annotation where annotation <> 'None'\n" + 
				"UNION ALL\n" + 
				"select (REPLACE(SUBSTR(file,INSTR(file,'src/')+4),'/','.') || '.' || field_name) name, annotation from field_annotation where annotation <> 'None'\n" + 
				"UNION ALL\n" + 
				"select (REPLACE(SUBSTR(file,INSTR(file,'src/')+4),'/','.') || '.' || method_name) name, annotation from method_annotation where annotation <> 'None'\n" + 
				"UNION ALL\n" + 
				"select (REPLACE(SUBSTR(file,INSTR(file,'src/')+4),'/','.') || '.' || method_name || '.' ||variable_name) name, annotation from variable_annotation where annotation <> 'None';");		

		while (rs.next()) {
			lst.add(rs.getObject(1).toString()+"|"+rs.getObject(2));
		}
		mydb.closeConnection();
		return lst;	
	}

	public int getMaxValueInstance(int abstraction, String annotation) throws Exception {

		int max = 0;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry(" select ifnull(max(cast(substr(annotation,pos+1) as integer)),0)\n" + 
				"    from(\n" + 
				"        select annotation, instr(annotation,'_') as pos\n" + 
				"        from instances where abstraction_id = " + abstraction + " and annotation like '" + annotation +"%' );");	
		while (rs.next()) {
			max = Integer.valueOf(String.valueOf(rs.getObject(1)));
		}
		mydb.closeConnection();
		return max;
	}

	public int getQuantityAbstraction(String instance) throws Exception {

		int max = 0;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry("select ifnull(count(*),0) from instances where annotation like '" + instance + "%';");	
		while (rs.next()) {
			max = Integer.valueOf(String.valueOf(rs.getObject(1)));
		}
		mydb.closeConnection();
		return max;
	}

	public int getMaxValueInstance(String annotation) throws Exception {

		int max = 0;
		SqliteDb mydb = new SqliteDb(dbDriver,url);
		ResultSet rs = mydb.executeQry(" select ifnull(max(cast(substr(annotation,pos+1) as integer)),0)\n" + 
				"    from(\n" + 
				"        select annotation, instr(annotation,'_') as pos\n" + 
				"        from instances where annotation like '" + annotation +"%' );");	
		while (rs.next()) {
			max = Integer.valueOf(String.valueOf(rs.getObject(1)));
		}
		mydb.closeConnection();
		return max;
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

}