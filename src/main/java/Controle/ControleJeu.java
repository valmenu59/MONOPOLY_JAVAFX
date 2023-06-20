package Controle;

import Affichage.AffichageJeu;
import Affichage.fx.ImageJeu;
import Modele.Jeu.Joueur;
import Modele.Jeu.Monopoly;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.util.*;

public class ControleJeu {

    private final AffichageJeu affichage;
    private final Monopoly monopoly;



    public ControleJeu(List<Joueur> listeJoueur, Stage stage){
        affichage = new AffichageJeu(stage);
        stage.setScene(affichage);
        monopoly = new Monopoly();
        for (Joueur j : listeJoueur){
            monopoly.getListeJoueurs().add(j);
        }


        int numero = 1;
        for (Joueur j : monopoly.getListeJoueurs()){
            affichage.getListeJoueur().put(numero, j);
            numero++;
        }
        affichage.afficherJoueurs();



        /*
        monopoly.getListeJoueurs().add(new Joueur("joueur1a"));
        monopoly.getListeJoueurs().add(new Joueur("joueur2b"));
        monopoly.getListeJoueurs().add(new Joueur("joueur3c"));
        monopoly.getListeJoueurs().add(new Joueur("joueur4d"));
        int numero = 1;
        for (Joueur j : monopoly.getListeJoueurs()){
            affichage.getListeJoueur().put(numero, j);
            numero++;
        }
        //affichage.afficherJoueurs();


        listeJoueur.add(new Joueur("joueur1a"));
        listeJoueur.add(new Joueur("joueur2b"));
        listeJoueur.add(new Joueur("joueur3c"));
        listeJoueur.add(new Joueur("joueur4d"));
        */




    }










}
