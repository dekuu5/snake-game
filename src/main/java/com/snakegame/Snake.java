 // Snake.java

 package com.snakegame;

 import javafx.scene.canvas.GraphicsContext;
 import javafx.scene.paint.Color;

 import java.util.LinkedList;

 public class Snake {



     private static final Color SNAKE_COLOR = Color.GREEN;

     private LinkedList<BodySegment> body;
     private int size = 1;
     private Direction direction;

     public Snake() {
         this.body = new LinkedList<>();
         this.direction = Direction.STOP; // Initial direction

         body.add(new BodySegment(12,12, getRandomColor()));
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
         if (body.size() > size) {
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
         if (head.getX() < 0 || head.getX() >= 24 ||
             head.getY() < 0 || head.getY() >= 24) {
             return true;
         }
         for (int i = 1; i < body.size(); i++) {
             if (head.collidesWith(body.get(i))) {
                 return true;
             }
         }
         return false;
     }
     public void grow() {
         // Grow the snake by one segment
         size++;
     }
     public boolean eat(Food food) {
         // Check if the snake eats the given food
         BodySegment head = getHead();
         if (head.getX() == food.getX() && head.getY() == food.getY()) {
             grow();
             return true;
         }
         return false;
     }

     private BodySegment getHead() {
         return body.getFirst();
     }
    public Direction getDirection() {
        return direction;
    }
    public void gameOver() {
        // Handle game over here
        this.direction = Direction.STOP;

    }

     // Additional methods can be added based on the specific requirements of your game
 }
