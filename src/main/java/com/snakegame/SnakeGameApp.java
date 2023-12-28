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
    private static final int CANVAS_SIZE = 600;
    private static final int GRID_SIZE = 25;
    private Snake snake;
    GraphicsContext gc;


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Snake Game");

        Canvas canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);
        this.gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        root.setStyle("-fx-background-color: black");

        Scene scene = new Scene(root, CANVAS_SIZE, CANVAS_SIZE);
        stage.setScene(scene);

        for (int i = 0; i < CANVAS_SIZE; i += GRID_SIZE) {
            gc.setStroke(Color.WHITE);
            gc.strokeLine(i, 0, i, CANVAS_SIZE);
            gc.strokeLine(0, i, CANVAS_SIZE, i);
        }
        this.snake = new Snake();
        // Set up key event handling
        scene.setOnKeyPressed(event -> handleKeyPress(event.getCode()));

        // Set up the game loop
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(150), event -> {
            // Game logic here (this code will be executed every 300 milliseconds)
            update();
            render();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        timeline.play();




        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setOnCloseRequest(e -> {
            e.consume();
            System.exit(0);
        });
        stage.show();


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
             case SPACE:
                 snake.changeDirection(Direction.STOP);
                 break;
         }
     }
    private void render() {
        // Clear the entire canvas
        gc.clearRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);
        drawGrid();
        snake.draw(gc);
    }

    private void drawGrid() {
        for (int i = 0; i < CANVAS_SIZE; i += GRID_SIZE) {
            gc.setStroke(Color.WHITE);
            gc.strokeLine(i, 0, i, CANVAS_SIZE);
            gc.strokeLine(0, i, CANVAS_SIZE, i);
        }
    }
    private void update() {
        // Update game logic (e.g., move snake, check collisions)

        if (snake.getDirection() == Direction.STOP) {
            // Don't move the snake if the direction is STOP
        }else {
            snake.move();
        }

        // Check for collisions
        if (snake.checkCollision()) {
            System.out.println("Game Over!");
            snake.gameOver();
        }
    }
    public static int getGridSize() {
        return GRID_SIZE;
    }

    public static void main(String[] args) {
        launch(args);
    }
}