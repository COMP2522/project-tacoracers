// KeyInput.java
package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;
import static processing.core.PApplet.*;

public class KeyInput {
    private Player player;
    private UI ui;
    float playerSpeed = 0.3F;
    float slowedPlayerSpeed = 0.1F;
    public KeyInput(Player player, UI ui) {
        this.player = player;
        this.ui = ui;
    }

    public void handleKeyEvent(int keyCode, boolean keyDown) {
        if (keyDown) {
            switch (keyCode) {
                case UP:
                    if (player.getPosition().y > 100) {
                        player.setPosition(player.getPosition().x, lerp(player.getPosition().y,
                                player.getPosition().y - 6, player.getPlayerSpeed()));
                    } break;
                case DOWN:
                    if (player.getPosition().y < 515) {
                        player.setPosition(player.getPosition().x, lerp(player.getPosition().y,
                                player.getPosition().y + 6, player.getPlayerSpeed()));
                        System.out.println("here");
                    } break;
                case LEFT:
                    ui.path.setSpeed(10);
                    player.setSpeed(slowedPlayerSpeed);
                    ui.window.fill(255, 255, 255);
                    ui.window.textFont(ui.window.mediumFont);
                    ui.window.text("SLOWED", (ui.window.width / 4), 327);
                    break;
            }
        } else {
            if (keyCode == LEFT) {
                ui.path.setSpeed(20);
                player.setSpeed(0.3F);
            }
        }
    }

    public void update() {
        updateKeyStates();
    }

    public void updateKeyStates() {
        if (player.pressedKeys.contains(UP)) {
            handleKeyEvent(UP, true);
        }
        if (player.pressedKeys.contains(DOWN)) {
            handleKeyEvent(DOWN, true);
        }
        if (player.pressedKeys.contains(LEFT)) {
            handleKeyEvent(LEFT, true);
            if (!player.isSpeedHalved) {
                player.speedMultiplier = 0.5f;
                for (EnemyCar enemyCar : ui.traffic) {
                    enemyCar.setSpeed(enemyCar.getOriginalSpeed() * player.speedMultiplier);
                }
                player.isSpeedHalved = true;
            }
        } else {
            if (player.isSpeedHalved) {
                handleKeyEvent(LEFT, false);
                player.speedMultiplier = 1.0f;
                for (EnemyCar enemyCar : ui.traffic) {
                    enemyCar.setSpeed(enemyCar.getOriginalSpeed() * player.speedMultiplier);
                }
                player.isSpeedHalved = false;
            }
        }
    }

}
