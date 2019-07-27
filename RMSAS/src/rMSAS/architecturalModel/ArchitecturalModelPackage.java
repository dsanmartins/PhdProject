/**
 */
package rMSAS.architecturalModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see rMSAS.architecturalModel.ArchitecturalModelFactory
 * @model kind="package"
 * @generated
 */
public interface ArchitecturalModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "architecturalModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/rMSAS/architecturalModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "architecturalModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchitecturalModelPackage eINSTANCE = rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link rMSAS.architecturalModel.impl.ArchitecturalRefactoringModelImpl <em>Architectural Refactoring Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.architecturalModel.impl.ArchitecturalRefactoringModelImpl
	 * @see rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl#getArchitecturalRefactoringModel()
	 * @generated
	 */
	int ARCHITECTURAL_REFACTORING_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_REFACTORING_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Smell</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_REFACTORING_MODEL__SMELL = 1;

	/**
	 * The feature id for the '<em><b>Engine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_REFACTORING_MODEL__ENGINE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_REFACTORING_MODEL__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Architectural Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_REFACTORING_MODEL__ARCHITECTURAL_OPERATION = 4;

	/**
	 * The number of structural features of the '<em>Architectural Refactoring Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_REFACTORING_MODEL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Architectural Refactoring Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_REFACTORING_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rMSAS.architecturalModel.impl.AbstractArchitecturalOperationImpl <em>Abstract Architectural Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.architecturalModel.impl.AbstractArchitecturalOperationImpl
	 * @see rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl#getAbstractArchitecturalOperation()
	 * @generated
	 */
	int ABSTRACT_ARCHITECTURAL_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ARCHITECTURAL_OPERATION__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Code Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION = 3;

	/**
	 * The number of structural features of the '<em>Abstract Architectural Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ARCHITECTURAL_OPERATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Abstract Architectural Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ARCHITECTURAL_OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rMSAS.architecturalModel.impl.MoveImpl <em>Move</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.architecturalModel.impl.MoveImpl
	 * @see rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl#getMove()
	 * @generated
	 */
	int MOVE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__DESCRIPTION = ABSTRACT_ARCHITECTURAL_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Code Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__CODE_OPERATION = ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__CONDITION = ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION;

	/**
	 * The feature id for the '<em><b>Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__ABSTRACTION = ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__FROM = ABSTRACT_ARCHITECTURAL_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__TO = ABSTRACT_ARCHITECTURAL_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Move</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_FEATURE_COUNT = ABSTRACT_ARCHITECTURAL_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Move</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_OPERATION_COUNT = ABSTRACT_ARCHITECTURAL_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rMSAS.architecturalModel.impl.CreateImpl <em>Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.architecturalModel.impl.CreateImpl
	 * @see rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl#getCreate()
	 * @generated
	 */
	int CREATE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__DESCRIPTION = ABSTRACT_ARCHITECTURAL_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Code Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__CODE_OPERATION = ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__CONDITION = ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION;

	/**
	 * The feature id for the '<em><b>Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__ABSTRACTION = ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__IN = ABSTRACT_ARCHITECTURAL_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FEATURE_COUNT = ABSTRACT_ARCHITECTURAL_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OPERATION_COUNT = ABSTRACT_ARCHITECTURAL_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rMSAS.architecturalModel.impl.DeleteImpl <em>Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.architecturalModel.impl.DeleteImpl
	 * @see rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl#getDelete()
	 * @generated
	 */
	int DELETE = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__DESCRIPTION = ABSTRACT_ARCHITECTURAL_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Code Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__CODE_OPERATION = ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__CONDITION = ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION;

	/**
	 * The feature id for the '<em><b>Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__ABSTRACTION = ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__FROM = ABSTRACT_ARCHITECTURAL_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FEATURE_COUNT = ABSTRACT_ARCHITECTURAL_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_OPERATION_COUNT = ABSTRACT_ARCHITECTURAL_OPERATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel <em>Architectural Refactoring Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architectural Refactoring Model</em>'.
	 * @see rMSAS.architecturalModel.ArchitecturalRefactoringModel
	 * @generated
	 */
	EClass getArchitecturalRefactoringModel();

	/**
	 * Returns the meta object for the attribute '{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see rMSAS.architecturalModel.ArchitecturalRefactoringModel#getName()
	 * @see #getArchitecturalRefactoringModel()
	 * @generated
	 */
	EAttribute getArchitecturalRefactoringModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getSmell <em>Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smell</em>'.
	 * @see rMSAS.architecturalModel.ArchitecturalRefactoringModel#getSmell()
	 * @see #getArchitecturalRefactoringModel()
	 * @generated
	 */
	EAttribute getArchitecturalRefactoringModel_Smell();

	/**
	 * Returns the meta object for the attribute '{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Engine</em>'.
	 * @see rMSAS.architecturalModel.ArchitecturalRefactoringModel#getEngine()
	 * @see #getArchitecturalRefactoringModel()
	 * @generated
	 */
	EAttribute getArchitecturalRefactoringModel_Engine();

	/**
	 * Returns the meta object for the attribute '{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see rMSAS.architecturalModel.ArchitecturalRefactoringModel#getDescription()
	 * @see #getArchitecturalRefactoringModel()
	 * @generated
	 */
	EAttribute getArchitecturalRefactoringModel_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getArchitecturalOperation <em>Architectural Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Architectural Operation</em>'.
	 * @see rMSAS.architecturalModel.ArchitecturalRefactoringModel#getArchitecturalOperation()
	 * @see #getArchitecturalRefactoringModel()
	 * @generated
	 */
	EReference getArchitecturalRefactoringModel_ArchitecturalOperation();

	/**
	 * Returns the meta object for class '{@link rMSAS.architecturalModel.AbstractArchitecturalOperation <em>Abstract Architectural Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Architectural Operation</em>'.
	 * @see rMSAS.architecturalModel.AbstractArchitecturalOperation
	 * @generated
	 */
	EClass getAbstractArchitecturalOperation();

	/**
	 * Returns the meta object for the attribute '{@link rMSAS.architecturalModel.AbstractArchitecturalOperation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see rMSAS.architecturalModel.AbstractArchitecturalOperation#getDescription()
	 * @see #getAbstractArchitecturalOperation()
	 * @generated
	 */
	EAttribute getAbstractArchitecturalOperation_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link rMSAS.architecturalModel.AbstractArchitecturalOperation#getCodeOperation <em>Code Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Code Operation</em>'.
	 * @see rMSAS.architecturalModel.AbstractArchitecturalOperation#getCodeOperation()
	 * @see #getAbstractArchitecturalOperation()
	 * @generated
	 */
	EReference getAbstractArchitecturalOperation_CodeOperation();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.architecturalModel.AbstractArchitecturalOperation#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see rMSAS.architecturalModel.AbstractArchitecturalOperation#getCondition()
	 * @see #getAbstractArchitecturalOperation()
	 * @generated
	 */
	EReference getAbstractArchitecturalOperation_Condition();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.architecturalModel.AbstractArchitecturalOperation#getAbstraction <em>Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Abstraction</em>'.
	 * @see rMSAS.architecturalModel.AbstractArchitecturalOperation#getAbstraction()
	 * @see #getAbstractArchitecturalOperation()
	 * @generated
	 */
	EReference getAbstractArchitecturalOperation_Abstraction();

	/**
	 * Returns the meta object for class '{@link rMSAS.architecturalModel.Move <em>Move</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Move</em>'.
	 * @see rMSAS.architecturalModel.Move
	 * @generated
	 */
	EClass getMove();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.architecturalModel.Move#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see rMSAS.architecturalModel.Move#getFrom()
	 * @see #getMove()
	 * @generated
	 */
	EReference getMove_From();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.architecturalModel.Move#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see rMSAS.architecturalModel.Move#getTo()
	 * @see #getMove()
	 * @generated
	 */
	EReference getMove_To();

	/**
	 * Returns the meta object for class '{@link rMSAS.architecturalModel.Create <em>Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create</em>'.
	 * @see rMSAS.architecturalModel.Create
	 * @generated
	 */
	EClass getCreate();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.architecturalModel.Create#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In</em>'.
	 * @see rMSAS.architecturalModel.Create#getIn()
	 * @see #getCreate()
	 * @generated
	 */
	EReference getCreate_In();

	/**
	 * Returns the meta object for class '{@link rMSAS.architecturalModel.Delete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete</em>'.
	 * @see rMSAS.architecturalModel.Delete
	 * @generated
	 */
	EClass getDelete();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.architecturalModel.Delete#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see rMSAS.architecturalModel.Delete#getFrom()
	 * @see #getDelete()
	 * @generated
	 */
	EReference getDelete_From();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArchitecturalModelFactory getArchitecturalModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link rMSAS.architecturalModel.impl.ArchitecturalRefactoringModelImpl <em>Architectural Refactoring Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.architecturalModel.impl.ArchitecturalRefactoringModelImpl
		 * @see rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl#getArchitecturalRefactoringModel()
		 * @generated
		 */
		EClass ARCHITECTURAL_REFACTORING_MODEL = eINSTANCE.getArchitecturalRefactoringModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURAL_REFACTORING_MODEL__NAME = eINSTANCE.getArchitecturalRefactoringModel_Name();

		/**
		 * The meta object literal for the '<em><b>Smell</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURAL_REFACTORING_MODEL__SMELL = eINSTANCE.getArchitecturalRefactoringModel_Smell();

		/**
		 * The meta object literal for the '<em><b>Engine</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURAL_REFACTORING_MODEL__ENGINE = eINSTANCE.getArchitecturalRefactoringModel_Engine();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURAL_REFACTORING_MODEL__DESCRIPTION = eINSTANCE.getArchitecturalRefactoringModel_Description();

		/**
		 * The meta object literal for the '<em><b>Architectural Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL_REFACTORING_MODEL__ARCHITECTURAL_OPERATION = eINSTANCE.getArchitecturalRefactoringModel_ArchitecturalOperation();

		/**
		 * The meta object literal for the '{@link rMSAS.architecturalModel.impl.AbstractArchitecturalOperationImpl <em>Abstract Architectural Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.architecturalModel.impl.AbstractArchitecturalOperationImpl
		 * @see rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl#getAbstractArchitecturalOperation()
		 * @generated
		 */
		EClass ABSTRACT_ARCHITECTURAL_OPERATION = eINSTANCE.getAbstractArchitecturalOperation();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_ARCHITECTURAL_OPERATION__DESCRIPTION = eINSTANCE.getAbstractArchitecturalOperation_Description();

		/**
		 * The meta object literal for the '<em><b>Code Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION = eINSTANCE.getAbstractArchitecturalOperation_CodeOperation();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION = eINSTANCE.getAbstractArchitecturalOperation_Condition();

		/**
		 * The meta object literal for the '<em><b>Abstraction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION = eINSTANCE.getAbstractArchitecturalOperation_Abstraction();

		/**
		 * The meta object literal for the '{@link rMSAS.architecturalModel.impl.MoveImpl <em>Move</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.architecturalModel.impl.MoveImpl
		 * @see rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl#getMove()
		 * @generated
		 */
		EClass MOVE = eINSTANCE.getMove();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVE__FROM = eINSTANCE.getMove_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVE__TO = eINSTANCE.getMove_To();

		/**
		 * The meta object literal for the '{@link rMSAS.architecturalModel.impl.CreateImpl <em>Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.architecturalModel.impl.CreateImpl
		 * @see rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl#getCreate()
		 * @generated
		 */
		EClass CREATE = eINSTANCE.getCreate();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE__IN = eINSTANCE.getCreate_In();

		/**
		 * The meta object literal for the '{@link rMSAS.architecturalModel.impl.DeleteImpl <em>Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.architecturalModel.impl.DeleteImpl
		 * @see rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl#getDelete()
		 * @generated
		 */
		EClass DELETE = eINSTANCE.getDelete();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE__FROM = eINSTANCE.getDelete_From();

	}

} //ArchitecturalModelPackage
