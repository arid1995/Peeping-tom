package org.dimwits.gui.drawings;

import org.dimwits.data.models.Prisoner;

import java.awt.*;

/**
 * Created by farid on 2/12/17.
 */
public class DataRectangle implements Drawable {
    private Prisoner prisoner;
    private final double OFFSET = 0.01;
    private BoundingRect boundingRect;
    private Color color;

    public DataRectangle(Prisoner prisoner, double x, double y) {
        this.prisoner = prisoner;
        boundingRect = new BoundingRect(0, 0, x, y);
    }

    public void draw(CGraphics graphics) {
        String text = prisoner.toString();
        graphics.setColor(color);

        boundingRect.setWidth(graphics.getTextLength(text) + 2 * OFFSET);
        boundingRect.setHeight(graphics.getTextHeight(text) + 2 * OFFSET);

        graphics.drawString(prisoner.toString(), boundingRect.getX() + OFFSET,
                boundingRect.getY() + 3 * graphics.getTextHeight(text) / 4 + OFFSET);
        graphics.drawRect(boundingRect.getX(), boundingRect.getY(), boundingRect.getWidth(), boundingRect.getHeight());

        color = color.BLACK;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BoundingRect getBoundingRect() {
        return boundingRect;
    }
}
