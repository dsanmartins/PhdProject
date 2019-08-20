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
package br.ufscar.sas.ui.handlers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class UI extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// get workbench window
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		// set selection service
		ISelectionService service = window.getSelectionService();
		// set structured selection
		IStructuredSelection structured = (IStructuredSelection) service.getSelection();

		String projectName = "";

		try {

			if (structured != null) {
				IProject jProject = (IProject) structured.getFirstElement();
				if (jProject != null)
					projectName = jProject.getName();
				else {
					MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Error", "Please select a project!.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!projectName.equals("")) {

			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().resetPerspective();

			try {	
				window.getActivePage().showView("MainView");
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			window.getActivePage();

			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			String folder = workspace.getRoot().getLocation().toFile().getPath().toString();
			String umlFolderPlannedAbsolute = folder + "/" + projectName + "/PlannedArchitecture/" ;
			String umlFolderCurrentAbsolute = folder +  "/" + projectName + "/CurrentArchitecture/";

			Path plannedPath = Paths.get(umlFolderPlannedAbsolute);
			Path architecture = plannedPath.resolve("architecture.sas");
			Path currentPath = Paths.get(umlFolderCurrentAbsolute);

			try {Files.createDirectories(plannedPath);} catch (IOException e) {e.printStackTrace();}
			try {
				if (!Files.exists(architecture, LinkOption.NOFOLLOW_LINKS))
				{
					Files.createFile(architecture);
					Files.write(architecture, this.architectureTemplate().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
				}	

			} 
			catch (IOException e1) {

				e1.printStackTrace();
			}
			try {Files.createDirectories(currentPath);} catch (IOException e) {	e.printStackTrace();}
			try {this.refreshProjects();} catch (CoreException e) {	e.printStackTrace();}

			MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "The project " + projectName + " was selected! ");
		}
		return null;
	}

	public void refreshProjects() throws CoreException {
		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		}
	}

	public String architectureTemplate() {

		return "Architecture TemplateAdaptiveSystem {\n" + 
				"	\n" + 
				"	Managing Managing_1 {\n" + 
				"		\n" + 
				"		Controller Controller_1{\n" + 
				"			\n" + 
				"			Monitor Monitor_1;\n" + 
				"			Analyzer Analyzer_1;\n" + 
				"			Planner Planner_1;\n" + 
				"			Executor Executor_1;\n" + 
				"			Knowledge Knowledge_1 {\n" + 
				"				\n" + 
				"				 ReferenceInput ReferenceInput_1;\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}\n" + 
				"	Managed Managed_1 {\n" + 
				"				\n" + 
				"		 Sensor Sensor_1;\n" + 
				"		 Effector Efector_1;\n" + 
				"		 MeasuredOutput MeasuredOutput_1;\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"Rules{\n" + 
				"	\n" + 
				"	\n" + 
				"}";
	}
}