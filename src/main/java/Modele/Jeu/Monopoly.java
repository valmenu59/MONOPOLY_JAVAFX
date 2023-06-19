package Modele.Jeu;

import java.util.ArrayList;
import java.util.List;

public class Monopoly {

    private final De[] tableauDes;
    private final CartesChance  cartesChance;
    private final CartesCaisse cartesCaisse;
    private int nombreMaisons;
    private int nombreHotels;
    private Plateau plateau;
    private final List<Joueur> listeJoueurs = new ArrayList<>();

    public Monopoly(){
        tableauDes = new De[]{new De(), new De()};
        cartesChance = new CartesChance();
        cartesCaisse = new CartesCaisse();
        cartesChance.melangerPile();
        cartesCaisse.melangerPile();
        nombreMaisons = 32;
        nombreHotels = 12;
        plateau = new Plateau();
    }

    public De[] getDe(){
        return tableauDes;
    }

    public CartesCaisse getCartesCaisse(){
        return cartesCaisse;
    }

    public CartesChance getCartesChance(){
        return cartesChance;
    }


    public int getNombreMaisons() {
        return nombreMaisons;
    }

    public int getNombreHotels() {
        return nombreHotels;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public List<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }
}
