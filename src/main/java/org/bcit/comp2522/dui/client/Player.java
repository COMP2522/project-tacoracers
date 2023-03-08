package org.bcit.comp2522.dui.client;

public class Player extends Sprite implements Collidable {
    private final float yVel = 1;
    public Player(float xPos, float yPos, Window window) {
        super(xPos, yPos, window);
    }

    void move(float y) {
        this.yPos += y;
    }

    @Override
    public void collide() {

    }
}
