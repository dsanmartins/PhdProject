/**
 * generated by Xtext 2.21.0
 */
package br.ufscar.sas.xtext.sasdsl.sasDsl.impl;

import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLAlternative;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLKnowledge;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLReferenceInput;
import br.ufscar.sas.xtext.sasdsl.sasDsl.SasDslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DSL Knowledge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link br.ufscar.sas.xtext.sasdsl.sasDsl.impl.DSLKnowledgeImpl#getName <em>Name</em>}</li>
 *   <li>{@link br.ufscar.sas.xtext.sasdsl.sasDsl.impl.DSLKnowledgeImpl#getReferenceInput <em>Reference Input</em>}</li>
 *   <li>{@link br.ufscar.sas.xtext.sasdsl.sasDsl.impl.DSLKnowledgeImpl#getShalt <em>Shalt</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DSLKnowledgeImpl extends MinimalEObjectImpl.Container implements DSLKnowledge
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getReferenceInput() <em>Reference Input</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenceInput()
   * @generated
   * @ordered
   */
  protected EList<DSLReferenceInput> referenceInput;

  /**
   * The cached value of the '{@link #getShalt() <em>Shalt</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShalt()
   * @generated
   * @ordered
   */
  protected EList<DSLAlternative> shalt;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DSLKnowledgeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SasDslPackage.Literals.DSL_KNOWLEDGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SasDslPackage.DSL_KNOWLEDGE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<DSLReferenceInput> getReferenceInput()
  {
    if (referenceInput == null)
    {
      referenceInput = new EObjectContainmentEList<DSLReferenceInput>(DSLReferenceInput.class, this, SasDslPackage.DSL_KNOWLEDGE__REFERENCE_INPUT);
    }
    return referenceInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<DSLAlternative> getShalt()
  {
    if (shalt == null)
    {
      shalt = new EObjectContainmentEList<DSLAlternative>(DSLAlternative.class, this, SasDslPackage.DSL_KNOWLEDGE__SHALT);
    }
    return shalt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SasDslPackage.DSL_KNOWLEDGE__REFERENCE_INPUT:
        return ((InternalEList<?>)getReferenceInput()).basicRemove(otherEnd, msgs);
      case SasDslPackage.DSL_KNOWLEDGE__SHALT:
        return ((InternalEList<?>)getShalt()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SasDslPackage.DSL_KNOWLEDGE__NAME:
        return getName();
      case SasDslPackage.DSL_KNOWLEDGE__REFERENCE_INPUT:
        return getReferenceInput();
      case SasDslPackage.DSL_KNOWLEDGE__SHALT:
        return getShalt();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SasDslPackage.DSL_KNOWLEDGE__NAME:
        setName((String)newValue);
        return;
      case SasDslPackage.DSL_KNOWLEDGE__REFERENCE_INPUT:
        getReferenceInput().clear();
        getReferenceInput().addAll((Collection<? extends DSLReferenceInput>)newValue);
        return;
      case SasDslPackage.DSL_KNOWLEDGE__SHALT:
        getShalt().clear();
        getShalt().addAll((Collection<? extends DSLAlternative>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SasDslPackage.DSL_KNOWLEDGE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SasDslPackage.DSL_KNOWLEDGE__REFERENCE_INPUT:
        getReferenceInput().clear();
        return;
      case SasDslPackage.DSL_KNOWLEDGE__SHALT:
        getShalt().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SasDslPackage.DSL_KNOWLEDGE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SasDslPackage.DSL_KNOWLEDGE__REFERENCE_INPUT:
        return referenceInput != null && !referenceInput.isEmpty();
      case SasDslPackage.DSL_KNOWLEDGE__SHALT:
        return shalt != null && !shalt.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //DSLKnowledgeImpl
