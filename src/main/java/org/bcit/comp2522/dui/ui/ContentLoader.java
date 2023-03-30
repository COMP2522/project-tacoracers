package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.Manager;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.util.ArrayList;

public class ContentLoader extends PApplet {
  public PImage playerImage;
  public PImage heart;
  public PImage heartLost;
  public PImage roadLine;
  public PFont bigFont;
  public PFont smallFont;
  public PFont mediumFont;
  PFont tinyFont;
  public ContentLoader() {  }

  public void load() {
    playerImage = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/playerImage.png"));
    heart = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/heart.png"));
    heartLost = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/heartLost.png"));
    roadLine = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/roadline.png"));
  }

  public void loadFonts(PApplet pApplet) {
    bigFont = pApplet.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 150, true);
    smallFont = pApplet.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 48, true);
    mediumFont = pApplet.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 64, true);
    tinyFont = pApplet.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 24, true);
  }

  void loadCarImages(Manager manager, ArrayList<PImage> cars) {
    for (int i = 1; i <= 5; i++) {
      PImage carImage = loadImage("src/main/java/org/bcit/comp2522/dui/content/carImage" + i + ".png");
      cars.add(carImage);
    }
  }
}
