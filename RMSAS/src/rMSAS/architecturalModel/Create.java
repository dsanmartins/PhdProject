/**
 */
package rMSAS.architecturalModel;

import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.architecturalModel.Create#getIn <em>In</em>}</li>
 * </ul>
 *
 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getCreate()
 * @model
 * @generated
 */
public interface Create extends AbstractArchitecturalOperation {
	/**
	 * Returns the value of the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' reference.
	 * @see #setIn(AbstractStructureElement)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getCreate_In()
	 * @model
	 * @generated
	 */
	AbstractStructureElement getIn();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.Create#getIn <em>In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In</em>' reference.
	 * @see #getIn()
	 * @generated
	 */
	void setIn(AbstractStructureElement value);

} // Create
