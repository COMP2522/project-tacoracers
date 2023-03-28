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
    private float playerSpeed = 0.3F;
    float slowedPlayerSpeed = 0.1F;
    private KeyInput keyInput;

    public Player(PVector position, Window window, float playerWidth, float playerHeight) {
        super(position, window, playerWidth, playerHeight);
        this.playerDeath = false;
        this.lives = 3;
        this.keyInput = new KeyInput(window, this);
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







    public float getPlayerSpeed() {
        return playerSpeed;
    }

    public void handleKeyEvent(int keyCode, Path path, boolean keyDown) {
        if (keyDown) {
            switch (keyCode) {
                case UP:
                    if (getPosition().y > 100) {
                        setPosition(getPosition().x, lerp(getPosition().y, getPosition().y - 6, playerSpeed));
                    }
                    break;
                case DOWN:
                    if (getPosition().y < 515) {
                        setPosition(getPosition().x, lerp(getPosition().y, getPosition().y + 6, playerSpeed));
                        System.out.println("here");
                    }
                    break;
                case LEFT:
                    path.setSpeed(10);
                    setSpeed(slowedPlayerSpeed);
                    window.fill(255, 255, 255);
                    window.textFont(window.mediumFont);
                    window.text("SLOWED", (window.width / 4), 327);
                    break;
            }
        } else {
            if (keyCode == LEFT) {
                path.setSpeed(20);
                setSpeed(0.3F);
            }
        }
    }



    public void displayHealth() {
        switch (this.lives) {
            case 3:
                window.image(this.heart, 75, 25, 50, 50);
                window.image(this.heart, 135, 25, 50, 50);
                window.image(this.heart, 195, 25, 50, 50);
                break;
            case 2:
                window.image(this.heart, 75, 25, 50, 50);
                window.image(this.heart, 135, 25, 50, 50);
                window.image(this.heartLost, 195, 25, 50, 50);
                break;
            case 1:
                window.image(this.heart, 75, 25, 50, 50);
                window.image(this.heartLost, 135, 25, 50, 50);
                window.image(this.heartLost, 195, 25, 50, 50);
                break;
            case 0:
                window.image(this.heartLost, 75, 25, 50, 50);
                window.image(this.heartLost, 135, 25, 50, 50);
                window.image(this.heartLost, 195, 25, 50, 50);
        }
    }

    public void setSpeed(float speed) {
        this.playerSpeed = speed;
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
