package org.bcit.comp2522.dui.client;

import org.bson.Document;

import java.util.ArrayList;

/**
 * Leaderboard class creates a table and fills in the top 10 scores and names on a separate screen.
 */
public class Leaderboard {

    /**
     * The Manager.
     */
    public Manager manager;

    /**
     * The Window.
     */
    public Window window;

    private ArrayList<Document> cachedHighestScores;

    /**
     * Constructor creates a manager and window object.
     *
     * @param manager Manager
     * @param scene Window
     */
    public Leaderboard(Manager manager, Window scene) {
        this.manager = manager;
        this.window = scene;
        this.cachedHighestScores = new ArrayList<>();
        updateHighestScores();
    }

    /**
     * Updates the top 10 highest scores.
     */
    public void updateHighestScores() {
        DatabaseHandler dbhandler = new DatabaseHandler("erictatch", "1UCQfffWKdXM6Aom");
        this.cachedHighestScores = dbhandler.getHighestScores();
    }

    /**
     * Leaderboard controls displaying the top 10 scores and names in a table.
     *
     * @author Pavanpreet Brar
     */
    public void leaderboard() {
        window.background(0);
        int y = 200;
        int rank = 1;
        //back
        window.fill(0, 0, 255);
        window.textAlign(window.CENTER);
        window.textFont(manager.contentLoader.getSmallFont());
        window.text("Back", 330, 70);
        manager.button.back();

        window.textSize(32);
        window.fill(0, 0, 255);
        window.textAlign(window.CENTER);

        window.text("Leaderboard", window.width / 2, 80);
        window.text("Rank", window.width / 8 + 50, 160);
        window.text("Name", window.width / 2 - 70, 160);
        window.text("Score", window.width * 3 / 4 + 30, 160);

        window.fill(255);
        window.textSize(28);
        window.textAlign(window.CENTER, window.CENTER);
        window.stroke(255);
        window.strokeWeight(2);
        window.line(80, 180, window.width - 80, 180);

        window.stroke(255);
        window.strokeWeight(2);

        // Left vertical line
        window.line(80, 180, 80, 580);

        // Right vertical line
        window.line(window.width - 80, 180, window.width - 80, 580);

        window.line(330, 180, 330, 580);
        window.line(window.width - 450, 180, window.width - 450, 580);

        for (Document doc : cachedHighestScores) {

            String name = doc.getString("name");
            int score = doc.getLong("score").intValue();


            window.fill(255);
            window.text(rank, window.width / 8 + 50, y);

            window.fill(255);
            window.text(name, window.width / 2 - 70, y);

            window.fill(255);
            window.text(score, window.width * 3 / 4 + 30, y);

            window.stroke(255);
            window.strokeWeight(2);
            window.line(80, y + 20, window.width - 80, y + 20);

            y += 40;
            rank++;
        }

        window.stroke(255);
        window.strokeWeight(2);
        window.line(80, y - 20, window.width - 80, y - 20);
    }
}