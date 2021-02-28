package br.ufscar.sas.aspects;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ParserException;
import org.xml.sax.SAXException;

import br.ufscar.sas.modisco.AddNamespaces;
import br.ufscar.sas.modisco.GenerateStructure;
import br.ufscar.sas.transformation.AddASModel;

public aspect UtilsKDM {
	
	
	pointcut utilsKDM(Resource resource, String javaProjectName): call(void createKDMFile(Resource,String)) && args(resource,javaProjectName);

	after(Resource resource, String javaProjectName) : utilsKDM(resource, javaProjectName)  {
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();  
		String folder= workspace.getRoot().getLocation().toFile().getPath().toString(); 
		
		String path = folder + "/" + javaProjectName +"/";
		String file = javaProjectName + "_KDM" + ".xmi";
		String dbName = javaProjectName + "_KDM";
		IWorkspaceRoot root = workspace.getRoot();
		IProject project  = root.getProject(javaProjectName);
		IFile kdmCurrent = project.getFile(javaProjectName + "_KDM.xmi");
		
		//String fileRefactored = javaProjectName + "_REFACTORED_KDM" + ".xmi";
		//String dbNameRefactored = javaProjectName + "_REFACTORED_KDM";
		
		
		System.out.println("************* GENERATE STEREOTYPE OF SAS *************");
		AddASModel addASModel = new AddASModel();
		try {addASModel.addStereotype(kdmCurrent);} catch (ExecutionException e2) {e2.printStackTrace();}
		System.out.println("************* END STEREOTYPE OF SAS *************");
		System.out.println("************* START GENERATE STRUCTURE *************");
		GenerateStructure generateStructure = new GenerateStructure();
		generateStructure.createModel(new File(path),file,dbName, path);
		System.out.println("************* END GENERATE STRUCTURE *************");
		
		
		AddNamespaces an = new AddNamespaces();
		try {an.parser(path + file);} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {e.printStackTrace();}
		System.out.println("************* START GENERATE STRUCTURE ELEMENTS *************");
		generateStructure.mapping(kdmCurrent,path);
		try {generateStructure.relationshipsSubsystem(kdmCurrent,path);} catch (ParserException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (Exception e) {e.printStackTrace();}
		try {generateStructure.relationshipsComponent(kdmCurrent,path);} catch (ParserException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (Exception e) {e.printStackTrace();}
		System.out.println("************* END GENERATE STRUCTURE ELEMENTS *************");	
	}
}