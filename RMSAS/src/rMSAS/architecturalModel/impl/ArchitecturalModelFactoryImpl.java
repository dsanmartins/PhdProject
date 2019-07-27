/**
 */
package rMSAS.architecturalModel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import rMSAS.architecturalModel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchitecturalModelFactoryImpl extends EFactoryImpl implements ArchitecturalModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ArchitecturalModelFactory init() {
		try {
			ArchitecturalModelFactory theArchitecturalModelFactory = (ArchitecturalModelFactory)EPackage.Registry.INSTANCE.getEFactory(ArchitecturalModelPackage.eNS_URI);
			if (theArchitecturalModelFactory != null) {
				return theArchitecturalModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ArchitecturalModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitecturalModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ArchitecturalModelPackage.ARCHITECTURAL_REFACTORING_MODEL: return createArchitecturalRefactoringModel();
			case ArchitecturalModelPackage.MOVE: return createMove();
			case ArchitecturalModelPackage.CREATE: return createCreate();
			case ArchitecturalModelPackage.DELETE: return createDelete();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArchitecturalRefactoringModel createArchitecturalRefactoringModel() {
		ArchitecturalRefactoringModelImpl architecturalRefactoringModel = new ArchitecturalRefactoringModelImpl();
		return architecturalRefactoringModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Move createMove() {
		MoveImpl move = new MoveImpl();
		return move;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Create createCreate() {
		CreateImpl create = new CreateImpl();
		return create;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Delete createDelete() {
		DeleteImpl delete = new DeleteImpl();
		return delete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArchitecturalModelPackage getArchitecturalModelPackage() {
		return (ArchitecturalModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ArchitecturalModelPackage getPackage() {
		return ArchitecturalModelPackage.eINSTANCE;
	}

} //ArchitecturalModelFactoryImpl
