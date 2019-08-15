/**
 * generated by Xtext 2.16.0
 */
package br.ufscar.sas.xtext.sasdsl.sasDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DSL Knowledge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link br.ufscar.sas.xtext.sasdsl.sasDsl.DSLKnowledge#getName <em>Name</em>}</li>
 *   <li>{@link br.ufscar.sas.xtext.sasdsl.sasDsl.DSLKnowledge#getReferenceInput <em>Reference Input</em>}</li>
 *   <li>{@link br.ufscar.sas.xtext.sasdsl.sasDsl.DSLKnowledge#getShalt <em>Shalt</em>}</li>
 * </ul>
 *
 * @see br.ufscar.sas.xtext.sasdsl.sasDsl.SasDslPackage#getDSLKnowledge()
 * @model
 * @generated
 */
public interface DSLKnowledge extends EObject
{
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
   * @see br.ufscar.sas.xtext.sasdsl.sasDsl.SasDslPackage#getDSLKnowledge_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link br.ufscar.sas.xtext.sasdsl.sasDsl.DSLKnowledge#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Reference Input</b></em>' containment reference list.
   * The list contents are of type {@link br.ufscar.sas.xtext.sasdsl.sasDsl.DSLReferenceInput}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference Input</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Input</em>' containment reference list.
   * @see br.ufscar.sas.xtext.sasdsl.sasDsl.SasDslPackage#getDSLKnowledge_ReferenceInput()
   * @model containment="true"
   * @generated
   */
  EList<DSLReferenceInput> getReferenceInput();

  /**
   * Returns the value of the '<em><b>Shalt</b></em>' containment reference list.
   * The list contents are of type {@link br.ufscar.sas.xtext.sasdsl.sasDsl.DSLSelfHealingAlt}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Shalt</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Shalt</em>' containment reference list.
   * @see br.ufscar.sas.xtext.sasdsl.sasDsl.SasDslPackage#getDSLKnowledge_Shalt()
   * @model containment="true"
   * @generated
   */
  EList<DSLSelfHealingAlt> getShalt();

} // DSLKnowledge
