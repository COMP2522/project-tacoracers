package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;

import java.util.HashSet;

import static processing.core.PApplet.*;

/**
 * KeyInput handles all keyboard input from the user.
 *
 * @author Eric Tatchell
 */
public class KeyInput {

    // instance for window
    private Window window;

    // instance for player, main communicator
    private Player player;

    // instance for manager
    private Manager manager;

    // hash set to track pressed keys
    HashSet<Integer> pressedKeys = new HashSet<>();

    // for when the player is in SLOWED mode
    boolean isSpeedHalved;

    /**
     * Constructor assigning instances
     * @param window Window
     * @param player Player
     * @param manager Manager
     */
    public KeyInput(Window window, Player player, Manager manager) {
        this.window = window;
        this.player = player;
        this.manager = manager;
    }

    // used at game over screen to clear key presses from the finished game
    public void reset() {
        pressedKeys.clear();
    }

    /**
     * handleKeyEvent is the primary moving logic for the player.
     * Supports UP, DOWN and LEFT. Sets the players position based on a CLICK HOLD principle
     * @param keyCode received keycode from Window.java
     * @param path for setting path speed
     * @param keyDown t/f if key is held
     */
    public void handleKeyEvent(int keyCode, Path path, boolean keyDown) {
        if (keyDown) {
            switch (keyCode) {
                case UP:
                    // move the player up
                    if (player.getPosition().y > 100) {
                        player.setPosition(player.getPosition().x, lerp(player.getPosition().y,
                                player.getPosition().y - 6, 0.3F));
                    }
                    break;
                case DOWN:
                    // move the player down
                    if (player.getPosition().y < 515) {
                        player.setPosition(player.getPosition().x, lerp(player.getPosition().y,
                                player.getPosition().y + 6, 0.3F));
                    }
                    break;
                case LEFT:
                    // slow the game down
                    path.setSpeed(10);
                    player.setSpeed(player.slowedPlayerSpeed);
                    // halves the score increment
                    if (manager.game.getScoreIncrement() / 2 == 5) {
                        manager.game.setScoreIncrement(manager.game.getScoreIncrement() / 2);
                    }
                    window.fill(255, 255, 255);
                    window.textFont(manager.contentLoader.mediumFont);
                    window.text("SLOWED", (window.width / 4), 327);
                    break;
            }
        } else {
            if (keyCode == LEFT) {
                // For when the left key is released, reset all speed values
                path.setSpeed(20);
                player.setSpeed(0.3F);
                if (manager.game.getScoreIncrement() * 2 == 10) {
                    manager.game.setScoreIncrement(manager.game.getScoreIncrement() * 2);
                }
            }
        }
    }

    /**
     * updateKeyStates is the primary communicator for UI to track key presses
     * @param ui
     */
    public void updateKeyStates(UI ui) {
        if (pressedKeys.contains(UP)) {
            handleKeyEvent(UP, manager.path, true);
        }
        if (pressedKeys.contains(DOWN)) {
            handleKeyEvent(DOWN, manager.path, true);
        }
      float speedMultiplier;
      if (pressedKeys.contains(LEFT)) {
            handleKeyEvent(LEFT, manager.path, true);
            if (!isSpeedHalved) {
                speedMultiplier = 0.5f;
                for (EnemyCar enemyCar : ui.traffic) {
                    enemyCar.setSpeed(enemyCar.getOriginalSpeed() * speedMultiplier);
                }
                isSpeedHalved = true;
            }
        } else {
            if (isSpeedHalved) {
                handleKeyEvent(LEFT, manager.path, false);
                speedMultiplier = 1.0f;
                for (EnemyCar enemyCar : ui.traffic) {
                    enemyCar.setSpeed(enemyCar.getOriginalSpeed() * speedMultiplier);
                }
                isSpeedHalved = false;
            }
        }
    }

}
