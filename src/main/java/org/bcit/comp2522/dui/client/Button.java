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
            window.rect((window.width / 2) - 150, 450, 300, 125);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(window.mediumFont);
            window.text("PLAY", window.width / 2, 535);
            if (window.mousePressed) { // when play button is pressed
//                window.playing = true;
                switchToMenu2();
//                ui.draw();

            }
        }
    }

    public void switchToMenu2() {
        window.menu1Active = false;
        window.menu2Active = true;
    }


    public void diff() {
        if (window.mouseX > ((window.width / 2) - 150) &&
                window.mouseX < ((window.width / 2)) + 150
                && window.mouseY > 150 && window.mouseY < 200) {
            window.fill(0, 0, 255);
            window.rect(375, 125, 525, 125);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(window.smallFont);
            window.text("Difficulty", window.width / 2, 200);

            if (window.mousePressed) {
                window.playing = true;
                ui.draw();
            }
        }
    }

    public void cars() {
        if (window.mouseX > ((window.width / 2) - 150) &&
                window.mouseX < ((window.width / 2)) + 150
                && window.mouseY > 250 && window.mouseY < 300) {
            window.fill(0, 0, 255);
            window.rect((window.width / 2) - 150, 225, 300, 125);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(window.smallFont);
            window.text("Cars", window.width / 2, 300);

            if (window.mousePressed) {
                window.playing = true;
                ui.draw();
            }
        }
    }

    public void leaderboard() {
        if (window.mouseX > ((window.width / 2) - 150) &&
                window.mouseX < ((window.width / 2)) + 150
                && window.mouseY > 350 && window.mouseY < 400) {
            window.fill(0, 0, 255);
            window.rect(350, 325, 575, 125);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(window.smallFont);
            window.text("LeaderBoard", window.width / 2, 400);

            if (window.mousePressed) {
                window.playing = true;
                ui.draw();
            }
        }
    }


    public void quit() {
        if (window.mouseX > ((900) - 150) && window.mouseX < ((900)) + 150
                && window.mouseY > 450 && window.mouseY < 575) {
            window.fill(0, 0, 255);
            window.rect(775, 450, 250, 125);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(window.smallFont);
            window.text("Quit", 900, 535);

            if (window.mousePressed) {
                window.exit();
            }
        }
    }

    public void red() {
        //red
        if (window.mouseX > ((50)) && window.mouseX < ((150)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(50, 475, 200, 75);
            window.textAlign(CENTER);
            window.fill(255);
            window.textFont(window.smallFont);
            window.textSize(30);
            window.text("Select", 150, 525);

            if (window.mousePressed) {
//                Player.setCarColor("red");
                Sprite.chooseCarColor("red");

            }
        }
    }

    public void yellow() {
        //yellow
        if (window.mouseX > ((375)) && window.mouseX < ((475)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(375, 475, 200, 75);

            window.textAlign(CENTER);
            window.fill(255, 0, 0);
            window.textFont(window.smallFont);
            window.textSize(30);
            window.text("Select", 475, 525);

            if (window.mousePressed) {
//                Player.setCarColor("yellow");
                Sprite.chooseCarColor("yellow");

            }
        }
    }

    public void blue() {
        //blue
        if (window.mouseX > ((675)) && window.mouseX < ((775)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(675, 475, 200, 75);

            window.textAlign(CENTER);
            window.fill(255, 0, 0);
            window.textFont(window.smallFont);
            window.textSize(30);
            window.text("Select", 775, 525);

            if (window.mousePressed) {
//                Player.setCarColor("blue");
                Sprite.chooseCarColor("blue");

            }
        }
    }

    public void purple() {
        //purple
        if (window.mouseX > ((975)) && window.mouseX < ((1075)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(975, 475, 200, 75);

            window.textAlign(CENTER);
            window.fill(255, 0, 0);
            window.textFont(window.smallFont);
            window.textSize(30);
            window.text("Select", 1075, 525);

            if (window.mousePressed) {
//                Player.setCarColor("purple");
                Sprite.chooseCarColor("purple");
            }
        }


    }
}

//    public void move(Player player) {
//        if (window.keyPressed) {
//            player.handleKeyPress(window.keyCode, ui.path);
//        }
//    }



