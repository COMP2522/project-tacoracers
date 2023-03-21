package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;
import processing.core.PVector;

/**
 * In my head: Window should create and call a Manager
 * Manager creates and calls UI, sprites and game scoring
 */
public class Manager extends Window {
  Window window;
  UI ui;
  Game game;
  Player player;
  public Manager(Window window) {
    ui = new UI(window);
    game = new Game(); // CHANGE WITH NECESSARY PARAMS
    // sprite here. arraylist? player? change later
    this.window = window;
    player = new Player(new PVector(500, 300), this.window);

  }

  public void run() {
    ui.init();
    // game.init() which starts the process
    // some shit with sprites idk yet
  }
}
