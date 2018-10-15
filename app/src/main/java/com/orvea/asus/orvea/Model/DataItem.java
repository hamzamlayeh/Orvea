package com.orvea.asus.orvea.Model;

public class DataItem {

//    public String id;
    private int img_membre;
    private String nom_membre;
    private String etat_membre;


    public DataItem(int img_membre, String nom_membre, String etat_membre) {
        this.img_membre = img_membre;
        this.nom_membre = nom_membre;
        this.etat_membre = etat_membre;
    }

    public int getImg_membre() {
        return img_membre;
    }

    public void setImg_membre(int img_membre) {
        this.img_membre = img_membre;
    }

    public String getNom_membre() {
        return nom_membre;
    }

    public void setNom_membre(String nom_membre) {
        this.nom_membre = nom_membre;
    }

    public String getEtat_membre() {
        return etat_membre;
    }

    public void setEtat_membre(String etat_membre) {
        this.etat_membre = etat_membre;
    }
}
