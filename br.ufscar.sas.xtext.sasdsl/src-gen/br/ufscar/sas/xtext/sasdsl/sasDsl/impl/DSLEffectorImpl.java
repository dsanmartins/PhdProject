/**
 * generated by Xtext 2.21.0
 */
package br.ufscar.sas.xtext.sasdsl.sasDsl.impl;

import br.ufscar.sas.xtext.sasdsl.sasDsl.DCLStructureElement;
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLEffector;
import br.ufscar.sas.xtext.sasdsl.sasDsl.SasDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DSL Effector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link br.ufscar.sas.xtext.sasdsl.sasDsl.impl.DSLEffectorImpl#getName <em>Name</em>}</li>
 *   <li>{@link br.ufscar.sas.xtext.sasdsl.sasDsl.impl.DSLEffectorImpl#getLayer <em>Layer</em>}</li>
 *   <li>{@link br.ufscar.sas.xtext.sasdsl.sasDsl.impl.DSLEffectorImpl#getSubSystem <em>Sub System</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DSLEffectorImpl extends MinimalEObjectImpl.Container implements DSLEffector
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
   * The cached value of the '{@link #getLayer() <em>Layer</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLayer()
   * @generated
   * @ordered
   */
  protected DCLStructureElement layer;

  /**
   * The cached value of the '{@link #getSubSystem() <em>Sub System</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubSystem()
   * @generated
   * @ordered
   */
  protected DCLStructureElement subSystem;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DSLEffectorImpl()
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
    return SasDslPackage.Literals.DSL_EFFECTOR;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SasDslPackage.DSL_EFFECTOR__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DCLStructureElement getLayer()
  {
    if (layer != null && layer.eIsProxy())
    {
      InternalEObject oldLayer = (InternalEObject)layer;
      layer = (DCLStructureElement)eResolveProxy(oldLayer);
      if (layer != oldLayer)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SasDslPackage.DSL_EFFECTOR__LAYER, oldLayer, layer));
      }
    }
    return layer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DCLStructureElement basicGetLayer()
  {
    return layer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLayer(DCLStructureElement newLayer)
  {
    DCLStructureElement oldLayer = layer;
    layer = newLayer;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SasDslPackage.DSL_EFFECTOR__LAYER, oldLayer, layer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DCLStructureElement getSubSystem()
  {
    if (subSystem != null && subSystem.eIsProxy())
    {
      InternalEObject oldSubSystem = (InternalEObject)subSystem;
      subSystem = (DCLStructureElement)eResolveProxy(oldSubSystem);
      if (subSystem != oldSubSystem)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SasDslPackage.DSL_EFFECTOR__SUB_SYSTEM, oldSubSystem, subSystem));
      }
    }
    return subSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DCLStructureElement basicGetSubSystem()
  {
    return subSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSubSystem(DCLStructureElement newSubSystem)
  {
    DCLStructureElement oldSubSystem = subSystem;
    subSystem = newSubSystem;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SasDslPackage.DSL_EFFECTOR__SUB_SYSTEM, oldSubSystem, subSystem));
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
      case SasDslPackage.DSL_EFFECTOR__NAME:
        return getName();
      case SasDslPackage.DSL_EFFECTOR__LAYER:
        if (resolve) return getLayer();
        return basicGetLayer();
      case SasDslPackage.DSL_EFFECTOR__SUB_SYSTEM:
        if (resolve) return getSubSystem();
        return basicGetSubSystem();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SasDslPackage.DSL_EFFECTOR__NAME:
        setName((String)newValue);
        return;
      case SasDslPackage.DSL_EFFECTOR__LAYER:
        setLayer((DCLStructureElement)newValue);
        return;
      case SasDslPackage.DSL_EFFECTOR__SUB_SYSTEM:
        setSubSystem((DCLStructureElement)newValue);
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
      case SasDslPackage.DSL_EFFECTOR__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SasDslPackage.DSL_EFFECTOR__LAYER:
        setLayer((DCLStructureElement)null);
        return;
      case SasDslPackage.DSL_EFFECTOR__SUB_SYSTEM:
        setSubSystem((DCLStructureElement)null);
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
      case SasDslPackage.DSL_EFFECTOR__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SasDslPackage.DSL_EFFECTOR__LAYER:
        return layer != null;
      case SasDslPackage.DSL_EFFECTOR__SUB_SYSTEM:
        return subSystem != null;
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

} //DSLEffectorImpl
