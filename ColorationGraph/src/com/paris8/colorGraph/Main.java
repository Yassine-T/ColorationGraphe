package com.paris8.colorGraph;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application{


    Stage window;
    Scene scene, scene1, scene2, scene3, scene4;
    TextField tf_sommet1, tf_sommet2, tf_nbre;
    Label lbl_nbre_sommet;
    int nbre_s;
    private static Graphe graphe;
    Info info;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Coloration de Graphe");

        info = new Info();
        graphe = new Graphe();


        selectNbreSommet();


        window.setScene(scene1);

        window.show();

    }



    public void selectNbreSommet()
    {
        Button btn_valider_nbre = new Button("Valider");

        Label txt = new Label("Cas pratique : Nous cherchons à colorier sur une carte les villes adjacentes");

        Label txt2 = new Label("Choisissez le nombre de ville à colorier : ");

        tf_nbre = new TextField();
        tf_nbre.setPromptText("Nombre de ville");

        HBox hbox1 = new HBox(10);
        hbox1.getChildren().addAll(txt2, tf_nbre, btn_valider_nbre);
        hbox1.setPadding(new Insets(20, 20, 20, 20));

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(txt, hbox1);
        vbox.setPadding(new Insets(20, 20, 20, 20));

        btn_valider_nbre.setOnAction(e -> {

            if (isInt(tf_nbre, tf_nbre.getText())) {



                nbre_s = Integer.parseInt(tf_nbre.getText());

                info.setNbreSommet(nbre_s);
                System.out.println(info.getNbreSommet() + " sommets");

                selectNameSommet();

                window.setScene(scene2);

            }

        });



        scene1 = new Scene(vbox, 800, 650);
    }
    int i = 0;

    public void selectNameSommet()
    {



        lbl_nbre_sommet = new Label("Vous avez " + info.getNbreSommet() + " villes");

        Button btn_valider = new Button("Valider");
        Button btn_continuer = new Button("Continuer");
        btn_continuer.setVisible(false);


        Label lbl_text = new Label("Choisissez le nom des villes : ");

        TextField tf_nameSommet = new TextField();
        tf_nameSommet.setPromptText("Nom des villes");



        HBox hbox = new HBox(10);

        hbox.setPadding(new Insets(20, 20, 20, 20));
        hbox.getChildren().addAll(lbl_text, tf_nameSommet, btn_valider);

        VBox vbox2 = new VBox(10);
        vbox2.getChildren().addAll(lbl_nbre_sommet, hbox, btn_continuer);


        btn_valider.setOnAction(e -> {
            String nameSommet = tf_nameSommet.getText();
            graphe.ajouterSommet(new Sommet(i, nameSommet));

            int j = i+1;
            Label lbl = new Label("Votre ville numéro " + j + " se nomme " + graphe.sommets.get(i).getNom());

            tf_nameSommet.setText("");

            if (i < info.getNbreSommet()) vbox2.getChildren().add(lbl);

            i++;

            if (i == info.getNbreSommet())
            {

                btn_valider.setVisible(false);
                tf_nameSommet.setVisible(false);
                lbl_text.setVisible(false);
                btn_continuer.setVisible(true);

            }
        });

        btn_continuer.setOnAction(event -> {
            selectSommet();
            window.setScene(scene3);
        });



        vbox2.setPadding(new Insets(20, 20, 20, 20));
        scene2 = new Scene(vbox2, 800, 650);
    }

    public void selectSommet()
    {
        System.out.println(info.getNbreSommet() + " sommets");

        Button btn_valider = new Button("Valider");
        Button btn_display_graph = new Button("Afficher le Graphe");

        Label lbl_info = new Label("Indiquez les villes qui sont adjacentes : ");
        Label label = new Label();
        label.setText("-->");

        tf_sommet1 = new TextField();
        tf_sommet1.setPromptText("Ville A");
        tf_sommet1.setPrefSize(100, 20);

        tf_sommet2 = new TextField();
        tf_sommet2.setPromptText("Ville B");
        tf_sommet2.setPrefSize(100, 20);



        HBox hbox = new HBox(10);

        hbox.setPadding(new Insets(20, 20, 20, 20));
        hbox.getChildren().addAll(lbl_info, tf_sommet1, label, tf_sommet2, btn_valider);

        HBox hbox2 = new HBox(10);

        hbox2.setPadding(new Insets(20, 0, 20, 0));


        Label lbl1 = new Label("Vos " + info.getNbreSommet() + " villes : ");
        hbox2.getChildren().add(lbl1);

        for (int i = 0; i < info.getNbreSommet(); i++)
        {
            if (i != info.getNbreSommet() - 1) {
                Label lbl2 = new Label(graphe.sommets.get(i).getNom() + ", ");
                hbox2.getChildren().add(lbl2);
            } else {
                Label lbl2 = new Label(graphe.sommets.get(i).getNom() + ".");
                hbox2.getChildren().add(lbl2);
            }
        }

        VBox vbox2 = new VBox(10);


        btn_valider.setOnAction(e -> {

            String s1, s2;

            s1 = tf_sommet1.getText();
            s2 = tf_sommet2.getText();

            Label lbl = new Label(s1 + " réagit avec " + s2);
            vbox2.getChildren().add(lbl);

            int i = 0;
            int num_s1 = 0, num_s2 = 0;
            while(i<graphe.sommets.size()){
                if (graphe.sommets.get(i).getNom().equalsIgnoreCase(s1))
                {
                    num_s1 = graphe.sommets.get(i).getNumero();
                }
                if (graphe.sommets.get(i).getNom().equalsIgnoreCase(s2))
                {
                    num_s2 = graphe.sommets.get(i).getNumero();
                }
                i++;

            }
            graphe.ajouterArret(new Arrete(graphe.sommets.get(num_s1), graphe.sommets.get(num_s2)));
        });





        btn_display_graph.setOnAction(e -> {

            int j = 0;
            while(j<graphe.arrets.size()){
                Label lbl = new Label(graphe.arrets.get(j).get_info_arrete(j));
                vbox2.getChildren().add(lbl);

                j++;
            }

            displayGraph();
            window.setScene(scene4);

        });


        vbox2.getChildren().addAll(hbox2, lbl_nbre_sommet, hbox, btn_display_graph);
        vbox2.setPadding(new Insets(20, 20, 20, 20));
        scene3 = new Scene(vbox2, 800, 650);
    }


    public void displayGraph()
    {
        displaySommet();
    }


    public void displaySommet()
    {

        int width = 1260, height = 860;
        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: white;");
        canvas.setPrefSize(width,height);


        int x = width/2;
        int y = height/11;

        int taille = info.getNbreSommet();

        for (int i = 0; i < taille; i++) {




            if (i == 0) {

                // Défini la position du sommet
                graphe.sommets.get(i).setPosX(i + x);
                graphe.sommets.get(i).setPosY(i + y);

                graphe.sommets.get(i).createCircle(graphe, i, canvas);
                

            } else {

                info.placeSommet(graphe, info.getNbreSommet());




                graphe.sommets.get(i).createCircle(graphe, i, canvas);
            }
        }



        displayArrete(canvas);
        color_sommet(graphe, taille);

    }

    public void displayArrete(Pane canvas)
    {

        int nbre_arrete = graphe.arrets.size();

        System.out.println("Arrete " + nbre_arrete);

        for (int i = 0; i < nbre_arrete; i++) {

            // Récupère les données du sommet à analyser
            Line line;

            if(graphe.arrets.get(i).get_sommet1().getNumero() > graphe.arrets.get(i).get_sommet2().getNumero())
            {
                line = new Line(graphe.arrets.get(i).get_sommet2().getPosX() + 34, graphe.arrets.get(i).get_sommet2().getPosY() + 34,
                        graphe.arrets.get(i).get_sommet1().getPosX() + 6, graphe.arrets.get(i).get_sommet1().getPosY() + 6);
            } else {

                line = new Line(graphe.arrets.get(i).get_sommet1().getPosX() + 34, graphe.arrets.get(i).get_sommet1().getPosY() + 34,
                        graphe.arrets.get(i).get_sommet2().getPosX() + 6, graphe.arrets.get(i).get_sommet2().getPosY() + 6);
            }
            canvas.getChildren().add(line);

        }

    }


    public void displaySommet2()
    {


        int width = 1260, height = 860;
        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: white;");
        canvas.setPrefSize(width,height);


        displayArrete(canvas);

        int x = width/2;
        int y = height/11;

        int taille = info.getNbreSommet();

        for (int i = 0; i < taille; i++) {

            if (i == 0) {

                // Défini la position du sommet
                graphe.sommets.get(i).setPosX(i + x);
                graphe.sommets.get(i).setPosY(i + y);

                graphe.sommets.get(i).createCircle(graphe, i, canvas);


            } else {

                info.placeSommet(graphe, info.getNbreSommet());

                graphe.sommets.get(i).createCircle(graphe, i, canvas);
            }
        }

        Label lbl = new Label("Nombre chromatique : " + graphe.getNombreChromatique());
        lbl.setFont(Font.font("Verdana", 20));
        lbl.setLayoutX(10);
        lbl.setLayoutY(10);

        canvas.getChildren().add(lbl);

        scene4 = new Scene(canvas, width, height);
    }

    public void color_sommet(Graphe g, int nbre_som)
    {


        // Met toutes les couleurs à 0

        for (int i = 0; i < nbre_som; i++) {
            g.sommets.get(i).setCouleur(0);
        }


        for (int i = 1; i < nbre_som; i++) {

            // Récupère les données du sommet à analyser

            int sommet = g.sommets.get(i).getNumero();
            int couleur_sommet = g.sommets.get(i).getCouleur();
            List<Integer> couleur_interdit = new ArrayList<Integer>();


            // Compare notre sommet aux autres sommets
            for (int j = i-1; j > -1; j--) {


                // On récupère les données du sommet actuel
                int cmp_sommet = g.sommets.get(j).getNumero();
                int cmp_couleur_sommet = g.sommets.get(j).getCouleur();
                int valmax = 0;

                for (int k = g.arrets.size() - 1; k >= 0; k--)
                {
                    if (sommet == g.arrets.get(k).get_sommet1().getNumero() && cmp_sommet == g.arrets.get(k).get_sommet2().getNumero())
                    {
                        // On place la couleur du sommet actuel dans les couleurs interdite du sommet qu'on analyse
                        couleur_interdit.add(cmp_couleur_sommet);


                        // Le sommet actuel et le sommet à analyser on la même couleur
                        if (couleur_sommet == cmp_couleur_sommet)
                        {



                            // On récupère les valeurs interdites du sommet et on l'incrémente

                            for (int l = 0; l < couleur_interdit.size(); l++)
                            {
                                if (couleur_interdit.get(l) > valmax)
                                    valmax = couleur_interdit.get(l);

                            }

                            valmax++;


                            // on donne une couleur au sommet que l'on analyse
                            couleur_sommet = valmax;

                            g.sommets.get(i).setCouleur(couleur_sommet);
                        }
                    }



                    if (sommet == g.arrets.get(k).get_sommet2().getNumero() && cmp_sommet == g.arrets.get(k).get_sommet1().getNumero())
                    {
                        // On place la couleur du sommet actuel dans les couleurs interdite du sommet qu'on analyse
                        couleur_interdit.add(cmp_couleur_sommet);


                        // Le sommet actuel et le sommet à analyser on la même couleur
                        if (couleur_sommet != cmp_couleur_sommet)
                        {} else {



                            // On récupère les valeurs interdites du sommet et on l'incrémente

                            for (int l = 0; l < couleur_interdit.size(); l++)
                            {
                                if (couleur_interdit.get(l) > valmax)
                                    valmax = couleur_interdit.get(l);


                            }

                            valmax++;


                            // on donne une couleur au sommet que l'on analyse
                            couleur_sommet = valmax;

                            g.sommets.get(i).setCouleur(couleur_sommet);
                        }
                    }


                    // Le sommet actuel n'est pas lié à notre sommet
                    if (g.arrets.get(k).get_sommet1().getNumero() != sommet && g.arrets.get(k).get_sommet2().getNumero() != sommet)
                    {


                        // Regarde la couleur du sommet actuel si couleur différente, regarde si couleur interdite
                        // Si couleur interdite laisse comme ça
                        // Si couleur autorisé regarde si la couleur est supérieur au sommet à analyser
                        // Si la couleur est supérieur le sommet à analyser prend la couleur du sommet actuelle
                        if (couleur_sommet != cmp_couleur_sommet)
                        {
                            for (int l = 0; l < couleur_interdit.size(); l++)
                            {
                                if (cmp_couleur_sommet != couleur_interdit.get(l) && cmp_couleur_sommet < couleur_sommet)
                                {
                                    cmp_couleur_sommet = couleur_sommet;
                                    g.sommets.get(i).setCouleur(couleur_sommet);
                                }

                            }
                        }



                    }

                }
                }


                if (i == 0)
                {
                    couleur_sommet = 0;
                    g.sommets.get(i).setCouleur(couleur_sommet);
                }
        }

        nombre_chromatique(graphe);
        displaySommet2();

    }


    public void nombre_chromatique(Graphe g)
    {
        int nombre_chromatique = 0;

        for (int i = 0; i < g.sommets.size(); i++)
        {

                if (g.sommets.get(i).getCouleur() > nombre_chromatique)
                    nombre_chromatique = g.sommets.get(i).getCouleur();

        }

        nombre_chromatique++;
        g.setNombreChromatique(nombre_chromatique);




    }


    private boolean isInt(TextField input, String message)
    {
        try {
            int nbre = Integer.parseInt(input.getText());


            return true;

        } catch (NumberFormatException e) {
            System.out.println("Erreur " + message + " n'est pas un chiffre");

            return false;
        }
    }

}
