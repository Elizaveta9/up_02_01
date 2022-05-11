package com.example.up_02_01.entities;

import com.example.up_02_01.service.AddressToString;

public class Parents implements AddressToString {
    private Long abiturientCode;
    private String family_status;
    private Integer children_amount;

    private String mother_name;
    private String mother_town;
    private Integer mother_house;
    private String mother_street;
    private Integer mother_room;
    private String mother_phone;
    private String mother_work;
    private String mother_address;

    private String father_name;
    private String father_town;
    private Integer father_house;
    private String father_street;
    private Integer father_room;
    private String father_work;
    private String father_phone;
    private String father_address;

    public Parents(String family_status, Integer children_amount, String mother_name, String mother_town, Integer mother_house, String mother_street, Integer mother_room, String mother_phone, String mother_work, String father_name, String father_town, Integer father_house, String father_street, Integer father_room, String father_work, String father_phone) {
        this.family_status = family_status;
        this.children_amount = children_amount;
        this.mother_name = mother_name;
        this.mother_town = mother_town;
        this.mother_house = mother_house;
        this.mother_street = mother_street;
        this.mother_room = mother_room;
        this.mother_phone = mother_phone;
        this.mother_work = mother_work;
        this.father_name = father_name;
        this.father_town = father_town;
        this.father_house = father_house;
        this.father_street = father_street;
        this.father_room = father_room;
        this.father_work = father_work;
        this.father_phone = father_phone;
        mother_address = getAddressString(mother_town, mother_street, mother_house, mother_room);
        father_address = getAddressString(father_town,father_street,father_house,father_room);
    }

    public Parents(String family_status, Integer children_amount, String mother_name, String mother_phone, String mother_work, String mother_address, String father_name, String father_work, String father_phone, String father_address) {
        this.family_status = family_status;
        this.children_amount = children_amount;
        this.mother_name = mother_name;
        this.mother_phone = mother_phone;
        this.mother_work = mother_work;
        this.mother_address = mother_address;
        this.father_name = father_name;
        this.father_work = father_work;
        this.father_phone = father_phone;
        this.father_address = father_address;
    }

    public String getMother_address() {
        return mother_address;
    }

    public void setMother_address(String mother_address) {
        this.mother_address = mother_address;
    }

    public String getFather_address() {
        return father_address;
    }

    public void setFather_address(String father_address) {
        this.father_address = father_address;
    }

    public Long getAbiturientCode() {
        return abiturientCode;
    }

    public void setAbiturientCode(Long abiturientCode) {
        this.abiturientCode = abiturientCode;
    }

    public String getFamily_status() {
        return family_status;
    }

    public void setFamily_status(String family_status) {
        this.family_status = family_status;
    }

    public Integer getChildren_amount() {
        return children_amount;
    }

    public void setChildren_amount(Integer children_amount) {
        this.children_amount = children_amount;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getMother_town() {
        return mother_town;
    }

    public void setMother_town(String mother_town) {
        this.mother_town = mother_town;
    }

    public Integer getMother_house() {
        return mother_house;
    }

    public void setMother_house(Integer mother_house) {
        this.mother_house = mother_house;
    }

    public String getMother_street() {
        return mother_street;
    }

    public void setMother_street(String mother_street) {
        this.mother_street = mother_street;
    }

    public Integer getMother_room() {
        return mother_room;
    }

    public void setMother_room(Integer mother_room) {
        this.mother_room = mother_room;
    }

    public String getMother_phone() {
        return mother_phone;
    }

    public void setMother_phone(String mother_phone) {
        this.mother_phone = mother_phone;
    }

    public String getMother_work() {
        return mother_work;
    }

    public void setMother_work(String mother_work) {
        this.mother_work = mother_work;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getFather_town() {
        return father_town;
    }

    public void setFather_town(String father_town) {
        this.father_town = father_town;
    }

    public Integer getFather_house() {
        return father_house;
    }

    public void setFather_house(Integer father_house) {
        this.father_house = father_house;
    }

    public String getFather_street() {
        return father_street;
    }

    public void setFather_street(String father_street) {
        this.father_street = father_street;
    }

    public Integer getFather_room() {
        return father_room;
    }

    public void setFather_room(Integer father_room) {
        this.father_room = father_room;
    }

    public String getFather_work() {
        return father_work;
    }

    public void setFather_work(String father_work) {
        this.father_work = father_work;
    }

    public String getFather_phone() {
        return father_phone;
    }

    public void setFather_phone(String father_phone) {
        this.father_phone = father_phone;
    }
}
