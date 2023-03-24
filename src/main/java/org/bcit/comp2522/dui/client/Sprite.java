package org.bcit.comp2522.dui.client;

import processing.core.PVector;

public class Sprite extends Manager implements Drawable {
    int yVel = 50;
    protected PVector position;
    protected Window window;
    protected Obstacle car;
    Player player;
    // i removed xSize and ySize for now, seemed unnecessary. will revisit
    public Sprite(PVector position, Window window) {
        super();
        this.position = position;
        this.window = window;
    }

    public PVector getPosition() {
        return position.copy();
    }

    public void drawPlayer(float x, float y) {
        window.rect(x, y, 100, 50);
    }
    public void setPosition(float x, float y) {
        this.position.x += x;
        this.position.y += y;
    }


    @Override
    public void draw() {

    }
}
