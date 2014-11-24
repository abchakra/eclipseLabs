/**
 */
package root.com.eclipselabs.graphiti.example.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see root.com.eclipselabs.graphiti.example.model.RootFactory
 * @model kind="package"
 * @generated
 */
public interface RootPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "root";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/root";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "root";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RootPackage eINSTANCE = root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl.init();

	/**
	 * The meta object id for the '{@link root.com.eclipselabs.graphiti.example.model.impl.PObjectImpl <em>PObject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see root.com.eclipselabs.graphiti.example.model.impl.PObjectImpl
	 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getPObject()
	 * @generated
	 */
	int POBJECT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POBJECT__NAME = 0;

	/**
	 * The number of structural features of the '<em>PObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POBJECT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>PObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link root.com.eclipselabs.graphiti.example.model.impl.PoolImpl <em>Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see root.com.eclipselabs.graphiti.example.model.impl.PoolImpl
	 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getPool()
	 * @generated
	 */
	int POOL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__NAME = POBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__LANES = POBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL_FEATURE_COUNT = POBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL_OPERATION_COUNT = POBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link root.com.eclipselabs.graphiti.example.model.impl.LaneImpl <em>Lane</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see root.com.eclipselabs.graphiti.example.model.impl.LaneImpl
	 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getLane()
	 * @generated
	 */
	int LANE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__NAME = POBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__TASKS = POBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__START = POBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__END = POBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Lane</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_FEATURE_COUNT = POBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Lane</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_OPERATION_COUNT = POBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link root.com.eclipselabs.graphiti.example.model.impl.StartImpl <em>Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see root.com.eclipselabs.graphiti.example.model.impl.StartImpl
	 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getStart()
	 * @generated
	 */
	int START = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__NAME = POOL__NAME;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__LANES = POOL__LANES;

	/**
	 * The feature id for the '<em><b>Lane</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__LANE = POOL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_FEATURE_COUNT = POOL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_OPERATION_COUNT = POOL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link root.com.eclipselabs.graphiti.example.model.impl.EndImpl <em>End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see root.com.eclipselabs.graphiti.example.model.impl.EndImpl
	 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getEnd()
	 * @generated
	 */
	int END = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__NAME = POBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Lane</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__LANE = POBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_FEATURE_COUNT = POBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_OPERATION_COUNT = POBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link root.com.eclipselabs.graphiti.example.model.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see root.com.eclipselabs.graphiti.example.model.impl.TaskImpl
	 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = POOL__NAME;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__LANES = POOL__LANES;

	/**
	 * The feature id for the '<em><b>Lane</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__LANE = POOL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = POOL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_OPERATION_COUNT = POOL_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link root.com.eclipselabs.graphiti.example.model.Pool <em>Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pool</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.Pool
	 * @generated
	 */
	EClass getPool();

	/**
	 * Returns the meta object for the containment reference list '{@link root.com.eclipselabs.graphiti.example.model.Pool#getLanes <em>Lanes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lanes</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.Pool#getLanes()
	 * @see #getPool()
	 * @generated
	 */
	EReference getPool_Lanes();

	/**
	 * Returns the meta object for class '{@link root.com.eclipselabs.graphiti.example.model.Lane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lane</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.Lane
	 * @generated
	 */
	EClass getLane();

	/**
	 * Returns the meta object for the reference list '{@link root.com.eclipselabs.graphiti.example.model.Lane#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tasks</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.Lane#getTasks()
	 * @see #getLane()
	 * @generated
	 */
	EReference getLane_Tasks();

	/**
	 * Returns the meta object for the reference '{@link root.com.eclipselabs.graphiti.example.model.Lane#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.Lane#getStart()
	 * @see #getLane()
	 * @generated
	 */
	EReference getLane_Start();

	/**
	 * Returns the meta object for the reference '{@link root.com.eclipselabs.graphiti.example.model.Lane#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.Lane#getEnd()
	 * @see #getLane()
	 * @generated
	 */
	EReference getLane_End();

	/**
	 * Returns the meta object for class '{@link root.com.eclipselabs.graphiti.example.model.Start <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.Start
	 * @generated
	 */
	EClass getStart();

	/**
	 * Returns the meta object for the reference '{@link root.com.eclipselabs.graphiti.example.model.Start#getLane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lane</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.Start#getLane()
	 * @see #getStart()
	 * @generated
	 */
	EReference getStart_Lane();

	/**
	 * Returns the meta object for class '{@link root.com.eclipselabs.graphiti.example.model.End <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.End
	 * @generated
	 */
	EClass getEnd();

	/**
	 * Returns the meta object for the reference '{@link root.com.eclipselabs.graphiti.example.model.End#getLane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lane</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.End#getLane()
	 * @see #getEnd()
	 * @generated
	 */
	EReference getEnd_Lane();

	/**
	 * Returns the meta object for class '{@link root.com.eclipselabs.graphiti.example.model.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the reference '{@link root.com.eclipselabs.graphiti.example.model.Task#getLane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lane</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.Task#getLane()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Lane();

	/**
	 * Returns the meta object for class '{@link root.com.eclipselabs.graphiti.example.model.PObject <em>PObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PObject</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.PObject
	 * @generated
	 */
	EClass getPObject();

	/**
	 * Returns the meta object for the attribute '{@link root.com.eclipselabs.graphiti.example.model.PObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see root.com.eclipselabs.graphiti.example.model.PObject#getName()
	 * @see #getPObject()
	 * @generated
	 */
	EAttribute getPObject_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RootFactory getRootFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link root.com.eclipselabs.graphiti.example.model.impl.PoolImpl <em>Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see root.com.eclipselabs.graphiti.example.model.impl.PoolImpl
		 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getPool()
		 * @generated
		 */
		EClass POOL = eINSTANCE.getPool();

		/**
		 * The meta object literal for the '<em><b>Lanes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POOL__LANES = eINSTANCE.getPool_Lanes();

		/**
		 * The meta object literal for the '{@link root.com.eclipselabs.graphiti.example.model.impl.LaneImpl <em>Lane</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see root.com.eclipselabs.graphiti.example.model.impl.LaneImpl
		 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getLane()
		 * @generated
		 */
		EClass LANE = eINSTANCE.getLane();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANE__TASKS = eINSTANCE.getLane_Tasks();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANE__START = eINSTANCE.getLane_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANE__END = eINSTANCE.getLane_End();

		/**
		 * The meta object literal for the '{@link root.com.eclipselabs.graphiti.example.model.impl.StartImpl <em>Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see root.com.eclipselabs.graphiti.example.model.impl.StartImpl
		 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getStart()
		 * @generated
		 */
		EClass START = eINSTANCE.getStart();

		/**
		 * The meta object literal for the '<em><b>Lane</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference START__LANE = eINSTANCE.getStart_Lane();

		/**
		 * The meta object literal for the '{@link root.com.eclipselabs.graphiti.example.model.impl.EndImpl <em>End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see root.com.eclipselabs.graphiti.example.model.impl.EndImpl
		 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getEnd()
		 * @generated
		 */
		EClass END = eINSTANCE.getEnd();

		/**
		 * The meta object literal for the '<em><b>Lane</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END__LANE = eINSTANCE.getEnd_Lane();

		/**
		 * The meta object literal for the '{@link root.com.eclipselabs.graphiti.example.model.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see root.com.eclipselabs.graphiti.example.model.impl.TaskImpl
		 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>Lane</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__LANE = eINSTANCE.getTask_Lane();

		/**
		 * The meta object literal for the '{@link root.com.eclipselabs.graphiti.example.model.impl.PObjectImpl <em>PObject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see root.com.eclipselabs.graphiti.example.model.impl.PObjectImpl
		 * @see root.com.eclipselabs.graphiti.example.model.impl.RootPackageImpl#getPObject()
		 * @generated
		 */
		EClass POBJECT = eINSTANCE.getPObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POBJECT__NAME = eINSTANCE.getPObject_Name();

	}

} //RootPackage
