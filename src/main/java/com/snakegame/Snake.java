// Snake.java

package com.snakegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.LinkedList;

public class Snake {

    private static final int INITIAL_SIZE = 100;
    private static final Color SNAKE_COLOR = Color.GREEN;

    private LinkedList<BodySegment> body;
    private Direction direction;

    public Snake() {
        this.body = new LinkedList<>();
        this.direction = Direction.RIGHT; // Initial direction

        // Initialize the snake with a few body segments
        for (int i = 0; i < INITIAL_SIZE; i++) {
            body.add(new BodySegment(400/2 - i * BodySegment.SIZE, 400/2, getRandomColor()));
        }
    }

    private Color getRandomColor() {
        // Generate a random color for the snake
        return Color.rgb((int) (Math.random() * 255),
                         (int) (Math.random() * 255),
                         (int) (Math.random() * 255));
    }
    public void move() {
        // Move the snake in the current direction
        BodySegment head = getHead();
        BodySegment newHead = new BodySegment(head.getX() + direction.getDeltaX(),
                                              head.getY() + direction.getDeltaY(),
                                              getRandomColor());
        
        body.addFirst(newHead); // Add the new head

        // Remove the tail (last segment) to maintain the snake's length
        if (body.size() > INITIAL_SIZE) {
            body.removeLast();
        }
    }

    public void changeDirection(Direction newDirection) {
        // Prevent the snake from reversing its direction
        if (!direction.isOpposite(newDirection)) {
            this.direction = newDirection;
        }
    }

    public void draw(GraphicsContext gc) {
        // Draw each body segment of the snake
        for (BodySegment segment : body) {
            segment.draw(gc);
        }
    }

    public boolean checkCollision() {
        // Check if the snake collides with itself
        BodySegment head = getHead();
        for (int i = 1; i < body.size(); i++) {
            if (head.collidesWith(body.get(i))) {
                return true;
            }
        }
        return false;
    }

    private BodySegment getHead() {
        return body.getFirst();
    }

    // Additional methods can be added based on the specific requirements of your game
}
