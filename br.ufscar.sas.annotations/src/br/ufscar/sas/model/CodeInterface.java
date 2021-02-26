package br.ufscar.sas.model;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.modisco.omg.kdm.core.KDMRelationship;

public class CodeInterface {

	String projectName;
	String package_;
	String name;
	String mapping;
	int idAbstraction;
	Set<KDMRelationship> kdmRelationship = new HashSet<KDMRelationship>();
	
	public CodeInterface(String projectName, String package_, String name, String mapping, int idAbstraction) {
		super();
		this.projectName = projectName;
		this.package_ = package_;
		this.name = name;
		this.mapping = mapping;
		this.idAbstraction = idAbstraction;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getPackage_() {
		return package_;
	}
	public void setPackage_(String package_) {
		this.package_ = package_;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMapping() {
		return mapping;
	}
	public void setMapping(String mapping) {
		this.mapping = mapping;
	}
	public int getIdAbstraction() {
		return idAbstraction;
	}
	public void setIdAbstraction(int idAbstraction) {
		this.idAbstraction = idAbstraction;
	}
	public Set<KDMRelationship> getKdmType() {
		return kdmRelationship;
	}
	public void addKDMRelationship(KDMRelationship relation) {
		
		this.kdmRelationship.add(relation);
		
	}
}
