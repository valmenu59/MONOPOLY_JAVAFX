module main.monopoly_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.monopoly_fx to javafx.fxml;
    exports main.monopoly_fx;
    exports Modele.Jeu;
    opens Modele.Jeu to javafx.fxml;
    exports Controle;
    opens Controle to javafx.fxml;
}