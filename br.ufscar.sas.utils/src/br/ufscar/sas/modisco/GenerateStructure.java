package br.ufscar.sas.modisco;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.basex.core.BaseXException;
import org.basex.query.QueryException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.modisco.omg.kdm.action.Addresses;
import org.eclipse.modisco.omg.kdm.action.Calls;
import org.eclipse.modisco.omg.kdm.action.Creates;
import org.eclipse.modisco.omg.kdm.action.ExceptionFlow;
import org.eclipse.modisco.omg.kdm.action.Reads;
import org.eclipse.modisco.omg.kdm.action.Throws;
import org.eclipse.modisco.omg.kdm.action.UsesType;
import org.eclipse.modisco.omg.kdm.action.Writes;
import org.eclipse.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.modisco.omg.kdm.code.Extends;
import org.eclipse.modisco.omg.kdm.code.HasType;
import org.eclipse.modisco.omg.kdm.code.HasValue;
import org.eclipse.modisco.omg.kdm.code.Implements;
import org.eclipse.modisco.omg.kdm.code.Imports;
import org.eclipse.modisco.omg.kdm.code.InterfaceUnit;
import org.eclipse.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.modisco.omg.kdm.code.Package;
import org.eclipse.modisco.omg.kdm.code.StorableUnit;
import org.eclipse.modisco.omg.kdm.core.KDMEntity;
import org.eclipse.modisco.omg.kdm.kdm.KdmPackage;
import org.eclipse.modisco.omg.kdm.structure.Component;
import org.eclipse.modisco.omg.kdm.structure.Subsystem;
import org.eclipse.modisco.omg.kdm.structure.impl.StructurePackageImpl;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Query;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import br.ufscar.sas.database.QueryClass;
import br.ufscar.sas.model.CodeClass;
import br.ufscar.sas.model.CodeField;
import br.ufscar.sas.model.CodeMethod;
import br.ufscar.sas.model.CodePackage;
import br.ufscar.sas.model.CodeVariable;
import br.ufscar.sas.structuretree.Tree;
import br.ufscar.sas.transformation.AddAggregated;
import br.ufscar.sas.transformation.AddImplementation;


public class GenerateStructure {

	private Tree tree = null;

	public GenerateStructure() {

		tree = new Tree();
	}

	public void createTree(String path_) throws Exception
	{
		QueryClass queryClass = new QueryClass(path_);
		List<String> annotation = new ArrayList<String>();
		List<String> belong = new ArrayList<String>();
		List<String> db = queryClass.selectAnnotationBelong();
		List<String> roots = new ArrayList<String>();
		for (String str: db)
		{
			String child = str.split(Pattern.quote("|"))[0];
			String parent = str.split(Pattern.quote("|"))[1];

			annotation.add(child);
			belong.add(parent);

			if (parent.equals("None"))
				roots.add(child);
		}
		tree.addNode("roots", roots);

		for (int i=0; i<annotation.size(); i++) 
		{
			List<String> children = new ArrayList<String>();
			for (int j=0; j<belong.size(); j++) 
				if (annotation.get(i).equals(belong.get(j)))
					children.add(annotation.get(j));
			Set<String> childrenNonDuplicate = new LinkedHashSet<>(children);
			children.clear();
			children.addAll(childrenNonDuplicate);
			tree.addNode(annotation.get(i), children);
		}

	}

	public void createStructureElementFromTree(Manager baseXManager, String path_) throws Exception
	{
		List<String> memory1 = new ArrayList<String>();
		List<String> memory2 = new ArrayList<String>();
		List<String> rootList = tree.getChildren("roots"); 
		memory1.addAll(rootList);
		memory2.addAll(rootList);
		while (!memory1.isEmpty())
		{
			String child = memory1.get(0);
			rootList = tree.getChildren(child);
			Set<String> set = new HashSet<>(rootList);
			rootList.clear();
			rootList.addAll(set);
			if (!rootList.isEmpty())
			{
				for (int i = rootList.size()-1; i >= 0; i--)
				{
					if (i == rootList.size()-1 )
					{
						String parent = memory1.remove(0);
						if (memory2.contains(new String(parent)))
						{
							memory2.remove(new String(parent));
							this.createStructureElement(baseXManager, null, parent, path_);
						}
						memory1.add(0,rootList.get(i));
					}
					else
						memory1.add(0,rootList.get(i));
					this.createStructureElement(baseXManager, child, memory1.get(0),path_);
				}
			}
			else
				memory1.remove(0);

		}
		for (String memory: memory2)
			this.createStructureElement(baseXManager, null, memory, path_);
	}

