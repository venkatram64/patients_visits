package com.srijan.model;

import java.io.Serializable;

public class Medicine implements Serializable {

    private String illnessType;
    private String medicine;
    private String prevention;

    public Medicine(){}

    public Medicine(String illnessType, String medicine, String prevention) {
        this.illnessType = illnessType;
        this.medicine = medicine;
        this.prevention = prevention;
    }

    public String getIllnessType() {
        return illnessType;
    }

    public void setIllnessType(String illnessType) {
        this.illnessType = illnessType;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }
}

