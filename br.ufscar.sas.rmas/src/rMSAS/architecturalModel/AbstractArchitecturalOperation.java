/**
 */
package rMSAS.architecturalModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import rMSAS.codeModel.AbstractCodeOperation;

import rMSAS.constraintModel.AbstractCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Architectural Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.architecturalModel.AbstractArchitecturalOperation#getDescription <em>Description</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.AbstractArchitecturalOperation#getCodeOperation <em>Code Operation</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.AbstractArchitecturalOperation#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getAbstractArchitecturalOperation()
 * @model abstract="true"
 * @generated
 */
public interface AbstractArchitecturalOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getAbstractArchitecturalOperation_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.AbstractArchitecturalOperation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Code Operation</b></em>' containment reference list.
	 * The list contents are of type {@link rMSAS.codeModel.AbstractCodeOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code Operation</em>' containment reference list.
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getAbstractArchitecturalOperation_CodeOperation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractCodeOperation> getCodeOperation();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(AbstractCondition)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getAbstractArchitecturalOperation_Condition()
	 * @model
	 * @generated
	 */
	AbstractCondition getCondition();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.AbstractArchitecturalOperation#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(AbstractCondition value);

} // AbstractArchitecturalOperation
