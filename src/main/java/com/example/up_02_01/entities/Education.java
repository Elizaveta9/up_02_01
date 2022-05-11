package com.example.up_02_01.entities;

public class Education {
    private Long abiturientCode;
    private String educationLevel;
    private String attesstatNumber;
    private Float grade;
    private String specialityName;
    private String specialityCode;

    public Education(String educationLevel, String attesstatNumber, Float grade, String specialityName, String specialityCode) {
        this.educationLevel = educationLevel;
        this.attesstatNumber = attesstatNumber;
        this.grade = grade;
        this.specialityName = specialityName;
        this.specialityCode = specialityCode;
    }

    public Long getAbiturientCode() {
        return abiturientCode;
    }

    public void setAbiturientCode(Long abiturientCode) {
        this.abiturientCode = abiturientCode;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getAttesstatNumber() {
        return attesstatNumber;
    }

    public void setAttesstatNumber(String attesstatNumber) {
        this.attesstatNumber = attesstatNumber;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getSpecialityCode() {
        return specialityCode;
    }

    public void setSpecialityCode(String specialityCode) {
        this.specialityCode = specialityCode;
    }
}
