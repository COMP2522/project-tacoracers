package org.bcit.comp2522.dui.client;

import processing.core.*;

public class EnemyCar {
    public PVector position;
    float speed;
    public float size;
    Window window;
    private final float[] lanes = {140, 327, 515};

    public EnemyCar(int laneIndex, float speed, float size, float initialOffset, Window window) {
        this.position = new PVector(window.width + initialOffset, lanes[laneIndex]);
        this.speed = speed;
        this.size = size;
        this.window = window;
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
        window.fill(255, 0, 0);
        window.rect(this.position.x, this.position.y, size * 2, size);
    }

    public PVector getPosition() {
        return position.copy();
    }
}
