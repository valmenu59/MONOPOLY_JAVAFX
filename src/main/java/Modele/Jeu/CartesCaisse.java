package Modele.Jeu;

import Modele.Jeu.Carte;

import java.util.Collections;
import java.util.Stack;

public class CartesCaisse {

    private final Stack<Carte> pile;

    public CartesCaisse(){
        pile = new Stack<>();
        pile.add(new Carte("Placez-vous sur la case départ"));
        pile.add(new Carte("Erreur de la banque en votre faveur. Recevez $200"));
        pile.add(new Carte("Payez la note du médecin $50"));
        pile.add(new Carte("La vente de votre stock vous rapporte $50"));
        pile.add(new Carte("Vous êtes libéré de prison. Cette carte peut être conservée jusqu’à ce qu’elle soit utilisée ou vendue."));
        pile.add(new Carte("Aller en prison. Rendez-vous directement à la prison. Ne franchissez pas par la case départ, ne touchez pas $200"));
        pile.add(new Carte("Retournez à Belleville"));
        pile.add(new Carte("Recevez votre revenu annuel $100"));
        pile.add(new Carte("C’est votre anniversaire. Chaque joueur doit vous donner $10"));
        pile.add(new Carte("Les contributions vous remboursent la somme de $20"));
        pile.add(new Carte("Recevez votre intérêt sur l’emprunt à 7% $25"));
        pile.add(new Carte("Payez votre Police d’Assurance $50"));
        pile.add(new Carte("Payez une amende de $10 ou bien tirez une carte « CHANCE »"));
        pile.add(new Carte("Rendez-vous à la gare la plus proche. Si vous passez par la case départ, recevez $200"));
        pile.add(new Carte("Vous avez gagné le deuxième Prix de Beauté. Recevez $10"));
        pile.add(new Carte("Vous héritez $100"));
    }

    public void melangerPile(){
        Collections.shuffle(pile);
    }

    public Stack<Carte> getPile(){
        return pile;
    }

    public Carte getCarte(){
        return pile.pop();
    }
}
