package org.spotlive.wizzardsgame;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.spotlive.wizzardsgame.screens.StartMenuScreen;


public class Main extends Application {

    public static Stage primaryStage;
    public static GameStateManager gameStateManager;



    @Override
    public void start(Stage primaryStage) {

        Main.primaryStage = primaryStage;

        // Ottieni le dimensioni dello schermo
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        // Imposta la finestra a tutto schermo
        Main.primaryStage.setX(screenBounds.getMinX());
        Main.primaryStage.setY(screenBounds.getMinY());
        Main.primaryStage.setWidth(screenBounds.getWidth());
        Main.primaryStage.setHeight(screenBounds.getHeight());

        // Disabilita la possibilità di ridimensionare la finestra
        Main.primaryStage.setResizable(false);

        // Imposta il titolo della finestra
        Main.primaryStage.setTitle("Wizzards Game");


        // Inizializzazione del GameStateManager
        gameStateManager = new GameStateManager();

        // Aggiunta della schermata del menu principale
        gameStateManager.pushScreen(new StartMenuScreen());

        // Impostazione della prima schermata
        gameStateManager.setActiveScreen();

        // Mostra la finestra principale
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
