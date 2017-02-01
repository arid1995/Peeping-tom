package org.dimwits.gui;

import org.dimwits.gui.screens.MenuScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Stack;

/**
 * Created by farid on 1/31/17.
 * Main window
 */
@Component
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class MainWindow extends JFrame{

    @Autowired
    private MenuScreen menuScreen;

    private Stack<JPanel> history = new Stack<>();

    public MainWindow() {
        super("Peeping tom");
        init();
    }

    @PostConstruct
    private void attachScreen() {
        changeScreen(menuScreen);
    }

    private void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        this.setSize(600, 600);//TODO: constants for window size and location
        this.setLocation(300, 300);
    }

    public void changeScreen(JPanel newScreen) {
        this.setContentPane(newScreen);
        SwingUtilities.updateComponentTreeUI(this);
        history.push(newScreen);
    }

    public void goBack() {
        this.setContentPane(history.pop());

    }
}
