package org.bcit.comp2522.dui.client;

import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

/**
 * The type Power up.
 */
public class PowerUp extends Sprite implements Drawable, Collidable {

    // window instance
    private Window window;

    // checks if on screen
    private boolean active;

    // manager instance
    private Manager parent;

    /**
     * The Lanes.
     */
// Main lanes are 140, 327 and 515. All other numbers are to account for AFK cheating
    public final float[] lanes = {140, 175, 297, 327, 357, 485, 515};

    /**
     * Constructor creating a powerup sprite and assigning instances for usable UI additions
     *
     * @param manager  Manager
     * @param window   Window
     * @param position PVector
     * @param width    float
     * @param height   float
     * @param speed    float
     */
    public PowerUp(Manager manager, Window window, PVector position, float width, float height, float speed) {
        super(manager, window, position, width, height, speed);
        this.parent = manager;
        this.window = window;
        this.active = false;
    }

    /**
     * Checks if on screen.
     *
     * @return active t/f
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Toggles on screen
     *
     * @param active boolean
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Update.
     */
// used for moving the powerup from left to right
    public void update() {
        float minDistance = 10000;
        position.x -= getSpeed();
        if (position.x < -getWidth()) {
            float offset = (float) (Math.random() * (window.width * 75) * 0.5);
            // for fluid transitions. imitates traffic!
            position.x = window.width + getWidth() + offset;
            int laneIndex = (int) (Math.random() * lanes.length);
            position.y = lanes[laneIndex];
        }
    }

    /**
     * Half speed.
     */
// Halves the speed for LEFT key press
    public void halfSpeed() {
        this.speed /= 2;
    }

    /**
     * Reset speed.
     */
// Resets speed after LEFT key press
    public void resetSpeed() {
        this.speed *= 2;
    }

    /**
     * Checks collision relative to player.
     * @param player
     * @return
     */
    @Override
    public boolean collide(Player player) {
       float minDistanceX = (width / 2) + (player.getWidth() / 2);
       float minDistanceY = (height / 2) + (player.getHeight() / 2);
       if (Math.abs(getPosition().x - player.getPosition().x) < minDistanceX
               && Math.abs(getPosition().y - player.getPosition().y) < minDistanceY) {
           return true;
       }
       return false;
    }

    @Override
    public boolean collide(EnemyCar enemyCar) {
        return false;
    }

    /**
     * Checks and handles collide()
     *
     * @param player Player
     */
    public void check(Player player) {
        if (collide(player)) {
            if (player.getLives() == 3) {
                for (int i = 0; i < 10000; i++); {
                    window.fill(255, 255, 255);
                    window.textFont(manager.contentLoader.getMediumFont());
                    window.text("HEALTH FULL", (window.width / 4), 327);
                }
            } else {
                this.position.x -= 1000;
                player.setLives(3);
            }
        }
    }

    // Draws the powerup on screen
    @Override
    public void draw() {
        if (active && parent.contentLoader.getPowerup() != null) {
            window.image(parent.contentLoader.getPowerup(), position.x, position.y, 100, 100);
        } else {
            System.out.println("wtf");
        }
    }
}
