package com.orvea.asus.orvea.Model;

/**
 * Created by user on 08/10/2018.
 */

public class ItemDosserPhoto {
    private String NomUser;
    private String Photo;

    public ItemDosserPhoto(String nomProjet, String image) {
        NomUser = nomProjet;
        Photo = image;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String image) {
        Photo = image;
    }


    public String getNomUser() {
        return NomUser;
    }

    public void setNomUser(String nomProjet) {
        NomUser = nomProjet;
    }

}
