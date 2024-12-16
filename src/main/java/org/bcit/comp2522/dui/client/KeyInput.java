package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;

import java.util.HashSet;

import static processing.core.PApplet.lerp;

/**
 * KeyInput handles user key presses.
 *
 * @aauthor Eric Tatchell
 */
public class KeyInput {

    // default player speed
    private final float playerSpeed = 0.3F;
    private Window window;
    private Player player;
    private Manager manager;
    private PowerUp powerup;
    private HashSet<Integer> pressedKeys = new HashSet<>();
    private boolean isSpeedHalved;

    //

    /**
     * Instantiates a new Key input.
     *
     * @param window  the window
     * @param player  the player
     * @param manager the manager
     * @param powerup the powerup
     */
    public KeyInput(Window window, Player player, Manager manager, PowerUp powerup) {
        this.window = window;
        this.player = player;
        this.powerup = powerup;
        this.manager = manager;
    }

    /**
     * handleKeyEvent handles all key inputs from the user.
     * lerp is a PApplet method for interpolation.
     *
     * @param keyCode the key code
     * @param path    affected upon LEFT key press
     * @param keyDown the pressed key
     */
    public void handleKeyEvent(int keyCode, Path path, boolean keyDown) {
        float newY;

        if (keyDown) {
            if (keyCode == window.UP) {
                newY = lerp(player.getPosition().y, player.getPosition().y - 6, playerSpeed);
                if (player.getPosition().y > 100) player.setPosition(player.getPosition().x, newY);
            } else if (keyCode == window.DOWN) {
                newY = lerp(player.getPosition().y, player.getPosition().y + 6, playerSpeed);
                if (player.getPosition().y < 515) player.setPosition(player.getPosition().x, newY);
            } else if (keyCode == window.LEFT) {
                handleLeftKeyDown(path);
            }
        } else {
            if (keyCode == window.LEFT) {
                handleLeftKeyUp(path);
            }
        }
    }

    /**
     * Slows down the roadlines if the LEFT key is pressed.
     * @param path roadlines
     */
    private void handleLeftKeyDown(Path path) {
        path.setSpeed(10);

        if (manager.game.getScoreIncrement() / 2 == 5) {
            manager.game.setScoreIncrement(manager.game.getScoreIncrement() / 2);
        }

        window.fill(255, 255, 255);
        window.textFont(manager.contentLoader.getMediumFont());
        window.text("SLOWED", (window.width / 4), 327);

        // halves speed if it isn't already
        if (!isSpeedHalved()) {
            updateSpeeds(0.5f);
            powerup.halfSpeed();
            setSpeedHalved(true);
        }
    }

    /**
     * Resets the speed to normal upon release.
     *
     * @param path roadllines
     */
    private void handleLeftKeyUp(Path path) {
        path.setSpeed(20);

        if (manager.game.getScoreIncrement() * 2 == 10) {
            manager.game.setScoreIncrement(manager.game.getScoreIncrement() * 2);
        }

        if (isSpeedHalved()) {
            updateSpeeds(1.0f);
            powerup.resetSpeed();
            setSpeedHalved(false);
        }
    }

    /**
     * Updates the speeds in UI.
     *
     * @param speedMultiplier given speed
     */
    private void updateSpeeds(float speedMultiplier) {
        UI ui = manager.getUi();
        ui.getTraffic().forEach(enemyCar -> {
            enemyCar.setSpeed(enemyCar.getOriginalSpeed() * speedMultiplier);
        });
    }

    /**
     * Update key states.
     */
    public void updateKeyStates() {
        if (pressedKeys.contains(window.UP)) handleKeyEvent(window.UP, manager.path, true);
        if (pressedKeys.contains(window.DOWN)) handleKeyEvent(window.DOWN, manager.path, true);
        if (pressedKeys.contains(window.LEFT)) handleKeyEvent(window.LEFT, manager.path, true);
        else handleKeyEvent(window.LEFT, manager.path, false);
    }

    /**
     * Gets pressed keys.
     *
     * @return the pressed keys
     */
    public HashSet<Integer> getPressedKeys() {
        return pressedKeys;
    }

    /**
     * Gets t/f if speed halved.
     *
     * @return t/f
     */
    public boolean isSpeedHalved() {
        return isSpeedHalved;
    }

    /**
     * Sets t/f for halved speed.
     * @param speedHalved t/f
     */
    public void setSpeedHalved(boolean speedHalved) {
        isSpeedHalved = speedHalved;
    }
}
