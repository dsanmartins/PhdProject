package br.ufscar.sas.tableviewer.result;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class TableLabelAnomalyMappedProvider extends LabelProvider implements ITableLabelProvider , IColorProvider{

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		MappedAnomaly data = (MappedAnomaly) element;

		switch (columnIndex) {
		case 0:
			return data.getRule();
		default:
			return data.getName();
		}
	}

	@Override
	public Color getBackground(Object element) {
		
		Color negative = new Color(Display.getCurrent(), 255, 102, 102);
		Color positive = new Color(Display.getCurrent(), 204, 255, 153);
		
		MappedAnomaly data = (MappedAnomaly) element;
		if (data.getResult().equals("0"))
			return negative;
		else 
			return positive;
	}

	@Override
	public Color getForeground(Object element) {
		Color negative = new Color(Display.getCurrent(), 255, 255, 255);
		Color positive = new Color(Display.getCurrent(), 0, 0, 0);
		
		MappedAnomaly data = (MappedAnomaly) element;
		if (data.getResult().equals("0"))
			return negative;
		else 
			return positive;
	}
}