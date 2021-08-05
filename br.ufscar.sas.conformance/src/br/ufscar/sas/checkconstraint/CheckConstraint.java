package br.ufscar.sas.checkconstraint;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import org.eclipse.modisco.omg.kdm.core.AggregatedRelationship;
import org.eclipse.modisco.omg.kdm.core.CorePackage;
import org.eclipse.modisco.omg.kdm.kdm.KdmPackage;
import org.eclipse.modisco.omg.kdm.structure.Component;
import org.eclipse.modisco.omg.kdm.structure.StructureModel;
import org.eclipse.modisco.omg.kdm.structure.StructurePackage;
import org.eclipse.modisco.omg.kdm.structure.Subsystem;
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

	String workspacePath;
	String projectName;

	public CheckConstraint(String workspacePath, String projectName) {

		this.workspacePath = workspacePath;
		this.projectName = projectName + "/";

	}

	public void checkConstraint(IFile currentArchitecturePath, IFile constraintPath) throws SQLException  {


		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName);
		try {
			dataConstraint.deleteTables();
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

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
						int row = dataConstraint.insertExistence(projectName.replaceAll("\\/", ""), abstraction, (check.booleanValue() ? 1 : 0 ));
						dataConstraint.insertExistenceRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") , (check.booleanValue() ? 1 : 0 ), row);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					if (type.equals("composite")) {

						try {
							int row =dataConstraint.insertComposite(projectName.replaceAll("\\/", ""), abstraction, (check.booleanValue() ? 1 : 0 ));
							dataConstraint.insertCompositeRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") , (check.booleanValue() ? 1 : 0 ),row);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else {

						if (type.equals("access")) {
							String abstraction2 = key.split(Pattern.quote("_"))[3] + "_" + key.split(Pattern.quote("_"))[4];
							try {
								int row =dataConstraint.insertAccess(projectName.replaceAll("\\/", ""), abstraction, abstraction2, (check.booleanValue() ? 1 : 0 ));
								dataConstraint.insertAccessRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") , (check.booleanValue() ? 1 : 0 ),row);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else
						{
							if (type.equals("not")) {
								String abstraction2 = key.split(Pattern.quote("_"))[4] + "_" + key.split(Pattern.quote("_"))[5];
								abstraction =  key.split(Pattern.quote("_"))[2] + "_" + key.split(Pattern.quote("_"))[3];
								try {
									int row =dataConstraint.insertAccess(projectName.replaceAll("\\/", ""), abstraction, abstraction2, (check.booleanValue() ? 1 : 0 ));
									dataConstraint.insertAccessRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") , (check.booleanValue() ? 1 : 0 ),row);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}								
							}
							else {
								if (type.equals("domain")) {
									
									if (key.split(Pattern.quote("_"))[1].equals("not")) {
										
										String abstraction2 = key.split(Pattern.quote("_"))[5] + "_" + key.split(Pattern.quote("_"))[6];
										abstraction =  key.split(Pattern.quote("_"))[3] + "_" + key.split(Pattern.quote("_"))[4];
										try {
											int row =dataConstraint.insertDomain(projectName.replaceAll("\\/", ""), abstraction, abstraction2, (check.booleanValue() ? 1 : 0 ));
											dataConstraint.insertDomainRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") , (check.booleanValue() ? 1 : 0 ),row);
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}							
									}
									else
									{
										String abstraction2 = key.split(Pattern.quote("_"))[4] + "_" + key.split(Pattern.quote("_"))[5];
										abstraction =  key.split(Pattern.quote("_"))[2] + "_" + key.split(Pattern.quote("_"))[3];
										try {
											int row =dataConstraint.insertDomain(projectName.replaceAll("\\/", ""), abstraction, abstraction2, (check.booleanValue() ? 1 : 0 ));
											dataConstraint.insertDomainRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") , (check.booleanValue() ? 1 : 0 ),row);
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}				
									}
								}
							}
						}
					}
				}
			}
			catch (InvalidValueException e)
			{
				if (type.equals("exist")) 
					try {
						int row =dataConstraint.insertExistence(projectName.replaceAll("\\/", ""), abstraction, 0);
						dataConstraint.insertExistenceRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") , 0,row);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else {
					if (type.equals("composite")) {
						try {
							int row =dataConstraint.insertComposite(projectName.replaceAll("\\/", ""), abstraction, 0);
							dataConstraint.insertCompositeRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") ,0,row);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else {
						if (type.equals("access")) {
							String abstraction2 = key.split(Pattern.quote("_"))[3]  + "_" +  key.split(Pattern.quote("_"))[4];
							try {
								int row =dataConstraint.insertAccess(projectName.replaceAll("\\/", ""), abstraction, abstraction2, 0);
								dataConstraint.insertAccessRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") ,0,row);
							} catch (Exception e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}
						else
						{
							if (type.equals("not")) {
								String abstraction2 = key.split(Pattern.quote("_"))[4] + "_" + key.split(Pattern.quote("_"))[5];
								abstraction =  key.split(Pattern.quote("_"))[2] + "_" + key.split(Pattern.quote("_"))[3];
								try {
									int row =dataConstraint.insertAccess(projectName.replaceAll("\\/", ""), abstraction, abstraction2, (check.booleanValue() ? 1 : 0 ));
									dataConstraint.insertAccessRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") , (check.booleanValue() ? 1 : 0 ),row);
								} catch (Exception e3) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}								
							}
							else {
								if (type.equals("domain")) {
									
									if (key.split(Pattern.quote("_"))[1].equals("not")) {
										
										String abstraction2 = key.split(Pattern.quote("_"))[4] + "_" + key.split(Pattern.quote("_"))[5];
										abstraction =  key.split(Pattern.quote("_"))[2] + "_" + key.split(Pattern.quote("_"))[3];
										try {
											int row =dataConstraint.insertDomain(projectName.replaceAll("\\/", ""), abstraction, abstraction2, (check.booleanValue() ? 1 : 0 ));
											dataConstraint.insertDomainRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") , (check.booleanValue() ? 1 : 0 ),row);
										} catch (Exception e4) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}							
										
									}
									else
									{
										String abstraction2 = key.split(Pattern.quote("_"))[5] + "_" + key.split(Pattern.quote("_"))[6];
										abstraction =  key.split(Pattern.quote("_"))[3] + "_" + key.split(Pattern.quote("_"))[4];
										try {
											int row =dataConstraint.insertDomain(projectName.replaceAll("\\/", ""), abstraction, abstraction2, (check.booleanValue() ? 1 : 0 ));
											dataConstraint.insertDomainRules(projectName.replaceAll("\\/", ""), key, expressionInOCL.getBody().replaceAll("\'","") , (check.booleanValue() ? 1 : 0 ),row);
										} catch (Exception e5) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}				
									}
								}
							}
						}
					}
				}
			}
		}	
		
		//Update constraints according to the existence of abstractions
		try {
			dataConstraint.checkRealConstraints();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkDrifts(IFile currentArchitecturePath, IFile plannedArchitecturePath) throws SQLException {

		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName);

		int nComponent = this.checkDriftsComponents(currentArchitecturePath, plannedArchitecturePath);
		int nSubsystem = this.checkDriftsSubsystems(currentArchitecturePath, plannedArchitecturePath);
		int nAssociation = this.checkDriftsAssociation(currentArchitecturePath, plannedArchitecturePath);

		try {
			dataConstraint.insertDrifts(projectName.replaceAll("\\/", ""), nComponent, nSubsystem, nAssociation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int checkDriftsComponents(IFile currentArchitecturePath, IFile plannedArchitecturePath) {

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

	public List<Integer> getExistenceAbstractions() throws Exception{

		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName);
		return dataConstraint.getExistenceAbstractions();
	}

	public List<Integer> getCompositeAbstractions() throws Exception{

		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName);
		return dataConstraint.getCompositionAbstractions();
	}

	public List<Integer> getAccessAbstractions() throws Exception{

		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName);
		return dataConstraint.getAccessAbstractions();
	}
	
	public List<Integer> getDomainAbstractions() throws Exception{

		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName);
		return dataConstraint.getDomainAbstractions();
	}

	public List<Integer> getIgnoredValues() throws Exception{

		List<Integer> list = new ArrayList<Integer>();
		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName);
		list.add(dataConstraint.getIgnoredRulesComposition().size());
		list.add(dataConstraint.getIgnoredRulesAccess().size());
		list.add(dataConstraint.getIgnoredRulesDomain().size());
		return list;
	}
	
	public List<Integer> getUntestedValues() throws Exception{

		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName);
		return dataConstraint.getUntestedValues();
	}

	public String getTotalViolations() throws Exception{

		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName);
		return dataConstraint.getTotalViolations();
	}
	
	public String getTotalPassed() throws Exception{

		DataConstraint dataConstraint = new DataConstraint(workspacePath + projectName);
		return dataConstraint.getTotalPassed();
	}
	
}
