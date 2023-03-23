package org.bcit.comp2522.dui.client;

/**
 * Scoring, using JSON data structure
 * Use processing elements to display text to ui
 *
 * Should work with Manager.java to track Game state (alive or dead)
 * If alive, compounding score, stop and write to JSON when dead
 * Display to UI, read current high score if there is one
 */
public class Game {
  private long highScore = 0;
  private long score = 0;
  Window window;
  // initial variables to work with, both for displaying and tracking score
  Manager manager;

  void setup() {
    highScore = loadHighScoreFromFile(); // load high score from database
  }
  public void displayScore() {
    window.textSize(20);
//    window.textAlign(LEFT);
    window.fill(255, 255, 255);
    window.text("Score: " + score, 10, 50); // display the score at position (10, 50)
  }
  void updateHighScore(int score) {
    if (score > highScore) {
      highScore = score; // if the user beats the previous high score, their score becomes the new high score
      saveHighScoreToFile(); // saves the new high score to the database
    }
  }

  public void displayHighScore() {
    window.textSize(20);
//    window.textAlign(LEFT);
    window.fill(255, 255, 255);
    window.text("High Score: " + highScore, 10, 30); // display the high score at position (10, 30)
  }

  int loadHighScoreFromFile() {
    return 0;
  }

  void saveHighScoreToFile() {
  }
}
