package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.Button;
import org.bcit.comp2522.dui.client.Manager;
import org.bcit.comp2522.dui.client.Window;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.util.ArrayList;

public class ContentLoader extends PApplet {
  public PImage playerImage;
  public PImage heart;
  public PImage heartLost;
  public PImage roadLine;
  public PImage mute;
  public PFont bigFont;
  public PFont smallFont;
  public PFont mediumFont;
  public PFont tinyFont;
  public  PImage playercar;


//  public void carLoader(int type) {
//
//    switch (type){
//
//      case 0:
//        playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/redside2.png"));
//        break;
//
//        case 1:
//          playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/lambo.png"));
//            break;
//
//        case 2:
//          playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/viper.png"));
//            break;
//
//        case 3:
//          playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/Purp.png"));
//            break;
//
//      default:
//         playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/redside2.png"));
//        break;
//    }
//
//  }


//  if (button.red()){
//    playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/redside2.png"));
//  } else if(button.yellow()){
//    playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/lambo.png"));
//  } else if(button.blue()){
//    playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/viper.png"));
//  } else if(button.purple()){
//    playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/Purp.png"));
//  } else {
//    playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/redside2.png"));
//  }
  public PImage getCar(){
    return playercar;
  }


  private Manager manager;

  public void carupdate(){
    manager = new Manager();
    switch (manager.carType){

      case 0:
        playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/redside2.png"));
        break;

      case 1:
        playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/lambo.png"));
        break;

      case 2:
        playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/viper.png"));
        break;

      case 3:
        playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/Purp.png"));
        break;

      default:
        playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/redside2.png"));
        break;
    }
  }

  public void load() {
    playercar = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/redside2.png"));
    carupdate();
    heart = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/heart.png"));
    heartLost = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/heartLost.png"));
    roadLine = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/roadline.png"));
    mute = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/mute.png"));
  }

  public void loadFonts(PApplet p) {
    bigFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 150, true);
    smallFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 48, true);
    mediumFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 64, true);
    tinyFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 24, true);
  }

  void loadCarImages(Manager manager, ArrayList<PImage> cars) {
    for (int i = 1; i <= 5; i++) {
      PImage carImage = loadImage("src/main/java/org/bcit/comp2522/dui/content/carImage" + i + ".png");
      cars.add(carImage);
    }
  }
}