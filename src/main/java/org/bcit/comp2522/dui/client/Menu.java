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

  PImage car1, car2, car3, car4,
          truck1, truck2, truck3,
          moto1, moto2, moto3, moto4;
  public Menu(Manager manager, Window scene) {
    this.manager = manager;
    this.window = scene;

    // car images
    car1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/redUpright.png");
    car2 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/lamboUpright.png");
    car3 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/viperUpright.png");
    car4 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/PurpUpright.png");

    //moto images
    moto1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/redBikeUPP.png");
    moto2 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/yellowBikeUPP.png");
    moto3 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/bike1Upright.png");
    moto4 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/purpleBikeUp.png");

  //truck images
    truck1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/truck1NoBGUpright.png");
//    truck2 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/truck2.png");
//    truck3 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/truck3.png");



  }

  public void menu2() {
    window.background(window.background);

    //quit
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Quit", 120, 100);
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
    window.text("LeaderBoard", window.width / 2 + 10, 100 + 300);
    manager.button.leaderboard();

    // play button
    window.fill(0, 0, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getMediumFont());
    window.text("Play", 900, 100 + 450);
    manager.button.play2();
  }


  //should check to see if the user has selected the easy, medium, or hard difficulty
  // and with that info set the different car selection images
  public void difficulty(){
    window.background(0);

    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getMediumFont());
    window.text("Difficulty", window.width / 2, 90);


  //motorcycle
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Easy", 150, 450);

    //image
    window.image(moto1, 100, 125, 100, 250);
    window.fill(255, 0, 0);
//

    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.textSize(30);
    window.text("Select", 150, 525);
    manager.button.easy();


    //car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Medium", 600, 450);

    //image
    window.image(car1, 550, 125, 150, 250);

    //select
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 600, 525);
      manager.button.medium();



    //Truck
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Hard", 1050, 450);

    //image
    window.image(truck1, 1000, 125, 100, 250);

    //select
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 1050, 525);
      manager.button.hard();

  }


       /*
        check the score to see if the player has unlocked the next car if they have then call the
        function that will see if the player chooses the red yellow or blue car and then
         set the player.carColor to the color they chose
         then in the player class you can use a switch statement to change the color of the car
         */

  /**
   * Check the score to see if the player has unlocked the next car if they have then call the
   * function that will see if the player chooses the red yellow or blue car and then
   * set the player.carColor to the color they chose
   * then in the player class you can use a switch statement to change the color of the car.
   */
  public void carSelection(){
    window.background(window.background);

    //red car
    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Car Rank", window.width / 2, 90);

    // Red
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Red", 150, 450);

    //image
    window.image(car1, 100, 125, 150, 250);
    window.fill(255, 0, 0);
//

    window.fill(255, 255, 255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.textSize(30);
    window.text("Select", 150, 525);
    manager.button.red();


    //yellow car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("yellow", 475, 450);

    window.image(car2, 425, 125, 100, 250);

    if (manager.game.highScore >= 1000) {
      window.fill(255, 255, 255);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 475, 525);
      manager.button.yellow();
      //player.yellowCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Locked", 475, 525);
    }

    //blue car
    window.fill(255, 0, 0);
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
      //player.BlueCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Locked", 775, 525);
    }

    //purple car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Purple", 1075, 450);

    window.image(car4, 1025, 125, 100, 250);

    //select/locked
    if (manager.game.highScore >= 5000) {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 1075, 525);
      manager.button.purple();
      //player.BlueCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Locked", 1075, 525);
      //player.GreenCar();
    }
  }

  public void bikeSelection(){
    window.background(0);

    //red car
    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getMediumFont());
    window.text("Car Rank", window.width / 2, 90);

    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Red", 150, 450);

    //image
    window.image(moto1, 100, 125, 150, 250);
    window.fill(255, 0, 0);
//

    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.textSize(30);
    window.text("Select", 150, 525);
    manager.button.redbike();


    //yellow car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("yellow", 475, 450);

    //image
    window.image(moto2, 425, 125, 150, 250);
//    window.fill(255, 0, 0);
//    window.rect(425, 125, 100, 250);

    //select/locked
    if (manager.game.highScore >= 0) {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 475, 525);
      manager.button.yellowbike();
      //player.yellowCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Locked", 475, 525);
    }

    //blue car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Blue", 775, 450);

    //image
    window.image(moto3, 725, 125, 150, 250);
