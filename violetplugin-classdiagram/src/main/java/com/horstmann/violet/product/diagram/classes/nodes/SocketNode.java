/*
 Violet - A program for editing UML diagrams.

 Copyright (C) 2007 Cay S. Horstmann (http://horstmann.com)
 Alexandre de Pellegrin (http://alexdp.free.fr);

 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.horstmann.violet.product.diagram.classes.nodes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Arc2D;
import com.horstmann.violet.product.diagram.abstracts.edge.IEdge;
import com.horstmann.violet.product.diagram.abstracts.node.RectangularNode;

/**
 * SocketNode for Class diagram
 */
public class SocketNode extends RectangularNode
{

    @Override
    public boolean addConnection(IEdge e){
         return this != e.getEnd() && super.addConnection(e);
    }

    @Override
    public Point2D getConnectionPoint(IEdge e){
    	Point2D location = getLocation();
        int divideHeight = 2;
        return new Point2D.Double(location.getX(), location.getY()+(DEFAULT_HEIGHT / divideHeight));
    }

    @Override
    public Rectangle2D getBounds(){
        Rectangle2D b = getDefaultBounds();
        return new Rectangle2D.Double(b.getX(), b.getY(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    private Rectangle2D getDefaultBounds(){
        Point2D currentLocation = getLocation();
        double x = currentLocation.getX();
        double y = currentLocation.getY();
        double w = DEFAULT_WIDTH;
        double h = DEFAULT_HEIGHT;
        return new Rectangle2D.Double(x, y, w, h);
    }

    @Override
    public void draw(Graphics2D g2){
        super.draw(g2);
        Color oldColor = g2.getColor();
        Rectangle2D bounds = getDefaultBounds();
        g2.draw(new Arc2D.Double((int)bounds.getX(), (int)bounds.getY(),
                                 DEFAULT_WIDTH, DEFAULT_HEIGHT, 90, 180, Arc2D.OPEN));
        g2.setColor(oldColor);
    }

    /**
     * @see java.lang.Object#clone()
     */
    @Override
    public SocketNode clone()
    {
        return (SocketNode) super.clone();
    }

    private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_HEIGHT = 70;
}
