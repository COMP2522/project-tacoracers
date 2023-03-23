package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;

public class Path extends Manager implements Drawable {

    Window window;
    UI ui;

    public Path(Window manager) {
        this.window = manager;
    }
    public void drawLines() {
        // Move the origin of the coordinate system to the right
        // by an amount equal to the current frame count
        float xTranslation = -window.frameCount % window.width;
        window.translate(xTranslation, 0);

        // Draw the rectangles
        window.rect(0, 450,  90, 10);
        window.rect(200, 450, 90, 10);
        window.rect(400, 450, 90, 10);
        window.rect(600, 450, 90, 10);
        window.rect(800, 450, 90, 10);
        window.rect(1035, 450, 90, 10);
        // If the rectangles have moved off the screen on the left,
        // move them back to the right
        if (xTranslation < 0) {
            window.translate(window.width, 0);
            window.rect(0, 450,  0, 10);
            window.rect(200, 450, 90, 10);
            window.rect(400, 450, 90, 10);
            window.rect(600, 450, 90, 10);
            window.rect(800, 450, 90, 10);
            window.rect(1000, 450, 90, 10);
        }
    }
}