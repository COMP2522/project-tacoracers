package org.bcit.comp2522.dui.client;

import processing.core.PVector;

public class Player extends Sprite implements Collidable {

    public Player(PVector position, Window window) {
        super(position, window);
    }

    @Override
    public void collide() {

    }
}
