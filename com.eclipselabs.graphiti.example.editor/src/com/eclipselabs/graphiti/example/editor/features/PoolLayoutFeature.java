package com.eclipselabs.graphiti.example.editor.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import root.com.eclipselabs.graphiti.example.model.Pool;

public class PoolLayoutFeature extends AbstractLayoutFeature {
	private static final int MIN_HEIGHT = 100;

	private static final int MIN_WIDTH = 100;

	public PoolLayoutFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canLayout(ILayoutContext context) {
		// return true, if pictogram element is linked to an EClass
		PictogramElement pe = context.getPictogramElement();
		if (!(pe instanceof ContainerShape))
			return false;

		Object object = findBusinessObject(pe);

		return object != null;
	}

	private Object findBusinessObject(PictogramElement pe) {
		if (pe instanceof ContainerShape) {

			for (Shape shape : ((ContainerShape) pe).getChildren()) {
				if (shape.getLink() != null) {
					EList<EObject> businessObjects = shape.getLink().getBusinessObjects();
					if (businessObjects.size() == 1 && businessObjects.get(0) instanceof Pool) {
						return businessObjects.get(0);
					}

				}
			}
		}
		return null;
	}

	@Override
	public boolean layout(ILayoutContext context) {
		boolean anythingChanged = false;
		ContainerShape containerShape = (ContainerShape) context.getPictogramElement();
		GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();

		// height
		if (containerGa.getHeight() < MIN_HEIGHT) {
			containerGa.setHeight(MIN_HEIGHT);
			anythingChanged = true;
		}

		// width
		if (containerGa.getWidth() < MIN_WIDTH) {
			containerGa.setWidth(MIN_WIDTH);
			anythingChanged = true;
		}
		int containerWidth = containerGa.getWidth();
		int containerHeight = containerGa.getHeight();

		anythingChanged = reSizeChildrens(anythingChanged, containerShape, containerWidth, containerHeight);
		return anythingChanged;
	}

	private boolean reSizeChildrens(boolean anythingChanged, ContainerShape containerShape, int containerWidth, int containerHeight) {
		for (Shape shape : containerShape.getChildren()) {
			if (shape instanceof ContainerShape) {
				anythingChanged= reSizeChildrens(anythingChanged, (ContainerShape) shape, containerWidth, containerHeight);
			}
			GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
			if (!(graphicsAlgorithm instanceof Text)) {

				IGaService gaService = Graphiti.getGaService();
				IDimension size = gaService.calculateSize(graphicsAlgorithm);
				if (containerWidth != size.getWidth() || containerHeight != size.getHeight()) {
					gaService.setWidth(graphicsAlgorithm, containerWidth);
					gaService.setHeight(graphicsAlgorithm, containerHeight - 10);
					anythingChanged = true;
				}
			}

		}
		return anythingChanged;
	}
}
