/**
 */
package root.com.eclipselabs.graphiti.example.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link root.com.eclipselabs.graphiti.example.model.Pool#getLanes <em>Lanes</em>}</li>
 * </ul>
 * </p>
 *
 * @see root.com.eclipselabs.graphiti.example.model.RootPackage#getPool()
 * @model
 * @generated
 */
public interface Pool extends PObject {
	/**
	 * Returns the value of the '<em><b>Lanes</b></em>' containment reference list.
	 * The list contents are of type {@link root.com.eclipselabs.graphiti.example.model.Lane}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lanes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lanes</em>' containment reference list.
	 * @see root.com.eclipselabs.graphiti.example.model.RootPackage#getPool_Lanes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Lane> getLanes();

} // Pool
