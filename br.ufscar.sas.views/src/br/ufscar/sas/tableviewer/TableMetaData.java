package br.ufscar.sas.tableviewer;

public class TableMetaData {

	
	int id;
	String abstraction1;
	String abstraction2;
	String accessType;
	boolean checkbox;
	
	public TableMetaData(int id, String abstraction1, String abstraction2, String accessType, boolean checkbox) {
		
		this.id = id;
		this.abstraction1 = abstraction1;
		this.abstraction2 = abstraction2;
		this.accessType = accessType;
		this.checkbox = checkbox;
	}
	
	public boolean getIsSelected() {
		return checkbox;
	}
	
	public void setIsSelected(boolean checkbox) {
		this.checkbox = checkbox;
	}
	
	public int getId() {
		return id;
	}
	
	public String getAbstraction1() {
		return abstraction1;
	}
	
	public String getAbstraction2() {
		return abstraction2;
	}
	
	public String getAccessType() {
		return accessType;
	}
	
}
