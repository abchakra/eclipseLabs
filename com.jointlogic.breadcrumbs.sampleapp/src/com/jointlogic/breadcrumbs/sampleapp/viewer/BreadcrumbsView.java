package com.jointlogic.breadcrumbs.sampleapp.viewer;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreePathContentProvider;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;

import com.jointlogic.breadcrumbs.sampleapp.api.BreadcrumbMessages;
import com.jointlogic.breadcrumbs.sampleapp.api.BreadcrumbViewer;
import com.jointlogic.breadcrumbs.sampleapp.api.IBreadcrumbDropDownSite;

public class BreadcrumbsView extends ViewPart {
	public static final String ID = "com.jointlogic.breadcrumbs.sampleapp.view";
	private CustomTreeViewer viewer;
	protected boolean showIcons = false;
	static final private Object fgEmptyDebugContextElement = new Object();

	public void createPartControl(final Composite parent) {

		parent.setLayout(new GridLayout(1, false));
		parent.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		final BreadcrumbViewer breadcrumbViewer = new BreadcrumbViewer(parent, SWT.HORIZONTAL) {

			@Override
			protected Control createDropDown(Composite parent, IBreadcrumbDropDownSite site, TreePath path) {

				TableViewer dropTable = new TableViewer(parent);

				dropTable.setContentProvider(new FileTableContentProvider());
				dropTable.setLabelProvider(new FileLabelProvider());
				if (path.getLastSegment() instanceof File) {
					File file = ((File) path.getLastSegment());
					dropTable.setInput(new File[] { file });

				}
				return dropTable.getControl();

			}

			@Override
			public boolean showLastItemArrow(Object object) {
				if (object instanceof File) {
					if (((File) object).isDirectory()) {
						return true;
					}
				}
				return false;
			}
		};

		breadcrumbViewer.setContentProvider(new FileBreadcrumbContentProvider());
		breadcrumbViewer.setLabelProvider(new FileTreePathLabelProvider());

		viewer = new CustomTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new FileContentProvider());
		viewer.setLabelProvider(new FileLabelProvider());
		viewer.setInput(File.listRoots());

		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		viewer.getControl().setLayoutData(gd);
		// parent.pack();
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// TODO Auto-generated method stub
				if (event.getSelection() instanceof TreeSelection) {
					TreeSelection selection = (TreeSelection) event.getSelection();

					breadcrumbViewer.setInput(selection.getFirstElement());

					parent.layout();
				}
			}
		});

		viewer.addOpenListener(new IOpenListener() {

			@Override
			public void open(OpenEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();

				File file = (File) selection.getFirstElement();
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					if (desktop.isSupported(Desktop.Action.OPEN)) {
						try {
							desktop.open(file);
						} catch (IOException e) {
							// DO NOTHING
						}
					}
				}
			}
		});

		// select first item

		Tree tree = viewer.getTree();
		TreeItem[] treeItems = tree.getItems();

		IStructuredSelection sel = null;
		if (treeItems.length > 0) {
			sel = new StructuredSelection((treeItems[0]).getData());

		}
		if (sel != null) {
			viewer.setSelection(sel, true);
		}

		final Button chkBtnShowIcons = new Button(parent, SWT.CHECK);
		chkBtnShowIcons.setText(BreadcrumbMessages.Breadcrumb_ShowIcons);
		chkBtnShowIcons.setBackground(parent.getBackground());
		chkBtnShowIcons.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showIcons = chkBtnShowIcons.getSelection();
			}
		});

		final Button chkBtnSingleRoot = new Button(parent, SWT.CHECK);
		chkBtnSingleRoot.setText(BreadcrumbMessages.Breadcrumb_ShowSingleRoot);
		chkBtnSingleRoot.setBackground(parent.getBackground());
		chkBtnSingleRoot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				viewer.setInput(new File[] { File.listRoots()[0] });
			}
		});

	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private class FileTreePathLabelProvider extends BaseLabelProvider implements ITreePathLabelProvider {
		@Override
		public void updateLabel(ViewerLabel label, TreePath elementPath) {
			if (fgEmptyDebugContextElement.equals(elementPath.getLastSegment())) {
				label.setText(BreadcrumbMessages.Breadcrumb_NoActiveContext);
				label.setImage(null);
			} else {
				ViewerLabel treeViewerLabel = viewer.getElementLabel(elementPath);
				if (treeViewerLabel == null) {
					label.setText(BreadcrumbMessages.Breadcrumb_NoActiveContext);
					label.setImage(null);
				} else {
					label.setText(treeViewerLabel.getText());
					label.setTooltipText(treeViewerLabel.getText());
					if (showIcons) {
						label.setImage(treeViewerLabel.getImage());
					}
					label.setFont(treeViewerLabel.getFont());
					label.setForeground(treeViewerLabel.getForeground());
					label.setBackground(treeViewerLabel.getBackground());

				}

				elementPath.getLastSegment().toString();
			}

		}

	}

	private static class FileBreadcrumbContentProvider implements ITreePathContentProvider {

		private static final Object[] EMPTY_ELEMENTS_ARRAY = new Object[0];

		public TreePath treePath;

		@Override
		public Object[] getChildren(TreePath parentPath) {
			if (hasChildren(parentPath)) {
				return new Object[] { treePath.getSegment(parentPath.getSegmentCount()) };
			}
			return EMPTY_ELEMENTS_ARRAY;
		}

		@Override
		public TreePath[] getParents(Object element) {
			// Not supported
			return new TreePath[] { TreePath.EMPTY };
		}

		@Override
		public boolean hasChildren(TreePath parentPath) {
			if (parentPath.getSegmentCount() == 0) {
				return treePath != null;
			} else if (treePath != null && treePath.getSegmentCount() > parentPath.getSegmentCount()) {
				for (int i = 0; i < parentPath.getSegmentCount(); i++) {
					if (i >= treePath.getSegmentCount()) {
						return false;
					} else {
						Object parentElement = parentPath.getSegment(i);
						Object contextElement = treePath.getSegment(i);
						if (!parentElement.equals(contextElement)) {
							return false;
						}
					}
				}
				return true;
			}
			return false;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (treePath != null) {
				return getChildren(TreePath.EMPTY);
			} else {
				return new Object[] { fgEmptyDebugContextElement };
			}
		}

		@Override
		public void dispose() {
			treePath = null;
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput instanceof File) {
				Object[] objectSegments = getPathStrings((File) newInput);

				treePath = new TreePath(objectSegments);
			} else {
				treePath = null;
			}
		}

		public Object[] getPathStrings(File path) {
			LinkedList<File> list = new LinkedList<File>();
			File p = path;
			while (p != null) {
				list.addFirst(p);
				p = p.getParentFile();
			}
			return list.toArray();
		}

	}

}