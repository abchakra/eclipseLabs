package com.eclipselabs.graphiti.example.editor.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;

import root.com.eclipselabs.graphiti.example.model.Pool;

import com.eclipselabs.graphiti.example.editor.features.PoolLayoutFeature;
import com.eclipselabs.graphiti.example.editor.pattern.LanePattern;
import com.eclipselabs.graphiti.example.editor.pattern.PoolPattern;

public class PoolLaneFeatureProvider extends DefaultFeatureProviderWithPatterns {

	public PoolLaneFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		addPattern(new PoolPattern());
		addPattern(new LanePattern());
	}

	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = findBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Pool) {
			return new PoolLayoutFeature(this);
		}
		return super.getLayoutFeature(context);

	}

	public Object findBusinessObjectForPictogramElement(PictogramElement pictogramElement) {
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo != null) {
			return bo;
		} else {
			if (pictogramElement instanceof ContainerShape) {
				if (((ContainerShape) pictogramElement).getChildren().size() > 0) {
					for (Shape shape : ((ContainerShape) pictogramElement).getChildren()) {
						if (shape instanceof ContainerShape) {
							return findBusinessObjectForPictogramElement(shape);
						}
					}
				}
			}
		}

		return null;

	}
}
