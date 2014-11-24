/**
 */
package root.com.eclipselabs.graphiti.example.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import root.com.eclipselabs.graphiti.example.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see root.com.eclipselabs.graphiti.example.model.RootPackage
 * @generated
 */
public class RootAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RootPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RootPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootSwitch<Adapter> modelSwitch =
		new RootSwitch<Adapter>() {
			@Override
			public Adapter casePool(Pool object) {
				return createPoolAdapter();
			}
			@Override
			public Adapter caseLane(Lane object) {
				return createLaneAdapter();
			}
			@Override
			public Adapter caseStart(Start object) {
				return createStartAdapter();
			}
			@Override
			public Adapter caseEnd(End object) {
				return createEndAdapter();
			}
			@Override
			public Adapter caseTask(Task object) {
				return createTaskAdapter();
			}
			@Override
			public Adapter casePObject(PObject object) {
				return createPObjectAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link root.com.eclipselabs.graphiti.example.model.Pool <em>Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see root.com.eclipselabs.graphiti.example.model.Pool
	 * @generated
	 */
	public Adapter createPoolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link root.com.eclipselabs.graphiti.example.model.Lane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see root.com.eclipselabs.graphiti.example.model.Lane
	 * @generated
	 */
	public Adapter createLaneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link root.com.eclipselabs.graphiti.example.model.Start <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see root.com.eclipselabs.graphiti.example.model.Start
	 * @generated
	 */
	public Adapter createStartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link root.com.eclipselabs.graphiti.example.model.End <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see root.com.eclipselabs.graphiti.example.model.End
	 * @generated
	 */
	public Adapter createEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link root.com.eclipselabs.graphiti.example.model.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see root.com.eclipselabs.graphiti.example.model.Task
	 * @generated
	 */
	public Adapter createTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link root.com.eclipselabs.graphiti.example.model.PObject <em>PObject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see root.com.eclipselabs.graphiti.example.model.PObject
	 * @generated
	 */
	public Adapter createPObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RootAdapterFactory
