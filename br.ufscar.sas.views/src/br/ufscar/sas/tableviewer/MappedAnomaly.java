package br.ufscar.sas.tableviewer;

public class MappedAnomaly {

	String rule;
	String name;
	
	
	public MappedAnomaly(String rule, String name) {
		super();
		this.rule = rule;
		this.name = name;
	}
	
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
