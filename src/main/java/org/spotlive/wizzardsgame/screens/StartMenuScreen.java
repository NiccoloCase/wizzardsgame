package org.spotlive.wizzardsgame.screens;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.spotlive.wizzardsgame.Main;
import org.spotlive.wizzardsgame.characters.Player;

public class StartMenuScreen extends Screen {






    public StartMenuScreen() {
        super();

    }

    @Override
    public void init() {
        // Creazione dei pulsanti del menu principale
        Button playButton = new Button("Play");
        Button optionsButton = new Button("Options");
        Button exitButton = new Button("Exit");

        // Imposta un'azione per il pulsante Play (puoi aggiungere azioni anche per gli altri pulsanti)
        playButton.setOnAction(event -> {
            Main.gameStateManager.startGame();
        });

        // Creazione di un layout per organizzare i pulsanti verticalmente
        VBox layout = new VBox(10); // Spazio tra i pulsanti
        layout.getChildren().addAll(playButton, optionsButton, exitButton);

        // Imposta il layout come contenuto della schermata
        screenView = new Pane(layout);


    }

    @Override
    public void update() {
        // Aggiorna la vista del menu principale
    }
}
