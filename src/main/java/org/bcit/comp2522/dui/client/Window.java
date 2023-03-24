package org.bcit.comp2522.dui.client;

import processing.core.PApplet;
import processing.core.PFont;

public class Window extends PApplet {
    public Player player;
    public PFont font;
    public boolean playing = false;
    protected int gameMode;
    private Manager manager;
    public void settings() {
        size(1080,600);
    }
    public void setup() {
        frameRate(120);
        this.init();
    }
    public void init() {
        font = createFont("Helvetica", 16, true);
        manager = new Manager(this);
        background(0);
    }
    public void draw() {
        manager.run();
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"eatBubbles"};
        Window eatBubbles = new Window();
        PApplet.runSketch(appletArgs, eatBubbles);
    }
}
