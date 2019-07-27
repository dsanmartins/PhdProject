/**
 */
package rMSAS.architecturalModel.impl;

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

import rMSAS.architecturalModel.AbstractArchitecturalOperation;
import rMSAS.architecturalModel.ArchitecturalModelFactory;
import rMSAS.architecturalModel.ArchitecturalModelPackage;
import rMSAS.architecturalModel.ArchitecturalRefactoringModel;
import rMSAS.architecturalModel.Create;
import rMSAS.architecturalModel.Delete;
import rMSAS.architecturalModel.Move;

import rMSAS.codeModel.CodeModelPackage;

import rMSAS.codeModel.impl.CodeModelPackageImpl;

import rMSAS.constraintModel.ConstraintModelPackage;

import rMSAS.constraintModel.impl.ConstraintModelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchitecturalModelPackageImpl extends EPackageImpl implements ArchitecturalModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architecturalRefactoringModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractArchitecturalOperationEClass = null;

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
	 * @see rMSAS.architecturalModel.ArchitecturalModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ArchitecturalModelPackageImpl() {
		super(eNS_URI, ArchitecturalModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ArchitecturalModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ArchitecturalModelPackage init() {
		if (isInited) return (ArchitecturalModelPackage)EPackage.Registry.INSTANCE.getEPackage(ArchitecturalModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredArchitecturalModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ArchitecturalModelPackageImpl theArchitecturalModelPackage = registeredArchitecturalModelPackage instanceof ArchitecturalModelPackageImpl ? (ArchitecturalModelPackageImpl)registeredArchitecturalModelPackage : new ArchitecturalModelPackageImpl();

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
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CodeModelPackage.eNS_URI);
		CodeModelPackageImpl theCodeModelPackage = (CodeModelPackageImpl)(registeredPackage instanceof CodeModelPackageImpl ? registeredPackage : CodeModelPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ConstraintModelPackage.eNS_URI);
		ConstraintModelPackageImpl theConstraintModelPackage = (ConstraintModelPackageImpl)(registeredPackage instanceof ConstraintModelPackageImpl ? registeredPackage : ConstraintModelPackage.eINSTANCE);

		// Create package meta-data objects
		theArchitecturalModelPackage.createPackageContents();
		theCodeModelPackage.createPackageContents();
		theConstraintModelPackage.createPackageContents();

		// Initialize created meta-data
		theArchitecturalModelPackage.initializePackageContents();
		theCodeModelPackage.initializePackageContents();
		theConstraintModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theArchitecturalModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ArchitecturalModelPackage.eNS_URI, theArchitecturalModelPackage);
		return theArchitecturalModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArchitecturalRefactoringModel() {
		return architecturalRefactoringModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getArchitecturalRefactoringModel_Name() {
		return (EAttribute)architecturalRefactoringModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getArchitecturalRefactoringModel_Smell() {
		return (EAttribute)architecturalRefactoringModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getArchitecturalRefactoringModel_Engine() {
		return (EAttribute)architecturalRefactoringModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getArchitecturalRefactoringModel_Description() {
		return (EAttribute)architecturalRefactoringModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArchitecturalRefactoringModel_ArchitecturalOperation() {
		return (EReference)architecturalRefactoringModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractArchitecturalOperation() {
		return abstractArchitecturalOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractArchitecturalOperation_Description() {
		return (EAttribute)abstractArchitecturalOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractArchitecturalOperation_CodeOperation() {
		return (EReference)abstractArchitecturalOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractArchitecturalOperation_Condition() {
		return (EReference)abstractArchitecturalOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractArchitecturalOperation_Abstraction() {
		return (EReference)abstractArchitecturalOperationEClass.getEStructuralFeatures().get(3);
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
	public ArchitecturalModelFactory getArchitecturalModelFactory() {
		return (ArchitecturalModelFactory)getEFactoryInstance();
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
		architecturalRefactoringModelEClass = createEClass(ARCHITECTURAL_REFACTORING_MODEL);
		createEAttribute(architecturalRefactoringModelEClass, ARCHITECTURAL_REFACTORING_MODEL__NAME);
		createEAttribute(architecturalRefactoringModelEClass, ARCHITECTURAL_REFACTORING_MODEL__SMELL);
		createEAttribute(architecturalRefactoringModelEClass, ARCHITECTURAL_REFACTORING_MODEL__ENGINE);
		createEAttribute(architecturalRefactoringModelEClass, ARCHITECTURAL_REFACTORING_MODEL__DESCRIPTION);
		createEReference(architecturalRefactoringModelEClass, ARCHITECTURAL_REFACTORING_MODEL__ARCHITECTURAL_OPERATION);

		abstractArchitecturalOperationEClass = createEClass(ABSTRACT_ARCHITECTURAL_OPERATION);
		createEAttribute(abstractArchitecturalOperationEClass, ABSTRACT_ARCHITECTURAL_OPERATION__DESCRIPTION);
		createEReference(abstractArchitecturalOperationEClass, ABSTRACT_ARCHITECTURAL_OPERATION__CODE_OPERATION);
		createEReference(abstractArchitecturalOperationEClass, ABSTRACT_ARCHITECTURAL_OPERATION__CONDITION);
		createEReference(abstractArchitecturalOperationEClass, ABSTRACT_ARCHITECTURAL_OPERATION__ABSTRACTION);

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
		CodeModelPackage theCodeModelPackage = (CodeModelPackage)EPackage.Registry.INSTANCE.getEPackage(CodeModelPackage.eNS_URI);
		ConstraintModelPackage theConstraintModelPackage = (ConstraintModelPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintModelPackage.eNS_URI);
		StructurePackage theStructurePackage = (StructurePackage)EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		moveEClass.getESuperTypes().add(this.getAbstractArchitecturalOperation());
		createEClass.getESuperTypes().add(this.getAbstractArchitecturalOperation());
		deleteEClass.getESuperTypes().add(this.getAbstractArchitecturalOperation());

		// Initialize classes, features, and operations; add parameters
		initEClass(architecturalRefactoringModelEClass, ArchitecturalRefactoringModel.class, "ArchitecturalRefactoringModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchitecturalRefactoringModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, ArchitecturalRefactoringModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArchitecturalRefactoringModel_Smell(), ecorePackage.getEString(), "smell", null, 0, 1, ArchitecturalRefactoringModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArchitecturalRefactoringModel_Engine(), ecorePackage.getEString(), "engine", null, 0, 1, ArchitecturalRefactoringModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArchitecturalRefactoringModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, ArchitecturalRefactoringModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitecturalRefactoringModel_ArchitecturalOperation(), this.getAbstractArchitecturalOperation(), null, "architecturalOperation", null, 1, -1, ArchitecturalRefactoringModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractArchitecturalOperationEClass, AbstractArchitecturalOperation.class, "AbstractArchitecturalOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractArchitecturalOperation_Description(), ecorePackage.getEString(), "description", null, 0, 1, AbstractArchitecturalOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractArchitecturalOperation_CodeOperation(), theCodeModelPackage.getAbstractCodeOperation(), null, "codeOperation", null, 1, -1, AbstractArchitecturalOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractArchitecturalOperation_Condition(), theConstraintModelPackage.getAbstractCondition(), null, "condition", null, 0, 1, AbstractArchitecturalOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractArchitecturalOperation_Abstraction(), theStructurePackage.getAbstractStructureElement(), null, "abstraction", null, 1, 1, AbstractArchitecturalOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moveEClass, Move.class, "Move", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMove_From(), theStructurePackage.getAbstractStructureElement(), null, "from", null, 0, 1, Move.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMove_To(), theStructurePackage.getAbstractStructureElement(), null, "to", null, 0, 1, Move.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createEClass, Create.class, "Create", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreate_In(), theStructurePackage.getAbstractStructureElement(), null, "in", null, 0, 1, Create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteEClass, Delete.class, "Delete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDelete_From(), theStructurePackage.getAbstractStructureElement(), null, "from", null, 0, 1, Delete.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ArchitecturalModelPackageImpl
