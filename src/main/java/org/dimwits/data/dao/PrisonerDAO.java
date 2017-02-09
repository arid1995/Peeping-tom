package org.dimwits.data.dao;

import org.dimwits.data.Persistable;
import org.dimwits.data.models.Prisoner;
import org.dimwits.data.utils.Database;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by farid on 2/3/17.
 */
public class PrisonerDAO implements Persistable{
    private Prisoner prisoner;
    private final ArrayList<Prisoner> prisoners = new ArrayList<>();

    public PrisonerDAO() {

    }

    public PrisonerDAO(Prisoner prisoner) {
        this.prisoner = prisoner;
    }

    public Prisoner getPrisoner() {
        return prisoner;
    }

    public ArrayList<Prisoner> getPrisoners() {
        return prisoners;
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

    private void extractAllPrisoners(ResultSet result) throws SQLException {
        while (result.next()) {
            prisoners.add(new Prisoner(result.getInt("id"),
                    result.getString("firstName"),
                    result.getString("surname"),
                    result.getString("patronymic"),
                    result.getInt("birthYear"),
                    result.getString("birthPlace"),
                    result.getString("livingPlace"),
                    result.getString("prison"),
                    result.getString("nickname"),
                    result.getString("convictionInfo"),
                    result.getString("additionalInfo"),
                    result.getString("fileLink"))
            );
        }
    }

    public void findByFullName(String firstName, String lastName, String patronymic) {
        try {
            Database.select("SELECT * FROM prisoners WHERE " +
                            "firstName='" + firstName + "' AND " +
                            "surname='" + lastName + "' AND " +
                            "patronymic='" + patronymic + "';", this::extractAllPrisoners);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByNickname(String nickname) {
        try {
            Database.select("SELECT * FROM prisoners WHERE " +
                    "nickname='" + nickname + "';", this::extractAllPrisoners);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByLivingPlace(String livingPlace) {
        try {
            Database.select("SELECT * FROM prisoners WHERE " +
                    "livingPlace='" + livingPlace + "';", this::extractAllPrisoners);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByLastName(String lastName) {
        try {
            Database.select("SELECT * FROM prisoners WHERE " +
                    "surname='" + lastName + "';", this::extractAllPrisoners);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByPrison(String prison) {
        try {
            Database.select("SELECT * FROM prisoners WHERE " +
                    "prison='" + prison + "';", this::extractAllPrisoners);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
