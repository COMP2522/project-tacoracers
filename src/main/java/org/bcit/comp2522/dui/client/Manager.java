package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;
/**
 * In my head: Window should create and call a Manager
 * Manager creates and calls UI, sprites and game scoring
 */
public class Manager extends Window {
  Window window;
  UI ui;
  Sprite sprite;
  Game game;
  public Manager(Window window) {
    ui = new UI(window);
    game = new Game(); // CHANGE WITH NECESSARY PARAMS
    // sprite here. arraylist? player? change later
  }

  public void run() {
    ui.init();
    // game.init() which starts the process
    // some shit with sprites idk yet
  }
}
