package org.bcit.comp2522.dui.client;

import processing.core.PImage;

/**
 * The type Difficulty.
 * This class is used to select the difficulty of the game
 * and the car that the user will be driving.
 * It will display the different vehicles that the player can choose from.
 *
 * @author Jaskaran Toor
 * @version 2023.1.1
 */
public class Difficulty {

    private Manager manager;
    private Window window;

    /*
    vehicle images
    */
    private final PImage  car1;
    private final PImage truck1;
    private final PImage moto1;


    /**
     * Creates a difficulty object.
     * @param manager
     * @param scene
     */
    public Difficulty(Manager manager, Window scene) {
        this.manager = manager;
        this.window = scene;

        // car images
        car1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/redUpright.png");

        //moto images
        moto1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/redBikeUPP.png");

        //truck images
        truck1 = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/truck1NoBG.png");

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
}
