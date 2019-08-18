/**
 */
package rMSAS.constraintModel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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

import rMSAS.codeModel.CodeModelPackage;

import rMSAS.codeModel.impl.CodeModelPackageImpl;

import rMSAS.constraintModel.AbstractCondition;
import rMSAS.constraintModel.ConstraintModelFactory;
import rMSAS.constraintModel.ConstraintModelPackage;
import rMSAS.constraintModel.PostCondition;
import rMSAS.constraintModel.PreCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConstraintModelPackageImpl extends EPackageImpl implements ConstraintModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postConditionEClass = null;

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
	 * @see rMSAS.constraintModel.ConstraintModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConstraintModelPackageImpl() {
		super(eNS_URI, ConstraintModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ConstraintModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConstraintModelPackage init() {
		if (isInited) return (ConstraintModelPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredConstraintModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ConstraintModelPackageImpl theConstraintModelPackage = registeredConstraintModelPackage instanceof ConstraintModelPackageImpl ? (ConstraintModelPackageImpl)registeredConstraintModelPackage : new ConstraintModelPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CodeModelPackage.eNS_URI);
		CodeModelPackageImpl theCodeModelPackage = (CodeModelPackageImpl)(registeredPackage instanceof CodeModelPackageImpl ? registeredPackage : CodeModelPackage.eINSTANCE);

		// Create package meta-data objects
		theConstraintModelPackage.createPackageContents();
		theArchitecturalModelPackage.createPackageContents();
		theCodeModelPackage.createPackageContents();

		// Initialize created meta-data
		theConstraintModelPackage.initializePackageContents();
		theArchitecturalModelPackage.initializePackageContents();
		theCodeModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConstraintModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConstraintModelPackage.eNS_URI, theConstraintModelPackage);
		return theConstraintModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractCondition() {
		return abstractConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractCondition_OclQuery() {
		return (EAttribute)abstractConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPreCondition() {
		return preConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPostCondition() {
		return postConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstraintModelFactory getConstraintModelFactory() {
		return (ConstraintModelFactory)getEFactoryInstance();
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
		abstractConditionEClass = createEClass(ABSTRACT_CONDITION);
		createEAttribute(abstractConditionEClass, ABSTRACT_CONDITION__OCL_QUERY);

		preConditionEClass = createEClass(PRE_CONDITION);

		postConditionEClass = createEClass(POST_CONDITION);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		preConditionEClass.getESuperTypes().add(this.getAbstractCondition());
		postConditionEClass.getESuperTypes().add(this.getAbstractCondition());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractConditionEClass, AbstractCondition.class, "AbstractCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractCondition_OclQuery(), ecorePackage.getEString(), "oclQuery", null, 0, 1, AbstractCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preConditionEClass, PreCondition.class, "PreCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(postConditionEClass, PostCondition.class, "PostCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ConstraintModelPackageImpl
