package org.bcit.comp2522.dui.client;

import processing.core.PApplet;

/**
 * Window creates the actual window and Manager runs the game.
 *
 * @author Eric Tatchell
 */
public class Window extends PApplet {
    private Manager manager;
    public MusicPlayer musicPlayer;
    public void settings() {
        size(1280,600);
    }

    public void setup() {
        background(0);
        musicPlayer = new MusicPlayer("src/main/java/org/bcit/comp2522/dui/content/Redneck1.wav");
        musicPlayer.play();
        manager = new Manager();
        manager.contentLoader.load();
        manager.contentLoader.loadFonts(this);
        manager.run(this);
    }

    @Override
    public void keyPressed() {
        if (manager.screenState == 0) { // playing
            manager.keyInput.pressedKeys.add(this.keyCode);
        }
    }

    @Override
    public void keyReleased() {
        if (manager.screenState == 0) { // playing
            manager.keyInput.pressedKeys.remove(this.keyCode);
        }
    }

    public void draw() {
        manager.ui.init();
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"eatBubbles"};
        Window eatBubbles = new Window();
        PApplet.runSketch(appletArgs, eatBubbles);
    }
}