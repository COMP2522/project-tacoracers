package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;

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

    public Path(Window manager) {
        this.window = manager;
        this.linePositions = new float[] {0, 180, 360, 540, 720, 900, 1080};
    }

    public void drawLines() {
        window.fill(240, 230, 140);

        // Update line positions
        for (int i = 0; i < linePositions.length; i++) {
            linePositions[i] -= 3;
            if (linePositions[i] < -180) {
                linePositions[i] = window.width;
            }
        }

        // Draw the rectangles
        for (float linePosition : linePositions) {
            for (int i = 0; i < 4; i++) {
                window.rect(linePosition + i * 180, 430, 75, 10);
                window.rect(linePosition + i * 180, 233, 75, 10);
            }
        }
    }
}
