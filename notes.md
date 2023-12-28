snake game should be 600 x 600

dived into 24 rows x 24 cols
so the one box is a 25 x 25 square

start snake at 12, 12

snake is an linkedlist with head of body segments
every body segment is an object with x and y coordinates is the start of box in the top left corner and color the rest of the box

moving the snake meaning creating a new head and removing the tail and adding the new head to the linkedlist as the new head

the dircation of the snake is determined by the direction of the head and it is an enum of up, down, left, right and the snake can only move in the direction it is facing
