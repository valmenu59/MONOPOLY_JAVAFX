package Modele.Jeu;

public class Compagnie extends Terrain {

    private static final int VALEUR_HYPOTHEQUE = 75;
    private static final int MULTIPLICATEUR1 = 4;
    private static final int MULTIPLICATEUR2 = 10;

    public Compagnie(int numeroCase){
        super(numeroCase, 150);
    }

    public int getValeurHypotheque(){
        return VALEUR_HYPOTHEQUE;
    }

    public int getMultiplicateur1(){
        return MULTIPLICATEUR1;
    }

    public int getMultiplicateur2(){
        return MULTIPLICATEUR2;
    }
}
