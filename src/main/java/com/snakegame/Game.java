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

public class Game {

    private static final int CANVAS_SIZE = 600;
    private static final int GRID_SIZE = 25;
    private Snake snake;
    private Canvas canvas;
    private StackPane root;
    private Scene scene;
    private Stage stage;
    private Timeline timeline;
    private Food food;
    GraphicsContext gc;

    public Game(Stage stage, int velocity, String title) {
        this.canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);
        this.gc = canvas.getGraphicsContext2D();
        this.root = new StackPane();
        this.root.getChildren().add(canvas);
        this.root.setStyle("-fx-background-color: black");
        this.scene = new Scene(root, CANVAS_SIZE, CANVAS_SIZE);
        this.stage = stage;
        this.stage.setTitle(title);
        this.stage.setScene(scene);
        this.timeline = new Timeline(new KeyFrame(Duration.millis(velocity), event -> {
            update();
            render();
        }));



        this.stage.resizableProperty().setValue(Boolean.FALSE);
        this.stage.setOnCloseRequest(e -> {
            e.consume();
            System.exit(0);
        });
        stage.show();
    }

    public void setEvents(){
        this.scene.setOnKeyPressed(event -> {
            handleKeyPress(event.getCode());
        });
    }
    public void setObjects(){
        this.snake = new Snake();
        // todo: add food, score
         this.food = new Food();
        // this.score = new Score();

    }
    public void start(){
        System.out.println("start");
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        System.out.println(Timeline.INDEFINITE);
        this.timeline.play();
        System.out.println("play");

        this.stage.show();
    }
    private void handleKeyPress(KeyCode code) {
        // Handle key presses here (e.g., change snake direction)
        // This code works regardless of any other dependencies
        switch (code) {
            case UP:
                snake.changeDirection(Direction.UP);
                System.out.println("up");
                break;
            case DOWN:
                snake.changeDirection(Direction.DOWN);
                System.out.println("down");
                break;
            case LEFT:
                snake.changeDirection(Direction.LEFT);
                System.out.println("left");
                break;
            case RIGHT:
                snake.changeDirection(Direction.RIGHT);
                System.out.println("right");
                break;
            case SPACE:
                snake.changeDirection(Direction.STOP);
                System.out.println("stop");
                break;
        }
    }
    private void render() {
        // Clear the entire canvas
        this.gc.clearRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);
        drawGrid();
        this.snake.draw(gc);
        this.food.draw(gc);

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
         //   System.out.println("stop update");
            return;
        }else {
            this.timeline.play();
            snake.move();
           // System.out.println("move update");
        }

        if (snake.eat(food)) {
            food = new Food();
            System.out.println("new food update");
        }
        if (snake.checkCollision()) {
            System.out.println("Game Over!");
            this.gameOver();
        }
    }
    public static int getGridSize() {
        return GRID_SIZE;
    }
    private void gameOver() {
        // Handle game over here
        this.snake.gameOver();
        // this.food.gameOver();
        // this.score.gameOver();
        this.timeline.stop();

    }

}
