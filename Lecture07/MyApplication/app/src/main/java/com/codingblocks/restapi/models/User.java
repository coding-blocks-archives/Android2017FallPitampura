package com.codingblocks.restapi.models;

/**
 * Created by arnav on 9/10/2017.
 */

public class User {
    Integer id;
    String name, username, email;
    Address address;

    public User(Integer id, String name, String username, String email, Address address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
