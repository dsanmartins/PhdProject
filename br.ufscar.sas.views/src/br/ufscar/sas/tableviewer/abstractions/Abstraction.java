package br.ufscar.sas.tableviewer.abstractions;

public class Abstraction {

	private int id;
	private String abstraction;
	private String quantity;
	private String realQuantity;
	
	public Abstraction(int id, String abstraction, String quantity, String realQuantity){
		
		this.id = id;
		this.abstraction = abstraction;
		this.quantity = quantity;
		this.realQuantity = realQuantity;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbstraction() {
		return abstraction;
	}

	public void setAbstraction(String abstraction) {
		this.abstraction = abstraction;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	
	public String getRealQuantity() {
		return realQuantity;
	}

	public void setRealQuantity(String realQuantity) {
		this.realQuantity = realQuantity;
	}
	
	
}
