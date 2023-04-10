package org.bcit.comp2522.dui.client;

import processing.core.PImage;

/**
 * Instruction class displays the controls of the game prior to playing.
 * Displays each control when button is hovered over.
 *
 * @author Pavanpreet
 */
public class Instruction {

    /**
     * The Manager.
     */
    public Manager manager;

    /**
     * The Window.
     */
    public Window window;

    /**
     * upkey image.
     */
    private PImage upKey;

    /**
     * downkey image.
     */
    private PImage downKey;

    /**
     * leftkey image.
     */
    private PImage leftKey;

    /**
     * repairkey image.
     */
    private PImage repairKey;


    /**
     * Constructor loads images and creates manager and window objects.
     *
     * @param manager Manager
     * @param scene Window
     */
    public Instruction(Manager manager, Window scene) {
        this.manager = manager;
        this.window = scene;

        upKey = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/upKey.png");
        downKey = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/downKey.png");
        leftKey = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/leftKey.png");
        repairKey = window.loadImage("src/main/java/org/bcit/comp2522/dui/content/repairKey.png");
    }

    /**
     * Instruction method creates the controls manual.
     * Hovering over each button displays the function
     */
    public void instruction() {
        window.background(window.getBackground());

        window.textSize(48);
        window.fill(0, 0, 255);
        window.textAlign(window.CENTER);
        window.text("CONTROLS", window.width / 2, 80);

        window.textSize(20);
        window.fill(255);
        window.textAlign(window.CENTER);
        window.text("Hover over\nbuttons", window.width / 2 - 500, 40);

        window.image(upKey, (window.width / 2) + 200, 110, 100, 100);
        manager.button.upArrow();

        window.image(downKey, (window.width / 2) - 300, 210, 100, 100);
        manager.button.downArrow();

        window.image(leftKey, (window.width / 2) + 200, 310, 100, 100);
        manager.button.leftArrow();

        window.image(repairKey, (window.width / 2) - 300, 410, 100, 100);
        manager.button.repair();

        window.fill(0, 0, 255);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("Back", (window.width) - 120, 200);
        manager.button.back2();

        window.fill(0, 0, 255);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("CONTINUE", window.width - 225, 550);
        manager.button.play3();
    }
}
