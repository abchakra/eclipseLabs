package com.jointlogic.breadcrumbs.sampleapp.bcviewerapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;

import com.jointlogic.bfolders.eclipse.utils.CoolLabel;

public class CBreadcrumbViewer extends ContentViewer {
	private static final boolean IS_GTK = "gtk".equals(SWT.getPlatform()); //$NON-NLS-1$
	private final Composite mContainer;
	private final List<CoolLabel> mBreadcrumbs;
	private final ArrayList<CoolLabel> arrowList;
	private HashMap<Object, CoolLabel> mappedELements = new HashMap<Object, CoolLabel>();;
	private Image arrowImage = null;
	private Image arrowImageRTL = null;
	private boolean RTL = false;

	public CBreadcrumbViewer(final Composite parent) {
		this.mContainer = new Composite(parent, SWT.NONE);
		this.arrowImage = new ArrowImage(true).createImage();
		this.arrowImageRTL = new ArrowImage(false).createImage();
		this.mBreadcrumbs = new ArrayList<CoolLabel>();
		this.arrowList = new ArrayList<CoolLabel>();
//		final GridData layoutData = new GridData(SWT.FILL, SWT.TOP, true, false);
//		layoutData.heightHint=24;
//		this.mContainer.setLayoutData(layoutData);
		int columns = 1000;
		final GridLayout gridLayout = new GridLayout(columns, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		this.mContainer.setLayout(gridLayout);
		this.mContainer.setBackground(parent.getBackground());
		this.mContainer.addListener(SWT.Resize, new Listener() {
			@Override
			public void handleEvent(final Event event) {
				updateSize();
				mContainer.layout(true, true);
			}
		});
		hookControl(mContainer);
	}

	@Override
	public Control getControl() {
		return this.mContainer;
	}

	@Override
	protected void inputChanged(final Object input, Object oldInput) {
		if (input != null) {
			if (mappedELements != null && mappedELements.size() > 0) {
				mappedELements = new HashMap<Object, CoolLabel>();
			}

			if (this.mContainer.isDisposed()) {
				return;
			}

			disableRedraw();
			try {
				new Runnable() {
					@Override
					public void run() {
						createBreadcrumbChain(input);
						updateSize();
						mContainer.layout(true, true);
					}

				}.run();
			} finally {
				enableRedraw();
			}
		} else {
			int index = 0;
			while (index < this.mBreadcrumbs.size()) {
				final CoolLabel item = (CoolLabel) this.mBreadcrumbs.remove(this.mBreadcrumbs.size() - 1);

				item.dispose();
				if (this.arrowList.size() > 0) {
					final CoolLabel arrow = (CoolLabel) this.arrowList.remove(this.arrowList.size() - 1);
					// arrow.getImage().dispose();
					arrow.dispose();
				}
			}
		}
	}

	private void enableRedraw() {
		if (IS_GTK) {
			return;
		}

		this.mContainer.setRedraw(true);
	}

	private void disableRedraw() {
		if (IS_GTK) {
			return;
		}

		this.mContainer.setRedraw(false);
	}

	private void createBreadcrumbChain(Object input) {
		int index = 0;
		boolean updateLayout = false;
		final IStructuredContentProvider contentProvider = (IStructuredContentProvider) getContentProvider();
		if (input != null) {

			// Top level elements need to be retrieved using getElements(), rest
			// using getChildren()

			Object[] parents = contentProvider.getElements(input);

			for (Object object : parents) {
				CoolLabel item;
				if (this.mBreadcrumbs.size() > index) {
					item = (CoolLabel) this.mBreadcrumbs.get(index);
					if (item.getData() != null) {
						mappedELements.remove(item.getData());
					}
				} else {
					CoolLabel arrowLabel = null;
					// No Leading Arrow
					if (index > 0) {
						arrowLabel = new CoolLabel(mContainer);
						arrowLabel.setBackground(mContainer.getBackground());
						if (RTL) {
							arrowLabel.setImage(arrowImageRTL);
						} else {
							arrowLabel.setImage(arrowImage);
						}
					}
					item = new CoolLabel(this.mContainer);
					item.setBackground(mContainer.getBackground());
					item.setCursor(item.getDisplay().getSystemCursor(SWT.CURSOR_HAND));
					item.setLayoutData(new GridData(GridData.BEGINNING));
					item.addMouseListener(new CoolLabelSelectionListener());
					item.addMouseTrackListener(new MouseTrackAdapter() {

						@Override
						public void mouseEnter(MouseEvent e) {
							if (e.getSource() instanceof CoolLabel) {
								CoolLabel label = ((CoolLabel) e.getSource());
								label.makeShadowOut();
							}
						}

						@Override
						public void mouseExit(MouseEvent e) {
							if (e.getSource() instanceof CoolLabel) {
								CoolLabel label = ((CoolLabel) e.getSource());
								label.makeShadowNone();
							}
						}
					});
					this.mBreadcrumbs.add(item);
					if (arrowLabel != null) {
						this.arrowList.add(arrowLabel);
					}
				}

				updateLayout = false;
				if (equals(object, item.getData())) {
					updateLayout = myDoUpdateItem(item, object, false);
				} else {
					item.setData(object);
					mappedELements.put(object, item);
					updateLayout = refreshItem(item);
				}
				index++;
			}

		}

		while (index < this.mBreadcrumbs.size()) {
			updateLayout = true;
			final CoolLabel item = (CoolLabel) this.mBreadcrumbs.remove(this.mBreadcrumbs.size() - 1);

			item.dispose();
			if (this.arrowList.size() > 0) {
				final CoolLabel arrow = (CoolLabel) this.arrowList.remove(this.arrowList.size() - 1);
				// arrow.getImage().dispose();
				arrow.dispose();
			}
		}

		if (updateLayout) {
			this.mContainer.layout(true, true);
		}
	}

	private class CoolLabelSelectionListener implements MouseListener {

		@Override
		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDown(MouseEvent e) {

			if (e.getSource() instanceof CoolLabel) {
				CoolLabel label = ((CoolLabel) e.getSource());
				label.makeShadowIn();
			}
		}

		@Override
		public void mouseUp(MouseEvent e) {
			if (e.getSource() instanceof CoolLabel) {

				CoolLabel label = ((CoolLabel) e.getSource());
				label.makeShadowOut();
				selectBreadCrumbItem(label);

				label.makeShadowNone();
			}
		}
	}

	private void selectBreadCrumbItem(final CoolLabel cLabel) {
		fireSelectionChanged(new SelectionChangedEvent(this, new IStructuredSelection() {

			@Override
			public boolean isEmpty() {
				if (cLabel != null) {
					return true;
				}
				return false;
			}

			@Override
			public List toList() {
				return null;
			}

			@Override
			public Object[] toArray() {
				return null;
			}

			@Override
			public int size() {
				return 0;
			}

			@Override
			public Iterator iterator() {
				return null;
			}

			@Override
			public Object getFirstElement() {
				return cLabel.getData();
			}
		}));
	}

	protected boolean equals(Object elementA, Object elementB) {
		return elementA == null ? elementB == null : elementA.equals(elementB);
	}

	private boolean myDoUpdateItem(final Widget widget, final Object element, final boolean fullMap) {
		if (widget instanceof CoolLabel) {
			final CoolLabel item = (CoolLabel) widget;

			// remember element we are showing
			if (fullMap) {
				// associate(element, item);
			} else {
				final Object data = item.getData();
				if (data != null) {
					mappedELements.remove(data);
				}
				item.setData(element);
				mappedELements.put(element, item);
			}

			refreshItem(item);
		}
		return false;
	}

	/**
	 * @param item
	 *            Item to refresh.
	 * @return returns whether the item's size and layout needs to be updated.
	 */
	private boolean refreshItem(final CoolLabel item) {
		boolean layoutChanged = false;
		LabelProvider labelProvider = (LabelProvider) getLabelProvider();
		String text = labelProvider.getText(item.getData());
		Image image = labelProvider.getImage(item.getData());

		if (!text.equals(item.getText())) {
			item.setText(text);
			layoutChanged = true;
		}
		if (!image.equals(item.getImage())) {
			item.setImage(image);
			layoutChanged = true;
		}
		return layoutChanged;
	}

	@Override
	public ISelection getSelection() {
		// TODO Auto-generated method stub
		System.out.println();
		return null;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		System.out.println();
	}

	@Override
	public void setSelection(ISelection selection, boolean reveal) {
		// TODO Auto-generated method stub
		System.out.println();
	}

	private void setVisible(CoolLabel label, boolean visible) {
		final GridData data = (GridData) label.getLayoutData();
		label.setShorten(visible);
		if (!visible) {

			data.horizontalAlignment = GridData.FILL_HORIZONTAL;
			data.grabExcessHorizontalSpace = true;
		} else {
			data.horizontalAlignment = GridData.BEGINNING;
			data.grabExcessHorizontalSpace = false;
		}

	}

	/**
	 * Update the size of the items such that all items are visible, if
	 * possible.
	 * 
	 * @return <code>true</code> if any item has changed, <code>false</code>
	 *         otherwise
	 */
	private boolean updateSize() {
		final int width = this.mContainer.getClientArea().width;

		int currentWidth = getCurrentWidth();

		boolean requiresLayout = false;

		if (currentWidth > width) {
			// Modified to show first ,Secondlast and Last Item, all the time
			// during shrink
			int index = 1;
			while (currentWidth > width && index < this.mBreadcrumbs.size() - 2) {
				final CoolLabel item = (CoolLabel) this.mBreadcrumbs.get(index);
				if (item.isShorten()) {
					setVisible(item, false);
					currentWidth = getCurrentWidth();
					requiresLayout = true;
				}

				index++;
			}

		} else if (currentWidth < width) {
			int index = this.mBreadcrumbs.size() - 1;

			while (currentWidth < width && index >= 1) {

				final CoolLabel bItem = (CoolLabel) this.mBreadcrumbs.get(index);
				if (!bItem.isShorten()) {
					setVisible(bItem, true);
					currentWidth = getCurrentWidth();
					if (currentWidth > width) {
						setVisible(bItem, false);
						index = 0;
					} else {
						requiresLayout = true;
					}
				}

				index--;
			}
		}

		return requiresLayout;
	}

	/**
	 * Returns the current width of all items in the list.
	 * 
	 * @return the width of all items in the list
	 */
	private int getCurrentWidth() {
		int result = 0;
		for (int i = 0, size = this.mBreadcrumbs.size(); i < size; i++) {
			final CoolLabel label = (CoolLabel) this.mBreadcrumbs.get(i);
			result += label.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
		}
		for (int i = 0, size = this.arrowList.size(); i < size; i++) {
			final CoolLabel label = (CoolLabel) this.arrowList.get(i);
			result += label.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
		}

		return result;
	}

	/**
	 * An arrow image descriptor. The images color is related to the list fore-
	 * and background color. This makes the arrow visible even in high contrast
	 * mode. If <code>ltr</code> is true the arrow points to the right,
	 * otherwise it points to the left.
	 */
	private final class ArrowImage extends CompositeImageDescriptor {

		private final static int ARROW_SIZE = 5;

		private final boolean fLTR;

		public ArrowImage(final boolean ltr) {
			this.fLTR = ltr;
		}

		/*
		 * @see
		 * org.eclipse.jface.resource.CompositeImageDescriptor#drawCompositeImage
		 * (int, int)
		 */
		@Override
		protected void drawCompositeImage(final int width, final int height) {
			final Display display = CBreadcrumbViewer.this.mContainer.getDisplay();

			final Image image = new Image(display, ARROW_SIZE, ARROW_SIZE * 2);

			final GC gc = new GC(image);

			final Color triangle = display.getSystemColor(SWT.COLOR_BLACK);
			gc.setBackground(triangle);

			if (this.fLTR) {
				gc.fillPolygon(new int[] { mirror(0), 0, mirror(ARROW_SIZE), ARROW_SIZE, mirror(0), ARROW_SIZE * 2 });
			} else {
				gc.fillPolygon(new int[] { ARROW_SIZE, 0, 0, ARROW_SIZE, ARROW_SIZE, ARROW_SIZE * 2 });
			}

			gc.dispose();
			triangle.dispose();

			final ImageData imageData = image.getImageData();
			for (int y = 1; y < ARROW_SIZE; y++) {
				for (int x = 0; x < y; x++) {
					imageData.setAlpha(mirror(x), y, 255);
				}
			}
			for (int y = 0; y < ARROW_SIZE; y++) {
				for (int x = 0; x <= y; x++) {
					imageData.setAlpha(mirror(x), ARROW_SIZE * 2 - y - 1, 255);
				}
			}

			final int offset = this.fLTR ? 0 : -1;
			drawImage(imageData, width / 2 - ARROW_SIZE / 2 + offset, height / 2 - ARROW_SIZE - 1);

			image.dispose();
		}

		private int mirror(final int x) {
			if (this.fLTR) {
				return x;
			}

			return ARROW_SIZE - x - 1;
		}

		@Override
		protected Point getSize() {
			return new Point(10, 16);
		}

	}

	public static Object[] reverse(Object[] arr) {
		List<Object> list = Arrays.asList(arr);
		Collections.reverse(list);
		return list.toArray();
	}

	public void setDirection(boolean selection) {

		this.RTL = selection;
		if (selection) {
			mContainer.setOrientation(SWT.RIGHT_TO_LEFT);
		} else {
			mContainer.setOrientation(SWT.LEFT_TO_RIGHT);
		}
		for (CoolLabel coolLabelArrow : arrowList) {
			if (!selection) {
				coolLabelArrow.setImage(arrowImage);
			} else {
				coolLabelArrow.setImage(arrowImageRTL);
			}
		}

	}

}
