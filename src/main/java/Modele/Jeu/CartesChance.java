package Modele.Jeu;

import Modele.Jeu.Carte;

import java.util.Collections;
import java.util.Stack;

public class CartesChance {

    private final Stack<Carte> pile;

    public CartesChance(){
        pile = new Stack<>();
        pile.add(new Carte("Rendez-vous à la Rue de la Paix"));
        pile.add(new Carte("Avancer jusqu’à la case départ"));
        pile.add(new Carte("Rendez-vous à l’Avenue Henri-Martin. Si vous passez par la case départ, recevez $200"));
        pile.add(new Carte("Avancez au Boulevard de La Villette. Si vous passez par la case départ, recevez $200"));
        pile.add(new Carte("Vous êtes imposé pour les réparations de voirie à raison de $40 par maison et $115 par hôtel.", 40, 115));
        pile.add(new Carte("Avancez jusqu’à la Gare de Lyon. Si vous passez par la case départ, recevez $200"));
        pile.add(new Carte("Vous avez gagné le prix de mots croisés. Recevez $100", 100));
        pile.add(new Carte("La banque vous verse un dividende de $50", 50));
        pile.add(new Carte("Vous êtes libéré de prison. Cette carte peut être conservée jusqu’à ce qu’elle soit utilisée ou vendue.", true));
        pile.add(new Carte("Reculez de trois cases"));
        pile.add(new Carte("Aller en prison. Rendez-vous directement en prison. Ne franchissez pas par la case départ, ne touchez pas $200"));
        pile.add(new Carte("Faites des réparations dans toutes vos maisons. Versez pour chaque maison $25. Versez pour chaque hôtel $100"));
        pile.add(new Carte("Amende pour excès de vitesse $15"));
        pile.add(new Carte("Payez pour frais de scolarité $150"));
        pile.add(new Carte("Amende pour ivresse $20"));
        pile.add(new Carte("Votre immeuble et votre prêt rapportent. Vous devez toucher $150"));
    }

    public void melangerPile(){
        Collections.shuffle(pile);
    }

    public Carte getCarte(){
        return pile.pop();
    }

    public Stack<Carte> getPile(){
        return pile;
    }
}
