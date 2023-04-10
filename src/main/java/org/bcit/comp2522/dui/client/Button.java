package org.bcit.comp2522.dui.client;


/**
 * The type Button.
 */
public class Button extends ButtonHandler {

    // manager instance
    private Manager manager;

    // window instance
    private Window window;

    // middle width value
    private int middle;

    /**
     * Instantiates a new Button.
     *
     * @param window  the window
     * @param manager the manager
     */
    public Button(Window window, Manager manager) {
        super(window, manager);
        this.manager = getManager();
        this.window = getWindow();
        this.middle = window.width / 2;
    }

    /**
     * Reset.
     */
    public void reset() {
        manager.game.updateHighScore();
        manager.ui.getPlayer().setLives(manager.ui.getPlayer().getDefaultLives());
        manager.game.resetScore();
        manager.game.resumeScore();
        manager.keyInput.getPressedKeys().clear();
    }


    /**
     * Play.
     */
    public void play() {
        float x1 = middle - 150;
        float x2 = middle + 150;
        float y1 = 450;
        float y2 = 575;

        if (hover(x1, x2, y1, y2)) {
            window.fill(0, 0, 255);
            window.rect(x1, y1, 300, 125);
            manager.ui.displayText(manager.contentLoader.getMediumFont(), window.CENTER,
                    255, 255, 255, "PLAY", middle, 535);
            if (clickedWhileHover(x1, x2, y1, y2)) {
                manager.screenState = 3;
            }
        }
    }

    /**
     * Play 2.
     */
    public void play2() {
        if (window.mouseX > ((window.width - 175) - 150) && window.mouseX < ((window.width - 175)) + 150
                && window.mouseY > 45 && window.mouseY < 95) {
            window.fill(0, 0, 255);
            window.rect((window.width - 175) - 150, 0, 300, 110);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(manager.contentLoader.getMediumFont());
            window.text("PLAY", (window.width - 175), 70);
            if (window.mousePressed) { // when play button is pressed
                manager.screenState = 7;
            }
        }
    }

    /**
     * up arrow key control.
     */
    public void upArrow() {
        float x1 = middle + 200;
        float x2 = middle + 300;
        float y1 = 110;
        float y2 = 210;

        if (hover(x1, x2, y1, y2)) {
            manager.ui.displayText(manager.contentLoader.getTinyFont(), window.CENTER,
                    255, 255, 255, "Switch to above lane.", middle - 50, 165);
        }
    }

    /**
     * down arrow key control.
     */
    public void downArrow() {
        float x1 = middle - 300;
        float x2 = middle - 200;
        float y1 = 210;
        float y2 = 310;

        if (hover(x1, x2, y1, y2)) {
            manager.ui.displayText(manager.contentLoader.getTinyFont(), window.CENTER,
                    255, 255, 255, "Switch to below lane.", middle + 65, 265);
        }
    }

    /**
     * left arrow key control.
     */
    public void leftArrow() {
        float x1 = middle + 200;
        float x2 = middle + 300;
        float y1 = 310;
        float y2 = 410;

        if (hover(x1, x2, y1, y2)) {
            manager.ui.displayText(manager.contentLoader.getTinyFont(), window.CENTER,
                    255, 255, 255, "Slow down.", middle - 30, 365);
        }
    }

    /**
     * repair control.
     */
    public void repair() {
        float x1 = middle - 300;
        float x2 = middle - 200;
        float y1 = 410;
        float y2 = 510;

        if (hover(x1, x2, y1, y2)) {
            manager.ui.displayText(manager.contentLoader.getTinyFont(), window.CENTER,
                    255, 255, 255, "Refill health to full.", middle + 65, 465);
        }
    }

    /**
     * Play 3 from controls page.
     */
    public void play3() {
        if (window.mouseX > ((window.width - 225) - 200) && window.mouseX < ((window.width - 225)) + 150
                && window.mouseY > 475 && window.mouseY < 585) {
            window.fill(0, 0, 255);
            window.rect((window.width - 225) - 200, 475, 400, 110);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.text("CONTINUE", (window.width - 225), 550);
            if (window.mousePressed) { // when play button is pressed
                manager.screenState = 0;
            }
        }
    }

