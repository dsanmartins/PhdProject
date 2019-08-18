package br.ufscar.sas.tableviewer;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class TableLabelAnomalyMappedProvider extends LabelProvider implements ITableLabelProvider {

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
}