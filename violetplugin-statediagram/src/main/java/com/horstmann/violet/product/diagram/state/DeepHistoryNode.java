package com.horstmann.violet.product.diagram.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import com.horstmann.violet.product.diagram.state.HistoryNode;
import com.horstmann.violet.product.diagram.abstracts.node.EllipticalNode;
import com.horstmann.violet.workspace.sidebar.colortools.ColorToolsBarPanel;

public class DeepHistoryNode extends HistoryNode{

    public DeepHistoryNode(){
    	super();
    	this.historyType = "H*";
    }

		
}
