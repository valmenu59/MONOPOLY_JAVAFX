package Modele.Jeu;

public class Carte {
    private String texte;
    private int argent = 0;
    //private Case allerCase;
    private boolean imposition = false;

    private int valeurMaison = 0;
    private int valeurHotel = 0;
    private boolean carteLibererPrison = false;
    private int avancerCase = 0;
    private int recoitJoueur = 0;
    private boolean tirerCarteChance = false;


    public Carte(String texte, int argent, boolean imposition, boolean carteLibererPrison,
                 int avancerCase, int recoitJoueur, boolean tirerCarteChance){
        this.texte = texte;
        this.argent = argent;
        this.imposition = imposition;
        this.carteLibererPrison = carteLibererPrison;
        this.avancerCase = avancerCase;
        this.recoitJoueur = recoitJoueur;
        this.tirerCarteChance = tirerCarteChance;
    }

    public Carte(String texte){
        this.texte = texte;
    }

    public Carte(String texte, int valeurMaison, int valeurHotel){
        this.texte = texte;
        this.imposition = true;
        this.valeurMaison = valeurMaison;
        this.valeurHotel = valeurHotel;
    }

    public Carte(String texte, int argent){
        this.texte = texte;
        this.argent = argent;
    }

    public Carte(String texte, boolean carteLibererPrison){
        this.texte = texte;
        this.carteLibererPrison = carteLibererPrison;
    }

    public String getTexte() {
        return texte;
    }

    public int getArgent() {
        return argent;
    }

    public int getAvancerCase() {
        return avancerCase;
    }

    public boolean isCarteLibererPrison() {
        return carteLibererPrison;
    }

    public boolean isImposition() {
        return imposition;
    }

    public boolean isTirerCarteChance() {
        return tirerCarteChance;
    }

    public int getRecoitJoueur() {
        return recoitJoueur;
    }
}
