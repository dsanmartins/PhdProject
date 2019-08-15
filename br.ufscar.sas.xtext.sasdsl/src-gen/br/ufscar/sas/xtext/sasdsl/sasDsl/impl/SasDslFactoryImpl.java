/**
 * generated by Xtext 2.16.0
 */
package br.ufscar.sas.xtext.sasdsl.sasDsl.impl;

import br.ufscar.sas.xtext.sasdsl.sasDsl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SasDslFactoryImpl extends EFactoryImpl implements SasDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SasDslFactory init()
  {
    try
    {
      SasDslFactory theSasDslFactory = (SasDslFactory)EPackage.Registry.INSTANCE.getEFactory(SasDslPackage.eNS_URI);
      if (theSasDslFactory != null)
      {
        return theSasDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SasDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SasDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SasDslPackage.ARCHITECTURE_DEFINITION: return createArchitectureDefinition();
      case SasDslPackage.DSL_RULES: return createDSLRules();
      case SasDslPackage.DSL_RULE_MCONTROLLER: return createDSLRuleMController();
      case SasDslPackage.DSL_RULE_CONTROLLER: return createDSLRuleController();
      case SasDslPackage.DSL_RULE_MONITOR: return createDSLRuleMonitor();
      case SasDslPackage.DSL_RULE_ANALYZER: return createDSLRuleAnalyzer();
      case SasDslPackage.DSL_RULE_PLANNER: return createDSLRulePlanner();
      case SasDslPackage.DSL_RULE_EXECUTOR: return createDSLRuleExecutor();
      case SasDslPackage.DSL_RULE_MO: return createDSLRuleMO();
      case SasDslPackage.DSL_MANAGING: return createDSLManaging();
      case SasDslPackage.DSL_MANAGED: return createDSLManaged();
      case SasDslPackage.DSL_MANAGER_CONTROLLER: return createDSLManagerController();
      case SasDslPackage.DSL_CONTROLLER: return createDSLController();
      case SasDslPackage.DSL_MONITOR: return createDSLMonitor();
      case SasDslPackage.DSL_ANALYZER: return createDSLAnalyzer();
      case SasDslPackage.DSL_PLANNER: return createDSLPlanner();
      case SasDslPackage.DSL_EXECUTOR: return createDSLExecutor();
      case SasDslPackage.DSL_KNOWLEDGE: return createDSLKnowledge();
      case SasDslPackage.DSL_SENSOR: return createDSLSensor();
      case SasDslPackage.DSL_EFFECTOR: return createDSLEffector();
      case SasDslPackage.DSL_REFERENCE_INPUT: return createDSLReferenceInput();
      case SasDslPackage.DSL_MEASURED_OUTPUT: return createDSLMeasuredOutput();
      case SasDslPackage.DSL_SELF_HEALING_ALT: return createDSLSelfHealingAlt();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArchitectureDefinition createArchitectureDefinition()
  {
    ArchitectureDefinitionImpl architectureDefinition = new ArchitectureDefinitionImpl();
    return architectureDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLRules createDSLRules()
  {
    DSLRulesImpl dslRules = new DSLRulesImpl();
    return dslRules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLRuleMController createDSLRuleMController()
  {
    DSLRuleMControllerImpl dslRuleMController = new DSLRuleMControllerImpl();
    return dslRuleMController;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLRuleController createDSLRuleController()
  {
    DSLRuleControllerImpl dslRuleController = new DSLRuleControllerImpl();
    return dslRuleController;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLRuleMonitor createDSLRuleMonitor()
  {
    DSLRuleMonitorImpl dslRuleMonitor = new DSLRuleMonitorImpl();
    return dslRuleMonitor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLRuleAnalyzer createDSLRuleAnalyzer()
  {
    DSLRuleAnalyzerImpl dslRuleAnalyzer = new DSLRuleAnalyzerImpl();
    return dslRuleAnalyzer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLRulePlanner createDSLRulePlanner()
  {
    DSLRulePlannerImpl dslRulePlanner = new DSLRulePlannerImpl();
    return dslRulePlanner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLRuleExecutor createDSLRuleExecutor()
  {
    DSLRuleExecutorImpl dslRuleExecutor = new DSLRuleExecutorImpl();
    return dslRuleExecutor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLRuleMO createDSLRuleMO()
  {
    DSLRuleMOImpl dslRuleMO = new DSLRuleMOImpl();
    return dslRuleMO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLManaging createDSLManaging()
  {
    DSLManagingImpl dslManaging = new DSLManagingImpl();
    return dslManaging;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLManaged createDSLManaged()
  {
    DSLManagedImpl dslManaged = new DSLManagedImpl();
    return dslManaged;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLManagerController createDSLManagerController()
  {
    DSLManagerControllerImpl dslManagerController = new DSLManagerControllerImpl();
    return dslManagerController;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLController createDSLController()
  {
    DSLControllerImpl dslController = new DSLControllerImpl();
    return dslController;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLMonitor createDSLMonitor()
  {
    DSLMonitorImpl dslMonitor = new DSLMonitorImpl();
    return dslMonitor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLAnalyzer createDSLAnalyzer()
  {
    DSLAnalyzerImpl dslAnalyzer = new DSLAnalyzerImpl();
    return dslAnalyzer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLPlanner createDSLPlanner()
  {
    DSLPlannerImpl dslPlanner = new DSLPlannerImpl();
    return dslPlanner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLExecutor createDSLExecutor()
  {
    DSLExecutorImpl dslExecutor = new DSLExecutorImpl();
    return dslExecutor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLKnowledge createDSLKnowledge()
  {
    DSLKnowledgeImpl dslKnowledge = new DSLKnowledgeImpl();
    return dslKnowledge;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLSensor createDSLSensor()
  {
    DSLSensorImpl dslSensor = new DSLSensorImpl();
    return dslSensor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLEffector createDSLEffector()
  {
    DSLEffectorImpl dslEffector = new DSLEffectorImpl();
    return dslEffector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLReferenceInput createDSLReferenceInput()
  {
    DSLReferenceInputImpl dslReferenceInput = new DSLReferenceInputImpl();
    return dslReferenceInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLMeasuredOutput createDSLMeasuredOutput()
  {
    DSLMeasuredOutputImpl dslMeasuredOutput = new DSLMeasuredOutputImpl();
    return dslMeasuredOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DSLSelfHealingAlt createDSLSelfHealingAlt()
  {
    DSLSelfHealingAltImpl dslSelfHealingAlt = new DSLSelfHealingAltImpl();
    return dslSelfHealingAlt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SasDslPackage getSasDslPackage()
  {
    return (SasDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SasDslPackage getPackage()
  {
    return SasDslPackage.eINSTANCE;
  }

} //SasDslFactoryImpl
