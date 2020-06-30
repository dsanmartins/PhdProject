package br.ufscar.sas.tableviewer.abstractions;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class TableLabelAbstractionProvider extends LabelProvider implements ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		Abstraction data = (Abstraction) element;

		switch (columnIndex) {
		case 0:
			return data.getAbstraction();
		default:
			return String.valueOf(data.getQuantity());
		}
	}
}