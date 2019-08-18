/**
 */
package rMSAS.codeModel;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeElement;

import rMSAS.constraintModel.AbstractCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Code Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.codeModel.AbstractCodeOperation#getDescription <em>Description</em>}</li>
 *   <li>{@link rMSAS.codeModel.AbstractCodeOperation#getCondition <em>Condition</em>}</li>
 *   <li>{@link rMSAS.codeModel.AbstractCodeOperation#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @see rMSAS.codeModel.CodeModelPackage#getAbstractCodeOperation()
 * @model abstract="true"
 * @generated
 */
public interface AbstractCodeOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see rMSAS.codeModel.CodeModelPackage#getAbstractCodeOperation_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link rMSAS.codeModel.AbstractCodeOperation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(AbstractCondition)
	 * @see rMSAS.codeModel.CodeModelPackage#getAbstractCodeOperation_Condition()
	 * @model
	 * @generated
	 */
	AbstractCondition getCondition();

	/**
	 * Sets the value of the '{@link rMSAS.codeModel.AbstractCodeOperation#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(AbstractCondition value);

	/**
	 * Returns the value of the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' reference.
	 * @see #setEntity(AbstractCodeElement)
	 * @see rMSAS.codeModel.CodeModelPackage#getAbstractCodeOperation_Entity()
	 * @model required="true"
	 * @generated
	 */
	AbstractCodeElement getEntity();

	/**
	 * Sets the value of the '{@link rMSAS.codeModel.AbstractCodeOperation#getEntity <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(AbstractCodeElement value);

} // AbstractCodeOperation
