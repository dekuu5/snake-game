package com.snakegame;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Score {
    private int score = 0;
    public Score() {

    }


    public void draw(GraphicsContext gc, int score) {
        gc.setFill(Color.WHITE);
        gc.fillText("Score: " + score, 300, 50, 400);
    }
}
