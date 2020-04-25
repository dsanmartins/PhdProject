package br.ufscar.sas.tableviewer;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class TableLabelRuleProvider extends LabelProvider implements ITableLabelProvider, IColorProvider {

	@Override
	public Color getBackground(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getForeground(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		
		TableMetaData tableMetaData = (TableMetaData) arg0;
		switch (arg1) {
		case 0:
			return String.valueOf(tableMetaData.getId());
		case 1:
			return tableMetaData.getAbstraction1();
		case 2:
			return tableMetaData.getAccessType();
		case 3: 
			return tableMetaData.getAbstraction2();
		default:
			return String.valueOf(tableMetaData.getIsSelected());
		}

	}

}
