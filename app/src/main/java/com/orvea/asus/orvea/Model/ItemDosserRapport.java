package com.orvea.asus.orvea.Model;

/**
 * Created by user on 08/10/2018.
 */

public class ItemDosserRapport {
    private String NomProjet;
    private String Image;

    public ItemDosserRapport(String nomProjet, String image) {
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
