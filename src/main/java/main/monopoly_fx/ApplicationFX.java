package main.monopoly_fx;

import Affichage.AffichageJeu;
import Controle.ControleAttributionOrdreJoueurs;
import Controle.ControleJeu;
import Modele.Jeu.Monopoly;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("MONOPOLY - JavaFX Edition");
        stage.setScene(new ControleAttributionOrdreJoueurs().getAffichage());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}