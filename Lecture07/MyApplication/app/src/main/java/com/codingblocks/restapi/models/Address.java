package com.codingblocks.restapi.models;

/**
 * Created by arnav on 9/10/2017.
 */

public class Address {
    String city, zipcode;

    public Address(String city, String zipcode) {
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }
}
