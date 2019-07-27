package br.ufscar.sas.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import org.basex.core.BaseXException;
import org.basex.query.QueryException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;

import br.ufscar.sas.modisco.Manager;

public class SourceRegion {


	public SourceRegion(){

	}

	public void statementsByLine(File projectDir) {

		new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
			try 
			{ 
				//Get Class Name
				String token[] = path.split("\\/"); 
				String packageName = token[token.length-2];
				String className = token[token.length-1].split("\\.")[0];

				//Get Fields of a class
				CompilationUnit cu = JavaParser.parse(file);
				FieldClassVisitor fdc = new FieldClassVisitor();
				List<FieldDeclaration> listFd = fdc.getFieldClasses(cu);
				for (int i = 0; i< listFd.size(); i ++)
				{
					NodeList<VariableDeclarator> nl = listFd.get(i).getVariables();
					for (int j = 0; j< nl.size(); j++)
					{
						String fieldName = nl.get(j).getNameAsString().toString();
						int startLine = listFd.get(i).getBegin().get().line;
						int endLine = listFd.get(i).getEnd().get().line;
						this.lineNumbersGenerator(1,projectDir.getPath() + "/", 
								projectDir.getName() +"_KDM" + ".xmi", 
								projectDir.getName() + "_KDM", 
								packageName,
								className,
								fieldName, 
								startLine, 
								endLine); 
					}
				}


				MethodVisitor md = new MethodVisitor();
				List<MethodDeclaration>  listMd = md.getMethodClasses(cu); 
				for (int i = 0; i< listMd.size(); i ++)
				{
					String methodName = listMd.get(i).getName().toString();
					int startLine = listMd.get(i).getBegin().get().line;
					int endLine = listMd.get(i).getEnd().get().line;

					this.lineNumbersGenerator(2,projectDir.getPath() + "/", 
							projectDir.getName() +"_KDM" + ".xmi", 
							projectDir.getName() + "_KDM", 
							packageName,
							className,
							methodName, 
							startLine, 
							endLine); 


					VariableVisitor vv = new VariableVisitor();
					List<VariableDeclarator> listVD = vv.getVariableExpr(listMd.get(i));
					for (int j=0; j< listVD.size(); j++)
					{
						String variable = listVD.get(j).getNameAsString().toString();
						startLine = listVD.get(j).getBegin().get().line;
						endLine = listVD.get(j).getEnd().get().line;

						this.lineNumbersGenerator(4,projectDir.getPath() + "/", 
								projectDir.getName() +"_KDM" + ".xmi", 
								projectDir.getName() + "_KDM", 
								packageName,
								className,
								listMd.get(i).getName() + "|" + variable, 
								startLine, 
								endLine); 
					}
				}

				ClassVisitor cv = new ClassVisitor();
				List<ClassOrInterfaceDeclaration> listCID = cv.getClassesOrInterfaces(cu);
				for (int i=0; i< listCID.size(); i++)
				{
					String classOrInterfaceName = listCID.get(i).getName().toString();
					int startLine = listCID.get(i).getBegin().get().line;
					int endLine = listCID.get(i).getEnd().get().line;

					this.lineNumbersGenerator(3,projectDir.getPath() + "/", 
							projectDir.getName() +"_KDM" + ".xmi", 
							projectDir.getName() + "_KDM", 
							packageName,
							classOrInterfaceName,
							"", 
							startLine, 
							endLine); 

				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).explore(projectDir);

	}

	public void lineNumbersGenerator(int op, String path, String file, String dbName, String packageName, String className, String elementName, int startLine , int endLine) {

		Manager baseXManager=null;

		try {
			baseXManager = new Manager(path, file, dbName);
		} catch (BaseXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			baseXManager.openDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (op == 2)
		{
			//EndLine
			try {

				String query = "for $a in//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']"
						+ "//codeElement[@xsi:type='code:Package' and @name='" + packageName + "']"
						+ "//codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "']" 
						+ "//codeElement[@xsi:type='code:MethodUnit' and @name='" + elementName + "']/source/region" 
						+ " return if (not($a/boolean(@endLine))) then insert node (attribute { 'endLine' } {'" + endLine + "'}) as last into $a else ()";

				baseXManager.createLine(query);
			} catch (QueryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			//StartLine
			try {

				String query = "for $a in//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']"
						+ "//codeElement[@xsi:type='code:Package' and @name='" + packageName + "']"
						+ "//codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "']" 
						+ "//codeElement[@xsi:type='code:MethodUnit' and @name='" + elementName + "']/source/region" 
						+ " return if (not($a/boolean(@startLine))) then insert node (attribute { 'startLine' } {'" + startLine + "'}) as last into $a else ()";

				baseXManager.createLine(query);
			} catch (QueryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		else
		{
			if (op == 1)
			{

				//EndLine
				try {

					String query = "for $a in//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']"
							+ "//codeElement[@xsi:type='code:Package' and @name='" + packageName + "']"
							+ "//codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "']"  
							+ "//codeElement[@xsi:type='code:StorableUnit' and @name='" + elementName + "']/source/region" 
							+ " return if (not($a/boolean(@endLine))) then insert node (attribute { 'endLine' } {'" + endLine + "'}) as last into $a else ()";
					baseXManager.createLine(query);
				} catch (QueryException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}



				//StartLine
				try {

					String query = "for $a in//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']"
							+ "//codeElement[@xsi:type='code:Package' and @name='" + packageName + "']"
							+ "//codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "']"  
							+ "//codeElement[@xsi:type='code:StorableUnit' and @name='" + elementName + "']/source/region" 
							+ " return if (not($a/boolean(@startLine))) then insert node (attribute { 'startLine' } {'" + startLine + "'}) as last into $a else ()";

					baseXManager.createLine(query);
				} catch (QueryException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				if (op == 3)
				{
					//EndLine
					try {

						String query = "for $a in//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']"
								+ "//codeElement[@xsi:type='code:Package' and @name='" + packageName + "']"
								+ "//codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "']/source/region"  
								+ " return if (not($a/boolean(@endLine))) then insert node (attribute { 'endLine' } {'" + endLine + "'}) as last into $a else ()";

						baseXManager.createLine(query);
					} catch (QueryException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					//StartLine
					try {

						String query = "for $a in//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']"
								+ "//codeElement[@xsi:type='code:Package' and @name='" + packageName + "']"
								+ "//codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "']/source/region"  
								+ " return if (not($a/boolean(@startLine))) then insert node (attribute { 'startLine' } {'" + startLine + "'}) as last into $a else ()";

						baseXManager.createLine(query);
					} catch (QueryException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					if (op == 4)
					{
						//EndLine
						try {

							String query = "for $a in//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']"
									+ "//codeElement[@xsi:type='code:Package' and @name='" + packageName + "']"
									+ "//codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "']"  
									+ "//codeElement[@xsi:type='code:MethodUnit' and @name='" + elementName.split("\\|")[0] + "']" 
									+ "//codeElement[@xsi:type='code:StorableUnit' and @name='" + elementName.split("\\|")[1] + "']/source/region"  
									+ " return if (not($a/boolean(@endLine))) then insert node (attribute { 'endLine' } {'" + endLine + "'}) as last into $a else ()";

							baseXManager.createLine(query);
						} catch (QueryException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						//StartLine
						try {

							String query = "for $a in//kdm:Segment/model[@xsi:type='code:CodeModel' and @name != 'externals']"
									+ "//codeElement[@xsi:type='code:Package' and @name='" + packageName + "']"
									+ "//codeElement[@xsi:type='code:ClassUnit' and @name='" + className + "']"  
									+ "//codeElement[@xsi:type='code:MethodUnit' and @name='" + elementName.split("\\|")[0] + "']" 
									+ "//codeElement[@xsi:type='code:StorableUnit' and @name='" + elementName.split("\\|")[1] + "']/source/region"  
									+ " return if (not($a/boolean(@startLine))) then insert node (attribute { 'startLine' } {'" + startLine + "'}) as last into $a else ()";

							baseXManager.createLine(query);
						} catch (QueryException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		}

		try {
			baseXManager.exportDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baseXManager.closeDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
