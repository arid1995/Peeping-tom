package org.dimwits.gui.drawings;

import java.awt.*;

/**
 * Created by farid on 2/15/17.
 */
public class Linker implements Drawable {
    public static final Color FRIENDLY_LINK_COLOR = new Color(42, 224, 60);
    public static final Color HOSTILE_LINK_COLOR = new Color(255, 33, 62);
    private BoundingRect boundingRect1;
    private BoundingRect boundingRect2;
    private Color color;

    public  Linker(BoundingRect boundingRect1, BoundingRect boundingRect2) {
        this.boundingRect1 = boundingRect1;
        this.boundingRect2 = boundingRect2;
    }

    @Override
    public void draw(CGraphics graphics) {
        graphics.setColor(color);

        calculateAndDrawLine(graphics);
    }

    private void calculateAndDrawLine(CGraphics graphics) {
        double x1 = boundingRect2.getX() - boundingRect1.getX();
        double y1 = boundingRect2.getY() - boundingRect1.getY();
        double x2 = 1.0;
        double y2 = 0.0;

        double angle = Math.acos((x1 * x2 + y1*y2) / (Math.sqrt(x1 * x1 + y1 * y1) * Math.sqrt(x2 * x2 + y2 * y2)));

        if (y1 > 0.5) {
            if (angle < Math.PI / 4) {
                graphics.drawLine(boundingRect1.getRightMiddleX(), boundingRect1.getRightMiddleY(),
                        boundingRect2.getLeftMiddleX(), boundingRect2.getLeftMiddleY());
            } else if (angle < 3 * Math.PI / 4) {
                graphics.drawLine(boundingRect1.getTopMiddleX(), boundingRect1.getTopMiddleY(),
                        boundingRect2.getBottomMiddleX(), boundingRect2.getBottomMiddleY());
            } else {
                graphics.drawLine(boundingRect1.getLeftMiddleX(), boundingRect1.getLeftMiddleY(),
                        boundingRect2.getRightMiddleX(), boundingRect2.getRightMiddleY());
            }
        } else if (angle > 0) {
            if (angle < Math.PI / 4) {
                graphics.drawLine(boundingRect1.getRightMiddleX(), boundingRect1.getRightMiddleY(),
                        boundingRect2.getLeftMiddleX(), boundingRect2.getLeftMiddleY());
            } else if (angle < 3 * Math.PI / 4) {
                graphics.drawLine(boundingRect1.getBottomMiddleX(), boundingRect1.getBottomMiddleY(),
                        boundingRect2.getTopMiddleX(), boundingRect2.getTopMiddleY());
            } else {
                graphics.drawLine(boundingRect1.getLeftMiddleX(), boundingRect1.getLeftMiddleY(),
                        boundingRect2.getRightMiddleX(), boundingRect2.getRightMiddleY());
            }
        }
    }

    @Override
    public BoundingRect getBoundingRect() {
        return null;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }


}
