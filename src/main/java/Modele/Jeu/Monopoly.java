package Modele.Jeu;

public class Monopoly {

    private final De[] tableauDes;
    private final CartesChance  cartesChance;
    private final CartesCaisse cartesCaisse;

    public Monopoly(){
        tableauDes = new De[]{new De(), new De()};
        cartesChance = new CartesChance();
        cartesCaisse = new CartesCaisse();
        cartesChance.melangerPile();
        cartesCaisse.melangerPile();
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


}
