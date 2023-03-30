package org.bcit.comp2522.dui.client;

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
    private boolean isSpeedHalved = false;
    public float speedMultiplier = 1.0f;
    HashSet<Integer> pressedKeys = new HashSet<>();
    public int lives = 3;
    public PImage heart;
    public PImage heartLost;
    private float playerSpeed = 0.3F;
    float slowedPlayerSpeed = 0.1F;

    public Player(Manager manager, Window window, PVector position, float playerWidth, float playerHeight) {
        super(manager, window, position, playerWidth, playerHeight);
        this.playerDeath = false;
        this.lives = 3;
//        this.keyInput = new KeyInput(window, this);
    }

//    public void handleKeyEvent(int keyCode, Path path, boolean keyDown) {
//        if (keyDown) {
//            switch (keyCode) {
//                case UP:
//                    if (getPosition().y > 100) {
//                        setPosition(getPosition().x, lerp(getPosition().y,
//                                getPosition().y - 6, getPlayerSpeed()));
//                    } break;
//                case DOWN:
//                    if (getPosition().y < 515) {
//                        setPosition(getPosition().x, lerp(getPosition().y,
//                                getPosition().y + 6, getPlayerSpeed()));
//                        System.out.println("here");
//                    } break;
//                case LEFT:
//                    path.setSpeed(10);
//                    setSpeed(slowedPlayerSpeed);
//                    window.fill(255, 255, 255);
//                    window.textFont(window.mediumFont);
//                    window.text("SLOWED", (window.width / 4), 327);
//                    break;
//            }
//        } else {
//            if (keyCode == LEFT) {
//                path.setSpeed(20);
//                setSpeed(0.3F);
//            }
//        }
//    }
//    public void update(UI ui) {
//        updateKeyStates(ui);
//    }
//    public void updateKeyStates(UI ui) {
//        if (pressedKeys.contains(UP)) {
//            handleKeyEvent(UP, ui.path, true);
//        }
//        if (pressedKeys.contains(DOWN)) {
//            handleKeyEvent(DOWN, ui.path, true);
//        }
//        if (pressedKeys.contains(LEFT)) {
//            handleKeyEvent(LEFT, ui.path, true);
//            if (!isSpeedHalved) {
//                speedMultiplier = 0.5f;
//                for (EnemyCar enemyCar : ui.traffic) {
//                    enemyCar.setSpeed(enemyCar.getOriginalSpeed() * speedMultiplier);
//                }
//                isSpeedHalved = true;
//            }
//        } else {
//            if (isSpeedHalved) {
//                handleKeyEvent(LEFT, ui.path, false);
//                speedMultiplier = 1.0f;
//                for (EnemyCar enemyCar : ui.traffic) {
//                    enemyCar.setSpeed(enemyCar.getOriginalSpeed() * speedMultiplier);
//                }
//                isSpeedHalved = false;
//            }
//        }
//    }
    public void check(EnemyCar enemyCar, Menu menu) {
        if (collide(enemyCar) && lives <= 3) {
            lives -= 1;
            enemyCar.position.x -= 1000;
            if (lives == -1) {
                menu.gameOver();
                playerDeath = true;
            }
        }
    }
    public float getPlayerSpeed() {
        return playerSpeed;
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
        if (Math.abs(position.x - enemyCar.getPosition().x) < minDistanceX
                && Math.abs(position.y - enemyCar.getPosition().y) < minDistanceY) {
            return true;
        }
        return false;
    }

}
