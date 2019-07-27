package br.ufscar.sas.modisco;

import java.util.List;
import java.util.regex.Pattern;

import br.ufscar.sas.database.QueryClass;

public class AddAbstractionTag {

	QueryClass queryClass = null;

	public void generator(String path, String file, String dbName) 
	{
		Manager baseXManager=null;
		try
		{
			baseXManager = new Manager(path, file, dbName);
			baseXManager.openDB();
			baseXManager.addAbstractionTag();
			baseXManager.exportDB();
			baseXManager.closeDB();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void updatePackageWithAbstraction(String path_, String file, String dbName) throws Exception {

		queryClass = new QueryClass(path_);
		List<String> packages = queryClass.getPackageAnnotations();
		for (String line : packages)
		{
			String package_ = line.split(Pattern.quote("|"))[1];
			String abstraction = line.split(Pattern.quote("|"))[3];

			if (package_.contains("."))
			{
				String package__[] = package_.split(Pattern.quote(".")); 
				String codeElement = "/codeElement[@xsi:type='code:Package' and @name='XXXX']"; 
				String path = "";
				for (int i=0; i< package__.length; i++)
					path = path + codeElement.replaceFirst("XXXX", package__[i]);

				String query = " let $a:=//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']" + path + "/attribute[@tag='abstraction'] " +
						"return replace value of node $a/@value with '" + abstraction + "'";

				Manager baseXManager=null;
				try
				{
					baseXManager = new Manager(path_, file, dbName);
					baseXManager.openDB();
					baseXManager.addAbstraction(query);
					baseXManager.exportDB();
					baseXManager.closeDB();
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
				path = "";
			}
		}
	}

	public void updateClassWithAbstraction(String path_, String file, String dbName) throws Exception {

		queryClass = new QueryClass(path_);
		List<String> classes = queryClass.getClassAnnotations();
		for (String line : classes)
		{
			String package_ = line.split(Pattern.quote("|"))[2].split(Pattern.quote("/src/"))[1];
			String class_ = line.split(Pattern.quote("|"))[1];
			String abstraction = line.split(Pattern.quote("|"))[3];
			package_ = package_.replaceAll(class_, "").replaceAll("\\/", ".");
			package_ = package_.substring(0, package_.length() -1);

			String path = "";
			String codeElement = "/codeElement[@xsi:type='code:Package' and @name='XXXX']"; 
			if (package_.contains("."))
			{
				String package__[] = package_.split(Pattern.quote(".")); 
				for (int i=0; i< package__.length; i++)
					path = path + codeElement.replaceFirst("XXXX", package__[i]);
			}	
			else
				path = codeElement.replaceFirst("XXXX", package_);


			String query = " let $a:=//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']" + path + 
					"/codeElement[@xsi:type='code:ClassUnit' and @name='"+ class_ + "']" +"/attribute[@tag='abstraction'] " +
					"return replace value of node $a/@value with '" + abstraction + "'";

			Manager baseXManager=null;
			try
			{
				baseXManager = new Manager(path_, file, dbName);
				baseXManager.openDB();
				baseXManager.addAbstraction(query);
				baseXManager.exportDB();
				baseXManager.closeDB();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			path = "";

		}
	}

	public void updateFieldWithAbstraction(String path_, String file, String dbName) throws Exception {

		queryClass = new QueryClass(path_);
		List<String> fields = queryClass.getFieldClassAnnotations();
		for (String line : fields)
		{
			String package_ = line.split(Pattern.quote("|"))[3].split(Pattern.quote("/src/"))[1];
			String class_ = line.split(Pattern.quote("|"))[1];
			String field = line.split(Pattern.quote("|"))[2];
			String abstraction = line.split(Pattern.quote("|"))[4];
			package_ = package_.replaceAll(class_, "").replaceAll("\\/", ".");
			package_ = package_.substring(0, package_.length() -1);

			String path = "";
			String codeElement = "/codeElement[@xsi:type='code:Package' and @name='XXXX']"; 
			if (package_.contains("."))
			{
				String package__[] = package_.split(Pattern.quote(".")); 
				for (int i=0; i< package__.length; i++)
					path = path + codeElement.replaceFirst("XXXX", package__[i]);
			}	
			else
				path = codeElement.replaceFirst("XXXX", package_);

			String query = " let $a:=//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']" + path + 
					"/codeElement[@xsi:type='code:ClassUnit' and @name='"+ class_ + "']" + 
					"/codeElement[@xsi:type='code:StorableUnit' and @name='"+ field + "']" + 
					"/attribute[@tag='abstraction'] " +
					"return replace value of node $a/@value with '" + abstraction + "'";

			Manager baseXManager=null;
			try
			{
				baseXManager = new Manager(path_, file, dbName);
				baseXManager.openDB();
				baseXManager.addAbstraction(query);
				baseXManager.exportDB();
				baseXManager.closeDB();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			path = "";

		}
	}

	public void updateMethodWithAbstraction(String path_, String file, String dbName) throws Exception {

		queryClass = new QueryClass(path_);
		List<String> methods = queryClass.getMethodAnnotations();
		for (String line : methods)
		{
			String package_ = line.split(Pattern.quote("|"))[3].split(Pattern.quote("/src/"))[1];
			String class_ = line.split(Pattern.quote("|"))[1];
			String method = line.split(Pattern.quote("|"))[2];
			String abstraction = line.split(Pattern.quote("|"))[4];
			package_ = package_.replaceAll(class_, "").replaceAll("\\/", ".");
			package_ = package_.substring(0, package_.length() -1);

			String path = "";
			String codeElement = "/codeElement[@xsi:type='code:Package' and @name='XXXX']"; 
			if (package_.contains("."))
			{
				String package__[] = package_.split(Pattern.quote(".")); 
				for (int i=0; i< package__.length; i++)
					path = path + codeElement.replaceFirst("XXXX", package__[i]);
			}	
			else
				path = codeElement.replaceFirst("XXXX", package_);

			String query = " let $a:=//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']" + path + 
					"/codeElement[@xsi:type='code:ClassUnit' and @name='"+ class_ + "']" + 
					"/codeElement[@xsi:type='code:MethodUnit' and @name='"+ method + "']" + 
					"/attribute[@tag='abstraction'] " +
					"return replace value of node $a/@value with '" + abstraction + "'";

			Manager baseXManager=null;
			try
			{
				baseXManager = new Manager(path_, file, dbName);
				baseXManager.openDB();
				baseXManager.addAbstraction(query);
				baseXManager.exportDB();
				baseXManager.closeDB();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			path = "";
		}
	}

	public void updateVariableMethodWithAbstraction(String path_, String file, String dbName) throws Exception {

		queryClass = new QueryClass(path_);
		List<String> variables = queryClass.getVariableAnnotations();
		for (String line : variables)
		{
			String package_ = line.split(Pattern.quote("|"))[4].split(Pattern.quote("/src/"))[1];
			String class_ = line.split(Pattern.quote("|"))[1];
			String method = line.split(Pattern.quote("|"))[2];
			String variable = line.split(Pattern.quote("|"))[3];
			String abstraction = line.split(Pattern.quote("|"))[5];
			package_ = package_.replaceAll(class_, "").replaceAll("\\/", ".");
			package_ = package_.substring(0, package_.length() -1);

			String path = "";
			String codeElement = "/codeElement[@xsi:type='code:Package' and @name='XXXX']"; 
			if (package_.contains("."))
			{
				String package__[] = package_.split(Pattern.quote(".")); 
				for (int i=0; i< package__.length; i++)
					path = path + codeElement.replaceFirst("XXXX", package__[i]);
			}	
			else
				path = codeElement.replaceFirst("XXXX", package_);


			String query = " let $a:=//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']" + path + 
					"/codeElement[@xsi:type='code:ClassUnit' and @name='"+ class_ + "']" + 
					"/codeElement[@xsi:type='code:MethodUnit' and @name='"+ method + "']" + 
					"//codeElement[@xsi:type='code:StorableUnit' and @name='"+ variable + "']" + 
					"/attribute[@tag='abstraction'] " +
					"return replace value of node $a/@value with '" + abstraction + "'";

			Manager baseXManager=null;
			try
			{
				baseXManager = new Manager(path_, file, dbName);
				baseXManager.openDB();
				baseXManager.addAbstraction(query);
				baseXManager.exportDB();
				baseXManager.closeDB();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			path = "";
		}
	}
}
