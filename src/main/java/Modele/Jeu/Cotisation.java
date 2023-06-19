package Modele.Jeu;

public class Cotisation extends Case {

    int sommeAPayer;

    public Cotisation(int numeroCase, String nom, int sommeAPayer){
        super(numeroCase, nom);
        this.sommeAPayer = sommeAPayer;
    }

    public int getSommeAPayer(){
        return sommeAPayer;
    }
}
