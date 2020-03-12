package br.ufscar.sas.query;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.modisco.omg.kdm.structure.Component;
import org.eclipse.modisco.omg.kdm.structure.StructureModel;
import org.eclipse.modisco.omg.kdm.structure.StructurePackage;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.Query;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.eclipse.ocl.xtext.oclstdlib.OCLstdlibStandaloneSetup;


public class OCLQuery {

	public Set<Component> getComponent(ResourceSet resourceSet, Resource resource, String componentName) throws ParserException {

		OCLstdlib.install(); 
		CompleteOCLStandaloneSetup.doSetup();
		OCLstdlibStandaloneSetup.doSetup();
		EssentialOCLStandaloneSetup.doSetup(); 
		
		OCL ocl = OCL.newInstance(resource.getResourceSet());
		StructureModel structureModel = (StructureModel) resource.getContents().get(0).eContents().get(4);
		
		Set<Component> currentComponent = null;
		
		try {
			ExpressionInOCL query = ocl.createQuery(StructurePackage.Literals.STRUCTURE_MODEL,"Component.allInstances()->select(c|c.name='"+ componentName +"')");
			Query evaluateQuery = ocl.createQuery(query);
			currentComponent =  (Set<Component>) evaluateQuery.evaluateUnboxed(structureModel);

		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return currentComponent;
	}
	
	public Object getTo(ResourceSet resourceSet, Resource resource, String componentStereotype) throws ParserException {

		OCLstdlib.install(); 
		CompleteOCLStandaloneSetup.doSetup();
		OCLstdlibStandaloneSetup.doSetup();
		EssentialOCLStandaloneSetup.doSetup(); 
		
		OCL ocl = OCL.newInstance(resource.getResourceSet());
		StructureModel structureModel = (StructureModel) resource.getContents().get(0).eContents().get(4);
	
		Object object = null;
		
		try {
			ExpressionInOCL query = ocl.createQuery(StructurePackage.Literals.STRUCTURE_MODEL,"Component.allInstances()->select(c|c.stereotype->asSequence()->first().name='"+ componentStereotype +"') "
					+ "->asSequence()->first()");
			Query evaluateQuery = ocl.createQuery(query);
			object = evaluateQuery.evaluateUnboxed(structureModel);

		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;
	}
	
	public Object getInSubsystem(ResourceSet resourceSet, Resource resource, String componentStereotype) throws ParserException {

		OCLstdlib.install(); 
		CompleteOCLStandaloneSetup.doSetup();
		OCLstdlibStandaloneSetup.doSetup();
		EssentialOCLStandaloneSetup.doSetup(); 
		
		OCL ocl = OCL.newInstance(resource.getResourceSet());
		StructureModel structureModel = (StructureModel) resource.getContents().get(0).eContents().get(4);
	
		Object object = null;
		
		try {
			ExpressionInOCL query = ocl.createQuery(StructurePackage.Literals.STRUCTURE_MODEL,"Subsystem.allInstances()->select(c|c.stereotype->asSequence()->first().name='"+ componentStereotype +"') "
					+ "->asSequence()->first()");
			Query evaluateQuery = ocl.createQuery(query);
			object = evaluateQuery.evaluateUnboxed(structureModel);

		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;
	}
	
}
