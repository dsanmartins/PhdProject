/**
 */
package rMSAS.constraintModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import rMSAS.constraintModel.AbstractCondition;
import rMSAS.constraintModel.ConstraintModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.constraintModel.impl.AbstractConditionImpl#getOclQuery <em>Ocl Query</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractConditionImpl extends MinimalEObjectImpl.Container implements AbstractCondition {
	/**
	 * The default value of the '{@link #getOclQuery() <em>Ocl Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String OCL_QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOclQuery() <em>Ocl Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclQuery()
	 * @generated
	 * @ordered
	 */
	protected String oclQuery = OCL_QUERY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintModelPackage.Literals.ABSTRACT_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOclQuery() {
		return oclQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOclQuery(String newOclQuery) {
		String oldOclQuery = oclQuery;
		oclQuery = newOclQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintModelPackage.ABSTRACT_CONDITION__OCL_QUERY, oldOclQuery, oclQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintModelPackage.ABSTRACT_CONDITION__OCL_QUERY:
				return getOclQuery();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintModelPackage.ABSTRACT_CONDITION__OCL_QUERY:
				setOclQuery((String)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConstraintModelPackage.ABSTRACT_CONDITION__OCL_QUERY:
				setOclQuery(OCL_QUERY_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConstraintModelPackage.ABSTRACT_CONDITION__OCL_QUERY:
				return OCL_QUERY_EDEFAULT == null ? oclQuery != null : !OCL_QUERY_EDEFAULT.equals(oclQuery);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (oclQuery: ");
		result.append(oclQuery);
		result.append(')');
		return result.toString();
	}

} //AbstractConditionImpl
