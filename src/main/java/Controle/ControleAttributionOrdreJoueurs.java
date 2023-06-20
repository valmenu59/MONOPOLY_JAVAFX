package Controle;

import Affichage.AffichageAttributionOrdre;
import Affichage.AffichageJeu;
import Affichage.SourceImages;
import Affichage.fx.ImageJeu;
import Modele.Jeu.Joueur;
import Modele.Jeu.Monopoly;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControleAttributionOrdreJoueurs {

    private final AffichageAttributionOrdre affichage;
    private final Monopoly monopoly;
    private final List<Joueur> listeJoueur = new ArrayList<>();
    private int valeurDe1, valeurDe2;
    private int compteur = 0;
    private ImageJeu de1 = null;
    private ImageJeu de2 = null;
    private ImageJeu de3 = null;
    private ImageJeu de4 = null;
    private ImageJeu de5 = null;
    private ImageJeu de6 = null;

    //Pour attribuer ordre aux joueurs

    private final List<Joueur> exaequo1 = new ArrayList<>();
    private final List<Joueur> exaequo2 = new ArrayList<>();
    private final List<Integer> listeValeurDe = new ArrayList<>();
    private final List<Joueur> listeJoueurTrie = new ArrayList<>();

    public ControleAttributionOrdreJoueurs(Stage stage) {

        affichage = new AffichageAttributionOrdre(stage);
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
        affichage.affichageTexteDebutDePartie();


        //attributionOrdreJoueurs();
        initialiserImagesDes();

        //boucleAnimationDe();
        attributionOrdreJoueurs();
    }

    public void attributionOrdreJoueurs(){
        boucleAnimationDe(new AnimationListener() {
            @Override
            public void animationTerminee() {

                if (listeJoueurTrie.size() < listeJoueur.size()) {
                    listeJoueurTrie.add(listeJoueur.get(compteur));
                    listeJoueur.get(compteur).setValeurDe(valeurDe1 + valeurDe2);
                    System.out.println("ici");
                    trierListeJoueurTrie(listeJoueurTrie);


                    //Regardes les exaequos
                    for (int i = 0; i < listeJoueurTrie.size() - 1; i++) {
                        if (listeJoueurTrie.get(i).getValeurDe() == listeJoueurTrie.get(i + 1).getValeurDe()) {
                            exaequo1.add(listeJoueurTrie.get(i));
                            exaequo1.add(listeJoueurTrie.get(i + 1));
                            i++;
                        }
                    }
                    //permet de gérer les rares cas où par exemple : 5, 5, 3, 3
                    if (exaequo1.size() == 4) {
                        if (exaequo1.get(1).getValeurDe() != exaequo1.get(2).getValeurDe()) {
                            exaequo2.add(exaequo1.get(2));
                            exaequo2.add(exaequo1.get(3));
                            exaequo1.remove(2);
                            exaequo1.remove(3);
                        }
                    }

                    for (int i = 0; i < listeJoueurTrie.size(); i++) {
                        affichage.getListeLabelJoueurs().get(i).setText("J" + (i + 1) + " : " + listeJoueurTrie.get(i).getSurnom() + " (" + listeJoueurTrie.get(i).getValeurDe() + ")");
                    }


                    if (listeJoueurTrie.size() == listeJoueur.size() ) { //&& exaequo1.isEmpty() && exaequo2.isEmpty()
                        printListeJoueur();
                    } else {
                        compteur++;
                        affichage.setDeLances(false);
                        if (listeJoueurTrie.size() == listeJoueur.size()){
                            compteur = 0;
                        }
                        attributionOrdreJoueurs();
                    }
                } else {

                    //Ne marche pas encore, à tester
                    /*

                    //Uniquement s'il y a 4 joueurs
                    if (!exaequo2.isEmpty()){
                        exaequo(exaequo2);
                    } else if (!exaequo1.isEmpty()){
                        if (exaequo1.size() < 4) {
                            exaequo(exaequo1);
                            if (exaequo1.isEmpty()){
                                printListeJoueur();
                            }
                        } else {
                            System.out.println("jfjkdfjdkjfdkjf");
                            listeJoueurTrie.clear();
                            compteur = 0;
                            attributionOrdreJoueurs();
                        }
                    }

                     */
                }
            }
        });



    }


    /*
    Ne marche pas pour le cas de 3 axaequos
     */
    public void exaequo(List<Joueur> exaequo) {
        exaequo.get(compteur).setValeurDe(valeurDe1 + valeurDe2);
        if (exaequo.size() == 2) {
            if (exaequo.get(0).getValeurDe() == exaequo.get(1).getValeurDe() && compteur == 1) {
                compteur = 0;
                attributionOrdreJoueurs();
            } else if (compteur == 1) {
                if (exaequo.get(0).getValeurDe() > exaequo.get(1).getValeurDe()) {
                    Joueur a, b;
                    a = listeJoueurTrie.get(2);
                    b = listeJoueurTrie.get(3);
                    listeJoueurTrie.remove(3);
                    listeJoueurTrie.remove(2);
                    listeJoueurTrie.add(b);
                    listeJoueurTrie.add(a);
                }
                exaequo.clear();
                compteur = 0;
                attributionOrdreJoueurs();
            }
            compteur++;
            attributionOrdreJoueurs();
        } else {
            if (exaequo.get(0).getValeurDe() == exaequo.get(1).getValeurDe() && exaequo.get(1).getValeurDe() == exaequo.get(2).getValeurDe()) {
                compteur = 0;
                attributionOrdreJoueurs();
            } else {
                Joueur a, b, c;
                a = listeJoueurTrie.get(1);
                b = listeJoueurTrie.get(2);
                c = listeJoueurTrie.get(3);
                listeJoueurTrie.remove(3);
                listeJoueurTrie.remove(2);
                listeJoueurTrie.remove(1);
                listeJoueurTrie.add(c);
                listeJoueurTrie.add(b);
                listeJoueurTrie.add(a);
                exaequo.clear();
                compteur = 0;
                attributionOrdreJoueurs();
            }
            compteur++;
            attributionOrdreJoueurs();
        }
    }

    public void printListeJoueur(){
        for (int i = 0; i < 4; i++) {
            System.out.println(listeJoueurTrie.get(i).getValeurDe());
            System.out.println(listeJoueurTrie.get(i).getSurnom());
        }
        ControleJeu cj = new ControleJeu(listeJoueurTrie, affichage.getStage());
    }


    public void trierListeJoueurTrie(List<Joueur> listeJoueurTrie) {
        for (int i = 1; i < listeJoueurTrie.size(); i++) {
            Joueur joueurCourant = listeJoueurTrie.get(i);
            int j = i - 1;

            while (j >= 0 && listeJoueurTrie.get(j).getValeurDe() < joueurCourant.getValeurDe()) {
                listeJoueurTrie.set(j + 1, listeJoueurTrie.get(j));
                j--;
            }

            listeJoueurTrie.set(j + 1, joueurCourant);
        }
    }

    public void boucleAnimationDe(AnimationListener listener){
        AnimationTimer at = new AnimationTimer() {
            private long dernierTemps = 0;
            private long tempsAccumule = 0;
            private static final long FPS = 69L * 1_000_000; //correspond à 144 FPS
            @Override
            public void handle(long now) {

                if (dernierTemps == 0) {
                    dernierTemps = now;
                } else {
                    long tempsEcoule = now - dernierTemps;
                    dernierTemps = now;
                    tempsAccumule += tempsEcoule;
                    if (tempsAccumule >= FPS) {
                        animationDe();
                        tempsAccumule -= FPS;
                        if (affichage.isDeLances()){
                            if (Math.random() < 0.25){
                                System.out.println("j'arrête la boucle");
                                if (listener != null){
                                    listener.animationTerminee();
                                }
                                stop();
                            }
                        }
                    }
                }
            }
        };
        at.start();

    }

    public void initialiserImagesDes(){
        de1 = new ImageJeu(getClass().getResource(new SourceImages().getSourceImage(SourceImages.nomImage.DE1)).toExternalForm());
        de2 = new ImageJeu(getClass().getResource(new SourceImages().getSourceImage(SourceImages.nomImage.DE2)).toExternalForm());
        de3 = new ImageJeu(getClass().getResource(new SourceImages().getSourceImage(SourceImages.nomImage.DE3)).toExternalForm());
        de4 = new ImageJeu(getClass().getResource(new SourceImages().getSourceImage(SourceImages.nomImage.DE4)).toExternalForm());
        de5 = new ImageJeu(getClass().getResource(new SourceImages().getSourceImage(SourceImages.nomImage.DE5)).toExternalForm());
        de6 = new ImageJeu(getClass().getResource(new SourceImages().getSourceImage(SourceImages.nomImage.DE6)).toExternalForm());
    }

    public void animationDe(){
        monopoly.getDe()[0].melangerDe();
        monopoly.getDe()[1].melangerDe();
        valeurDe1 = monopoly.getDe()[0].getValeur();
        valeurDe2 = monopoly.getDe()[1].getValeur();

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
    }


    public AffichageAttributionOrdre getAffichage(){
        return this.affichage;
    }
}
