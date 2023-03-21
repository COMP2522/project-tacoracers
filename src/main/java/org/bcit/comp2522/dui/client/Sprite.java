package org.bcit.comp2522.dui.client;

import processing.core.*;

public class Sprite implements Drawable {
    protected PVector position;
    protected Window window;
    // i removed xSize and ySize for now, seemed unnecessary. will revisit
    public Sprite(PVector position, Window window) {
        this.position = position;
        this.window = window;
    }


    public PVector getPosition() {
        return this.position;
    }
    public void setPosition(int y) {
        this.position = getPosition().add(0, y);
    }

    @Override
    public void draw() {
    }
}
