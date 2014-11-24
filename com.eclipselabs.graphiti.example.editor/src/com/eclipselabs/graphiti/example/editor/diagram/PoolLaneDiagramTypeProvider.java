package com.eclipselabs.graphiti.example.editor.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class PoolLaneDiagramTypeProvider extends AbstractDiagramTypeProvider {
	private IToolBehaviorProvider[] toolBehaviorProviders;

	public PoolLaneDiagramTypeProvider() {
		super();
		setFeatureProvider(new PoolLaneFeatureProvider(this));
	}

	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[] { new PoolLaneToolBehaviorProvider(this) };
		}
		return toolBehaviorProviders;
	}
}
