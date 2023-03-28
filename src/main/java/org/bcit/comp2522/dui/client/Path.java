package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;
import processing.core.PImage;

/**
 * Path controls the speed at which the road lines move. This creates the illusion of
 * driving a car.
 *
 * @author Eric Tatchell
 */
public class Path extends Manager implements Drawable {

    Window window;
    UI ui;
    float[] linePositions;
    PImage roadline;
    public float speed = 4;

    public Path(Window manager) {
        this.window = manager;
        this.linePositions = new float[] {0, 180, 360, 540, 720, 900, 1080};
        roadline = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/roadline.png");
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void drawLines() {
        window.fill(240, 230, 140);

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
                window.image(roadline, linePosition + i * 180, 430);
                window.image(roadline, linePosition + i * 180, 233);
            }
        }
    }
}
