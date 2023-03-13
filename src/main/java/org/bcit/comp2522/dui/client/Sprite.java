package org.bcit.comp2522.dui.client;

public class Sprite implements Drawable {
    protected float xPos;
    protected float yPos;
    protected float xSize;
    protected float ySize;
    protected Window window;
    // i removed xSize and ySize for now, seemed unnecessary. will revisit
    public Sprite(float xPos, float yPos, Window window) {
        this.yPos = yPos;
        this.xPos = xPos;
        this.window = window;
    }

    @Override
    public void draw() {
        if (window.playing == true) {
            window.rect(xPos, yPos, 100, 75);
        }
    }

    public float getYPos() {
        return this.yPos;
    }
}