    /**
     * Back 2.
     */
    public void back2() {
        if (window.mouseX > (((window.width) - 230)) && window.mouseX < ((window.width))
                && window.mouseY > 100 && window.mouseY < 200) {
            window.fill(0, 0, 255);
            window.rect((window.width) - 230, 135, 210, 100);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.text("Back", (window.width) - 120, 200);

            if (window.mousePressed) {
                manager.screenState = 3;
            }
        }
    }

    /**
     * Diff.
     */
    public void diff() {
        if (window.mouseX > ((window.width / 2) - 150) &&
                window.mouseX < ((window.width / 2)) + 150
                && window.mouseY > 150 && window.mouseY < 200) {
            window.fill(0, 0, 255);
            window.rect(375, 125, 525, 125);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.text("Difficulty", window.width / 2, 200);

            if (window.mousePressed) {
                manager.screenState = 6;
                manager.ui.draw();
            }
        }
    }

    /**
     * Cars.
     */
    public void cars() {
        if (window.mouseX > ((window.width / 2) - 150) &&
                window.mouseX < ((window.width / 2)) + 150
                && window.mouseY > 250 && window.mouseY < 300) {
            window.fill(0, 0, 255);
            window.rect((window.width / 2) - 150, 225, 300, 125);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.text("Cars", window.width / 2, 300);

            if (window.mousePressed) {
                manager.screenState = 4;
                manager.ui.draw();
            }
        }
    }

    /**
     * Leaderboard.
     */
    public void leaderboard() {
        if (window.mouseX > ((window.width / 2) - 150) &&
                window.mouseX < ((window.width / 2)) + 150
                && window.mouseY > 350 && window.mouseY < 400) {
            window.fill(0, 0, 255);
            window.rect(350, 325, 575, 125);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.text("Leaderboard", window.width / 2, 400);

            if (window.mousePressed) {
                manager.screenState = 5;
                manager.ui.draw();
            }
        }
    }

    /**
     * Back.
     */
    public void back() {
        if (window.mouseX > ((350) - 130) && window.mouseX < ((350)) + 70
                && window.mouseY > 0 && window.mouseY < 100) {
            window.fill(0, 0, 255);
            window.rect(220, 0, 210, 100);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.text("Back", 330, 70);

            if (window.mousePressed) {
                manager.screenState = 3;
            }
        }
    }

