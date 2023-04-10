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
public abstract class Sprite implements Collidable {

    /**
     * The Width.
     */
// instance for width
    protected float width;

    /**
     * The Height.
     */
// instance for height
    protected float height;

    /**
     * The Speed.
     */
// instance for speed
    protected float speed;

    /**
     * The Position.
     */
// instance for PVector positioning
    protected PVector position;

    /**
     * The Manager.
     */
// instance for manager
    protected Manager manager;

    /**
     * The Window.
     */
// instance for window
    protected Window window;

    /**
     * Constructor creating a sprite without speed (player).
     *
     * @param manager  sprite is able to access all parts of the game
     * @param scene    sprite is able to access drawing methods
     * @param position sprite PVector positioning
     * @param width    float
     * @param height   float
     */
    public Sprite(Manager manager, Window scene, PVector position, float width, float height) {
        this.manager = manager;
        this.window = scene;
        this.position = position;
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor creating a sprite.
     *
     * @param manager  sprite is able to access all parts of the game
     * @param scene    sprite is able to access drawing methods
     * @param position sprite PVector positioning
     * @param width    float
     * @param height   float
     * @param speed    float
     */
    public Sprite(Manager manager, Window scene, PVector position, float width, float height, float speed) {
        this.manager = manager;
        this.window = scene;
        this.position = position;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }


    /**
     * Getter for speed.
     *
     * @return current speed
     */
    public float getSpeed() {
        return this.speed;
    }

    /**
     * Getter for position.
     *
     * @return x, y or both
     */
    public PVector getPosition() {
        return position.copy();
    }

    /**
     * Getter for width.
     *
     * @return sprite 's width
     */
    public float getWidth() {
        return this.width;
    }

    /**
     * Getter for height
     *
     * @return sprite 's height
     */
    public float getHeight() {
        return this.height;
    }

    /**
     * Mutator for speed.
     *
     * @param speed sprite's speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * Position setter.
     *
     * @param x x
     * @param y y
     */
    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }

    /**
     * Sets position.
     *
     * @param p the p
     */
    public void setPosition(PVector p) {
        this.position = p;
    }
}
