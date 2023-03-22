package org.bcit.comp2522.dui.client;

import processing.core.PVector;

public class Obstacle extends Sprite implements Collidable {

    private float xVel;
    public Obstacle(PVector position, Window window, float xVel) {
        super(position, window);
        this.xVel = xVel;
    }

    @Override
    public void collide() {

    }
}
