package com.example.stick_hero_game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class Platform extends Rectangle {
    public Platform(double height) {
        setHeight(height);
        setWidth(generateRandomWidth());
        setFill(Color.BLACK); // You can customize the fill color if needed
    }

    // Copy constructor
    public Platform(Platform other) {
        setHeight(other.getHeight());
        setWidth(other.getWidth());
        setFill(other.getFill());
    }

    private double generateRandomWidth() {
        Random random = new Random();
        // Adjust the range of random width as needed
        return random.nextDouble() * 100 + 75; // Example: Random width between 50 and 150
    }
}
