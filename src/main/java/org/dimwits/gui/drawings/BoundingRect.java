package org.dimwits.gui.drawings;

import java.awt.*;

/**
 * Created by farid on 2/14/17.
 */
public class BoundingRect {
    private double width;
    private double height;
    private double x;
    private double y;
    private double anchorX;
    private double anchorY;

    public BoundingRect(double width, double height, double anchorX, double anchorY) {
        this.width = width;
        this.height = height;
        this.anchorX = anchorX;
        this.anchorY = anchorY;
        x = anchorX - width / 2;
        y = anchorY - height / 2;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setWidth(double width) {
        this.width = width;
        x = anchorX - width / 2;
    }

    public void setHeight(double height) {
        this.height = height;
        y = anchorY - height / 2;
    }

    public void setX(double anchorX) {
        this.anchorX = anchorX;
        x = anchorX - width / 2;
    }

    public void setY(double anchorY) {
        this.anchorY = anchorY;
        y = anchorY - height / 2;
    }

    public boolean isIntersected(double px, double py) {
        return ((px > x && px < x + width) && (py > y && py < y + height));
    }

    public double getRightMiddleX() {
        return x + width;
    }

    public double getLeftMiddleX() {
        return x;
    }

    public double getTopMiddleX() {
        return anchorX;
    }

    public double getBottomMiddleX() {
        return anchorX;
    }

    public double getRightMiddleY() {
        return anchorY;
    }

    public double getLeftMiddleY() {
        return anchorY;
    }

    public double getTopMiddleY() {
        return y;
    }

    public double getBottomMiddleY() {
        return y + height;
    }
}
