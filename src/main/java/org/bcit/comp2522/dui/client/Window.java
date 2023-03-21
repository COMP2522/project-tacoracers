package org.bcit.comp2522.dui.client;

import processing.core.PApplet;
import processing.core.PFont;
import processing.event.KeyEvent;
public class Window extends PApplet {
    public Player player;
    public PFont font;
    public boolean playing = false;
    protected int gameMode;
    private Manager manager;
    public void settings() {
        size(1080,640);
    }
    public void setup() {
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
    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch(keyCode) {
            case UP:
                player.move(50);
                System.out.println("up");
                break;
            case DOWN:
                player.move(-50);
                System.out.println("down");
                break;
        }
    }
    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"eatBubbles"};
        Window eatBubbles = new Window();
        PApplet.runSketch(appletArgs, eatBubbles);
    }
}
