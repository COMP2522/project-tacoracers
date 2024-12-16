package org.bcit.comp2522.dui.client;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Window creates the actual window and Manager runs the game.
 *
 * @author Eric Tatchell
 */
public class Window extends PApplet {
    private Manager manager;
    public MusicPlayer musicPlayer;
    private PImage background;
    private PImage gameBackground;

    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 600;

    public void settings() {
        size(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    /**
     * prepares the program.
     */
    public void setup() {
        background = loadImage("src/main/java/org/bcit/comp2522/dui/content/background4.png");
        background(background);
        musicPlayer = new MusicPlayer("src/main/java/org/bcit/comp2522/dui/content/Redneck1.wav");
//        musicPlayer.play();
        manager = new Manager();
        manager.contentLoader.load();
        manager.contentLoader.loadFonts(this);
        manager.run(this);
    }

    @Override
    public void keyPressed() {
        if (manager.screenState == 0) { // playing
            manager.keyInput.getPressedKeys().add(this.keyCode);
        }
    }

    @Override
    public void keyReleased() {
        if (manager.screenState == 0) { // playing
            manager.keyInput.getPressedKeys().remove(this.keyCode);
        }
    }

    public PImage getBackground() {
        return background;
    }

    public void draw() {
        manager.ui.init();
    }

    /**
     * The entry point of application.
     *
     * @param passedArgs the input arguments
     */
    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] {"eatBubbles"};
        Window eatBubbles = new Window();
        PApplet.runSketch(appletArgs, eatBubbles);
    }

}
