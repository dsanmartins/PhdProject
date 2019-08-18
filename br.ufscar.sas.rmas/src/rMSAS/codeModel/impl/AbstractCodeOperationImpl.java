/**
 */
package rMSAS.codeModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeElement;

import rMSAS.codeModel.AbstractCodeOperation;
import rMSAS.codeModel.CodeModelPackage;

import rMSAS.constraintModel.AbstractCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Code Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.codeModel.impl.AbstractCodeOperationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link rMSAS.codeModel.impl.AbstractCodeOperationImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link rMSAS.codeModel.impl.AbstractCodeOperationImpl#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractCodeOperationImpl extends MinimalEObjectImpl.Container implements AbstractCodeOperation {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected AbstractCondition condition;

	/**
	 * The cached value of the '{@link #getEntity() <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntity()
	 * @generated
	 * @ordered
	 */
	protected AbstractCodeElement entity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractCodeOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodeModelPackage.Literals.ABSTRACT_CODE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodeModelPackage.ABSTRACT_CODE_OPERATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractCondition getCondition() {
		if (condition != null && condition.eIsProxy()) {
			InternalEObject oldCondition = (InternalEObject)condition;
			condition = (AbstractCondition)eResolveProxy(oldCondition);
			if (condition != oldCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodeModelPackage.ABSTRACT_CODE_OPERATION__CONDITION, oldCondition, condition));
			}
		}
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractCondition basicGetCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCondition(AbstractCondition newCondition) {
		AbstractCondition oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodeModelPackage.ABSTRACT_CODE_OPERATION__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractCodeElement getEntity() {
		if (entity != null && entity.eIsProxy()) {
			InternalEObject oldEntity = (InternalEObject)entity;
			entity = (AbstractCodeElement)eResolveProxy(oldEntity);
			if (entity != oldEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodeModelPackage.ABSTRACT_CODE_OPERATION__ENTITY, oldEntity, entity));
			}
		}
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractCodeElement basicGetEntity() {
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEntity(AbstractCodeElement newEntity) {
		AbstractCodeElement oldEntity = entity;
		entity = newEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodeModelPackage.ABSTRACT_CODE_OPERATION__ENTITY, oldEntity, entity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__DESCRIPTION:
				return getDescription();
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__CONDITION:
				if (resolve) return getCondition();
				return basicGetCondition();
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__ENTITY:
				if (resolve) return getEntity();
				return basicGetEntity();
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
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__CONDITION:
				setCondition((AbstractCondition)newValue);
				return;
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__ENTITY:
				setEntity((AbstractCodeElement)newValue);
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
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__CONDITION:
				setCondition((AbstractCondition)null);
				return;
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__ENTITY:
				setEntity((AbstractCodeElement)null);
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
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__CONDITION:
				return condition != null;
			case CodeModelPackage.ABSTRACT_CODE_OPERATION__ENTITY:
				return entity != null;
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
		result.append(" (description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //AbstractCodeOperationImpl
