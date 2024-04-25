package org.bcit.comp2522.dui.client;

import processing.core.PImage;


import org.bson.Document;

/**
 * Menu class handles the 3 menus and name input.
 */
public class Menu {

  /**
   * manager instance.
   */
  private Manager manager;

  /**
   * window instance.
   */
  private Window window;

  /**
   * score display.
   */
  String scoreDisplay;

  /**
   * high score display.
   */
  String highScoreDisplay;

  /**
   * input name.
   */
  public String inputName = "";

  /**
   * player name.
   */
  public String playerName = "";

  /**
   * name is valid.
   */
  public boolean nameIsValid = false;

  /**
   * key pressed.
   */
  private boolean keyPressed = false;

  /**
   * Constructs manager and window objects.
   *
   * @param manager Manager
   * @param scene Window
   */
  public Menu(Manager manager, Window scene) {
    this.manager = manager;
    this.window = scene;

  }

  /**
   * Second menu.
   */
  public void menu2() {
    window.background(window.getBackground());

    //quit
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Quit", 120, 70);
    manager.button.quit();


    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getMediumFont());
    window.text("DUI", window.width / 2, 90);

    //Should take you to a page to select a car style
    //semi = hard
    //car = medium
    //moto = easy
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Difficulty", window.width / 2 + 10, 100 + 100);
    manager.button.diff();

    // Should take you to a page to select show you what car color your at
    // like skins but for cars that you unlock at certain scores
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Cars", window.width / 2 + 10, 100 + 200);
    manager.button.cars();


    // Should take you to a page to show you the top 10 scores
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Leaderboard", window.width / 2 + 10, 100 + 300);
    manager.button.leaderboard();

    // play button
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getMediumFont());
    window.text("Play", window.width - 175, 70);
    manager.button.play2();
  }

  /**
   * game over menu.
   */
  public void gameOver() {
    manager.game.stopScore();
    window.background(window.getBackground());
    scoreDisplay = "Score: " + manager.game.score;

    if (manager.game.score > manager.game.highScore) {
      highScoreDisplay = "New High Score!";
      window.fill(255, 255, 0);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textAlign(window.CENTER);
      window.text(highScoreDisplay, (window.width / 2), 275);
    } else {
      highScoreDisplay = "";
    }
    window.fill(255, 255, 255);
    window.textFont(manager.contentLoader.getSmallFont());
    window.textAlign(window.CENTER);
    window.text(scoreDisplay, (window.width / 2), 350);

    // Totaled
    window.fill(255, 0, 0);
    window.textFont(manager.contentLoader.getMediumFont());
    window.textAlign(window.CENTER);
    window.text("TOTALED", (window.width / 2), 175);

    manager.button.mainMenu();
    manager.button.playAgain();
  }

  /**
   * Main starting menu.
   */
  public void main() {
    validateName();
    window.background(window.getBackground());
    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getBigFont());
    window.text("DUI", window.width / 2, 190);

    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getBigFont());
    window.text("DUI", window.width / 2 + 10, 200);
    window.fill(255);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Driving\nUnintelligently", window.width / 2, 275);

    window.fill(255);
    window.textFont(manager.contentLoader.getTinyFont());
    window.text("Enter your name: ", window.width / 2, 375);
    window.rect( (window.width / 2) - 150, 390, 300, 40);
    window.textAlign(window.CENTER);
    window.fill(0);
    window.textAlign(window.CENTER);
    window.text(playerName, window.width / 2, 420);

    window.fill(255);
    window.rect( (window.width / 2) - 150, 450, 300, 125);
    window.textAlign(window.CENTER);
    window.fill(0);
    window.textFont(manager.contentLoader.getMediumFont());
    window.text("PLAY", window.width / 2, 535);
    if (nameIsValid) {
      manager.button.play();
    }
  }

  /**
   * Validates the name input.
   */
  public void validateName() {
    if (window.keyPressed && !keyPressed) {
      if (window.key >= 'a' && window.key <= 'z' || window.key >= 'A' && window.key <= 'Z') {
        if (inputName.length() < 20) {
          inputName += window.key;
          playerName = inputName;
          manager.game.setPlayerName(playerName);
        }
      } else if (window.key == window.BACKSPACE && inputName.length() > 0) {
        inputName = inputName.substring(0, inputName.length() - 1);
        playerName = inputName;
        manager.game.setPlayerName(playerName);

      }
      nameIsValid = !inputName.isEmpty() && inputName.length() > 2;
      keyPressed = true;
    } else if (!window.keyPressed) {
      keyPressed = false;
    }

  }

}