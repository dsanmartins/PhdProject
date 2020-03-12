/**
 */
package rMSAS.codeModel;

import org.eclipse.modisco.omg.kdm.code.AbstractCodeElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.codeModel.Create#getIn <em>In</em>}</li>
 *   <li>{@link rMSAS.codeModel.Create#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @see rMSAS.codeModel.CodeModelPackage#getCreate()
 * @model
 * @generated
 */
public interface Create extends AbstractCodeOperation {
	/**
	 * Returns the value of the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' reference.
	 * @see #setIn(AbstractCodeElement)
	 * @see rMSAS.codeModel.CodeModelPackage#getCreate_In()
	 * @model required="true"
	 * @generated
	 */
	AbstractCodeElement getIn();

	/**
	 * Sets the value of the '{@link rMSAS.codeModel.Create#getIn <em>In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In</em>' reference.
	 * @see #getIn()
	 * @generated
	 */
	void setIn(AbstractCodeElement value);

	/**
	 * Returns the value of the '<em><b>Entity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' attribute.
	 * @see #setEntity(String)
	 * @see rMSAS.codeModel.CodeModelPackage#getCreate_Entity()
	 * @model required="true"
	 * @generated
	 */
	String getEntity();

	/**
	 * Sets the value of the '{@link rMSAS.codeModel.Create#getEntity <em>Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' attribute.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(String value);

} // Create
