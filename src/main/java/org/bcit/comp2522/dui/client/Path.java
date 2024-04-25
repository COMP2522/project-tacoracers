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

    /**
     * Instantiates a new Path.
     *
     * @param manager the manager
     * @param scene   the scene
     */
    public Path(Manager manager, Window scene) {
        this.manager = manager;
        this.window = scene;
        this.linePositions = new float[] {0, 180, 360, 540, 720, 900, 1080};
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public float getSpeed() {
        return this.speed;
    }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * Draw roadlines moving right to left
     */
    public void drawLines() {
        // Update line positions
        for (int i = 0; i < linePositions.length; i++) {
            linePositions[i] -= speed;
            if (linePositions[i] < -180) {
                linePositions[i] += window.width;
            }
        }
        float rightmostPosition = window.width;
        for (float linePosition : linePositions) {
            if (linePosition < rightmostPosition) {
                rightmostPosition = linePosition;
            }
        }

        // Draw the roadlines
        for (int i = 0; i < 4; i++) {
            for (float linePosition : linePositions) {
                // Ensure that the line is within the visible area
                if (linePosition + i * 180 >= rightmostPosition) {
                    window.image(manager.contentLoader.getRoadLine(), linePosition + i * 180, 430);
                    window.image(manager.contentLoader.getRoadLine(), linePosition + i * 180, 233);
                }
            }
        }
    }

  public float getOriginalSpeed() {
      return (float) 20;
  }
}
