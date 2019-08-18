/**
 */
package rMSAS.codeModel;

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
 * @see rMSAS.codeModel.CodeModelFactory
 * @model kind="package"
 * @generated
 */
public interface CodeModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "codeModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/rMSAS/codeModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "codeModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CodeModelPackage eINSTANCE = rMSAS.codeModel.impl.CodeModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link rMSAS.codeModel.impl.AbstractCodeOperationImpl <em>Abstract Code Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.codeModel.impl.AbstractCodeOperationImpl
	 * @see rMSAS.codeModel.impl.CodeModelPackageImpl#getAbstractCodeOperation()
	 * @generated
	 */
	int ABSTRACT_CODE_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CODE_OPERATION__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CODE_OPERATION__CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CODE_OPERATION__ENTITY = 2;

	/**
	 * The number of structural features of the '<em>Abstract Code Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CODE_OPERATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Abstract Code Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CODE_OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rMSAS.codeModel.impl.MoveImpl <em>Move</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.codeModel.impl.MoveImpl
	 * @see rMSAS.codeModel.impl.CodeModelPackageImpl#getMove()
	 * @generated
	 */
	int MOVE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__DESCRIPTION = ABSTRACT_CODE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__CONDITION = ABSTRACT_CODE_OPERATION__CONDITION;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__ENTITY = ABSTRACT_CODE_OPERATION__ENTITY;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__FROM = ABSTRACT_CODE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE__TO = ABSTRACT_CODE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Move</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_FEATURE_COUNT = ABSTRACT_CODE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Move</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_OPERATION_COUNT = ABSTRACT_CODE_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rMSAS.codeModel.impl.CreateImpl <em>Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.codeModel.impl.CreateImpl
	 * @see rMSAS.codeModel.impl.CodeModelPackageImpl#getCreate()
	 * @generated
	 */
	int CREATE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__DESCRIPTION = ABSTRACT_CODE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__CONDITION = ABSTRACT_CODE_OPERATION__CONDITION;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__ENTITY = ABSTRACT_CODE_OPERATION__ENTITY;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__IN = ABSTRACT_CODE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FEATURE_COUNT = ABSTRACT_CODE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OPERATION_COUNT = ABSTRACT_CODE_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rMSAS.codeModel.impl.DeleteImpl <em>Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.codeModel.impl.DeleteImpl
	 * @see rMSAS.codeModel.impl.CodeModelPackageImpl#getDelete()
	 * @generated
	 */
	int DELETE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__DESCRIPTION = ABSTRACT_CODE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__CONDITION = ABSTRACT_CODE_OPERATION__CONDITION;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__ENTITY = ABSTRACT_CODE_OPERATION__ENTITY;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__FROM = ABSTRACT_CODE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FEATURE_COUNT = ABSTRACT_CODE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_OPERATION_COUNT = ABSTRACT_CODE_OPERATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link rMSAS.codeModel.AbstractCodeOperation <em>Abstract Code Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Code Operation</em>'.
	 * @see rMSAS.codeModel.AbstractCodeOperation
	 * @generated
	 */
	EClass getAbstractCodeOperation();

	/**
	 * Returns the meta object for the attribute '{@link rMSAS.codeModel.AbstractCodeOperation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see rMSAS.codeModel.AbstractCodeOperation#getDescription()
	 * @see #getAbstractCodeOperation()
	 * @generated
	 */
	EAttribute getAbstractCodeOperation_Description();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.codeModel.AbstractCodeOperation#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see rMSAS.codeModel.AbstractCodeOperation#getCondition()
	 * @see #getAbstractCodeOperation()
	 * @generated
	 */
	EReference getAbstractCodeOperation_Condition();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.codeModel.AbstractCodeOperation#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entity</em>'.
	 * @see rMSAS.codeModel.AbstractCodeOperation#getEntity()
	 * @see #getAbstractCodeOperation()
	 * @generated
	 */
	EReference getAbstractCodeOperation_Entity();

	/**
	 * Returns the meta object for class '{@link rMSAS.codeModel.Move <em>Move</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Move</em>'.
	 * @see rMSAS.codeModel.Move
	 * @generated
	 */
	EClass getMove();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.codeModel.Move#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see rMSAS.codeModel.Move#getFrom()
	 * @see #getMove()
	 * @generated
	 */
	EReference getMove_From();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.codeModel.Move#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see rMSAS.codeModel.Move#getTo()
	 * @see #getMove()
	 * @generated
	 */
	EReference getMove_To();

	/**
	 * Returns the meta object for class '{@link rMSAS.codeModel.Create <em>Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create</em>'.
	 * @see rMSAS.codeModel.Create
	 * @generated
	 */
	EClass getCreate();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.codeModel.Create#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In</em>'.
	 * @see rMSAS.codeModel.Create#getIn()
	 * @see #getCreate()
	 * @generated
	 */
	EReference getCreate_In();

	/**
	 * Returns the meta object for class '{@link rMSAS.codeModel.Delete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete</em>'.
	 * @see rMSAS.codeModel.Delete
	 * @generated
	 */
	EClass getDelete();

	/**
	 * Returns the meta object for the reference '{@link rMSAS.codeModel.Delete#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see rMSAS.codeModel.Delete#getFrom()
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
	CodeModelFactory getCodeModelFactory();

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
		 * The meta object literal for the '{@link rMSAS.codeModel.impl.AbstractCodeOperationImpl <em>Abstract Code Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.codeModel.impl.AbstractCodeOperationImpl
		 * @see rMSAS.codeModel.impl.CodeModelPackageImpl#getAbstractCodeOperation()
		 * @generated
		 */
		EClass ABSTRACT_CODE_OPERATION = eINSTANCE.getAbstractCodeOperation();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_CODE_OPERATION__DESCRIPTION = eINSTANCE.getAbstractCodeOperation_Description();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_CODE_OPERATION__CONDITION = eINSTANCE.getAbstractCodeOperation_Condition();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_CODE_OPERATION__ENTITY = eINSTANCE.getAbstractCodeOperation_Entity();

		/**
		 * The meta object literal for the '{@link rMSAS.codeModel.impl.MoveImpl <em>Move</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.codeModel.impl.MoveImpl
		 * @see rMSAS.codeModel.impl.CodeModelPackageImpl#getMove()
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
		 * The meta object literal for the '{@link rMSAS.codeModel.impl.CreateImpl <em>Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.codeModel.impl.CreateImpl
		 * @see rMSAS.codeModel.impl.CodeModelPackageImpl#getCreate()
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
		 * The meta object literal for the '{@link rMSAS.codeModel.impl.DeleteImpl <em>Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.codeModel.impl.DeleteImpl
		 * @see rMSAS.codeModel.impl.CodeModelPackageImpl#getDelete()
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

} //CodeModelPackage
