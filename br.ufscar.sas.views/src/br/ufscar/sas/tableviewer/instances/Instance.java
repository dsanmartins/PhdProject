package br.ufscar.sas.tableviewer.instances;

public class Instance {

	private int abstractionID;
	private String instance;
	private boolean check;
	
	public Instance(int abstractionID, String instance, Boolean check){
		
		this.abstractionID = abstractionID;
		this.instance = instance;
		this.check = check;
	}

	public int getAbstractionID() {
		return abstractionID;
	}

	public void setAbstractionID(int abstractionID) {
		this.abstractionID = abstractionID;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public boolean getIsSelected() {
		return check;
	}
	
	public void setIsSelected(boolean checkbox) {
		this.check = checkbox;
	}
}
