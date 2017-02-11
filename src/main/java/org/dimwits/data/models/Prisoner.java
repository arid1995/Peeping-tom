package org.dimwits.data.models;

import javax.validation.constraints.NotNull;

/**
 * Created by farid on 2/3/17.
 */
public class Prisoner {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String patronymic;
    @NotNull
    private Integer birthYear;
    @NotNull
    private String birthPlace;
    @NotNull
    private String livingPlace;
    @NotNull
    private String prison;

    private String nickname = "";
    private String convictionInfo = "";
    private String additionalInfo = "";
    private String filePath = "";

    public Prisoner() {
    }

    public Prisoner(Integer id, String name, String surname, String patronymic, Integer birthYear, String birthPlace,
                    String livingPlace, String prison, String nickname, String convictionInfo, String additionalInfo,
                    String filePath) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
        this.livingPlace = livingPlace;
        this.prison = prison;
        this.nickname = nickname;
        this.convictionInfo = convictionInfo;
        this.additionalInfo = additionalInfo;
        this.filePath = filePath;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getLivingPlace() {
        return livingPlace;
    }

    public String getPrison() {
        return prison;
    }

    public String getNickname() {
        return nickname;
    }

    public String getConvictionInfo() {
        return convictionInfo;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setLivingPlace(String livingPlace) {
        this.livingPlace = livingPlace;
    }

    public void setPrison(String prison) {
        this.prison = prison;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setConvictionInfo(String convictionInfo) {
        this.convictionInfo = convictionInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }
}
