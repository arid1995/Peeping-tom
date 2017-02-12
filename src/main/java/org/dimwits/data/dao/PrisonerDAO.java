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

    private boolean checkRequired() {
        return !(prisoner.getSurname() == null ||
                prisoner.getName() == null ||
                prisoner.getPatronymic() == null ||
                prisoner.getBirthPlace() == null ||
                prisoner.getBirthYear() == null ||
                prisoner.getLivingPlace() == null ||
                prisoner.getPrison() == null);
    }

    public void persist() {
        try {
            if (!checkRequired()) return;

            Database.update("INSERT INTO prisoners (surname, firstName, patronymic, nickname, birthYear," +
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
        try {
            if (!checkRequired()) return;

            Database.update("UPDATE prisoners SET "
                    + "surname='" + prisoner.getSurname() + "',"
                    + "firstName='" + prisoner.getName() + "',"
                    + "patronymic='"+ prisoner.getPatronymic() + "',"
                    + "nickname='" + prisoner.getNickname() + "',"
                    + "birthYear=" + prisoner.getBirthYear() + ","
                    + "birthPlace='" + prisoner.getBirthPlace() + "',"
                    + "livingPlace='" + prisoner.getLivingPlace() + "',"
                    + "prison='" + prisoner.getPrison() + "',"
                    + "convictionInfo='" + prisoner.getConvictionInfo() + "',"
                    + "additionalInfo='" + prisoner.getAdditionalInfo() + "',"
                    + "fileLink='" + prisoner.getFilePath() + "' WHERE "
                    + "id=" + prisoner.getId() + ";"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void extractAllPrisoners(ResultSet result, ArrayList<Prisoner> prisoners) throws SQLException {
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
                            "patronymic='" + patronymic + "';", (result) -> { extractAllPrisoners(result, prisoners); });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByNickname(String nickname) {
        try {
            Database.select("SELECT * FROM prisoners WHERE " +
                    "nickname='" + nickname + "';", (result) -> { extractAllPrisoners(result, prisoners); });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByLivingPlace(String livingPlace) {
        try {
            Database.select("SELECT * FROM prisoners WHERE " +
                    "livingPlace='" + livingPlace + "';", (result) -> { extractAllPrisoners(result, prisoners); });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByLastName(String lastName) {
        try {
            Database.select("SELECT * FROM prisoners WHERE " +
                    "surname='" + lastName + "';", (result) -> { extractAllPrisoners(result, prisoners); });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByPrison(String prison) {
        try {
            Database.select("SELECT * FROM prisoners WHERE " +
                    "prison='" + prison + "';", (result) -> { extractAllPrisoners(result, prisoners); });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void linkTwoPrisoners(Prisoner prisoner1, Prisoner prisoner2) {
        try {
            Database.update("INSERT INTO links (prisoner1, prisoner2) " +
                    "values(" + prisoner1.getId() + ","
                    + prisoner2.getId() + ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Prisoner> getLinkedPrisoners() {
        final ArrayList<Prisoner> linkedPrisoners = new ArrayList<>();

        try {
            Database.select("SELECT DISTINCT * FROM prisoners INNER JOIN links ON " +
                    "links.prisoner1=prisoners.id OR " +
                    "links.prisoner2=prisoners.id WHERE " +
                    "prisoners.id=" + prisoner.getId(), (result) -> { extractAllPrisoners(result, linkedPrisoners); });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linkedPrisoners;
    }
}
