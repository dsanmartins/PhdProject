/**
 */
package rMSAS.architecturalModel.impl;

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

import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;

import rMSAS.architecturalModel.AbstractArchitecturalOperation;
import rMSAS.architecturalModel.ArchitecturalModelPackage;

import rMSAS.codeModel.AbstractCodeOperation;

import rMSAS.constraintModel.AbstractCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Architectural Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.architecturalModel.impl.AbstractArchitecturalOperationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.impl.AbstractArchitecturalOperationImpl#getCodeOperation <em>Code Operation</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.impl.AbstractArchitecturalOperationImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.impl.AbstractArchitecturalOperationImpl#getAbstraction <em>Abstraction</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractArchitecturalOperationImpl extends MinimalEObjectImpl.Container implements AbstractArchitecturalOperation {
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
	 * The cached value of the '{@link #getCodeOperation() <em>Code Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractCodeOperation> codeOperation;

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
	 * The cached value of the '{@link #getAbstraction() <em>Abstraction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstraction()
	 * @generated
	 * @ordered
	 */
	protected AbstractStructureElement abstraction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractArchitecturalOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturalModelPackage.Literals.ABSTRACT_ARCHITECTURAL_OPERATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractCodeOperation> getCodeOperation() {
		if (codeOperation == null) {
			codeOperation = new EObjectContainmentEList<AbstractCodeOperation>(AbstractCodeOperation.class, this, ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION);
		}
		return codeOperation;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION, oldCondition, condition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractStructureElement getAbstraction() {
		if (abstraction != null && abstraction.eIsProxy()) {
			InternalEObject oldAbstraction = (InternalEObject)abstraction;
			abstraction = (AbstractStructureElement)eResolveProxy(oldAbstraction);
			if (abstraction != oldAbstraction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION, oldAbstraction, abstraction));
			}
		}
		return abstraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractStructureElement basicGetAbstraction() {
		return abstraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbstraction(AbstractStructureElement newAbstraction) {
		AbstractStructureElement oldAbstraction = abstraction;
		abstraction = newAbstraction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION, oldAbstraction, abstraction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION:
				return ((InternalEList<?>)getCodeOperation()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__DESCRIPTION:
				return getDescription();
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION:
				return getCodeOperation();
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION:
				if (resolve) return getCondition();
				return basicGetCondition();
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION:
				if (resolve) return getAbstraction();
				return basicGetAbstraction();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION:
				getCodeOperation().clear();
				getCodeOperation().addAll((Collection<? extends AbstractCodeOperation>)newValue);
				return;
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION:
				setCondition((AbstractCondition)newValue);
				return;
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION:
				setAbstraction((AbstractStructureElement)newValue);
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
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION:
				getCodeOperation().clear();
				return;
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION:
				setCondition((AbstractCondition)null);
				return;
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION:
				setAbstraction((AbstractStructureElement)null);
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
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION:
				return codeOperation != null && !codeOperation.isEmpty();
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION:
				return condition != null;
			case ArchitecturalModelPackage.ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION:
				return abstraction != null;
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

} //AbstractArchitecturalOperationImpl
