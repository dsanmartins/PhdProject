/**
 */
package rMSAS.architecturalModel;

import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.architecturalModel.Delete#getFrom <em>From</em>}</li>
 * </ul>
 *
 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getDelete()
 * @model
 * @generated
 */
public interface Delete extends AbstractArchitecturalOperation {
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
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getDelete_From()
	 * @model
	 * @generated
	 */
	AbstractStructureElement getFrom();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.Delete#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(AbstractStructureElement value);

} // Delete
