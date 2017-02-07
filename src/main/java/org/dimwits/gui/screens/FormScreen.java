package org.dimwits.gui.screens;

import org.dimwits.controllers.data.SaveDataAction;
import org.dimwits.data.Persistable;
import org.dimwits.data.dao.PrisonerDAO;
import org.dimwits.data.models.Prisoner;
import org.dimwits.gui.customized.CButton;
import org.dimwits.gui.customized.CLabel;
import org.dimwits.gui.customized.CTextField;
import org.dimwits.gui.utils.Collectable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created by farid on 2/1/17.
 */
@Service
public class FormScreen extends JPanel implements Collectable {
    @Autowired
    private MenuScreen menuScreen;

    private CTextField lastNameField;
    private CTextField firstNameField;
    private CTextField patronymicField;
    private CTextField nicknameField;
    private CTextField birthYearField;
    private CTextField birthPlaceField;
    private CTextField livingPlaceField;
    private CTextField prisonField;
    //TODO: Add conviction history, additional info and path to file

    private CButton saveButton;

    public FormScreen() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.weighty = 1;

        this.add(new CLabel("Анкета"), constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        this.add(new CLabel("Фамилия"), constraints);
        constraints.gridy = 2;
        this.add(new CLabel("Имя"), constraints);
        constraints.gridy = 3;
        this.add(new CLabel("Отчество"), constraints);
        constraints.gridy = 4;
        this.add(new CLabel("Кличка"), constraints);
        constraints.gridy = 5;
        this.add(new CLabel("Год рождения"), constraints);
        constraints.gridy = 6;
        this.add(new CLabel("Место рождения"), constraints);
        constraints.gridy = 7;
        this.add(new CLabel("Место жительства"), constraints);
        constraints.gridy = 8;
        this.add(new CLabel("Место содержания"), constraints);

        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        lastNameField = new CTextField();
        constraints.gridy = 1;
        this.add(lastNameField, constraints);

        firstNameField = new CTextField();
        constraints.gridy = 2;
        this.add(firstNameField, constraints);

        patronymicField = new CTextField();
        constraints.gridy = 3;
        this.add(patronymicField, constraints);

        nicknameField = new CTextField();
        constraints.gridy = 4;
        this.add(nicknameField, constraints);

        birthYearField = new CTextField();
        constraints.gridy = 5;
        this.add(birthYearField, constraints);

        birthPlaceField = new CTextField();
        constraints.gridy = 6;
        this.add(birthPlaceField, constraints);

        livingPlaceField = new CTextField();
        constraints.gridy = 7;
        this.add(livingPlaceField, constraints);

        prisonField = new CTextField();
        constraints.gridy = 8;
        this.add(prisonField, constraints);

        saveButton = new CButton("Сохранить");
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 2;
        this.add(saveButton, constraints);
    }

    @PostConstruct
    private void initializeControls() {
        saveButton.addActionListener(new SaveDataAction(this));
    }

    public Persistable collectData() {
        Prisoner prisoner = new Prisoner();

        prisoner.setName(firstNameField.getText());
        prisoner.setSurname(lastNameField.getText());
        prisoner.setPatronymic(patronymicField.getText());
        prisoner.setNickname(nicknameField.getText());
        prisoner.setBirthYear(Integer.parseInt(birthYearField.getText()));
        prisoner.setBirthPlace(birthPlaceField.getText());
        prisoner.setLivingPlace(livingPlaceField.getText());
        prisoner.setPrison(prisonField.getText());

        return new PrisonerDAO(prisoner);
    }
}
