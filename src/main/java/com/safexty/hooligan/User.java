package com.safexty.hooligan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class User {

    public static final List<User> users = new ArrayList<>();

    private final String firstname;
    private final String lastname;
    private String dispoCode;

    public User(String firstname, String lastname) {
        this(firstname, lastname, null);
    }
    public User(String firstname, String lastname, String dispoCode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dispoCode = dispoCode;
        users.add(this);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDispoCode() {
        return dispoCode;
    }

    public void setDispoCode(String dispoCode) {
        this.dispoCode = dispoCode;
    }

    public static Optional<User> findByName(String name) {
        return users.stream().filter(u -> u.getLastname().toLowerCase().contains(name.toLowerCase())).findAny();
    }
}
