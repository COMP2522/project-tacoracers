package org.bcit.comp2522.dui.client;

public class Menu {
  private Manager manager;
  private Window window;
  public Menu(Manager manager, Window scene) {
    this.manager = manager;
    this.window = scene;
  }

  public void gameOver() {
    manager.playing = false;
    manager.game.updateHighScore();
    manager.game.resetScore();
    window.background(0);
    window.fill(255, 0, 0);
    window.textFont(manager.contentLoader.mediumFont);
    window.textAlign(window.CENTER);
    window.text("TOTALED", (window.width / 2), 200);
    window.rect((window.width / 2) - 280, 400, 560, 75);
    window.textAlign(window.CENTER);
    window.fill(0);
    window.textFont(manager.contentLoader.smallFont);
    window.text("PLAY AGAIN", (window.width / 2), 455);
    manager.button.restart();
  }

  public void main() {
    window.background(0);
    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.bigFont);
    window.text("DUI", window.width / 2, 200);
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.bigFont);
    window.text("DUI", window.width / 2 + 10, 200 + 10);
    window.fill(255);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Driving\nUnintelligently", window.width / 2, 300);
    window.rect( (window.width / 2) - 150, 450, 300, 125);
    window.textAlign(window.CENTER);
    window.fill(0);
    window.textFont(manager.contentLoader.mediumFont);
    window.text("PLAY", window.width / 2, 535);
    manager.button.play();
  }
}
