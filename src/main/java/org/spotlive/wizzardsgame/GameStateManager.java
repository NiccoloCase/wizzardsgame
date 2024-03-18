package org.spotlive.wizzardsgame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import org.spotlive.wizzardsgame.screens.GameScreen;
import java.util.Stack;

public class GameStateManager {
    private final Stack<GameScreen> screenStack;
    private final Scene scene;

    public GameStateManager() {
        screenStack = new Stack<>();
        Pane root = new Pane();
        scene = new Scene(root, 800, 600);
        Main.primaryStage.setScene(scene);
    }

    public void pushScreen(GameScreen screen) {
        screenStack.push(screen);
        screen.init();
    }

    public void setActiveScreen() {
        GameScreen currentScreen = screenStack.peek();
        Pane root = (Pane) scene.getRoot();
        root.getChildren().clear();
        root.getChildren().add(currentScreen.getView());
        currentScreen.update();
    }
}