	public void mapping(IFile kdm, String path_) {

		QueryClass queryClass = null;
		try {

			queryClass = new QueryClass(path_);

			//Packages
			List<CodePackage> lst1 = queryClass.getPackageAnnotations();

			for (CodePackage data: lst1)
			{

				String abstraction = data.getMapping();
				String abstractionType = "";
				String packagePath = data.getPackage_();
				String elementType = "package";
				String codeElement = data.getName();


				if (data.getIdAbstraction() == 1 || data.getIdAbstraction() == 2)
					abstractionType = "subsystem";
				else
					abstractionType = "component";

				if (!abstraction.equals("None"))
				{
					AddImplementation addImplementation = new AddImplementation(abstraction, abstractionType, codeElement, elementType, packagePath);
					addImplementation.createStructureModel(kdm);
				}
			}
			lst1.clear();

			//Classes
			List<CodeClass> lst2 = queryClass.getClassAnnotations();

			for (CodeClass data: lst2)
			{

				String abstraction = data.getMapping();
				String abstractionType = "";
				String codeElement = data.getName();
				String elementType = "class";
				String packages = data.getPackage_();
				String classPath = "";

				classPath = packages + "." + codeElement;

				if (data.getIdAbstraction() ==1 || data.getIdAbstraction() ==2)
					abstractionType = "subsystem";
				else
					abstractionType = "component";

				if (!abstraction.equals("None"))
				{
					AddImplementation addImplementation = new AddImplementation(abstraction, abstractionType, codeElement, elementType, classPath);
					addImplementation.createStructureModel(kdm);
				}
			}

			lst2.clear();

			//Methods
			List<CodeMethod> lst3 = queryClass.getMethodAnnotations();

			for (CodeMethod data: lst3)
			{

				String abstraction = data.getMapping();
				String abstractionType = "";
				String codeElement = data.getName();
				String className = data.getClass_();
				String elementType = "method";
				String packages = data.getPackage_();
				String methodPath = "";

				methodPath = packages + "." + className + "." + codeElement;

				if (data.getIdAbstraction() ==1 || data.getIdAbstraction() ==2)
					abstractionType = "subsystem";
				else
					abstractionType = "component";

				if (!abstraction.equals("None"))
				{
					AddImplementation addImplementation = new AddImplementation(abstraction, abstractionType, codeElement, elementType, methodPath);
					addImplementation.createStructureModel(kdm);
				}
			}
			lst3.clear();

			//Field Class
			List<CodeField> lst4 = queryClass.getFieldClassAnnotations();

			for (CodeField data: lst4)
			{

				String abstraction = data.getMapping();
				String abstractionType = "";
				String codeElement = data.getName();
				String className = data.getClass_();
				String elementType = "field";
				String packages = data.getPackage_();
				String fieldPath = "";


				fieldPath = packages + "." + className + "." + codeElement;

				if (data.getIdAbstraction() ==1 || data.getIdAbstraction() ==2)
					abstractionType = "subsystem";
				else
					abstractionType = "component";


				if (!abstraction.equals("None"))
				{
					AddImplementation addImplementation = new AddImplementation(abstraction, abstractionType, codeElement, elementType, fieldPath);
					addImplementation.createStructureModel(kdm);
				}
			}
			lst4.clear();


			//Variables Class
			List<CodeVariable> lst5 = queryClass.getVariableAnnotations();

			for (CodeVariable data: lst5)
			{

				String abstraction = data.getMapping();
				String abstractionType = "";
				String codeElement = data.getName();
				String elementType = "variable";
				String className = data.getName();
				String methodName = data.getMethod();
				String packages = data.getPackage_();
				String varPath = "";

				varPath = packages + "." + className + "."+  methodName + "." + codeElement;

				if (data.getIdAbstraction() ==1 || data.getIdAbstraction() ==2)
					abstractionType = "subsystem";
				else
					abstractionType = "component";

				if (!abstraction.equals("None"))
				{
					AddImplementation addImplementation = new AddImplementation(abstraction, abstractionType, codeElement, elementType, varPath);
					addImplementation.createStructureModel(kdm);
				}
			}
			lst5.clear();
			
			//Interface 
			List<CodeClass> lst6 = queryClass.getInterfaceAnnotations();

			for (CodeClass data: lst6)
			{

				String abstraction = data.getMapping();
				String abstractionType = "";
				String codeElement = data.getName();
				String elementType = "interface";
				String packages = data.getPackage_();
				String classPath = "";

				classPath = packages + "." + codeElement;

				if (data.getIdAbstraction() ==1 || data.getIdAbstraction() ==2)
					abstractionType = "subsystem";
				else
					abstractionType = "component";

				if (!abstraction.equals("None"))
				{
					AddImplementation addImplementation = new AddImplementation(abstraction, abstractionType, codeElement, elementType, classPath);
					addImplementation.createStructureModel(kdm);
				}
			}
			lst5.clear();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void relationshipsSubsystem(IFile kdm, String databasePath) throws Exception {

		KdmPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource kdmResource = resourceSet.getResource(URI.createURI(kdm.getFullPath().toString()), true);	
		kdmResource.load(null);

		String sQuery = "Subsystem.allInstances()";
		org.eclipse.ocl.ecore.OCL.initialize(resourceSet);
		OCL ocl  = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE, kdmResource);
		OCLHelper helper = ocl.createOCLHelper();
		helper.setContext(StructurePackageImpl.eINSTANCE.getEClassifier("Subsystem"));
		OCLExpression query = helper.createQuery(sQuery);
		Query queryEval = ocl.createQuery(query);

		HashSet<Subsystem> subsystemHashSet  = (HashSet<Subsystem>) queryEval.evaluate(query);
		List<Subsystem> subsystem = new ArrayList<Subsystem>(subsystemHashSet);

		for (Subsystem c : subsystem) {

			for (int j=0; j< c.getImplementation().size(); j++) {

				KDMEntity kdmEntity = c.getImplementation().get(j); 

				if (kdmEntity instanceof ClassUnit) {

					ClassUnit classUnit = (ClassUnit) kdmEntity;
					List<Calls> toCalls 					= this.getCalls(classUnit);
					List<UsesType> toUsesType 	 			= this.getUsesType(classUnit);
					List<Creates> toCreates  	 			= this.getCreates(classUnit);
					List<ExceptionFlow> toExceptionFlow 	= this.getExceptionFlow(classUnit);
					List<Throws> toThrows 					= this.getThrows(classUnit);
					List<Addresses> toAddresses 			= this.getAddresses(classUnit);
					List<Writes> toWrites 					= this.getWrites(classUnit);
					List<Reads> toReads 					= this.getReads(classUnit);
					List<HasValue> toHasValue 				= this.getHasValue(classUnit);
					List<Extends> toExtends 				= this.getExtends(classUnit);
					List<Implements> toImplements 			= this.getImplements(classUnit);
					List<Imports> toImports 				= this.getImports(classUnit);
					List<HasType> toHasType 				= this.getHasType(classUnit);
					
					this.createRelationShip(toCalls,toUsesType,toCreates,toExceptionFlow,toThrows,toAddresses,toWrites,			
							toReads,toHasValue,toExtends,toImplements,toImports,toHasType,c,classUnit,databasePath,kdm);
				}
				else {

					if (kdmEntity instanceof MethodUnit) {

						MethodUnit methodUnit = (MethodUnit) kdmEntity;
						List<Calls> toCalls 					= this.getCalls(methodUnit);
						List<UsesType> toUsesType 	 			= this.getUsesType(methodUnit);
						List<Creates> toCreates  	 			= this.getCreates(methodUnit);
						List<ExceptionFlow> toExceptionFlow 	= this.getExceptionFlow(methodUnit);
						List<Throws> toThrows 					= this.getThrows(methodUnit);
						List<Addresses> toAddresses 			= this.getAddresses(methodUnit);
						List<Writes> toWrites 					= this.getWrites(methodUnit);
						List<Reads> toReads 					= this.getReads(methodUnit);
						List<HasValue> toHasValue 				= this.getHasValue(methodUnit);
						List<Extends> toExtends 				= this.getExtends(methodUnit);
						List<Implements> toImplements 			= this.getImplements(methodUnit);
						List<Imports> toImports 				= this.getImports(methodUnit);
						List<HasType> toHasType 				= this.getHasType(methodUnit);
						
						this.createRelationShip(toCalls,toUsesType,toCreates,toExceptionFlow,toThrows,toAddresses,toWrites,			
								toReads,toHasValue,toExtends,toImplements,toImports,toHasType,c,methodUnit,databasePath,kdm);
					}
					else
					{
						if (kdmEntity instanceof Package) {

							Package package_ = (Package) kdmEntity;
							List<Calls> toCalls 					= this.getCalls(package_);
							List<UsesType> toUsesType 	 			= this.getUsesType(package_);
							List<Creates> toCreates  	 			= this.getCreates(package_);
							List<ExceptionFlow> toExceptionFlow 	= this.getExceptionFlow(package_);
							List<Throws> toThrows 					= this.getThrows(package_);
							List<Addresses> toAddresses 			= this.getAddresses(package_);
							List<Writes> toWrites 					= this.getWrites(package_);
							List<Reads> toReads 					= this.getReads(package_);
							List<HasValue> toHasValue 				= this.getHasValue(package_);
							List<Extends> toExtends 				= this.getExtends(package_);
							List<Implements> toImplements 			= this.getImplements(package_);
							List<Imports> toImports 				= this.getImports(package_);
							List<HasType> toHasType 				= this.getHasType(package_);
							
							this.createRelationShip(toCalls,toUsesType,toCreates,toExceptionFlow,toThrows,toAddresses,toWrites,			
									toReads,toHasValue,toExtends,toImplements,toImports,toHasType,c,package_,databasePath,kdm);

						}
						else
						{
							if (kdmEntity instanceof StorableUnit) {

								StorableUnit storableUnit = (StorableUnit) kdmEntity;
								List<Calls> toCalls 					= this.getCalls(storableUnit);
								List<UsesType> toUsesType 	 			= this.getUsesType(storableUnit);
								List<Creates> toCreates  	 			= this.getCreates(storableUnit);
								List<ExceptionFlow> toExceptionFlow 	= this.getExceptionFlow(storableUnit);
								List<Throws> toThrows 					= this.getThrows(storableUnit);
								List<Addresses> toAddresses 			= this.getAddresses(storableUnit);
								List<Writes> toWrites 					= this.getWrites(storableUnit);
								List<Reads> toReads 					= this.getReads(storableUnit);
								List<HasValue> toHasValue 				= this.getHasValue(storableUnit);
								List<Extends> toExtends 				= this.getExtends(storableUnit);
								List<Implements> toImplements 			= this.getImplements(storableUnit);
								List<Imports> toImports 				= this.getImports(storableUnit);
								List<HasType> toHasType 				= this.getHasType(storableUnit);
								
								this.createRelationShip(toCalls,toUsesType,toCreates,toExceptionFlow,toThrows,toAddresses,toWrites,			
										toReads,toHasValue,toExtends,toImplements,toImports,toHasType,c,storableUnit,databasePath,kdm);

							} 
							else
							{

								if (kdmEntity instanceof InterfaceUnit) {

									InterfaceUnit interfaceUnit = (InterfaceUnit) kdmEntity;
									List<Calls> toCalls 					= this.getCalls(interfaceUnit);
									List<UsesType> toUsesType 	 			= this.getUsesType(interfaceUnit);
									List<Creates> toCreates  	 			= this.getCreates(interfaceUnit);
									List<ExceptionFlow> toExceptionFlow 	= this.getExceptionFlow(interfaceUnit);
									List<Throws> toThrows 					= this.getThrows(interfaceUnit);
									List<Addresses> toAddresses 			= this.getAddresses(interfaceUnit);
									List<Writes> toWrites 					= this.getWrites(interfaceUnit);
									List<Reads> toReads 					= this.getReads(interfaceUnit);
									List<HasValue> toHasValue 				= this.getHasValue(interfaceUnit);
									List<Extends> toExtends 				= this.getExtends(interfaceUnit);
									List<Implements> toImplements 			= this.getImplements(interfaceUnit);
									List<Imports> toImports 				= this.getImports(interfaceUnit);
									List<HasType> toHasType 				= this.getHasType(interfaceUnit);
									
									this.createRelationShip(toCalls,toUsesType,toCreates,toExceptionFlow,toThrows,toAddresses,toWrites,			
											toReads,toHasValue,toExtends,toImplements,toImports,toHasType,c,interfaceUnit,databasePath,kdm);
								}
							}
						}
					}
				}
			}
		}
	}

	public void relationshipsComponent(IFile kdm, String databasePath) throws Exception {

		KdmPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource kdmResource = resourceSet.getResource(URI.createURI(kdm.getFullPath().toString()), true);	
		kdmResource.load(null);

		String sQuery = "Component.allInstances()";
		org.eclipse.ocl.ecore.OCL.initialize(resourceSet);
		OCL ocl  = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE, kdmResource);
		OCLHelper helper = ocl.createOCLHelper();
		helper.setContext(StructurePackageImpl.eINSTANCE.getEClassifier("Component"));
		OCLExpression query = helper.createQuery(sQuery);
		Query queryEval = ocl.createQuery(query);

		HashSet<Component> componentHashSet  = (HashSet<Component>) queryEval.evaluate(query);
		List<Component> component = new ArrayList<Component>(componentHashSet);

		for (Component c : component) {

			for (int j=0; j< c.getImplementation().size(); j++) {

				KDMEntity kdmEntity = c.getImplementation().get(j); 
				if (kdmEntity instanceof ClassUnit) {

					ClassUnit classUnit = (ClassUnit) kdmEntity;
					List<Calls> toCalls 					= this.getCalls(classUnit);
					List<UsesType> toUsesType 	 			= this.getUsesType(classUnit);
					List<Creates> toCreates  	 			= this.getCreates(classUnit);
					List<ExceptionFlow> toExceptionFlow 	= this.getExceptionFlow(classUnit);
					List<Throws> toThrows 					= this.getThrows(classUnit);
					List<Addresses> toAddresses 			= this.getAddresses(classUnit);
					List<Writes> toWrites 					= this.getWrites(classUnit);
					List<Reads> toReads 					= this.getReads(classUnit);
					List<HasValue> toHasValue 				= this.getHasValue(classUnit);
					List<Extends> toExtends 				= this.getExtends(classUnit);
					List<Implements> toImplements 			= this.getImplements(classUnit);
					List<Imports> toImports 				= this.getImports(classUnit);
					List<HasType> toHasType 				= this.getHasType(classUnit);

					this.createRelationShip(toCalls,toUsesType,toCreates,toExceptionFlow,toThrows,toAddresses,toWrites,			
							toReads,toHasValue,toExtends,toImplements,toImports,toHasType,c,classUnit,databasePath,kdm);

				}
				else {

					if (kdmEntity instanceof MethodUnit) {

						MethodUnit methodUnit = (MethodUnit) kdmEntity;
						List<Calls> toCalls 					= this.getCalls(methodUnit);
						List<UsesType> toUsesType 	 			= this.getUsesType(methodUnit);
						List<Creates> toCreates  	 			= this.getCreates(methodUnit);
						List<ExceptionFlow> toExceptionFlow 	= this.getExceptionFlow(methodUnit);
						List<Throws> toThrows 					= this.getThrows(methodUnit);
						List<Addresses> toAddresses 			= this.getAddresses(methodUnit);
						List<Writes> toWrites 					= this.getWrites(methodUnit);
						List<Reads> toReads 					= this.getReads(methodUnit);
						List<HasValue> toHasValue 				= this.getHasValue(methodUnit);
						List<Extends> toExtends 				= this.getExtends(methodUnit);
						List<Implements> toImplements 			= this.getImplements(methodUnit);
						List<Imports> toImports 				= this.getImports(methodUnit);
						List<HasType> toHasType 				= this.getHasType(methodUnit);
						this.createRelationShip(toCalls,toUsesType,toCreates,toExceptionFlow,toThrows,toAddresses,toWrites,			
								toReads,toHasValue,toExtends,toImplements,toImports,toHasType,c,methodUnit,databasePath,kdm);
					}
					else
					{
						if (kdmEntity instanceof Package) {

							Package package_ = (Package) kdmEntity;
							List<Calls> toCalls 					= this.getCalls(package_);
							List<UsesType> toUsesType 	 			= this.getUsesType(package_);
							List<Creates> toCreates  	 			= this.getCreates(package_);
							List<ExceptionFlow> toExceptionFlow 	= this.getExceptionFlow(package_);
							List<Throws> toThrows 					= this.getThrows(package_);
							List<Addresses> toAddresses 			= this.getAddresses(package_);
							List<Writes> toWrites 					= this.getWrites(package_);
							List<Reads> toReads 					= this.getReads(package_);
							List<HasValue> toHasValue 				= this.getHasValue(package_);
							List<Extends> toExtends 				= this.getExtends(package_);
							List<Implements> toImplements 			= this.getImplements(package_);
							List<Imports> toImports 				= this.getImports(package_);
							List<HasType> toHasType 				= this.getHasType(package_);

							this.createRelationShip(toCalls,toUsesType,toCreates,toExceptionFlow,toThrows,toAddresses,toWrites,			
									toReads,toHasValue,toExtends,toImplements,toImports,toHasType,c,package_,databasePath,kdm);

						}
						else
						{
							if (kdmEntity instanceof StorableUnit) {

								StorableUnit storableUnit = (StorableUnit) kdmEntity;
								List<Calls> toCalls 					= this.getCalls(storableUnit);
								List<UsesType> toUsesType 	 			= this.getUsesType(storableUnit);
								List<Creates> toCreates  	 			= this.getCreates(storableUnit);
								List<ExceptionFlow> toExceptionFlow 	= this.getExceptionFlow(storableUnit);
								List<Throws> toThrows 					= this.getThrows(storableUnit);
								List<Addresses> toAddresses 			= this.getAddresses(storableUnit);
								List<Writes> toWrites 					= this.getWrites(storableUnit);
								List<Reads> toReads 					= this.getReads(storableUnit);
								List<HasValue> toHasValue 				= this.getHasValue(storableUnit);
								List<Extends> toExtends 				= this.getExtends(storableUnit);
								List<Implements> toImplements 			= this.getImplements(storableUnit);
								List<Imports> toImports 				= this.getImports(storableUnit);
								List<HasType> toHasType 				= this.getHasType(storableUnit);

								this.createRelationShip(toCalls,toUsesType,toCreates,toExceptionFlow,toThrows,toAddresses,toWrites,			
										toReads,toHasValue,toExtends,toImplements,toImports,toHasType,c,storableUnit,databasePath,kdm);

							} 
							else
							{

								if (kdmEntity instanceof InterfaceUnit) {

									InterfaceUnit interfaceUnit = (InterfaceUnit) kdmEntity;
									List<Calls> toCalls 					= this.getCalls(interfaceUnit);
									List<UsesType> toUsesType 	 			= this.getUsesType(interfaceUnit);
									List<Creates> toCreates  	 			= this.getCreates(interfaceUnit);
									List<ExceptionFlow> toExceptionFlow 	= this.getExceptionFlow(interfaceUnit);
									List<Throws> toThrows 					= this.getThrows(interfaceUnit);
									List<Addresses> toAddresses 			= this.getAddresses(interfaceUnit);
									List<Writes> toWrites 					= this.getWrites(interfaceUnit);
									List<Reads> toReads 					= this.getReads(interfaceUnit);
									List<HasValue> toHasValue 				= this.getHasValue(interfaceUnit);
									List<Extends> toExtends 				= this.getExtends(interfaceUnit);
									List<Implements> toImplements 			= this.getImplements(interfaceUnit);
									List<Imports> toImports 				= this.getImports(interfaceUnit);
									List<HasType> toHasType 				= this.getHasType(interfaceUnit);

									this.createRelationShip(toCalls,toUsesType,toCreates,toExceptionFlow,toThrows,toAddresses,toWrites,			
											toReads,toHasValue,toExtends,toImplements,toImports,toHasType,c,interfaceUnit,databasePath,kdm);
								}
							}
						}
					}
				}
			}
		}
	}

