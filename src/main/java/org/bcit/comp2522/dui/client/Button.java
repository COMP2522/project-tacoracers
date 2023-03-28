package org.bcit.comp2522.dui.client;

import org.bcit.comp2522.dui.ui.UI;
import processing.core.*;
import processing.event.*;

public class Button extends PApplet {
    private Window window;
    private UI ui;
    public Button(Window window, UI ui) {
        this.window = window;
        this.ui = ui;
    }
    public void restart() {
        if (window.mouseX > ((window.width / 2) - 280) && window.mouseX < (window.width / 2) + 280
                && window.mouseY > 400 && window.mouseY < 475) {
            window.fill(150, 0, 0);
            window.rect((window.width / 2) - 280, 400, 560, 75);
            window.textAlign(window.CENTER);
            window.fill(0);
            window.textFont(window.smallFont);
            window.text("PLAY AGAIN", (window.width / 2), 455);
            if (window.mousePressed) { // when play button is pressed
                window.playing = true;
                window.init();
            }
        }
    }

    public void play() {
        if (window.mouseX > ((window.width / 2) - 150) && window.mouseX < ((window.width / 2)) + 150
                && window.mouseY > 450 && window.mouseY < 575) {
            window.fill(0, 0, 255);
            window.rect( (window.width / 2) - 150, 450, 300, 125);
            window.textAlign(window.CENTER);
            window.fill(255,255,255);
            window.textFont(window.mediumFont);
            window.text("PLAY", window.width / 2, 535);
            if (window.mousePressed) { // when play button is pressed
                window.playing = true;
                ui.draw();
            }
        }
    }
//    public void move(Player player) {
//        if (window.keyPressed) {
//            player.handleKeyPress(window.keyCode, ui.path);
//        }
//    }

}
