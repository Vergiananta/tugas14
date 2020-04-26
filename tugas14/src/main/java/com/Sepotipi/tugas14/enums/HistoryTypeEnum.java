package com.Sepotipi.tugas14.enums;

public enum HistoryTypeEnum {
   TOPUP("topup"), PAYMENT("payment"), WITHDRAWAL("withdrawal");

   private String value;

    HistoryTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
