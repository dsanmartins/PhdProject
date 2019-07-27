/**
 */
package rMSAS.codeModel;

import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.codeModel.Delete#getFrom <em>From</em>}</li>
 * </ul>
 *
 * @see rMSAS.codeModel.CodeModelPackage#getDelete()
 * @model
 * @generated
 */
public interface Delete extends AbstractCodeOperation {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(AbstractCodeElement)
	 * @see rMSAS.codeModel.CodeModelPackage#getDelete_From()
	 * @model required="true"
	 * @generated
	 */
	AbstractCodeElement getFrom();

	/**
	 * Sets the value of the '{@link rMSAS.codeModel.Delete#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(AbstractCodeElement value);

} // Delete
