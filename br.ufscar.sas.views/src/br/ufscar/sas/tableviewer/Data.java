package br.ufscar.sas.tableviewer;

public class Data {

	private String codeType;
	private String name;
	private String annotation;
	private String belong;
	private String pathCode;
	
	private String className;
	private String methodName;
	

	public Data(String codeType, String name, String pathCode, String annotation, String className, String methodName, String belong) {
		this.codeType = codeType;
		this.name = name;
		this.annotation = annotation;
		this.belong = belong;
		this.setPathCode(pathCode);
		this.setClassName(className);
		this.setMethodName(methodName);
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getPathCode() {
		return pathCode;
	}

	public void setPathCode(String pathCode) {
		this.pathCode = pathCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}
}
