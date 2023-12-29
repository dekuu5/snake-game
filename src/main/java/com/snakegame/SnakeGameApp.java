// // SnakeGameApp.java

package com.snakegame;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;




public class SnakeGameApp extends Application {


    @Override
    public void start(Stage stage) throws Exception {


        Game game = new Game(stage, 100, "Snake Game");

        game.setObjects();
        game.setEvents();

        game.start();




    }

    public static void main(String[] args) {
        launch(args);
    }
}