// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core.model.metadata.designerproperties;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.ui.image.ImageProvider;
import org.talend.core.CorePlugin;
import org.talend.core.i18n.Messages;

/**
 * DOC Administrator class global comment. Detailled comment
 */
public class OpenXSDFileDialog extends TitleAreaDialog {

    /**
     * Dialog to open XML files when dragging and dropping a xsd metadata xml item, added by nma, 17/07/2009.
     * 
     * @param parentShell
     */
    protected OpenXSDFileDialog(Shell parentShell) {
        super(parentShell);
        this.setTitle(Messages.getString("OpenXSDFileDialog.xmlFileSelection")); //$NON-NLS-1$
    }

    protected void createButtonsForButtonBar(Composite parent) {
        Button confirmButton = createButton(parent, 9999, Messages.getString("OpenXSDFileDialog.confirm"), true); //$NON-NLS-1$
        confirmButton.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(SelectionEvent arg0) {

            }

            public void widgetSelected(SelectionEvent arg0) {
                setReturnCode(OK);
                close();
            }
        });

        Button cancelButton = createButton(parent, 9998, Messages.getString("OpenXSDFileDialog.cancel"), true); //$NON-NLS-1$
        cancelButton.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(SelectionEvent arg0) {

            }

            public void widgetSelected(SelectionEvent arg0) {
                setReturnCode(CANCEL);
                close();
            }
        });
    }

    protected int getShellStyle() {
        return super.getShellStyle();
    }

    protected Point getInitialSize() {
        return new Point(430, 180);
    }

    public void create() {
        super.create();
        setTitle(Messages.getString("OpenXSDFileDialog.xmlFileSelection")); //$NON-NLS-1$
        setMessage(Messages.getString("OpenXSDFileDialog.xmlSelectedOrNot")); //$NON-NLS-1$
    }

    protected Control createDialogArea(Composite parent) {
        final Composite container = (Composite) super.createDialogArea(parent);
        GridLayout layout = new GridLayout(14, false);
        container.setLayout(layout);

        final Label label = new Label(container, SWT.NONE);
        final Text text = new Text(container, SWT.BORDER);
        text.setText(new Path(p.toPortableString()).toOSString());
        portableValue = new Path(p.toPortableString()).toOSString();
        Button findButton = new Button(container, SWT.NONE);
        findButton.setImage(ImageProvider.getImage(CorePlugin.getImageDescriptor("icons/dots_button.gif"))); //$NON-NLS-1$
        findButton.addSelectionListener(new SelectionListener() {

            public void widgetDefaultSelected(SelectionEvent e) {
            }

            public void widgetSelected(SelectionEvent e) {
                FileDialog dial = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.NONE);
                dial.setFilterExtensions(new String[] { "*.xml" }); //$NON-NLS-1$
                dial.setText(Messages.getString("OpenXSDFileDialog.xmlFileSelection")); //$NON-NLS-1$
                dial.setFileName(new Path(p.toPortableString()).toOSString());
                String file = dial.open();
                if (file != null) {
                    if (!file.equals("")) { //$NON-NLS-1$
                        portableValue = Path.fromOSString(file).toPortableString();
                        text.setText(portableValue);
                    }
                }
            }

        });

        label.setText(Messages.getString("OpenXSDFileDialog.fileName")); //$NON-NLS-1$
        GridData data = new GridData(GridData.BEGINNING);
        data.horizontalSpan = 1;
        label.setLayoutData(data);

        GridData data1 = new GridData(GridData.BEGINNING);
        data1.horizontalSpan = 8;
        data1.widthHint = 305;
        data1.grabExcessVerticalSpace = true;
        text.setLayoutData(data1);

        GridData data2 = new GridData(GridData.BEGINNING);
        data2.horizontalSpan = 2;
        data2.widthHint = 30;
        data2.grabExcessVerticalSpace = true;
        findButton.setLayoutData(data2);

        return container;
    }

    /**
     * DOC Administrator Comment method "setPath".
     * 
     * @param p
     */
    public void setPath(Path p) {
        this.p = p;
    }

    public static String portableValue = ""; //$NON-NLS-1$

    private Path p;
}
