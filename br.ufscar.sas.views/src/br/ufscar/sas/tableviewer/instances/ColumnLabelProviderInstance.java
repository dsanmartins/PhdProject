package br.ufscar.sas.tableviewer.instances;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import br.ufscar.sas.tableviewer.TableMetaData;

public class ColumnLabelProviderInstance extends ColumnLabelProvider implements IColorProvider{

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
    	
    	return ((Instance) element).getInstance();
    }
	
}