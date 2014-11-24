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

import root.com.eclipselabs.graphiti.example.model.Pool;
import root.com.eclipselabs.graphiti.example.model.RootFactory;

public class PoolPattern extends AbstractPattern implements IPattern {

	@Override
	public String getCreateName() {
		return "Pool";
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof Pool;
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
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return context.getNewObject() instanceof Pool && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		Pool pool = RootFactory.eINSTANCE.createPool();

		pool.setName(PoolLaneHelper.createNewName(getCreateName(), getDiagram()));

		getDiagram().eResource().getContents().add(pool);
		addGraphicalRepresentation(context, pool);
		return new Object[] { pool };
	}

	@Override
	public PictogramElement add(IAddContext context) {
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		Pool addedDomainObject = (Pool) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		// Outer container (invisible)
		ContainerShape outerContainerShape = peCreateService.createContainerShape(targetDiagram, true);
		Rectangle outerRectangle = gaService.createInvisibleRectangle(outerContainerShape);
		gaService.setLocationAndSize(outerRectangle, context.getX(), context.getY(), context.getWidth(), context.getHeight());

		// Register tab
		Rectangle registerRectangle = gaService.createRectangle(outerRectangle);
		gaService.setLocationAndSize(registerRectangle, 0, 0, 100, 30);
		registerRectangle.setFilled(true);
		gaService.setRenderingStyle(registerRectangle, PoolLanePredefinedColoredAreas.getLightGrayAdaptions());

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
		gaService.setRenderingStyle(mainRectangle, PoolLanePredefinedColoredAreas.getLightGrayAdaptions());

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(innerContainerShape, addedDomainObject);

		return outerContainerShape;
	}

	private void setLocationAndSizeOfMainContentsArea(Rectangle outerRectangle, Rectangle mainRectangle) {
		Graphiti.getGaService().setLocationAndSize(mainRectangle, 0, 30, outerRectangle.getWidth(), outerRectangle.getHeight() - 30);
	}

	private void setLocationAndSizeOfTextArea(Rectangle outerRectangle, Text text) {
		Graphiti.getGaService().setLocationAndSize(text, 2, 2, outerRectangle.getWidth(), outerRectangle.getHeight());
	}

}
