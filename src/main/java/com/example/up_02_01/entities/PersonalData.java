package com.example.up_02_01.entities;

import java.time.LocalDate;

public class PersonalData {
    private Long abiturientCode;

    private String abiturientSurname;
    private String abiturientName;
    private String abiturientPatronymic;
    private LocalDate abiturientBirthday;
    private String birthPlace;

    private String pasportSeria;
    private String pasportNumber;
    private String whoGavePasport;
    private LocalDate whenPassportGiven;

    private String birthCertificateNumber;
    private String birthCertificateSeria;
    private String whoGaveBirthCertificate;

    public PersonalData(String abiturientSurname, String abiturientName, String abiturientPatronymic, LocalDate abiturientBirthday, String birthPlace, String pasportSeria, String pasportNumber, String whoGavePasport, LocalDate whenPassportGiven, String birthCertificateNumber, String birthCertificateSeria, String whoGaveBirthCertificate) {
        this.abiturientSurname = abiturientSurname;
        this.abiturientName = abiturientName;
        this.abiturientPatronymic = abiturientPatronymic;
        this.abiturientBirthday = abiturientBirthday;
        this.birthPlace = birthPlace;
        this.pasportSeria = pasportSeria;
        this.pasportNumber = pasportNumber;
        this.whoGavePasport = whoGavePasport;
        this.whenPassportGiven = whenPassportGiven;
        this.birthCertificateNumber = birthCertificateNumber;
        this.birthCertificateSeria = birthCertificateSeria;
        this.whoGaveBirthCertificate = whoGaveBirthCertificate;
    }

    public Long getAbiturientCode() {
        return abiturientCode;
    }

    public void setAbiturientCode(Long abiturientCode) {
        this.abiturientCode = abiturientCode;
    }

    public String getAbiturientSurname() {
        return abiturientSurname;
    }

    public void setAbiturientSurname(String abiturientSurname) {
        this.abiturientSurname = abiturientSurname;
    }

    public String getAbiturientName() {
        return abiturientName;
    }

    public void setAbiturientName(String abiturientName) {
        this.abiturientName = abiturientName;
    }

    public String getAbiturientPatronymic() {
        return abiturientPatronymic;
    }

    public void setAbiturientPatronymic(String abiturientPatronymic) {
        this.abiturientPatronymic = abiturientPatronymic;
    }

    public LocalDate getAbiturientBirthday() {
        return abiturientBirthday;
    }

    public void setAbiturientBirthday(LocalDate abiturientBirthday) {
        this.abiturientBirthday = abiturientBirthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getPasportSeria() {
        return pasportSeria;
    }

    public void setPasportSeria(String pasportSeria) {
        this.pasportSeria = pasportSeria;
    }

    public String getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(String pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    public String getWhoGavePasport() {
        return whoGavePasport;
    }

    public void setWhoGavePasport(String whoGavePasport) {
        this.whoGavePasport = whoGavePasport;
    }

    public LocalDate getWhenPassportGiven() {
        return whenPassportGiven;
    }

    public void setWhenPassportGiven(LocalDate whenPassportGiven) {
        this.whenPassportGiven = whenPassportGiven;
    }

    public String getBirthCertificateNumber() {
        return birthCertificateNumber;
    }

    public void setBirthCertificateNumber(String birthCertificateNumber) {
        this.birthCertificateNumber = birthCertificateNumber;
    }

    public String getBirthCertificateSeria() {
        return birthCertificateSeria;
    }

    public void setBirthCertificateSeria(String birthCertificateSeria) {
        this.birthCertificateSeria = birthCertificateSeria;
    }

    public String getWhoGaveBirthCertificate() {
        return whoGaveBirthCertificate;
    }

    public void setWhoGaveBirthCertificate(String whoGaveBirthCertificate) {
        this.whoGaveBirthCertificate = whoGaveBirthCertificate;
    }
}
