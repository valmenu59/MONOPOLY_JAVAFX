package Controle;

import Affichage.AffichageJeu;
import Modele.Jeu.Monopoly;

public class ControleJeu {

    private AffichageJeu affichage;
    private Monopoly jeu;

    public ControleJeu(){
        affichage = new AffichageJeu();
        jeu = new Monopoly();
    }

    public AffichageJeu getAffichage(){
        return this.affichage;
    }

    public Monopoly getJeu(){
        return this.getJeu();
    }
}
