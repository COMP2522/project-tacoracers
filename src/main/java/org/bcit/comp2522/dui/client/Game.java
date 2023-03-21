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
  Window window;
  // initial variables to work with, both for displaying and tracking score
  Manager manager;
}
