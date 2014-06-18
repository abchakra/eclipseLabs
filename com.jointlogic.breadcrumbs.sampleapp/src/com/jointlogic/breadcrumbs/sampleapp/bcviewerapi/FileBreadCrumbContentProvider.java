package com.jointlogic.breadcrumbs.sampleapp.bcviewerapi;

import java.io.File;
import java.util.LinkedList;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class FileBreadCrumbContentProvider implements IStructuredContentProvider {

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
		if (inputElement instanceof File) {
			File path = (File) inputElement;
			LinkedList<File> list = new LinkedList<File>();
			File p = path;
			while (p != null) {
				list.addFirst(p);
				p = p.getParentFile();
			}
			return list.toArray();
		}
		return new Object[] {};
	}
}
