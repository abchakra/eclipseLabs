/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Pawel Piech (Wind River) - adapted breadcrumb for use in Debug view (Bug 252677)
 *     Jens Reimann (TH4 SYSTEMS GmbH) - extracted to standalone bundle
 *******************************************************************************/
package com.jointlogic.breadcrumbs.sampleapp.api;

import org.eclipse.osgi.util.NLS;

/**
 * Helper class to get NLSed messages.
 * 
 * @since 3.5
 */
public class BreadcrumbMessages extends NLS {

	private static final String BUNDLE_NAME = BreadcrumbMessages.class
			.getName();

	public static String Breadcrumb_ShowSingleRoot;

	public static String Breadcrumb_NoActiveContext;

	public static String BreadcrumbItemDropDown_showDropDownMenu_action_toolTip;
	public static String Breadcrumb_ShowIcons;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, BreadcrumbMessages.class);
	}

	private BreadcrumbMessages() {
	}
}
