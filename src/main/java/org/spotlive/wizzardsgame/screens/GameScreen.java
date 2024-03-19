package org.spotlive.wizzardsgame.screens;

import javafx.scene.control.Button;
import org.spotlive.wizzardsgame.Main;
import org.spotlive.wizzardsgame.characters.Player;

public class GameScreen extends Screen {

    Player player;

    public GameScreen() {
        super();
        player = new Player();
        screenView.getChildren().add(player.getView());


        // Aggiunge bottone per menu
        Button menuButton = new Button("Menu");
        menuButton.setOnAction(event -> {
            Main.gameStateManager.openMenu();
        });
        screenView.getChildren().add(menuButton);


    }

}
