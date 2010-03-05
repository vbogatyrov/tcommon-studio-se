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
package org.talend.rcp.intro;

import java.util.Properties;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;
import org.talend.core.CorePlugin;
import org.talend.core.prefs.ITalendCorePrefConstants;

/**
 * wchen class global comment. Detailled comment
 */
public class AlwaysWelcomeAction implements IIntroAction {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.intro.config.IIntroAction#run(org.eclipse.ui.intro.IIntroSite, java.util.Properties)
     */
    public void run(IIntroSite site, Properties params) {
        if (params == null) {
            return;
        }
        String showIntro = (String) params.get("showIntro");
        IPreferenceStore store = CorePlugin.getDefault().getPreferenceStore();
        store.setValue(ITalendCorePrefConstants.ALWAYS_WELCOME, !store.getBoolean(ITalendCorePrefConstants.ALWAYS_WELCOME));
    }

}
