// BodySegment.java

package com.snakegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BodySegment {

    public static final int SIZE = 20;

    private Color color;
    private double x;
    private double y;

    public BodySegment(double x, double y,Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean collidesWith(BodySegment other) {
        return x == other.x && y == other.y;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillRect(x, y, SIZE, SIZE);
    }
}
