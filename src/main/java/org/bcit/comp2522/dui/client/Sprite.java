package org.bcit.comp2522.dui.client;

import processing.core.PImage;
import processing.core.PVector;

/**
 * Sprite class represents objects in the world.
 * (player nad enemy car)
 *
 * @author Eric Tatchell
 */
public class Sprite extends Manager implements Drawable {
    int yVel = 50;
    protected PVector position;
    protected Window window;
    Player player;
    PImage playerImage;

    // i removed xSize and ySize for now, seemed unnecessary. will revisit
    public Sprite(PVector position, Window window) {
        super();
        this.position = position;
        this.window = window;
        playerImage = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/playerImage.png");

    }
    public void drawPlayer(float x, float y) {
        window.image(playerImage, x, y, 140, 75);
    }

    /**
     * Add difficulties with different vehicles
     * eg drawEasy drawMedium drawHard etc
     * @return
     */
    public PVector getPosition() {
        return position.copy();
    }


    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }



    @Override
    public void draw() {

    }
}
