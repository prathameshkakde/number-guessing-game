package com.prathamesh;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

/*
 * Main class for the Number Guessing Game
 */
public class Main extends Application {

    // Secret random number for the game
    private int secretNumber;

    @Override
    public void start(Stage stage) {

        // Create Random object
        Random random = new Random();

        // Generate random number between 1 to 100
        secretNumber = random.nextInt(100) + 1;

        // Print secret number in console for testing
        System.out.println("Secret Number: " + secretNumber);

        // Title label
        Label titleLabel = new Label("Number Guessing Game");

        // Instruction label
        Label instructionLabel = new Label("Guess a number between 1 and 100");

        // Text field where user enters guess
        TextField guessField = new TextField();

        // Placeholder text inside input box
        guessField.setPromptText("Enter your guess");

        // Button to submit guess
        Button guessButton = new Button("Submit Guess");

        // Label for displaying game messages
        Label resultLabel = new Label("Game messages will appear here");

        /*
         * VBox layout:
         * Arranges all elements vertically
         */
        VBox layout = new VBox(15);

        // Add all UI elements into layout
        layout.getChildren().addAll(
                titleLabel,
                instructionLabel,
                guessField,
                guessButton,
                resultLabel
        );

        // Center all elements
        layout.setAlignment(Pos.CENTER);

        // Create scene
        Scene scene = new Scene(layout, 400, 300);

        // Window title
        stage.setTitle("Number Guessing Game");

        // Set scene into stage
        stage.setScene(scene);

        // Show window
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}