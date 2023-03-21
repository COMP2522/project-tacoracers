package org.bcit.comp2522.dui.client;

import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

public class Player extends Sprite implements Collidable {
    private final float yVel = 1;
    public Player(float xPos, float yPos, Window window) {
        super(xPos, yPos, window);
    }


    public void move(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch(keyCode) {
            case PApplet.UP:
                this.setyPos(this.getYPos() + 50);
                System.out.println("up is pressed");
                break;
            case PApplet.DOWN:
                this.setyPos(this.getYPos() - 50);
                System.out.println("down is pressed");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + keyCode);
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
}
