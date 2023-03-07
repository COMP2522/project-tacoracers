package org.example;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;
public class Window extends PApplet {
    public Player player;
    public PFont font;
    Menu menu;
    UI game;
    boolean playing = false;
    protected int gameMode;
    private UI_Manager uiManager;
    private Sprite_Manager spriteManager;
    public void settings() {
        size(1080,640);
    }
    public void setup() {
        this.init();
    }
    public void init() {
        font = createFont("Helvetica", 16, true);
        menu = new Menu(this);
        game = new UI(this);
        background(0);
    }
    public void draw() {
        if (playing) {
            game.draw();
        } else {
            menu.draw();
        }
    }
    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"eatBubbles"};
        Window eatBubbles = new Window();
        PApplet.runSketch(appletArgs, eatBubbles);
    }
}
