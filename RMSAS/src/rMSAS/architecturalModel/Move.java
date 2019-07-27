/**
 */
package rMSAS.architecturalModel;

import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Move</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.architecturalModel.Move#getFrom <em>From</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.Move#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getMove()
 * @model
 * @generated
 */
public interface Move extends AbstractArchitecturalOperation {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(AbstractStructureElement)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getMove_From()
	 * @model
	 * @generated
	 */
	AbstractStructureElement getFrom();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.Move#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(AbstractStructureElement value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(AbstractStructureElement)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getMove_To()
	 * @model
	 * @generated
	 */
	AbstractStructureElement getTo();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.Move#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(AbstractStructureElement value);

} // Move
