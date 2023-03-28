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
public class Player extends Sprite implements Collidable {
    public boolean playerDeath;
    public int lives = 3;
    public PImage heart;
    public PImage heartLost;

    public Player(PVector position, Window window, float playerWidth, float playerHeight) {
        super(position, window, playerWidth, playerHeight);
        this.playerDeath = false;
        this.lives = 3;
        heart = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/heart.png");
        heartLost = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/heartLost.png");
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

    public void handleKeyPress(int keyCode) {
        switch (keyCode) {
            case UP:
                setPosition(getPosition().x, lerp(getPosition().y, getPosition().y - 6, 1F));
                break;
            case DOWN:
                setPosition(getPosition().x, lerp(getPosition().y, getPosition().y + 6, 1F));
                System.out.println("here");
                break;
        }
    }




    @Override
    public void draw() {
        window.image(playerImage, getPosition().x, getPosition().y, width, height);
    }

    @Override
    public boolean collide(EnemyCar enemyCar) {
        float minDistanceX = (width / 2) + (enemyCar.getWidth() / 2);
        float minDistanceY = (height / 2) + (enemyCar.getHeight() / 2);
        if (Math.abs(position.x - enemyCar.getPosition().x) < minDistanceX
                && Math.abs(position.y - enemyCar.getPosition().y) < minDistanceY) {
            return true;
        }
        return false;
    }

}
