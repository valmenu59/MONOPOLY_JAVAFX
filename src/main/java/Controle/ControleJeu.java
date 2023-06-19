package Controle;

import Affichage.AffichageJeu;
import Affichage.fx.ImageJeu;
import Modele.Jeu.Joueur;
import Modele.Jeu.Monopoly;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class ControleJeu {

    private final AffichageJeu affichage;
    private final Monopoly monopoly;
    private final List<Joueur> listeJoueur = new ArrayList<>();

    public ControleJeu(){
        affichage = new AffichageJeu();
        monopoly = new Monopoly();
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

         */
        listeJoueur.add(new Joueur("joueur1a"));
        listeJoueur.add(new Joueur("joueur2b"));
        listeJoueur.add(new Joueur("joueur3c"));
        listeJoueur.add(new Joueur("joueur4d"));

        animationDe();
    }

    public void attributionOrdreJoueurs(){
        
    }

    public void animationDe(){
        affichage.affichageTexteDebutDePartie();
        AnimationTimer boucleAnimation = new AnimationTimer() {
            private long dernierTemps = 0;
            private long tempsAccumule = 0;
            private static final long FPS = 69L * 1_000_000; //correspond à 144 FPS
            private final ImageJeu de1 = new ImageJeu(getClass().getResource(affichage.getSourceImage("de1")).toExternalForm());
            private final ImageJeu de2 = new ImageJeu(getClass().getResource(affichage.getSourceImage("de2")).toExternalForm());
            private final ImageJeu de3 = new ImageJeu(getClass().getResource(affichage.getSourceImage("de3")).toExternalForm());
            private final ImageJeu de4 = new ImageJeu(getClass().getResource(affichage.getSourceImage("de4")).toExternalForm());
            private final ImageJeu de5 = new ImageJeu(getClass().getResource(affichage.getSourceImage("de5")).toExternalForm());
            private final ImageJeu de6 = new ImageJeu(getClass().getResource(affichage.getSourceImage("de6")).toExternalForm());

            @Override
            public void handle(long now) {
                System.out.println("iciiiciifd");
                if (dernierTemps == 0) {
                    dernierTemps = now;
                } else {
                    long tempsEcoule = now - dernierTemps;
                    dernierTemps = now;
                    tempsAccumule += tempsEcoule;

                    if (tempsAccumule >= FPS) {
                        System.out.println("ici");
                        monopoly.getDe()[0].melangerDe();
                        monopoly.getDe()[1].melangerDe();
                        int valeurDe1 = monopoly.getDe()[0].getValeur();
                        int valeurDe2 = monopoly.getDe()[1].getValeur();

                        switch (valeurDe1){
                            case 1 -> affichage.getDe1().setFill(new ImagePattern(de1));
                            case 2 -> affichage.getDe1().setFill(new ImagePattern(de2));
                            case 3 -> affichage.getDe1().setFill(new ImagePattern(de3));
                            case 4 -> affichage.getDe1().setFill(new ImagePattern(de4));
                            case 5 -> affichage.getDe1().setFill(new ImagePattern(de5));
                            case 6 -> affichage.getDe1().setFill(new ImagePattern(de6));
                        }
                        switch (valeurDe2){
                            case 1 -> affichage.getDe2().setFill(new ImagePattern(de1));
                            case 2 -> affichage.getDe2().setFill(new ImagePattern(de2));
                            case 3 -> affichage.getDe2().setFill(new ImagePattern(de3));
                            case 4 -> affichage.getDe2().setFill(new ImagePattern(de4));
                            case 5 -> affichage.getDe2().setFill(new ImagePattern(de5));
                            case 6 -> affichage.getDe2().setFill(new ImagePattern(de6));
                        }


                        tempsAccumule -= FPS;
                    }
                }

            }
        };
        boucleAnimation.start();
    }

    public void modifierImage(int valeurDe, Rectangle de){

    }

    public AffichageJeu getAffichage(){
        return this.affichage;
    }



    public void lancerDe(){

    }





}
