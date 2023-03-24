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


    /**
     * half of this might be redundant tbh.
     * might just combine it in another function.
     * @return one of the 3 lanes
     */
    public int pickLane() {
        Random random = new Random();
        int top = 140;
        int middle = 327;
        int bottom = 515;
        ArrayList<Integer> lanes = new ArrayList<Integer>();
        lanes.add(top);
        lanes.add(middle);
        lanes.add(bottom);
        int num = random.nextInt(3);
        this.lane = lanes.get(num);
        return this.lane - 140;
    }

    public float getLane() {
        return this.lane;
    }
}
