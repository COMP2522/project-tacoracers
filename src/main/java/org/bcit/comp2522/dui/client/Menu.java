package org.bcit.comp2522.dui.client;

import processing.core.PImage;

import org.bson.Document;

public class Menu {
  private Manager manager;
  private Window window;
  String scoreDisplay;
  String highScoreDisplay;
  public String inputName = "";
  public String playerName = "";

  public boolean nameIsValid = false;

  private boolean keyPressed = false;

  PImage car1, car2, car3, car4;
  public Menu(Manager manager, Window scene) {
    this.manager = manager;
    this.window = scene;

    car1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/redUpright.png");
    car2 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/lamboUpright.png");
    car3 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/viperUpright.png");
    car4 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/PurpUpright.png");
  }

  public void menu2() {
    window.background(0);


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
    window.text("LeaderBoard", window.width / 2 + 10, 100 + 300);
    manager.button.leaderboard();

    // Should take you to a page that asks if you really want to quit
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Quit", 900, 100 + 450);
    manager.button.quit();
  }


  /**
   * Check the score to see if the player has unlocked the next car if they have then call the
   * function that will see if the player chooses the red yellow or blue car and then
   * set the player.carColor to the color they chose
   * then in the player class you can use a switch statement to change the color of the car.
   */
  public void carSelection(){
    window.background(0);


    window.fill(255,255,255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Car Rank", window.width / 2, 90);

    // Red
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Red", 150, 450);

    window.image(car1, 100, 125, 150, 250);

    window.fill(255, 255, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.textSize(30);
    window.text("Select", 150, 525);
    manager.button.red();


    // Yellow
    window.fill(255, 255, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Yellow", 475, 450);

    window.image(car2, 425, 125, 100, 250);
    if (manager.game.highScore >= 1000) {
      window.fill(255, 255, 255);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 475, 525);
      manager.button.yellow();
    }

    // Blue
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Blue", 775, 450);
    window.image(car3, 725, 125, 100, 250);
    if (manager.game.highScore >= 2500) {
      window.fill(255, 255, 255);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 775, 525);
      manager.button.blue();
    }

    // Purple
    window.fill(160, 32, 240);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Purple", 1075, 450);
    window.image(car4, 1025, 125, 100, 250);
    if (manager.game.highScore >= 5000) {
      window.fill(255, 255, 255);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 1075, 525);
      manager.button.purple();
      //player.BlueCar();
    }
  }


  public void gameOver() {
    manager.game.stopScore();
    window.background(0);
    scoreDisplay = String.format("Your score: %d", manager.game.score);

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

  public void main() {
    validateName();
    window.background(0);
    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getBigFont());
    window.text("DUI", window.width / 2, 200);

    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getBigFont());
    window.text("DUI", window.width / 2 + 10, 200 + 10);
    window.fill(255);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Driving\nUnintelligently", window.width / 2, 300);

    window.fill(255);
    window.textFont(manager.contentLoader.getTinyFont());
    window.text("Enter your name: ", window.width / 2, 400);
    window.rect( (window.width / 2) - 150, 400, 300, 40);
    window.textAlign(window.CENTER);
    window.fill(0);
    window.textAlign(window.CENTER);
    window.text(playerName, window.width / 2, 430);

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