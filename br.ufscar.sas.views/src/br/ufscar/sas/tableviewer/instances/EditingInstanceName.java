package br.ufscar.sas.tableviewer.instances;

import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Display;

import br.ufscar.sas.database.QueryClass;
import br.ufscar.sas.view.MainView;

public class EditingInstanceName extends EditingSupport {

	private TextCellEditor cellEditor = null;
	private TableViewer viewer = null;

	public EditingInstanceName(TableViewer viewer) {
		super(viewer);
		this.viewer = viewer;
		cellEditor = new TextCellEditor(viewer.getTable());
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {

		return ((Instance) element).getInstance();
	}

	@Override
	protected void setValue(Object element, Object value) {		

		if (element instanceof Instance){
			Instance data = (Instance) element;
			String newValue = (String) value;
			String oldValue = data.getInstance();

			/* only set new value if it differs from old one */

			if (data.getInstance() != newValue) {
				if (!newValue.contains("_")) {
					try {
						QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
						int max = queryClass.getMaxValueInstance(data.getAbstractionID(), newValue );
						newValue = newValue + "_" + (max+1);
						data.setInstance(newValue);
						this.getViewer().update(element, null);
						queryClass = new QueryClass(MainView.getDatabaseUrl());
						queryClass.UpdateInstance(newValue, oldValue);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
					MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "The new value cannot contain underscore characater");
			}
		}
	}
}