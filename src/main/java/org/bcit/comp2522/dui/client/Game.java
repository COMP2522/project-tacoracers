package org.bcit.comp2522.dui.client;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Scoring, using JSON data structure
 * Use processing elements to display text to ui
 *
 * Should work with Manager.java to track Game state (alive or dead)
 * If alive, compounding score, stop and write to JSON when dead
 * Display to UI, read current high score if there is one
 *
 * @author Pavan Brar
 */
public class Game {
  private static Game theGame; // Static variable reference of theGame of type Singleton
  public long highScore = 0;
  public long score = 0;
  public int scoreIncrement = 10; // Score increment amount in each timer tick

  Window window;
  // initial variables to work with, both for displaying and tracking score
  Manager manager;

  Timer scoreTimer;

  private Game() {
    scoreTimer = new Timer(100, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        updateScore();
//        System.out.println(score);
      }
    });
  }
  public void displayScore(Window window) {
    window.textFont(window.tinyFont);
    window.textAlign(window.LEFT);
    window.fill(0, 0, 255);
    window.text("Score: " + this.score, 900, 75); // display the score at position (, )
  }
  public void displayHighScore(Window window) {
    window.textFont(window.tinyFont);
    window.textAlign(window.LEFT);
    window.fill(0, 0, 255);
    window.text("High Score: " + this.highScore, 900, 45); // display the high score at position (, )
  }

  public void start() {
    scoreTimer.start();
  }

  // Static method to create instance of Singleton class
  public static Game getInstance() {
    if (theGame == null) {
      theGame = new Game();
    }
    return theGame;
  }

  void setup() {
    highScore = loadHighScoreFromFile(); // load high score from database
  }


  public void updateScore() {
    score += scoreIncrement; // Increment the score by the scoreIncrement amount
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

  public static void main(String[] args) {

  }
}
