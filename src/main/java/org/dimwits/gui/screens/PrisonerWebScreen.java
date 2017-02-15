package org.dimwits.gui.screens;

import org.dimwits.data.dao.PrisonerDAO;
import org.dimwits.data.models.Prisoner;
import org.dimwits.gui.MainWindow;
import org.dimwits.gui.drawings.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by farid on 2/12/17.
 */
@Service
public class PrisonerWebScreen extends Screen {
    CCanvas canvas;
    private Prisoner mainPrisoner;

    @Autowired
    PrisonerScreen prisonerScreen;

    @Autowired
    MainWindow mainWindow;

    public PrisonerWebScreen() {
        canvas = new CCanvas(new Dimension(this.getWidth(), this.getHeight()));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Prisoner prisoner = canvas.getSelectedPrisoner(e.getX(), e.getY());
                    if (prisoner != null) {
                        setMainPrisoner(prisoner);
                        canvas.redraw();
                        repaint();
                    }
                } else {
                    Prisoner prisoner = canvas.getSelectedPrisoner(e.getX(), e.getY());
                    if (prisoner != null) {
                        PrisonerWebScreen.this.pushHistory();
                        prisonerScreen.setPrisoner(prisoner);
                        mainWindow.changeScreen(prisonerScreen);
                    }
                }
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                canvas.mouseMoved(e.getX(), e.getY());
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        canvas.setSize(new Dimension(this.getWidth(), this.getHeight()));
        canvas.setGraphics(graphics);
        canvas.redraw();
        this.setBackground(new Color(250, 250, 250));
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
}
