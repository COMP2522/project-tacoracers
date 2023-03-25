package org.bcit.comp2522.dui.client;

import java.util.ArrayList;
import processing.core.*;

public class Enemycar {
    public PVector position;
    float speed;
    public float size;
    Window window;
    private final float[] lanes = {140, 327, 515};

    public Enemycar(int laneIndex, float speed, float size, Window window) {
        this.position = new PVector(window.width, lanes[laneIndex]);
        this.speed = speed;
        this.size = size;
        this.window = window;
    }

    public void update(Player player) {
        this.position.x -= speed;

        if (this.position.x < -size) {
            this.position.x = window.width + size + (float) (Math.random() * window.width * 0.5);
            this.position.y = lanes[(int) (Math.random() * lanes.length)];
        }
    }



    public void display() {
        window.fill(255, 0, 0);
        window.rect(this.position.x, this.position.y, size, size);
    }

    public PVector getPosition() {
        return position.copy();
    }
}
