/**
 */
package root.com.eclipselabs.graphiti.example.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link root.com.eclipselabs.graphiti.example.model.Task#getLane <em>Lane</em>}</li>
 * </ul>
 * </p>
 *
 * @see root.com.eclipselabs.graphiti.example.model.RootPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends Pool {
	/**
	 * Returns the value of the '<em><b>Lane</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link root.com.eclipselabs.graphiti.example.model.Lane#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lane</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane</em>' reference.
	 * @see #setLane(Lane)
	 * @see root.com.eclipselabs.graphiti.example.model.RootPackage#getTask_Lane()
	 * @see root.com.eclipselabs.graphiti.example.model.Lane#getTasks
	 * @model opposite="tasks"
	 * @generated
	 */
	Lane getLane();

	/**
	 * Sets the value of the '{@link root.com.eclipselabs.graphiti.example.model.Task#getLane <em>Lane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane</em>' reference.
	 * @see #getLane()
	 * @generated
	 */
	void setLane(Lane value);

} // Task
