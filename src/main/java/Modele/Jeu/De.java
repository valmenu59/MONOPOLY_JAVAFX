package Modele.Jeu;

import java.util.Random;

public class De {

    private int valeur;

    public De(){
        melangerDe();
    }

    public void melangerDe(){
        Random random = new Random();
        valeur =  random.nextInt(1,7);
    }

    public void setValeurDe(int val){
        valeur = val;
    }

    public int getValeur(){
        return valeur;
    }

}
