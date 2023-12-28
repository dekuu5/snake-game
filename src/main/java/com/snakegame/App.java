package com.snakegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Scene scene;

    public void start(Stage stage) {
        stage.setTitle("Snake Game");

        Canvas canvas = new Canvas(800, 600);  // Adjust the size according to your needs

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        this.scene = new Scene(root, 800, 600);  
        stage.setScene(this.scene); 
        stage.show();

        // TODO: Initialize your game logic and start the game loop
    }

    public static void main(String[] args) {
        launch();
    }

}