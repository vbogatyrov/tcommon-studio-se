// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006 Talend - www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.commons.ui.swt.drawing.link;

import org.eclipse.swt.widgets.TreeItem;

/**
 * DOC amaumont class global comment. Detailled comment <br/>
 * 
 * $Id$
 * 
 */
public class TreeExtremityDescriptor implements IExtremityLink<TreeItem, Object> {

    private TreeItem treeItem;

    private Object dataObject;

    /**
     * DOC amaumont TreeItemExtremityDescriptor constructor comment.
     * 
     * @param treeItem
     */
    public TreeExtremityDescriptor(TreeItem treeItem, Object dataObject) {
        super();
        this.treeItem = treeItem;
        this.dataObject = dataObject;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.commons.ui.swt.drawing.link.IExtremityLink#getAssociatedItem()
     */
    public TreeItem getGraphicalObject() {
        return treeItem;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.commons.ui.swt.drawing.link.IExtremityLink#getDataItem()
     */
    public Object getDataItem() {
        return dataObject;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.commons.ui.swt.drawing.link.IExtremityLink#setDataItem(java.lang.Object)
     */
    public void setDataItem(Object dataItem) {
        this.dataObject = dataItem;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.commons.ui.swt.drawing.link.IExtremityLink#setGraphicalItem(java.lang.Object)
     */
    public void setGraphicalObject(TreeItem graphicalItem) {
        this.treeItem = graphicalItem;
    }

}
