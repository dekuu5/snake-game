package com.snakegame;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;


public class Food {


    private static final Color color = Color.RED;
    private BodySegment visableFood;

    public Food() {
        int randomX = (int) (Math.random() * 25);
        int randomY = (int) (Math.random() * 25);
        this.visableFood = new BodySegment(randomX, randomY, color);
    }

    public double getX() {
        return this.visableFood.getX();
    }
    public double getY() {
        return this.visableFood.getY();
    }

    public void draw(GraphicsContext gc) {
        this.visableFood.draw(gc);
    }



}
