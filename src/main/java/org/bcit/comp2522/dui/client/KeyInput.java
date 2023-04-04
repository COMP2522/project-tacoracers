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

    // instance for powerup
    private PowerUp powerup;

    // hash set to track pressed keys
    HashSet<Integer> pressedKeys = new HashSet<>();

    // for when the player is in SLOWED mode
    boolean isSpeedHalved;

    /**
     * Constructor assigning instances
     *
     * @param window  Window
     * @param player  Player
     * @param manager Manager
     */
    public KeyInput(Window window, Player player, Manager manager, PowerUp powerup) {
        this.window = window;
        this.player = player;
        this.powerup = powerup;
        this.manager = manager;
    }

    /**
     * handleKeyEvent is the primary moving logic for the player.
     * Supports UP, DOWN and LEFT. Sets the players position based on a CLICK HOLD principle
     *
     * @param keyCode received keycode from Window.java
     * @param path    for setting path speed
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
                    player.setSpeed(player.getSlowedPlayerSpeed());
                    // halves the score increment
                    if (manager.game.getScoreIncrement() / 2 == 5) {
                        manager.game.setScoreIncrement(manager.game.getScoreIncrement() / 2);
                    }
                    window.fill(255, 255, 255);
                    window.textFont(manager.contentLoader.getMediumFont());
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
     *
     * @param ui UI to be updated
     */
    public void updateKeyStates(UI ui) {
        // Check if the UP key is pressed
        if (pressedKeys.contains(UP)) {
            handleKeyEvent(UP, manager.path, true);
        }
        // Check if the DOWN key is pressed
        if (pressedKeys.contains(DOWN)) {
            handleKeyEvent(DOWN, manager.path, true);
        }

        float speedMultiplier;

        // Check if the LEFT key is pressed
        if (pressedKeys.contains(LEFT)) {
            handleKeyEvent(LEFT, manager.path, true);

            // If the speed has not already been halved, do so now
            if (!isSpeedHalved) {
                speedMultiplier = 0.5f;
                // Iterate over enemy cars and set their speed to half of their original speed
                ui.getTraffic().forEach(enemyCar -> {
                    enemyCar.setSpeed(enemyCar.getOriginalSpeed() * speedMultiplier);
                });
                powerup.halfSpeed();
                // Set the flag to indicate that the speed has been halved
                isSpeedHalved = true;
            }
        } else {
            // If the LEFT key is not pressed and the speed was previously halved, restore it
            if (isSpeedHalved) {
                handleKeyEvent(LEFT, manager.path, false);
                speedMultiplier = 1.0f;
                // Iterate over enemy cars and set their speed to their original speed
                ui.getTraffic().forEach(enemyCar -> {
                    enemyCar.setSpeed(enemyCar.getOriginalSpeed() * speedMultiplier);
                });
                powerup.resetSpeed();
                // Set the flag to indicate that the speed is no longer halved
                isSpeedHalved = false;
            }
        }
    }
}

