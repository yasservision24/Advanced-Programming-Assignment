package com.example.stick_hero_game;


import javafx.animation.AnimationTimer;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Stick_Hero_Game extends Application {
    private boolean cherryCountIncremented = false;
    private boolean bool=false;
    private boolean isUpsideDown=false;

    Stage mystage;
    private boolean gameOver = false;
    int numCherries=0;

    private Platform rect1;
    private int score = 0;
    private Platform rect2;
    private Platform rect3;
    private static final int WIDTH = 1550;
    private static final double initialCharacterHeight = 55500; // Adjust the initial height as needed

    private static final int HEIGHT = 795;
    private boolean extendStick = false;
    private double stickHeight = 0;
    private double rotationAngle = 0;
    private double characterWidth = 60; // Adjust the character width as needed
    private double stickX = 500; // Adjust as needed based on your Insets
    private double stickY = 400; // Adjust as needed based on your Insets
    private double characterX = stickX; // Initial horizontal position of the character

    private Canvas canvas;
    private ImageView characterImageView; // Declare the character image view as a field
    private ImageView characterImageViewdown;






    @Override
    public void start(Stage primaryStage) {

        mystage=primaryStage;

        // Initialize the canvas

        canvas = new Canvas(WIDTH, HEIGHT);

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();


        // Add the cherry image view to the root pane



        initializeGame();

        scene.setOnMousePressed(event -> {

            // Toggle isUpsideDown when the primary mouse button is clicked (usually the left button)

            extendStick = true;
            stickHeight = 0;
            rotationAngle = 0;
            characterX = stickX; // Reset the horizontal position of the character
            cherryCountIncremented = false;
            bool = false;
            isUpsideDown=false;



        });

        scene.setOnMouseReleased(event -> {
            extendStick = false;
        });

        new AnimationTimer() {
            long lastNanoTime = System.nanoTime();
            boolean rotationComplete = false;

            @Override
            public void handle(long currentNanoTime) {
                double elapsedTime = (currentNanoTime - lastNanoTime) / 1e9; // Convert to seconds



                if (extendStick) {
                    if (!bool) {
                        Image cherryImage = new Image("file:downloadcherry.png");
                        ImageView cherryImageView = new ImageView(cherryImage);
                        double cherryWidth = 50; // Set the desired width
                        double cherryHeight = 50; // Set the desired height
                        cherryImageView.setFitWidth(cherryWidth);
                        cherryImageView.setFitHeight(cherryHeight);
                        StackPane.setAlignment(cherryImageView, Pos.BOTTOM_LEFT);
                        StackPane.setMargin(cherryImageView, new Insets(0, 10 / cmToPixels(), 340, 700));

                        // Add the cherry image view to the root pane
                        StackPane rootPane = (StackPane) canvas.getParent();
                        rootPane.getChildren().add(cherryImageView);

                        bool = true;
                    }
                    // Increase the size of the stick
                    stickHeight += 100 * elapsedTime; // Adjust the growth rate as needed
                } else if (rotationAngle < 90) {
                    // Rotate the stick when the mouse click is released
                    rotationAngle += 180 * elapsedTime; // Adjust the rotation speed as needed

                } else if (rotationAngle >= 90 && stickHeight != 0 && characterX < stickHeight + stickX) {
                    StackPane rootPane = (StackPane) canvas.getParent();
                    if(characterX>700) {
                        rootPane.getChildren().removeIf(node -> node instanceof ImageView);
                        bool = false;
                    }









                    // Move the character horizontally after rotation is complete
                    rotationComplete = true;
                    characterX += 100 * elapsedTime; // Adjust the movement speed as needed
                    scene.setOnKeyPressed(event -> {
                        if (event.getCode() == KeyCode.SPACE) {
                            // Toggle isUpsideDown only when the space bar is pressed
                            isUpsideDown = !isUpsideDown;
                        }
                    });

                    // Adjust the character position only when the rotation is complete
                    if (rotationComplete) {
                        StackPane.setMargin(characterImageView, new Insets(400 - initialCharacterHeight, 400, 400, 500 + characterX));
                        if(characterX>=stickHeight+stickX){
                            if(characterX<850 && characterX>rect1.getWidth()+500){
                                if(numCherries>=3){
                                    numCherries=numCherries-3;
                                    resumeGame();
                                }
                                else{
                                    stopGame();

                                }



                            }
                        }
                    }

                    if (characterX >= 700 && characterX < 702 && !cherryCountIncremented && isUpsideDown) {
                        // Increase cherry count when characterX is between 700 and 750
                        numCherries++;
                        cherryCountIncremented = true;
                        System.out.println("Cherry Count: " + numCherries);








                    }
                    if(isUpsideDown && characterX > 850 && characterX < 850 + rect2.getWidth()){
                        if(numCherries>=3){
                            numCherries=numCherries-3;
                            resumeGame();
                        }
                        else{
                            stopGame();


                        }

                    }
                    // Check if characterX is between 850 and 850 + rect2.getWidth()
                    if (characterX > 850 && characterX < 850 + rect2.getWidth() ) {






                        stickHeight = 0;extendStick = false;





                        // Set the character and stick positions



                        // Remove the left rectangle by sliding



                        TranslateTransition characterTransition = new TranslateTransition(Duration.seconds(2), characterImageView);
                        characterTransition.setToX(-350); // Adjust the distance as needed
                        characterTransition.play();



                        // Create a transition for rect1 (sliding to the left)
                        TranslateTransition rect1Transition = new TranslateTransition(Duration.seconds(2), rect1);
                        rect1Transition.setToX(-(rect1.getWidth()+2000)); // Slide rect1 to the left

                        TranslateTransition rect2Transition = new TranslateTransition(Duration.seconds(2), rect2);
                        rect2Transition.setToX(-350); // Slide rect2 to the left

                        rect3=new Platform(400);
                        StackPane.setAlignment(rect3, Pos.BOTTOM_LEFT);
                        double cmToPixels = 2.54 / 96.0;
                        StackPane.setMargin(rect3, new Insets(5, 10 / cmToPixels, 0, 1600));
                        rootPane.getChildren().add(rect3);
                        TranslateTransition rect3Transition = new TranslateTransition(Duration.seconds(2), rect3);
                        rect3Transition.setToX(-750); // Slide rect1 to the left




                        // Play both transitions

                        rect2Transition.play();
                        rect1Transition.play();
                        rect3Transition.play();


                        rect3Transition.setOnFinished(event -> {
                            rootPane.getChildren().remove(rect1);rootPane.getChildren().remove(rect2);rootPane.getChildren().remove(rect3);

                            System.out.println(rect1.getWidth());
                            rect1=new Platform(rect2);
                            StackPane.setAlignment(rect1, Pos.BOTTOM_LEFT);

                            StackPane.setMargin(rect1, new Insets(5, 10 / cmToPixels(), 0, 500));
                            rootPane.getChildren().add(rect1);


                            rect2=new Platform(rect3);
                            StackPane.setAlignment(rect2, Pos.BOTTOM_LEFT);

                            StackPane.setMargin(rect2, new Insets(5, 10 / cmToPixels(), 0, 850));
                            rootPane.getChildren().add(rect2);
                            characterX=stickX;
                            // Reset translation
                        });
                        score++;










                    }
                }


                drawStick();

                updateGame(elapsedTime);
                renderGame(canvas.getGraphicsContext2D());

                lastNanoTime = currentNanoTime;


            }


        }.start();

    }

    private void initializeGame() {
        rect1 = new Platform(400); // Width=100, Height=400
        rect1.setFill(Color.BLACK);

        rect2 = new Platform(400); // Width=100, Height=400
        rect2.setFill(Color.BLACK);
        Image backgroundImage = new Image("file:background.png");

        // Create a background image and set its properties
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                null,
                null,
                null,
                new BackgroundSize(WIDTH, HEIGHT, false, false, false, false)
        );

        // Set the background image to the root pane
        StackPane rootPane = (StackPane) canvas.getParent();
        rootPane.setBackground(new Background(background));

        // Add both rectangles to the root pane and position them at the bottom left
        rootPane.getChildren().addAll(rect1, rect2);

        // Load the character image
        Image characterImage = new Image("file:char.png"); // Replace with your image URL
        characterImageView = new ImageView(characterImage);
        characterImageView.setFitWidth(characterWidth);


        Image characterImagedown = new Image("file:char.png"); // Replace with your image URL
        characterImageViewdown = new ImageView(characterImagedown);
        characterImageViewdown.setFitWidth(characterWidth);
        characterImageViewdown.setScaleY(-1);
        StackPane.setAlignment(characterImageViewdown, Pos.BOTTOM_LEFT);
        double cmToPixels = 2.54 / 96.0;
        StackPane.setAlignment(characterImageViewdown, Pos.BOTTOM_LEFT);

        //rootPane.getChildren().add(characterImageViewdown);




        // Add the character image view to the root pane

        // Center the character image at the bottom left (5 cm away from the left side)
        StackPane.setAlignment(characterImageView, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(characterImageViewdown, Pos.BOTTOM_LEFT);
        //double cmToPixels = 2.54 / 96.0; // Assuming 96 DPI, convert cm to pixels

        Text startText = new Text("");
        startText.setFont(Font.font("Arial", 100));
        startText.setFill(Color.BLACK);

        // Add text to the root pane
        rootPane.getChildren().add(startText);
        // Load the cherry image
        Image cherryImage = new Image("file:downloadcherry.png"); // Replace with your cherry image URL
        //ImageView cherryImageView = new ImageView(cherryImage);

// Adjust the size of the cherry image
//        double cherryWidth = 50; // Set the desired width
//        double cherryHeight = 50; // Set the desired height
//        cherryImageView.setFitWidth(cherryWidth);
//        cherryImageView.setFitHeight(cherryHeight);

// Set the position of the cherry using Insets
//        StackPane.setAlignment(cherryImageView, Pos.BOTTOM_LEFT);
//        StackPane.setMargin(cherryImageView, new Insets(0, 10 / cmToPixels, 400, 700));

// Add the cherry image view to the root pane
//        rootPane.getChildren().add(cherryImageView);


        // Center the text in the StackPane
        StackPane.setAlignment(startText, Pos.CENTER);

        // Position the rectangles at the bottom left (5 cm away from the left side)

        StackPane.setAlignment(rect1, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(rect2, Pos.BOTTOM_LEFT);

        StackPane.setMargin(rect1, new Insets(5, 10 / cmToPixels, 0, 500));
        StackPane.setMargin(rect2, new Insets(5, 10 / cmToPixels() + 120, 0, 850)); // Adjust the margin for the second rectangle

        // ... (existing code)
    }

    private void drawStick() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, WIDTH, HEIGHT); // Clear the canvas

        // Draw the stick
        gc.save(); // Save the current graphics context state
        gc.translate(stickX, stickY); // Translate to the stick's base position
        gc.rotate(rotationAngle); // Rotate the stick
        gc.setStroke(Color.BROWN);
        gc.setLineWidth(10);
        gc.strokeLine(0, 0, 0, -stickHeight); // Adjust the length as needed

        // Adjust the rotation angle to ensure it doesn't exceed 360 degrees
        if (rotationAngle >= 91) {
            rotationAngle = 90;
        }

        gc.restore(); // Restore the graphics context state

        // Draw the character image at the end of the stick
        if (!isUpsideDown) {
            gc.drawImage(characterImageView.getImage(),
                    characterX - characterWidth / 2 + 25, 345);
        }

        if(isUpsideDown){
            gc.drawImage(characterImageViewdown.getImage(),
                    characterX - characterWidth / 2 + 25, 395);

        }
    }

    private void updateGame(double elapsedTime) {
        // Update positions, check collisions, and handle game logic
    }

    private void renderGame(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Arial", 50));
        gc.fillText("Score: " + score, 40, 50);

        // Display cherry count
        gc.fillText("Cherries: " + numCherries, 40, 110);

        // Render game elements, score, cherry count, and other information on the canvas
    }

    private double cmToPixels() {
        return 2.54 / 96.0; // Assuming 96 DPI, convert cm to pixels
    }
    private void stopGame() {
        System.out.println("Game Over! ");

        // Calculate the final score
        int finalScore = score;
        System.out.println("Final Score: " + finalScore);

        // Display cherry count
        System.out.println("Final Cherry Count: " + numCherries);

        // Set the game-over flag to true
        gameOver = true;

        // Display the final score and cherry count on the pane
        Text gameOverText = new Text("Game Over!");
        gameOverText.setFont(Font.font("Arial", 70));
        gameOverText.setFill(Color.YELLOW);

        Text finalScoreText = new Text("Final Score: " + finalScore);
        finalScoreText.setFont(Font.font("Arial", 40));
        finalScoreText.setFill(Color.BLACK);

        Text cherryCountText = new Text("Cherry : " + numCherries);
        cherryCountText.setFont(Font.font("Arial", 40));
        cherryCountText.setFill(Color.RED);

        // Button to go back to the calling class
        Button backButton = new Button("Restart");
        backButton.setFont(Font.font("Arial", 20));
        backButton.setOnAction(event -> {
            restartApplication();
        });

        // Center the texts and button in the pane
        StackPane rootPane = (StackPane) canvas.getParent();
        rootPane.getChildren().addAll(gameOverText, finalScoreText, cherryCountText, backButton);
        StackPane.setAlignment(gameOverText, Pos.CENTER);
        StackPane.setAlignment(finalScoreText, Pos.TOP_CENTER);

        // Set a margin for cherryCountText to position it below finalScoreText
        StackPane.setMargin(cherryCountText, new Insets(0, 0, -20, 500)); // Adjust the bottom margin as needed

        StackPane.setAlignment(cherryCountText, Pos.TOP_CENTER);
        StackPane.setAlignment(backButton, Pos.BOTTOM_CENTER);
    }


    private void restartApplication() {
        try {
            Stick_Hero_Game newGame = new Stick_Hero_Game();
            newGame.start(new Stage());
            mystage.close(); // Close the current stage
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void resumeGame() {
        StackPane rootPane = (StackPane) canvas.getParent();

        // Display the "Game Resumed!" message
        showGameResumedMessage(rootPane);
    }

    private void showGameResumedMessage(StackPane rootPane) {
        Text resumedText = new Text("Game Resumed!  3 cherries deducted");
        resumedText.setFont(Font.font("Arial", 40));
        resumedText.setFill(Color.GREEN);

        // Add the text to the root pane
        rootPane.getChildren().add(resumedText);

        // Schedule the removal of the text after 1 second
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> rootPane.getChildren().remove(resumedText));
        pause.play();
    }




    public static void main(String[] args) {

        launch(args);
    }

}