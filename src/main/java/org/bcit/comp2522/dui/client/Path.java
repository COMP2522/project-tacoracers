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
        float xTranslation = -3 * window.frameCount % window.width;
        window.translate(xTranslation, 0);

        // Draw the rectangles
        window.fill(240,230,140);
        window.rect(0, 430, 180, 10);
        window.rect(360, 430, 180, 10);
        window.rect(720, 430, 180, 10);
        window.rect(1080, 430, 180, 10);
        window.rect(0, 233, 180, 10);
        window.rect(360, 233, 180, 10);
        window.rect(720, 233, 180, 10);
        window.rect(1080, 233, 180, 10);
        // If the rectangles have moved off the screen on the left,
        // move them back to the right
        if (xTranslation < 0) {
            window.translate(window.width, 0);
            window.fill(240,230,140);
            window.rect(0, 430, 180, 10);
            window.rect(360, 430, 180, 10);
            window.rect(720, 430, 180, 10);
            window.rect(1080, 430, 180, 10);
            window.rect(0, 233, 180, 10);
            window.rect(360, 233, 180, 10);
            window.rect(720, 233, 180, 10);
            window.rect(1080, 233, 180, 10);
        }
    }
}
