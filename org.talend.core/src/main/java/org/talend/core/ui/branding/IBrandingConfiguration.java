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
package org.talend.core.ui.branding;

import java.util.List;
import java.util.Map;

import org.eclipse.ui.IPageLayout;
import org.talend.repository.model.RepositoryNode;

/**
 * BrandingConfigure for each application's customize setting E.g /perspective/menus/repository
 * view/palletteview/coolbars etc.
 */
public interface IBrandingConfiguration extends IActionBarHelper {

    public static final String DISPLAY_CODE_VIEW = "DISPLAY_CODE_VIEW"; //$NON-NLS-1$

    /**
     * 
     * init perspective.
     * 
     * @param layout
     */
    public void initPerspective(IPageLayout layout);

    /**
     * 
     * get the repositorynode you want to hide in repositoryview.
     * 
     * @return
     */
    public List<RepositoryNode> getHiddenRepositoryCategory(RepositoryNode parent);

    /**
     * returns null if all components are available.
     */
    public String[] getAvailableComponents();

    public void setHelper(IActionBarHelper helper);

    public IActionBarHelper getHelper();

    public String[] getAvailableLanguages();

    public Map<String, Object> getJobEditorSettings();

    public boolean isUseMailLoginCheck();

    public boolean isUseProductRegistration();

    public boolean isAllowDebugMode();

    public boolean isUseDemoProjects();

    public String getAdditionalTitle();

    public void setAdditionalTitle(String title);

    public String getInitialWindowPerspectiveId();
}
