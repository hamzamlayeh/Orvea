package com.orvea.asus.orvea.DAO;

/**
 * Created by user on 08/10/2018.
 */

public class ItemDosserPhoto {
    private String NomProjet;
    private String Image;

    public ItemDosserPhoto(String nomProjet, String image) {
        NomProjet = nomProjet;
        Image = image;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }


    public String getNomProjet() {
        return NomProjet;
    }

    public void setNomProjet(String nomProjet) {
        NomProjet = nomProjet;
    }

}
