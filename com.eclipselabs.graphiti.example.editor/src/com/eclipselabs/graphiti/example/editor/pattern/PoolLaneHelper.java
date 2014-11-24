package com.eclipselabs.graphiti.example.editor.pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import root.com.eclipselabs.graphiti.example.model.Lane;
import root.com.eclipselabs.graphiti.example.model.PObject;
import root.com.eclipselabs.graphiti.example.model.Pool;

public class PoolLaneHelper {

	private PoolLaneHelper() {

	}

	public static Object findBusinessObject(PictogramElement pe) {
		if (pe instanceof ContainerShape) {

			for (Shape shape : ((ContainerShape) pe).getChildren()) {
				if (shape.getLink() != null) {
					EList<EObject> businessObjects = shape.getLink().getBusinessObjects();
					if (businessObjects.size() == 1 && businessObjects.get(0) instanceof Pool) {
						return businessObjects.get(0);
					} else if (businessObjects.size() == 1 && businessObjects.get(0) instanceof Lane) {
						return businessObjects.get(0);
					}

				}
			}
		}
		return null;
	}

	public static String createNewName(String initialName, Diagram diagram) {
		// String initialName = "Pool";
		String name = initialName;
		int number = 0;
		while (findObject(name, diagram) != null) {
			number++;
			name = initialName + number;
		}
		return name;
	}

	public static EObject findObject(String name, Diagram diagram) {
		EList<EObject> contents = diagram.eResource().getContents();
		for (EObject eObject : contents) {
			if (eObject instanceof PObject) {
				if (name.equals(((PObject) eObject).getName())) {
					return eObject;
				}
			}
		}
		return null;
	}
}
