package org.dimwits.data.dao;

import org.dimwits.data.Persistable;
import org.dimwits.data.models.Prisoner;
import org.dimwits.data.utils.Database;

import java.sql.SQLException;

/**
 * Created by farid on 2/3/17.
 */
public class PrisonerDAO implements Persistable{
    private Prisoner prisoner;

    public PrisonerDAO() {

    }

    public PrisonerDAO(Prisoner prisoner) {
        this.prisoner = prisoner;
    }

    public Prisoner getPrisoner() {
        return prisoner;
    }

    public void setPrisoner(Prisoner prisoner) {
        this.prisoner = prisoner;
    }

    public void persist() {
        try {
            Database.update("INSERT INTO PRISONERS (surname, firstName, patronymic, nickname, birthYear," +
                    " birthPlace, livingPlace, prison, convictionInfo, additionalInfo, fileLink) " +
                    "values('" + prisoner.getSurname() + "','"
                    + prisoner.getName() + "','"
                    + prisoner.getPatronymic() + "','"
                    + prisoner.getNickname() + "',"
                    + prisoner.getBirthYear() + ",'"
                    + prisoner.getBirthPlace() + "','"
                    + prisoner.getLivingPlace() + "','"
                    + prisoner.getPrison() + "','"
                    + prisoner.getConvictionInfo() + "','"
                    + prisoner.getAdditionalInfo() + "','"
                    + prisoner.getFilePath() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update() {

    }

    public void findByFullName(String firstName, String lastName, String patronymic) {

    }

    public void findByNickname(String nickname) {

    }

    public void findByLivingPlace(String livingPlace) {
    }

    public void findByLastName(String lastName) {

    }

    public void findByPrison(String prison) {

    }
}
