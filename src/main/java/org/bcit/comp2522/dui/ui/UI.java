package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.*;
import processing.core.PImage;
import processing.core.PVector;

/**
 * UI controls in what orders players see content.
 * It also sets player and EnemyCar properties.
 *
 * @author Eric Tatchell
 */
public class UI extends Elements implements Drawable {

  // 3 main lanes
  private final float[] lanes = {140, 327, 515};

  // linked list of potential car images
  private CarLinkedList<PImage> cars;

  // linked list of enemycars
  private CarLinkedList<EnemyCar> traffic;

  // default player width
  private float playerWidth = 140;

  // default player width
  private float playerHeight = 75;

  // default powerup width
  private float powerUpWidth = 100;

  // default powerup height
  private float powerUpHeight = 100;

  // default powerup speed
  private float powerUpSpeed = 20;

  private final int hardcoreScore = 10000;

  // menu instance
  private final Menu menu;

  private final CarSelection carselect;
  private final BikeSelection bikeselect;
  private final TruckSelection truckselect;
  private final Difficulty difficulty;

  // player instance
  private final Player player;

  // button instance
  private Button button;

  // manager instance
  private final Manager manager;

  // instance for ui elements
  private Elements elements;

  // instance for the powerup
  private final PowerUp powerup;

  // window instance
  private final Window window;

  // leaderboard instance
  private final Leaderboard leaderboard;

  // instruction instance
  private final Instruction instruction;


  /**
   * Constructor creating all objects.
   *
   * @param manager manager
   * @param loader  contentloader
   * @param scene   window
   */
  public UI(Manager manager, ContentLoader loader, Window scene) {
    super(scene, manager, loader);
    this.manager = manager;
    this.player = new Player(manager, scene,
            new PVector(scene.width / 5, 327), playerWidth, playerHeight);
    this.traffic = new CarLinkedList<EnemyCar>();
    this.cars = new CarLinkedList<>();
    this.button = new Button(scene, manager);
    this.menu = new Menu(manager, scene);
    this.window = scene;
    this.leaderboard = new Leaderboard(manager, scene);
    this.instruction = new Instruction(manager, scene);
    this.carselect = new CarSelection(manager, scene);
    this.bikeselect = new BikeSelection(manager, scene);
    this.truckselect = new TruckSelection(manager, scene);
    this.difficulty = new Difficulty(manager, scene);


    PVector powerUpPosition = new PVector(window.width,
            (float) (Math.random() * (window.height - 240) + 140));
    this.powerup = new PowerUp(manager, scene,
            powerUpPosition, powerUpWidth, powerUpHeight, powerUpSpeed);

    loader.loadCarImages(cars);
    spawnCars(traffic);
  }


  /**
   * Ui elements.
   */
// spawns most UI elements
  public void uiElements() {
    manager.game.start();
    borders();
    displayText(manager.contentLoader.getTinyFont(), window.LEFT,
            0, 0, 255, "Score: " + manager.game.score, 850, 75);
    displayText(manager.contentLoader.getTinyFont(), window.LEFT,
            0, 0, 255, "High Score: " + manager.game.highScore, 850, 45);

    muteButton();
    manager.path.drawLines();
    manager.managePowerUp(powerup);
    powerup.update();
    powerup.draw();
    player.displayHealth();
    player.draw();
  }

  /**
   * Sets the powerups position.
   *
   * @param powerup PowerUp
   */
  public void spawnPowerUp(PowerUp powerup) {
    if (!powerup.isActive()) {
      float x = window.width;
      float y = (float) (Math.random() * (window.height - 240) + 140);
      powerup.getPosition().set(x, y);
      powerup.setActive(true);
    }
  }



  /**
   * Sets the EnemyCar positions.
   *
   * @param traffic CarLinkedList
   */
  private void spawnCars(CarLinkedList<EnemyCar> traffic) {
    int numCars = 2;
    for (int i = 0; i < numCars; i++) {
      for (float lane : lanes) {
        float carWidth = 140;
        float carHeight = 75;
        float carSpeed = (float) (Math.random() * 8 + 7);
        int xPos = (int) (Math.random() * 2560);
        EnemyCar car = new EnemyCar(manager, window, new PVector(xPos, lane),
                carWidth, carHeight, carSpeed, cars);
        traffic.add(car);
      }
    }
  }


  // UI drawing
  @Override
  public void draw() {
    switch (manager.screenState) {
      case 0:
        uiElements();
        traffic.forEach(enemyCar -> {
          // manager.toggleHardcoreMode((int) manager.game.score, enemyCar, manager.path);
          enemyCar.update(traffic);
          enemyCar.draw();
          enemyCar.collide(traffic);
          powerup.check(player);
          player.check(enemyCar, traffic);
          player.update();
        });
        break;
      case 1:
        menu.gameOver();
        break;
      case 2:
        menu.main();
        break;
      case 3:
        menu.menu2();
        break;
      case 4:
        if (manager.diffState == 1) {
          bikeselect.bikeSelection();
        } else if (manager.diffState == 2) {
          carselect.carSelect();
        } else if (manager.diffState == 3) {
          truckselect.truckSelection();
        }

        break;
      case 5:
        leaderboard.leaderboard();
        break;
      case 6:
        difficulty.difficulty();
        break;
      case 7:
        instruction.instruction();
    }
  }

  /**
   * Getter for the player.
   *
   * @return player
   */
  public Player getPlayer() {
    return player;
  }

  /**
   * Getter for the enemy car list.
   *
   * @return traffic
   */
  public CarLinkedList<EnemyCar> getTraffic() {
    return traffic;
  }

  /**
   * Getter for car images.
   *
   * @return cars
   */
  public CarLinkedList<PImage> getCars() {
    return cars;
  }

  /**
   * Getter for the powerup.
   *
   * @return powerup powerup
   */
  public PowerUp getPowerup() {
    return powerup;
  }

  /**
   * Init.
   */
  public void init() {
    this.draw();
  }
}
