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
    public UI() {
    }


    public void displayHighScore(long newScore) {

    }
}
