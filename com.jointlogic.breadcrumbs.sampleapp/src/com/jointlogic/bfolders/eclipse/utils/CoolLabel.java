/*
 * Copyright (c) 2011, JointLogic Ltd. All rights reserved.
 * JointLogic Ltd. PROPRIETARY/CONFIDENTIAL.
 * DO NOT DISTRIBUTE!
 */

package com.jointlogic.bfolders.eclipse.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;

public class CoolLabel extends CLabel {
	int m_shadowStyle;
	private final static String SHORTEN = "shorten";

	public CoolLabel(Composite parent) {
		super(parent, SWT.SHADOW_NONE);
		m_shadowStyle = SWT.SHADOW_NONE;
	}

	public void makeShadowIn() {
		m_shadowStyle &= ~SWT.SHADOW_NONE;
		m_shadowStyle &= ~SWT.SHADOW_OUT;
		m_shadowStyle |= SWT.SHADOW_IN;
		redraw();
	}

	public void makeShadowOut() {
		m_shadowStyle &= ~SWT.SHADOW_NONE;
		m_shadowStyle &= ~SWT.SHADOW_IN;
		m_shadowStyle |= SWT.SHADOW_OUT;
		redraw();
	}

	public void makeShadowNone() {
		m_shadowStyle |= SWT.SHADOW_NONE;
		m_shadowStyle &= ~SWT.SHADOW_IN;
		m_shadowStyle &= ~SWT.SHADOW_OUT;
		redraw();
	}

	/*
	 * We override that method so as to provide mechanism for dynamically
	 * changing the shadow style.
	 * 
	 * @see org.eclipse.swt.widgets.Widget#getStyle()
	 */
	public int getStyle() {
		int s = super.getStyle();

		// mask out the original bints for shadow
		s &= ~SWT.SHADOW_NONE;
		s &= ~SWT.SHADOW_IN;
		s &= ~SWT.SHADOW_OUT;

		// set out bits for shadow style
		return s | m_shadowStyle;
	}

	public void setShorten(boolean value) {
		setData(SHORTEN, value);
	}

	public boolean isShorten() {
		if (getData(SHORTEN) == null) {
			return true;
		}
		return (boolean) getData(SHORTEN);
	}

}