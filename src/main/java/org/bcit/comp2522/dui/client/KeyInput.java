package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;

import java.util.HashSet;

import static processing.core.PApplet.lerp;

public class KeyInput {
    private Window window;
    private Player player;
    private Manager manager;
    private PowerUp powerup;
    private HashSet<Integer> pressedKeys = new HashSet<>();
    private boolean isSpeedHalved;

    public KeyInput(Window window, Player player, Manager manager, PowerUp powerup) {
        this.window = window;
        this.player = player;
        this.powerup = powerup;
        this.manager = manager;
    }

    public void handleKeyEvent(int keyCode, Path path, boolean keyDown) {
        float newY;

        if (keyDown) {
            if (keyCode == window.UP) {
                newY = lerp(player.getPosition().y, player.getPosition().y - 6, 0.3F);
                if (player.getPosition().y > 100) player.setPosition(player.getPosition().x, newY);
            } else if (keyCode == window.DOWN) {
                newY = lerp(player.getPosition().y, player.getPosition().y + 6, 0.3F);
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

    private void handleLeftKeyDown(Path path) {
        path.setSpeed(10);

        if (manager.game.getScoreIncrement() / 2 == 5) {
            manager.game.setScoreIncrement(manager.game.getScoreIncrement() / 2);
        }

        window.fill(255, 255, 255);
        window.textFont(manager.contentLoader.getMediumFont());
        window.text("SLOWED", (window.width / 4), 327);

        if (!isSpeedHalved) {
            updateSpeeds(0.5f);
            powerup.halfSpeed();
            isSpeedHalved = true;
        }
    }

    private void handleLeftKeyUp(Path path) {
        path.setSpeed(20);

        if (manager.game.getScoreIncrement() * 2 == 10) {
            manager.game.setScoreIncrement(manager.game.getScoreIncrement() * 2);
        }

        if (isSpeedHalved) {
            updateSpeeds(1.0f);
            powerup.resetSpeed();
            isSpeedHalved = false;
        }
    }

    private void updateSpeeds(float speedMultiplier) {
        UI ui = manager.getUi();
        ui.getTraffic().forEach(enemyCar -> {
            enemyCar.setSpeed(enemyCar.getOriginalSpeed() * speedMultiplier);
        });
    }

    public void updateKeyStates() {
        if (pressedKeys.contains(window.UP)) handleKeyEvent(window.UP, manager.path, true);
        if (pressedKeys.contains(window.DOWN)) handleKeyEvent(window.DOWN, manager.path, true);
        if (pressedKeys.contains(window.LEFT)) handleKeyEvent(window.LEFT, manager.path, true);
        else handleKeyEvent(window.LEFT, manager.path, false);
    }

    public HashSet<Integer> getPressedKeys() {
        return pressedKeys;
    }
}
