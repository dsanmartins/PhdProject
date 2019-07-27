package br.ufscar.sas.structuretree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree {

	Map<String, List<String>> tree = null;
	
	public Tree () {
		
		tree = new HashMap<String, List<String>>();
	}
	
	public void addNode(String parent, List<String> children ) {
		
		tree.put(parent, children);
	}
	
	public List<String> getChildren(String parent) {
		
		return tree.get(parent);
	}
	
	public void printChildren(String parent) {
		
		System.out.println(Arrays.toString((tree.get(parent)).toArray()));
	}
	
}
