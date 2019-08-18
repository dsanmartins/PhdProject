package br.ufscar.sas.tableviewer;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class TableLabelAnomalyProvider extends LabelProvider implements ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		Anomaly data = (Anomaly) element;

		switch (columnIndex) {
		case 0:
			return data.getTypeAnomaly();
		case 1:
			return data.getName();
		default: 
			return data.getDescription();
		}
	}
}
