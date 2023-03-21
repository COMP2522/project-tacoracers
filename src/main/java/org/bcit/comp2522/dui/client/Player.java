package org.bcit.comp2522.dui.client;

public class Player extends Sprite implements Collidable {
    private final float yVel = 1;

    public Player(float xPos, float yPos, Window window) {
        super(xPos, yPos, window);
    }


    public void move(int event) {
        if (event > 0) {
            this.setyPos(this.getYPos() + 50);
        }
        if (event < 0) {
            this.setyPos(this.getYPos() - 50);
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
