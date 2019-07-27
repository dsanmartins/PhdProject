/**
 */
package rMSAS.architecturalModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architectural Refactoring Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getName <em>Name</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getSmell <em>Smell</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getEngine <em>Engine</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getDescription <em>Description</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getArchitecturalOperation <em>Architectural Operation</em>}</li>
 * </ul>
 *
 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoringModel()
 * @model
 * @generated
 */
public interface ArchitecturalRefactoringModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoringModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getName <em>Name</em>}' attribute.
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
	 * <p>
	 * If the meaning of the '<em>Smell</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smell</em>' attribute.
	 * @see #setSmell(String)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoringModel_Smell()
	 * @model
	 * @generated
	 */
	String getSmell();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getSmell <em>Smell</em>}' attribute.
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
	 * <p>
	 * If the meaning of the '<em>Engine</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine</em>' attribute.
	 * @see #setEngine(String)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoringModel_Engine()
	 * @model
	 * @generated
	 */
	String getEngine();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getEngine <em>Engine</em>}' attribute.
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
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoringModel_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link rMSAS.architecturalModel.ArchitecturalRefactoringModel#getDescription <em>Description</em>}' attribute.
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
	 * <p>
	 * If the meaning of the '<em>Architectural Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Architectural Operation</em>' containment reference list.
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#getArchitecturalRefactoringModel_ArchitecturalOperation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractArchitecturalOperation> getArchitecturalOperation();

} // ArchitecturalRefactoringModel
