package org.bcit.comp2522.dui.client;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Game class controls player's name and score.
 *
 * @author Pavanpreet Brar
 */
public class Game {
  public long highScore = 0;
  public long score = 0;
  public int scoreIncrement = 10; // Score increment amount in each timer tick
  public int delay = 100;
  public String gamePlayerName = "";

  // initial variables to work with, both for displaying and tracking score
  Manager manager;

  Timer scoreTimer;

  /**
   * Constructor creates a manager and timer object.
   * Timer is assigned to the scoreTimer instance variable
   *
   * @param manager Manager
   */
  public Game(Manager manager) {
    this.manager = manager;
    scoreTimer = new Timer(delay, e ->
            updateScore());
  }

  /**
   * For use when user is slowed.
   *
   * @param num int
   */
  public void setScoreIncrement(int num) {
    scoreIncrement = num;
  }

  /**
   * Getter for score increment.
   *
   * @return scoreIncrement
   */
  public int getScoreIncrement() {
    return scoreIncrement;
  }

  /**
   * Starts the score timer.
   */
  public void start() {
    scoreTimer.start();
  }

  /**
   * Stops the score timer.
   */
  public void stopScore() {
    scoreIncrement = 0;
  }

  /**
   * Resumes the score timer.
   */
  public void resumeScore() {
      scoreIncrement = 10;
  }

  /**
   * Updates the score every 100 milliseconds.
   */
  public void updateScore() {
    score += scoreIncrement; // Increment the score by the scoreIncrement amount
  }

  /**
   * Updates the high score and saves it to database.
   */
  public void updateHighScore() {
    if (score > highScore) {
      highScore = score; // if the user beats the previous high score, their score becomes the new high score
      saveHighScoreToFile(); // saves the new high score to the database
    }
  }

  /**
   * Resets the score.
   */
  public void resetScore() {
    score = 0;
  }

  /**
   * Sets the player name to a variable used to save it to the database.
   *
   * @param playerName
   */
  public void setPlayerName(String playerName) {
    manager.menu.playerName = playerName;
    this.gamePlayerName = playerName;
  }

   DatabaseHandler dbh = new DatabaseHandler("erictatch", "1UCQfffWKdXM6Aom");

  /**
   * Saves the high score using a put method from the database handler.
   */
    public void saveHighScoreToFile() {
      dbh.put("name", gamePlayerName, "score", highScore);
    }

}
