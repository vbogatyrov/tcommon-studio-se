package org.talend.librariesmanager.ui.wizards;

import java.util.List;

import org.eclipse.jface.wizard.Wizard;
import org.talend.core.model.general.ModuleToInstall;
import org.talend.librariesmanager.ui.i18n.Messages;

/**
 * 
 * created by ycbai on 2013-10-16 Detailled comment
 * 
 */
public class AcceptModuleLicensesWizard extends Wizard {

    private AcceptModuleLicensesWizardPage licensesPage;

    private List<ModuleToInstall> modulesToInstall;

    public AcceptModuleLicensesWizard(List<ModuleToInstall> modulesToInstall) {
        super();
        this.modulesToInstall = modulesToInstall;
        setWindowTitle(Messages.getString("AcceptModuleLicensesWizard.title")); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#addPages()
     */
    @Override
    public void addPages() {
        licensesPage = createLicensesPage();
        addPage(licensesPage);
    }

    protected AcceptModuleLicensesWizardPage createLicensesPage() {
        return new AcceptModuleLicensesWizardPage(modulesToInstall);
    }

    @Override
    public boolean performFinish() {
        return licensesPage.performFinish();
    }

}