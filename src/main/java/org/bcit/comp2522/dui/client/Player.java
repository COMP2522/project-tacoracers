package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.*;
import processing.core.*;

/**
 * Player represents the movable car in the world.
 * Lives, position and sizing properties are kept.
 *
 * @author Eric Tatchell
 */
public class Player extends Sprite implements Collidable {

    // 3 default lives for player
    private final int defaultLives = 3;

    // instance representing lives
    private int lives;

    // safe distance before collision detected
    private final int safeDistance = 30;

    // representing the player image
    private PImage playerImage;

    /**
     * Constructs a new Player object with the given properties.
     *
     * @param manager      The Manager object managing the game state.
     * @param window       The Window object handling the display.
     * @param position     The PVector object representing the player's position.
     * @param playerWidth  The width of the player's image.
     * @param playerHeight The height of the player's image.
     */
    public Player(Manager manager, Window window, PVector position, float playerWidth, float playerHeight) {
        super(manager, window, position, playerWidth, playerHeight);
        this.lives = 3;
        this.playerImage = manager.contentLoader.getPlayerImageRed();
    }

    /**
     * Checks for a collision between the player and an enemy car.
     *
     * @param enemyCar  The enemy car to check for collision with the player.
     * @param enemyCars the enemy cars
     */
    public void check(EnemyCar enemyCar, CarLinkedList<EnemyCar> enemyCars) {
        if (collide(enemyCar) && lives <= 3) {
            lives -= 1;
            if (lives == -1) {
                manager.screenState = 1;
            }

            // Handle enemyCar removal and repositioning
            enemyCars.remove(enemyCar);
            float offset = (float) (Math.random() * window.width * 0.5);
            enemyCar.position.x = window.width + enemyCar.getWidth() + offset;
            int laneIndex = (int) (Math.random() * enemyCar.lanes.length);
            enemyCar.position.y = enemyCar.lanes[laneIndex];
            enemyCars.add(enemyCar);
        }
    }


    /**
     * Sets lives.
     *
     * @param lives the lives
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Changes the player's image to the given car image.
     *
     * @param car The PImage object representing the new car image.
     */
    public void pickPlayer(PImage car) {
        playerImage = car;
    }

    /**
     * Displays the player's health as heart icons on the screen.
     * case 0: last life
     */
    public void displayHealth() {
        int heartXPosition = 75;
        for (int i = 0; i < 3; i++) {
            if (i < this.lives) {
                window.image(manager.contentLoader.getHeart(), heartXPosition, 25, 50, 50);
            } else {
                window.image(manager.contentLoader.getHeartLost(), heartXPosition, 25, 50, 50);
            }
            heartXPosition += 60;
        }
    }

    // draws the player image on screen
    public void draw() {
        window.image(playerImage, getPosition().x, getPosition().y, width, height);
    }

    @Override
    public boolean collide(Player player) {
        return false;
    }


    /**
     * Checks for a collision between the player and another player.
     * As it is not applicable in this context, this method always returns false.
     *
     * @param enemyCar The enemy car object to check for collision with the player.
     * @return A boolean value representing whether the collision occurs or not. Always false in this case.
     */
    public boolean collide(EnemyCar enemyCar) {
        float adjustedWidth = enemyCar.getWidth() - safeDistance;
        float adjustedHeight = enemyCar.getHeight() - safeDistance;
        float minDistanceX = (width / 2) + (adjustedWidth / 2);
        float minDistanceY = (height / 2) + (adjustedHeight / 2);
        if (Math.abs(getPosition().x - enemyCar.getPosition().x) < minDistanceX
                && Math.abs(getPosition().y - enemyCar.getPosition().y) < minDistanceY) {
            return true;
        }
        return false;
    }


    /**
     * Returns the player's number of lives.
     *
     * @return A float representing the player's number of lives.
     */
    public float getLives() {
        return this.lives;
    }

    /**
     * Adds the specified number of lives to the player's current lives.
     *
     * @param a The number of lives to add to the player's current lives.
     */
    public void addLives(float a) {
        this.lives += a;
    }

    // updates the ui's keys
    public void update() {
        manager.keyInput.updateKeyStates();
    }

    /**
     * Gets default lives.
     *
     * @return the default lives
     */
    public int getDefaultLives() {
        return defaultLives;
    }

    /**
     * Gets slowed player speed.
     *
     * @return the slowed player speed
     */
    public float getSlowedPlayerSpeed() {
        return getSlowedPlayerSpeed();
    }
}