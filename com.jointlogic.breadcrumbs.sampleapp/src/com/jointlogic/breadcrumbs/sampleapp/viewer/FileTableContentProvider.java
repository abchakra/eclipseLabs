package com.jointlogic.breadcrumbs.sampleapp.viewer;

import java.io.File;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class FileTableContentProvider implements IStructuredContentProvider {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof File[]) {

			File file = ((File[]) inputElement)[0];
			if (file.isDirectory()) {
				return file.listFiles();
			}
		}
		return (Object[]) inputElement;
	}

}
