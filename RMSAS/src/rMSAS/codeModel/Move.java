/**
 */
package rMSAS.codeModel;

import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Move</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.codeModel.Move#getFrom <em>From</em>}</li>
 *   <li>{@link rMSAS.codeModel.Move#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see rMSAS.codeModel.CodeModelPackage#getMove()
 * @model
 * @generated
 */
public interface Move extends AbstractCodeOperation {
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
	 * @see rMSAS.codeModel.CodeModelPackage#getMove_From()
	 * @model required="true"
	 * @generated
	 */
	AbstractCodeElement getFrom();

	/**
	 * Sets the value of the '{@link rMSAS.codeModel.Move#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(AbstractCodeElement value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(AbstractCodeElement)
	 * @see rMSAS.codeModel.CodeModelPackage#getMove_To()
	 * @model required="true"
	 * @generated
	 */
	AbstractCodeElement getTo();

	/**
	 * Sets the value of the '{@link rMSAS.codeModel.Move#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(AbstractCodeElement value);

} // Move
