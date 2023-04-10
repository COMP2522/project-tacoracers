package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.*;
import processing.core.*;

/**
 * ContentLoader loads fonts and images at the start of the program.
 *
 * @author Eric Tatchell
 */
public class ContentLoader extends PApplet {
  /**
   * The Player image red.
   */
  public PImage playerImageRed;
  /**
   * The Player image yellow.
   */
  public PImage playerImageYellow;
  /**
   * The Player image blue.
   */
  public PImage playerImageBlue;
  /**
   * The Player image purple.
   */
  public PImage playerImagePurple;
  /**
   * The Player imagemoto 1.
   */
  public PImage playerImagemoto1;
  /**
   * The Player imagemoto 2.
   */
  public PImage playerImagemoto2;
  /**
   * The Player imagemoto 3.
   */
  public PImage playerImagemoto3;
  /**
   * The Player imagemoto 4.
   */
  public PImage playerImagemoto4;
  /**
   * The Player imagetruck 1.
   */
  public PImage playerImagetruck1;

  /**
     * The Player imagetruck 2.
     */
  public PImage playerImagetruck2;
  /**
   * The Player imagetruck 3.
   */
  public PImage playerImagetruck3;
  /**
   * The Player imagetruck 4.
   */
  public PImage playerImagetruck4;
  /**
   * The Heart.
   */
  public PImage heart;
  /**
   * The Heart lost.
   */
  public PImage heartLost;
  /**
   * The Playercar.
   */
  public  PImage playercar;

  /**
   * roadline.
   */
  private PImage roadLine;

  /**
   * mute button.
   */
  private PImage mute;

  /**
   * repair tool.
   */
  private PImage powerup;

  /**
   * max size font.
   */
  private PFont bigFont;

  /**
   * smaller font.
   */
  private PFont smallFont;

  /**
   * decent size font.
   */
  private PFont mediumFont;

  /**
   * 'tiny' font.
   */
  private PFont tinyFont;


    /**
     * Load.
     */
// loads image assets at setup
  public void load() {
    //cars
    playerImageYellow = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/lambo.png"));
    playerImageRed = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/redside2.png"));
    playerImagePurple = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/Purp.png"));
    playerImageBlue = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/viper.png"));

    //moto
    playerImagemoto1 = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/redBikeSide.png"));
    playerImagemoto2 = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/yellowBikeSide.png"));
    playerImagemoto3 = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/bike1Side.png"));
    playerImagemoto4 = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/purpleBikeSide.png"));

    //truck
    playerImagetruck1 = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/Truckside1.png"));
    playerImagetruck2 = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/logTruckside2.png"));
    playerImagetruck3 = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/logTruckside3.png"));
    playerImagetruck4 = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/Oiltruckside4.png"));

    heart = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/heart.png"));
    heartLost = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/heartLost.png"));
    roadLine = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/roadline.png"));
    mute = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/mute.png"));
    powerup = loadImage(sketchPath("src/main/java/org/bcit/comp2522/dui/content/repair.png"));

  }

