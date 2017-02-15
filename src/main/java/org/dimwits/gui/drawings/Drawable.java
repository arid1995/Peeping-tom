package org.dimwits.gui.drawings;

import java.awt.*;

/**
 * Created by farid on 2/13/17.
 */
public interface Drawable {
    void draw(CGraphics graphics);
    BoundingRect getBoundingRect();
    void setColor(Color color);
}
