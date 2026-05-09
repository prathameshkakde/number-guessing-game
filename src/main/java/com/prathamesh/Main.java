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

    // Total remaining attempts
    private int remainingAttempts = 5;

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
        Label instructionLabel = new Label("Guess a number between 1 and 100\nYou have 5 attempts");

        // Text field where user enters guess
        TextField guessField = new TextField();

        // Placeholder text inside input box
        guessField.setPromptText("Enter your guess");

        // Button to submit guess
        Button guessButton = new Button("Submit Guess");

        // Label for displaying game messages
        Label resultLabel = new Label("Game messages will appear here");

        /*
        * Event handler for button click
        */
        guessButton.setOnAction(e -> {

            /*
            * Stop game if no attempts remain
            */
            if (remainingAttempts <= 0) {
                resultLabel.setText("Game Over! Please restart the game.");
                return;
            }

            // Get text entered by user
            String userInput = guessField.getText();

            // Convert text into integer
            int guessedNumber = Integer.parseInt(userInput);
            remainingAttempts--;

            /*
            * Compare guessed number with secret number
            */
            if (guessedNumber < secretNumber) {
                resultLabel.setText("Too low! Attempts left: " + remainingAttempts);
            } else if (guessedNumber > secretNumber) {
                resultLabel.setText("Too high! Attempts left: " + remainingAttempts);
            } else {
                resultLabel.setText("Correct! You guessed the number!");
            }

            /*
            * Check if player has used all attempts
            */
            if (remainingAttempts == 0 && guessedNumber != secretNumber) {
                resultLabel.setText("Game Over! The number was: " + secretNumber);
            }

        });

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