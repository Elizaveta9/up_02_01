package com.example.up_02_01.service;

public interface AddressToString {
    default String getAddressString(String town, String street, Integer house, Integer room) {
        return "г. " + town + ", ул. " + street + " " + house + "-" + room;
    }
}
