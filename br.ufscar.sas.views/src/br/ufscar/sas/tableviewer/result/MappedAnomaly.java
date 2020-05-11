package br.ufscar.sas.tableviewer.result;

public class MappedAnomaly {

	String rule;
	String name;
	String result;
	
	public MappedAnomaly(String rule, String name, String result) {
		super();
		this.rule = rule;
		this.name = name;
		this.result = result;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {

		this.result = result;
	}
	
	
}
