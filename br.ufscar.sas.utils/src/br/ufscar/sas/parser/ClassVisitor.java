package br.ufscar.sas.parser;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ClassVisitor extends VoidVisitorAdapter<Void>{

	List<ClassOrInterfaceDeclaration> listCID = new ArrayList<ClassOrInterfaceDeclaration>();
	
	@Override
	public void visit(ClassOrInterfaceDeclaration n, Void arg) {
		listCID.add(n);
		super.visit(n, arg);
	}
	
	public List<ClassOrInterfaceDeclaration> getClassesOrInterfaces(CompilationUnit cu){
		cu.accept(this, null);
		return listCID;
	}
}
