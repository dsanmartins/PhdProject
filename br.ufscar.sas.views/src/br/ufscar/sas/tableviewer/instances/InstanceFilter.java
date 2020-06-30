package br.ufscar.sas.tableviewer.instances;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class InstanceFilter  extends ViewerFilter {

	
	private int idAbstraction;

    public void setInstanceFilter(int id) {
        // ensure that the value can be used for matching
        this.idAbstraction = id;
    }
	
	@Override
	public boolean select(Viewer arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
		if (idAbstraction == -1) {
            return true;
        }
		
        Instance instance = (Instance) arg2;
        
        if (instance.getAbstractionID() == idAbstraction) {
            return true;
        }
		return false;
	}
}
