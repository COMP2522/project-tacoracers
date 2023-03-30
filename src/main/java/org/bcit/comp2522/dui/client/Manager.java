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
  public boolean playing = false;
  public Manager() {
    contentLoader = new ContentLoader();
  }
  public void run(Window scene) {
    path = new Path(this, scene); // Move this line before the UI initialization
    ui = new UI(this, contentLoader, scene);
    keyInput = new KeyInput(scene, ui.player, this);
    game = Game.getInstance();
    button = new Button(scene, this);
    ui.init();
  }
}
