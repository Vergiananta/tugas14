package com.Sepotipi.tugas14.enums;

public enum GenderEnum {
    MALE("male"),
    FEMALE("female");

    private String value;

    GenderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
