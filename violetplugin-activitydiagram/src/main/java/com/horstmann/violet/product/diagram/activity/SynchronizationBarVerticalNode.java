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

package com.horstmann.violet.product.diagram.activity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import com.horstmann.violet.product.diagram.abstracts.edge.IEdge;
import com.horstmann.violet.product.diagram.abstracts.node.INode;
import com.horstmann.violet.product.diagram.abstracts.node.RectangularNode;

/**
 * A vertical synchronization bar node in an activity diagram.
 */
public class SynchronizationBarVerticalNode extends RectangularNode
{
    @Override
    public boolean addConnection(IEdge e){

        return e.getEnd() != null && this != e.getEnd();
    }

    @Override
    public Point2D getConnectionPoint(IEdge e) {
        Point2D defaultConnectionPoint = super.getConnectionPoint(e);
        if (!ActivityTransitionEdge.class.isInstance(e)) {
            return defaultConnectionPoint;
        }
        INode end = e.getEnd();
        INode start = e.getStart();
        Point2D currentLocation = getLocation();
        if (this == start){
            return determineStartConnectionPoint(e, currentLocation);
        }else if (this == end) {
            return determineEndConnectionPoint(e, currentLocation);
        }
        return defaultConnectionPoint;
    }

    private Point2D determineEndConnectionPoint(IEdge e, Point2D location){
        INode start = e.getStart();
        Point2D node = start.getLocation();
        return new Point2D.Double(location.getX(), node.getY());
    }

    private Point2D determineStartConnectionPoint(IEdge e, Point2D location){
        INode end = e.getEnd();
        Point2D node = end.getLocation();
        return new Point2D.Double(location.getX(), node.getY());
    }
    
    @Override
    public Rectangle2D getBounds() {
        Rectangle2D defaultBounds = getDefaultBounds();
        List<INode> connectedNodes = getConnectedNodes();
        if (connectedNodes.size() > 0) {
            double minY = Double.MAX_VALUE; 
            double maxY = Double.MIN_VALUE;
            for (INode n : connectedNodes) {
                Rectangle2D b2 = n.getBounds();
                minY = Math.min(minY, b2.getMinY()); 
                maxY = Math.max(maxY, b2.getMaxY()); 
            }
            minY -= EXTRA_HEIGHT;
            maxY += EXTRA_HEIGHT;
            translate(0, minY - defaultBounds.getY());
            defaultBounds = new Rectangle2D.Double(defaultBounds.getX(), minY, DEFAULT_WIDTH, maxY - minY);
        }
        return defaultBounds;
    }

    /**
     * @return minimal bounds (location + default width and default height
     */
    private Rectangle2D getDefaultBounds() {
        Point2D currentLocation = getLocation();
        double x = currentLocation.getX();
        double y = currentLocation.getY();
        double w = DEFAULT_WIDTH;
        double h = DEFAULT_HEIGHT;
        return new Rectangle2D.Double(x, y, w, h);
    }

    /**
     * @return nodes which are connected (with edges) to this node
     */
    private List<INode> getConnectedNodes() {
        List<INode> connectedNodes = new ArrayList<INode>();
        for (IEdge e : getGraph().getAllEdges()) {
            if (e.getStart() == this) connectedNodes.add(e.getEnd());
            if (e.getEnd() == this) connectedNodes.add(e.getStart());
        }
        return connectedNodes;
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        Color oldColor = g2.getColor();
        g2.setColor(getBorderColor());
        g2.fill(getShape());
        g2.setColor(oldColor);
    }

    /**
     * @see java.lang.Object#clone()
     */
    @Override
    public SynchronizationBarVerticalNode clone() {
        return (SynchronizationBarVerticalNode) super.clone();
    }


    private static final int DEFAULT_WIDTH = 4;
    private static final int DEFAULT_HEIGHT = 100;
    private static final int EXTRA_HEIGHT = 12;
}