    /**
     * Loads fonts at startup.
     *
     * @param p window
     */
    public void loadFonts(PApplet p) {
    bigFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 150, true);
    smallFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 48, true);
    mediumFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 64, true);
    tinyFont = p.createFont(sketchPath("src/main/java/org/bcit/comp2522/dui/content/PublicPixel-z84yD.ttf"), 24, true);
  }

    /**
     * Loads EnemyCar images.
     *
     * @param cars linked list
     */
    public void loadCarImages(CarLinkedList<PImage> cars) {
    for (int i = 1; i <= 5; i++) {
      PImage carImage = loadImage("src/main/java/org/bcit/comp2522/dui/content/carImage" + i + ".png");
      cars.add(carImage);
    }
  }

    /**
     * Returns the player's PImage.
     *
     * @return A PImage object representing the player's image red.
     */
    public PImage getPlayerImageRed() {
    return playerImageRed;
  }

    /**
     * Sets the player's image red.
     *
     * @param playerImageRed A PImage object representing the player's image red.
     */
    public void setPlayerImageRed(PImage playerImageRed) {
    this.playerImageRed = playerImageRed;
  }

    /**
     * Returns the player's PImage.
     *
     * @return A PImage object representing the player's image yellow.
     */
    public PImage getPlayerImageYellow() {
    return playerImageYellow;
  }

    /**
     * Sets the player's image yellow.
     *
     * @param playerImageYellow A PImage object representing the player's image yellow.
     */
    public void setPlayerImageYellow(PImage playerImageYellow) {
    this.playerImageYellow = playerImageYellow;
  }

    /**
     * Returns the player's PImage.
     *
     * @return A PImage object representing the player's image blue.
     */
    public PImage getPlayerImageBlue() {
    return playerImageBlue;
  }

    /**
     * Sets the player's image blue.
     *
     * @param playerImageBlue A PImage object representing the player's image blue.
     */
    public void setPlayerImageBlue(PImage playerImageBlue) {
    this.playerImageBlue = playerImageBlue;
  }

    /**
     * Returns the player's PImage.
     *
     * @return A PImage object representing the player's image purple.
     */
    public PImage getPlayerImagePurple() {
    return playerImagePurple;
  }

    /**
     * Sets the player's image purple.
     *
     * @param playerImagePurple A PImage object representing the player's image purple.
     */
    public void setPlayerImagePurple(PImage playerImagePurple) {
    this.playerImagePurple = playerImagePurple;
  }

    /**
     * Returns the player's PImage.
     *
     * @return A PImage object representing the player's image Moto(red)
     */
    public PImage getPlayerImagemoto1() {
    return playerImagemoto1;
  }

    /**
     * Sets the player's image Moto(red).
     *
     * @param playerImagemoto1 A PImage object representing the player's image Moto(red).
     */
    public void setPlayerImagemoto1(PImage playerImagemoto1) {
    this.playerImagemoto1 = playerImagemoto1;
  }

    /**
     * Returns the player's PImage.
     *
     * @return A PImage object representing the player's image Moto(yellow)
     */
    public PImage getPlayerImagemoto2() {
    return playerImagemoto2;
  }

    /**
     * Sets the player's image Moto(yellow).
     *
     * @param playerImagemoto2 A PImage object representing the player's image Moto(yellow).
     */
    public void setPlayerImagemoto2(PImage playerImagemoto2) {
    this.playerImagemoto2 = playerImagemoto2;
  }

    /**
     * Returns the player's PImage.
     *
     * @return A PImage object representing the player's image Moto(blue)
     */
    public PImage getPlayerImagemoto3() {
    return playerImagemoto3;
  }

    /**
     * Sets the player's image Moto(blue).
     *
     * @param playerImagemoto3 A PImage object representing the player's image Moto(blue).
     */
    public void setPlayerImagemoto3(PImage playerImagemoto3) {
    this.playerImagemoto3 = playerImagemoto3;
  }

    /**
     * Returns the player's PImage.
     *
     * @return A PImage object representing the player's image Moto(purple)
     */
    public PImage getPlayerImagemoto4() {
    return playerImagemoto4;
  }

    /**
     * Sets the player's image Moto(purple).
     *
     * @param playerImagemoto4 A PImage object representing the player's image Moto(purple).
     */
    public void setPlayerImagemoto4(PImage playerImagemoto4) {
    this.playerImagemoto4 = playerImagemoto4;
  }

    /**
     * Returns the player's PImage.
     *
     * @return A PImage object representing the player's image truck1(red)
     */
    public PImage getPlayerImagetruck1() {
    return playerImagetruck1;
  }

    /**
     * Sets the player's image truck1(red).
     *
     * @param playerImagetruck1 A PImage object representing the player's image truck1(red).
     */
    public void setPlayerImagetruck1(PImage playerImagetruck1) {
    this.playerImagetruck1 = playerImagetruck1;
  }

  /**
   * Returns the player's PImage.
   *
   * @return A PImage object representing the player's image truck2(yellow)
   */
  public PImage getPlayerImagetruck2() {
    return playerImagetruck2;
  }

    /**
     * Sets the player's image truck2(yellow).
     *
     * @param playerImagetruck2 A PImage object representing the player's image truck2(yellow).
     */
  public void setPlayerImagetruck2(PImage playerImagetruck2) {
    this.playerImagetruck2 = playerImagetruck2;
  }

    /**
     * Returns the player's PImage.
     *
     * @return A PImage object representing the player's image truck3(blue)
     */
  public PImage getPlayerImagetruck3() {
    return playerImagetruck3;
  }

    /**
     * Sets the player's image truck3(blue).
     *
     * @param playerImagetruck3 A PImage object representing the player's image truck3(blue).
     */
  public void setPlayerImagetruck3(PImage playerImagetruck3) {
    this.playerImagetruck3 = playerImagetruck3;
  }

    /**
     * Returns the player's PImage.
     *
     * @return A PImage object representing the player's image truck4(purple)
     */
  public PImage getPlayerImagetruck4() {
    return playerImagetruck4;
  }

    /**
     * Sets the player's image truck4(purple).
     *
     * @param playerImagetruck4 A PImage object representing the player's image truck4(purple).
     */
  public void setPlayerImagetruck4(PImage playerImagetruck4) {
    this.playerImagetruck4 = playerImagetruck4;
  }
    /**
     * Returns the heart PImage.
     *
     * @return A PImage object representing the heart.
     */
    public PImage getHeart() {
    return heart;
  }

    /**
     * Sets the heart PImage.
     *
     * @param heart A PImage object representing the heart.
     */
    public void setHeart(PImage heart) {
    this.heart = heart;
  }

    /**
     * Returns the heart lost PImage.
     *
     * @return A PImage object representing the heart lost.
     */
    public PImage getHeartLost() {
    return heartLost;
  }

    /**
     * Sets the heart lost PImage.
     *
     * @param heartLost A PImage object representing the heart lost.
     */
    public void setHeartLost(PImage heartLost) {
    this.heartLost = heartLost;
  }

    /**
     * Returns the road line PImage.
     *
     * @return A PImage object representing the road line.
     */
    public PImage getRoadLine() {
    return roadLine;
  }

    /**
     * Sets the road line PImage.
     *
     * @param roadLine A PImage object representing the road line.
     */
    public void setRoadLine(PImage roadLine) {
    this.roadLine = roadLine;
  }

    /**
     * Returns the mute PImage.
     *
     * @return A PImage object representing the mute.
     */
    public PImage getMute() {
    return mute;
  }

    /**
     * Sets the mute PImage.
     *
     * @param mute A PImage object representing the mute.
     */
    public void setMute(PImage mute) {
    this.mute = mute;
  }

    /**
     * Returns the power-up PImage.
     *
     * @return A PImage object representing the power-up.
     */
    public PImage getPowerup() {
    return powerup;
  }

    /**
     * Sets the power-up PImage.
     *
     * @param powerup A PImage object representing the power-up.
     */
    public void setPowerup(PImage powerup) {
    this.powerup = powerup;
  }

    /**
     * Returns the big font.
     *
     * @return A PFont object representing the big font.
     */
    public PFont getBigFont() {
    return bigFont;
  }

    /**
     * Sets the big font.
     *
     * @param bigFont A PFont object representing the big font.
     */
    public void setBigFont(PFont bigFont) {
    this.bigFont = bigFont;
  }

    /**
     * Returns the small font.
     *
     * @return A PFont object representing the small font.
     */
    public PFont getSmallFont() {
    return smallFont;
  }

    /**
     * Sets the small font.
     *
     * @param smallFont A PFont object representing the small font.
     */
    public void setSmallFont(PFont smallFont) {
    this.smallFont = smallFont;
  }

    /**
     * Returns the medium font.
     *
     * @return A PFont object representing the medium font.
     */
    public PFont getMediumFont() {
    return mediumFont;
  }

    /**
     * Sets the medium font.
     *
     * @param mediumFont A PFont object representing the medium font.
     */
    public void setMediumFont(PFont mediumFont) {
    this.mediumFont = mediumFont;
  }

    /**
     * Returns the tiny font.
     *
     * @return A PFont object representing the tiny font.
     */
    public PFont getTinyFont() {
    return tinyFont;
  }

    /**
     * Sets the tiny font.
     *
     * @param tinyFont A PFont object representing the tiny font.
     */
    public void setTinyFont(PFont tinyFont) {
    this.tinyFont = tinyFont;
  }
}