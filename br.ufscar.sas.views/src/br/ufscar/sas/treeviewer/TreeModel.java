package br.ufscar.sas.treeviewer;

import java.util.ArrayList;
import java.util.List; 
import java.lang.NumberFormatException;

public class TreeModel {

	
	private String parentName; 
	private List<TreeModel> children;
	
	public TreeModel(String parentName) {
		
		this.parentName = parentName;
		children = new ArrayList<TreeModel>();
	}
	
	public TreeModel getChild(String abs) {
		
		for (int i =0; i<  children.size(); i++) {
			
			TreeModel child = children.get(i);
			if (child.getParent().equals(abs) ) {
				return child;
			}
		}
		return null;
	}
	
	public void addChildren()
	{
		String child = parentName + "_" + checkNumber(); 
		children.add(new TreeModel(child));
	}
	
	public void setParent(String parent) {
		
		this.parentName = parent;
	}
	
	public void addAbstraction(String abstraction)
	{
		children.add(new TreeModel(abstraction));
	}
	
	public String getParent() {
		
		return parentName;
	}
	
	public List<TreeModel> getChildren(){
		
		return children;
	}
	
	public void setChildren(List<TreeModel> children) {
		
		this.children = children;
	}
	
	public boolean deleteChildren(String childName) {
		
		for (TreeModel child: children)
		{
			if (child.getParent().equals(childName))
				return children.remove(child);
		
		}
		return false;
	}
	
	private int checkNumber() {
		
		int lastNumber =1;
		
		if (children.isEmpty())
			return lastNumber;
		else
		{
			for (TreeModel child:children) {
				
				String lastCharacter = child.getParent().substring(child.getParent().length(), 1);
				try {
					
					lastNumber = Integer.valueOf(lastCharacter);
					lastNumber = lastNumber++;

				}catch (NumberFormatException ex){
					
					ex.printStackTrace();
				}
			}
			return lastNumber;
		}
	}
	
}
