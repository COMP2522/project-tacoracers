package org.example;

import processing.core.*;
import processing.core.PFont;

public class UI extends PApplet {

    public Window window;
    private UI_Manager uiManager;

    public PFont font;

    public float xPos;

    public float yPos;

    public float height;

    public float width;

    public UI(Window window, float x, float y,
                    float width, float height) {
        window = this.window;
        x = this.xPos;
        y = this.yPos;
        width = this.width;
        height = this.height;
    }
    public UI(Window scene) {
        this.window = scene;
    }

    public void draw() {
        window.background(0);
        window.rect(0, 580, 1080, 15);
        window.fill(255);
        window.rect(0, 180, 1080, 15);
        window.fill(255);
    }

    public void displayHighScore(long newScore) {

    }

    public void init() {


    }
}
