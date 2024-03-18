package org.spotlive.wizzardsgame.characters;

import javafx.scene.Node;

public interface Entity {
    public Node getView();

    public void update();

    public void move();
}
