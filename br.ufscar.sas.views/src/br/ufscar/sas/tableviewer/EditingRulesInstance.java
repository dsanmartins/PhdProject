package br.ufscar.sas.tableviewer;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

public class EditingRulesInstance extends EditingSupport{

	private CheckboxCellEditor cellEditor;
	
	public EditingRulesInstance(ColumnViewer viewer) {
		super(viewer);
		// TODO Auto-generated constructor stub
		 cellEditor = new CheckboxCellEditor(((TableViewer)viewer).getTable());
	}

	@Override
	protected boolean canEdit(Object element) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		// TODO Auto-generated method stub
		return cellEditor;
	}

	@Override
	protected Object getValue(Object element) {
		// TODO Auto-generated method stub
		 return ((TableMetaData) element).getIsSelected();
	}

	@Override
	protected void setValue(Object element, Object value) {
		// TODO Auto-generated method stub
		((TableMetaData) element).setIsSelected(Boolean.valueOf((boolean) value));
        getViewer().update(element, null);
		
	}
	
}
