package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;
import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 * In my head: Window should create and call a Manager
 * Manager creates and calls UI, sprites and game scoring
 */
public class Manager extends PApplet {
  Window window;
  UI ui;
  Game game;
  public Player player;
  public Manager(Window window) {
    ui = new UI(window);
    game = new Game(); // CHANGE WITH NECESSARY PARAMS
    // sprite here. arraylist? player? change later
  }
  public Manager() {

  }

  @Override
  public void keyPressed(KeyEvent event) {
    int keyCode = event.getKeyCode();
    switch(keyCode) {
      case UP:
        ui.player.getPosition().y += ui.player.yVel;
        System.out.println("up");
        break;
      case DOWN:
        ui.player.getPosition().y -= ui.player.yVel;
        System.out.println("down");
        break;
    }
  }

  public void playerMove(int y) {
    player.move(y);
  }

  public void run() {
    ui.init();
    // game.init() which starts the process
    // some shit with sprites idk yet
  }
}
