package org.bcit.comp2522.dui.client;

import processing.core.PVector;

import java.util.ArrayList;
import java.util.Random;

public class Obstacle extends Sprite implements Collidable {
    public int lane;
    public Obstacle(PVector position, Window window) {
        super(position, window);
    }
    @Override
    public void collide() {

    }

    public void move(float speed) {
        this.position.x -= speed;
    }

    /**
     * half of this might be redundant tbh.
     * might just combine it in another function.
     * @return one of the 3 lanes
     */
    public PVector pickLane(int laneWidth, int numberOfLanes) {
        Random random = new Random();
        int top = 140;
        int middle = 327;
        int bottom = 515;
        ArrayList<Integer> lanes = new ArrayList<Integer>();
        lanes.add(top);
        lanes.add(middle);
        lanes.add(bottom);
        int num = random.nextInt(numberOfLanes);
        this.lane = lanes.get(num);

        // Assign a random x position within the screen bounds
        int x = random.nextInt(window.width - 100);

        return new PVector(x, this.lane);
    }



    public float getLane() {
        return this.lane;
    }
}
