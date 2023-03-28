package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;
import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 * Manager class creates a UI and game instance
 *
 * @author Eric Tatchell
 */
public class Manager extends PApplet {
  Window window;
  UI ui;
  Game game;
  public Player player;
  public Manager(Window scene) {
    this.window = scene;
    ui = new UI(scene);
    game = Game.getInstance(); // CHANGE WITH NECESSARY PARAMS
    // sprite here. arraylist? player? change later
  }
  public Manager() {}

  public void run() {
    ui.init();
    // some shit with sprites idk yet
  }


}
