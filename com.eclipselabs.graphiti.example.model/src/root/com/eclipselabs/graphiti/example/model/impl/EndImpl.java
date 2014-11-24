/**
 */
package root.com.eclipselabs.graphiti.example.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import root.com.eclipselabs.graphiti.example.model.End;
import root.com.eclipselabs.graphiti.example.model.Lane;
import root.com.eclipselabs.graphiti.example.model.RootPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link root.com.eclipselabs.graphiti.example.model.impl.EndImpl#getLane <em>Lane</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EndImpl extends PObjectImpl implements End {
	/**
	 * The cached value of the '{@link #getLane() <em>Lane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLane()
	 * @generated
	 * @ordered
	 */
	protected Lane lane;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RootPackage.Literals.END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lane getLane() {
		if (lane != null && lane.eIsProxy()) {
			InternalEObject oldLane = (InternalEObject)lane;
			lane = (Lane)eResolveProxy(oldLane);
			if (lane != oldLane) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RootPackage.END__LANE, oldLane, lane));
			}
		}
		return lane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lane basicGetLane() {
		return lane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLane(Lane newLane, NotificationChain msgs) {
		Lane oldLane = lane;
		lane = newLane;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RootPackage.END__LANE, oldLane, newLane);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLane(Lane newLane) {
		if (newLane != lane) {
			NotificationChain msgs = null;
			if (lane != null)
				msgs = ((InternalEObject)lane).eInverseRemove(this, RootPackage.LANE__END, Lane.class, msgs);
			if (newLane != null)
				msgs = ((InternalEObject)newLane).eInverseAdd(this, RootPackage.LANE__END, Lane.class, msgs);
			msgs = basicSetLane(newLane, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RootPackage.END__LANE, newLane, newLane));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RootPackage.END__LANE:
				if (lane != null)
					msgs = ((InternalEObject)lane).eInverseRemove(this, RootPackage.LANE__END, Lane.class, msgs);
				return basicSetLane((Lane)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RootPackage.END__LANE:
				return basicSetLane(null, msgs);
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
			case RootPackage.END__LANE:
				if (resolve) return getLane();
				return basicGetLane();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RootPackage.END__LANE:
				setLane((Lane)newValue);
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
			case RootPackage.END__LANE:
				setLane((Lane)null);
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
			case RootPackage.END__LANE:
				return lane != null;
		}
		return super.eIsSet(featureID);
	}

} //EndImpl
