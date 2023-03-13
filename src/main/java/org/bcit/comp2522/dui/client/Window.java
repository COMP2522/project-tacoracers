package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI_Manager;
import processing.core.PApplet;
import processing.core.PFont;

import java.awt.event.KeyEvent;

public class Window extends PApplet {
    public Player player;
    public PFont font;
    public boolean playing = false;
    protected int gameMode;
    private UI_Manager UI;
    private Sprite_Manager spriteManager;
    public void settings() {
        size(1080,640);
    }
    public void setup() {
        this.init();
    }
    public void init() {
        font = createFont("Helvetica", 16, true);
        UI = new UI_Manager(this);
        background(0);
    }
    public void draw() {
        UI.generateUI();
    }
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch(keyCode) {
            case UP:
                player.move(player.getYPos() + 50);
                break;
            case DOWN:
                player.move(player.getYPos() - 50);
                break;
        }
    }
    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"eatBubbles"};
        Window eatBubbles = new Window();
        PApplet.runSketch(appletArgs, eatBubbles);
    }
}
