package com.paris8.colorGraph;

import com.sun.prism.paint.Color;
import javafx.scene.shape.Circle;

public class Info {

    int nbre_sommet;

    public int getNbreSommet()
    {
        return nbre_sommet;
    }

    public void setNbreSommet(int nbre_sommet)
    {
        this.nbre_sommet = nbre_sommet;
    }

    public void placeSommet(Graphe graphe, int nbreSom)
    {

        int posX = 0;
        int posY = 0;

        if (nbreSom == 2)
        {
            for (int i = 1; i < nbreSom; i++) {
                int k = graphe.sommets.get(i - 1).getPosX();
                int l = graphe.sommets.get(i - 1).getPosY() + 300;

                graphe.sommets.get(i).setPosX(k);
                graphe.sommets.get(i).setPosY(l);
            }

        } else if (nbreSom == 3) {



            for (int i = 1; i < nbreSom; i++) {
                if(i == 1)
                {
                    posX = 250;
                    posY = 300;
                } else {
                    posX = -250 * 2;
                    posY = 0;
                }
                int k = graphe.sommets.get(i - 1).getPosX() + posX;
                int l = graphe.sommets.get(i - 1).getPosY() + posY;

                graphe.sommets.get(i).setPosX(k);
                graphe.sommets.get(i).setPosY(l);
            }

        } else if (nbreSom == 4) {

            for (int i = 1; i < nbreSom; i++) {
                if (i == 1) {
                    posX = 250;
                    posY = 250;
                } else if (i == 2) {
                    posX = -250 * 2;
                    posY = 0;
                } else {
                    posX = 250;
                    posY = 250;
                }
                int k = graphe.sommets.get(i - 1).getPosX() + posX;
                int l = graphe.sommets.get(i - 1).getPosY() + posY;

                graphe.sommets.get(i).setPosX(k);
                graphe.sommets.get(i).setPosY(l);
            }

        } else if (nbreSom == 5) {

            for (int i = 1; i < nbreSom; i++) {
                if (i == 1) {
                    posX = 250;
                    posY = 200;
                } else if (i == 2) {
                    posX = 150;
                    posY = 400;
                } else if (i == 3){
                    posX = -150;
                    posY = 400;
                } else {
                    posX = -250;
                    posY = 200;
                }
                int k = graphe.sommets.get(0).getPosX() + posX;
                int l = graphe.sommets.get(0).getPosY() + posY;

                graphe.sommets.get(i).setPosX(k);
                graphe.sommets.get(i).setPosY(l);
            }

        } else if (nbreSom == 6) {

            for (int i = 1; i < nbreSom; i++) {
                if (i == 1) {
                    posX = 150;
                    posY = 150;
                } else if (i == 2) {
                    posX = 150;
                    posY = 300;
                } else if (i == 3){
                    posX = 0;
                    posY = 450;
                } else if(i == 4){
                    posX = -150;
                    posY = 300;
                } else {
                    posX = -150;
                    posY = 150;
                }
                int k = graphe.sommets.get(0).getPosX() + posX;
                int l = graphe.sommets.get(0).getPosY() + posY;

                graphe.sommets.get(i).setPosX(k);
                graphe.sommets.get(i).setPosY(l);
            }

        } else if (nbreSom == 7) {
            for (int i = 1; i < nbreSom; i++) {
                if (i == 1) {
                    posX = 250;
                    posY = 150;
                } else if (i == 2) {
                    posX = 250;
                    posY = 300;
                } else if (i == 3){
                    posX = 150;
                    posY = 450;
                } else if(i == 4){
                    posX = -150;
                    posY = 450;
                } else if (i == 5){
                    posX = -250;
                    posY = 300;
                } else {
                    posX = -250;
                    posY = 150;
                }
                int k = graphe.sommets.get(0).getPosX() + posX;
                int l = graphe.sommets.get(0).getPosY() + posY;

                graphe.sommets.get(i).setPosX(k);
                graphe.sommets.get(i).setPosY(l);
            }

        } else if (nbreSom == 8) {
            for (int i = 1; i < nbreSom; i++) {
                if (i == 1) {
                    posX = 200;
                    posY = 125;
                } else if (i == 2) {
                    posX = 250;
                    posY = 275;
                } else if (i == 3){
                    posX = 200;
                    posY = 400;
                } else if(i == 4){
                    posX = 0;
                    posY = 525;
                } else if (i == 5){
                    posX = -200;
                    posY = 400;
                } else if (i == 6){
                    posX = -250;
                    posY = 275;
                } else {
                    posX = -200;
                    posY = 125;
                }
                int k = graphe.sommets.get(0).getPosX() + posX;
                int l = graphe.sommets.get(0).getPosY() + posY;

                graphe.sommets.get(i).setPosX(k);
                graphe.sommets.get(i).setPosY(l);
            }

        } else if (nbreSom == 9) {
            for (int i = 1; i < nbreSom; i++) {
                if (i == 1) {
                    posX = 200;
                    posY = 125;
                } else if (i == 2) {
                    posX = 250;
                    posY = 275;
                } else if (i == 3){
                    posX = 200;
                    posY = 400;
                } else if(i == 4){
                    posX = 100;
                    posY = 525;
                } else if (i == 5){
                    posX = -100;
                    posY = 525;
                } else if (i == 6){
                    posX = -200;
                    posY = 400;
                } else if (i == 7){
                    posX = -250;
                    posY = 275;
                } else {
                    posX = -200;
                    posY = 125;
                }

                int k = graphe.sommets.get(0).getPosX() + posX;
                int l = graphe.sommets.get(0).getPosY() + posY;

                graphe.sommets.get(i).setPosX(k);
                graphe.sommets.get(i).setPosY(l);
            }

        } else if (nbreSom == 10) {

            for (int i = 1; i < nbreSom; i++) {
                if (i == 1) {
                    posX = 200;
                    posY = 100;
                } else if (i == 2) {
                    posX = 250;
                    posY = 200;
                } else if (i == 3){
                    posX = 250;
                    posY = 300;
                } else if(i == 4){
                    posX = 200;
                    posY = 400;
                } else if (i == 5){
                    posX = 0;
                    posY = 500;
                } else if (i == 6){
                    posX = -200;
                    posY = 400;
                } else if (i == 7){
                    posX = -250;
                    posY = 300;
                } else if (i == 8){
                    posX = -250;
                    posY = 200;
                } else {
                    posX = -200;
                    posY = 100;
                }

                int k = graphe.sommets.get(0).getPosX() + posX;
                int l = graphe.sommets.get(0).getPosY() + posY;

                graphe.sommets.get(i).setPosX(k);
                graphe.sommets.get(i).setPosY(l);
            }

        } else if (nbreSom == 11) {

        } else if (nbreSom == 12) {

        } else if (nbreSom == 13) {

        } else if (nbreSom == 14) {

        }

    }


}
