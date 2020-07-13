package br.ufscar.sas.parser;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class VariableVisitor extends VoidVisitorAdapter<Void> {

	List<VariableDeclarator> listVar = new ArrayList<VariableDeclarator>();

	@Override
	public void visit(VariableDeclarator n, Void arg) {
		listVar.add(n);
		super.visit(n, arg);
	}

	public List<VariableDeclarator> getVariableExpr(MethodDeclaration md) {
		md.accept(this, null);
		return listVar;
	}
	
	public List<VariableDeclarator> getVariableExprConstructor(ConstructorDeclaration md) {
		md.accept(this, null);
		return listVar;
	}
}
