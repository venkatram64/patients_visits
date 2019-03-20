package com.srijan.model;

import java.io.Serializable;

public class Illness implements Serializable {

    private String illnessType;
    private String description;

    public Illness(){}

    public Illness(String illnessType, String description) {
        this.illnessType = illnessType;
        this.description = description;
    }

    public String getIllnessType() {
        return illnessType;
    }

    public void setIllnessType(String illnessType) {
        this.illnessType = illnessType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
