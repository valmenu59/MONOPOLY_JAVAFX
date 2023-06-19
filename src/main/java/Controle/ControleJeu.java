package Controle;

import Affichage.AffichageJeu;
import Modele.Jeu.Joueur;
import Modele.Jeu.Monopoly;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ControleJeu {

    private AffichageJeu affichage;
    private Monopoly monopoly;

    public ControleJeu(){
        affichage = new AffichageJeu();
        monopoly = new Monopoly();
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
    }

    public void attributionOrdreJoueurs(){
        
    }

    public AffichageJeu getAffichage(){
        return this.affichage;
    }



    public void lancerDe(){

    }





}
