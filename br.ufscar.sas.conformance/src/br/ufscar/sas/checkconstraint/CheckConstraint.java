package br.ufscar.sas.checkconstraint;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.omg.kdm.core.AggregatedRelationship;
import org.eclipse.gmt.modisco.omg.kdm.core.CorePackage;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage;
import org.eclipse.gmt.modisco.omg.kdm.structure.Component;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructurePackage;
import org.eclipse.gmt.modisco.omg.kdm.structure.Subsystem;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.Query;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.eclipse.ocl.xtext.oclstdlib.OCLstdlibStandaloneSetup;

import br.ufscar.sas.dataconstraint.DataConstraint;

public class CheckConstraint {


	public void checkConstraint(IFile currentArchitecturePath, IFile constraintPath, String workspacePath) throws SQLException  {

		String projectName = currentArchitecturePath.getProject().getName();
		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName + "/");

		OCLstdlib.install(); 
		CompleteOCLStandaloneSetup.doSetup();
		OCLstdlibStandaloneSetup.doSetup();
		EssentialOCLStandaloneSetup.doSetup(); 

		KdmPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createURI(currentArchitecturePath.getFullPath().toString()), true);	
		OCL ocl = OCL.newInstance(resource.getResourceSet());

		// get an OCL text file via some hypothetical API
		Resource asResource = ocl.parse(URI.createFileURI(constraintPath.getRawLocation().toOSString()));

		Map<String, ExpressionInOCL> constraintMap = new HashMap<String, ExpressionInOCL>();
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) 
		{
			EObject next = tit.next();
			if (next instanceof Constraint) 
			{
				Constraint constraint = (Constraint)next;
				ExpressionInOCL expressionInOCL = null;
				try {expressionInOCL = ocl.getSpecification(constraint);} catch (ParserException e) {e.printStackTrace();}
				if (expressionInOCL != null)
				{
					String name = constraint.getName();
					if (name != null) 
						constraintMap.put(name, expressionInOCL);
				}
			}
		}

		StructureModel structureModel = (StructureModel) resource.getContents().get(0).eContents().get(4);
		for (String key : constraintMap.keySet() ) {
			Boolean check = false;
			ExpressionInOCL expressionInOCL = constraintMap.get(key);
			String type = key.split(Pattern.quote("_"))[0];
			String abstraction = key.split(Pattern.quote("_"))[1] + "_" +key.split(Pattern.quote("_"))[2];
			
			try {
				check = (Boolean) ocl.evaluate(structureModel, expressionInOCL);

				if (type.equals("exist")) {

					try {
						dataConstraint.insertExistence(projectName, abstraction, (check.booleanValue() ? 1 : 0 ));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					if (type.equals("composite")) {

						try {
							dataConstraint.insertComposite(projectName, abstraction, (check.booleanValue() ? 1 : 0 ));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else {
						
						if (type.equals("access")) {
							String abstraction2 = key.split(Pattern.quote("_"))[3] + "_" + key.split(Pattern.quote("_"))[4];
							try {
								dataConstraint.insertAccess(projectName, abstraction, abstraction2, (check.booleanValue() ? 1 : 0 ));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
				}
			}
			catch (InvalidValueException e)
			{
				if (type.equals("exist")) 
				try {
					dataConstraint.insertExistence(projectName, abstraction, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				else {
					if (type.equals("composite")) {
						try {
							dataConstraint.insertComposite(projectName, abstraction, 0);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else {
						String abstraction2 = key.split(Pattern.quote("_"))[3]  + "_" +  key.split(Pattern.quote("_"))[4];
						try {
							dataConstraint.insertAccess(projectName, abstraction, abstraction2, 0);
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
			}
		}	
		
	}
	
	public void checkDrifts(IFile currentArchitecturePath, IFile plannedArchitecturePath, String workspacePath) throws SQLException {
		
		String projectName = currentArchitecturePath.getProject().getName();
		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName + "/");
		
		int nComponent = this.checkDriftsComponents(currentArchitecturePath, plannedArchitecturePath);
		int nSubsystem = this.checkDriftsSubsystems(currentArchitecturePath, plannedArchitecturePath);
		int nAssociation = this.checkDriftsAssociation(currentArchitecturePath, plannedArchitecturePath);
		
		try {
			dataConstraint.insertDrifts(projectName, nComponent, nSubsystem, nAssociation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int checkDriftsComponents(IFile currentArchitecturePath, IFile plannedArchitecturePath) {
		
		int total = 0;
		OCLstdlib.install(); 
		CompleteOCLStandaloneSetup.doSetup();
		OCLstdlibStandaloneSetup.doSetup();
		EssentialOCLStandaloneSetup.doSetup(); 

		KdmPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());		

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createURI(currentArchitecturePath.getFullPath().toString()), true);

		ResourceSet resourceSet2 = new ResourceSetImpl();
		Resource resource2 = resourceSet2.getResource(URI.createURI(plannedArchitecturePath.getFullPath().toString()), true);	

		Set<Component> currentComponent = null;
		Set<Component> plannedComponent = null;

		OCL ocl = OCL.newInstance(resource.getResourceSet());
		StructureModel structureModel = (StructureModel) resource.getContents().get(0).eContents().get(4);
		try {
			ExpressionInOCL query = ocl.createQuery(StructurePackage.Literals.STRUCTURE_MODEL,"Component.allInstances()");
			Query evaluateQuery = ocl.createQuery(query);
			currentComponent =  (Set<Component>) evaluateQuery.evaluateUnboxed(structureModel);

		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		structureModel = (StructureModel) resource2.getContents().get(0).eContents().get(2);
		ocl = OCL.newInstance(resource2.getResourceSet());
		try {
			ExpressionInOCL query = ocl.createQuery(StructurePackage.Literals.STRUCTURE_MODEL,"Component.allInstances()");
			Query evaluateQuery = ocl.createQuery(query);
			plannedComponent =  (Set<Component>) evaluateQuery.evaluateUnboxed(structureModel);

		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator iterator = plannedComponent.iterator();
		while(iterator.hasNext())
		{
			Component compPlanned = (Component) iterator.next();
			currentComponent.removeIf(comp -> comp.getName().equals(compPlanned.getName()));
		}
		return currentComponent.size();
	}

	private int checkDriftsSubsystems(IFile currentArchitecturePath, IFile plannedArchitecturePath) {

		int total = 0;
		OCLstdlib.install(); 
		CompleteOCLStandaloneSetup.doSetup();
		OCLstdlibStandaloneSetup.doSetup();
		EssentialOCLStandaloneSetup.doSetup(); 

		KdmPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());		

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createURI(currentArchitecturePath.getFullPath().toString()), true);

		ResourceSet resourceSet2 = new ResourceSetImpl();
		Resource resource2 = resourceSet2.getResource(URI.createURI(plannedArchitecturePath.getFullPath().toString()), true);	

		Set<Subsystem> currentSubsystem= null;
		Set<Subsystem> plannedSubsystem = null;

		OCL ocl = OCL.newInstance(resource.getResourceSet());
		StructureModel structureModel = (StructureModel) resource.getContents().get(0).eContents().get(4);
		try {
			ExpressionInOCL query = ocl.createQuery(StructurePackage.Literals.STRUCTURE_MODEL,"Subsystem.allInstances()");
			Query evaluateQuery = ocl.createQuery(query);
			currentSubsystem =  (Set<Subsystem>) evaluateQuery.evaluateUnboxed(structureModel);
			
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		structureModel = (StructureModel) resource2.getContents().get(0).eContents().get(2);
		ocl = OCL.newInstance(resource2.getResourceSet());
		try {
			ExpressionInOCL query = ocl.createQuery(StructurePackage.Literals.STRUCTURE_MODEL,"Subsystem.allInstances()");
			Query evaluateQuery = ocl.createQuery(query);
			plannedSubsystem =  (Set<Subsystem>) evaluateQuery.evaluateUnboxed(structureModel);

		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator iterator = plannedSubsystem.iterator();
		while(iterator.hasNext())
		{
			Subsystem subPlanned = (Subsystem) iterator.next();
			currentSubsystem.removeIf(sub -> sub.getName().equals(subPlanned.getName()));
		}
		return currentSubsystem.size();

	}

	private int checkDriftsAssociation(IFile currentArchitecturePath, IFile plannedArchitecturePath) {

		int total = 0;
		OCLstdlib.install(); 
		CompleteOCLStandaloneSetup.doSetup();
		OCLstdlibStandaloneSetup.doSetup();
		EssentialOCLStandaloneSetup.doSetup(); 

		KdmPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());		

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createURI(currentArchitecturePath.getFullPath().toString()), true);

		ResourceSet resourceSet2 = new ResourceSetImpl();
		Resource resource2 = resourceSet2.getResource(URI.createURI(plannedArchitecturePath.getFullPath().toString()), true);	

		Set<AggregatedRelationship> currentAggregated = null;
		Set<AggregatedRelationship> plannedAggregated = null;

		OCL ocl = OCL.newInstance(resource.getResourceSet());
		StructureModel structureModel = (StructureModel) resource.getContents().get(0).eContents().get(4);
		try {
			ExpressionInOCL query = ocl.createQuery(CorePackage.Literals.AGGREGATED_RELATIONSHIP,"AggregatedRelationship.allInstances()");
			Query evaluateQuery = ocl.createQuery(query);
			currentAggregated =  (Set<AggregatedRelationship>) evaluateQuery.evaluateUnboxed(structureModel);

		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		structureModel = (StructureModel) resource2.getContents().get(0).eContents().get(2);
		ocl = OCL.newInstance(resource2.getResourceSet());
		try {
			ExpressionInOCL query = ocl.createQuery(CorePackage.Literals.AGGREGATED_RELATIONSHIP,"AggregatedRelationship.allInstances()");
			Query evaluateQuery = ocl.createQuery(query);
			plannedAggregated =  (Set<AggregatedRelationship>) evaluateQuery.evaluateUnboxed(structureModel);

		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator iterator = plannedAggregated.iterator();
		while(iterator.hasNext())
		{
			AggregatedRelationship aggregated = (AggregatedRelationship) iterator.next();
			currentAggregated.removeIf(agg -> agg.getFrom().getName().equals(aggregated.getFrom().getName()) && agg.getTo().getName().equals(aggregated.getTo().getName()));
		}

		return currentAggregated.size();
	}
}
