package org.bcit.comp2522.dui.client;

public class Button {
    private Window window;
    private Manager manager;

    public Button(Window window, Manager manager) {
        this.window = window;
        this.manager = manager;
    }
    public void restart() {
        if (window.mouseX > ((window.width / 2) - 280) && window.mouseX < (window.width / 2) + 280
                && window.mouseY > 400 && window.mouseY < 475) {
            window.fill(150, 0, 0);
            window.rect((window.width / 2) - 280, 400, 560, 75);
            window.textAlign(window.CENTER);
            window.fill(0);
            window.textFont(manager.contentLoader.smallFont);
            window.text("PLAY AGAIN", (window.width / 2), 455);
            if (window.mousePressed) { // when play button is pressed
                manager.playing = true;
                manager.ui.init();
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
            window.textFont(manager.contentLoader.mediumFont);
            window.text("PLAY", window.width / 2, 535);
            if (window.mousePressed) { // when play button is pressed
                manager.playing = true;
                manager.ui.draw();
            }
        }
    }
//    public void move(Player player) {
//        if (window.keyPressed) {
//            player.handleKeyPress(window.keyCode, ui.path);
//        }
//    }

}
