package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.*;
import processing.core.PFont;
import processing.core.PVector;
import processing.event.KeyEvent;

public class UI extends Manager implements Drawable {
    public Window window;
    private Manager manager;
    private Obstacle traffic;
    public Player player;
    public Path path;
    public PFont font;
    public float height;
    public float width;
    boolean hasKeyPressed = false;

    public UI(Window scene) {
        super();
        this.window = scene;
        path = new Path(scene);
        player = new Player(new PVector(window.width / 5, 400), this.window);
    }
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch(keyCode) {
            case UP:
                player.setPosition(player.getPosition().y + 1);
                System.out.println("up");
                break;
            case DOWN:
                player.setPosition(player.getPosition().y - 1);
                System.out.println("down");
                break;
        }
    }

    boolean keyPressed = false;
    int targetPosition = 125;
    int currentPosition = 125;
    int animationFrames = 10; // number of frames to complete the animation

    @Override
    public void draw() {
        if (window.playing == false) {
            this.menu();
        } else {
            window.background(0);
            window.rect(0, 600, 1080, 500); // top of the border
            window.fill(255);
            window.rect(0, 100, 1080, -500); // bottom of the border
            window.fill(255);


            // update the player position gradually using an animation loop
            if (currentPosition != targetPosition) {
                float delta = (targetPosition - currentPosition) / (float) animationFrames;
                currentPosition += delta;
            }
            player.drawPlayer(player.getPosition().x, currentPosition);

            // handle key presses
            if (window.keyPressed && !keyPressed) {
                keyPressed = true;
                switch(window.keyCode) {
                    case UP:
                        if (targetPosition - 125 > 100 ) {
                            targetPosition -= 125;
                            System.out.println(targetPosition);
                        } else {
                            targetPosition = 125;
                            System.out.println(targetPosition);

                        }
                        break;
                    case DOWN:
                        if (targetPosition + 125 < 550) {
                            targetPosition += 125;
                            System.out.println(targetPosition);
                        } else {
                            targetPosition = 550;
                            System.out.println(targetPosition);

                        }
                        break;
                }
            } else if (!window.keyPressed) {
                keyPressed = false;
            }
            path.drawLines();
        }
    }




    public void menu() {
        window.background(0);
        window.fill(255);
//        window.textFont(window.font);
        window.textSize(150);
        window.textAlign(CENTER);
        window.text("DUI", 540, 200);
        window.textSize(50);
        window.text("Driving Unintelligently", 540, 300);
        window.rect(465, 400, 150, 75);
        window.textAlign(CENTER);
        window.fill(0);
        window.textSize(50);
        window.text("PLAY", 540, 455);
        if (window.mouseX > 465 && window.mouseX < 615
                && window.mouseY > 400 && window.mouseY < 475) {
            if (window.mousePressed) { // when play button is pressed
                window.playing = true;
                this.draw();
            }
        }
    }

    public void displayHighScore(long newScore) {

    }

    public void init() {
        this.draw();
    }
}
