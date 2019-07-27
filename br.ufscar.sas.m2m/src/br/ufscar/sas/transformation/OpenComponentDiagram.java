package br.ufscar.sas.transformation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class OpenComponentDiagram {

	public void open (String path, String projectName) {
		
		try {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			IPath path2 = new Path("/"+ projectName + "/CurrentArchitecture/ComponentDiagram.txt");
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path2);
			IDE.openEditor(page, file, true);
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("net.sourceforge.plantuml.eclipse.views.PlantUmlView");

		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
