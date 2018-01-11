package com.paris8.colorGraph;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main extends Application{

    Group root;
    MenuBar menuBar;
    BorderPane borderPane;
    Stage window;
    Scene scene, scene1, scene2, scene3, scene4;
    TextField tf_sommet1, tf_sommet2, tf_nbreSommet, tf_nbre;
    Label lbl_nbre_sommet;
    int nbre_s;

    private static int nbre_sommet;
    private static int[] tab_numero_sommet;
    private static String nom_sommet;
    private static Graphe graphe;
    private static boolean fin = false;
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


        /*root = new Group();
        Scene scene = new Scene(root, 900, 650, Color.WHITE);

        menuBar = new MenuBar();
        EventHandler<ActionEvent> action = changeTabPlacement();

        Menu menu = new Menu("Direction");
        MenuItem left = new MenuItem("Left");

        left.setOnAction(action);
        menu.getItems().add(left);

        MenuItem right = new MenuItem("Right");
        right.setOnAction(action);
        menu.getItems().add(right);

        MenuItem top = new MenuItem("Top");
        top.setOnAction(action);
        menu.getItems().add(top);

        MenuItem bottom = new MenuItem("Bottom");
        bottom.setOnAction(action);
        menu.getItems().add(bottom);

        menuBar.getMenus().add(menu);

        borderPane = new BorderPane();


        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setTop(menuBar);

        root.getChildren().add(borderPane);*/
        selectNbreSommet();


        window.setScene(scene1);

        window.show();

        //graphe = new Graphe();

        //get_sommet();

        /*Group root = new Group();
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("");

        VBox vb = new VBox();

        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: black;");
        canvas.setPrefSize(200,200);
        Circle circle = new Circle(50, Color.BLUE);
        circle.relocate(20, 20);
        Rectangle rectangle = new Rectangle(100,100,Color.RED);
        rectangle.relocate(70,70);
        canvas.getChildren().addAll(circle,rectangle);

        vb.getChildren().add(canvas);

        scene.setRoot(vb);
        primaryStage.show();*/


    }



    public void selectNbreSommet()
    {
        Button btn_valider_nbre = new Button("Valider");

        Label txt = new Label("Choisissez le nombre de sommet : ");

        tf_nbre = new TextField();
        tf_nbre.setPromptText("Choisir le nombre de sommet");

        HBox hbox1 = new HBox(10);
        hbox1.getChildren().addAll(txt, tf_nbre, btn_valider_nbre);
        hbox1.setPadding(new Insets(20, 20, 20, 20));

        btn_valider_nbre.setOnAction(e -> {

            if (isInt(tf_nbre, tf_nbre.getText())) {



                nbre_s = Integer.parseInt(tf_nbre.getText());
                nbre_sommet = nbre_s;
                info.setNbreSommet(nbre_s);
                System.out.println(info.getNbreSommet() + " sommets");

                tab_numero_sommet = new int[nbre_sommet];

                selectNameSommet();

                window.setScene(scene2);

            }

        });



        scene1 = new Scene(hbox1, 800, 650);
    }
    int i = 0;

    public void selectNameSommet()
    {



        lbl_nbre_sommet = new Label("Vous avez " + info.getNbreSommet() + " sommets");

        Button btn_valider = new Button("Valider");


        Label lbl_text = new Label("Choisissez le nom de vos sommets : ");

        TextField tf_nameSommet = new TextField();
        tf_nameSommet.setPromptText("Saisir le nom de vos sommets : ");



        HBox hbox = new HBox(10);

        hbox.setPadding(new Insets(20, 20, 20, 20));
        hbox.getChildren().addAll(tf_nameSommet, btn_valider);

        VBox vbox2 = new VBox(10);
        vbox2.getChildren().addAll(lbl_nbre_sommet, hbox);


        btn_valider.setOnAction(e -> {
            String nameSommet = tf_nameSommet.getText();
            graphe.ajouterSommet(new Sommet(i, nameSommet));

            int j = i+1;
            Label lbl = new Label("Votre sommet numéro " + j + " se nomme " + graphe.sommets.get(i).getNom());

            tf_nameSommet.setText("");

            if (i < info.getNbreSommet()) vbox2.getChildren().add(lbl);

            i++;

            if (i == info.getNbreSommet())
            {

                btn_valider.setText("Continuer");
                tf_nameSommet.setVisible(false);

                for (i = 0; i < graphe.sommets.size(); i++)
                {
                    graphe.sommets.get(i).setPosX(i + 50);
                    graphe.sommets.get(i).setPosY(i + 50);
                }

            }

            if (i == info.getNbreSommet() + 1)
            {

                selectSommet();

                window.setScene(scene3);

            }



        });



        vbox2.setPadding(new Insets(20, 20, 20, 20));
        scene2 = new Scene(vbox2, 800, 650);
    }

    public void selectSommet()
    {
        System.out.println(info.getNbreSommet() + " sommets");

        nbre_sommet = info.getNbreSommet();

        lbl_nbre_sommet = new Label("Vous avez " + info.getNbreSommet() + " sommets");

        Button btn_valider = new Button("Valider");
        Button btn_display_graph = new Button("Afficher le Graphe");

        Label lbl_info = new Label("Indiquez les sommets qui réagissent entre eux : ");
        Label label = new Label();
        label.setText("-->");

        tf_sommet1 = new TextField();
        tf_sommet1.setPromptText("Sommet A");
        tf_sommet1.setPrefSize(50, 20);

        tf_sommet2 = new TextField();
        tf_sommet2.setPromptText("Sommet B");
        tf_sommet2.setPrefSize(50, 20);



        HBox hbox = new HBox(10);

        hbox.setPadding(new Insets(20, 20, 20, 20));
        hbox.getChildren().addAll(lbl_info, tf_sommet1, label, tf_sommet2, btn_valider);

        VBox vbox2 = new VBox(10);

        Label lbl_text = new Label();






        btn_valider.setOnAction(e -> {

            String s1, s2;

            s1 = tf_sommet1.getText();
            s2 = tf_sommet2.getText();

            Label lbl = new Label(s1 + " réagit avec " + s2);
            vbox2.getChildren().add(lbl);

            int i = 0;
            int num_s1 = 0, num_s2 = 0;
            while(i<graphe.sommets.size()){
                if (graphe.sommets.get(i).getNom().equals(s1))
                {
                    num_s1 = graphe.sommets.get(i).getNumero();
                }
                if (graphe.sommets.get(i).getNom().equals(s2))
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


        vbox2.getChildren().addAll(lbl_nbre_sommet, hbox, btn_display_graph, lbl_text);
        vbox2.setPadding(new Insets(20, 20, 20, 20));
        scene3 = new Scene(vbox2, 800, 650);
    }


    public void displayGraph()
    {
        displaySommet();
        displayArrete();
    }

    public void displaySommet()
    {
        int i;
        int width = 1260, height = 860;
        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: white;");
        canvas.setPrefSize(width,height);


        int x = width/5;
        int y = height/10;

        int taille = graphe.sommets.size() - 1;

        System.out.println("Taille : " + taille);

        for (i = 0; i < taille; i++) {



            if (i == 0) {

                graphe.sommets.get(i).setPosX(i + x);
                graphe.sommets.get(i).setPosY(i + y);

                Circle circle = new Circle(20, Color.BLUE);
                circle.relocate(graphe.sommets.get(i).getPosX(), graphe.sommets.get(i).getPosY());
                
                Label lbl = new Label(graphe.sommets.get(i).getNom());
                lbl.setFont(Font.font("Verdana", 20));
                lbl.setLayoutX(circle.getLayoutX() - circle.getRadius()/2 + 2);
                lbl.setLayoutY(circle.getLayoutY() - circle.getRadius()/2 - 2);


                canvas.getChildren().addAll(circle, lbl);
            } else {

                int k = graphe.sommets.get(i-1).getPosX() + 250;
                int l = graphe.sommets.get(i-1).getPosY() + 250;

                graphe.sommets.get(i).setPosX(k);
                graphe.sommets.get(i).setPosY(l);




                Circle circle = new Circle(20, Color.BLUE);
                circle.relocate(k, l);

                Label lbl = new Label(graphe.sommets.get(i).getNom());
                lbl.setFont(Font.font("Verdana", 20));
                lbl.setLayoutX(circle.getLayoutX() - circle.getRadius()/2 + 2);
                lbl.setLayoutY(circle.getLayoutY() - circle.getRadius()/2 - 2);

                Line line = new Line(graphe.sommets.get(i-1).getPosX() + 34, graphe.sommets.get(i-1).getPosY() + 34,
                        graphe.sommets.get(i).getPosX() + 6, graphe.sommets.get(i).getPosY() + 6);

                canvas.getChildren().addAll(circle, line, lbl);
            }
        }



        scene4 = new Scene(canvas, width, height);
    }

    public void displayArrete()
    {
        int i;
        for (i = 0; i < graphe.arrets.size(); i++)
        {

        }
    }





    public static void get_sommet()
    {


        /*Scanner nb_somm = new Scanner(System.in);
        System.out.println("Veuillez entrer le nombre de sommet :");
        nbre_sommet = nb_somm.nextInt();
        System.out.println("Vous avez saisi : " + nbre_sommet + " sommets");

        tab_numero_sommet = new int[nbre_sommet];*/

        for (int i = 0; i < nbre_sommet; i++)
        {
            Scanner name_somm = new Scanner(System.in);
            System.out.println("\nRépertoriez le nom du sommet " + i +" : ");
            nom_sommet = name_somm.nextLine();

            graphe.ajouterSommet(new Sommet(i, nom_sommet));

        }

        System.out.print("\nVous avez " + nbre_sommet + " sommets qui sont : ");

        for (int i = 0; i < nbre_sommet; i++)
        {
            if (i < nbre_sommet - 1)
            {
                System.out.print(graphe.sommets.get(i).getNom() + ", ");
            } else {
                System.out.println(graphe.sommets.get(i).getNom() + ". ");
            }


        }


        System.out.println("\n\n\nVeuillez indiquer les sommets qui réagissent entre eux : \n");

        while (fin == false)
        {
            String str1;
            String str2;
            char char_continue;
            Scanner liaison_somm1 = new Scanner(System.in);
            System.out.println("Veuillez indiquer le premier sommet : ");
            str1 = liaison_somm1.nextLine();

            Scanner liaison_somm2 = new Scanner(System.in);
            System.out.println("Veuillez indiquer le second sommet : ");
            str2 = liaison_somm2.nextLine();


            int i = 0;
            int num_s1 = 0, num_s2 = 0;
            while(i<graphe.sommets.size()){
                if (graphe.sommets.get(i).getNom().equals(str1))
                {
                    num_s1 = graphe.sommets.get(i).getNumero();
                }
                if (graphe.sommets.get(i).getNom().equals(str2))
                {
                    num_s2 = graphe.sommets.get(i).getNumero();
                }
                i++;
            }


            graphe.ajouterArret(new Arrete(graphe.sommets.get(num_s1), graphe.sommets.get(num_s2)));



            Scanner continuer = new Scanner(System.in);
            System.out.println("Ajouter des liaisons ? (O/N) ");
            char_continue = continuer.next().charAt(0);
            //if (str_continue == "O"|| str_continue == "o")
            if(char_continue == 'N' || char_continue == 'n')
            {
                fin = true;
                System.out.println("Vous avez saisi : " + char_continue);
            }

        }

        int j = 0;
        while(j<graphe.arrets.size()){
            System.out.println("\n\n" + graphe.arrets.get(j).get_info_arrete(j) + "\n");

            j++;
        }

        color_sommet2(graphe, nbre_sommet);

        nombre_chromatique(graphe);

    }






    public static void color_sommet2(Graphe g, int nbre_som)
    {
        System.out.println("---------------Coloration des sommets----------------------\n\n" );

        boolean finish = false;


        // Met toutes les couleurs à 0

        for (int i = 0; i < nbre_som; i++) {
            g.sommets.get(i).setCouleur(0);
            System.out.println("Couleur = 0");
        }


        for (int i = 1; i < nbre_som; i++) {

            // Récupère les données du sommet à analyser

            int sommet = g.sommets.get(i).getNumero();
            int couleur_sommet = g.sommets.get(i).getCouleur();
            //System.out.println("get Couleur = " + g.sommets.get(i).getCouleur());
            List<Integer> couleur_interdit = new ArrayList<Integer>();

            //System.out.println("Yassine " + i);

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
                        for (int l = 0; l < couleur_interdit.size(); l++)
                        {
                            System.out.println("*********Valeur Interdit : " + couleur_interdit.get(l));

                        }

                        // Le sommet actuel et le sommet à analyser on la même couleur
                        if (couleur_sommet == cmp_couleur_sommet)
                        {



                            // On récupère les valeurs interdites du sommet et on l'incrémente

                            for (int l = 0; l < couleur_interdit.size(); l++)
                            {
                                if (couleur_interdit.get(l) > valmax)
                                    valmax = couleur_interdit.get(l);

                                System.out.println("*********Meme Couleur : " + valmax + "  *****  " + couleur_interdit.get(l));

                            }

                            valmax++;
                            System.out.println("*********Donc couleurs vaut : " + valmax);

                            // on donne une couleur au sommet que l'on analyse
                            couleur_sommet = valmax;

                            g.sommets.get(i).setCouleur(couleur_sommet);
                        }
                    }



                    if (sommet == g.arrets.get(k).get_sommet2().getNumero() && cmp_sommet == g.arrets.get(k).get_sommet1().getNumero())
                    {
                        // On place la couleur du sommet actuel dans les couleurs interdite du sommet qu'on analyse
                        couleur_interdit.add(cmp_couleur_sommet);
                        for (int l = 0; l < couleur_interdit.size(); l++)
                        {
                            System.out.println("*********Valeur Interdit : " + couleur_interdit.get(l));

                        }

                        // Le sommet actuel et le sommet à analyser on la même couleur
                        if (couleur_sommet != cmp_couleur_sommet)
                        {} else {



                            // On récupère les valeurs interdites du sommet et on l'incrémente

                            for (int l = 0; l < couleur_interdit.size(); l++)
                            {
                                if (couleur_interdit.get(l) > valmax)
                                    valmax = couleur_interdit.get(l);

                                System.out.println("*********Meme Couleur : " + valmax + "  *****  " + couleur_interdit.get(l));

                            }

                            valmax++;
                            System.out.println("*********Donc couleurs vaut : " + valmax);

                            // on donne une couleur au sommet que l'on analyse
                            couleur_sommet = valmax;

                            g.sommets.get(i).setCouleur(couleur_sommet);
                        }
                    }


                    // Le sommet actuel n'est pas lié à notre sommet
                    if (g.arrets.get(k).get_sommet1().getNumero() != sommet && g.arrets.get(k).get_sommet2().getNumero() != sommet)
                    {

                        System.out.println("Difffffférent");

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

                System.out.println("JJJJJ = " + j);

                }

                if (i == 0)
                {
                    couleur_sommet = 0;
                    g.sommets.get(i).setCouleur(couleur_sommet);
                }

            System.out.println("\n----------------Couleur du sommet " + sommet + " = " + g.sommets.get(i).getCouleur() + " -------------------------");

        }



    }




    public static void nombre_chromatique(Graphe g)
    {
        int nombre_chromatique = 0;

        for (int i = 0; i < g.sommets.size(); i++)
        {

                if (g.sommets.get(i).getCouleur() > nombre_chromatique)
                    nombre_chromatique = g.sommets.get(i).getCouleur();

        }

        nombre_chromatique++;

        System.out.println("*************** Le nombre chromatique est : " + nombre_chromatique + " ***************");
    }







    public static void color_sommet(Graphe g, int nbre_som)
    {
        System.out.println("---------------Coloration des sommets----------------------\n\n" );

        boolean finish = false;


            // Met toutes les couleurs à 0

            for (int i = 0; i < nbre_som; i++) {
                g.sommets.get(i).setCouleur(0);
                System.out.println("Couleur = 0");
            }


            for (int i = 1; i < nbre_som; i++) {

                // Récupère les données du sommet à analyser

                int sommet = g.sommets.get(i).getNumero();
                int couleur_sommet = g.sommets.get(i).getCouleur();
                //System.out.println("get Couleur = " + g.sommets.get(i).getCouleur());
                List<Integer> couleur_interdit = new ArrayList<Integer>();

                //System.out.println("Yassine " + i);

                // Compare notre sommet aux autres sommets
                for (int j = i-1; j > -1; j--) {


                    // Le sommet actuel est liée à notre sommet
                    if (g.arrets.get(j).get_sommet1().getNumero() == sommet)
                    {


                        // On récupère les données du sommet actuel
                        int cmp_sommet = g.arrets.get(j).get_sommet2().getNumero();
                        int cmp_couleur_sommet = g.arrets.get(j).get_sommet2().getCouleur();

                        // On place la couleur du sommet actuel dans les couleurs interdite du sommet qu'on analyse
                        couleur_interdit.add(cmp_couleur_sommet);
                        for (int l = 0; l < couleur_interdit.size(); l++)
                        {
                            System.out.println("*********Valeur Interdit 1 : " + couleur_interdit.get(l));

                        }

                        // Le sommet actuel et le sommet à analyser on la même couleur
                        if (couleur_sommet == cmp_couleur_sommet)
                        {



                            // On récupère les valeurs interdites du sommet et on l'incrémente
                            int valmax = 0;
                            for (int l = 0; l < couleur_interdit.size(); l++)
                            {
                                if (couleur_interdit.get(l) > valmax)
                                    valmax = couleur_interdit.get(l);

                                System.out.println("*********Interdit 1 : " + valmax + "  *****  " + couleur_interdit.get(l));

                            }

                            valmax++;

                            // on donne une couleur au sommet que l'on analyse
                            couleur_sommet = valmax;
                            g.sommets.get(i).setCouleur(couleur_sommet);
                        }

                    }


                    // Le sommet actuel est liée à notre sommet
                    if (g.arrets.get(i).get_sommet2().getNumero() == sommet)
                    {
                        // On récupère les données du sommet actuel
                        int cmp_sommet = g.arrets.get(i).get_sommet1().getNumero();
                        int cmp_couleur_sommet = g.arrets.get(i).get_sommet2().getCouleur();

                        // On place la couleur du sommet actuel dans les couleurs interdite du sommet qu'on analyse
                        couleur_interdit.add(cmp_couleur_sommet);
                        for (int l = 0; l < couleur_interdit.size(); l++)
                        {
                            System.out.println("*********Valeur Interdit 2 : " + couleur_interdit.get(l));

                        }
                        // Le sommet actuel et le sommet à analyser on la même couleur
                        if (couleur_sommet == cmp_couleur_sommet)
                        {


                            // On récupère les valeurs interdites du sommet et on l'incrémente
                            int valmax = 0;
                            for (int l = 0; l < couleur_interdit.size(); l++)
                            {
                                if (couleur_interdit.get(l) > valmax)
                                    valmax = couleur_interdit.get(l);
                                System.out.println("*********Interdit 2 : " + valmax + "  *****  " + couleur_interdit.get(l));
                            }

                            valmax++;

                            System.out.println("valmax = " + valmax);

                            // on donne une couleur au sommet que l'on analyse
                            couleur_sommet = valmax;
                            g.sommets.get(i).setCouleur(couleur_sommet);
                        }

                    }


                    // Le sommet actuel n'est pas lié à notre sommet
                    if (g.arrets.get(j).get_sommet1().getNumero() != sommet && g.arrets.get(j).get_sommet2().getNumero() != sommet)
                    {

                        System.out.println("Difffffférent");
                        int cmp_sommet = g.sommets.get(j).getNumero();
                        int cmp_couleur_sommet = g.sommets.get(j).getCouleur();

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

                    if (i == 0)
                    {
                        couleur_sommet = 0;
                        g.sommets.get(i).setCouleur(couleur_sommet);
                    }

                    System.out.println("JJJJJ = " + j);
                }

                System.out.println("\n----------------Couleur du sommet " + sommet + " = " + g.sommets.get(i).getCouleur() + " -------------------------");
            }


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
