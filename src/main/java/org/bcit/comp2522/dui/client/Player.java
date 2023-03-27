package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;
import processing.core.PImage;
import processing.core.PVector;

/**
 * Player represents the movable car in the world.
 * Lives, position and sizing properties are kept.
 *
 * @author Eric Tatchell
 */
public class Player extends Sprite {
    public boolean playerDeath;
    private PVector position;
    private Window window;
    public int lives = 3;
    private float playerWidth;
    private float playerHeight;
    public PImage heart;
    public PImage heartLost;


    public Player(PVector position, Window window, float playerWidth, float playerHeight) {
        super(position, window);
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        this.playerDeath = false;
        heart = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/heart.png");
        heartLost = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/heartLost.png");
    }



    public boolean collide(EnemyCar enemyCar) {
        float playerLeft = getPosition().x;
        float playerRight = getPosition().x + playerWidth;
        float playerTop = getPosition().y;
        float playerBottom = getPosition().y + playerHeight;
        float enemyCarLeft = enemyCar.getPosition().x;
        float enemyCarRight = enemyCar.getPosition().x + ((enemyCar.size * 2) - 10);
        float enemyCarTop = enemyCar.getPosition().y;
        float enemyCarBottom = enemyCar.getPosition().y + enemyCar.size;

        if (playerRight >= enemyCarLeft
                && playerLeft <= enemyCarRight
                && (playerTop <= enemyCarBottom && playerBottom >= enemyCarTop
                || playerBottom >= enemyCarTop && playerTop <= enemyCarBottom)) {
            System.out.println("here");
            return true;
        }
        return false;
    }

    public void check(EnemyCar enemyCar, UI ui) {
        if (collide(enemyCar) && lives <= 3) {
            lives -= 1;
            enemyCar.position.x -= 1000;
            if (lives == -1) {
                ui.gameOver();
                playerDeath = true;
            }
        }
    }
}
