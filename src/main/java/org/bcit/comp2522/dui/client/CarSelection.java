package org.bcit.comp2522.dui.client;

import processing.core.PImage;

/**
 * The type Car selection.
 * This class is used to select the Car of the game
 * and the car that the user will be driving.
 * It will display the different Cars that the player can choose from.
 * And check if the player has unlocked the next car.
 *
 * @author Jaskaran Toor
 * @version 2023.1.1
 */
public class CarSelection {
    private Manager manager;
    private Window window;

    /**
     * car images.
     */
    private final PImage car1;
    private final PImage car2;
    private final PImage car3;
    private final PImage car4;

    /**
     * check the score to see if the player has unlocked the next car if they have then call the
     * function that will see if the player chooses the red yellow or blue car and then
     * set the player.carColor to the color they chose
     * then in the player class you can use a switch statement to change the color of the car
     *
     * @param manager Manager
     * @param window Window
     */
    public CarSelection(Manager manager, Window window) {
        this.manager = manager;
        this.window = window;

        // car images
        car1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/redUpright.png");
        car2 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/lamboUpright.png");
        car3 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/viperUpright.png");
        car4 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/PurpUpright.png");
    }

    /**
     * Car select method.
     */
    public void carSelect() {
        window.background(0);

        //red car
        window.fill(255);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("Car Rank", window.width / 2, 90);

        // Red
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("Room", 150, 450);

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
        window.text("Sped", 475, 450);

        window.image(car2, 425, 125, 100, 250);

        //select/locked
        carlocked(1000, 475, 2);



        //blue car
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("Nuts", 775, 450);

        window.image(car3, 725, 125, 100, 250);

        //select/locked
        carlocked(3000, 775, 3);



        //purple car
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("Bolts", 1075, 450);

        window.image(car4, 1025, 125, 100, 250);

        //select/locked
        carlocked(5000, 1075, 4);

    }

    /**
     * carLocked method locks cars until reaches a certain score.
     *
     * @param highScore highScore
     * @param x x
     * @param type type
     */
    public void carlocked(int highScore, int x, int type){
        if (manager.game.highScore >= highScore) {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", x, 525);
            if (type == 1){
                manager.button.red();
            } else if (type == 2){
                manager.button.yellow();
            } else if (type == 3){
                manager.button.blue();
            } else if (type == 4){
                manager.button.purple();
            }
        } else {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Locked", x, 525);
        }
    }
}
