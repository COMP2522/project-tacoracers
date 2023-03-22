package org.bcit.comp2522.dui.client;

import processing.core.PVector;

public class Player extends Sprite implements Collidable {

    public Player(PVector position, Window window) {
        super(position, window);
    }

    public void move(int event) {
        if (event > 0) {
            this.setPosition(event);
            System.out.println("y increased");
        }
        if (event < 0) {
            this.setPosition(event);
            System.out.println("y decreased");
        }
    }

    @Override
    public void collide() {

    }



    @Override
    public void draw() {
        window.pushStyle();
        window.ellipse(this.position.x, this.position.y, 50, 50);
        window.popStyle();
    }
}
