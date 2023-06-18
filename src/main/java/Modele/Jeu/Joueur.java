package Modele.Jeu;

import java.util.List;

public class Joueur {

    private String surnom;
    private int argent;

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

}
