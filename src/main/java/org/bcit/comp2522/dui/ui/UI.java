package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.*;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

public class UI implements Drawable {
    public final float[] lanes = {140, 327, 515};
    public ArrayList<PImage> cars;
    public ArrayList<EnemyCar> traffic;
    public Player player;
    public float playerWidth = 140;
    public float playerHeight = 75;
    private float slowedEnemyCarSpeed = 1.6F;
    public Menu menu;
    public Button button;
    public Manager manager;
    public Elements elements;
    private Window window;

    public UI(Manager manager, ContentLoader loader, Window scene) {
        this.manager = manager;
        this.elements = new Elements(scene, manager, loader); // Keep this one
        this.player = new Player(manager, scene, new PVector(scene.width / 5, 327), playerWidth, playerHeight);
        this.traffic = new ArrayList<EnemyCar>();
        this.cars = new ArrayList<>();
        this.button = new Button(scene, manager);
        this.menu = new Menu(manager, scene);
        this.window = scene;
        loader.loadCarImages(manager, cars);
        spawnCars(traffic);
    }
    public void uiElements() {
        window.background(0);
        manager.game.start();
        elements.borders();
        elements.displayScore();
        elements.displayHighScore();
        elements.muteButton();
        player.displayHealth();
        manager.path.drawLines();
        player.draw();
    }
    private void spawnCars(ArrayList<EnemyCar> traffic) {
        int numCars = 2;
        int numLanes = lanes.length;
        float carSpacing = window.width / numCars;

        for (int i = 0; i < numCars; i++) {
            for (int j = 0; j < numLanes; j++) {
                float carWidth = 140;
                float carHeight = 75;
                float carSpeed = (float) (Math.random() * 8 + 7);
                float xPos = i * carSpacing + carWidth / 2 + (carSpacing / 2 * j);
                EnemyCar car = new EnemyCar(manager, window, new PVector(xPos, lanes[j]), carWidth, carHeight, carSpeed, cars);
                traffic.add(car);
            }
        }
    }
    @Override
    public void draw() {
        switch (manager.screenState) {
            case 0:
                uiElements();
                for (EnemyCar enemyCar : traffic) {
                    enemyCar.update();
                    enemyCar.draw();
                    player.check(enemyCar);
                    player.update(this);
                }
                break;
            case 1:
                menu.gameOver();
                break;
            case 2:
                menu.main();
                break;
            case 3:
                this.menu2();
                break;
            case 4:
                this.carSelection();
                break;
            case 5:
                menu.gameOver();
                break;
            case 6:
                menu.gameOver();
                break;
        }
    }

    public void menu2() {
        window.background(0);


        window.fill(255);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.mediumFont);
        window.text("DUI", window.width / 2, 90);

        //Should take you to a page to select a car style
        //semi = hard
        //car = medium
        //moto = easy
        window.fill(0, 0, 255);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.smallFont);
        window.text("Difficulty", window.width / 2 + 10, 100 + 100);
        button.diff();

        // Should take you to a page to select show you what car color your at
        // like skins but for cars that you unlock at certain scores
        window.fill(0, 0, 255);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.smallFont);
        window.text("Cars", window.width / 2 + 10, 100 + 200);
        button.cars();

        // Should take you to a page to show you the top 3-5 scores
        window.fill(0, 0, 255);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.smallFont);
        window.text("LeaderBoard", window.width / 2 + 10, 100 + 300);
        button.leaderboard();

        // Should take you to a page that asks if you really want to quit
        window.fill(0, 0, 255);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.smallFont);
        window.text("Quit", 900, 100 + 450);
        button.quit();
    }

       /*
        check the score to see if the player has unlocked the next car if they have then call the
        function that will see if the player chooses the red yellow or blue car and then
         set the player.carColor to the color they chose
         then in the player class you can use a switch statement to change the color of the car
         */

    public void carSelection(){
        window.background(0);

        //red car
        window.fill(255);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.mediumFont);
        window.text("Car Rank", window.width / 2, 90);

        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.smallFont);
        window.text("Red", 150, 450);

        //image
        window.fill(255, 0, 0);
        window.rect(100, 125, 100, 250);
//        car = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/playerImage.png");
        //player.redCar();

        //select/locked
        if (manager.game.highScore >= 0) {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Select", 150, 525);
            button.red();
        } else {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Locked", 150, 525);
        }


        //yellow car
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.smallFont);
        window.text("yello", 475, 450);

        //image
        window.fill(255, 0, 0);
        window.rect(425, 125, 100, 250);

        //select/locked
        if (manager.game.highScore >= 1000) {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Select", 475, 525);
            button.yellow();
            //player.yellowCar();
        } else {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Locked", 475, 525);
        }

        //blue car
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.smallFont);
        window.text("Blue", 775, 450);

        //image
        window.fill(255, 0, 0);
        window.rect(725, 125, 100, 250);

        //select/locked
        if (manager.game.highScore >= 5000) {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Select", 775, 525);
            button.blue();
            //player.BlueCar();
        } else {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Locked", 775, 525);
        }

        //purple car
        window.fill(255, 0, 0);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.smallFont);
        window.text("Purple", 1075, 450);

        window.fill(255, 0, 0);
        window.rect(1025, 125, 100, 250);

        //select/locked
        if (manager.game.highScore >= 10000) {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Select", 1075, 525);
            button.purple();
            //player.BlueCar();
        } else {
            window.fill(255, 0, 0);
            window.textAlign(window.CENTER);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Locked", 1075, 525);
            //player.GreenCar();
        }
    }


    public void borders() {
        window.background(0);
        window.rect(0, 600, 1280, 500); // top of the border
        window.fill(255);
        window.rect(0, 100, 1280, -500); // bottom of the border
        window.fill(255);
    }
    public void init() {
        this.draw();
    }
}
