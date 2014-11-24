/**
 */
package root.com.eclipselabs.graphiti.example.model.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import root.com.eclipselabs.graphiti.example.model.Lane;
import root.com.eclipselabs.graphiti.example.model.Pool;
import root.com.eclipselabs.graphiti.example.model.RootPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link root.com.eclipselabs.graphiti.example.model.impl.PoolImpl#getLanes <em>Lanes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PoolImpl extends PObjectImpl implements Pool {
	/**
	 * The cached value of the '{@link #getLanes() <em>Lanes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanes()
	 * @generated
	 * @ordered
	 */
	protected EList<Lane> lanes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PoolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RootPackage.Literals.POOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Lane> getLanes() {
		if (lanes == null) {
			lanes = new EObjectContainmentEList<Lane>(Lane.class, this, RootPackage.POOL__LANES);
		}
		return lanes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RootPackage.POOL__LANES:
				return ((InternalEList<?>)getLanes()).basicRemove(otherEnd, msgs);
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
			case RootPackage.POOL__LANES:
				return getLanes();
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
			case RootPackage.POOL__LANES:
				getLanes().clear();
				getLanes().addAll((Collection<? extends Lane>)newValue);
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
			case RootPackage.POOL__LANES:
				getLanes().clear();
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
			case RootPackage.POOL__LANES:
				return lanes != null && !lanes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PoolImpl
