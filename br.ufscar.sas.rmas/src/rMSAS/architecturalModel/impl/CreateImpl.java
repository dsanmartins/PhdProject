/**
 */
package rMSAS.architecturalModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;

import rMSAS.architecturalModel.ArchitecturalModelPackage;
import rMSAS.architecturalModel.Create;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.architecturalModel.impl.CreateImpl#getIn <em>In</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.impl.CreateImpl#getAbstraction <em>Abstraction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CreateImpl extends AbstractArchitecturalOperationImpl implements Create {
	/**
	 * The cached value of the '{@link #getIn() <em>In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIn()
	 * @generated
	 * @ordered
	 */
	protected AbstractStructureElement in;

	/**
	 * The default value of the '{@link #getAbstraction() <em>Abstraction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstraction()
	 * @generated
	 * @ordered
	 */
	protected static final String ABSTRACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAbstraction() <em>Abstraction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstraction()
	 * @generated
	 * @ordered
	 */
	protected String abstraction = ABSTRACTION_EDEFAULT;

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
		return ArchitecturalModelPackage.Literals.CREATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractStructureElement getIn() {
		if (in != null && in.eIsProxy()) {
			InternalEObject oldIn = (InternalEObject)in;
			in = (AbstractStructureElement)eResolveProxy(oldIn);
			if (in != oldIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturalModelPackage.CREATE__IN, oldIn, in));
			}
		}
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractStructureElement basicGetIn() {
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIn(AbstractStructureElement newIn) {
		AbstractStructureElement oldIn = in;
		in = newIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturalModelPackage.CREATE__IN, oldIn, in));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAbstraction() {
		return abstraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbstraction(String newAbstraction) {
		String oldAbstraction = abstraction;
		abstraction = newAbstraction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturalModelPackage.CREATE__ABSTRACTION, oldAbstraction, abstraction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchitecturalModelPackage.CREATE__IN:
				if (resolve) return getIn();
				return basicGetIn();
			case ArchitecturalModelPackage.CREATE__ABSTRACTION:
				return getAbstraction();
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
			case ArchitecturalModelPackage.CREATE__IN:
				setIn((AbstractStructureElement)newValue);
				return;
			case ArchitecturalModelPackage.CREATE__ABSTRACTION:
				setAbstraction((String)newValue);
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
			case ArchitecturalModelPackage.CREATE__IN:
				setIn((AbstractStructureElement)null);
				return;
			case ArchitecturalModelPackage.CREATE__ABSTRACTION:
				setAbstraction(ABSTRACTION_EDEFAULT);
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
			case ArchitecturalModelPackage.CREATE__IN:
				return in != null;
			case ArchitecturalModelPackage.CREATE__ABSTRACTION:
				return ABSTRACTION_EDEFAULT == null ? abstraction != null : !ABSTRACTION_EDEFAULT.equals(abstraction);
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
		result.append(" (abstraction: ");
		result.append(abstraction);
		result.append(')');
		return result.toString();
	}

} //CreateImpl
