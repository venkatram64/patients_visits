package com.srijan.model;

public enum IllnessType {

    FEVER("fever"),
    HEAD_ACHE("head ache"),
    STOMACH_ACHE("Stomach ache"),
    KNEE_PAIN("body pain"),
    BACK_PAIN("Back pain"),
    DIAIRHOEA("diairhoea"),
    COUGH("Cough");

    private String type;

    IllnessType(String type){
        this.type = type;
    }

    public String getName(){
        return this.type;
    }
}
