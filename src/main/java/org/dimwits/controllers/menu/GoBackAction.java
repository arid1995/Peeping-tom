package org.dimwits.controllers.menu;

import org.dimwits.gui.MainWindow;
import org.dimwits.gui.screens.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by farid on 2/1/17.
 */
public class GoBackAction implements ActionListener {
    private MainWindow mainWindow;

    public GoBackAction(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.changeScreen(Screen.goBack());
    }
}
