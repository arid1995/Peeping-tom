package org.dimwits.gui;

import javax.swing.*;

/**
 * Created by farid on 1/31/17.
 */
public class MainWindow extends JFrame{

    public MainWindow(String title) {
        super(title);
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        this.setSize(600, 600);
        this.setLocation(300, 300);
    }
}
