/**
 */
package rMSAS.codeModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmt.modisco.omg.kdm.code.AbstractCodeElement;

import rMSAS.codeModel.CodeModelPackage;
import rMSAS.codeModel.Create;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.codeModel.impl.CreateImpl#getIn <em>In</em>}</li>
 *   <li>{@link rMSAS.codeModel.impl.CreateImpl#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CreateImpl extends AbstractCodeOperationImpl implements Create {
	/**
	 * The cached value of the '{@link #getIn() <em>In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIn()
	 * @generated
	 * @ordered
	 */
	protected AbstractCodeElement in;

	/**
	 * The default value of the '{@link #getEntity() <em>Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntity()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntity() <em>Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntity()
	 * @generated
	 * @ordered
	 */
	protected String entity = ENTITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodeModelPackage.Literals.CREATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractCodeElement getIn() {
		if (in != null && in.eIsProxy()) {
			InternalEObject oldIn = (InternalEObject)in;
			in = (AbstractCodeElement)eResolveProxy(oldIn);
			if (in != oldIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodeModelPackage.CREATE__IN, oldIn, in));
			}
		}
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractCodeElement basicGetIn() {
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIn(AbstractCodeElement newIn) {
		AbstractCodeElement oldIn = in;
		in = newIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodeModelPackage.CREATE__IN, oldIn, in));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEntity() {
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEntity(String newEntity) {
		String oldEntity = entity;
		entity = newEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodeModelPackage.CREATE__ENTITY, oldEntity, entity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodeModelPackage.CREATE__IN:
				if (resolve) return getIn();
				return basicGetIn();
			case CodeModelPackage.CREATE__ENTITY:
				return getEntity();
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
			case CodeModelPackage.CREATE__IN:
				setIn((AbstractCodeElement)newValue);
				return;
			case CodeModelPackage.CREATE__ENTITY:
				setEntity((String)newValue);
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
			case CodeModelPackage.CREATE__IN:
				setIn((AbstractCodeElement)null);
				return;
			case CodeModelPackage.CREATE__ENTITY:
				setEntity(ENTITY_EDEFAULT);
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
			case CodeModelPackage.CREATE__IN:
				return in != null;
			case CodeModelPackage.CREATE__ENTITY:
				return ENTITY_EDEFAULT == null ? entity != null : !ENTITY_EDEFAULT.equals(entity);
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
		result.append(" (entity: ");
		result.append(entity);
		result.append(')');
		return result.toString();
	}

} //CreateImpl
