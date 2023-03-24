package org.bcit.comp2522.dui.client;

import java.util.ArrayList;
import processing.core.*;

// EnemyCar class
public class Enemycar extends PApplet {
     float x, y; // position
    float speed; // speed
    float size; // size



    public Enemycar(float x, float y, float speed, float size) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size;
    }

    void update() {
        y += speed;
        if (y > height + size) {
            // if enemy car goes off screen, reset position and speed
            y = -size;
            x = random(width);
            speed = random(2, 5);
        }
    }

    void display() {
        fill(255, 0, 0);
        rect(x, y, size, size);
    }


    // main program
    ArrayList<Enemycar> enemyCars;

    public void setup() {
        size(400, 600);
        enemyCars = new ArrayList<Enemycar>();
        for (int i = 0; i < 10; i++) {
            float x = random(width);
            float y = random(-height, 0);
            float speed = random(2, 5);
            float size = random(20, 40);
            Enemycar enemyCar = new Enemycar(x, y, speed, size);
            enemyCars.add(enemyCar);
        }
    }

    public void draw() {
        // update and display enemy cars
         for (Enemycar enemyCar : enemyCars) {
            enemyCar.update();
            enemyCar.display();
            // check for collision with player's car
            float distance = dist(enemyCar.x, enemyCar.y, mouseX, height - 50);
            if (distance < enemyCar.size / 2 + 25) {
                // if there is a collision, end game or deduct points
                textSize(32);
                text("Game Over", width / 2, height / 2);
                noLoop();
            }
        }
        // display player's car
        fill(0, 255, 0);
        ellipse(mouseX, height - 50, 50, 50);
    }
}
