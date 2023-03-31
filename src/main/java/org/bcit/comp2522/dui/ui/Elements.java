package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.*;


/**
 * Elements handles the majority of UI elements seen on screen.
 *
 * @author Eric Tatchell
 */
public class Elements {
  private ContentLoader loader;
  private Manager manager;
  private Window window;
  private Path path;

  public Elements(Window window, Manager manager, ContentLoader loader) {
    this.manager = manager;
    this.loader = loader;
    this.window = window;
  }
  public void muteButton() {
    window.image(manager.contentLoader.mute, 300, 25);
    manager.button.mute();
  }
  public void muted() {
    if (manager.muted) {
      window.fill(0);
      window.textFont(manager.contentLoader.tinyFont);
      window.text("Muted!", 400, 25);
    }
  }
  public void borders() {
    window.background(0);
    window.rect(0, 600, 1280, 500); // top of the border
    window.fill(255);
    window.rect(0, 100, 1280, -500); // bottom of the border
    window.fill(255);
  }
  public void displayScore() {
    window.textFont(manager.contentLoader.tinyFont);
    window.textAlign(manager.LEFT);
    window.fill(0, 0, 255);
    window.text("Score: " + manager.game.score, 850, 75); // display the score at position (, )
  }
  public void displayHighScore() {
    window.textFont(manager.contentLoader.tinyFont);
    window.textAlign(manager.LEFT);
    window.fill(0, 0, 255);
    window.text("High Score: " + manager.game.highScore, 850, 45); // display the high score at position (, )
  }
}
