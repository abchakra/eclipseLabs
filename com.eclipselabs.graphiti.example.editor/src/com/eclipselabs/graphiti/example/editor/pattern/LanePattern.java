package com.eclipselabs.graphiti.example.editor.pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import root.com.eclipselabs.graphiti.example.model.Lane;
import root.com.eclipselabs.graphiti.example.model.Pool;
import root.com.eclipselabs.graphiti.example.model.RootFactory;
import root.com.eclipselabs.graphiti.example.model.impl.LaneImpl;
import root.com.eclipselabs.graphiti.example.model.impl.PoolImpl;

public class LanePattern extends AbstractPattern implements IPattern {

	private static int PoolNameTab_Height = 30;

	@Override
	public String getCreateName() {
		return "Lane";
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof Lane;
	}

	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(domainObject);
	}

	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(domainObject);
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (!(context.getTargetContainer() instanceof Diagram)) {
			Object object = PoolLaneHelper.findBusinessObject(context.getTargetContainer());
			if (object instanceof Pool || object instanceof Lane) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canAdd(IAddContext context) {

		if (context.getNewObject() instanceof Lane && !(context.getTargetContainer() instanceof Diagram)) {
			Object object = PoolLaneHelper.findBusinessObject(context.getTargetContainer());
			if (object instanceof Pool || object instanceof Lane) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object[] create(ICreateContext context) {
		Object object = PoolLaneHelper.findBusinessObject(context.getTargetContainer());
		Lane lane = RootFactory.eINSTANCE.createLane();
		lane.setName(PoolLaneHelper.createNewName(getCreateName(), getDiagram()));
		if (object instanceof Pool) {
			((Pool) object).getLanes().add(lane);
		} else if (object instanceof Lane) {
			if (((Lane) object).eContainer() instanceof Pool) {
				((Pool) (((Lane) object).eContainer())).getLanes().add(lane);
			}
		}

		addGraphicalRepresentation(context, lane);
		return new Object[] { lane };
	}

	ContainerShape findContainer(ContainerShape containerShape, Class classname) {

		if (containerShape.getLink() != null) {

			EList<EObject> businessObjects = containerShape.getLink().getBusinessObjects();
			if (businessObjects.size() == 1 && businessObjects.get(0).getClass().equals(classname)) {
				businessObjects.get(0);
			}

			return containerShape;
		} else {
			for (Shape shape : containerShape.getChildren()) {
				if (shape instanceof ContainerShape) {
					return findContainer((ContainerShape) shape, classname);
				}
			}
		}

		return null;
	}

	@Override
	public PictogramElement add(IAddContext context) {

		ContainerShape targetContainer = null;
		targetContainer = findContainer(context.getTargetContainer(), PoolImpl.class);
		if (targetContainer == null) {
			targetContainer = findContainer(context.getTargetContainer(), LaneImpl.class);
		}
		Lane addedDomainObject = (Lane) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		// Outer container (invisible)
		ContainerShape outerContainerShape = null;
		if (targetContainer != null) {
			outerContainerShape = peCreateService.createContainerShape(targetContainer, true);

			Rectangle outerRectangle = gaService.createInvisibleRectangle(outerContainerShape);
			gaService.setLocationAndSize(outerRectangle, targetContainer.getGraphicsAlgorithm().getX(), targetContainer.getGraphicsAlgorithm().getY(), targetContainer.getGraphicsAlgorithm()
					.getWidth() - 1, targetContainer.getGraphicsAlgorithm().getHeight() - PoolNameTab_Height);

			// Register tab
			Rectangle registerRectangle = gaService.createRectangle(outerRectangle);
			gaService.setLocationAndSize(registerRectangle, 0, 0, outerRectangle.getWidth(), PoolNameTab_Height);
			registerRectangle.setFilled(true);
			gaService.setRenderingStyle(registerRectangle, PoolLanePredefinedColoredAreas.getCopperWhiteGlossAdaptions());

			// Folder name
			Shape shape = peCreateService.createShape(outerContainerShape, false);
			Text text = gaService.createText(shape, addedDomainObject.getName());
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			setLocationAndSizeOfTextArea(registerRectangle, text);

			// Main contents area
			ContainerShape innerContainerShape = peCreateService.createContainerShape(outerContainerShape, false);
			Rectangle mainRectangle = gaService.createRectangle(innerContainerShape);
			setLocationAndSizeOfMainContentsArea(outerRectangle, mainRectangle);
			mainRectangle.setFilled(true);
			gaService.setRenderingStyle(mainRectangle, PoolLanePredefinedColoredAreas.getCopperWhiteGlossAdaptions());

			peCreateService.createChopboxAnchor(outerContainerShape);

			link(innerContainerShape, addedDomainObject);
		}
		return outerContainerShape;
	}

	private void setLocationAndSizeOfMainContentsArea(Rectangle outerRectangle, Rectangle mainRectangle) {
		Graphiti.getGaService().setLocationAndSize(mainRectangle, 0, PoolNameTab_Height, outerRectangle.getWidth(), outerRectangle.getHeight() - PoolNameTab_Height);
	}

	private void setLocationAndSizeOfTextArea(Rectangle outerRectangle, Text text) {
		Graphiti.getGaService().setLocationAndSize(text, 2, 2, outerRectangle.getWidth(), outerRectangle.getHeight());
	}

}
