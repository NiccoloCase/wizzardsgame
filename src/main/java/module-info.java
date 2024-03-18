module org.spotlive.wizzardsgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.spotlive.wizzardsgame to javafx.fxml;
    exports org.spotlive.wizzardsgame;
}