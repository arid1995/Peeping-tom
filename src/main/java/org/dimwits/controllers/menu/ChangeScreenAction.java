package org.dimwits.controllers.menu;

import org.dimwits.gui.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by farid on 2/1/17.
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class ChangeScreenAction implements ActionListener {
    private MainWindow mainWindow;
    private JPanel screen;

    public ChangeScreenAction (JPanel screen, MainWindow mainWindow) {
        this.screen = screen;
        this.mainWindow = mainWindow;
    }

    public void actionPerformed(ActionEvent e) {
        mainWindow.changeScreen(screen);
    }
}
