package org.bcit.comp2522.dui.client;

public class Button {
    private Window window;
    private Manager manager;

    public Button(Window window, Manager manager) {
        this.window = window;
        this.manager = manager;
    }
    public void reset() {
        manager.ui.getPlayer().lives = 3;
        manager.game.updateHighScore();
        manager.game.resetScore();
        manager.game.resumeScore();
        manager.keyInput.pressedKeys.clear();
    }

    public void play() {
        if (window.mouseX > ((window.width / 2) - 150) && window.mouseX < ((window.width / 2)) + 150
                && window.mouseY > 450 && window.mouseY < 575) {
            window.fill(0, 0, 255);
            window.rect((window.width / 2) - 150, 450, 300, 125);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(manager.contentLoader.mediumFont);
            window.text("PLAY", window.width / 2, 535);
            if (window.mousePressed) { // when play button is pressed
                manager.screenState = 3;
            }
        }
    }



    public void diff() {
        if (window.mouseX > ((window.width / 2) - 150) &&
                window.mouseX < ((window.width / 2)) + 150
                && window.mouseY > 150 && window.mouseY < 200) {
            window.fill(0, 0, 255);
            window.rect(375, 125, 525, 125);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(manager.contentLoader.smallFont);
            window.text("Difficulty", window.width / 2, 200);

            if (window.mousePressed) {
                manager.screenState = 6;
                manager.ui.draw();
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
            window.textFont(manager.contentLoader.smallFont);
            window.text("Cars", window.width / 2, 300);

            if (window.mousePressed) {
                manager.screenState = 4;
                manager.ui.draw();
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
            window.textFont(manager.contentLoader.smallFont);
            window.text("Leaderboard", window.width / 2, 400);

            if (window.mousePressed) {
                manager.screenState = 5;
                manager.ui.draw();
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
            window.textFont(manager.contentLoader.smallFont);
            window.text("Quit", 900, 535);

            if (window.mousePressed) {
                window.exit();
            }
        }
    }

    public void playAgain() {
        window.fill(255, 255, 255);
        window.rect((window.width / 2) - 270, 465, 540, 75);
        window.textAlign(window.CENTER);
        window.fill(0);
        window.textFont(manager.contentLoader.smallFont);
        window.text("RESTART", (window.width / 2), 525);
        if (window.mouseX > window.width / 2 - 270 && window.mouseX < window.width / 2 + 270
                && window.mouseY > 465 && window.mouseY < 535) {
            if (window.mousePressed) {
                reset();
                manager.screenState = 0;
            }
        }
    }
    public void mainMenu() {
        window.fill(255, 255, 255);
        window.rect((window.width / 2) - 270, 380, 540, 75);
        window.textAlign(window.CENTER);
        window.fill(0);
        window.textFont(manager.contentLoader.smallFont);
        window.text("MAIN MENU", (window.width / 2), 440);
        if (window.mouseX > window.width / 2 - 270 && window.mouseX < window.width / 2 + 270
                && window.mouseY > 380 && window.mouseY < 455) {
            if (window.mousePressed) {
                reset();
                System.out.println("here");
                manager.screenState = 3;
            }
        }
    }

    public void red() {
        //red
        if (window.mouseX > ((50)) && window.mouseX < ((150)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(50, 475, 200, 75);
            window.textAlign(window.CENTER);
            window.fill(255);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Select", 150, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.playerImageRed);
                manager.screenState = 0;
            }
        }
    }

    public void yellow() {
        //yellow
        if (window.mouseX > ((375)) && window.mouseX < ((475)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(375, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Select", 475, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.playerImageYellow);
                manager.screenState = 0;
            }
        }
    }

    public void blue() {
        if (window.mouseX > ((675)) && window.mouseX < ((775)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(675, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Select", 775, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.playerImageBlue);
                manager.screenState = 0;
            }
        }
    }

    public void purple() {
        //purple
        if (window.mouseX > ((975)) && window.mouseX < ((1075)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(975, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.smallFont);
            window.textSize(30);
            window.text("Select", 1075, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.playerImagePurple);
                manager.screenState = 0;
            }
        }
    }
    public void checkMuteButtonClick() {
        if (window.mousePressed && window.mouseX >= 300 && window.mouseX <= 300 + manager.contentLoader.mute.width &&
                window.mouseY >= 25 && window.mouseY <= 25 + manager.contentLoader.mute.height) {
            manager.muted = true;
        }
    }
}