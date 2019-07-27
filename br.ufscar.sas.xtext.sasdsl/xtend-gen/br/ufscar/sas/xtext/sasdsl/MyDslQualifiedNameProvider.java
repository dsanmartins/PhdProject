package br.ufscar.sas.xtext.sasdsl;

import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLAnalyzer;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLController;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLEffector;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLExecutor;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLKnowledge;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLManagerController;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLMeasuredOutput;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLMonitor;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLPlanner;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLReferenceInput;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLSensor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

@SuppressWarnings("all")
public class MyDslQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
  @Override
  public QualifiedName getFullyQualifiedName(final EObject obj) {
    boolean _matched = false;
    if (obj instanceof DSLController) {
      _matched=true;
      return QualifiedName.create(((DSLController)obj).getName());
    }
    if (!_matched) {
      if (obj instanceof DSLManagerController) {
        _matched=true;
        return QualifiedName.create(((DSLManagerController)obj).getName());
      }
    }
    if (!_matched) {
      if (obj instanceof DSLMonitor) {
        _matched=true;
        return QualifiedName.create(((DSLMonitor)obj).getName());
      }
    }
    if (!_matched) {
      if (obj instanceof DSLAnalyzer) {
        _matched=true;
        return QualifiedName.create(((DSLAnalyzer)obj).getName());
      }
    }
    if (!_matched) {
      if (obj instanceof DSLPlanner) {
        _matched=true;
        return QualifiedName.create(((DSLPlanner)obj).getName());
      }
    }
    if (!_matched) {
      if (obj instanceof DSLExecutor) {
        _matched=true;
        return QualifiedName.create(((DSLExecutor)obj).getName());
      }
    }
    if (!_matched) {
      if (obj instanceof DSLEffector) {
        _matched=true;
        return QualifiedName.create(((DSLEffector)obj).getName());
      }
    }
    if (!_matched) {
      if (obj instanceof DSLSensor) {
        _matched=true;
        return QualifiedName.create(((DSLSensor)obj).getName());
      }
    }
    if (!_matched) {
      if (obj instanceof DSLKnowledge) {
        _matched=true;
        return QualifiedName.create(((DSLKnowledge)obj).getName());
      }
    }
    if (!_matched) {
      if (obj instanceof DSLReferenceInput) {
        _matched=true;
        return QualifiedName.create(((DSLReferenceInput)obj).getName());
      }
    }
    if (!_matched) {
      if (obj instanceof DSLMeasuredOutput) {
        _matched=true;
        return QualifiedName.create(((DSLMeasuredOutput)obj).getName());
      }
    }
    return super.getFullyQualifiedName(obj);
  }
}
