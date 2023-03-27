package org.bcit.comp2522.dui.client;

import processing.core.*;
import java.math.*;

/**
 * EnemyCar represents and individual enemy in the world. Each enemy can
 * be in 1 of 3 lanes and has position, speed and size properties kept.
 * In UI, an arraylist of EnemyCars are created and subsequently drawn.
 *
 * @authors Eric Tatchell, Jaskaran Toor
 */
public class EnemyCar {
    public PVector position;
    float speed;
    public float size;
    Window window;
    PImage car;
    private final float[] lanes = {140, 327, 515};

    public EnemyCar(int laneIndex, float speed, float size, float initialOffset, Window window) {
        this.position = new PVector(window.width + initialOffset, lanes[laneIndex]);
        this.speed = speed;
        this.size = size;
        this.window = window;
        int random = (int) (Math.random() * 5) + 1;
        switch (random) {
            case 1:
                car = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/carImage1.png");
                break;
            case 2:
                car = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/carImage2.png");
                break;
            case 3:
                car = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/carImage3.png");
                break;
            case 4:
                car = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/carImage4.png");
                break;
            case 5:
                car = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/carImage5.png");
                break;
        }
    }


    public void update(Player player) {
        this.position.x -= speed;

        if (this.position.x < -size) {
            this.position.x = window.width + size + (float) (Math.random() * window.width * 0.5);
            int laneIndex = (int) (Math.random() * lanes.length);
            this.position.y = lanes[laneIndex];
        }
    }



    public void display() {
        window.image(car, this.position.x, this.position.y, (size * 2) - 10, size);
    }

    public PVector getPosition() {
        return position.copy();
    }
}
