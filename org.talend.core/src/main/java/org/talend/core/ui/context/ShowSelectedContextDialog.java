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
package org.talend.core.ui.context;

import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.talend.commons.ui.image.ImageProvider;
import org.talend.core.model.context.JobContextManager;
import org.talend.core.model.process.IContext;
import org.talend.core.model.process.IContextManager;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.properties.ContextItem;
import org.talend.core.ui.images.ECoreImage;

/**
 * DOC ggu class global comment. Detailled comment
 */
public class ShowSelectedContextDialog extends Dialog {

    ContextItem contextItem;

    IContextManager contextManager;

    /**
     * DOC ggu ShowSelectedContextDialog constructor comment.
     * 
     * @param parentShell
     */
    protected ShowSelectedContextDialog(ContextItem contextItem, Shell parentShell) {
        super(parentShell);
        setDefaultImage(ImageProvider.getImage(ECoreImage.CONTEXT_ICON));
        setShellStyle(getShellStyle() | SWT.RESIZE);
        this.contextItem = contextItem;
        this.contextManager = new JobContextManager(contextItem.getContext(), contextItem.getDefaultContext());
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        if (contextItem != null) {
            newShell.setText("Context:" + contextItem.getProperty().getLabel()); //$NON-NLS-1$
        }
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        final ShowSelectedContextComposite showContext = new ShowSelectedContextComposite(composite);
        showContext.setLayout(new GridLayout());
        GridData gridData = new GridData();
        gridData.grabExcessHorizontalSpace = true;
        gridData.grabExcessVerticalSpace = true;
        gridData.verticalAlignment = SWT.FILL;
        gridData.horizontalAlignment = SWT.FILL;
        showContext.setLayoutData(gridData);
        showContext.setReadOnly(true);
        showContext.refreshTemplateTab();
        return composite;

    }

    /**
     * 
     * DOC ggu ShowSelectedContextDialog class global comment. Detailled comment
     */
    class ShowSelectedContextComposite extends ContextComposite {

        public ShowSelectedContextComposite(Composite parent) {
            super(parent, true);

        }

        @Override
        public IContextManager getContextManager() {
            return contextManager;
        }

        public void onContextAddParameter(IContextManager contextManager, IContextParameter parameter) {

        }

        public void onContextChangeDefault(IContextManager contextManager, IContext newDefault) {

        }

        public void onContextModify(IContextManager contextManager, IContextParameter parameter) {

        }

        public void onContextRemoveParameter(IContextManager contextManager, String paramName) {

        }

        public void onContextRenameParameter(IContextManager contextManager, String oldName, String newName) {

        }

        public void onContextRemoveParameter(IContextManager contextManager, Set<String> paramNames) {

        }

    }
}
