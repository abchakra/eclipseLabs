/**
 */
package root.com.eclipselabs.graphiti.example.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import root.com.eclipselabs.graphiti.example.model.End;
import root.com.eclipselabs.graphiti.example.model.Lane;
import root.com.eclipselabs.graphiti.example.model.PObject;
import root.com.eclipselabs.graphiti.example.model.Pool;
import root.com.eclipselabs.graphiti.example.model.RootFactory;
import root.com.eclipselabs.graphiti.example.model.RootPackage;
import root.com.eclipselabs.graphiti.example.model.Start;
import root.com.eclipselabs.graphiti.example.model.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RootPackageImpl extends EPackageImpl implements RootPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass poolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass laneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pObjectEClass = null;

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
	 * @see root.com.eclipselabs.graphiti.example.model.RootPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RootPackageImpl() {
		super(eNS_URI, RootFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RootPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RootPackage init() {
		if (isInited) return (RootPackage)EPackage.Registry.INSTANCE.getEPackage(RootPackage.eNS_URI);

		// Obtain or create and register package
		RootPackageImpl theRootPackage = (RootPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RootPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RootPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theRootPackage.createPackageContents();

		// Initialize created meta-data
		theRootPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRootPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RootPackage.eNS_URI, theRootPackage);
		return theRootPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPool() {
		return poolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPool_Lanes() {
		return (EReference)poolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLane() {
		return laneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLane_Tasks() {
		return (EReference)laneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLane_Start() {
		return (EReference)laneEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLane_End() {
		return (EReference)laneEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStart() {
		return startEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStart_Lane() {
		return (EReference)startEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnd() {
		return endEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnd_Lane() {
		return (EReference)endEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTask() {
		return taskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_Lane() {
		return (EReference)taskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPObject() {
		return pObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPObject_Name() {
		return (EAttribute)pObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootFactory getRootFactory() {
		return (RootFactory)getEFactoryInstance();
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
		poolEClass = createEClass(POOL);
		createEReference(poolEClass, POOL__LANES);

		laneEClass = createEClass(LANE);
		createEReference(laneEClass, LANE__TASKS);
		createEReference(laneEClass, LANE__START);
		createEReference(laneEClass, LANE__END);

		startEClass = createEClass(START);
		createEReference(startEClass, START__LANE);

		endEClass = createEClass(END);
		createEReference(endEClass, END__LANE);

		taskEClass = createEClass(TASK);
		createEReference(taskEClass, TASK__LANE);

		pObjectEClass = createEClass(POBJECT);
		createEAttribute(pObjectEClass, POBJECT__NAME);
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
		poolEClass.getESuperTypes().add(this.getPObject());
		laneEClass.getESuperTypes().add(this.getPObject());
		startEClass.getESuperTypes().add(this.getPool());
		endEClass.getESuperTypes().add(this.getPObject());
		taskEClass.getESuperTypes().add(this.getPool());

		// Initialize classes, features, and operations; add parameters
		initEClass(poolEClass, Pool.class, "Pool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPool_Lanes(), this.getLane(), null, "lanes", null, 0, -1, Pool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(laneEClass, Lane.class, "Lane", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLane_Tasks(), this.getTask(), this.getTask_Lane(), "tasks", null, 0, -1, Lane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLane_Start(), this.getStart(), this.getStart_Lane(), "start", null, 0, 1, Lane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLane_End(), this.getEnd(), this.getEnd_Lane(), "end", null, 0, 1, Lane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(startEClass, Start.class, "Start", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStart_Lane(), this.getLane(), this.getLane_Start(), "lane", null, 0, 1, Start.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endEClass, End.class, "End", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnd_Lane(), this.getLane(), this.getLane_End(), "lane", null, 0, 1, End.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTask_Lane(), this.getLane(), this.getLane_Tasks(), "lane", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pObjectEClass, PObject.class, "PObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, PObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RootPackageImpl
