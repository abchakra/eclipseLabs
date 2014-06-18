package com.jointlogic.breadcrumbs.sampleapp.bcviewerapi;

import java.io.File;
import java.util.LinkedList;

public class FileUtil {
	// private construtor
	private FileUtil() {

	}

	public static Object[] getPathBreadCrumbs(Object object) {
		if (object instanceof File) {
			File path = (File) object;
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
