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

    // representing player speed
    private final float playerSpeed = 0.3F;

    // representing slowed player speed
    private final float slowedPlayerSpeed = 0.1f;

    // representing the player image
    private PImage playerImage;

    /**
     * Constructs a new Player object with the given properties.
     *
     * @param manager    The Manager object managing the game state.
     * @param window     The Window object handling the display.
     * @param position   The PVector object representing the player's position.
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
     * @param enemyCar The enemy car to check for collision with the player.
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
        switch (this.lives) {
            case 3:
                window.image(manager.contentLoader.getHeart(), 75, 25, 50, 50);
                window.image(manager.contentLoader.getHeart(), 135, 25, 50, 50);
                window.image(manager.contentLoader.getHeart(), 195, 25, 50, 50);
                break;
            case 2:
                window.image(manager.contentLoader.getHeart(), 75, 25, 50, 50);
                window.image(manager.contentLoader.getHeart(), 135, 25, 50, 50);
                window.image(manager.contentLoader.getHeartLost(), 195, 25, 50, 50);
                break;
            case 1:
                window.image(manager.contentLoader.getHeart(), 75, 25, 50, 50);
                window.image(manager.contentLoader.getHeartLost(), 135, 25, 50, 50);
                window.image(manager.contentLoader.getHeartLost(), 195, 25, 50, 50);
                break;
            case 0:
                window.image(manager.contentLoader.getHeartLost(), 75, 25, 50, 50);
                window.image(manager.contentLoader.getHeartLost(), 135, 25, 50, 50);
                window.image(manager.contentLoader.getHeartLost(), 195, 25, 50, 50);
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
        float minDistanceX = (width / 2) + (enemyCar.getWidth() / 2);
        float minDistanceY = (height / 2) + (enemyCar.getHeight() / 2);
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

    /**
     * Updates the player's state based on user input.
     *
     * @param ui The UI object handling user input.
     */
    public void update(UI ui) {
        manager.keyInput.updateKeyStates();
        ContentLoader contentLoader = manager.contentLoader;
    }

    public int getDefaultLives() {
        return defaultLives;
    }

    public float getSlowedPlayerSpeed() {
        return getSlowedPlayerSpeed();
    }
}