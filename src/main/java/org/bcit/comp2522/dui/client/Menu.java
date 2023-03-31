package org.bcit.comp2522.dui.client;

import processing.core.PImage;

import static processing.awt.ShimAWT.loadImage;

public class Menu {
  private Manager manager;
  private Window window;
  String scoreDisplay;
  String highScoreDisplay;

  PImage car1, car2, car3, car4;
  public Menu(Manager manager, Window scene) {
    this.manager = manager;
    this.window = scene;

    car1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/redUpright.png");
    car2 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/lamboUpright.png");
    car3 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/viperUpright.png");
    car4 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/PurpUpright.png");
  }

//  public void gameOver() {
//    manager.game.updateHighScore();
//    manager.game.resetScore();
//    window.background(0);
//    window.fill(255, 0, 0);
//    window.textFont(manager.contentLoader.mediumFont);
//    window.textAlign(window.CENTER);
//    window.text("TOTALED", (window.width / 2), 200);
//    window.rect((window.width / 2) - 280, 400, 560, 75);
//    window.textAlign(window.CENTER);
//    window.fill(0);
//    window.textFont(manager.contentLoader.smallFont);
//    window.text("PLAY AGAIN", (window.width / 2), 455);
//    manager.button.restart();
//  }
  public void menu2() {
    window.background(0);


    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.mediumFont);
    window.text("DUI", window.width / 2, 90);

    //Should take you to a page to select a car style
    //semi = hard
    //car = medium
    //moto = easy
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Difficulty", window.width / 2 + 10, 100 + 100);
    manager.button.diff();

    // Should take you to a page to select show you what car color your at
    // like skins but for cars that you unlock at certain scores
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Cars", window.width / 2 + 10, 100 + 200);
    manager.button.cars();

    // Should take you to a page to show you the top 3-5 scores
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("LeaderBoard", window.width / 2 + 10, 100 + 300);
    manager.button.leaderboard();

    // Should take you to a page that asks if you really want to quit
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Quit", 900, 100 + 450);
//    manager.button.quit();
  }

       /*
        check the score to see if the player has unlocked the next car if they have then call the
        function that will see if the player chooses the red yellow or blue car and then
         set the player.carColor to the color they chose
         then in the player class you can use a switch statement to change the color of the car
         */

  public void carSelection(){
    window.background(0);

    //red car
    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.mediumFont);
    window.text("Car Rank", window.width / 2, 90);

    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Red", 150, 450);

    //image
//    window.fill(car1);
    window.image(car1, 100, 125, 150, 250);
    window.fill(255, 0, 0);
//

    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.textSize(30);
    window.text("Select", 150, 525);
    manager.button.red();

//    //select/locked
//    if (manager.game.highScore >= 0) {
//      window.fill(255, 0, 0);
//      window.textAlign(window.CENTER);
//      window.textFont(manager.contentLoader.smallFont);
//      window.textSize(30);
//      window.text("Select", 150, 525);
//      manager.button.red();
//    } else {
//      window.fill(255, 0, 0);
//      window.textAlign(window.CENTER);
//      window.textFont(manager.contentLoader.smallFont);
//      window.textSize(30);
//      window.text("Locked", 150, 525);
//    }


    //yellow car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("yello", 475, 450);

    //image
    window.image(car2, 425, 125, 100, 250);
//    window.fill(255, 0, 0);
//    window.rect(425, 125, 100, 250);

    //select/locked
    if (manager.game.highScore >= 0) {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.smallFont);
      window.textSize(30);
      window.text("Select", 475, 525);
      manager.button.yellow();
      //player.yellowCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.smallFont);
      window.textSize(30);
      window.text("Locked", 475, 525);
    }

    //blue car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Blue", 775, 450);

    //image
    window.image(car3, 725, 125, 100, 250);
//    window.fill(255, 0, 0);
//    window.rect(725, 125, 100, 250);

    //select/locked
    if (manager.game.highScore >= 0) {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.smallFont);
      window.textSize(30);
      window.text("Select", 775, 525);
      manager.button.blue();
      //player.BlueCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.smallFont);
      window.textSize(30);
      window.text("Locked", 775, 525);
    }

    //purple car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.smallFont);
    window.text("Purple", 1075, 450);

    window.image(car4, 1025, 125, 100, 250);
//    window.fill(255, 0, 0);
//    window.rect(1025, 125, 100, 250);

    //select/locked
    if (manager.game.highScore >= 0) {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.smallFont);
      window.textSize(30);
      window.text("Select", 1075, 525);
      manager.button.purple();
      //player.BlueCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.smallFont);
      window.textSize(30);
      window.text("Locked", 1075, 525);
      //player.GreenCar();
    }
  }


  public void gameOver() {
    window.background(0);
    scoreDisplay = String.format("Your score: %d", manager.game.score);
    System.out.println(scoreDisplay);

    if (manager.game.score > manager.game.highScore) {
      highScoreDisplay = "New High Score!";
      window.fill(255, 255, 0);
      window.textFont(manager.contentLoader.smallFont);
      window.textAlign(window.CENTER);
      window.text(highScoreDisplay, (window.width / 2), 275);
    } else {
      highScoreDisplay = "";
    }
    window.fill(255, 255, 255);
    window.textFont(manager.contentLoader.smallFont);
    window.textAlign(window.CENTER);
    window.text(scoreDisplay, (window.width / 2), 350);

    // Totaled
    window.fill(255, 0, 0);
    window.textFont(manager.contentLoader.mediumFont);
    window.textAlign(window.CENTER);
    window.text("TOTALED", (window.width / 2), 175);

    // play again
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
