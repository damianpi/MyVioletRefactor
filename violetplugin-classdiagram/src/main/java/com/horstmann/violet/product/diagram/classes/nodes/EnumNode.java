package com.horstmann.violet.product.diagram.classes.nodes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import com.horstmann.violet.product.diagram.abstracts.node.INode;
import com.horstmann.violet.product.diagram.abstracts.node.RectangularNode;
import com.horstmann.violet.product.diagram.abstracts.property.MultiLineString;
import com.horstmann.violet.product.diagram.common.PointNode;

/**
 * An EnumNode in a Class diagram.
 */
public class EnumNode extends RectangularNode{
    /**
     * Construct an Enum node with a default size and the text <<enum>>.
     */
    public EnumNode(){
        super();
        name = new MultiLineString();
        name.setSize(MultiLineString.LARGE);
        name.setText("\u00ABenum\u00BB");
        fields = new MultiLineString();
        fields.setJustification(MultiLineString.LEFT);
    }

    private Rectangle2D getTopRectangleBounds(){
        Rectangle2D globalBounds = new Rectangle2D.Double(0, 0, 0, 0);
        Rectangle2D nameBounds = name.getBounds();
        globalBounds.add(nameBounds);
        boolean isFieldsEmpty = (fields.getText().length() == 0);
        double defaultHeight = DEFAULT_HEIGHT;
        if (!isFieldsEmpty){
            defaultHeight = DEFAULT_COMPARTMENT_HEIGHT;
        }
        globalBounds.add(new Rectangle2D.Double(0, 0, DEFAULT_WIDTH, defaultHeight));
        Point2D currentLocation = getLocation();
        globalBounds.setFrame(currentLocation.getX(), currentLocation.getY(),
                              globalBounds.getWidth(), globalBounds.getHeight());
        return getGraph().getGridSticker().snap(globalBounds);
    }

    private Rectangle2D getBottomRectangleBounds(){
        Rectangle2D globalBounds = new Rectangle2D.Double(0, 0, 0, 0);
        Rectangle2D fieldsBounds = fields.getBounds();
        globalBounds.add(fieldsBounds);
        if (fieldsBounds.getHeight() > 0){
            globalBounds.add(new Rectangle2D.Double(0, 0, DEFAULT_WIDTH, DEFAULT_COMPARTMENT_HEIGHT));
        }
        Rectangle2D topBounds = getTopRectangleBounds();
        globalBounds.setFrame(topBounds.getX(), topBounds.getMaxY(),
                              globalBounds.getWidth(), globalBounds.getHeight());
        return getGraph().getGridSticker().snap(globalBounds);
    }

    @Override
    public Rectangle2D getBounds(){
        Rectangle2D top = getTopRectangleBounds();
        Rectangle2D bot = getBottomRectangleBounds();
        top.add(bot);
        return getGraph().getGridSticker().snap(top);
    }

    @Override
    public void draw(Graphics2D g2){
        Color oldColor = g2.getColor();
        Point2D g2Location = getDrawLocation();
        g2.translate(g2Location.getX(), g2Location.getY());
        super.draw(g2);
        Rectangle2D currentBounds = getBounds();
        Rectangle2D topBounds = getTopRectangleBounds();
        Rectangle2D bottomBounds = getBottomRectangleBounds();
        if (topBounds.getWidth() < currentBounds.getWidth()){
            topBounds.setRect(topBounds.getX(), topBounds.getY(), currentBounds.getWidth(), topBounds.getHeight());
        }
        fillBackground(g2, currentBounds);
        drawGraphics(g2, currentBounds, topBounds);
        addElements(g2, topBounds, bottomBounds);
        g2.translate(-g2Location.getX(), -g2Location.getY());
        g2.setColor(oldColor);
    }

    private void addElements(Graphics2D g2, Rectangle2D topBounds, Rectangle2D bottomBounds){
        name.draw(g2, topBounds);
        fields.draw(g2, bottomBounds);
    }

    private void drawGraphics(Graphics2D g2,  Rectangle2D currentBounds, Rectangle2D topBounds){
        g2.setColor(getBorderColor());
        g2.draw(currentBounds);
        g2.setColor(getBorderColor());
        g2.drawLine((int) topBounds.getX(), (int) topBounds.getMaxY(),
                    (int) currentBounds.getMaxX(), (int) topBounds.getMaxY());
        g2.setColor(getTextColor());
    }

    private Point2D getDrawLocation() {
        Point2D nodeLocationOnGraph = getLocationOnGraph();
        Point2D nodeLocation = getLocation();
        return new Point2D.Double(nodeLocationOnGraph.getX() - nodeLocation.getX(),
                                  nodeLocationOnGraph.getY() - nodeLocation.getY());
    }

    private void fillBackground(Graphics2D g2, Rectangle2D currentBounds) {
        g2.setColor(getBackgroundColor());
        g2.fill(currentBounds);
    }

    @Override
    public boolean addChild(INode n, Point2D p){
        return (n instanceof PointNode);
    }

    public void setName(MultiLineString newValue) throws IllegalArgumentException{
        if(newValue != null){
            name = newValue;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public MultiLineString getName(){
        return name;
    }

    public void setFields(MultiLineString newValue) throws IllegalArgumentException{
       if(newValue != null) {
           fields = newValue;
       }else{
           throw new IllegalArgumentException();
       }
    }

    public MultiLineString getFields(){
        return fields;
    }

    @Override
    public EnumNode clone(){
        EnumNode cloned = (EnumNode) super.clone();
        cloned.name = name.clone();
        cloned.fields = fields.clone();
        return cloned;
    }


    private MultiLineString name;
    private MultiLineString fields;
    private static int DEFAULT_COMPARTMENT_HEIGHT = 20;
    private static int DEFAULT_WIDTH = 100;
    private static int DEFAULT_HEIGHT = 60;
}