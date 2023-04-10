package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.*;
import processing.core.*;


/**
 * Elements handles the majority of UI elements seen on screen.
 *
 * @author Eric Tatchell
 */
public abstract class Elements {

  // CL instance
  private ContentLoader loader;

  // Manager instance
  private Manager manager;

  // Window instance
  private Window window;

    /**
     * Creates an elements object.
     *
     * @param window  Window
     * @param manager Manager
     * @param loader  ContentLoader
     */
    public Elements(Window window, Manager manager, ContentLoader loader) {
    this.manager = manager;
    this.loader = loader;
    this.window = window;
  }

  /**
   *  draws the mute button.
   */
  public void muteButton() {
    window.image(manager.contentLoader.getMute(), 300, 25);
    manager.button.checkMuteButtonClick();
    if (manager.muted) {
      displayText(loader.getTinyFont(), 0, 0, 0, 0,
              "Muted!", 400, 25);
      window.musicPlayer.stop();
    }
  }

  /**
   * draws the borders on top.
   */
  public void borders() {
    window.background(0);
    window.fill(255);
    window.rect(0, 100, 1280, -500);
  }

    /**
     * Displays text to the screen.
     *
     * @param font  PFont from ContentLoader
     * @param align Left, middle or right align. 0 if no align!!
     * @param R     Red RGB value
     * @param G     Green RGB value
     * @param B     Blue RGB value
     * @param text  String
     * @param x     x pos
     * @param y     y pos
     */
    public void displayText(PFont font, int align,
                            float R, float G, float B, String text, float x, float y) {
    window.fill(R, G, B);
    window.textFont(font);
    if (align != 0) {
      window.textAlign(align);
    }
    window.text(text, x, y);
  }
}
