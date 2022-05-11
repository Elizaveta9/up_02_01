package com.example.up_02_01.entities;

import com.example.up_02_01.service.AddressToString;

import java.time.LocalDate;

public class Abiturient implements AddressToString {
    private Long code;
    private String fullname;
    private LocalDate birthday;
    private String phoneNumber;
    private String town;
    private String street;
    private Integer homeNumber;
    private Integer roomNumber;
    private String address;

    public Abiturient(String fullname, LocalDate birthday, String phoneNumber, String town, String street, Integer homeNumber, Integer roomNumber) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.town = town;
        this.street = street;
        this.homeNumber = homeNumber;
        this.roomNumber = roomNumber;
        address = getAddressString(town,street,homeNumber,roomNumber);
    }

    public Abiturient(String fullname, LocalDate birthday, String phoneNumber, String address) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(Integer homeNumber) {
        this.homeNumber = homeNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
