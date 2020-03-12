package br.ufscar.sas.recommendation;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.modisco.omg.kdm.code.AbstractCodeElement;
import org.eclipse.modisco.omg.kdm.core.KDMEntity;
import org.eclipse.modisco.omg.kdm.structure.Component;
import org.eclipse.modisco.omg.kdm.structure.Subsystem;
import org.eclipse.ocl.pivot.utilities.ParserException;

import br.ufscar.sas.query.OCLQuery;
import rMSAS.architecturalModel.ArchitecturalModelFactory;
import rMSAS.architecturalModel.ArchitecturalRefactoring;
import rMSAS.architecturalModel.Move;
import rMSAS.codeModel.CodeModelFactory;

public class ReferenceInputRecommendation {

	public void recomendation(ResourceSet resourceSet, Resource resource, String instance, String projectWorkspace, String rule) throws ParserException  {


		ArchitecturalModelFactory factoryArch =   ArchitecturalModelFactory.eINSTANCE;
		ArchitecturalRefactoring model = factoryArch.createArchitecturalRefactoring();
		model.setDescription("Recommendation of refactoring for Scattered Refence Input Smell");
		model.setEngine("Set your transformation language");
		model.setName(rule);
		model.setSmell("Scattered Refence Input");

		OCLQuery oclQuery = new OCLQuery();
		Move archMove = factoryArch.createMove();
		Set<Component> lstComponent = oclQuery.getComponent(resourceSet, resource, instance);

		
		Component abstractionComponent = null;
		Component fromC = null;
		Subsystem fromS = null;
		
		Iterator<Component> iterator = lstComponent.iterator();
		while(iterator.hasNext())
		{
			abstractionComponent = iterator.next();
			archMove.setAbstraction(abstractionComponent);
		}
		
		Set<Component> fromComponent = null;
		Set<Subsystem> fromSubsystem = null;
		//From
		Object object = abstractionComponent.eContainer();
		if (object instanceof Set<?>) {
			fromComponent = (Set<Component>) object;
			Iterator<Component> iteratorComponent = fromComponent.iterator();
			while(iteratorComponent.hasNext())
			{
				fromC = iteratorComponent.next();
				archMove.setFrom(fromC);
			}
		}
		else
		{
			if (object instanceof Set<?>)
			{
				fromSubsystem = (Set<Subsystem>) object;
				Iterator<Subsystem> iteratorSubsystem = fromSubsystem.iterator();
				while(iteratorSubsystem.hasNext())
				{
					fromS = iteratorSubsystem.next();
					archMove.setFrom(fromS);
				}
			}
			else 
				archMove.setFrom(null);
		}
		//To
		object = oclQuery.getTo(resourceSet, resource, "Knowledge");
		if (object instanceof Component) {
			Component container = (Component) object;
			archMove.setTo(container);
		}
		else
			archMove.setTo(null);


		archMove.setDescription("Move Reference Input to Knowledge Abstraction");
		model.getArchitecturalOperation().add(archMove);

		CodeModelFactory factoryCode = CodeModelFactory.eINSTANCE;
		for (KDMEntity entity : abstractionComponent.getImplementation())
		{
			rMSAS.codeModel.Move codeMove = factoryCode.createMove();
			codeMove.setDescription("Move operation at code package level");
			codeMove.setEntity((AbstractCodeElement) entity);
			model.getArchitecturalOperation().get(0).getCodeOperation().add(codeMove);
		}

		ResourceSet resSet = new ResourceSetImpl();

		// create a resource
		URI uriMyInstance = URI.createFileURI(new File(projectWorkspace + "Recommendations/"+ "Refactor_" + rule +".architecturalmodel").getAbsolutePath());
		resource = resSet.createResource(uriMyInstance);
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		resource.getContents().add(model);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}



