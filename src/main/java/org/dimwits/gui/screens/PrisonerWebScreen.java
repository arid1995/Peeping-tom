package org.dimwits.gui.screens;

import org.dimwits.data.models.Prisoner;
import org.dimwits.gui.drawings.*;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by farid on 2/12/17.
 */
@Service
public class PrisonerWebScreen extends Screen implements MouseMotionListener, MouseListener {
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
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void setMainPrisoner(Prisoner mainPrisoner) {
        this.mainPrisoner = mainPrisoner;
        canvas.setMainShape(new DataRectangle(mainPrisoner, 0.5, 0.5));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        canvas.mouseMoved(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
