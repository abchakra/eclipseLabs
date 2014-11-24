/**
 */
package root.com.eclipselabs.graphiti.example.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link root.com.eclipselabs.graphiti.example.model.End#getLane <em>Lane</em>}</li>
 * </ul>
 * </p>
 *
 * @see root.com.eclipselabs.graphiti.example.model.RootPackage#getEnd()
 * @model
 * @generated
 */
public interface End extends PObject {
	/**
	 * Returns the value of the '<em><b>Lane</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link root.com.eclipselabs.graphiti.example.model.Lane#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lane</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane</em>' reference.
	 * @see #setLane(Lane)
	 * @see root.com.eclipselabs.graphiti.example.model.RootPackage#getEnd_Lane()
	 * @see root.com.eclipselabs.graphiti.example.model.Lane#getEnd
	 * @model opposite="end"
	 * @generated
	 */
	Lane getLane();

	/**
	 * Sets the value of the '{@link root.com.eclipselabs.graphiti.example.model.End#getLane <em>Lane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane</em>' reference.
	 * @see #getLane()
	 * @generated
	 */
	void setLane(Lane value);

} // End
