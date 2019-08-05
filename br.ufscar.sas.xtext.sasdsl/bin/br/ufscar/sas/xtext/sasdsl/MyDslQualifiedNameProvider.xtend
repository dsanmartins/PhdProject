package br.ufscar.sas.xtext.sasdsl

import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLAnalyzer
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLController
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLEffector
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLExecutor
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLKnowledge
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLManagerController
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLMeasuredOutput
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLMonitor
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLPlanner
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLReferenceInput
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLSensor
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName

class MyDslQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	override getFullyQualifiedName(EObject obj) {
		switch (obj) {
			DSLController: return QualifiedName.create(obj.name)
			DSLManagerController: return QualifiedName.create(obj.name)
			DSLMonitor: return QualifiedName.create(obj.name)
			DSLAnalyzer: return QualifiedName.create(obj.name)
			DSLPlanner: return QualifiedName.create(obj.name)
			DSLExecutor: return QualifiedName.create(obj.name)
			DSLEffector: return QualifiedName.create(obj.name)
			DSLSensor: return QualifiedName.create(obj.name)
			DSLKnowledge: return QualifiedName.create(obj.name)
			DSLReferenceInput: return QualifiedName.create(obj.name)
			DSLMeasuredOutput: return QualifiedName.create(obj.name)
			default: return super.getFullyQualifiedName(obj)
		}
	}
}