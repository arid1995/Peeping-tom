package org.dimwits.gui.screens;

import org.dimwits.controllers.menu.ChangeScreenAction;
import org.dimwits.data.models.Prisoner;
import org.dimwits.gui.MainWindow;
import org.dimwits.gui.customized.CButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created by farid on 1/31/17.
 * Screen containing menu
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Service
public class MenuScreen extends Screen {

    @Autowired
    private MainWindow mainWindow;

    @Autowired
    private FormScreen formScreen;

    @Autowired
    private SearchScreen searchScreen;

    private JButton searchDatabaseButton;
    private JButton goToRegionsButton;
    private JButton addNewInfoButton;
    private JButton editOldRecordsButton;
    private JButton linkRecordsButton;

    public MenuScreen() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        searchDatabaseButton = new CButton("Поиск по базе");
        constraints.gridx = 0;
        constraints.gridy = 0; this.setLayout(new GridBagLayout());
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(40, 40, 0, 40);
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

        this.pushHistory();
    }

    @PostConstruct
    private void initializeControls() {
        addNewInfoButton.addActionListener(new ChangeScreenAction(formScreen, mainWindow));
        searchDatabaseButton.addActionListener(new ChangeScreenAction(searchScreen, mainWindow));
    }
}
