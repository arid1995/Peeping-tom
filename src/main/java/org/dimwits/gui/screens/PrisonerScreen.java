package org.dimwits.gui.screens;

import org.dimwits.controllers.data.SaveDataAction;
import org.dimwits.controllers.data.UpdateDataAction;
import org.dimwits.data.Persistable;
import org.dimwits.data.dao.PrisonerDAO;
import org.dimwits.data.models.Prisoner;
import org.dimwits.gui.customized.*;
import org.dimwits.gui.utils.Collectable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created by farid on 2/7/17.
 */
@Service
public class PrisonerScreen extends Screen implements Collectable {
    private CTextField lastNameField;
    private CTextField firstNameField;
    private CTextField patronymicField;
    private CTextField nicknameField;
    private NumberField birthYearField;
    private CTextField birthPlaceField;
    private CTextField livingPlaceField;
    private CTextField prisonField;
    private CTextArea convictionHistoryField;
    private CTextArea additionalInfoField;
    private CTextArea filePathField;
    //TODO: Add conviction history, additional info and path to file

    private CButton updateButton;
    Prisoner prisoner;

    public PrisonerScreen() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.weighty = 1;
        constraints.ipadx = 50;

        this.add(new CLabel("Человек"), constraints);

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
        constraints.gridy = 9;
        this.add(new CLabel("История судимости"), constraints);
        constraints.gridy = 10;
        this.add(new CLabel("Дополнительная информация"), constraints);
        constraints.gridy = 11;
        this.add(new CLabel("Путь к файлу"), constraints);

        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        lastNameField = new CTextField(true);
        constraints.gridy = 1;
        this.add(lastNameField, constraints);

        firstNameField = new CTextField(true);
        constraints.gridy = 2;
        this.add(firstNameField, constraints);

        patronymicField = new CTextField(true);
        constraints.gridy = 3;
        this.add(patronymicField, constraints);

        nicknameField = new CTextField();
        constraints.gridy = 4;
        this.add(nicknameField, constraints);

        birthYearField = new NumberField(true);
        constraints.gridy = 5;
        this.add(birthYearField, constraints);

        birthPlaceField = new CTextField(true);
        constraints.gridy = 6;
        this.add(birthPlaceField, constraints);

        livingPlaceField = new CTextField(true);
        constraints.gridy = 7;
        this.add(livingPlaceField, constraints);

        prisonField = new CTextField(true);
        constraints.gridy = 8;
        this.add(prisonField, constraints);

        convictionHistoryField = new CTextArea();
        convictionHistoryField.setLineWrap(true);
        constraints.gridy = 9;
        this.add(convictionHistoryField, constraints);

        additionalInfoField = new CTextArea();
        additionalInfoField.setLineWrap(true);
        constraints.gridy = 10;
        this.add(additionalInfoField, constraints);

        filePathField = new CTextArea();
        filePathField.setLineWrap(true);
        constraints.gridy = 11;
        this.add(filePathField, constraints);

        updateButton = new CButton("Обновить");
        constraints.gridx = 0;
        constraints.gridy = 12;
        constraints.gridwidth = 2;
        this.add(updateButton, constraints);
    }

    @PostConstruct
    private void initializeControls() {
        updateButton.addActionListener(new UpdateDataAction(this));
    }

    @SuppressWarnings("Duplicates")
    public Persistable collectData() {
        prisoner.setName(firstNameField.getText());
        prisoner.setSurname(lastNameField.getText());
        prisoner.setPatronymic(patronymicField.getText());
        prisoner.setNickname(nicknameField.getText());
        prisoner.setBirthYear(birthYearField.getNumber());
        prisoner.setBirthPlace(birthPlaceField.getText());
        prisoner.setLivingPlace(livingPlaceField.getText());
        prisoner.setPrison(prisonField.getText());
        prisoner.setConvictionInfo(convictionHistoryField.getText());
        prisoner.setAdditionalInfo(additionalInfoField.getText());
        prisoner.setFilePath(filePathField.getText());

        return new PrisonerDAO(prisoner);
    }

    public void setPrisoner(Prisoner prisoner) {
        firstNameField.setText(prisoner.getName());
        lastNameField.setText(prisoner.getSurname());
        patronymicField.setText(prisoner.getPatronymic());
        nicknameField.setText(prisoner.getNickname());
        birthYearField.setText(prisoner.getBirthYear().toString());
        birthPlaceField.setText(prisoner.getBirthPlace());
        livingPlaceField.setText(prisoner.getLivingPlace());
        prisonField.setText(prisoner.getPrison());
        convictionHistoryField.setText(prisoner.getConvictionInfo());
        additionalInfoField.setText(prisoner.getAdditionalInfo());
        filePathField.setText(prisoner.getFilePath());

        this.prisoner = prisoner;
    }
}
