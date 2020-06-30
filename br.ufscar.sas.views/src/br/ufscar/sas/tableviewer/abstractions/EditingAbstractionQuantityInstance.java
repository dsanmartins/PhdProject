package br.ufscar.sas.tableviewer.abstractions;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Display;

import br.ufscar.sas.database.QueryClass;
import br.ufscar.sas.view.MainView;

public class EditingAbstractionQuantityInstance extends EditingSupport {

	private TextCellEditor cellEditor = null;
	private TableViewer viewer = null;

	public EditingAbstractionQuantityInstance(TableViewer viewer) {
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

		return ((Abstraction) element).getQuantity();
	}

	@Override
	protected void setValue(Object element, Object value) {		

		if (element instanceof Abstraction){
			Abstraction data = (Abstraction) element;
			String newValue = (String) value;
			if (isInteger(newValue))
			{
				/* only set new value if it differs from old one */
				if (Integer.parseInt(data.getQuantity()) <= Integer.parseInt(newValue)) {
					data.setQuantity(newValue);
					this.getViewer().update(element, null);
					try {
						QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
						queryClass.updateAbstraction(data.getAbstraction(), newValue);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
					MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", "The new value must be greater than the current value");
			}
			else
				MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", "The entry is not a number");

		}
	}

	private boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}