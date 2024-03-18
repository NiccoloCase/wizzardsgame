package org.spotlive.wizzardsgame.characters;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player implements Entity {
    private static final int RECTANGLE_SIZE = 50;
    private final Rectangle rect;

    public Player() {
        rect = new Rectangle(RECTANGLE_SIZE, RECTANGLE_SIZE, Color.BLUE);
    }

    @Override
    public Node getView() {
        return rect;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
    }

}
