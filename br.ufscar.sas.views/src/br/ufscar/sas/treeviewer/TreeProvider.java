package br.ufscar.sas.treeviewer;

import org.eclipse.jface.viewers.ITreeContentProvider;

public class TreeProvider  implements ITreeContentProvider {

	@Override
	public Object[] getChildren(Object inputElement) {
		return getElements(inputElement);
	}
	
	@Override
	public Object[] getElements(Object inputElement) {
		return ((TreeModel) inputElement).getChildren().toArray();
		
	}

	@Override
	public Object getParent(Object element) {
		if(element instanceof TreeModel) {
	        return ((TreeModel)element).getNodeName();
	    }
	    return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return  ((TreeModel) element).getChildren().size() > 0;
	}

}
