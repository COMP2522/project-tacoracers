package org.bcit.comp2522.dui.client;

public class Obstacle extends Sprite implements Collidable {

    private float xVel;
    public Obstacle(float xPos, float yPos, Window window, float xVel) {
        super(xPos, yPos, window);
        this.xVel = xVel;
    }

    @Override
    public void collide() {

    }
}
