/**
 */
package root.com.eclipselabs.graphiti.example.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lane</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link root.com.eclipselabs.graphiti.example.model.Lane#getTasks <em>Tasks</em>}</li>
 *   <li>{@link root.com.eclipselabs.graphiti.example.model.Lane#getStart <em>Start</em>}</li>
 *   <li>{@link root.com.eclipselabs.graphiti.example.model.Lane#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see root.com.eclipselabs.graphiti.example.model.RootPackage#getLane()
 * @model
 * @generated
 */
public interface Lane extends PObject {
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' reference list.
	 * The list contents are of type {@link root.com.eclipselabs.graphiti.example.model.Task}.
	 * It is bidirectional and its opposite is '{@link root.com.eclipselabs.graphiti.example.model.Task#getLane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' reference list.
	 * @see root.com.eclipselabs.graphiti.example.model.RootPackage#getLane_Tasks()
	 * @see root.com.eclipselabs.graphiti.example.model.Task#getLane
	 * @model opposite="lane"
	 * @generated
	 */
	EList<Task> getTasks();

	/**
	 * Returns the value of the '<em><b>Start</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link root.com.eclipselabs.graphiti.example.model.Start#getLane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' reference.
	 * @see #setStart(Start)
	 * @see root.com.eclipselabs.graphiti.example.model.RootPackage#getLane_Start()
	 * @see root.com.eclipselabs.graphiti.example.model.Start#getLane
	 * @model opposite="lane"
	 * @generated
	 */
	Start getStart();

	/**
	 * Sets the value of the '{@link root.com.eclipselabs.graphiti.example.model.Lane#getStart <em>Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Start value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link root.com.eclipselabs.graphiti.example.model.End#getLane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' reference.
	 * @see #setEnd(End)
	 * @see root.com.eclipselabs.graphiti.example.model.RootPackage#getLane_End()
	 * @see root.com.eclipselabs.graphiti.example.model.End#getLane
	 * @model opposite="lane"
	 * @generated
	 */
	End getEnd();

	/**
	 * Sets the value of the '{@link root.com.eclipselabs.graphiti.example.model.Lane#getEnd <em>End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' reference.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(End value);

} // Lane
