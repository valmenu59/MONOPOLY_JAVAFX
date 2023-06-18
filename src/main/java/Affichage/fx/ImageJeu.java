package Affichage.fx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageJeu extends Image {

    public ImageJeu(String url){
        super(url);
    }

    public ImageJeu(String url, double longueur, double largeur, boolean preserverRatio){
        super(url, longueur, largeur, preserverRatio, false);
    }

    public ImageView afficherImage(double longueur, double largeur, boolean preserverRatio){
        ImageView img = new ImageView(this);
        img.setFitWidth(longueur);
        img.setFitHeight(largeur);
        img.setPreserveRatio(preserverRatio);
        return img;
    }
}
