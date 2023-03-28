package org.bcit.comp2522.dui.client;

import processing.core.*;
import java.math.*;
import java.util.ArrayList;

import static java.lang.Math.random;

/**
 * EnemyCar represents and individual enemy in the world. Each enemy can
 * be in 1 of 3 lanes and has position, speed and size properties kept.
 * In UI, an arraylist of EnemyCars are created and subsequently drawn.
 *
 * @authors Eric Tatchell, Jaskaran Toor
 */
public class EnemyCar extends Sprite {
    public final float[] lanes = {140, 327, 515};
    PImage car;
    private float originalSpeed;
    private ArrayList<PImage> carImages;

    public EnemyCar(PVector position, Window window, float width, float height, float speed, ArrayList<PImage> carImages) {
        super(position, window, width, height, speed);
        this.originalSpeed = speed;
        this.carImages = carImages;
        pickCar();
    }
    public float getOriginalSpeed() {
        return originalSpeed;
    }

    private void pickCar() {
        int random = (int) (Math.random() * carImages.size());
        car = carImages.get(random);
    }


    public void update() {
        this.position.x -= speed;

        if (this.position.x < -this.width) {
            float offset = (float) (Math.random() * window.width * 0.5);
            this.position.x = window.width + this.width + offset;
            int laneIndex = (int) (Math.random() * lanes.length);
            this.position.y = lanes[laneIndex];
        }
    }



    @Override
    public void draw() {
        window.image(car, this.position.x, this.position.y, this.width, this.height);
    }

    public PVector getPosition() {
        return position.copy();
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }
}
