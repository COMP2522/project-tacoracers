package org.bcit.comp2522.dui.client;

/**
 * Collidable interface, in use by Player.java
 */
public interface Collidable {
    /**
     * Collide boolean.
     *
     * @param player the player
     * @return the boolean
     */
    boolean collide(Player player);

    /**
     * Collide boolean.
     *
     * @param enemyCar the enemy car
     * @return the boolean
     */
    boolean collide(EnemyCar enemyCar);
}
