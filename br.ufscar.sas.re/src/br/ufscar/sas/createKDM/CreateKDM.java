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
package br.ufscar.sas.createKDM;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;
import org.eclipse.modisco.java.discoverer.DiscoverKDMModelFromJavaProject;


public class CreateKDM {

	public void createKDMFile(String javaProjectName) {

		//Load Project
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(javaProjectName);
		IJavaProject javaProject = JavaCore.create(project);

		//Creates KDM instance
		DiscoverKDMModelFromJavaProject kdmDiscover = new DiscoverKDMModelFromJavaProject();
		try 
		{
			kdmDiscover.discoverElement(javaProject, new NullProgressMonitor());
		} 
		catch (DiscoveryException e){e.printStackTrace();}
		Resource javaResource = kdmDiscover.getTargetModel();

		//Generates the KDM file
		try 
		{
			this.createKDMFile(javaResource, javaProjectName);
		} catch (IOException e) {e.printStackTrace();}
	}

	private void createKDMFile(Resource javaResource, String projectName) throws IOException
	{ 
		IWorkspace workspace = ResourcesPlugin.getWorkspace();  
		//Saving KDM instance
		String folder= workspace.getRoot().getLocation().toFile().getPath().toString(); 

		//If file doesn't exists then create it.
		File file = new File(folder + "/" + projectName +"/" + projectName + "_KDM" + ".xmi");
		if (!file.exists())
		{
			FileOutputStream fout = new FileOutputStream(file);
			javaResource.save(fout, null);
			fout.close();
		}
		else
		{
			Files.deleteIfExists(Paths.get(folder + "/" + projectName +"/" + projectName + "_KDM" + ".xmi"));
			FileOutputStream fout = new FileOutputStream(file);
			javaResource.save(fout, null);
			fout.close();
		}

		/*
		 * File file2 = new File(folder + "/" + projectName +"/" + projectName +
		 * "_REFACTORED_KDM" + ".xmi");
		 * 
		 * if (!file2.exists()) { FileOutputStream fout = new FileOutputStream(file2);
		 * javaResource.save(fout, null); fout.close(); }
		 */
	}
}
