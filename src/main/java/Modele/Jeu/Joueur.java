package Modele.Jeu;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

    private String surnom;
    private int argent;

    private final List<Propriete> listeProprietes = new ArrayList<>();
    private final List<Gare> listeGares = new ArrayList<>();
    private final List<Compagnie> listeCompagnies = new ArrayList<>();


    public Joueur(String surnom){
        this.surnom = surnom;
        this.argent = 1500;
    }

    public String getSurnom(){
        return this.surnom;
    }

    public int getArgent() {
        return argent;
    }

    public List<Propriete> getListeProprietes() {
        return listeProprietes;
    }

    public List<Gare> getListeGares() {
        return listeGares;
    }

    public List<Compagnie> getListeCompagnies() {
        return listeCompagnies;
    }

    @Override
    public String toString() {
        return surnom+"\n$"+argent;
    }
}
