package com.zeazonz.domain.model.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name  = "house_name")
    private String houseName;

    @Column(name  = "street")
    private String street;

    @Column(name  = "city")
    private String city;

    @Column(name  = "district")
    private String district;

    @Column(name  = "state")
    private String state;

    @Column(name  = "country")
    private String country;

    public Address() {
    }

    public Address(String houseName, String street, String city, String district, String state, String country) {
        this.houseName = houseName;
        this.street = street;
        this.city = city;
        this.district = district;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
