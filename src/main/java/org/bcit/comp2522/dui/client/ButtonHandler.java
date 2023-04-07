package org.bcit.comp2522.dui.client;

/**
 * The type Button handler.
 */
public abstract class ButtonHandler {

    // window instance
    private Window window;

    // manager instance
    private Manager manager;

    /**
     * Instantiates a new Button handler.
     *
     * @param window  the window
     * @param manager the manager
     */
    public ButtonHandler(Window window, Manager manager) {
        this.window = window;
        this.manager = manager;
    }

    /**
     * Hover boolean.
     *
     * @param x1 the x 1
     * @param x2 the x 2
     * @param y1 the y 1
     * @param y2 the y 2
     * @return the boolean
     */
    public boolean hover(float x1, float x2, float y1, float y2) {
        if (window.mouseX > x1 && window.mouseX < x2
                && window.mouseY > y1 && window.mouseY < y2) {
            return true;
        }
        return false;
    }

    /**
     * Clicked while hover boolean.
     *
     * @param x1 the x 1
     * @param x2 the x 2
     * @param y1 the y 1
     * @param y2 the y 2
     * @return the boolean
     */
    public boolean clickedWhileHover(float x1, float x2, float y1, float y2) {
        if (hover(x1, x2, y1, y2) && window.mousePressed) {
            return true;
        }
        return false;
    }


    /**
     * Getter for manager, handling game elements.
     *
     * @return manager manager
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * Getter for window, handling PApplet.
     *
     * @return window window
     */
    public Window getWindow() {
        return window;
    }
}
