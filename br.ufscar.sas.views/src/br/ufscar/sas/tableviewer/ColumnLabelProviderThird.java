package br.ufscar.sas.tableviewer;

import java.io.UnsupportedEncodingException;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class ColumnLabelProviderThird extends ColumnLabelProvider implements IColorProvider{

	@Override
    public Color getBackground(Object element) {
		
		Color negative = new Color(Display.getCurrent(), 255, 102, 102);
		Color positive = new Color(Display.getCurrent(), 204, 255, 153);
		
		TableMetaData tableMetaData = (TableMetaData) element;
		if (tableMetaData.accessType.equals("\u219B"))
			return negative;
		else 
			return positive;
		
		
    }

    @Override
    public Color getForeground(Object element) {
    	
    	Color negative = new Color(Display.getCurrent(), 255, 255, 255);
		Color positive = new Color(Display.getCurrent(), 0, 0, 0);
		
		TableMetaData tableMetaData = (TableMetaData) element;
		if (tableMetaData.accessType.equals("\u219B"))
			return negative;
		else 
			return positive;
    }

    @Override
    public String getText(Object element) {
    	
    	TableMetaData tableMetaData = (TableMetaData) element;
    	byte[] utf8Bytes;
		try {
			utf8Bytes = tableMetaData.getAccessType().getBytes("UTF8");
			String text = new String(utf8Bytes,"UTF8");
			return text;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

}
