package org.dimwits.gui.screens;

import org.dimwits.gui.customized.CButton;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

/**
 * Created by farid on 2/1/17.
 */
@Service
public class FormScreen extends JPanel{
    private JButton searchDatabaseButton;

    public FormScreen() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        searchDatabaseButton = new CButton("Успех");
        constraints.gridx = 0;
        constraints.gridy = 0; this.setLayout(new GridBagLayout());
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        this.add(searchDatabaseButton, constraints);
    }
}
