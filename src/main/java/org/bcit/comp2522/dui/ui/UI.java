package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.*;
import processing.core.PVector;

import java.util.ArrayList;

public class UI extends Manager implements Drawable {
    public Window window;
    private Manager manager;
//    private ArrayList<Obstacle> traffic;
    private ArrayList<EnemyCar> traffic;
    public Player player;
    public float playerWidth = 100;
    public float playerHeight = 50;
    public Path path;
    public Game game;


    public UI(Window scene) {
        super();
        this.window = scene;
        path = new Path(scene);
        player = new Player(new PVector(window.width / 5, 400), this.window, playerWidth, playerHeight);
        player.lives = 3;
        traffic = new ArrayList<EnemyCar>();
        game = Game.getInstance();
        // Spawn initial enemy cars
        int carsPerLane = 2; // Adjust this value to control the number of cars per lane
        float carSpeed = 2.0f; // Set a constant speed for all cars

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < carsPerLane; j++) {
                float size = 50;
                float initialOffset = j * (window.width / carsPerLane);
                EnemyCar enemyCar = new EnemyCar(i, random(carSpeed, 2.8F), size, initialOffset, this.window);
                traffic.add(enemyCar);
            }
        }
    }

    int targetPosition = 327;
    int currentPosition = 125;
    int animationFrames = 25; // number of frames to complete the animation
    @Override
    public void draw() {
        if (window.playing == false) {
            if (player.playerDeath) {
                this.gameOver();
            } else {
                this.menu();
            }
        } else {
            window.background(0);
            window.rect(0, 600, 1280, 500); // top of the border
            window.fill(255);
            window.rect(0, 100, 1280, -500); // bottom of the border
            window.fill(255);
            game.start(); // Start the Timer
            displayScore();
            displayHighScore();
            if (currentPosition != targetPosition) {
                float delta = (targetPosition - currentPosition) / (float) animationFrames;
                currentPosition += delta;
            }
            player.setPosition(player.getPosition().x, currentPosition);
            player.drawPlayer(player.getPosition().x, currentPosition);
            displayHealth();
            if (window.keyPressed && !keyPressed) {
                keyPressed = true;
                switch(window.keyCode) {
                    case UP:
                        if (targetPosition - 187.5 > 140 ) {
                            targetPosition -= 187.5;
                            System.out.println(targetPosition);
                        } else {
                            targetPosition = 140;
                            System.out.println(targetPosition);
                        } break;
                    case DOWN:
                        if (targetPosition + 187.5 < 500) {
                            targetPosition += 187.5;
                            System.out.println(targetPosition);
                        } else {
                            targetPosition = 515;
                            System.out.println(targetPosition);
                        } break;
                }
            } else if (!window.keyPressed) {
                keyPressed = false;
            }
            path.drawLines();
            for (EnemyCar enemyCar : traffic) {
                enemyCar.update(player);
                enemyCar.display();
                player.check(enemyCar, this);
            }
        }
    }

    public void displayHealth() {
        window.textSize(50);
        window.textAlign(LEFT);
        window.fill(255, 0, 0);
        window.text("Car Health: " + player.lives, 30, 59); // display the high score at position (, )

    }

    public void gameOver() {
        window.playing = false;
        game.score = 0; /** !!! Change with whatever score system/method we end up using **/
        window.background(0);
        window.fill(255, 0, 0);
        window.textSize(150);
        window.textAlign(CENTER);
        window.text("GAME OVER", (window.width / 2), 200);
        window.rect((window.width / 2) - 150, 400, 300, 75);
        window.textAlign(CENTER);
        window.fill(0);
        window.textSize(50);
        window.text("PLAY AGAIN", (window.width / 2), 455);
        if (window.mouseX > ((window.width / 2) - 150) && window.mouseX < (window.width / 2) + 150
                && window.mouseY > 400 && window.mouseY < 475) {
            if (window.mousePressed) { // when play button is pressed
                window.playing = true;
                window.init();
            }
        }
    }

    public void menu() {
        window.background(0);
        window.fill(255);
        window.textSize(150);
        window.textAlign(CENTER);
        window.text("DUI", window.width / 2, 200);
        window.textSize(50);
        window.text("Driving Unintelligently", window.width / 2, 300);
        window.rect( (window.width / 2) - 75, 400, 150, 75);
        window.textAlign(CENTER);
        window.fill(0);
        window.textSize(50);
        window.text("PLAY", window.width / 2, 455);
        if (window.mouseX > ((window.width / 2) - 75) && window.mouseX < ((window.width / 2) - 75) + 150
                && window.mouseY > 400 && window.mouseY < 475) {
            if (window.mousePressed) { // when play button is pressed
                window.playing = true;
                this.draw();
            }
        }
    }


    public void displayScore() {
        window.textSize(20);
        window.textAlign(LEFT);
        window.fill(0, 0, 255);
        window.text("Score: " + game.score, 1100, 70); // display the score at position (, )
    }
    public void displayHighScore() {
        window.textSize(20);
        window.textAlign(LEFT);
        window.fill(0, 0, 255);
        window.text("High Score: " + game.highScore, 1100, 50); // display the high score at position (, )
    }

    public void init() {

        this.draw();
    }

}
