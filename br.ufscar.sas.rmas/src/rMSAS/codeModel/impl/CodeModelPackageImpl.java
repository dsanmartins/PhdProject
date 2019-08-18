/**
 */
package rMSAS.codeModel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionPackage;

import org.eclipse.gmt.modisco.omg.kdm.build.BuildPackage;

import org.eclipse.gmt.modisco.omg.kdm.code.CodePackage;

import org.eclipse.gmt.modisco.omg.kdm.conceptual.ConceptualPackage;

import org.eclipse.gmt.modisco.omg.kdm.core.CorePackage;

import org.eclipse.gmt.modisco.omg.kdm.data.DataPackage;

import org.eclipse.gmt.modisco.omg.kdm.event.EventPackage;

import org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage;

import org.eclipse.gmt.modisco.omg.kdm.platform.PlatformPackage;

import org.eclipse.gmt.modisco.omg.kdm.source.SourcePackage;

import org.eclipse.gmt.modisco.omg.kdm.structure.StructurePackage;

import org.eclipse.gmt.modisco.omg.kdm.ui.UiPackage;

import rMSAS.architecturalModel.ArchitecturalModelPackage;

import rMSAS.architecturalModel.impl.ArchitecturalModelPackageImpl;

import rMSAS.codeModel.AbstractCodeOperation;
import rMSAS.codeModel.CodeModelFactory;
import rMSAS.codeModel.CodeModelPackage;
import rMSAS.codeModel.Create;
import rMSAS.codeModel.Delete;
import rMSAS.codeModel.Move;

import rMSAS.constraintModel.ConstraintModelPackage;

import rMSAS.constraintModel.impl.ConstraintModelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodeModelPackageImpl extends EPackageImpl implements CodeModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractCodeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see rMSAS.codeModel.CodeModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CodeModelPackageImpl() {
		super(eNS_URI, CodeModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link CodeModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CodeModelPackage init() {
		if (isInited) return (CodeModelPackage)EPackage.Registry.INSTANCE.getEPackage(CodeModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCodeModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CodeModelPackageImpl theCodeModelPackage = registeredCodeModelPackage instanceof CodeModelPackageImpl ? (CodeModelPackageImpl)registeredCodeModelPackage : new CodeModelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		KdmPackage.eINSTANCE.eClass();
		SourcePackage.eINSTANCE.eClass();
		CodePackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		PlatformPackage.eINSTANCE.eClass();
		BuildPackage.eINSTANCE.eClass();
		ConceptualPackage.eINSTANCE.eClass();
		DataPackage.eINSTANCE.eClass();
		EventPackage.eINSTANCE.eClass();
		StructurePackage.eINSTANCE.eClass();
		UiPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ArchitecturalModelPackage.eNS_URI);
		ArchitecturalModelPackageImpl theArchitecturalModelPackage = (ArchitecturalModelPackageImpl)(registeredPackage instanceof ArchitecturalModelPackageImpl ? registeredPackage : ArchitecturalModelPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ConstraintModelPackage.eNS_URI);
		ConstraintModelPackageImpl theConstraintModelPackage = (ConstraintModelPackageImpl)(registeredPackage instanceof ConstraintModelPackageImpl ? registeredPackage : ConstraintModelPackage.eINSTANCE);

		// Create package meta-data objects
		theCodeModelPackage.createPackageContents();
		theArchitecturalModelPackage.createPackageContents();
		theConstraintModelPackage.createPackageContents();

		// Initialize created meta-data
		theCodeModelPackage.initializePackageContents();
		theArchitecturalModelPackage.initializePackageContents();
		theConstraintModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCodeModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CodeModelPackage.eNS_URI, theCodeModelPackage);
		return theCodeModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractCodeOperation() {
		return abstractCodeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractCodeOperation_Description() {
		return (EAttribute)abstractCodeOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractCodeOperation_Condition() {
		return (EReference)abstractCodeOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractCodeOperation_Entity() {
		return (EReference)abstractCodeOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMove() {
		return moveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMove_From() {
		return (EReference)moveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMove_To() {
		return (EReference)moveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCreate() {
		return createEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCreate_In() {
		return (EReference)createEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDelete() {
		return deleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDelete_From() {
		return (EReference)deleteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CodeModelFactory getCodeModelFactory() {
		return (CodeModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractCodeOperationEClass = createEClass(ABSTRACT_CODE_OPERATION);
		createEAttribute(abstractCodeOperationEClass, ABSTRACT_CODE_OPERATION__DESCRIPTION);
		createEReference(abstractCodeOperationEClass, ABSTRACT_CODE_OPERATION__CONDITION);
		createEReference(abstractCodeOperationEClass, ABSTRACT_CODE_OPERATION__ENTITY);

		moveEClass = createEClass(MOVE);
		createEReference(moveEClass, MOVE__FROM);
		createEReference(moveEClass, MOVE__TO);

		createEClass = createEClass(CREATE);
		createEReference(createEClass, CREATE__IN);

		deleteEClass = createEClass(DELETE);
		createEReference(deleteEClass, DELETE__FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ConstraintModelPackage theConstraintModelPackage = (ConstraintModelPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintModelPackage.eNS_URI);
		CodePackage theCodePackage = (CodePackage)EPackage.Registry.INSTANCE.getEPackage(CodePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		moveEClass.getESuperTypes().add(this.getAbstractCodeOperation());
		createEClass.getESuperTypes().add(this.getAbstractCodeOperation());
		deleteEClass.getESuperTypes().add(this.getAbstractCodeOperation());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractCodeOperationEClass, AbstractCodeOperation.class, "AbstractCodeOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractCodeOperation_Description(), ecorePackage.getEString(), "description", null, 0, 1, AbstractCodeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractCodeOperation_Condition(), theConstraintModelPackage.getAbstractCondition(), null, "condition", null, 0, 1, AbstractCodeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractCodeOperation_Entity(), theCodePackage.getAbstractCodeElement(), null, "entity", null, 1, 1, AbstractCodeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moveEClass, Move.class, "Move", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMove_From(), theCodePackage.getAbstractCodeElement(), null, "from", null, 1, 1, Move.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMove_To(), theCodePackage.getAbstractCodeElement(), null, "to", null, 1, 1, Move.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createEClass, Create.class, "Create", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreate_In(), theCodePackage.getAbstractCodeElement(), null, "in", null, 1, 1, Create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteEClass, Delete.class, "Delete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDelete_From(), theCodePackage.getAbstractCodeElement(), null, "from", null, 1, 1, Delete.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CodeModelPackageImpl
