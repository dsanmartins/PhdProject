package br.ufscar.sas.tableviewer;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public final class TableLabelProvider extends LabelProvider implements ITableLabelProvider, IColorProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		Data data = (Data) element;

		switch (columnIndex) {
		case 0:
			return data.getCodeType();
		case 1:
			return data.getName();
		case 2:
			return data.getAnnotation();
		default: 
			return data.getBelong();
		}
	}

	@Override
	public Color getBackground(Object arg0) {
		// TODO Auto-generated method stub
		Data data = (Data) arg0;
		Color colorPackage = new Color(Display.getCurrent(), 255, 102, 102);
		Color colorClass = new Color(Display.getCurrent(), 255, 178, 102);
		Color colorField = new Color(Display.getCurrent(), 204, 255, 153);
		Color colorMethod = new Color(Display.getCurrent(), 153, 204, 255);
		Color colorVariable = new Color(Display.getCurrent(), 224, 224, 224);

		if (data.getCodeType().equals("Class Name"))
			return colorClass;
		else {
			if (data.getCodeType().equals("Field Class"))
				return colorField;
			else {
				if (data.getCodeType().equals("Method"))
					return colorMethod;
				else {
					if (data.getCodeType().equals("Package"))
						return colorPackage;
					else
						return colorVariable;
				}
			}
		}

	}

	@Override
	public Color getForeground(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
