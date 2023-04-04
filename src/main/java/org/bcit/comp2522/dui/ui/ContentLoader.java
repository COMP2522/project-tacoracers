package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.CarLinkedList;
import org.bcit.comp2522.dui.client.Manager;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * ContentLoader loads fonts and images at the start of the program.
 *
 * @author Eric Tatchell
 */
public class ContentLoader extends PApplet {
  public PImage playerImageRed;
  public PImage playerImageYellow;
  public PImage playerImageBlue;
  public PImage playerImagePurple;
  public PImage heart;
  public PImage heartLost;
  public PImage roadLine;
  public PImage mute;
  public  PImage playercar;
  public PImage powerup;
  public PFont bigFont;
  public PFont smallFont;
  public PFont mediumFont;
  public PFont tinyFont;

  public PImage getCar(){
    return playercar;
  }


  private Manager manager;


  //function that will update the image of the car when the user selects a new car
  // using the manager.carType variable which gets changed in the button class

  public void load() {
    playerImageYellow = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/lambo.png"));
    playerImageRed = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/redside2.png"));
    playerImagePurple = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/Purp.png"));
    playerImageBlue = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/viper.png"));
    heart = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/heart.png"));
    heartLost = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/heartLost.png"));
    roadLine = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/roadline.png"));
    mute = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/mute.png"));
    powerup = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/repair.png"));
  }

  public void loadFonts(PApplet p) {
    bigFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 150, true);
    smallFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 48, true);
    mediumFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 64, true);
    tinyFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 24, true);
  }

  void loadCarImages(Manager manager, CarLinkedList<PImage> cars) {
    for (int i = 1; i <= 5; i++) {
      PImage carImage = loadImage("src/main/java/org/bcit/comp2522/dui/content/carImage" + i + ".png");
      cars.add(carImage);
    }
  }
}