//    window.fill(255, 0, 0);
//    window.rect(725, 125, 100, 250);

    //select/locked
    if (manager.game.highScore >= 0) {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 775, 525);
      manager.button.bluebike();
      //player.BlueCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Locked", 775, 525);
    }

    //purple car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Purple", 1075, 450);

    window.image(moto4, 1025, 125, 150, 250);

    //select/locked
    if (manager.game.highScore >= 0) {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 1075, 525);
      manager.button.purplebike();
      //player.BlueCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Locked", 1075, 525);
      //player.GreenCar();
    }
  }

  public void truckSelection(){
    window.background(0);

    //red car
    window.fill(255);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getMediumFont());
    window.text("Car Rank", window.width / 2, 90);

    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Red", 150, 450);

    //image
    window.image(car1, 100, 125, 150, 250);
    window.fill(255, 0, 0);
//

    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.textSize(30);
    window.text("Select", 150, 525);
    manager.button.red();


    //yellow car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("yellow", 475, 450);

    //image
    window.image(car2, 425, 125, 150, 250);
//    window.fill(255, 0, 0);
//    window.rect(425, 125, 100, 250);

    //select/locked
    if (manager.game.highScore >= 0) {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 475, 525);
      manager.button.yellow();
      //player.yellowCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Locked", 475, 525);
    }

    //blue car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Blue", 775, 450);

    //image
    window.image(car3, 725, 125, 150, 250);
//    window.fill(255, 0, 0);
//    window.rect(725, 125, 100, 250);

    //select/locked
    if (manager.game.highScore >= 0) {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 775, 525);
      manager.button.blue();
      //player.BlueCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Locked", 775, 525);
    }

    //purple car
    window.fill(255, 0, 0);
    window.textAlign(window.CENTER);
    window.textFont(manager.contentLoader.getSmallFont());
    window.text("Purple", 1075, 450);

    window.image(car4, 1025, 125, 150, 250);

    //select/locked
    if (manager.game.highScore >= 0) {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Select", 1075, 525);
      manager.button.purple();
      //player.BlueCar();
    } else {
      window.fill(255, 0, 0);
      window.textAlign(window.CENTER);
      window.textFont(manager.contentLoader.getSmallFont());
      window.textSize(30);
      window.text("Locked", 1075, 525);
      //player.GreenCar();
    }
  }

  public void gameOver() {
    manager.game.stopScore();
    window.background(window.background);
    scoreDisplay = String.format("Your score: %d", manager.game.score);
    System.out.println(scoreDisplay);

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

  public void Leaderboard() {
    DatabaseHandler dbhandler = new DatabaseHandler("pavanbrar73", "KFmJyFJrTM6Dd7c2");

    window.background(0);

    window.textSize(32);
    window.fill(255);
    window.textAlign(window.CENTER);

    window.text("Leaderboard", window.width/2, 80);
    window.text("Rank", 100, 160);
    window.text("Name", window.width/2 - 200, 160);
    window.text("Score", window.width/2 + 200, 160);

    window.textSize(28);
    window.textAlign(window.CENTER, window.CENTER);
//    window.fill(255);
    int y = 200;
    int rank = 1;

    window.stroke(255);
    window.strokeWeight(2);
    window.line(80, 180, window.width - 80, 180);

    window.rect(80, 180, 70, y - 180);

    window.rect(window.width/2 - 390, 180, 340, y - 180);

    for (Document doc : dbhandler.getHighestScores()) {

      String name = doc.getString("name");
      long score = doc.getLong("score");
      window.stroke(255);
      window.strokeWeight(2);
      window.line(80, y - 20, window.width - 80, y - 20);

      window.text(rank, 150, y);

      window.rect(window.width/2 - 390, y - 20, 340, 40);

      window.text(name, window.width/2 - 120, y);

      window.rect(window.width/2 + 150, y - 20, 270, 40);

      window.text(score, window.width/2 + 270, y);

      window.stroke(255);
      window.strokeWeight(2);
      window.line(80, y + 20, window.width - 80, y + 20);

      y += 40;
      rank++;
    }

    window.stroke(255);
    window.strokeWeight(2);
    window.line(80, y - 20, window.width - 80, y - 20);
  }

  public void main() {
    validateName();
    window.background(window.background);
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