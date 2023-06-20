package Affichage;

public class SourceImages {
    private static final String DE1 = "/de/de1.png";
    private static final String DE2 = "/de/de2.png";
    private static final String DE3 = "/de/de3.png";
    private static final String DE4 = "/de/de4.png";
    private static final String DE5 = "/de/de5.png";
    private static final String DE6 = "/de/de6.png";
    private static final String ARRIERE_PLAN = "/arrierePlanJeu.png";
    private static final String PLATEAU = "/monopoly-plateau.png";

    public enum nomImage {
        DE1, DE2, DE3, DE4, DE5, DE6, ARRIERE_PLAN, PLATEAU
    }

    public String getSourceImage(nomImage nom){
        switch (nom){
            case DE1 -> { return DE1; }
            case DE2 -> { return DE2; }
            case DE3 -> { return DE3; }
            case DE4 -> { return DE4; }
            case DE5 -> { return DE5; }
            case DE6 -> { return DE6; }
            case ARRIERE_PLAN -> {return ARRIERE_PLAN; }
            case PLATEAU -> { return PLATEAU; }
            default -> { return null; }
        }
    }

}
