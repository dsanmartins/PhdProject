package br.ufscar.sas.view;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {

		// Get the editor area.
		String editorArea = layout.getEditorArea();

		// Top left: Resource Navigator view and Bookmarks view placeholder
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.25f,	editorArea);
		topLeft.addView(IPageLayout.ID_PROJECT_EXPLORER);

		// Bottom right: Task List view
		//layout.addView("MainView", IPageLayout.BOTTOM, 0.66f, editorArea);
		layout.addPlaceholder("MainView", IPageLayout.RIGHT, 0.47f, editorArea);
		IViewLayout ivew = layout.getViewLayout("MainView");
		ivew.setCloseable(false);
	}

}