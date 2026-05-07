package com.prathamesh;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Label welcomeLabel = new Label("Welcome to Number Guessing Game!");

        Scene scene = new Scene(welcomeLabel, 400, 200);

        stage.setTitle("Number Guessing Game");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}