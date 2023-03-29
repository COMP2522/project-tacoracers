package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.*;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

public class UI extends Manager implements Drawable {
    public final float[] lanes = {140, 327, 515};
    public ArrayList<PImage> cars;
    public Window window;
    public ArrayList<EnemyCar> traffic;
    public Player player;
    public float playerWidth = 140;
    public float playerHeight = 75;
    private float slowedEnemyCarSpeed = 1.6F;
    public Path path;
    public Game game;
    public Button button;

    public UI(Window scene) {
        super();
        this.window = scene;
        path = new Path(scene);
        player = new Player(new PVector(window.width / 5, 327), this.window, playerWidth, playerHeight);
        traffic = new ArrayList<EnemyCar>();
        game = Game.getInstance();
        cars = new ArrayList<>();
        button = new Button(this.window, this);
        loadCarImages();
        spawnCars(traffic);
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
                EnemyCar car = new EnemyCar(new PVector(xPos, lanes[j]), this.window, carWidth, carHeight, carSpeed, cars);
                traffic.add(car);
            }
        }
    }
    public void update(UI ui) {
        player.keyInput.update();
    }

    private void loadCarImages() {
        for (int i = 1; i <= 5; i++) {
            PImage carImage = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/carImage" + i + ".png");
            cars.add(carImage);
        }
    }



    @Override
    public void draw() {
        if (window.playing == false) {
            if (player.playerDeath) {
                this.gameOver();
            } else {
                this.menu();
            }
        } else {
            borders();
            game.start();
            path.drawLines();
            player.draw();
            player.displayHealth();
            game.displayScore(window);
            game.displayHighScore(window);

            for (EnemyCar enemyCar : traffic) {
                enemyCar.update();
                enemyCar.draw();
                player.check(enemyCar, this);
            }
            player.keyInput.update();
        }
    }

    public void gameOver() {
        window.playing = false;
        game.score = 0; /** !!! Change with whatever score system/method we end up using **/
        window.background(0);
        window.fill(255, 0, 0);
        window.textFont(window.mediumFont);
        window.textAlign(CENTER);
        window.text("TOTALED", (window.width / 2), 200);
        window.rect((window.width / 2) - 280, 400, 560, 75);
        window.textAlign(CENTER);
        window.fill(0);
        window.textFont(window.smallFont);
        window.text("PLAY AGAIN", (window.width / 2), 455);
        button.restart();
    }

    public void menu() {
        window.background(0);
        window.fill(255);
        window.textAlign(CENTER);
        window.textFont(window.bigFont);
        window.text("DUI", window.width / 2, 200);
        window.fill(0, 0, 255);
        window.textAlign(CENTER);
        window.textFont(window.bigFont);
        window.text("DUI", window.width / 2 + 10, 200 + 10);
        window.fill(255);
        window.textFont(window.smallFont);
        window.text("Driving\nUnintelligently", window.width / 2, 300);
        window.rect( (window.width / 2) - 150, 450, 300, 125);
        window.textAlign(CENTER);
        window.fill(0);
        window.textFont(window.mediumFont);
        window.text("PLAY", window.width / 2, 535);
        button.play();
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
