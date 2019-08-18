/**
 */
package rMSAS.constraintModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.constraintModel.AbstractCondition#getOclQuery <em>Ocl Query</em>}</li>
 * </ul>
 *
 * @see rMSAS.constraintModel.ConstraintModelPackage#getAbstractCondition()
 * @model abstract="true"
 * @generated
 */
public interface AbstractCondition extends EObject {
	/**
	 * Returns the value of the '<em><b>Ocl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Query</em>' attribute.
	 * @see #setOclQuery(String)
	 * @see rMSAS.constraintModel.ConstraintModelPackage#getAbstractCondition_OclQuery()
	 * @model
	 * @generated
	 */
	String getOclQuery();

	/**
	 * Sets the value of the '{@link rMSAS.constraintModel.AbstractCondition#getOclQuery <em>Ocl Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Query</em>' attribute.
	 * @see #getOclQuery()
	 * @generated
	 */
	void setOclQuery(String value);

} // AbstractCondition
