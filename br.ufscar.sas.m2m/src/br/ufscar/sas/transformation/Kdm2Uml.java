/*******************************************************************************
 * Copyright (c)  2016 Daniel San Martin Santibanez.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *    Daniel San Martin Santibanez - initial API and implementation and/or initial documentation
 *  
 *******************************************************************************/
package br.ufscar.sas.transformation;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.StringBufferLog;

import br.ufscar.sas.m2m.Activator;

public class Kdm2Uml {

	public Resource createComponentDiagram(IFile kdm, String uml, String javaProjectName,String mapping ) throws ExecutionException
	{
		// Refer to an existing transformation via URI
		URI transformationURI = URI.createURI("platform:/plugin/br.ufscar.sas.m2m/transforms/kdm2uml.qvto");

		// create executor for the given transformation
		TransformationExecutor executor = new TransformationExecutor(transformationURI);
		// define the transformation input
		// Remark: we take the objects from a resource, however
		// a list of arbitrary in-memory EObjects may be passed
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource kdmInResource = resourceSet.getResource(URI.createURI(kdm.getFullPath().toString()), true);	
		EList<EObject> inObjects = kdmInResource.getContents();
		// create the input extent with its initial contents
		ModelExtent input = new BasicModelExtent(inObjects);		
		// create an empty extent to catch the output
		ModelExtent output = new BasicModelExtent();

		//Log log =  new WriterLog(new OutputStreamWriter(System.out)); 
		// setup the execution environment details -> 
		// configuration properties, logger, monitor object etc.
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("modelName", "ArchitecturalView_" + javaProjectName);
		StringBufferLog log = new StringBufferLog();
		context.setLog(log);
		
		// run the transformation assigned to the executor with the given 
		// input and output and execution context -> ChangeTheWorld(in, out)
		// Remark: variable arguments count is supported
		ExecutionDiagnostic result = executor.execute(context, input, output);
		try {
			Files.write(Paths.get(mapping), log.getContents().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING );

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// check the result for success
		Resource umlOutResource = null;
		if(result.getSeverity() == Diagnostic.OK) 
		{
			// the output objects got captured in the output extent
			List<EObject> outObjects = output.getContents();
			// let's persist them using a resource 
			ResourceSet resourceSet2 = new ResourceSetImpl();
			umlOutResource = resourceSet2.createResource(URI.createFileURI(new File(uml).getAbsolutePath()));
			umlOutResource.getContents().addAll(outObjects);
			try 
			{
				umlOutResource.save(Collections.emptyMap());

			} catch (IOException e) { e.printStackTrace();}
		} 
		else 
		{
			// turn the result diagnostic into status and send it to error log			
			IStatus status = BasicDiagnostic.toIStatus(result);
			Activator.getDefault().getLog().log(status);
		}
		return umlOutResource;
	}
}
