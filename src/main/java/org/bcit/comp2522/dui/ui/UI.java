package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.*;
import processing.core.PApplet;
import processing.core.PFont;

public class UI extends PApplet implements Drawable {
    public Window window;
    private Manager manager;
    private Player player;
    private Obstacle traffic;
    public PFont font;
    public float xPos;
    public float yPos;
    public float height;
    public float width;
    public UI(Window scene) {
        this.window = scene;
    }

    @Override
    public void draw() {
        if (window.playing == false) {
            this.menu();
        } else {
            window.background(0);
            window.rect(0, 580, 1080, 15);
            window.fill(255);
            window.rect(0, 180, 1080, 15);
            window.fill(255);
        }
    }
    public void menu() {
        window.background(0);
        window.fill(255);
        window.textFont(window.font);
        window.textSize(150);
        window.textAlign(CENTER);
        window.text("DUI", 540, 200);
        window.textSize(50);
        window.text("Driving Unintelligently", 540, 300);
        window.rect(465, 400, 150, 75);
        window.textAlign(CENTER);
        window.fill(0);
        window.textSize(50);
        window.text("PLAY", 540, 455);
        if (window.mouseX > 465 && window.mouseX < 615
                && window.mouseY > 400 && window.mouseY < 475) {
            if (window.mousePressed) { // when play button is pressed
                window.playing = true;
                this.draw();
            }
        }
    }

    public void displayHighScore(long newScore) {

    }



    public void init() {
        this.draw();
        Sprite sprite = new Sprite(this.xPos, this.yPos, this.window);
        sprite.draw();
    }
}
