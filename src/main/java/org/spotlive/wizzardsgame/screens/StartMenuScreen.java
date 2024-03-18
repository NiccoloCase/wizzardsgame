package org.spotlive.wizzardsgame.screens;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class StartMenuScreen extends GameScreen {

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
            // Azione da eseguire quando il pulsante Play viene premuto
            // Puoi implementare il codice per passare alla schermata di gioco qui
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
