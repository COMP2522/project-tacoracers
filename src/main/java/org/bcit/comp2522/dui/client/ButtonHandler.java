package org.bcit.comp2522.dui.client;

public abstract class ButtonHandler {

    // window instance
    private Window window;

    // manager instance
    private Manager manager;
    public ButtonHandler(Window window, Manager manager) {
        this.window = window;
        this.manager = manager;
    }

    public boolean hover(float x1, float x2, float y1, float y2) {
        if (window.mouseX > x1 && window.mouseX < x2
                && window.mouseY > y1 && window.mouseY < y2) {
            return true;
        }
        return false;
    }

    public boolean clickedWhileHover(float x1, float x2, float y1, float y2) {
        if (hover(x1, x2, y1, y2) && window.mousePressed) {
            return true;
        }
        return false;
    }


    /**
     * Getter for manager, handling game elements.
     * @return manager
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * Getter for window, handling PApplet.
     * @return window
     */
    public Window getWindow() {
        return window;
    }
}
