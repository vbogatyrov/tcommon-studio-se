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

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;

/**
 * DOC amaumont class global comment. Detailled comment <br/>
 * 
 * $Id$
 * 
 */
public interface IExtremityDrawableLink {

    /**
     * DOC amaumont Comment method "draw".
     * 
     * @param gc
     * @param point
     */
    public void draw(GC gc, Point point);

    /**
     * Getter for xOffset.
     * 
     * @return the xOffset
     */
    public int getXOffset();

    /**
     * Sets the xOffset.
     * 
     * @param offset the xOffset to set
     */
    public void setXOffset(int offset);

    /**
     * Getter for yOffset.
     * 
     * @return the yOffset
     */
    public int getYOffset();

    /**
     * Sets the yOffset.
     * 
     * @param offset the yOffset to set
     */
    public void setYOffset(int offset);

    public Point getSize();
}
