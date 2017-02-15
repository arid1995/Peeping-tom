package org.dimwits.gui.drawings;

import java.awt.*;

/**
 * Created by farid on 2/13/17.
 * Wrapper for graphics
 * Scales everything
 * Working interval of values is from 0.0 to 1.0
 */
@SuppressWarnings("WeakerAccess")
public class CGraphics {
    private Graphics graphics;
    private Dimension size;
    private double FONT_SIZE = 0.02;

    public CGraphics() {
    }

    public CGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
        this.graphics.setFont(new Font("TimesRoman", Font.BOLD, scaleX(FONT_SIZE)));
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Dimension getSize() {
        return size;
    }

    public void drawString(String text, double x, double y) {
        graphics.drawString(text, scaleX(x), scaleY(y));
    }

    public void drawOval(double x, double y, double width, double height) {
        graphics.drawOval(scaleX(x), scaleY(y), scaleX(width), scaleY(height));
    }

    public void drawRect(double x, double y, double width, double height) {
        graphics.drawRect(scaleX(x), scaleY(y), scaleX(width), scaleY(height));
    }

    public double getTextLength(String text) {
        return (double) graphics.getFontMetrics().stringWidth(text) / size.width;
    }

    public void setColor(Color color) {
        graphics.setColor(color);
    }

    public double getTextHeight(String text) {
        return (double) graphics.getFontMetrics().getHeight() / size.height;
    }

    private int scaleX(double value) {
        return (int) (value * size.width);
    }

    private int scaleY(double value) {
        return (int) (value * size.height);
    }
}