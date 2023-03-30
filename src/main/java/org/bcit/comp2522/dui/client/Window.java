package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.ContentLoader;
import processing.core.PApplet;
import processing.core.PFont;

/**
 * Window creates the actual window and Manager runs the game.
 *
 * @author Eric Tatchell
 */
public class Window extends PApplet {
    public Player player;
    protected int gameMode;
    private Manager manager;
    private MusicPlayer musicPlayer;
    private ContentLoader loader;
    public void settings() {
        size(1280,600);
    }

    public void setup() {
        musicPlayer = new MusicPlayer("src/main/java/org/bcit/comp2522/dui/content/Team America - America, Fck Yeah! (Lyrics).wav");
        musicPlayer.play();
        manager = new Manager();
        manager.contentLoader.load();
        manager.contentLoader.loadFonts(this);
        manager.run(this); // Add this line to the setup method
        background(0);
    }


    @Override
    public void keyPressed() {
        if (manager.playing == true) {
            manager.keyInput.pressedKeys.add(this.keyCode);
        }
    }

    @Override
    public void keyReleased() {
        if (manager.playing == true) {
            manager.keyInput.pressedKeys.remove(this.keyCode);
        }
    }

//    public void init() {
//        manager = new Manager();
//        manager.contentLoader.load();
//        bigFont = createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 150, true);
//        smallFont = createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 48, true);
//        mediumFont = createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 64, true);
//        tinyFont = createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 24, true);
//
////        manager.contentLoader.loadFonts();
//        background(0);
//    }
    public void draw() {
        manager.ui.init();
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"eatBubbles"};
        Window eatBubbles = new Window();
        PApplet.runSketch(appletArgs, eatBubbles);
    }
}
