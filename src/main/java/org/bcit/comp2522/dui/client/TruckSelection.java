package org.bcit.comp2522.dui.client;

import processing.core.PImage;

/**
 * The TruckSelection class.
 * This class is used to select the truck that the player wants to use.
 * It will display the different trucks that the player can choose from.
 * It will also check to see if the player has unlocked the next truck.
 * If the player has unlocked the next truck then it will display the next truck.
 *
 * @author Jaskaran Toor
 * @version 2023.1.1
 */
public class TruckSelection {
    private Manager manager;
    private Window window;

    /**
     * Truck images.
     */
    PImage truck1,
            truck2,
            truck3,
            truck4;

    /**
     * check the score to see if the player has unlocked the next car if they have then call the
     * function that will see if the player chooses the red yellow or blue car and then
     * set the player.carColor to the color they chose
     * then in the player class you can use a switch statement to change the color of the car
     *
     * @param manager Manager
     * @param window Window
     */
    public TruckSelection(Manager manager, Window window) {
        this.manager = manager;
        this.window = window;

        //truck images
        truck1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/truck1NoBG.png");
        truck2 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/truck2NoBG.png");
        truck3 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/logtruck-removebg-preview.png");
        truck4 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/oiltruck-removebg-preview.png");

    }

    /**
     * Truck Selection method.
     */
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
        window.text("Mack", 150, 450);

        //image
        window.image(truck1, 100, 125, 150, 250);
        window.fill(255, 0, 0);
//

        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.textSize(30);
        window.text("Select", 150, 525);
        manager.button.redtruck();


        //yellow car
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("Nuty", 475, 450);

        //image
        window.image(truck2, 425, 125, 150, 250);


        //select/locked
        Trucklocked(1000, 475, 2);


        //blue car
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("Logs", 775, 450);

        //image
        window.image(truck3, 725, 125, 150, 250);


        //select/locked
        Trucklocked(3000, 775, 3);


        //purple car
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("Oily", 1075, 450);

        window.image(truck4, 1025, 125, 150, 250);

        //select/locked
        Trucklocked(5000, 1075, 4);

    }

    /**
     * Locks trucks until a certain score is reached.
     *
     * @param highScore highScore
     * @param x x
     * @param type type
     */
    public void Trucklocked(int highScore, int x, int type){
        if (manager.game.highScore >= highScore) {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", x, 525);
            if (type == 1){
                manager.button.redtruck();
            } else if (type == 2){
                manager.button.yellowtruck();
            } else if (type == 3){
                manager.button.bluetruck();
            } else if (type == 4){
                manager.button.purpletruck();
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
