package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;
import processing.core.PVector;

public class Player extends Sprite {
    public boolean playerDeath;
    private PVector position;
    private Window window;
    private float playerWidth;
    private float playerHeight;
    public int lives = 3;

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Player(PVector position, Window window, float playerWidth, float playerHeight) {
        super(position, window);
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        this.playerDeath = false;
    }

    public boolean collide(EnemyCar enemyCar) {
        float playerLeft = getPosition().x;
        float playerRight = getPosition().x + playerWidth;
        float playerTop = getPosition().y;
        float playerBottom = getPosition().y + playerHeight;
        float enemyCarLeft = enemyCar.getPosition().x;
        float enemyCarRight = enemyCar.getPosition().x + enemyCar.size * 2;
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
            setLives(getLives() - 1);
            enemyCar.getPosition().x -= 1000;
            if (lives == -1) {
                ui.gameOver();
                playerDeath = true;
            }
        }
    }
}
