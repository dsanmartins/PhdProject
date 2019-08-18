package br.ufscar.sas.tableviewer;

public class Anomaly {

	private String typeAnomaly;
	private String name;
	private String description;
	
	
	public Anomaly(String typeAnomaly, String name, String description){
		
		this.typeAnomaly = typeAnomaly;
		this.name = name;
		this.description = description;
		
	}
	
	public String getTypeAnomaly() {
		return typeAnomaly;
	}
	public void setTypeAnomaly(String typeAnomaly) {
		this.typeAnomaly = typeAnomaly;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
