package org.dimwits.gui.screens;

import org.dimwits.gui.customized.CButton;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

/**
 * Created by farid on 1/31/17.
 * Screen containing menu
 */
@Service
public class MenuScreen extends JPanel {

    JButton searchDatabaseButton;
    JButton goToRegionsButton;
    JButton addNewInfoButton;
    JButton editOldRecordsButton;
    JButton linkRecordsButton;

    public MenuScreen() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        searchDatabaseButton = new CButton("Поиск по базе");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        this.add(searchDatabaseButton, constraints);

        goToRegionsButton = new CButton("Перейти к списку регионов");
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(goToRegionsButton, constraints);

        addNewInfoButton = new CButton("Добавить новую запись");
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(addNewInfoButton, constraints);

        editOldRecordsButton = new CButton("Редактировать");
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(editOldRecordsButton, constraints);

        linkRecordsButton = new CButton("Создать связь");
        constraints.gridx = 0;
        constraints.gridy = 4;
        this.add(linkRecordsButton, constraints);
    }
}
