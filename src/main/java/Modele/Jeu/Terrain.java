package Modele.Jeu;

public class Terrain extends Case {

    private int valeurAchat;

    public Terrain(int numeroCase, String nom, int valeurAchat){
        super(numeroCase, nom);
        this.valeurAchat = valeurAchat;
    }

    private int getValeurAchat(){
        return this.valeurAchat;
    };
}
