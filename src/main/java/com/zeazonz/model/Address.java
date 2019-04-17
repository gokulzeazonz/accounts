package com.zeazonz.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String houseName;

    private String street;

    private String city;

    private String state;

    private String country;

    public Address() {
    }

    public Address(String houseName, String street, String city, String state, String country) {
        this.houseName = houseName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
