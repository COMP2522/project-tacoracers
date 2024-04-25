package org.bcit.comp2522.dui.client;

import processing.core.*;

/**
 * EnemyCar represents and individual enemy in the world. Each enemy can
 * be in 1 of 3 lanes and has position, speed and size properties kept.
 * In UI.java, an arraylist of EnemyCars are created and subsequently drawn.
 *
 * @authors Eric Tatchell, Jaskaran Toor
 */
public class EnemyCar extends Sprite implements Drawable {

    // Main lanes are 140, 327 and 515. All other numbers are to account for AFK exploiting
    public final float[] lanes = {140, 175, 230, 297, 327, 357, 385, 435, 485, 515};

    // Image for the enemyCar
    private PImage car;

    // enemyCar's original speed value
    private final float originalSpeed;

    // Collection of different car sprites
    private final CarLinkedList<PImage> carImages;

    /**
     * Constructor setting car properties, initializing PImage array and picking a car image.
     *
     * @param manager   manager
     * @param window    window
     * @param position  PVector
     * @param width     float
     * @param height    float
     * @param speed     float
     * @param carImages arraylist
     */
    public EnemyCar(Manager manager, Window window, PVector position, float width, float height, float speed, CarLinkedList<PImage> carImages) {
        super(manager, window, position, width, height, speed);
        this.originalSpeed = speed;
        this.carImages = carImages;
        this.car = pickCar();
    }

    /**
     * Boolean function checking for car overlap
     *
     * @param otherCar    EnemyCar
     * @param minDistance float, can be random
     * @return overlap true/false
     */
    public boolean shouldStop(EnemyCar otherCar, float minDistance) {
        float distanceX = Math.abs(otherCar.position.x - this.position.x);
        float distanceY = Math.abs(otherCar.position.y - this.position.y);

        return distanceX < minDistance && distanceY < getHeight();
    }

    /**
     * Checks if the current EnemyCar instance collides with any other EnemyCar in the given linked list.
     * If a collision is detected, the method adjusts the position of the current EnemyCar and
     * returns true. Otherwise, it returns false.
     *
     * @param enemyCars a CarLinkedList of EnemyCar objects to check for collisions
     * @return true if a collision is detected, false otherwise
     */
    public boolean collide(CarLinkedList<EnemyCar> enemyCars) {
        boolean collided = false;

        for (int i = 0; i < enemyCars.size(); i++) {
            EnemyCar otherCar = enemyCars.get(i);

            if (otherCar == this) {
                continue;
            }

            float distanceX = Math.abs(otherCar.position.x - this.position.x);
            float distanceY = Math.abs(otherCar.position.y - this.position.y);

            boolean overlap = distanceX < getWidth() && distanceY < getHeight();

            if (overlap) {
                enemyCars.remove(this);
                float offset = (float) (Math.random() * window.width * 0.5);
                this.position.x = window.width + getWidth() + offset;
                int laneIndex = (int) (Math.random() * lanes.length);
                this.position.y = lanes[laneIndex];
                this.setSpeed(originalSpeed); // Reset the speed to the original speed
                enemyCars.add(this);
                collided = true;
                break;
            }
        }

        return collided;
    }


    /**
     * Original speed getter.
     *
     * @return float original speed
     */
    public float getOriginalSpeed() {
        return originalSpeed;
    }

    /**
     * Picks a random PImage for the car, called in Constructor.
     * @return PImage
     */
    private PImage pickCar() {
        int random = (int) (Math.random() * carImages.size());
        car = carImages.get(random);
        return car;
    }

    /**
     * Move method for EnemyCar, first checks for car overlap, then sets speed accordingly
     * Moves EnemyCar from the end of the screen to the left and moving them back to the right again
     *
     * @param enemyCars the arraylist of enemyCars, used in UI.java
     */
    public void update(CarLinkedList<EnemyCar> enemyCars) {
        float minDistance = 300;

        enemyCars.forEach(otherCar -> {
            if (otherCar == this) {
                return;
            }

            if (shouldStop(otherCar, minDistance)) {
                this.setSpeed(otherCar.getSpeed());
            }
        });

        position.x -= getSpeed();
        if (position.x < -getWidth()) {
            float offset = (float) (Math.random() * window.width * 0.5);
            // for fluid transitions. imitates traffic!
            position.x = window.width + getWidth() + offset;
            int laneIndex = (int) (Math.random() * lanes.length);
            position.y = lanes[laneIndex];
        }
    }

    // Draws the image, used in UI.java
    @Override
    public void draw() {
        window.image(car, position.x, position.y, width, height);
    }

    @Override
    public boolean collide(Player player) {
        return false;
    }

    @Override
    public boolean collide(EnemyCar enemyCar) {
        return false;
    }
}


