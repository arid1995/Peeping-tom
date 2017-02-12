package org.dimwits.gui.screens;

import org.dimwits.controllers.data.FindDataAction;
import org.dimwits.data.dao.PrisonerDAO;
import org.dimwits.data.models.Prisoner;
import org.dimwits.gui.MainWindow;
import org.dimwits.gui.customized.CButton;
import org.dimwits.gui.customized.CLabel;
import org.dimwits.gui.customized.CTextField;
import org.dimwits.gui.utils.Visualizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by farid on 2/7/17.
 */
@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "unchecked"})
@Service
public class SearchScreen extends Screen implements Visualizer {

    @Autowired
    PrisonerScreen prisonerScreen;

    @Autowired
    MainWindow mainWindow;

    private JTabbedPane searchOptions;

    private CTextField surnameField;
    private CTextField nicknameField;
    private CTextField livingPlaceField;
    private CTextField prisonField;
    private CTextField firstNameField;
    private CTextField lastNameField;
    private CTextField patronymicField;

    private CButton searchButton;

    private JList<Prisoner> foundPrisonersList;
    private DefaultListModel<Prisoner> listModel;
    private boolean isActiveList = true;

    public SearchScreen(MainWindow mainWindow) {
        this();
        this.mainWindow = mainWindow;
    }

    public SearchScreen(boolean isActiveList) {
        this();
        this.isActiveList = isActiveList;
    }

    public SearchScreen() {
        searchOptions = new JTabbedPane();
        JPanel searchByFullNameScreen = new JPanel(new GridBagLayout());
        JPanel searchByLivingPlaceScreen = new JPanel(new GridBagLayout());
        JPanel searchByNicknameScreen = new JPanel(new GridBagLayout());
        JPanel searchByPrisonScreen = new JPanel(new GridBagLayout());
        JPanel searchBySurnameScreen = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.weighty = 1;

        //Search by full name screen filling
        searchByFullNameScreen.add(new CLabel("Фамилия"), constraints);
        constraints.gridy = 1;
        searchByFullNameScreen.add(new CLabel("Имя"), constraints);
        constraints.gridy = 2;
        searchByFullNameScreen.add(new CLabel("Отчество"), constraints);

        constraints.weightx = 1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        lastNameField = new CTextField(true);
        searchByFullNameScreen.add(lastNameField, constraints);

        constraints.gridy = 1;
        firstNameField = new CTextField(true);
        searchByFullNameScreen.add(firstNameField, constraints);

        constraints.gridy = 2;
        patronymicField = new CTextField(true);
        searchByFullNameScreen.add(patronymicField, constraints);

        //Search by living place screen filling
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        searchByLivingPlaceScreen.add(new CLabel("Место жительство"), constraints);

        constraints.weightx = 1;
        constraints.gridx = 1;
        livingPlaceField = new CTextField(true);
        searchByLivingPlaceScreen.add(livingPlaceField, constraints);

        //Search by nickname screen filling
        constraints.gridx = 0;
        constraints.weightx = 0.5;
        searchByNicknameScreen.add(new CLabel("Кличка"), constraints);

        constraints.weightx = 1;
        constraints.gridx = 1;
        nicknameField = new CTextField(true);
        searchByNicknameScreen.add(nicknameField, constraints);

        //Search by prison screen filling
        constraints.gridx = 0;
        constraints.weightx = 0.5;
        searchByPrisonScreen.add(new CLabel("Место содержания"), constraints);

        constraints.weightx = 1;
        constraints.gridx = 1;
        prisonField = new CTextField(true);
        searchByPrisonScreen.add(prisonField, constraints);

        //Search by surname screen filling
        constraints.gridx = 0;
        constraints.weightx = 0.5;
        searchBySurnameScreen.add(new CLabel("Фамилия"), constraints);

        constraints.weightx = 1;
        constraints.gridx = 1;
        surnameField = new CTextField(true);
        searchBySurnameScreen.add(surnameField, constraints);

        //Setting interchangable screens
        searchOptions.addTab("По Фамилии", searchBySurnameScreen);
        searchOptions.addTab("По ФИО", searchByFullNameScreen);
        searchOptions.addTab("По кличке", searchByNicknameScreen);
        searchOptions.addTab("По месту жительства", searchByLivingPlaceScreen);
        searchOptions.addTab("По месту содержания", searchByPrisonScreen);

        this.setLayout(new GridBagLayout());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(searchOptions, constraints);

        searchButton = new CButton("Найти");
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(searchButton, constraints);

        constraints.gridy = 2;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        listModel = new DefaultListModel<>();
        foundPrisonersList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(foundPrisonersList);
        this.add(scrollPane, constraints);

        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList<Prisoner> list = (JList<Prisoner>) e.getSource();
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        goToPrisoner(listModel.elementAt(index));
                    }
                }
            }
        };

        searchButton.addActionListener(new FindDataAction(this));
        foundPrisonersList.addMouseListener(mouseListener);
    }

    public void visualize() {
        listModel.clear();
        PrisonerDAO prisonerDAO = new PrisonerDAO();

        int currentTab = searchOptions.getSelectedIndex();

        switch (currentTab) {
            case 0:
                prisonerDAO.findByLastName(surnameField.getText());
                break;
            case 1:
                prisonerDAO.findByFullName(firstNameField.getText(), lastNameField.getText(), patronymicField.getText());
                break;
            case 2:
                prisonerDAO.findByNickname(nicknameField.getText());
                break;
            case 3:
                prisonerDAO.findByLivingPlace(livingPlaceField.getText());
                break;
            case 4:
                prisonerDAO.findByPrison(prisonField.getText());
                break;
        }

        ArrayList<Prisoner> prisoners = prisonerDAO.getPrisoners();

        for (Prisoner prisoner : prisoners) {
            listModel.addElement(prisoner);
        }
    }

    private void goToPrisoner(Prisoner prisoner) {
        if (!isActiveList) return;
        prisonerScreen.setPrisoner(prisoner);
        mainWindow.changeScreen(prisonerScreen);
        this.pushHistory();
    }

    public void setActiveList(boolean isActiveList) {
        this.isActiveList = isActiveList;
    }

    public Prisoner getSelectedPrisoner() {
        if (foundPrisonersList.getSelectedIndex() < 0) return null;
        return listModel.elementAt(foundPrisonersList.getSelectedIndex());
    }
}
