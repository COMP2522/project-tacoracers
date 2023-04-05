package org.bcit.comp2522.dui.ui;

import org.bcit.comp2522.dui.client.*;
import processing.core.PImage;
import processing.core.PVector;

import java.util.concurrent.atomic.AtomicBoolean;

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

    // menu instance
    private Menu menu;

    // player instance
    private Player player;

    // button instance
    private Button button;

    // manager instance
    private Manager manager;

    // instance for ui elements
    private Elements elements;

    // instance for the powerup
    private PowerUp powerup;

    // window instance
    private Window window;

    private Leaderboard leaderboard;


    /**
     * Constructor creating all objects.
     * @param manager manager
     * @param loader contentloader
     * @param scene window
     */
    public UI(Manager manager, ContentLoader loader, Window scene) {
        super(scene, manager, loader);
        this.manager = manager;
        this.player = new Player(manager, scene, new PVector(scene.width / 5, 327), playerWidth, playerHeight);
        this.traffic = new CarLinkedList<EnemyCar>();
        this.cars = new CarLinkedList<>();
        this.button = new Button(scene, manager);
        this.menu = new Menu(manager, scene);
        this.window = scene;
        this.leaderboard = new Leaderboard(manager, scene);


        PVector powerUpPosition = new PVector(window.width, (float) (Math.random() * (window.height - 240) + 140));
        this.powerup = new PowerUp(manager, scene, powerUpPosition, powerUpWidth, powerUpHeight, powerUpSpeed);

        loader.loadCarImages(cars);
        spawnCars(traffic);
    }


    // spawns most UI elements
    public void uiElements() {
        window.background(0);
        manager.game.start();
        borders();
        displayText(manager.contentLoader.getTinyFont(), window.LEFT,
                0, 0, 255, "Score: " + manager.game.score, 850, 75);
        displayText(manager.contentLoader.getTinyFont(), window.LEFT,
                0, 0, 255, "High Score: " + manager.game.score, 850, 45);

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
     * Checks for car overlap.
     * @param car EnemyCar
     * @param traffic CarLinkedList
     * @return t/f
     */
    private boolean carOverlap(EnemyCar car, CarLinkedList<EnemyCar> traffic) {
        float minDistance = 50; // Set the minimum distance between cars here.

        AtomicBoolean hasOverlap = new AtomicBoolean(false);
        traffic.forEach(otherCar -> {
            if (car.shouldStop(otherCar, minDistance)) {
                hasOverlap.set(true);
            }
        });

        return hasOverlap.get();
    }


    /**
     * Sets the EnemyCar positions.
     * @param traffic CarLinkedList
     */
    private void spawnCars(CarLinkedList<EnemyCar> traffic) {
        int numCars = 2;
        int numLanes = lanes.length;
        float carSpacing = window.width / numCars;

        for (int i = 0; i < numCars; i++) {
            for (int j = 0; j < numLanes; j++) {
                float carWidth = 140;
                float carHeight = 75;
                float carSpeed = (float) (Math.random() * 8 + 7);
                float xPos = i * carSpacing + carWidth / 2 + (carSpacing / 2 * j);
                EnemyCar car = new EnemyCar(manager, window, new PVector(xPos, lanes[j]), carWidth, carHeight, carSpeed, cars);

                // Adjust the car's position until it does not overlap with any existing car
                while (carOverlap(car, traffic)) {
                    xPos += 10; // Increase the X position until there is no overlap
                    car.getPosition().x = xPos;
                }

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
                    enemyCar.update(traffic);
                    enemyCar.draw();
                    traffic.forEach(enemyCar1 -> {
                        if (enemyCar1.collide2(enemyCar)) {
                            enemyCar1.setPosition(enemyCar.getPosition().x + 200, 0);
                        }
                    });
                    powerup.check(player);
                    player.check(enemyCar);
                    player.update(this);
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
                menu.carSelection();
                break;
            case 5:
                leaderboard.leaderboard();
                break;
            case 6:
                break;
        }
    }

    /**
     * Getter for the player
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Getter for the enemy car list
     * @return traffic
     */
    public CarLinkedList<EnemyCar> getTraffic() {
        return traffic;
    }

    /**
     * Getter for car images
     * @return cars
     */
    public CarLinkedList<PImage> getCars() {
        return cars;
    }

    /**
     * Getter for the powerup.
     * @return powerup
     */
    public PowerUp getPowerup() {
        return powerup;
    }

    public void init() {
        this.draw();
    }
}
