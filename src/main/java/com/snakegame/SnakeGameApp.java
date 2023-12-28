// SnakeGameApp.java

package com.snakegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SnakeGameApp extends Application {

    private static final int CANVAS_SIZE = 600;
    private static final int GRID_SIZE = 20;
    private Snake snake;
    int i = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Snake Game");

        Canvas canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        root.setStyle("-fx-background-color: black");

        Scene scene = new Scene(root, CANVAS_SIZE, CANVAS_SIZE);
        primaryStage.setScene(scene);

        // Set up key event handling
        scene.setOnKeyPressed(event -> handleKeyPress(event.getCode()));

        // Initialize the snake
        snake = new Snake();

        // Set up the game loop
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                render(gc);
            }
        };
        timer.start();

        primaryStage.show();
    }

    private void update() {
        // Update game logic (e.g., move snake, check collisions)
        snake.move();

        // Check for collisions
        if (snake.checkCollision()) {
            System.out.println("Game Over!" + this.i++);
            // Implement game over logic here
        }
    }

    private void render(GraphicsContext gc) {
        // Clear the canvas
        gc.clearRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);

        // Draw the snake
        snake.draw(gc);
    }

    private void handleKeyPress(KeyCode code) {
        // Handle key presses here (e.g., change snake direction)
        switch (code) {
            case UP:
                snake.changeDirection(Direction.UP);
                break;
            case DOWN:
                snake.changeDirection(Direction.DOWN);
                break;
            case LEFT:
                snake.changeDirection(Direction.LEFT);
                break;
            case RIGHT:
                snake.changeDirection(Direction.RIGHT);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

