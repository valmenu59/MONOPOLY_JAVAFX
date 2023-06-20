package Affichage;

import Affichage.fx.ImageJeu;
import Controle.ControleJeu;
import Modele.Jeu.Joueur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Scale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AffichageJeu extends Scene {
    private static final String DE1 = "/de/de1.png";
    private static final String DE2 = "/de/de2.png";
    private static final String DE3 = "/de/de3.png";
    private static final String DE4 = "/de/de4.png";
    private static final String DE5 = "/de/de5.png";
    private static final String DE6 = "/de/de6.png";

    private final ArrayList<Node> listeElementsPlateau = new ArrayList<>();
    private final ArrayList<Rectangle> listeRectangles = new ArrayList<>();
    private final ArrayList<Label> listeLabelsJoueurs = new ArrayList<>();
    private Scene scene;
    private BorderPane affichagePrincipale;

    private AnchorPane affichagePlateau;

    private double initialX;
    private double initialY;
    private double zoomFactor;
    private double taille;
    private ControleJeu controle;
    private final Map<Integer, Joueur> listeJoueur = new HashMap<>();
    private Rectangle de1,de2;

    private Text textSurnom;
    private Button boutonLancerDe;
    private boolean deLances = false;

    public AffichageJeu(){
        super(new BorderPane(), 1280, 720);
        scene = this;
        affichagePrincipale = (BorderPane) getRoot();
        affichagePrincipale.setStyle("-fx-background-color: rgb(218, 233, 212)");
        afficherPlateau();
        afficherCote();
        System.out.println("iojudfgjfdklgjfkldgjn,dklfgj,nlkdfgn,jh");
        //affichageTexteDebutDePartie();

        //controlerCarte();


    }
    public void affichageTexteDebutDePartie(){

        Rectangle rectangle = new Rectangle(scene.getWidth(), scene.getHeight());
        rectangle.setFill(new ImagePattern(new ImageJeu(getClass().getResource("/arrierePlanJeu.png").toExternalForm())));
        rectangle.setStroke(Color.BLACK);

        BorderPane borderPane = new BorderPane();
        StackPane stackPane = new StackPane();
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        vBox.setSpacing(20);
        hBox.setSpacing(75);

        borderPane.setPrefSize(scene.getWidth(), scene.getHeight());
        borderPane.setMinSize(scene.getWidth(), scene.getHeight());
        Text texteSurnom = new Text("Attribution de l'ordre des joueurs : ");

        ImageJeu img_de1 = new ImageJeu(getClass().getResource(DE1).toExternalForm(), scene.getWidth() *0.05, scene.getWidth() * 0.05, true);

        HBox hBoxLabels = new HBox();
        hBoxLabels.setSpacing(10);
        hBoxLabels.setAlignment(Pos.CENTER);

        List<Color> listeCouleurs = new ArrayList<>();
        listeCouleurs.add(Color.BLUE);
        listeCouleurs.add(Color.RED);
        listeCouleurs.add(Color.GREEN);
        listeCouleurs.add(Color.YELLOW);

        int numeroJoueur = 1;

        for (Color c : listeCouleurs ){
            Label labelJoueur = new Label("J"+numeroJoueur+" : ");
            if (!c.equals(Color.YELLOW)) {
                labelJoueur.setTextFill(Color.WHITE);
            }
            listeLabelsJoueurs.add(labelJoueur);
            Rectangle rectangleJoueur = new Rectangle(125,40);
            rectangleJoueur.setFill(c);
            StackPane stackPaneJoueur = new StackPane(rectangleJoueur, labelJoueur);
            hBoxLabels.getChildren().add(stackPaneJoueur);
            numeroJoueur++;
        }

        BoxBlur flou = new BoxBlur();
        Rectangle rPrincipal = new Rectangle(scene.getWidth() * 0.5, scene.getHeight() * 0.5);
        rPrincipal.setFill(Color.rgb(240,240,240,0.95));
        rPrincipal.setEffect(flou);
        de1 = new Rectangle(scene.getWidth() * 0.05, scene.getWidth() * 0.05);
        de1.setStroke(Color.BLACK);
        de1.setFill(new ImagePattern(img_de1));
        de2 = new Rectangle(scene.getWidth() * 0.05, scene.getWidth() * 0.05);
        de2.setStroke(Color.BLACK);
        de2.setFill(new ImagePattern(img_de1));
        hBox.getChildren().addAll(de1, de2);
        hBox.setAlignment(Pos.CENTER);



        boutonLancerDe = new Button("Lancer les dés");
        boutonLancerDe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                deLances = true;
            }
        });
        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(hBoxLabels, texteSurnom, hBox, boutonLancerDe);

        stackPane.getChildren().addAll(rectangle, rPrincipal, vBox);
        borderPane.setCenter(stackPane);

        affichagePrincipale.getChildren().add(borderPane);


    }


    public void afficherPlateau(){
        if (scene.getHeight() <= scene.getWidth()){
            affichagePlateau = new AnchorPane();
            taille = scene.getHeight() * 0.9;
            affichagePlateau.setMaxHeight(taille);
            affichagePlateau.setMaxWidth(taille);
        } else {
            affichagePlateau = new AnchorPane();
            taille = scene.getWidth() * 0.9;
            affichagePlateau.setMaxWidth(taille);
            affichagePlateau.setMaxHeight(taille);
        }
        ImageView imgPlateau = new ImageJeu(getClass().getResource("/monopoly-plateau.png").toExternalForm())
                .afficherImage(taille, taille, true);
        affichagePrincipale.setCenter(affichagePlateau);
        affichagePlateau.getChildren().add(imgPlateau);
    }

    public void afficherCote(){

        Rectangle rectangle = new Rectangle(scene.getWidth(), scene.getHeight() * 0.05);
        affichagePrincipale.setTop(rectangle);
        //rectangle.setFill(Color.rgb(218, 233, 212));
        rectangle.setFill(Color.LIGHTBLUE);
        listeRectangles.add(rectangle);

        Rectangle rectangle1 = new Rectangle(scene.getWidth(), scene.getHeight() * 0.05);
        affichagePrincipale.setBottom(rectangle1);
        rectangle1.setFill(Color.rgb(218, 233, 212));
        rectangle1.setFill(Color.LIGHTBLUE);
        listeRectangles.add(rectangle1);

        Rectangle rectangle2 = new Rectangle( (scene.getWidth() - scene.getHeight() * 0.9) / 2, scene.getHeight() * 0.9 + 2);
        affichagePrincipale.setLeft(rectangle2);
        rectangle2.setFill(Color.rgb(218, 233, 212));
        rectangle2.setFill(Color.LIGHTBLUE);
        listeRectangles.add(rectangle2);


        Rectangle rectangle3 = new Rectangle( (scene.getWidth() - scene.getHeight() * 0.9) / 2, scene.getHeight() *0.9 + 2);
        affichagePrincipale.setRight(rectangle3);
        rectangle3.setFill(Color.rgb(218, 233, 212));
        rectangle3.setFill(Color.LIGHTBLUE);
        listeRectangles.add(rectangle3);

    }

    public void afficherJoueurs(){
        AnchorPane affichageJoueurs = new AnchorPane();

        Label joueur1 = new Label(listeJoueursToString(1));
        joueur1.setMinSize(100, 100);
        joueur1.setLayoutX(10);
        joueur1.setLayoutY(-30);
        affichageJoueurs.getChildren().add(joueur1);

        Label joueur2 = new Label(listeJoueursToString(2));
        joueur2.setMinSize(100,100);
        joueur2.setTextAlignment(TextAlignment.RIGHT);
        joueur2.setLayoutX(scene.getWidth() - 70);
        joueur2.setLayoutY(-30);
        affichageJoueurs.getChildren().add(joueur2);

        Label joueur3 = new Label(listeJoueursToString(3));
        joueur3.setMinSize(100,100);
        joueur3.setLayoutX(10);
        joueur3.setLayoutY(scene.getHeight() - 70);
        affichageJoueurs.getChildren().add(joueur3);

        Label joueur4 = new Label(listeJoueursToString(4));
        joueur4.setMinSize(100,100);
        joueur4.setTextAlignment(TextAlignment.RIGHT);
        joueur4.setLayoutX(scene.getWidth() - 70);
        joueur4.setLayoutY(scene.getHeight() - 70);
        affichageJoueurs.getChildren().add(joueur4);

        affichagePrincipale.getChildren().add(affichageJoueurs);
    }

    public Map<Integer, Joueur> getListeJoueur() {
        return listeJoueur;
    }

    public String listeJoueursToString(int numeroJoueur){
        return listeJoueur.get(numeroJoueur).toString();
    }

    public void controlerCarte(){
        scene.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent scrollEvent) {
                double deltaY = scrollEvent.getDeltaY();
                System.out.println(deltaY);

                // Facteur de zoom
                zoomFactor = 1.35;

                if (deltaY < 0) {
                    // Zoom arrière (dézoom)
                    zoomFactor = 1 / zoomFactor;
                    System.out.println(zoomFactor);
                }

                boolean zoom = false;
                boolean dezoom = false;

                if (scene.getHeight() <= scene.getWidth()) {

                    double resultat = affichagePlateau.getScaleY() * zoomFactor;
                    if (resultat >= 1.001 && resultat < 1.6) {
                        zoom = true;
                    } else if (resultat < 1.001 && resultat > 0.999) {
                        dezoom = true;
                        zoom = true;
                    }
                } else {
                    if (affichagePlateau.getScaleX() * zoomFactor >= 1 && affichagePlateau.getScaleX() * zoomFactor < 1.6 ) {
                        zoom = true;
                    }
                }

                if (zoom) {
                    // Appliquer le zoom à l'affichagePlateau
                    Scale scaleTransform = new Scale(zoomFactor, zoomFactor);
                    affichagePlateau.getTransforms().add(scaleTransform);

                    // Réappliquer les changements d'échelle à l'affichagePlateau
                    affichagePlateau.setScaleX(affichagePlateau.getScaleX() * zoomFactor);
                    affichagePlateau.setScaleY(affichagePlateau.getScaleY() * zoomFactor);

                    // Ajuster les coordonnées de translation pour maintenir l'AnchorPane au même endroit
                    double translateX = affichagePlateau.getTranslateX() * zoomFactor;
                    double translateY = affichagePlateau.getTranslateY() * zoomFactor;
                    affichagePlateau.setTranslateX(translateX);
                    affichagePlateau.setTranslateY(translateY);
                }
                if (dezoom) {
                    // Réinitialiser la taille et la position du plateau
                    affichagePlateau.setScaleX(1);
                    affichagePlateau.setScaleY(1);
                    affichagePlateau.setTranslateX(0);
                    affichagePlateau.setTranslateY(0);
                }

            }
        });

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Enregistrez les coordonnées de la souris lorsqu'elle est appuyée
                initialX = mouseEvent.getX();
                initialY = mouseEvent.getY();
            }
        });

        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Calculez le déplacement de la souris depuis son point d'origine
                double deltaX = mouseEvent.getX() - initialX;
                double deltaY = mouseEvent.getY() - initialY;


                // Définir les limites inférieures et supérieures pour les coordonnées x et y
                System.out.println("x " + affichagePlateau.getTranslateX() +" taille "+(affichagePlateau.getTranslateY()));
                System.out.println(affichagePlateau.getScaleY() * zoomFactor);



                double positionX = affichagePlateau.getScaleX() * zoomFactor;
                double positionY = affichagePlateau.getScaleY() * zoomFactor;


                // Calculer les nouvelles coordonnées x et y du plateau
                double translateX = affichagePlateau.getTranslateX() + deltaX * 1.4;
                double translateY = affichagePlateau.getTranslateY() + deltaY * 1.4;

                double min, max;
                min = 0;
                max = 0;
                if (Math.floor(positionY * 100) == 182){
                    min = -420 - 50;
                    max = 111 + 50;
                }

                // Appliquez le déplacement au plateau
                if (positionY > 1) {
                    if (translateY >= min && translateY <= max && translateX >= min && translateX <= max) {
                        affichagePlateau.setTranslateX(translateX);
                        affichagePlateau.setTranslateY(translateY);
                    }
                }
                // Mettez à jour les coordonnées d'origine pour le prochain déplacement
                initialX = mouseEvent.getX();
                initialY = mouseEvent.getY();
            }
        });

        scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Réinitialisez les coordonnées d'origine lorsque la souris est relâchée
                initialX = 0;
                initialY = 0;
            }
        });
    }


    public String getSourceImage(String nom){
        switch (nom){
          case "de1" -> { return DE1; }
          case "de2" -> { return DE2; }
          case "de3" -> { return DE3; }
          case "de4" -> { return DE4; }
          case "de5" -> { return DE5; }
          case "de6" -> { return DE6; }
          default -> { return null; }
        }
    }

    public Rectangle getDe1() {
        return de1;
    }

    public Rectangle getDe2() {
        return de2;
    }

    public boolean isDeLances() {
        return deLances;
    }

    public void setDeLances(boolean b) {
        deLances = b;
    }

    public List<Label> getListeLabelJoueurs(){
        return listeLabelsJoueurs;
    }
}
