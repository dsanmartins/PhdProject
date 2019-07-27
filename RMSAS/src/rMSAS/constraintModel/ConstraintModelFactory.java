/**
 */
package rMSAS.constraintModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see rMSAS.constraintModel.ConstraintModelPackage
 * @generated
 */
public interface ConstraintModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConstraintModelFactory eINSTANCE = rMSAS.constraintModel.impl.ConstraintModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Pre Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pre Condition</em>'.
	 * @generated
	 */
	PreCondition createPreCondition();

	/**
	 * Returns a new object of class '<em>Post Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Condition</em>'.
	 * @generated
	 */
	PostCondition createPostCondition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConstraintModelPackage getConstraintModelPackage();

} //ConstraintModelFactory
