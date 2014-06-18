package com.jointlogic.breadcrumbs.sampleapp.viewer;

import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

public class CustomTreeViewer extends TreeViewer {

	public CustomTreeViewer(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
	}

	public Widget findLastSegment(Object segment, TreePath path) {
		Widget[] items = super.findItems(segment);
		if (items.length == 1) {
			return items[0];
		}
		for (int i = 0; i < items.length; i++) {
			if (super.getTreePathFromItem((Item) items[i]).equals(path)) {
				return items[i];
			}
		}
		return null;
	}

	/**
	 * Returns the item for the element at the given tree path or
	 * <code>null</code> if none.
	 * 
	 * @param path
	 *            tree path
	 * @return item or <code>null</code>
	 */
	public Widget findItem(TreePath path) {
		if (path.getSegmentCount() == 0) {
			return super.getTree();
		}
		Widget[] items = super.findItems(path.getLastSegment());
		if (items.length == 1) {
			return items[0];
		}
		for (int i = 0; i < items.length; i++) {
			if (super.getTreePathFromItem((Item) items[i]).equals(path)) {
				return items[i];
			}
		}
		return null;
	}

	public ViewerLabel getElementLabel(TreePath path) {
		if (path.getSegmentCount() == 0) {
			return null;
		}

		TreeItem item = (TreeItem) findItem(path);

		if (item != null) {
			ViewerLabel label = new ViewerLabel(item.getText(), item.getImage());
			label.setFont(item.getFont());
			label.setBackground(item.getBackground());
			label.setForeground(item.getForeground());
			return label;
		}

		return null;
	}

}
