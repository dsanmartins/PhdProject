package br.ufscar.sas.treeviewer;

import java.util.ArrayList;
import java.util.List; 
import java.lang.NumberFormatException;

public class TreeModel {

	
	private String parentName;
	private String nodeName; 
	private List<TreeModel> children;
	
	public TreeModel(String nodeName, String parentName) {
		
		this.nodeName = nodeName;
		this.parentName = parentName;
		children = new ArrayList<TreeModel>();
	}
	
	public TreeModel getChild(String abs) {
		
		for (int i =0; i<  children.size(); i++) {
			
			TreeModel child = children.get(i);
			if (child.getNodeName().equals(abs) ) {
				return child;
			}
		}
		return null;
	}
	
	public void addChildren()
	{
		String child = nodeName + "_" + checkNumber(); 
		children.add(new TreeModel(child, "root"));
	}
	
	public String getParent() {
		
		return parentName;
	}
	
	public void setNodeName(String nodeName) {
		
		this.nodeName = nodeName;
	}
	
	public void addAbstraction(String abstraction, String root)
	{
		children.add(new TreeModel(abstraction,root));
	}
	
	public String getNodeName() {
		
		return nodeName;
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
			if (child.getNodeName().equals(childName))
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
				
				String lastCharacter = child.getNodeName().substring(child.getNodeName().length(), 1);
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
