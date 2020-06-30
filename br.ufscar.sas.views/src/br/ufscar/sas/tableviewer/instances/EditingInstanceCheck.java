package br.ufscar.sas.tableviewer.instances;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

public class EditingInstanceCheck extends EditingSupport{
	
    private CheckboxCellEditor cellEditor;


    public EditingInstanceCheck(TableViewer viewer) {
        super(viewer);
        // TODO Auto-generated constructor stub
        //cellEditor = new CheckboxCellEditor(null, SWT.CHECK | SWT.READ_ONLY);
        cellEditor = new CheckboxCellEditor(viewer.getTable());
    }

    @Override
    protected CellEditor getCellEditor(Object element) {
        // TODO Auto-generated method stub
        return cellEditor;
    }

    @Override
    protected boolean canEdit(Object element) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    protected Object getValue(Object element) {
        // TODO Auto-generated method stub
        return ((Instance) element).getIsSelected();
    }

    @Override
    protected void setValue(Object element, Object value) {
        // TODO Auto-generated method stub
        ((Instance) element).setIsSelected(Boolean.valueOf((boolean) value));
        getViewer().update(element, null);

    }
}
