package com.example.all4sport;

public class Item {
    String nom;
    int photo;
    String quantite;

    public Item(String nom, int photo, String quantite) {
        this.nom = nom;
        this.photo = photo;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
}
