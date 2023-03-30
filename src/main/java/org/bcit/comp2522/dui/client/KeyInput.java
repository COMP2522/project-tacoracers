//package org.bcit.comp2522.dui.client;
//
//import org.bcit.comp2522.dui.ui.UI;
//
//import java.util.HashSet;
//
//import static processing.core.PApplet.*;
//
//public class KeyInput extends Manager {
//    private Window window;
//    private Player player;
//
//
//    public KeyInput(Window window, Player player) {
//        this.window = window;
//        this.player = player;
//    }
//    public void handleKeyEvent(int keyCode, Path path, boolean keyDown) {
//        if (keyDown) {
//            switch (keyCode) {
//                case UP:
//                    if (player.getPosition().y > 100) {
//                        player.setPosition(player.getPosition().x, lerp(player.getPosition().y,
//                                player.getPosition().y - 6, player.getPlayerSpeed()));
//                    }
//                    break;
//                case DOWN:
//                    if (player.getPosition().y < 515) {
//                        player.setPosition(player.getPosition().x, lerp(player.getPosition().y,
//                                player.getPosition().y + 6, player.getPlayerSpeed()));
//                        System.out.println("here");
//                    }
//                    break;
//                case LEFT:
//                    path.setSpeed(10);
//                    player.setSpeed(player.slowedPlayerSpeed);
//                    window.fill(255, 255, 255);
//                    window.textFont(window.mediumFont);
//                    window.text("SLOWED", (window.width / 4), 327);
//                    break;
//            }
//        } else {
//            if (keyCode == LEFT) {
//                path.setSpeed(20);
//                player.setSpeed(0.3F);
//            }
//        }
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
//
//}
