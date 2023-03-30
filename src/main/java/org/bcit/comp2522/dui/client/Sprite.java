package org.bcit.comp2522.dui.client;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

/**
 * Sprite class represents objects in the world.
 * (player nad enemy car)
 *
 * @author Eric Tatchell
 */
public class Sprite extends PApplet {
    protected float size;
    protected float laneSpeed;
    protected float width;
    protected float height;
    protected float speed;
    protected float initialOffset;
    protected PVector position;
    protected Window window;
    static Player player;
    PImage playerImage;
    static String path;

    /**
     * Sprite constructor intended for Players.
     * @param position PVector
     * @param window Window
     */
    public Sprite(PVector position, Window window, float width, float height) {
        this.position = position;
        this.window = window;
        this.width = width;
        this.height = height;
        playerImage = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/playerImage.png");
    }

//    public static void chooseCarColor(String color) {
//        switch (color) {
//            case "red":
//                player.setCarColor(color);
//                path = "src/main/java/org/bcit/comp2522/dui/content/viper.png";
//                break;
//            case "blue":
//                player.setCarColor(color);
//                path = "src/main/java/org/bcit/comp2522/dui/content/blue.png";
//                break;
//            case "yellow":
//                player.setCarColor(color);
//                path = "src/main/java/org/bcit/comp2522/dui/content/lambo.png";
//                break;
//            case "purple":
//                player.setCarColor(color);
//                path = "src/main/java/org/bcit/comp2522/dui/content/Purp.png";
//                break;
//            default:
//                System.out.println("Invalid color choice.");
//        }
//    }

    /**
     * Sprite constructor intended for EnemyCars.
     * @param position PVector
     * @param window Window
     * @param width Car width
     * @param height Car height
     */
    public Sprite(PVector position, Window window, float width, float height, float speed) {
        this.position = position;
        this.window = window;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }


    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * Add difficulties with different vehicles
     * eg drawEasy drawMedium drawHard etc
     * @return
     */
    public PVector getPosition() {
        return position.copy();
    }


    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }



    @Override
    public void draw() {

    }
}
