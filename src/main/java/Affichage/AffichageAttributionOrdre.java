package Affichage;

import Affichage.fx.ImageJeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AffichageAttributionOrdre extends Scene {
    private Scene scene;
    private Stage stage;
    private BorderPane affichagePrincipale;
    private SourceImages sourceImages = new SourceImages();
    private final ArrayList<Label> listeLabelsJoueurs = new ArrayList<>();
    private Rectangle de1,de2;

    private Button boutonLancerDe;
    private boolean deLances = false;


    public AffichageAttributionOrdre(Stage fenetre){
        super(new BorderPane(), 1280, 720);
        scene = this;
        stage = fenetre;
        affichagePrincipale = (BorderPane) getRoot();

        BackgroundImage backgroundImage;
        backgroundImage = new BackgroundImage(new ImageJeu(getClass().getResource(sourceImages.getSourceImage(SourceImages.nomImage.ARRIERE_PLAN)).toExternalForm()),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(scene.getWidth() * 1.5, scene.getHeight() * 1.5, false, false, false, false));
        affichagePrincipale.setBackground(new Background(backgroundImage));

    }

    public void affichageTexteDebutDePartie(){
        StackPane stackPane = new StackPane();
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        vBox.setSpacing(20);
        hBox.setSpacing(75);


        Text texteSurnom = new Text("Attribution de l'ordre des joueurs : ");

        ImageJeu img_de1 = new ImageJeu(getClass().getResource(sourceImages.getSourceImage(SourceImages.nomImage.DE1)).toExternalForm(),
                scene.getWidth() *0.05, scene.getWidth() * 0.05, true);

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

        stackPane.getChildren().addAll(rPrincipal, vBox);
        affichagePrincipale.setCenter(stackPane);
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


    public Stage getStage() {
        return stage;
    }
}
