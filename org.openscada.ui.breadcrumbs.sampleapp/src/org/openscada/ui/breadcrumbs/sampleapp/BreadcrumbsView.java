package org.openscada.ui.breadcrumbs.sampleapp;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreePathContentProvider;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.ViewPart;
import org.openscada.ui.breadcrumbs.BreadcrumbViewer;
import org.openscada.ui.breadcrumbs.IBreadcrumbDropDownSite;
import org.openscada.ui.breadcrumbs.sampleapp.provider.CustomTreeViewer;
import org.openscada.ui.breadcrumbs.sampleapp.provider.FileContentProvider;
import org.openscada.ui.breadcrumbs.sampleapp.provider.FileLabelProvider;

public class BreadcrumbsView extends ViewPart {
	public static final String ID = "org.openscada.ui.breadcrumbs.sampleapp.view";
	private CustomTreeViewer viewer;
	static final private Object fgEmptyDebugContextElement = new Object();

	public void createPartControl(final Composite parent) {

		parent.setLayout(new GridLayout(1, false));
		parent.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_BLUE));
		final BreadcrumbViewer breadcrumbViewer = new BreadcrumbViewer(parent,
				SWT.HORIZONTAL) {

			@Override
			protected Control createDropDown(Composite parent,
					IBreadcrumbDropDownSite site, TreePath path) {

				TreeViewer dropTree = new TreeViewer(parent, SWT.MULTI
						| SWT.H_SCROLL | SWT.V_SCROLL);

				dropTree.setContentProvider(new FileContentProvider());
				dropTree.setLabelProvider(new FileLabelProvider());

				if (path.getLastSegment() instanceof File) {
					File file = ((File) path.getLastSegment());
					dropTree.setInput(new File[] { file });

				}

				return dropTree.getControl();
			}
		};

		breadcrumbViewer
				.setContentProvider(new FileBreadcrumbContentProvider());
		breadcrumbViewer.setLabelProvider(new FileTreePathLabelProvider());

		viewer = new CustomTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
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
					breadcrumbViewer.setInput(new Input(((TreeSelection) event
							.getSelection()).getPaths()));

					parent.layout();
				}
			}
		});

		viewer.addOpenListener(new IOpenListener() {

			@Override
			public void open(OpenEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();

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
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private static class Input {
		final TreePath fPath;

		public Input(TreePath path) {
			fPath = path;
		}

		public Input(TreePath[] paths) {
			if (paths.length > 0) {
				fPath = paths[0];
			} else {
				fPath = null;
			}
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof Input
					&& ((fPath == null && ((Input) obj).fPath == null) || (fPath != null && fPath
							.equals(((Input) obj).fPath)));
		}

		@Override
		public int hashCode() {
			return fPath == null ? 0 : fPath.hashCode();
		}
	}

	private class FileTreePathLabelProvider extends BaseLabelProvider implements
			ITreePathLabelProvider {
		@Override
		public void updateLabel(ViewerLabel label, TreePath elementPath) {
			if (fgEmptyDebugContextElement.equals(elementPath.getLastSegment())) {
				label.setText("LaunchViewMessages.Breadcrumb_NoActiveContext");
				label.setImage(null);
			} else {
				ViewerLabel treeViewerLabel = viewer
						.getElementLabel(elementPath);
				if (treeViewerLabel == null) {
					label.setText("LaunchViewMessages.Breadcrumb_NoActiveContext");
					label.setImage(null);
				} else {
					label.setText(treeViewerLabel.getText());
					label.setTooltipText(treeViewerLabel.getText());
					label.setImage(treeViewerLabel.getImage());
					label.setFont(treeViewerLabel.getFont());
					label.setForeground(treeViewerLabel.getForeground());
					label.setBackground(treeViewerLabel.getBackground());

				}

				elementPath.getLastSegment().toString();
			}

		}

	}

	private static class FileBreadcrumbContentProvider implements
			ITreePathContentProvider {

		private static final Object[] EMPTY_ELEMENTS_ARRAY = new Object[0];

		public Input fInput;

		@Override
		public Object[] getChildren(TreePath parentPath) {
			if (hasChildren(parentPath)) {
				return new Object[] { fInput.fPath.getSegment(parentPath
						.getSegmentCount()) };
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
				return fInput != null;
			} else if (fInput != null
					&& fInput.fPath != null
					&& fInput.fPath.getSegmentCount() > parentPath
							.getSegmentCount()) {
				for (int i = 0; i < parentPath.getSegmentCount(); i++) {
					if (i >= fInput.fPath.getSegmentCount()) {
						return false;
					} else {
						Object parentElement = parentPath.getSegment(i);
						Object contextElement = fInput.fPath.getSegment(i);
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
			if (fInput != null && fInput.fPath != null) {
				return getChildren(TreePath.EMPTY);
			} else {
				return new Object[] { fgEmptyDebugContextElement };
			}
		}

		@Override
		public void dispose() {
			fInput = null;
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput instanceof Input) {
				fInput = ((Input) newInput);
			} else {
				fInput = null;
			}
		}

	}

}