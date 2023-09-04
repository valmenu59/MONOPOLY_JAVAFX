package Modele.Jeu;

public class Plateau {

    private final Case[] cases = new Case[40];

    public Plateau(){
        initialiserPlateau();
    }

    public void initialiserPlateau(){
        cases[0] = new Depart();
        cases[1] = new Propriete(1, "BOULEVARD DE BELLEVILLE", 60, 2,
                10, 30, 90, 160, 250, 30, 50, Couleurs.MARRON);
        cases[2] = new CaisseCommunaute(2);
        cases[3] = new Propriete(3, "RUE LECOURBE", 60, 4,
                20, 60, 180, 320, 450, 30, 50, Couleurs.MARRON);
        cases[4] = new Cotisation(4, "IMPOTS SUR LE REVENU", 200);
        cases[5] = new Gare(5, "GARE MONTPARNASSE");
        cases[6] = new Propriete(6, "RUE DE VAUGIRARD", 100, 6,
                30, 90, 270, 400, 550, 50, 50, Couleurs.BLEU_CIEL);
        cases[7] = new Chance(7);
        cases[8] = new Propriete(8, "RUE DE COURCELLES", 100, 6,
                30, 90, 270, 400, 550, 50, 50, Couleurs.BLEU_CIEL);
        cases[9] = new Propriete(9, "AVENUE DE LA REPUBLIQUE", 120, 8,
                40, 100, 300, 450, 600, 60, 50, Couleurs.BLEU_CIEL);
        cases[10] = new VisiteLibre(10);
        cases[11] = new Propriete(11, "BOULEVARD DE LA VILLETTE", 140, 10,
                50, 150, 450, 625, 750, 70, 100, Couleurs.ROSE);
        cases[12] = new Compagnie(12, "COMPAGNIE DE DISTRIBUTION D'ELECTRICITE");
        cases[13] = new Propriete(13, "AVENUE DE NEUILLY", 140, 10,
                50, 150, 450, 625, 750, 70, 100, Couleurs.ROSE);
        cases[14] = new Propriete(14, "RUE DE PARADIS", 160, 12,
                60, 180, 500, 700, 900, 80, 100, Couleurs.ROSE);
        cases[15] = new Gare(15, "GARE DE LYON");
        cases[16] = new Propriete(16, "AVENUE DE MOZART", 180, 14,
                70, 200, 550, 750, 950, 90, 100, Couleurs.ORANGE);
        cases[17] = new CaisseCommunaute(17);
        cases[18] = new Propriete(18, "BOULEVARD SAINT-MICHEL", 180, 14,
                70, 200, 550, 750, 950, 90, 100, Couleurs.ORANGE);
        cases[19] = new Propriete(19, "PLACE PIGALLE", 200, 16,
                80, 220, 600, 800, 1000, 100, 100, Couleurs.ORANGE);
        cases[20] = new ParcGratuit(20);
        cases[21] = new Propriete(21, "AVENUE MATIGNON", 220, 18,
                90, 250, 700, 875, 1050, 110, 150, Couleurs.ROUGE);
        cases[22] = new Chance(22);
        cases[23] = new Propriete(23, "BOULEVARD MALESHERBES", 220, 18,
                90, 250, 700, 875, 1050, 110, 150, Couleurs.ROUGE);
        cases[24] = new Propriete(24, "AVENUE HENRI-MARTIN", 240, 20,
                100, 300, 750, 925, 1100, 120, 150, Couleurs.ROUGE);
        cases[25] = new Gare(25, "GARE DU NORD");
        cases[26] = new Propriete(26, "FAUBOURG SAINT-HONORE", 260, 22,
                110, 330, 800, 975, 1150, 130, 150, Couleurs.JAUNE);
        cases[27] = new Propriete(27, "PLACE DE LA BOURSE", 260, 22,
                110, 330, 800, 975, 1150, 130, 150, Couleurs.JAUNE);
        cases[28] = new Compagnie(28, "COMPAGNIE DE DISTRIBUTION DES EAUX");
        cases[29] = new Propriete(29, "RUE LA FAYETTE", 280, 24,
                120, 360, 850, 1025, 1200, 140, 150, Couleurs.JAUNE);
        cases[30] = new AllerPrison(30);
        cases[31] = new Propriete(31, "AVENUE DE BRETEUIL", 300, 26,
                130, 390, 900, 1100, 1270, 150, 200, Couleurs.VERT);
        cases[32] = new Propriete(32, "AVENUE FOSH", 300, 26,
                130, 390, 900, 1100, 1270, 150, 200, Couleurs.VERT);
        cases[33] = new CaisseCommunaute(33);
        cases[34] = new Propriete(34, "BOULEVARD DES CAPUCINES", 320, 28,
                150, 450, 1000, 1200, 1400, 160, 200, Couleurs.VERT);
        cases[35] = new Gare(35, "GARE SAINT-LAZARE");
        cases[36] = new Chance(36);
        cases[37] = new Propriete(37, "AVENUE DES CHAMPS-ELYSEES", 350, 35,
                175, 500, 1100, 1300, 1500, 175, 200, Couleurs.BLEU);
        cases[38] = new Cotisation(38, "TAXE DE LUXE", 100);
        cases[39] = new Propriete(39, "RUE DE LA PAIX", 400, 50,
                200, 600, 1400, 1700, 2000, 200, 200, Couleurs.BLEU);
    }
}
