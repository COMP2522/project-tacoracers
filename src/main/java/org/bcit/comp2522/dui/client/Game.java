package org.bcit.comp2522.dui.client;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TODO: this
 *
 * @author Pavan Brar
 */
public class Game {
  private static Game theGame; // Static variable reference of theGame of type Singleton
  public long highScore = 0;
  public long score = 0;
  public int scoreIncrement = 10; // Score increment amount in each timer tick
  public int delay = 100;
  public String name = "Barack Obama"; // Temporary variable until user is able to input their name

  Window window;
  // initial variables to work with, both for displaying and tracking score
  Manager manager;

  Timer scoreTimer;

  public Game(Manager manager) {
    this.manager = manager;
  }

  private Game() {
    scoreTimer = new Timer(delay, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        updateScore();
//        System.out.println(score);
      }
    });
  }

  /**
   * For use when user is slowed
   * @param num int
   */
  public void setScoreIncrement(int num) {
    scoreIncrement = num;
  }

  /**
   * Getter for score increment
   * @return scoreIncrement
   */
  public int getScoreIncrement() {
    return scoreIncrement;
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

  int loadHighScoreFromFile() {
    return 0;
  }

  DatabaseHandler dbh = new DatabaseHandler("pavanbrar73", "KFmJyFJrTM6Dd7c2");
  public void saveHighScoreToFile() {
    dbh.put("name", name, "score", highScore);
  }

}