	private List<Calls> getCalls(KDMEntity entity) {

		List<Calls> elements = new ArrayList<Calls>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof Calls) {
				Calls relation = (Calls) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	private List<UsesType> getUsesType(KDMEntity entity)  {

		List<UsesType> elements = new ArrayList<UsesType>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof UsesType) {
				UsesType relation = (UsesType) eo;
				elements.add(relation);
			}
		}
		return elements;
	} 

	private List<Creates> getCreates(KDMEntity entity) {

		List<Creates> elements = new ArrayList<Creates>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof Creates) {
				Creates relation = (Creates) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	private List<ExceptionFlow> getExceptionFlow(KDMEntity entity) {

		List<ExceptionFlow> elements = new ArrayList<ExceptionFlow>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof ExceptionFlow) {
				ExceptionFlow relation = (ExceptionFlow) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	private List<Throws> getThrows(KDMEntity entity) {

		List<Throws> elements = new ArrayList<Throws>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof Throws) {
				Throws relation = (Throws) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	private List<Addresses> getAddresses(KDMEntity entity) {

		List<Addresses> elements = new ArrayList<Addresses>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof Addresses) {
				Addresses relation = (Addresses) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	private List<Writes> getWrites(KDMEntity entity) {

		List<Writes> elements = new ArrayList<Writes>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof Writes) {
				Writes relation = (Writes) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	private List<Reads> getReads(KDMEntity entity) {

		List<Reads> elements = new ArrayList<Reads>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof Reads) {
				Reads relation = (Reads) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	private List<HasValue> getHasValue(KDMEntity entity) {

		List<HasValue> elements = new ArrayList<HasValue>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof HasValue) {
				HasValue relation = (HasValue) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	private List<Extends> getExtends(KDMEntity entity) {

		List<Extends> elements = new ArrayList<Extends>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof Extends) {
				Extends relation = (Extends) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	private List<Implements> getImplements(KDMEntity entity) {

		List<Implements> elements = new ArrayList<Implements>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof Implements) {
				Implements relation = (Implements) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	private List<Imports> getImports(KDMEntity entity) {

		List<Imports> elements = new ArrayList<Imports>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof Imports) {
				Imports relation = (Imports) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	private List<HasType> getHasType(KDMEntity entity) {

		List<HasType> elements = new ArrayList<HasType>();
		TreeIterator<EObject> it = entity.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();

			if (eo instanceof HasType) {
				HasType relation = (HasType) eo;
				elements.add(relation);
			}
		}
		return elements;
	}

	public void createRelationShip(List<Calls> toCalls, 			
			List<UsesType> toUsesType 	 			,
			List<Creates> toCreates  	 			,
			List<ExceptionFlow> toExceptionFlow 		,
			List<Throws> toThrows 				,
			List<Addresses> toAddresses 	,
			List<Writes> toWrites 				,
			List<Reads> toReads 				,
			List<HasValue> toHasValue 	,
			List<Extends> toExtends 				,
			List<Implements> toImplements 			,
			List<Imports> toImports 				,
			List<HasType> toHasType 				,
			KDMEntity abstraction,
			KDMEntity from,
			String databasePath,
			IFile kdm) throws Exception {

		QueryClass query = new QueryClass(databasePath);
		List<CodePackage> package_ = query.getPackageAnnotations();
		List<CodeClass> class_ = query.getClassAnnotations();
		class_.addAll(query.getInterfaceAnnotations());
		List<CodeField> field = query.getFieldClassAnnotations();
		List<CodeMethod> method = query.getMethodAnnotations();
		List<CodeVariable> variable = query.getVariableAnnotations();

		//Package
		List<CodePackage> filteredPackage1 = package_.stream().
				filter(e -> foundCalls(e,toCalls)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified1 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage1)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());

			Set<Calls> relation = toCalls.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Calls c:relation)
				codePackage.addKDMRelationship(c);

			filteredPackageModified1.add(codePackage);
		}

		List<CodePackage> filteredPackage2 = package_.stream().
				filter(e -> foundUsesType(e,toUsesType)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified2 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage2)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());

			Set<UsesType> relation = toUsesType.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (UsesType c:relation)
				codePackage.addKDMRelationship(c);
			filteredPackageModified2.add(codePackage);
		}

		List<CodePackage> filteredPackage3 = package_.stream().
				filter(e -> foundCreates(e,toCreates)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified3 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage3)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Creates> relation = toCreates.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Creates c:relation)
				codePackage.addKDMRelationship(c);
			filteredPackageModified3.add(codePackage);
		}

		List<CodePackage> filteredPackage4 = package_.stream().
				filter(e -> foundExceptionFlow(e,toExceptionFlow)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified4 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage4)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());

			Set<ExceptionFlow> relationExceptionFlow = new HashSet<ExceptionFlow>();
			for (ExceptionFlow relation : toExceptionFlow)
			{
				TreeIterator<EObject> tree = relation.getTo().eAllContents();
				while (tree.hasNext()) {

					EObject eoTree = tree.next();
					if (eoTree instanceof StorableUnit) {
						StorableUnit storableUnit = (StorableUnit) eoTree;
						if (storableUnit.getName().equals(p.getName()))
							relationExceptionFlow.add(relation);
					}
				}
			}

			for (ExceptionFlow c:relationExceptionFlow)
				codePackage.addKDMRelationship(c);
			filteredPackageModified4.add(codePackage);
		}


		List<CodePackage> filteredPackage5 = package_.stream().
				filter(e -> foundThrows(e,toThrows)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified5 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage5)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Throws> relation = toThrows.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Throws c:relation)
				codePackage.addKDMRelationship(c);
			filteredPackageModified5.add(codePackage);
		}

		List<CodePackage> filteredPackage6 = package_.stream().
				filter(e -> foundAddresses(e,toAddresses)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified6 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage6)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Addresses> relation = toAddresses.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Addresses c:relation)
				codePackage.addKDMRelationship(c);
			filteredPackageModified6.add(codePackage);
		}

		List<CodePackage> filteredPackage7 = package_.stream().
				filter(e -> foundWrites(e,toWrites)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified7 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage7)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Writes> relation = toWrites.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Writes c:relation)
				codePackage.addKDMRelationship(c);
			filteredPackageModified7.add(codePackage);
		}

		List<CodePackage> filteredPackage8 = package_.stream().
				filter(e -> foundReads(e,toReads)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified8 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage8)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Reads> relation = toReads.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Reads c:relation)
				codePackage.addKDMRelationship(c);
			filteredPackageModified8.add(codePackage);
		}

		List<CodePackage> filteredPackage9 = package_.stream().
				filter(e -> foundHasValue(e,toHasValue)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified9 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage9)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<HasValue> relation = toHasValue.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (HasValue c:relation)
				codePackage.addKDMRelationship(c);
			filteredPackageModified9.add(codePackage);
		}

		List<CodePackage> filteredPackage10 = package_.stream().
				filter(e -> foundExtends(e,toExtends)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified10 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage10)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Extends> relation = toExtends.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Extends c:relation)
				codePackage.addKDMRelationship(c);
			filteredPackageModified10.add(codePackage);
		}

		List<CodePackage> filteredPackage11 = package_.stream().
				filter(e -> foundImplements(e,toImplements)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified11 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage11)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Implements> relation = toImplements.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Implements c:relation)
				codePackage.addKDMRelationship(c);
			filteredPackageModified11.add(codePackage);
		}

		List<CodePackage> filteredPackage12 = package_.stream().
				filter(e -> foundImports(e,toImports)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified12 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage12)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Imports> relation = toImports.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Imports c:relation)
				codePackage.addKDMRelationship(c);
			filteredPackageModified12.add(codePackage);
		}

		List<CodePackage> filteredPackage13 = package_.stream().
				filter(e -> foundHasType(e,toHasType)).
				collect(Collectors.toList());
		List<CodePackage> filteredPackageModified13 = new ArrayList<CodePackage>();
		for (CodePackage p: filteredPackage13)  {

			CodePackage codePackage = new CodePackage(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<HasType> relation = toHasType.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (HasType c:relation)
				codePackage.addKDMRelationship(c);
			filteredPackageModified13.add(codePackage);
		}


		//Class

		List<CodeClass> filteredClass1 = class_.stream().
				filter(e -> foundCalls(e,toCalls)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified1 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass1)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Calls> relation = toCalls.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Calls c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified1.add(codeClass);
		}

		List<CodeClass> filteredClass2 = class_.stream().
				filter(e -> foundUsesType(e,toUsesType)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified2 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass2)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<UsesType> relation = toUsesType.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (UsesType c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified2.add(codeClass);
		}


		List<CodeClass> filteredClass3 = class_.stream().
				filter(e -> foundCreates(e,toCreates)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified3 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass3)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Creates> relation = toCreates.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Creates c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified3.add(codeClass);
		}

		List<CodeClass> filteredClass4 = class_.stream().
				filter(e -> foundExceptionFlow(e,toExceptionFlow)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified4 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass4)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());

			Set<ExceptionFlow> relationExceptionFlow = new HashSet<ExceptionFlow>();
			for (ExceptionFlow relation : toExceptionFlow)
			{
				TreeIterator<EObject> tree = relation.getTo().eAllContents();
				while (tree.hasNext()) {

					EObject eoTree = tree.next();
					if (eoTree instanceof StorableUnit) {
						StorableUnit storableUnit = (StorableUnit) eoTree;
						if (storableUnit.getName().equals(p.getName()))
							relationExceptionFlow.add(relation);
					}
				}
			}

			for (ExceptionFlow c:relationExceptionFlow)
				codeClass.addKDMRelationship(c);
			filteredClassModified4.add(codeClass);
		}

		List<CodeClass> filteredClass5 = class_.stream().
				filter(e -> foundThrows(e,toThrows)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified5 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass5)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Throws> relation = toThrows.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Throws c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified5.add(codeClass);
		}

		List<CodeClass> filteredClass6 = class_.stream().
				filter(e -> foundAddresses(e,toAddresses)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified6 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass6)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Addresses> relation = toAddresses.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Addresses c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified6.add(codeClass);
		}

		List<CodeClass> filteredClass7 = class_.stream().
				filter(e -> foundWrites(e,toWrites)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified7 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass7)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Writes> relation = toWrites.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Writes c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified7.add(codeClass);
		}

		List<CodeClass> filteredClass8 = class_.stream().
				filter(e -> foundReads(e,toReads)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified8 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass8)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Reads> relation = toReads.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Reads c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified8.add(codeClass);
		}

		List<CodeClass> filteredClass9 = class_.stream().
				filter(e -> foundHasValue(e,toHasValue)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified9 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass9)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<HasValue> relation = toHasValue.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (HasValue c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified9.add(codeClass);
		}

		List<CodeClass> filteredClass10 = class_.stream().
				filter(e -> foundExtends(e,toExtends)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified10 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass10)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Extends> relation = toExtends.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Extends c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified10.add(codeClass);
		}

		List<CodeClass> filteredClass11 = class_.stream().
				filter(e -> foundImplements(e,toImplements)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified11 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass11)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Implements> relation = toImplements.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Implements c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified11.add(codeClass);
		}

		List<CodeClass> filteredClass12 = class_.stream().
				filter(e -> foundImports(e,toImports)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified12 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass12)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Imports> relation = toImports.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Imports c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified12.add(codeClass);
		}

		List<CodeClass> filteredClass13 = class_.stream().
				filter(e -> foundHasType(e,toHasType)).
				collect(Collectors.toList());
		List<CodeClass> filteredClassModified13 = new ArrayList<CodeClass>();
		for (CodeClass p: filteredClass13)  {

			CodeClass codeClass = new CodeClass(p.getProjectName(), 
					p.getPackage_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<HasType> relation = toHasType.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (HasType c:relation)
				codeClass.addKDMRelationship(c);
			filteredClassModified13.add(codeClass);
		}

		//Field

		List<CodeField> filteredField1 = field.stream().
				filter(e -> foundCalls(e,toCalls)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified1 = new ArrayList<CodeField>();
		for (CodeField p: filteredField1)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Calls> relation = toCalls.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Calls c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified1.add(codeField);

		}

		List<CodeField> filteredField2 = field.stream().
				filter(e -> foundHasType(e,toHasType)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified2 = new ArrayList<CodeField>();
		for (CodeField p: filteredField2)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<HasType> relation = toHasType.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (HasType c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified2.add(codeField);

		}

		List<CodeField> filteredField3 = field.stream().
				filter(e -> foundUsesType(e,toUsesType)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified3 = new ArrayList<CodeField>();
		for (CodeField p: filteredField3)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<UsesType> relation = toUsesType.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (UsesType c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified3.add(codeField);

		}

		List<CodeField> filteredField4 = field.stream().
				filter(e -> foundCreates(e,toCreates)).
				collect(Collectors.toList()); 
		List<CodeField> filteredFieldModified4 = new ArrayList<CodeField>();
		for (CodeField p: filteredField4)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Creates> relation = toCreates.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Creates c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified4.add(codeField);

		}

		List<CodeField> filteredField5 = field.stream().
				filter(e -> foundExceptionFlow(e,toExceptionFlow)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified5 = new ArrayList<CodeField>();
		for (CodeField p: filteredField5)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<ExceptionFlow> relationExceptionFlow = new HashSet<ExceptionFlow>();
			for (ExceptionFlow relation : toExceptionFlow)
			{
				TreeIterator<EObject> tree = relation.getTo().eAllContents();
				while (tree.hasNext()) {

					EObject eoTree = tree.next();
					if (eoTree instanceof StorableUnit) {
						StorableUnit storableUnit = (StorableUnit) eoTree;
						if (storableUnit.getName().equals(p.getName()))
							relationExceptionFlow.add(relation);
					}
				}
			}

			for (ExceptionFlow c:relationExceptionFlow)
				codeField.addKDMRelationship(c);
			filteredFieldModified5.add(codeField);

		}

		List<CodeField> filteredField6 = field.stream().
				filter(e -> foundThrows(e,toThrows)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified6 = new ArrayList<CodeField>();
		for (CodeField p: filteredField6)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Throws> relation = toThrows.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Throws c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified6.add(codeField);

		}
		List<CodeField> filteredField7 = field.stream().
				filter(e -> foundAddresses(e,toAddresses)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified7 = new ArrayList<CodeField>();
		for (CodeField p: filteredField7) {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Addresses> relation = toAddresses.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Addresses c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified7.add(codeField);
		}

		List<CodeField> filteredField8 = field.stream().
				filter(e -> foundWrites(e,toWrites)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified8 = new ArrayList<CodeField>();
		for (CodeField p: filteredField8)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Writes> relation = toWrites.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Writes c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified8.add(codeField);

		}

		List<CodeField> filteredField9 = field.stream().
				filter(e -> foundReads(e,toReads)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified9 = new ArrayList<CodeField>();
		for (CodeField p: filteredField9)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Reads> relation = toReads.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Reads c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified9.add(codeField);

		}
		List<CodeField> filteredField10 = field.stream().
				filter(e -> foundHasValue(e,toHasValue)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified10 = new ArrayList<CodeField>();
		for (CodeField p: filteredField10)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<HasValue> relation = toHasValue.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (HasValue c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified10.add(codeField);

		}

		List<CodeField> filteredField11 = field.stream().
				filter(e -> foundExtends(e,toExtends)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified11 = new ArrayList<CodeField>();
		for (CodeField p: filteredField11)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Extends> relation = toExtends.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Extends c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified11.add(codeField);

		}
		List<CodeField> filteredField12 = field.stream().
				filter(e -> foundImplements(e,toImplements)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified12 = new ArrayList<CodeField>();
		for (CodeField p: filteredField12)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Implements> relation = toImplements.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Implements c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified12.add(codeField);

		}

		List<CodeField> filteredField13 = field.stream().
				filter(e -> foundImports(e,toImports)).
				collect(Collectors.toList());
		List<CodeField> filteredFieldModified13 = new ArrayList<CodeField>();
		for (CodeField p: filteredField13)  {

			CodeField codeField = new CodeField(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Imports> relation = toImports.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Imports c:relation)
				codeField.addKDMRelationship(c);
			filteredFieldModified13.add(codeField);

		}

		//Method

		List<CodeMethod> filteredMethod1 = method.stream().
				filter(e -> foundCalls(e,toCalls)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified1 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod1)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Calls> relation = toCalls.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Calls c:relation)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified1.add(codeMethod);

		}

		List<CodeMethod> filteredMethod2 = method.stream().
				filter(e -> foundHasType(e,toHasType)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified2 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod2)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<HasType> relation = toHasType.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (HasType c:relation)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified2.add(codeMethod);

		}

		List<CodeMethod> filteredMethod3 = method.stream().
				filter(e -> foundUsesType(e,toUsesType)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified3 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod3)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<UsesType> relation = toUsesType.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (UsesType c:relation)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified3.add(codeMethod);
		}

		List<CodeMethod> filteredMethod4 = method.stream().
				filter(e -> foundCreates(e,toCreates)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified4 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod4)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Creates> relation = toCreates.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Creates c:relation)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified4.add(codeMethod);
		}

		List<CodeMethod> filteredMethod5 = method.stream().
				filter(e -> foundExceptionFlow(e,toExceptionFlow)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified5 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod5)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<ExceptionFlow> relationExceptionFlow = new HashSet<ExceptionFlow>();
			for (ExceptionFlow relation : toExceptionFlow)
			{
				TreeIterator<EObject> tree = relation.getTo().eAllContents();
				while (tree.hasNext()) {

					EObject eoTree = tree.next();
					if (eoTree instanceof StorableUnit) {
						StorableUnit storableUnit = (StorableUnit) eoTree;
						if (storableUnit.getName().equals(p.getName()))
							relationExceptionFlow.add(relation);
					}
				}
			}

			for (ExceptionFlow c:relationExceptionFlow)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified5.add(codeMethod);
		}

		List<CodeMethod> filteredMethod6 = method.stream().
				filter(e -> foundThrows(e,toThrows)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified6 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod6)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Throws> relation = toThrows.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Throws c:relation)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified6.add(codeMethod);
		}

		List<CodeMethod> filteredMethod7 = method.stream().
				filter(e -> foundAddresses(e,toAddresses)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified7 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod7)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Addresses> relation = toAddresses.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Addresses c:relation)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified7.add(codeMethod);
		}

		List<CodeMethod> filteredMethod8 = method.stream().
				filter(e -> foundWrites(e,toWrites)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified8 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod8)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Writes> relation = toWrites.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Writes c:relation)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified8.add(codeMethod);
		}

		List<CodeMethod> filteredMethod9 = method.stream().
				filter(e -> foundReads(e,toReads)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified9 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod9)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Reads> relation = toReads.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Reads c:relation)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified9.add(codeMethod);
		}

		List<CodeMethod> filteredMethod10 = method.stream().
				filter(e -> foundHasValue(e,toHasValue)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified10 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod10)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<ExceptionFlow> relationExceptionFlow = new HashSet<ExceptionFlow>();
			for (ExceptionFlow relation : toExceptionFlow)
			{
				TreeIterator<EObject> tree = relation.getTo().eAllContents();
				while (tree.hasNext()) {

					EObject eoTree = tree.next();
					if (eoTree instanceof StorableUnit) {
						StorableUnit storableUnit = (StorableUnit) eoTree;
						if (storableUnit.getName().equals(p.getName()))
							relationExceptionFlow.add(relation);
					}
				}
			}

			for (ExceptionFlow c:relationExceptionFlow)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified10.add(codeMethod);
		}

		List<CodeMethod> filteredMethod11 = method.stream().
				filter(e -> foundExtends(e,toExtends)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified11 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod11)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Extends> relation = toExtends.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Extends c:relation)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified11.add(codeMethod);
		}

		List<CodeMethod> filteredMethod12 = method.stream().
				filter(e -> foundImplements(e,toImplements)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified12 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod12)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Implements> relation = toImplements.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Implements c:relation)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified12.add(codeMethod);
		}

		List<CodeMethod> filteredMethod13 = method.stream().
				filter(e -> foundImports(e,toImports)).
				collect(Collectors.toList());
		List<CodeMethod> filteredMethodModified13 = new ArrayList<CodeMethod>();
		for (CodeMethod p: filteredMethod13)  {

			CodeMethod codeMethod = new CodeMethod(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Imports> relation = toImports.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Imports c:relation)
				codeMethod.addKDMRelationship(c);
			filteredMethodModified13.add(codeMethod);
		}

		//Variables

		List<CodeVariable> filteredVariable1 = variable.stream().
				filter(e -> foundCalls(e,toCalls)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified1 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable1)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Calls> relation = toCalls.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Calls c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified1.add(codeVariable);
		}

		List<CodeVariable> filteredVariable2 = variable.stream().
				filter(e -> foundHasType(e,toHasType)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified2 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable2)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<HasType> relation = toHasType.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (HasType c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified2.add(codeVariable);
		}

		List<CodeVariable> filteredVariable3 = variable.stream().
				filter(e -> foundUsesType(e,toUsesType)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified3 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable3)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<UsesType> relation = toUsesType.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (UsesType c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified3.add(codeVariable);
		}

		List<CodeVariable> filteredVariable4 = variable.stream().
				filter(e -> foundCreates(e,toCreates)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified4 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable4)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Creates> relation = toCreates.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Creates c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified4.add(codeVariable);
		}

		List<CodeVariable> filteredVariable5 = variable.stream().
				filter(e -> foundExceptionFlow(e,toExceptionFlow)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified5 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable5)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<ExceptionFlow> relationExceptionFlow = new HashSet<ExceptionFlow>();
			for (ExceptionFlow relation : toExceptionFlow)
			{
				TreeIterator<EObject> tree = relation.getTo().eAllContents();
				while (tree.hasNext()) {

					EObject eoTree = tree.next();
					if (eoTree instanceof StorableUnit) {
						StorableUnit storableUnit = (StorableUnit) eoTree;
						if (storableUnit.getName().equals(p.getName()))
							relationExceptionFlow.add(relation);
					}
				}
			}

			for (ExceptionFlow c:relationExceptionFlow)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified5.add(codeVariable);
		}

		List<CodeVariable> filteredVariable6 = variable.stream().
				filter(e -> foundThrows(e,toThrows)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified6 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable6)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Throws> relation = toThrows.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Throws c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified6.add(codeVariable);
		}

		List<CodeVariable> filteredVariable7 = variable.stream().
				filter(e -> foundAddresses(e,toAddresses)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified7 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable7)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Addresses> relation = toAddresses.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Addresses c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified7.add(codeVariable);
		}

		List<CodeVariable> filteredVariable8 = variable.stream().
				filter(e -> foundWrites(e,toWrites)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified8 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable8)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Writes> relation = toWrites.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Writes c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified8.add(codeVariable);
		}

		List<CodeVariable> filteredVariable9 = variable.stream().
				filter(e -> foundReads(e,toReads)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified9 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable9)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Reads> relation = toReads.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Reads c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified9.add(codeVariable);
		}

		List<CodeVariable> filteredVariable10 = variable.stream().
				filter(e -> foundHasValue(e,toHasValue)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified10 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable10)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<HasValue> relation = toHasValue.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (HasValue c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified10.add(codeVariable);
		}

		List<CodeVariable> filteredVariable11 = variable.stream().
				filter(e -> foundExtends(e,toExtends)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified11 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable11)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Extends> relation = toExtends.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Extends c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified11.add(codeVariable);
		}

		List<CodeVariable> filteredVariable12 = variable.stream().
				filter(e -> foundImplements(e,toImplements)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified12 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable12)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Implements> relation = toImplements.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Implements c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified12.add(codeVariable);
		}

		List<CodeVariable> filteredVariable13 = variable.stream().
				filter(e -> foundImports(e,toImports)).
				collect(Collectors.toList());
		List<CodeVariable> filteredVariableModified13 = new ArrayList<CodeVariable>();
		for (CodeVariable p: filteredVariable13)  {

			CodeVariable codeVariable = new CodeVariable(p.getProjectName(), 
					p.getPackage_(), 
					p.getClass_(), 
					p.getMethod(),
					p.getName(), 
					p.getMapping(), 
					p.getIdAbstraction());
			Set<Imports> relation = toImports.stream().filter(l->l.getTo().getName().equals(p.getName())).collect(Collectors.toSet());
			for (Imports c:relation)
				codeVariable.addKDMRelationship(c);
			filteredVariableModified13.add(codeVariable);
		}

		List<CodePackage> filteredPackage = Stream.of(filteredPackageModified1, 
				filteredPackageModified2, 
				filteredPackageModified3,
				filteredPackageModified4,
				filteredPackageModified5,
				filteredPackageModified6,
				filteredPackageModified7,
				filteredPackageModified8,
				filteredPackageModified9,
				filteredPackageModified10,
				filteredPackageModified11,
				filteredPackageModified12,
				filteredPackageModified13)
				.flatMap(Collection::stream)
				.collect(Collectors.toList()); 

		List<CodeClass> filteredClass = Stream.of(filteredClassModified1, 
				filteredClassModified2, 
				filteredClassModified3,
				filteredClassModified4,
				filteredClassModified5,
				filteredClassModified6,
				filteredClassModified7,
				filteredClassModified8,
				filteredClassModified9,
				filteredClassModified10,
				filteredClassModified11,
				filteredClassModified12,
				filteredClassModified13)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());   

		List<CodeField> filteredField = Stream.of(filteredFieldModified1, 
				filteredFieldModified2, 
				filteredFieldModified3,
				filteredFieldModified4,
				filteredFieldModified5,
				filteredFieldModified6,
				filteredFieldModified7,
				filteredFieldModified8,
				filteredFieldModified9,
				filteredFieldModified10,
				filteredFieldModified11,
				filteredFieldModified12,
				filteredFieldModified13)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());   

		List<CodeMethod> filteredMethod = Stream.of(filteredMethodModified1, 
				filteredMethodModified2, 
				filteredMethodModified3,
				filteredMethodModified4,
				filteredMethodModified5,
				filteredMethodModified6,
				filteredMethodModified7,
				filteredMethodModified8,
				filteredMethodModified9,
				filteredMethodModified10,
				filteredMethodModified11,
				filteredMethodModified12,
				filteredMethodModified13)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());   

		List<CodeVariable> filteredVariable = Stream.of(filteredVariableModified1, 
				filteredVariableModified2, 
				filteredVariableModified3,
				filteredVariableModified4,
				filteredVariableModified5,
				filteredVariableModified6,
				filteredVariableModified7,
				filteredVariableModified8,
				filteredVariableModified9,
				filteredVariableModified10,
				filteredVariableModified11,
				filteredVariableModified12,
				filteredVariableModified13)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());   

		
		for (int i=0; i< filteredPackage.size(); i++){

			AddAggregated aggregated = new AddAggregated(abstraction, filteredPackage.get(i).getMapping(), filteredPackage.get(i).getKdmType());
			aggregated.aggregated(kdm);
		}


		for (int i=0; i< filteredClass.size(); i++){

			AddAggregated aggregated = new AddAggregated(abstraction, filteredClass.get(i).getMapping(), filteredClass.get(i).getKdmType());
			aggregated.aggregated(kdm);
		}

		for (int i=0; i< filteredField.size(); i++){

			AddAggregated aggregated = new AddAggregated(abstraction, filteredField.get(i).getMapping(), filteredField.get(i).getKdmType());
			aggregated.aggregated(kdm);
		}

		for (int i=0; i< filteredMethod.size(); i++){

			AddAggregated aggregated = new AddAggregated(abstraction, filteredMethod.get(i).getMapping(), filteredMethod.get(i).getKdmType());
			aggregated.aggregated(kdm);
		}

		for (int i=0; i< filteredVariable.size(); i++){

			AddAggregated aggregated = new AddAggregated(abstraction, filteredVariable.get(i).getMapping(), filteredVariable.get(i).getKdmType());
			aggregated.aggregated(kdm);
		}
	}

	private boolean foundCalls(Object object, List<Calls> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundUsesType(Object object, List<UsesType> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundCreates(Object object, List<Creates> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundExceptionFlow(Object object, List<ExceptionFlow> toCalls) {

		List<StorableUnit> elements = new ArrayList<StorableUnit>();
		for (ExceptionFlow relation : toCalls)
		{
			TreeIterator<EObject> tree = relation.getTo().eAllContents();
			while (tree.hasNext()) {

				EObject eoTree = tree.next();
				if (eoTree instanceof StorableUnit) {
					StorableUnit storableUnit = (StorableUnit) eoTree;
					elements.add(storableUnit);
				}
			}
		}

		if (object instanceof CodePackage)
		{	

			return elements.stream().
					filter(l -> l.getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return elements.stream().
						filter(l -> l.getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return elements.stream().
							filter(l -> l.getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return elements.stream().
								filter(l -> l.getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return elements.stream().
									filter(l -> l.getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundThrows(Object object, List<Throws> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundAddresses(Object object, List<Addresses> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundWrites(Object object, List<Writes> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundReads(Object object, List<Reads> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundHasValue(Object object, List<HasValue> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundExtends(Object object, List<Extends> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundImplements(Object object, List<Implements> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundImports(Object object, List<Imports> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	private boolean foundHasType(Object object, List<HasType> toCalls) {

		if (object instanceof CodePackage)
		{	

			return toCalls.stream().
					filter(l -> l.getTo().getName().equals(((CodePackage) object).getName())).
					findAny().
					isPresent();
		}
		else
		{
			if (object instanceof CodeClass)
			{	

				return toCalls.stream().
						filter(l -> l.getTo().getName().equals(((CodeClass) object).getName())).
						findAny().
						isPresent();
			}
			else {

				if (object instanceof CodeField)
				{	

					return toCalls.stream().
							filter(l -> l.getTo().getName().equals(((CodeField) object).getName())).
							findAny().
							isPresent();
				}
				else {

					if (object instanceof CodeMethod)
					{	

						return toCalls.stream().
								filter(l -> l.getTo().getName().equals(((CodeMethod) object).getName())).
								findAny().
								isPresent();
					}
					else {

						if (object instanceof CodeVariable)
						{	

							return toCalls.stream().
									filter(l -> l.getTo().getName().equals(((CodeVariable) object).getName())).
									findAny().
									isPresent();
						}
						else
							return false;
					}
				}
			}
		}
	}

	public void createModel(File path, String file, String dbName, String path_)
	{
		Manager baseXManager=null;

		try {
			baseXManager = new Manager(path.getPath()+ "/", file, dbName);
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

		try {
			baseXManager.createModel();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String attr = "xsi:type";
			String value = "structure:StructureModel";
			baseXManager.createModelAttr(attr, value);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String attr = "name";
			String value = "ArchitecturalView_" + file.split("\\_")[0];
			baseXManager.createModelAttr(attr, value);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			baseXManager.exportDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Creates archtype of model
		try 
		{
			this.createTree(path_);
			this.createStructureElementFromTree(baseXManager, path_);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		try {
			baseXManager.closeDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createStructureElement(Manager baseXManager, String parent, String componentName, String path_) throws Exception {

		boolean check = baseXManager.checkComponentExist(componentName);
		if (!check)
		{
			//Root Parent
			if (parent == null)
			{
				//Create Structure element with name
				baseXManager.createStructureElement(componentName, "parent", path_);
				//Export DB
				baseXManager.exportDB();
			}
			else
			{
				//Create Structure element with name for children
				baseXManager.createStructureElement(componentName, parent, path_);
				//Export DB
				baseXManager.exportDB();
			}
		}
	}

}
