package org.bcit.comp2522.dui.client;

import processing.core.PApplet;
import processing.core.PFont;

public class Window extends PApplet {
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

//    @Override
//    public void keyPressed(KeyEvent event) {
//        int keyCode = event.getKeyCode();
//        switch(keyCode) {
//            case UP:
//                player.move(player.getYPos() + 50);
//                break;
//            case DOWN:
//                player.move(player.getYPos() - 50);
//                break;
//        }
//    }
    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"eatBubbles"};
        Window eatBubbles = new Window();
        PApplet.runSketch(appletArgs, eatBubbles);
    }
}
