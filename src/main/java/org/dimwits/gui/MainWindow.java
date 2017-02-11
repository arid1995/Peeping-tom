package org.dimwits.gui;

import org.dimwits.gui.screens.MenuScreen;
import org.dimwits.gui.screens.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created by farid on 1/31/17.
 * Main window
 */
@Service
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class MainWindow extends JFrame {

    private JPanel mainPanel;

    @Autowired
    private MenuScreen menuScreen;

    @Autowired
    private MenuBar menuBar;

    private Screen currentScreen;

    public MainWindow() {
        super("Peeping tom");
        init();
    }

    @PostConstruct
    private void attachScreen() {
        changeScreen(menuScreen);
        mainPanel.add(menuBar, BorderLayout.NORTH);
        revalidate();
    }

    private void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        this.setSize(600, 600);//TODO: constants for window size and location
        this.setLocation(300, 300);

        mainPanel = new JPanel(new BorderLayout());
        this.setContentPane(mainPanel);
    }

    public void changeScreen(Screen newScreen) {
        if (newScreen == null) return;

        if (currentScreen != null) {
            mainPanel.remove(currentScreen);
        }

        mainPanel.add(newScreen, BorderLayout.CENTER);
        currentScreen = newScreen;
        SwingUtilities.updateComponentTreeUI(this);
    }
}
