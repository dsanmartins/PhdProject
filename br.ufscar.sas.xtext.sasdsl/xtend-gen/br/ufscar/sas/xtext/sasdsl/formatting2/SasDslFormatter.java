package br.ufscar.sas.xtext.sasdsl.formatting2;

import br.ufscar.sas.xtext.sasdsl.sasDsl.ArchitectureDefinition;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLController;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLKnowledge;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLManaged;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLManagerController;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLManaging;
import br.ufscar.sas.xtext.sasdsl.services.SasDslGrammarAccess;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SasDslFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private SasDslGrammarAccess _sasDslGrammarAccess;
  
  protected void _format(final ArchitectureDefinition architecture, @Extension final IFormattableDocument document) {
    final DSLManaging lastManaging = IterableExtensions.<DSLManaging>last(architecture.getManaging());
    EList<DSLManaging> _managing = architecture.getManaging();
    for (final DSLManaging managing : _managing) {
      boolean _equals = Objects.equal(managing, lastManaging);
      if (_equals) {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.setNewLines(1);
        };
        document.<DSLManaging>append(managing, _function);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.setNewLines(2);
        };
        document.<DSLManaging>append(managing, _function_1);
      }
    }
    final DSLManaged lastManaged = IterableExtensions.<DSLManaged>last(architecture.getManaged());
    EList<DSLManaged> _managed = architecture.getManaged();
    for (final DSLManaged managed : _managed) {
      boolean _equals_1 = Objects.equal(managed, lastManaged);
      if (_equals_1) {
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.setNewLines(1);
        };
        document.<DSLManaged>append(managed, _function_2);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.setNewLines(2);
        };
        document.<DSLManaged>append(managed, _function_3);
      }
    }
    final ISemanticRegion open1 = this.textRegionExtensions.regionFor(architecture).keyword("{");
    final ISemanticRegion close1 = this.textRegionExtensions.regionFor(architecture).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(open1, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(open1, close1, _function_5);
    EList<DSLManaging> _managing_1 = architecture.getManaging();
    for (final DSLManaging managing_1 : _managing_1) {
      {
        final ISemanticRegion open2 = this.textRegionExtensions.regionFor(managing_1).keyword("{");
        final ISemanticRegion close2 = this.textRegionExtensions.regionFor(managing_1).keyword("}");
        final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.append(open2, _function_6);
        final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
          it.indent();
        };
        document.<ISemanticRegion, ISemanticRegion>interior(open2, close2, _function_7);
      }
    }
    EList<DSLManaging> _managing_2 = architecture.getManaging();
    for (final DSLManaging managing_2 : _managing_2) {
      EList<DSLController> _controller = managing_2.getController();
      for (final DSLController controller : _controller) {
        {
          final ISemanticRegion open2 = this.textRegionExtensions.regionFor(controller).keyword("{");
          final ISemanticRegion close2 = this.textRegionExtensions.regionFor(controller).keyword("}");
          final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
            it.newLine();
          };
          document.append(open2, _function_6);
          final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
            it.indent();
          };
          document.<ISemanticRegion, ISemanticRegion>interior(open2, close2, _function_7);
        }
      }
    }
    EList<DSLManaging> _managing_3 = architecture.getManaging();
    for (final DSLManaging managing_3 : _managing_3) {
      EList<DSLManagerController> _managerController = managing_3.getManagerController();
      for (final DSLManagerController mcontroller : _managerController) {
        {
          final ISemanticRegion open2 = this.textRegionExtensions.regionFor(mcontroller).keyword("{");
          final ISemanticRegion close2 = this.textRegionExtensions.regionFor(mcontroller).keyword("}");
          final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
            it.newLine();
          };
          document.append(open2, _function_6);
          final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
            it.indent();
          };
          document.<ISemanticRegion, ISemanticRegion>interior(open2, close2, _function_7);
        }
      }
    }
    EList<DSLManaging> _managing_4 = architecture.getManaging();
    for (final DSLManaging managing_4 : _managing_4) {
      EList<DSLController> _controller_1 = managing_4.getController();
      for (final DSLController controller_1 : _controller_1) {
        EList<DSLKnowledge> _knowledge = controller_1.getKnowledge();
        for (final DSLKnowledge knowledge : _knowledge) {
          {
            final ISemanticRegion open2 = this.textRegionExtensions.regionFor(knowledge).keyword("{");
            final ISemanticRegion close2 = this.textRegionExtensions.regionFor(knowledge).keyword("}");
            final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
              it.newLine();
            };
            document.append(open2, _function_6);
            final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
              it.indent();
            };
            document.<ISemanticRegion, ISemanticRegion>interior(open2, close2, _function_7);
          }
        }
      }
    }
    EList<DSLManaged> _managed_1 = architecture.getManaged();
    for (final DSLManaged managed_1 : _managed_1) {
      {
        final ISemanticRegion open2 = this.textRegionExtensions.regionFor(managed_1).keyword("{");
        final ISemanticRegion close2 = this.textRegionExtensions.regionFor(managed_1).keyword("}");
        final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.append(open2, _function_6);
        final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
          it.indent();
        };
        document.<ISemanticRegion, ISemanticRegion>interior(open2, close2, _function_7);
      }
    }
  }
  
  public void format(final Object architecture, final IFormattableDocument document) {
    if (architecture instanceof XtextResource) {
      _format((XtextResource)architecture, document);
      return;
    } else if (architecture instanceof ArchitectureDefinition) {
      _format((ArchitectureDefinition)architecture, document);
      return;
    } else if (architecture instanceof EObject) {
      _format((EObject)architecture, document);
      return;
    } else if (architecture == null) {
      _format((Void)null, document);
      return;
    } else if (architecture != null) {
      _format(architecture, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(architecture, document).toString());
    }
  }
}
