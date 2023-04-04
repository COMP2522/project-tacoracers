package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;

/**
 * Path controls the speed at which the road lines move.
 * Adapts based on gameplay difficulty and progress.
 *
 * @author Eric Tatchell
 */
public class Path {

    private Window window;
    private Manager manager;
    private float[] linePositions;
    private float speed = 20;

    public Path(Manager manager, Window scene) {
        this.manager = manager;
        this.window = scene;
        this.linePositions = new float[] {0, 180, 360, 540, 720, 900, 1080};
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void drawLines() {

        // Update line positions
        for (int i = 0; i < linePositions.length; i++) {
            linePositions[i] -= speed;
            if (linePositions[i] < -180) {
                linePositions[i] = window.width;
            }
        }

        // Draw the roadlines
        for (float linePosition : linePositions) {
            for (int i = 0; i < 4; i++) {
                window.image(manager.contentLoader.getRoadLine(), linePosition + i * 180, 430);
                window.image(manager.contentLoader.getRoadLine(), linePosition + i * 180, 233);
            }
        }
    }
}
