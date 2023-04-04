package org.bcit.comp2522.dui.client;

/**
 * Collidable interface, in use by Player.java
 */
public interface Collidable {
    boolean collide(Player player);
    boolean collide(EnemyCar enemyCar);
}
