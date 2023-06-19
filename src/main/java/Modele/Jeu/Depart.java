package Modele.Jeu;

public class Depart extends Case {

    private static final int SOMME_A_RECEVOIR = 200;

    public Depart(){
        super(0, "DEPART");
    }

    public int getSommeARecevoir(){
        return SOMME_A_RECEVOIR;
    }
}
