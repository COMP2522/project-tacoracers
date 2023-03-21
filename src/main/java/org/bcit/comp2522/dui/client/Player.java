package org.bcit.comp2522.dui.client;

import processing.core.PVector;

public class Player extends Sprite implements Collidable {
    private final float yVel = 1;

    public Player(PVector position, Window window) {
        super(position, window);
    }


    public void move(int event) {
        if (event > 0) {
            this.setPosition(event);
            System.out.println("y increased");
        }
        if (event < 0) {
            this.setPosition(event);
            System.out.println("y decreased");
        }
    }


//            this.yPos += y;
//        if (keyPressed) { // Check if a key is pressed
//            if (keyCode == UP) { // Check if the up arrow key is pressed
//                y -= 5; // Move the circle up
//            } else if (keyCode == DOWN) { // Check if the down arrow key is pressed
//                y += 5; // Move the circle down
//            }
//        }



    @Override
    public void collide() {

    }

    @Override
    public void draw() {
//        window.ellipse(this.getPosition().y, 100, 75);
    }
}
