package com.paris8.colorGraph;

import java.util.LinkedList;
import java.util.List;

public class Graphe {

    protected List<Sommet> sommets;
    protected List<Arrete> arrets;
    private int size=0;

    public int size(){
        return size;
    }

    public Graphe(Graphe g){
        this.sommets.addAll(g.sommets);
        this.arrets.addAll(g.arrets);
    }

    public Graphe(){
        sommets=new LinkedList<Sommet>();
        arrets=new LinkedList<Arrete>();
    }

    public void ajouterSommet(Sommet s){
        size++;
        sommets.add(s);

    }

    public boolean ajouterArret(Arrete a){
        return arrets.add(a);
    }

    public String get_info(Graphe g, int i){
        return "Votre sommet numéro " + sommets.get(i).getNumero() + " s'appelle : " + sommets.get(i).getNom() +
                "\nLe sommet " + arrets.get(i).get_sommet1().getNom() + " réagit avec le sommet " + arrets.get(i).get_sommet2().getNom();
    }
}
