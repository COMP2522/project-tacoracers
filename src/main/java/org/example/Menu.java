package org.example;

import processing.core.PFont;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends Window implements Drawable {
    Window window;
    boolean playing = false;
    public Menu(Window window) {
        this.window = window;
        this.draw();
    }
    public void draw() {
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

            }
        }
    }
}
