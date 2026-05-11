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

    // Random object for generating numbers
    private final Random random = new Random();

    // Total remaining attempts
    private int remainingAttempts = 5;

    @Override
    public void start(Stage stage) {

        // Generate random number between 1 to 100
        secretNumber = random.nextInt(100) + 1;

        // Print secret number in console for testing
        System.out.println("Secret Number: " + secretNumber);

        // Title label
        Label titleLabel = new Label("Number Guessing Game");

        // Style title text
        titleLabel.setStyle(
                "-fx-font-size: 20px; " +
                        "-fx-font-weight: bold;"
        );

        // Instruction label
        Label instructionLabel = new Label("Guess a number between 1 and 100\nYou have 5 attempts");

        // Text field where user enters guess
        TextField guessField = new TextField();

        // Placeholder text inside input box
        guessField.setPromptText("Enter your guess");

        // Set preferred width for input field
        guessField.setMaxWidth(200);

        // Button to submit guess
        Button guessButton = new Button("Submit Guess");

        // Style submit button
        guessButton.setStyle("-fx-font-size: 14px");

        // Button to restart the game
        Button restartButton = new Button("Restart Game");

        // Style restart button
        restartButton.setStyle("-fx-font-size: 14px");

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

            try {

                // Get text entered by user
                String userInput = guessField.getText();

                // Convert text into integer
                int guessedNumber = Integer.parseInt(userInput);

                // Reduce remaining attempts
                remainingAttempts--;

                /*
                 * Compare guessed number with secret number
                 */
                if (guessedNumber < secretNumber) {

                    resultLabel.setText(
                            "Too low! Attempts left: " + remainingAttempts
                    );

                } else if (guessedNumber > secretNumber) {

                    resultLabel.setText(
                            "Too high! Attempts left: " + remainingAttempts
                    );

                } else {

                    resultLabel.setText(
                            "Correct! You guessed the number!"
                    );

                    // Disable further guessing
                    guessField.setDisable(true);
                    guessButton.setDisable(true);
                }

                /*
                 * Check if player has used all attempts
                 */
                if (remainingAttempts == 0 && guessedNumber != secretNumber) {

                    resultLabel.setText(
                            "Game Over! The number was: " + secretNumber
                    );

                }

            } catch (NumberFormatException exception) {

                resultLabel.setText(
                        "Please enter a valid number!"
                );

            }

        });

        /*
        * Restart game button logic
        */
        restartButton.setOnAction(event ->{

            // Generate new secret number
            secretNumber = random.nextInt(100) + 1;

            // Reset attempts
            remainingAttempts = 5;

            // Clear input field
            guessField.clear();

            // Re-enable input controls
            guessField.setDisable(false);
            guessButton.setDisable(false);

            // Reset message label
            resultLabel.setText("New game started!");

            // Print new secret number for testing
            System.out.println("New Secret Number: " + secretNumber);
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
                restartButton,
                resultLabel
        );

        // Center all elements
        layout.setAlignment(Pos.CENTER);

        // Add spacing around window edges
        layout.setStyle("-fx-padding: 20;");

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