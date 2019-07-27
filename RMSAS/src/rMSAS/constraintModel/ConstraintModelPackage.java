/**
 */
package rMSAS.constraintModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see rMSAS.constraintModel.ConstraintModelFactory
 * @model kind="package"
 * @generated
 */
public interface ConstraintModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "constraintModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/rMSAS/constraintModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "constraintModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConstraintModelPackage eINSTANCE = rMSAS.constraintModel.impl.ConstraintModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link rMSAS.constraintModel.impl.AbstractConditionImpl <em>Abstract Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.constraintModel.impl.AbstractConditionImpl
	 * @see rMSAS.constraintModel.impl.ConstraintModelPackageImpl#getAbstractCondition()
	 * @generated
	 */
	int ABSTRACT_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Ocl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION__OCL_QUERY = 0;

	/**
	 * The number of structural features of the '<em>Abstract Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Abstract Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONDITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rMSAS.constraintModel.impl.PreConditionImpl <em>Pre Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.constraintModel.impl.PreConditionImpl
	 * @see rMSAS.constraintModel.impl.ConstraintModelPackageImpl#getPreCondition()
	 * @generated
	 */
	int PRE_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Ocl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_CONDITION__OCL_QUERY = ABSTRACT_CONDITION__OCL_QUERY;

	/**
	 * The number of structural features of the '<em>Pre Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_CONDITION_FEATURE_COUNT = ABSTRACT_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pre Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_CONDITION_OPERATION_COUNT = ABSTRACT_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rMSAS.constraintModel.impl.PostConditionImpl <em>Post Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rMSAS.constraintModel.impl.PostConditionImpl
	 * @see rMSAS.constraintModel.impl.ConstraintModelPackageImpl#getPostCondition()
	 * @generated
	 */
	int POST_CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Ocl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_CONDITION__OCL_QUERY = ABSTRACT_CONDITION__OCL_QUERY;

	/**
	 * The number of structural features of the '<em>Post Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_CONDITION_FEATURE_COUNT = ABSTRACT_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Post Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_CONDITION_OPERATION_COUNT = ABSTRACT_CONDITION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link rMSAS.constraintModel.AbstractCondition <em>Abstract Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Condition</em>'.
	 * @see rMSAS.constraintModel.AbstractCondition
	 * @generated
	 */
	EClass getAbstractCondition();

	/**
	 * Returns the meta object for the attribute '{@link rMSAS.constraintModel.AbstractCondition#getOclQuery <em>Ocl Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ocl Query</em>'.
	 * @see rMSAS.constraintModel.AbstractCondition#getOclQuery()
	 * @see #getAbstractCondition()
	 * @generated
	 */
	EAttribute getAbstractCondition_OclQuery();

	/**
	 * Returns the meta object for class '{@link rMSAS.constraintModel.PreCondition <em>Pre Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pre Condition</em>'.
	 * @see rMSAS.constraintModel.PreCondition
	 * @generated
	 */
	EClass getPreCondition();

	/**
	 * Returns the meta object for class '{@link rMSAS.constraintModel.PostCondition <em>Post Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Condition</em>'.
	 * @see rMSAS.constraintModel.PostCondition
	 * @generated
	 */
	EClass getPostCondition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConstraintModelFactory getConstraintModelFactory();

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
		 * The meta object literal for the '{@link rMSAS.constraintModel.impl.AbstractConditionImpl <em>Abstract Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.constraintModel.impl.AbstractConditionImpl
		 * @see rMSAS.constraintModel.impl.ConstraintModelPackageImpl#getAbstractCondition()
		 * @generated
		 */
		EClass ABSTRACT_CONDITION = eINSTANCE.getAbstractCondition();

		/**
		 * The meta object literal for the '<em><b>Ocl Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_CONDITION__OCL_QUERY = eINSTANCE.getAbstractCondition_OclQuery();

		/**
		 * The meta object literal for the '{@link rMSAS.constraintModel.impl.PreConditionImpl <em>Pre Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.constraintModel.impl.PreConditionImpl
		 * @see rMSAS.constraintModel.impl.ConstraintModelPackageImpl#getPreCondition()
		 * @generated
		 */
		EClass PRE_CONDITION = eINSTANCE.getPreCondition();

		/**
		 * The meta object literal for the '{@link rMSAS.constraintModel.impl.PostConditionImpl <em>Post Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rMSAS.constraintModel.impl.PostConditionImpl
		 * @see rMSAS.constraintModel.impl.ConstraintModelPackageImpl#getPostCondition()
		 * @generated
		 */
		EClass POST_CONDITION = eINSTANCE.getPostCondition();

	}

} //ConstraintModelPackage
