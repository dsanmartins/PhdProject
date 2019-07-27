package br.ufscar.sas.aspects;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.xml.sax.SAXException;

import br.ufscar.sas.modisco.AddAbstractionTag;
import br.ufscar.sas.modisco.AddNamespaces;
import br.ufscar.sas.modisco.GenerateStereotype;
import br.ufscar.sas.modisco.GenerateStructure;
import br.ufscar.sas.parser.SourceRegion;

public aspect UtilsKDM {
	
	
	pointcut utilsKDM(Resource resource, String javaProjectName): call(void createKDMFile(Resource,String)) && args(resource,javaProjectName);

	after(Resource resource, String javaProjectName) : utilsKDM(resource, javaProjectName)  {
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();  
		String folder= workspace.getRoot().getLocation().toFile().getPath().toString(); 
		
		String path = folder + "/" + javaProjectName +"/";
		String file = javaProjectName + "_KDM" + ".xmi";
		String dbName = javaProjectName + "_KDM";
		//String fileRefactored = javaProjectName + "_REFACTORED_KDM" + ".xmi";
		//String dbNameRefactored = javaProjectName + "_REFACTORED_KDM";
		
		System.out.println("************* START ADDING NAMESPACES *************");
		AddNamespaces an = new AddNamespaces();
		try {an.parser(path + file);} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {e.printStackTrace();}
		System.out.println("************* STOP ADDING NAMESPACES *************");
		//System.out.println("************* START ADDING RETURN TO KDM *************");
		//GenerateReturn gr = new GenerateReturn();
		//gr.generator(path, file, dbName);
		//gr.generator(path, fileRefactored, dbNameRefactored);
		//System.out.println("************* END ADDING RETURN TO KDM *************");
		System.out.println("************* START ADD ABSTRACTION CODE ELEMENT *************");
		AddAbstractionTag addAbsTag = new AddAbstractionTag();
		addAbsTag.generator(path,file,dbName);
		try {addAbsTag.updatePackageWithAbstraction(path,file,dbName);} catch (Exception e1) {e1.printStackTrace();}
		try {addAbsTag.updateClassWithAbstraction(path,file,dbName);} catch (Exception e1) {e1.printStackTrace();}
		try {addAbsTag.updateFieldWithAbstraction(path,file,dbName);} catch (Exception e1) {e1.printStackTrace();}
		try {addAbsTag.updateMethodWithAbstraction(path,file,dbName);} catch (Exception e1) {e1.printStackTrace();}
		try {addAbsTag.updateVariableMethodWithAbstraction(path,file,dbName);} catch (Exception e1) {e1.printStackTrace();}
		System.out.println("************* END ADD ABSTRACTION CODE ELEMENT *************");
		System.out.println("************* START EDITING SOURCE REGION *************");
		SourceRegion sourceRegion = new SourceRegion();
		sourceRegion.statementsByLine(new File(path));
		System.out.println("************* END EDITING SOURCE REGION *************");
		System.out.println("************* GENERATE STEREOTYPE OF SAS *************");
		GenerateStereotype generateStereotype = new GenerateStereotype();
		generateStereotype.createModel(new File(path), file, dbName);
		System.out.println("************* END STEREOTYPE OF SAS *************");
		System.out.println("************* START GENERATE STRUCTURE *************");
		GenerateStructure generateStructure = new GenerateStructure();
		generateStructure.createModel(new File(path),file,dbName, path);
		System.out.println("************* END GENERATE STRUCTURE *************");
		System.out.println("************* START GENERATE STRUCTURE ELEMENTS *************");
		try {generateStructure.discoverRelationShip(new File(path), path);} catch (Exception e) {e.printStackTrace();}
		generateStructure.annotationPackage(new File(path), path);
		generateStructure.annotationClass(new File(path),path);
		generateStructure.annotationFieldClass(new File(path),path);
		generateStructure.annotationMethod(new File(path),path);
		generateStructure.annotationVariable(new File(path),path);
		try {generateStructure.addAggregatedRelationShip(new File(path),path);} catch (Exception e) {e.printStackTrace();} 
		System.out.println("************* END GENERATE STRUCTURE ELEMENTS *************");
				
	}
}