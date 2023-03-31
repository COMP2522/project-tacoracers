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
public class EnemyCar extends Sprite implements Drawable {
    public final float[] lanes = {140, 170, 297, 327, 357, 485, 515};
    PImage car;
    private float originalSpeed;
    private ArrayList<PImage> carImages;

    public EnemyCar(Manager manager, Window window, PVector position, float width, float height, float speed, ArrayList<PImage> carImages) {
        super(manager, window, position, width, height, speed);
        this.originalSpeed = speed;
        this.carImages = carImages;
        this.car = pickCar();
    }
    public boolean checkCarOverlap(EnemyCar otherCar, float minDistance) {
        float distanceX = Math.abs(otherCar.position.x - this.position.x);
        float distanceY = Math.abs(otherCar.position.y - this.position.y);

        return distanceX < minDistance && distanceY < getHeight();
    }



    public float getOriginalSpeed() {
        return originalSpeed;
    }

    private PImage pickCar() {
        int random = (int) (Math.random() * carImages.size());
        car = carImages.get(random);
        return car;
    }


    public void update(ArrayList<EnemyCar> enemyCars) {
        float minDistance = 200;

        for (EnemyCar otherCar : enemyCars) {
            if (otherCar == this) {
                continue;
            }

            if (checkCarOverlap(otherCar, minDistance)) {
                this.setSpeed(otherCar.getSpeed());
            }
        }

        position.x -= getSpeed();
        if (position.x < -getWidth()) {
            float offset = (float) (Math.random() * window.width * 0.5);
            position.x = window.width + getWidth() + offset;
            int laneIndex = (int) (Math.random() * lanes.length);
            position.y = lanes[laneIndex];
        }
    }





    @Override
    public void draw() {
        window.image(car, position.x, position.y, width, height);
    }
}


