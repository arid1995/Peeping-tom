package org.dimwits.gui.drawings;

import org.dimwits.data.models.Prisoner;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by farid on 2/13/17.
 */
public class CCanvas {
    private CGraphics graphics = new CGraphics();
    private ArrayList<Drawable> shapes;
    private Drawable mainShape;
    private ArrayList<Linker> linkers;

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
        if (mainShape == null) return;

        linkers = new ArrayList<>();
        for (Drawable shape : this.shapes) {
            Linker linker = new Linker(mainShape.getBoundingRect(), shape.getBoundingRect());
            linker.setColor(Linker.FRIENDLY_LINK_COLOR);
            linkers.add(linker);
        }
    }

    public void setMainShape(Drawable mainShape) {
        this.mainShape = mainShape;
    }

    private Drawable checkIntersections(int px, int py) {
        double x = (double) px / graphics.getSize().width;
        double y = (double) py / graphics.getSize().height;

        for(Drawable shape : shapes) {
            if (shape.getBoundingRect().isIntersected(x, y)) return shape;
        }
        if (mainShape.getBoundingRect().isIntersected(x, y)) return mainShape;
        return null;
    }

    public Prisoner getSelectedPrisoner(int x, int y) {
        Drawable shape = checkIntersections(x, y);
        if (shape != null && shape instanceof  DataRectangle) {
            DataRectangle dataRectangle = (DataRectangle) shape;
            return dataRectangle.getPrisoner();
        }
        return null;
    }

    public void mouseMoved(int x, int y) {
        Dimension size = graphics.getSize();
        Drawable shape = checkIntersections(x, y);

        if (shape != null) {
            shape.setColor(DataRectangle.HIGHLIGHTED_COLOR);
        }
    }

    public void redraw() {
        mainShape.draw(graphics);

        for(Drawable shape : shapes) {
            shape.draw(graphics);
        }

        for (Linker linker : linkers) {
            linker.draw(graphics);
        }
    }
}
