package com.paris8.colorGraph;

public class Sommet {
    private int numero;
    private String nom;
    private int couleur;
    private int x;
    private int y;

    public Sommet(int numero, String nom){
        this.setNumero(numero);
        this.setNom(nom);
    }

    public void setNumero(int numero){
        this.numero=numero;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public void setCouleur(int couleur){
        this.couleur=couleur;
    }

    public int getNumero(){
        return this.numero;
    }

    public String getNom(){
        return this.nom;
    }

    public int getCouleur(){
        return this.couleur;
    }


    public int getPosX(){
        return this.x;
    }

    public void setPosX(int x){
        this.x=x;
    }

    public int getPosY(){
        return this.y;
    }

    public void setPosY(int y){
        this.y=y;
    }
}
