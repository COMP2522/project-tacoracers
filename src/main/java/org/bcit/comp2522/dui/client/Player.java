package org.bcit.comp2522.dui.client;

import processing.core.PVector;

public class Player extends Sprite {
    public boolean playerDeath;
    private PVector position;
    private Window window;
    private float playerWidth;
    private float playerHeight;

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
        float enemyCarRight = enemyCar.getPosition().x + enemyCar.size;
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



    public int compareTo(Object a) {
        if (a instanceof EnemyCar) {
            EnemyCar enemyCar = (EnemyCar) a;
            PVector playerPos = getPosition();
            PVector enemyCarPos = enemyCar.getPosition();

            if (playerPos.y < enemyCarPos.y) {
                return -1; // Player is above the enemy car
            } else if (playerPos.y > enemyCarPos.y) {
                return 1; // Player is below the enemy car
            } else {
                // Player and enemy car have the same y position
                if (playerPos.x < enemyCarPos.x) {
                    return -1; // Player is to the left of the enemy car
                } else if (playerPos.x > enemyCarPos.x) {
                    return 1; // Player is to the right of the enemy car
                } else {
                    return 0; // Player and enemy car have the same x and y positions
                }
            }
        } else {
            throw new IllegalArgumentException("Object must be an instance of EnemyCar");
        }
    }
}
