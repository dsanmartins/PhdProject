/**
 */
package rMSAS.architecturalModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architectural Refactoring</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.architecturalModel.ArchitecturalRefactoring#getName <em>Name</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.ArchitecturalRefactoring#getSmell <em>Smell</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.ArchitecturalRefactoring#getEngine <em>Engine</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.ArchitecturalRefactoring#getDescription <em>Description</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.ArchitecturalRefactoring#getArchitecturalOperation <em>Architectural Operation</em>}</li>
 * </ul>
 *
 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoring()
 * @model
 * @generated
 */
public interface ArchitecturalRefactoring extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoring_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.ArchitecturalRefactoring#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Smell</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smell</em>' attribute.
	 * @see #setSmell(String)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoring_Smell()
	 * @model
	 * @generated
	 */
	String getSmell();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.ArchitecturalRefactoring#getSmell <em>Smell</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smell</em>' attribute.
	 * @see #getSmell()
	 * @generated
	 */
	void setSmell(String value);

	/**
	 * Returns the value of the '<em><b>Engine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine</em>' attribute.
	 * @see #setEngine(String)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoring_Engine()
	 * @model
	 * @generated
	 */
	String getEngine();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.ArchitecturalRefactoring#getEngine <em>Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine</em>' attribute.
	 * @see #getEngine()
	 * @generated
	 */
	void setEngine(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoring_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.ArchitecturalRefactoring#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Architectural Operation</b></em>' containment reference list.
	 * The list contents are of type {@link rMSAS.architecturalModel.AbstractArchitecturalOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Architectural Operation</em>' containment reference list.
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoring_ArchitecturalOperation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractArchitecturalOperation> getArchitecturalOperation();

} // ArchitecturalRefactoring
