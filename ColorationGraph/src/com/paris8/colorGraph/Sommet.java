package com.paris8.colorGraph;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

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

    public  void CouleurCircle(Circle circle, int color)
    {
        if (color == 0) circle.setFill(javafx.scene.paint.Color.BLUE);

        else if (color == 1) circle.setFill(javafx.scene.paint.Color.RED);

        else if (color == 2) circle.setFill(javafx.scene.paint.Color.GOLD);

        else if (color == 3) circle.setFill(javafx.scene.paint.Color.GRAY);

        else if (color == 4) circle.setFill(javafx.scene.paint.Color.GREEN);

        else if (color == 5) circle.setFill(javafx.scene.paint.Color.MAGENTA);

        else if (color == 6) circle.setFill(javafx.scene.paint.Color.PINK);

        else if (color == 7) circle.setFill(javafx.scene.paint.Color.PURPLE);

        else if (color == 8) circle.setFill(javafx.scene.paint.Color.SILVER);

        else circle.setFill(javafx.scene.paint.Color.WHITE);
    }

    public void createCircle(Graphe graphe, int i, Pane canvas)
    {
        Circle circle = new Circle(20);
        circle.relocate(graphe.sommets.get(i).getPosX(), graphe.sommets.get(i).getPosY());
        CouleurCircle(circle, getCouleur());

        Label lbl = new Label(graphe.sommets.get(i).getNom());
        lbl.setFont(Font.font("Verdana", 20));
        lbl.setLayoutX(circle.getLayoutX() - circle.getRadius()/2 + 2);
        lbl.setLayoutY(circle.getLayoutY() - circle.getRadius()/2 - 2);


        canvas.getChildren().addAll(circle, lbl);
    }
}
