package com.interaktive.test.model;

/**
 * Created by bass on 16/11/2018.
 */

public class OperateurTel {
   private String name;
   private String solde;
   private int imageId;

    public OperateurTel(String name, String solde, int imageId) {
        this.name = name;
        this.solde = solde;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
