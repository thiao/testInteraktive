package com.interaktive.test.model;
/**
 * Created by bass on 16/11/2018.
 */
public class Usssd {
    private String name;
    private String ussdCode;

    public Usssd(String name, String ussdCode) {
        this.name = name;
        this.ussdCode = ussdCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUssdCode() {
        return ussdCode;
    }

    public void setUssdCode(String ussdCode) {
        this.ussdCode = ussdCode;
    }
}
