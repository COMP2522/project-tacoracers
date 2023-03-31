package org.bcit.comp2522.dui.client;

/**
 * The button class handles most user interactions in the game, including logic and UI.
 *
 * @author Eric Tatchell
 */
public class Button {

    // window instance
    private Window window;

    // manager instance
    private Manager manager;

    /**
     * Constructor building Window and Manager instances
     * @param window parent
     * @param manager parent
     */
    public Button(Window window, Manager manager) {
        this.window = window;
        this.manager = manager;
    }

    // Restart button
    public void restart() {
        if (window.mouseX > ((window.width / 2) - 280) && window.mouseX < (window.width / 2) + 280
                && window.mouseY > 400 && window.mouseY < 475) {
            window.fill(150, 0, 0);
            window.rect((window.width / 2) - 280, 400, 560, 75);
            window.textAlign(window.CENTER);
            window.fill(0);
            window.textFont(manager.contentLoader.smallFont);
            window.text("PLAY AGAIN", (window.width / 2), 455);
            if (window.mousePressed) { // when restart button is pressed

                // sets screenState to 0 which is the Playing state
                manager.screenState = 0;

                // resets player lives to 3
                manager.ui.player.lives = 3;

                // Updates the players high score
                manager.game.updateHighScore();

                // Resets the in game score counter
                manager.game.resetScore();

                // Resumes the score counter after it was stopped upon TOTALED
                manager.game.resumeScore();

                // Re-initializes UI
                manager.ui.init();
            }
        }
    }

    // Play button
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

                // 3 is Main Menu screen state
                manager.screenState = 3;
            }
        }
    }

    // Difficulty screen button
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

                // 6 is difficulty screenState
                manager.screenState = 6;
            }
        }
    }

    // Car selection button
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

                // 4 is Car Selection screen state
                manager.screenState = 4;
            }
        }
    }

    // Leaderboard button
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

                // 5 is leaderboard screenState
                manager.screenState = 5;
            }
        }
    }


    // Quit button
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

    // Red car select
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

                // unimplemented
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
                // unimplemented
                manager.screenState = 0;
            }
        }
    }

    public void blue() {
        //blue
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
                // unimplemented
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
                // unimplemented
                manager.screenState = 0;
            }
        }
    }

    // Mute button
    public void mute() {
        if (window.mouseX > 300 && window.mouseX < 350
        && window.mouseY > 25 && window.mouseY < 75) {
            if (window.mousePressed) {

                // mutes the in game music

                window.musicPlayer.stop();
                manager.muted = true;
                manager.ui.elements.muted();
            }
        }
    }
}