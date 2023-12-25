module com.example.stick_hero_game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stick_hero_game to javafx.fxml;
    exports com.example.stick_hero_game;
}