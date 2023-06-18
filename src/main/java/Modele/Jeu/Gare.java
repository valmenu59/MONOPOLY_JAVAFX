package Modele.Jeu;

public class Gare extends Terrain{

    private static final int LOYER1 = 25;
    private static final int LOYER2 = 50;
    private static final int LOYER3 = 100;
    private static final int LOYER4 = 200;

    public Gare(int numeroCase){
        super(numeroCase, 200);
    }

    public int getLoyer1(){
        return LOYER1;
    }

    public int getLoyer2(){
        return LOYER2;
    }

    public int getLoyer3(){
        return LOYER3;
    }

    public int getLoyer4(){
        return LOYER4;
    }
}
