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
    public static final Color TEXT_COLOR = new Color(240, 240, 240);
    public static final Color HIGHLIGHTED_COLOR = new Color(68, 237, 85);
    public static final Color DEFAULT_COLOR = new Color(51, 51, 51);

    public DataRectangle(Prisoner prisoner, double x, double y) {
        this.prisoner = prisoner;
        boundingRect = new BoundingRect(0, 0, x, y);
    }

    public void draw(CGraphics graphics) {
        graphics.setColor(color);

        String text = prisoner.toString();

        boundingRect.setWidth(graphics.getTextLength(text) + 2 * OFFSET);
        boundingRect.setHeight(graphics.getTextHeight(text) + 2 * OFFSET);

        graphics.drawRect(boundingRect.getX(), boundingRect.getY(), boundingRect.getWidth(), boundingRect.getHeight());
        graphics.setColor(TEXT_COLOR);
        graphics.drawString(prisoner.toString(), boundingRect.getX() + OFFSET,
                boundingRect.getY() + 3 * graphics.getTextHeight(text) / 4 + OFFSET);
        color = DEFAULT_COLOR;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BoundingRect getBoundingRect() {
        return boundingRect;
    }

    public Prisoner getPrisoner() {
        return prisoner;
    }
}
