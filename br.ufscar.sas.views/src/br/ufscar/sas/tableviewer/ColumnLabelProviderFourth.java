package br.ufscar.sas.tableviewer;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class ColumnLabelProviderFourth extends ColumnLabelProvider implements IColorProvider{

	@Override
    public Color getBackground(Object element) {
       
		Color monitor = new Color(Display.getCurrent(), 255, 178, 102);
		Color analyzer = new Color(Display.getCurrent(), 153, 204, 255);
		Color planner = new Color(Display.getCurrent(), 224, 224, 224);
		Color executor = new Color(Display.getCurrent(), 245, 245, 220);
		Color knowledge = new Color(Display.getCurrent(), 0, 206, 209);
		
		
		TableMetaData tableMetaData = (TableMetaData) element;
		if (tableMetaData.getAbstraction2().equals("Monitor"))
			return monitor;
		else 
			if (tableMetaData.getAbstraction2().equals("Analyzer"))
				return analyzer;
			else
				if (tableMetaData.getAbstraction2().equals("Planner"))
					return planner;
				else
					if (tableMetaData.getAbstraction2().equals("Executor"))
						return executor;
					else	
						if (tableMetaData.getAbstraction2().equals("Knowledge"))
							return knowledge;
						else
							return null;
    }

    @Override
    public Color getForeground(Object element) {
    	
        return null;
    }

    @Override
    public String getText(Object element) {
    	
    	TableMetaData tableMetaData = (TableMetaData) element;
    	return tableMetaData.getAbstraction2();
    }

}
