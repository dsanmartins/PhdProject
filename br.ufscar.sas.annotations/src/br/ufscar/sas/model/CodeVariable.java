package br.ufscar.sas.model;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.modisco.omg.kdm.core.KDMRelationship;

public class CodeVariable {

	String projectName;
	String package_;
	String class_;
	String method;
	String name;
	String mapping;
	int idAbstraction;
	String kdmType;
	Set<KDMRelationship> kdmRelationship = new HashSet<KDMRelationship>();
	
	public CodeVariable(String projectName, String package_, String class_, String method, String name, String mapping, int idAbstraction) {
		super();
		this.projectName = projectName;
		this.package_ = package_;
		this.class_ = class_;
		this.method = method;
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
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
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
