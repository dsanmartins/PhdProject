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

import rMSAS.architecturalModel.AbstractArchitecturalOperation;
import rMSAS.architecturalModel.ArchitecturalModelPackage;
import rMSAS.architecturalModel.ArchitecturalRefactoringModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architectural Refactoring Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link rMSAS.architecturalModel.impl.ArchitecturalRefactoringModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.impl.ArchitecturalRefactoringModelImpl#getSmell <em>Smell</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.impl.ArchitecturalRefactoringModelImpl#getEngine <em>Engine</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.impl.ArchitecturalRefactoringModelImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link rMSAS.architecturalModel.impl.ArchitecturalRefactoringModelImpl#getArchitecturalOperation <em>Architectural Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArchitecturalRefactoringModelImpl extends MinimalEObjectImpl.Container implements ArchitecturalRefactoringModel {
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
	 * The default value of the '{@link #getSmell() <em>Smell</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmell()
	 * @generated
	 * @ordered
	 */
	protected static final String SMELL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSmell() <em>Smell</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmell()
	 * @generated
	 * @ordered
	 */
	protected String smell = SMELL_EDEFAULT;

	/**
	 * The default value of the '{@link #getEngine() <em>Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngine()
	 * @generated
	 * @ordered
	 */
	protected static final String ENGINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEngine() <em>Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngine()
	 * @generated
	 * @ordered
	 */
	protected String engine = ENGINE_EDEFAULT;

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
	 * The cached value of the '{@link #getArchitecturalOperation() <em>Architectural Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecturalOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractArchitecturalOperation> architecturalOperation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitecturalRefactoringModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturalModelPackage.Literals.ARCHITECTURAL_REFACTORING_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSmell() {
		return smell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSmell(String newSmell) {
		String oldSmell = smell;
		smell = newSmell;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__SMELL, oldSmell, smell));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEngine() {
		return engine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEngine(String newEngine) {
		String oldEngine = engine;
		engine = newEngine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__ENGINE, oldEngine, engine));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractArchitecturalOperation> getArchitecturalOperation() {
		if (architecturalOperation == null) {
			architecturalOperation = new EObjectContainmentEList<AbstractArchitecturalOperation>(AbstractArchitecturalOperation.class, this, ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__ARCHITECTURAL_OPERATION);
		}
		return architecturalOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__ARCHITECTURAL_OPERATION:
				return ((InternalEList<?>)getArchitecturalOperation()).basicRemove(otherEnd, msgs);
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
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__NAME:
				return getName();
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__SMELL:
				return getSmell();
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__ENGINE:
				return getEngine();
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__DESCRIPTION:
				return getDescription();
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__ARCHITECTURAL_OPERATION:
				return getArchitecturalOperation();
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
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__NAME:
				setName((String)newValue);
				return;
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__SMELL:
				setSmell((String)newValue);
				return;
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__ENGINE:
				setEngine((String)newValue);
				return;
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__ARCHITECTURAL_OPERATION:
				getArchitecturalOperation().clear();
				getArchitecturalOperation().addAll((Collection<? extends AbstractArchitecturalOperation>)newValue);
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
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__SMELL:
				setSmell(SMELL_EDEFAULT);
				return;
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__ENGINE:
				setEngine(ENGINE_EDEFAULT);
				return;
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__ARCHITECTURAL_OPERATION:
				getArchitecturalOperation().clear();
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
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__SMELL:
				return SMELL_EDEFAULT == null ? smell != null : !SMELL_EDEFAULT.equals(smell);
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__ENGINE:
				return ENGINE_EDEFAULT == null ? engine != null : !ENGINE_EDEFAULT.equals(engine);
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL__ARCHITECTURAL_OPERATION:
				return architecturalOperation != null && !architecturalOperation.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", smell: ");
		result.append(smell);
		result.append(", engine: ");
		result.append(engine);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ArchitecturalRefactoringModelImpl
