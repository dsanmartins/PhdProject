package br.ufscar.sas.tableviewer.instances;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Color;

public class ColumnLabelProviderCheckbox extends ColumnLabelProvider implements IColorProvider{

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
    	
    	Instance instance = (Instance) element;
    	if(instance.getIsSelected())
			return Character.toString((char)0x2611);
		else
			return Character.toString((char)0x2610);
		
    }
}
