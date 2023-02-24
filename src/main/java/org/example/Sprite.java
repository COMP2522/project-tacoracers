package org.example;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;
public class Sprite implements Drawable {
    protected float xPos;
    protected float yPos;
    protected float xSize;
    protected float ySize;
    protected Window window;
    public Sprite(float xPos, float yPos, float xSize, float ySize, Window window) {
        this.yPos = yPos;
        this.xPos = xPos;
        this.xSize = xSize;
        this.ySize = ySize;
        this.window = window;
    }

    @Override
    public void draw() {

    }
}
