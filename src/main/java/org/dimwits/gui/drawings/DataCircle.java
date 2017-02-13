package org.dimwits.gui.drawings;

import org.dimwits.data.models.Prisoner;

import java.awt.*;

/**
 * Created by farid on 2/12/17.
 */
public class DataCircle implements Drawable {
    private Prisoner prisoner;
    private final double OFFSET = 0.01;
    private double x;
    private double y;

    public DataCircle(Prisoner prisoner, double x, double y) {
        this.prisoner = prisoner;
        this.x = x;
        this.y = y;
    }

    public void draw(CGraphics graphics) {
        String text = prisoner.toString();
        double width = graphics.getTextLength(text) + 2 * OFFSET;
        double height = graphics.getTextHeight(text) + 2 * OFFSET;
        double realX = x - width / 2;
        double realY = y - height / 2;
        graphics.drawString(prisoner.toString(), realX, realY);
        graphics.drawRect(realX - OFFSET, realY - 3 * graphics.getTextHeight(text) / 4 - OFFSET,
                width, height);
    }
}
