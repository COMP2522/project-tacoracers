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
  public long highScore = 0;
  public long score = 0;
  Window window;
  // initial variables to work with, both for displaying and tracking score
  Manager manager;

  void setup() {
    highScore = loadHighScoreFromFile(); // load high score from database
  }

  void updateHighScore(int score) {
    if (score > highScore) {
      highScore = score; // if the user beats the previous high score, their score becomes the new high score
      saveHighScoreToFile(); // saves the new high score to the database
    }
  }

  int loadHighScoreFromFile() {
    return 0;
  }

  void saveHighScoreToFile() {
  }
}
