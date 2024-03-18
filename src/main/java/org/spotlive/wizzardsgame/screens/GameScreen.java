package org.spotlive.wizzardsgame.screens;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class GameScreen {

    public Pane screenView;

    GameScreen() {
        // Crea la vista dello schermo di gioco
        screenView = new Pane();
    }

    public void update() {
        // ...
    }

    public void init() {
    }

    public Node getView() {
        return screenView;
    }
}
