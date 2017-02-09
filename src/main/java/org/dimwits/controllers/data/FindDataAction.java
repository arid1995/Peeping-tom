package org.dimwits.controllers.data;

import org.dimwits.gui.utils.Visualizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by farid on 2/9/17.
 */
public class FindDataAction implements ActionListener {
    Visualizer visualizer;

    public FindDataAction(Visualizer visualizer) {
        this.visualizer = visualizer;
    }

    public void actionPerformed(ActionEvent event) {
        visualizer.visualize();
    }
}
