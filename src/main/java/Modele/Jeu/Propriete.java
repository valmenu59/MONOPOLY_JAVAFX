package Modele.Jeu;

public class Propriete extends Terrain {

    public int loyer;
    private final int loyer1Maison;
    private final int loyer2Maisons;
    private final int loyer3Maisons;
    private final int loyer4Maisons;
    private final int loyerHotel;
    private final int valeurHypotheque;
    private final int valeurAchatMaison;
    private final Couleurs couleur;

    public Propriete(int numeroCase, int valeurAchat,
                     int loyer, int loyer1Maison, int loyer2Maisons, int loyer3Maisons, int loyer4Maisons, int loyerHotel,
                     int valeurHypotheque, int valeurAchatMaison, Couleurs couleur){
        super(numeroCase, valeurAchat);
        this.loyer = loyer;
        this.loyer1Maison = loyer1Maison;
        this.loyer2Maisons = loyer2Maisons;
        this.loyer3Maisons = loyer3Maisons;
        this.loyer4Maisons = loyer4Maisons;
        this.loyerHotel = loyerHotel;
        this.valeurHypotheque = valeurHypotheque;
        this.valeurAchatMaison = valeurAchatMaison;
        this.couleur = couleur;
    }

    public int getLoyer1Maison() {
        return loyer1Maison;
    }

    public int getLoyer2Maisons() {
        return loyer2Maisons;
    }

    public int getLoyer3Maisons() {
        return loyer3Maisons;
    }

    public int getLoyer4Maisons() {
        return loyer4Maisons;
    }

    public int getLoyerHotel() {
        return loyerHotel;
    }

    public int getValeurHypotheque() {
        return valeurHypotheque;
    }

    public int getValeurAchatMaison() {
        return valeurAchatMaison;
    }

    public Couleurs getCouleur() {
        return couleur;
    }
}
