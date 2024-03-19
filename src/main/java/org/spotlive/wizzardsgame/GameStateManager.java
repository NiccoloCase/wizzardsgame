package org.spotlive.wizzardsgame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import org.spotlive.wizzardsgame.screens.GameScreen;
import org.spotlive.wizzardsgame.screens.MenuScreen;
import org.spotlive.wizzardsgame.screens.Screen;
import java.util.Stack;



public class GameStateManager {
    private final Stack<Screen> screenStack;
    private final Scene scene;
    
    public enum GameState {
        START_MENU,
        GAME,
        GAME_OVER
    }

    public GameState gameState;


    public GameStateManager() {
        screenStack = new Stack<>();
        Pane root = new Pane();
        scene = new Scene(root, 800, 600);

        gameState = GameState.START_MENU;

        Main.primaryStage.setScene(scene);

    }

    public void pushScreen(Screen screen) {
        screenStack.push(screen);
        screen.init();
    }

    public void setActiveScreen() {
        Screen currentScreen = screenStack.peek();
        Pane root = (Pane) scene.getRoot();
        root.getChildren().clear();
        root.getChildren().add(currentScreen.getView());
        currentScreen.update();
    }


    public void startGame () {
        this.gameState = GameState.GAME;
        Screen gameScreen = new GameScreen();
        pushScreen(gameScreen);
        setActiveScreen();
    }

    public void openMenu () {
        this.gameState = GameState.START_MENU;
        Screen startMenuScreen = new MenuScreen();
        pushScreen(startMenuScreen);
        setActiveScreen();
    }
}