    /**
     * Quit.
     */
    public void quit() {
        if (window.mouseX > ((120) - 110) && window.mouseX < ((120)) + 60
                && window.mouseY > 0 && window.mouseY < 100) {
            window.fill(0, 0, 255);
            window.rect(10, 0, 210, 100);
            window.textAlign(window.CENTER);
            window.fill(255, 255, 255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.text("Quit", 120, 70);

            if (window.mousePressed) {
                window.exit();
            }
        }
    }

    /**
     * Play again.
     */
    public void playAgain() {
        window.fill(255, 255, 255);
        window.rect((window.width / 2) - 270, 465, 540, 75);
        window.textAlign(window.CENTER);
        window.fill(0);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("RESTART", (window.width / 2), 525);
        if (window.mouseX > window.width / 2 - 270 && window.mouseX < window.width / 2 + 270
                && window.mouseY > 465 && window.mouseY < 535) {
            if (window.mousePressed) {
                reset();
                manager.screenState = 0;
            }
        }
    }

    /**
     * Main menu.
     */
    public void mainMenu() {
        window.fill(255, 255, 255);
        window.rect((window.width / 2) - 270, 380, 540, 75);
        window.textAlign(window.CENTER);
        window.fill(0);
        window.textFont(manager.contentLoader.getSmallFont());
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

    /**
     * Red.
     */
    public void red() {
        //red
        if (window.mouseX > ((50)) && window.mouseX < ((150)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(50, 475, 200, 75);
            window.textAlign(window.CENTER);
            window.fill(255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 150, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImageRed());
                manager.screenState = 3;

            }
        }
    }

    /**
     * Yellow.
     */
    public void yellow() {
        //yellow
        if (window.mouseX > ((375)) && window.mouseX < ((475)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(375, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 475, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImageYellow());
                manager.screenState = 3;

            }
        }
    }

    /**
     * Blue.
     */
    public void blue() {
        if (window.mouseX > ((675)) && window.mouseX < ((775)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(675, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 775, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImageBlue());
                manager.screenState = 3;

            }
        }
    }

    /**
     * Purple.
     */
    public void purple() {
        //purple
        if (window.mouseX > ((975)) && window.mouseX < ((1075)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(975, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 1075, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImagePurple());
                manager.screenState = 3;

            }
        }
    }

    /**
     * Easy.
     */
    public void easy() {
        //easy
        if (window.mouseX > ((50)) && window.mouseX < ((150)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(50, 475, 200, 75);
            window.textAlign(window.CENTER);
            window.fill(255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 150, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.playerImagemoto1);
                manager.screenState = 3;
                manager.diffState = 1;

                // player.setWidth(low);
            }
        }
    }

    /**
     * Redbike.
     */
    public void redbike() {
        //red
        if (window.mouseX > ((50)) && window.mouseX < ((150)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(50, 475, 200, 75);
            window.textAlign(window.CENTER);
            window.fill(255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 150, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImagemoto1());
                manager.screenState = 3;
            }
        }
    }

    /**
     * Yellowbike.
     */
    public void yellowbike() {
        //yellow
        if (window.mouseX > ((375)) && window.mouseX < ((475)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(375, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 475, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImagemoto2());
                manager.screenState = 3;
            }
        }
    }

    /**
     * Bluebike.
     */
    public void bluebike() {
        //blue
        if (window.mouseX > ((675)) && window.mouseX < ((775)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(675, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 775, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImagemoto3());
                manager.screenState = 3;
            }
        }
    }

    /**
     * Purplebike.
     */
    public void purplebike() {
        //purple
        if (window.mouseX > ((975)) && window.mouseX < ((1075)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(975, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 1075, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImagetruck1());
                manager.screenState = 3;
            }
        }
    }


    public void redtruck(){
        //red
        if (window.mouseX > ((50)) && window.mouseX < ((150)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(50, 475, 200, 75);
            window.textAlign(window.CENTER);
            window.fill(255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 150, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImagetruck1());
                manager.screenState = 3;
            }
        }
    }

    public void yellowtruck(){
        //yellow
        if (window.mouseX > ((375)) && window.mouseX < ((475)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(375, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 475, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImagetruck2());
                manager.screenState = 3;
            }
        }

    }

    public void bluetruck(){
        //blue
        if (window.mouseX > ((675)) && window.mouseX < ((775)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(675, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 775, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImagetruck3());
                manager.screenState = 3;
            }
        }
    }

    public void purpletruck(){
        //purple
        if (window.mouseX > ((975)) && window.mouseX < ((1075)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(975, 475, 200, 75);

            window.textAlign(window.CENTER);
            window.fill(255, 0, 0);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 1075, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImagetruck4());
                manager.screenState = 3;
            }
        }
    }

    /**
     * Medium.
     */
    public void medium() {
        //easy
        if (window.mouseX > ((500)) && window.mouseX < ((600)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(500, 475, 200, 75);
            window.textAlign(window.CENTER);
            window.fill(255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 600, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImagemoto1());
                manager.screenState = 3;
                manager.diffState = 2;


                // player.setWidth(normal);
            }
        }
    }

    /**
     * Hard.
     */
    public void hard() {
        //easy
        if (window.mouseX > ((950)) && window.mouseX < ((1050)) + 100
                && window.mouseY > 500 && window.mouseY < 575) {

            window.fill(0, 0, 255);
            window.rect(950, 475, 200, 75);
            window.textAlign(window.CENTER);
            window.fill(255);
            window.textFont(manager.contentLoader.getSmallFont());
            window.textSize(30);
            window.text("Select", 1050, 525);

            if (window.mousePressed) {
                manager.ui.getPlayer().pickPlayer(manager.contentLoader.getPlayerImagetruck1());
                manager.screenState = 3;
                manager.diffState = 3;

                // player.setWidth(normal);
            }
        }
    }

    public void checkMuteButtonClick() {
        if (window.mousePressed && window.mouseX >= 300 && window.mouseX <= 300 + manager.contentLoader.getMute().width &&
                window.mouseY >= 25 && window.mouseY <= 25 + manager.contentLoader.getMute().height) {
            manager.muted = true;
        }
    }
}