package org.bcit.comp2522.dui.client;

import processing.core.PImage;

/**
 * The type Bike selection.
 * This class is used to select the bike of the game
 * and the bike that the user will be driving.
 * It will display the different Bikes that the player can choose from.
 * Also check to see if the player has unlocked the next bike.
 *
 * @author Jaskaran Toor
 * @version 2023.1.1
 */
public class BikeSelection {
    private final Manager manager;
    private final Window window;

    /**
     * moto images.
     */
    private final PImage  moto1;
    private final PImage moto2;
    private final PImage moto3;
    private final PImage moto4;

    /**
     * check the score to see if the player has unlocked the next car if they have then call the
     * function that will see if the player chooses the red yellow or blue car and then
     * set the player.carColor to the color they chose
     * then in the player class you can use a switch statement to change the color of the car
     *
     * @param manager Manager
     * @param window Window
     */
    public BikeSelection(Manager manager, Window window) {
        this.manager = manager;
        this.window = window;

        //moto images
        moto1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/redBikeUPP.png");
        moto2 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/yellowBikeUPP.png");
        moto3 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/bike1Upright.png");
        moto4 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/purpleBikeUp.png");

    }

    /**
     * bikeSelection method.
     */
    public void bikeSelection() {
        window.background(0);


        window.fill(255);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getMediumFont());
        window.text("Car Rank", window.width / 2, 90);

        // Red
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("Red", 150, 450);

        //image
        window.image(moto1, 100, 125, 150, 250);
        window.fill(255, 0, 0);


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
        window.text("Speed", 475, 450);

        //image
        window.image(moto2, 425, 125, 150, 250);

        //select/locked
        bikeLocked(1000, 475, 2);


        //blue car
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("5Down", 775, 450);

        //image
        window.image(moto3, 725, 125, 150, 250);

        //select/locked
        bikeLocked(3000, 775, 3);



        //purple car
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("Gears", 1075, 450);

        window.image(moto4, 1025, 125, 150, 250);

        bikeLocked(5000, 1075, 4);
    }

    /**
     * Bikelocked method locks bikes unless a certain score is reached.
     *
     * @param highScore highScore
     * @param x x
     * @param type type
     */
    public void bikeLocked(int highScore, int x, int type) {
        if (manager.game.highScore >= highScore) {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", x, 525);
            if (type == 1) {
                manager.button.redbike();
            } else if (type == 2) {
                manager.button.yellowbike();
            } else if (type == 3) {
                manager.button.bluebike();
            } else if (type == 4) {
                manager.button.purplebike();
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
