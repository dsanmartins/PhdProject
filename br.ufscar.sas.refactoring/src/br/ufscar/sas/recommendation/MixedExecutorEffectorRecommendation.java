package br.ufscar.sas.recommendation;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.modisco.omg.kdm.structure.Component;
import org.eclipse.modisco.omg.kdm.structure.StructureFactory;
import org.eclipse.modisco.omg.kdm.structure.Subsystem;
import org.eclipse.ocl.pivot.utilities.ParserException;

import br.ufscar.sas.query.OCLQuery;
import rMSAS.architecturalModel.ArchitecturalModelFactory;
import rMSAS.architecturalModel.ArchitecturalRefactoring;
import rMSAS.architecturalModel.Create;

public class MixedExecutorEffectorRecommendation {

	public void recomendation(ResourceSet resourceSet, Resource resource, String instance, String projectWorkspace, String rule) throws ParserException  {


		ArchitecturalModelFactory factoryArch =   ArchitecturalModelFactory.eINSTANCE;
		ArchitecturalRefactoring model = factoryArch.createArchitecturalRefactoring();
		model.setDescription("Recommendation of refactoring for Mixed Executors and Effectors Smell");
		model.setEngine("Set your transformation language");
		model.setName(rule);
		model.setSmell("Mixed Executors and Effectors");

		OCLQuery oclQuery = new OCLQuery();

		Create create = factoryArch.createCreate();
		create.setAbstraction(instance);



		Subsystem subSystem = (Subsystem) oclQuery.getInSubsystem(resourceSet, resource, "Managed Subsystem");
		if (subSystem !=null)
			create.setIn(subSystem);

		create.setDescription("Create a new Effector");
		model.getArchitecturalOperation().add(create);
		ResourceSet resSet = new ResourceSetImpl();
		resource = resSet.createResource(URI.createFileURI(new File(projectWorkspace + "Recommendations/"+ "Refactor_" + rule +".architecturalmodel").getAbsolutePath()));
		resource.getContents().add(model);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
