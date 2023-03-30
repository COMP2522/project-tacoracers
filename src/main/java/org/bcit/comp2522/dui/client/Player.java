package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;
import processing.core.PImage;
import processing.core.PVector;

import java.util.HashSet;


/**
 * Player represents the movable car in the world.
 * Lives, position and sizing properties are kept.
 *
 * @author Eric Tatchell
 */
public class Player extends Sprite implements Collidable {
    public boolean playerDeath;
    public float slowedPlayerSpeed = 0.1F;
    public int lives;
    private float playerSpeed = 0.3F;
    public Player(Manager manager, Window window, PVector position, float playerWidth, float playerHeight) {
        super(manager, window, position, playerWidth, playerHeight);
        this.playerDeath = false;
        this.lives = 3;
    }
    public void check(EnemyCar enemyCar, Menu menu) {
        if (collide(enemyCar) && lives <= 3) {
            lives -= 1;
            enemyCar.setPosition(enemyCar.getPosition().x - 1000, 0);
            if (lives == -1) {
                menu.gameOver();
                playerDeath = true;
            }
        }
    }

    public void displayHealth() {
        switch (this.lives) {
            case 3:
                window.image(manager.contentLoader.heart, 75, 25, 50, 50);
                window.image(manager.contentLoader.heart, 135, 25, 50, 50);
                window.image(manager.contentLoader.heart, 195, 25, 50, 50);
                break;
            case 2:
                window.image(manager.contentLoader.heart, 75, 25, 50, 50);
                window.image(manager.contentLoader.heart, 135, 25, 50, 50);
                window.image(manager.contentLoader.heartLost, 195, 25, 50, 50);
                break;
            case 1:
                window.image(manager.contentLoader.heart, 75, 25, 50, 50);
                window.image(manager.contentLoader.heartLost, 135, 25, 50, 50);
                window.image(manager.contentLoader.heartLost, 195, 25, 50, 50);
                break;
            case 0:
                window.image(manager.contentLoader.heartLost, 75, 25, 50, 50);
                window.image(manager.contentLoader.heartLost, 135, 25, 50, 50);
                window.image(manager.contentLoader.heartLost, 195, 25, 50, 50);
        }
    }

    public void setSpeed(float speed) {
        this.playerSpeed = speed;
    }


    public void draw() {
        window.image(manager.contentLoader.playerImage, getPosition().x, getPosition().y, width, height);
    }

    @Override
    public boolean collide(EnemyCar enemyCar) {
        float minDistanceX = (width / 2) + (enemyCar.getWidth() / 2);
        float minDistanceY = (height / 2) + (enemyCar.getHeight() / 2);
        if (Math.abs(getPosition().x - enemyCar.getPosition().x) < minDistanceX
                && Math.abs(getPosition().y - enemyCar.getPosition().y) < minDistanceY) {
            return true;
        }
        return false;
    }

    public float getPlayerSpeed() {
        return playerSpeed;
    }

    public void update(UI ui) {
        manager.keyInput.updateKeyStates(ui);
    }
}
