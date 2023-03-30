package org.bcit.comp2522.dui.client;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

/**
 * Sprite class represents objects in the world.
 * (player nad enemy car)
 *
 * @author Eric Tatchell
 */
public class Sprite {
    protected float size;
    protected float laneSpeed;
    protected float width;
    protected float height;
    protected float speed;
    protected float initialOffset;
    protected PVector position;
    protected Manager manager; // Add a Manager instance variable
    protected Window window;
    Player player;
    PImage playerImage;

    public Sprite(Manager manager, Window scene, PVector position, float width, float height) {
        this.manager = manager; // Initialize the Manager instance variable
        this.window = scene;
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Sprite(Manager manager, Window scene, PVector position, float width, float height, float speed) {
        this.manager = manager; // Initialize the Manager instance variable
        this.window = scene;
        this.position = position;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public float getSpeed() {
        return this.speed;
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
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }
}
