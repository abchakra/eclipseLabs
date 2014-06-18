package com.jointlogic.breadcrumbs.sampleapp.bcviewerapi;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;

import com.jointlogic.breadcrumbs.sampleapp.viewer.CustomTreeViewer;
import com.jointlogic.breadcrumbs.sampleapp.viewer.FileContentProvider;
import com.jointlogic.breadcrumbs.sampleapp.viewer.FileLabelProvider;

public class BreadcrumbsView2 extends ViewPart {
	public static final String ID = "com.jointlogic.breadcrumbs.sampleapp.view";
	private CustomTreeViewer viewer;
	protected boolean ctrlPressed;

	public void createPartControl(final Composite parent) {

		parent.setLayout(new GridLayout(1, false));
		parent.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		final CBreadcrumbViewer breadcrumbViewer = new CBreadcrumbViewer(parent);
		final GridData layoutData = new GridData(SWT.FILL, SWT.TOP, true, false);
		layoutData.heightHint = 24;
		breadcrumbViewer.getControl().setLayoutData(layoutData);
		breadcrumbViewer.setLabelProvider(new FileLabelProvider());
		breadcrumbViewer.setContentProvider(new FileBreadCrumbContentProvider());
		breadcrumbViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {

					if (((IStructuredSelection) event.getSelection()).getFirstElement() instanceof File) {
						File file = (File) (((IStructuredSelection) event.getSelection()).getFirstElement());

						String fileName = file.getName();
						if (fileName == null || fileName.trim().isEmpty()) {
							fileName = file.getPath();
						}
						MessageDialog.openInformation(parent.getShell(), "Info", fileName + " is SELECTED in BreadcrumbViewer !");

					}
				}
			}
		});
		viewer = new CustomTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new FileContentProvider());
		viewer.setLabelProvider(new FileLabelProvider());
		viewer.setInput(File.listRoots());

		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		viewer.getControl().setLayoutData(gd);
		// parent.pack();

		viewer.getTree().addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {

				if (event.getSource() instanceof Tree) {

					TreeItem[] items = ((Tree) event.getSource()).getSelection();
					if (items.length > 0 && items[0] != null) {
						// breadcrumbViewer.setInput(items[0].getData());
					} else {
						if ((event.stateMask & SWT.CTRL) != 0) {
							breadcrumbViewer.setInput(null);
						}
					}
				}
				parent.layout();

			}

		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof TreeSelection) {

					TreeSelection selection = (TreeSelection) event.getSelection();
					Object input = selection.getFirstElement();
					if (input != null) {
						breadcrumbViewer.setInput(selection.getFirstElement());
					}
					parent.layout();
				}
			}
		});

		viewer.addOpenListener(new IOpenListener() {

			@Override
			public void open(OpenEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();

				File file = (File) selection.getFirstElement();
				if (file != null) {
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
			}
		});

		// select first item

		Tree tree = viewer.getTree();
		TreeItem[] treeItems = tree.getItems();

		IStructuredSelection sel = null;
		if (treeItems.length > 0) {
			// tree.select(treeItems[0]);
			// tree.setSelection(treeItems[0]);
			sel = new StructuredSelection((treeItems[0]).getData());

		}
		if (sel != null) {
			viewer.setSelection(sel, true);
		}

		// CheckBox
		final Button directionButton = new Button(parent, SWT.CHECK);
		directionButton.setBackground(parent.getBackground());
		directionButton.setText("Set direction to RTL");

		directionButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				breadcrumbViewer.setDirection(directionButton.getSelection());
			}
		});

	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}

}