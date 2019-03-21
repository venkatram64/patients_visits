package com.srijan.model;

import java.io.Serializable;

public class Doctor implements Serializable {

    private String name;
    private String email;
    private String specialist;

    public Doctor() {

    }

    public Doctor(String name, String email, String specialist) {
        this.name = name;
        this.email = email;
        this.specialist = specialist;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialist() {
        return specialist;
    }
}
