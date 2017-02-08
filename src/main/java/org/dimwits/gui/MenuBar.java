package org.dimwits.gui;

import org.dimwits.controllers.menu.GoBackAction;
import org.dimwits.gui.customized.CButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created by farid on 2/1/17.
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Service
public class MenuBar extends JPanel {

    @Autowired
    private MainWindow mainWindow;

    private CButton goBackButton;

    public MenuBar() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;

        goBackButton = new CButton("Назад");
        this.add(goBackButton, constraints);
    }

    @PostConstruct
    private void initialiseControls() {
        goBackButton.addActionListener(new GoBackAction(mainWindow));
    }
}
