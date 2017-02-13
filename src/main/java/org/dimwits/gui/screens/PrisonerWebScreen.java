package org.dimwits.gui.screens;

import org.dimwits.data.models.Prisoner;
import org.dimwits.gui.drawings.*;
import org.springframework.stereotype.Service;

import java.awt.*;

/**
 * Created by farid on 2/12/17.
 */
@Service
public class PrisonerWebScreen extends Screen {
    CCanvas canvas;
    private Prisoner mainPrisoner;

    public PrisonerWebScreen() {
        canvas = new CCanvas(new Dimension(this.getWidth(), this.getHeight()));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        canvas.setSize(new Dimension(this.getWidth(), this.getHeight()));
        canvas.setGraphics(graphics);
        canvas.redraw();
    }

    public void setMainPrisoner(Prisoner mainPrisoner) {
        this.mainPrisoner = mainPrisoner;
        canvas.setMainShape(new DataCircle(mainPrisoner, 0.5, 0.1));
    }
}
