package br.ufscar.sas.parser;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ConstructorVisitor extends VoidVisitorAdapter<Void> {

	List<ConstructorDeclaration> listMd = new ArrayList<ConstructorDeclaration>();

	@Override
	public void visit(ConstructorDeclaration n, Void arg) {
		listMd.add(n);
		super.visit(n, arg);
	}

	public List<ConstructorDeclaration> getMethodClasses(CompilationUnit cu) {
		cu.accept(this, null);
		return listMd;
	}
}
