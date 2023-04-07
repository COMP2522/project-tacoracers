package org.bcit.comp2522.dui.client;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
  public long highScore = 0;
  public long score = 0;
  public int scoreIncrement = 10; // Score increment amount in each timer tick
  public int delay = 100;
  public String gamePlayerName = "";

  Window window;
  // initial variables to work with, both for displaying and tracking score
  Manager manager;

  Timer scoreTimer;

  public Game(Manager manager) {
    this.manager = manager;
    scoreTimer = new Timer(delay, e ->
            updateScore());
  }

  public void setScoreIncrement(int num) {
    scoreIncrement = num;
  }

  public int getScoreIncrement() {
    return scoreIncrement;
  }

  public void start() {
    scoreTimer.start();
  }

  public void stopScore() {
    scoreIncrement = 0;
  }

  public void resumeScore() {
      scoreIncrement = 10;
  }

  public void updateScore() {
    score += scoreIncrement; // Increment the score by the scoreIncrement amount
  }

  public void updateHighScore() {
    if (score > highScore) {
      highScore = score; // if the user beats the previous high score, their score becomes the new high score
      saveHighScoreToFile(); // saves the new high score to the database
    }
  }

  public void resetScore() {
    score = 0;
  }

  public void setPlayerName(String playerName) {
    manager.menu.playerName = playerName;
    this.gamePlayerName = playerName;
  }

  DatabaseHandler dbh = new DatabaseHandler("pavanbrar73", "KFmJyFJrTM6Dd7c2");

  public void saveHighScoreToFile() {
    dbh.put("name", gamePlayerName, "score", highScore);
  }

}
