package main.monopoly_fx;

import Modele.Jeu.De;
import Modele.Jeu.Monopoly;

public class Test {

    public static void main(String[] args) {

        Monopoly monopoly = new Monopoly();
        System.out.println(monopoly.getDe()[0].getValeur());
        System.out.println(monopoly.getCartesChance().getCarte().getTexte());
        System.out.println(monopoly.getCartesChance().getPile().isEmpty());
    }
}
