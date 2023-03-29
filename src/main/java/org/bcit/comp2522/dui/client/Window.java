package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;
import processing.core.PApplet;
import processing.core.PFont;

/**
 * Window creates the actual window and Manager runs the game.
 *
 * @author Eric Tatchell
 */
public class Window extends PApplet {
    public Player player;
    public PFont bigFont;
    public PFont smallFont;
    public PFont mediumFont;
    public PFont tinyFont;
    public boolean playing = false;
    protected int gameMode;
    private Manager manager;

    private MusicPlayer musicPlayer;
    public void settings() {
        size(1280,600);
    }

    public void setup() {
        this.init();
        musicPlayer = new MusicPlayer("src/main/java/org/bcit/comp2522/dui/content/Team America - America, Fck Yeah! (Lyrics).wav");
        musicPlayer.play();

    }
    @Override
    public void keyPressed() {
        if (this.playing == true) {
            player.keyInput.handleKeyEvent(keyCode, true);
        }
    }
    @Override
    public void keyReleased() {
        if (this.playing == true) {
            player.keyInput.handleKeyEvent(keyCode, false);
        }
    }



    public void init() {
        bigFont = createFont("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf", 150, true);
        smallFont = createFont("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf", 48, true);
        mediumFont = createFont("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf", 64, true);
        tinyFont = createFont("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf", 24, true);
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
