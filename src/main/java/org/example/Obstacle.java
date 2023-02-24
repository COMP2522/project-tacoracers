package org.example;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;
public class Obstacle extends Sprite implements Collidable {

    private float xVel;
    public Obstacle(float xPos, float yPos, float xSize, float ySize, Window window, float xVel) {
        super(xPos, yPos, xSize, ySize, window);
        this.xVel = xVel;
    }

    @Override
    public void collide() {

    }
}
