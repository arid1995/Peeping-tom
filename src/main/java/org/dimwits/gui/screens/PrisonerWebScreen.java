package org.dimwits.gui.screens;

import org.dimwits.data.dao.PrisonerDAO;
import org.dimwits.data.models.Prisoner;
import org.dimwits.gui.drawings.*;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

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
        this.setBackground(new Color(250, 250, 250));
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void setMainPrisoner(Prisoner mainPrisoner) {
        this.mainPrisoner = mainPrisoner;
        canvas.setMainShape(new DataRectangle(mainPrisoner, 0.5, 0.5));
        setLinkedPrisoners();
    }

    private void setLinkedPrisoners() {
        ArrayList<Prisoner> linkedPrisoners = (new PrisonerDAO(mainPrisoner)).getLinkedPrisoners();
        ArrayList<Drawable> shapes = new ArrayList<>();

        for (int i = 0; i < linkedPrisoners.size(); i++) {
            shapes.add(determineCoordinates(i, linkedPrisoners.size(), linkedPrisoners.get(i)));
        }

        canvas.setShapes(shapes);
    }

    private DataRectangle determineCoordinates(int position, int length, Prisoner prisoner) {
        double x = 0.5 + Math.sin(2 * Math.PI * position / length) * 0.3;
        double y = 0.5 + Math.cos(2 * Math.PI * position / length) * 0.4;

        return new DataRectangle(prisoner, x, y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        canvas.mouseMoved(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            Prisoner prisoner;
            prisoner = canvas.getSelectedPrisoner(e.getX(), e.getY());
            if (prisoner != null) {
                setMainPrisoner(prisoner);
                canvas.redraw();
                repaint();
            }
            return;
        }
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
