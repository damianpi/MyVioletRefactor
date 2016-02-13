package com.horstmann.violet.product.diagram.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import com.horstmann.violet.product.diagram.state.HistoryNode;
import com.horstmann.violet.product.diagram.abstracts.node.EllipticalNode;
import com.horstmann.violet.workspace.sidebar.colortools.ColorToolsBarPanel;


public class ShallowHistoryNode extends HistoryNode{

    public ShallowHistoryNode(){
    	super();
    	this.historyType = "H";
    }

}
