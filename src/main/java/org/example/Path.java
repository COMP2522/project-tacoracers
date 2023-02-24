package org.example;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;
public class Path extends Sprite {

    public Path(float xPos, float yPos, float xSize, float ySize, Window window) {
        super(xPos, yPos, xSize, ySize, window);
    }
    private float xVel;

}
