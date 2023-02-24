package org.example;

import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;
public class Window extends PApplet {
    public Player player;
    private UI_Manager uiManager;
    private Sprite_Manager spriteManager;
    public void settings() {
        size(920,480);
    }
    public void init() {

    }
    public void draw() {
    }
    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"eatBubbles"};
        Window eatBubbles = new Window();
        PApplet.runSketch(appletArgs, eatBubbles);
    }
}
