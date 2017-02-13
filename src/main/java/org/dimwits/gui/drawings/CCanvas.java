package org.dimwits.gui.drawings;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by farid on 2/13/17.
 */
public class CCanvas {
    private CGraphics graphics = new CGraphics();
    private ArrayList<Drawable> shapes;
    private Drawable mainShape;

    public CCanvas(Dimension size) {
        graphics.setSize(size);
    }

    public void setGraphics(Graphics graphics) {
        this.graphics.setGraphics(graphics);
    }

    public void setSize(Dimension size) {
        graphics.setSize(size);
    }

    public void setShapes(ArrayList<Drawable> shapes) {
        this.shapes = shapes;
    }

    public void setMainShape(Drawable mainShape) {
        this.mainShape = mainShape;
    }

    public void redraw() {
        mainShape.draw(graphics);
    }
}
