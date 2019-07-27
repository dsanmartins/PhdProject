package br.ufscar.sas.parser;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class FieldClassVisitor extends VoidVisitorAdapter<Void> {

	List<FieldDeclaration> listFd = new ArrayList<FieldDeclaration>();

	@Override
	public void visit(FieldDeclaration n, Void arg) {
		listFd.add(n);
		super.visit(n, arg);
	}

	public List<FieldDeclaration> getFieldClasses(CompilationUnit cu) {
		cu.accept(this, null);
		return listFd;
	}
}
