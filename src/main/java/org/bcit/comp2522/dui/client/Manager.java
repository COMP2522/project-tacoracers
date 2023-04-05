package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.ContentLoader;
import org.bcit.comp2522.dui.ui.UI;
import processing.core.*;

/**
 * Manager class creates a UI and game instance
 *
 * @author Eric Tatchell
 */
public class Manager extends PApplet {
  public UI ui;
  public Game game;
  public Button button;
  public Path path;
  public ContentLoader contentLoader;
  public KeyInput keyInput;
  public boolean muted;

  public Menu menu;

  /**
   * screenState tracks the current state of the screen and which to show.
   * 0: Playing
   * 1: Game Over
   * 2: Title Screen
   * 3: Main Menu
   * 4. Car Selection
   * 5. Leaderboard
   * 6. Difficulty
   */
  public int screenState;

  public int carType;

  public Manager() {
    contentLoader = new ContentLoader();
  }

  public void run(Window scene) {
    screenState = 2; // main menu
    carType = 2;

    path = new Path(this, scene); // Move this line before the UI initialization
    ui = new UI(this, contentLoader, scene);
    keyInput = new KeyInput(scene, ui.getPlayer(), this, ui.getPowerup());
    game = new Game(this);
    this.menu = new Menu(this, scene);
    button = new Button(scene, this);
    ui.init();
  }

  public void managePowerUp(PowerUp powerup) {
    if (!powerup.isActive()) {
      ui.spawnPowerUp(powerup);
      powerup.setActive(true);
    }
  }

}
