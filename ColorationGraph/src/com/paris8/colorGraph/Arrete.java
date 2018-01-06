package com.paris8.colorGraph;

public class Arrete {
    private Sommet sommet1;
    private Sommet sommet2;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Arrete(Sommet _1,Sommet _2){
        this.sommet1=_1;
        this.sommet2=_2;
    }

    public String get_info_arrete(int i)
    {
        return "L'arrete numéro " + i + " relie le sommet " + get_sommet1().getNom() + " au sommet " + get_sommet2().getNom();
    }

    public Sommet get_sommet1(){
        return sommet1;
    }

    public Sommet get_sommet2(){
        return sommet2;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }
}
