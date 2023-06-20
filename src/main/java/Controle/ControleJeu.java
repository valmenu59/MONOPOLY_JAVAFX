package Controle;

import Affichage.AffichageJeu;
import Affichage.fx.ImageJeu;
import Modele.Jeu.Joueur;
import Modele.Jeu.Monopoly;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.ImagePattern;

import java.util.*;

public class ControleJeu {

    private final AffichageJeu affichage;
    private final Monopoly monopoly;
    private final List<Joueur> listeJoueur = new ArrayList<>();
    private final List<Integer> ordreNombreDe = new ArrayList<>();
    private int valeurDe1, valeurDe2;
    private AnimationTimer boucleAnimationDe;
    private boolean animationFinie = false;
    private AnimationListener animationListener;
    private boolean animationEnCours = false;
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
        affichage.affichageTexteDebutDePartie();





    }










}
