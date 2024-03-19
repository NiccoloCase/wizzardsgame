package org.spotlive.wizzardsgame.screens;

import javafx.scene.control.Button;
import org.spotlive.wizzardsgame.Main;

public class MenuScreen extends Screen {
    public MenuScreen() {
        super();
    }

    @Override
    public void init() {
        super.init();

        // Bottone per tornare al gioco
        Button resumeButton = new Button("Resume");
        resumeButton.setOnAction(event -> {
            Main.gameStateManager.startGame();
        });
        screenView.getChildren().add(resumeButton);
    }
}
