package br.ufscar.sas.tableviewer;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Color;

public class ColumnLabelProviderFirst extends ColumnLabelProvider implements IColorProvider{

	@Override
    public Color getBackground(Object element) {
        return null;
    }

    @Override
    public Color getForeground(Object element) {
    	
        return null;
    }

    @Override
    public String getText(Object element) {
    	
    	TableMetaData tableMetaData = (TableMetaData) element;
    	return String.valueOf(tableMetaData.getId());
    }

}
