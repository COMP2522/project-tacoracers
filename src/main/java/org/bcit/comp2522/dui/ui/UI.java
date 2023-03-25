package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.*;
import processing.core.PFont;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.Iterator;

public class UI extends Manager implements Drawable {
    public Window window;
    private Manager manager;
//    private ArrayList<Obstacle> traffic;
    private ArrayList<Enemycar> traffic;
    public Player player;
    public Path path;

    public UI(Window scene) {
        super();
        this.window = scene;
        path = new Path(scene);
        player = new Player(new PVector(window.width / 5, 400), this.window);
        traffic = new ArrayList<Enemycar>();

        // Spawn initial enemy cars
        for (int i = 0; i < 3; i++) {
            float speed = random(1, 3);
            float size = 50;
            Enemycar enemyCar = new Enemycar(i, speed, size, this.window);
            traffic.add(enemyCar);
        }
    }

    /** FOR ERIC TONIGHT
     * find the issue with disappearance
     * collision
     *
     */


    int targetPosition = 327;
    int currentPosition = 125;
    int animationFrames = 10; // number of frames to complete the animation
    @Override
    public void draw() {
        if (window.playing == false) {
            this.menu();
        } else {
            window.background(0);
            window.rect(0, 600, 1080, 500); // top of the border
            window.fill(255);
            window.rect(0, 100, 1080, -500); // bottom of the border
            window.fill(255);
            game.start(); // Start the Timer
            displayScore();
            displayHighScore();
            if (currentPosition != targetPosition) {
                float delta = (targetPosition - currentPosition) / (float) animationFrames;
                currentPosition += delta;
            }
            player.drawPlayer(player.getPosition().x, currentPosition);

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
            for (Enemycar enemyCar : traffic) {
                enemyCar.update(player);
                enemyCar.display();
            }
        }
    }
    private void spawnEnemyCars() {
        float[] lanesArray = new float[]{140, 327, 515};
        float minDistance = window.width * 0.5f; // Minimum distance between cars

        for (int i = 0; i < lanesArray.length; i++) {
            boolean shouldSpawnCar = true;
            for (Enemycar enemyCar : traffic) {
                if (enemyCar.position.y == lanesArray[i]) {
                    float distance = Math.abs(enemyCar.position.x - window.width);
                    if (distance < minDistance) {
                        shouldSpawnCar = false;
                        break;
                    }
                }
            }

            if (shouldSpawnCar) {
                float speed = random(1, 3);
                float size = 50;
                Enemycar enemyCar = new Enemycar(i, speed, size, this.window);
                traffic.add(enemyCar);
            }
        }
    }




    public void menu() {
        window.background(0);
        window.fill(255);
//        window.textFont(window.font);
        window.textSize(150);
        window.textAlign(CENTER);
        window.text("DUI", 540, 200);
        window.textSize(50);
        window.text("Driving Unintelligently", 540, 300);
        window.rect(465, 400, 150, 75);
        window.textAlign(CENTER);
        window.fill(0);
        window.textSize(50);
        window.text("PLAY", 540, 455);
        if (window.mouseX > 465 && window.mouseX < 615
                && window.mouseY > 400 && window.mouseY < 475) {
            if (window.mousePressed) { // when play button is pressed
                window.playing = true;
                this.draw();
            }
        }
    }


    Game game = Game.getInstance();
    public void displayScore() {
        window.textSize(20);
        window.textAlign(LEFT);
        window.fill(0, 0, 255);
        window.text("Score: " + game.score, 900, 70); // display the score at position (, )
    }
    public void displayHighScore() {
        window.textSize(20);
        window.textAlign(LEFT);
        window.fill(0, 0, 255);
        window.text("High Score: " + game.highScore, 900, 50); // display the high score at position (, )
    }

    public void init() {

        this.draw();
    }

}
