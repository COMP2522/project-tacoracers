package org.bcit.comp2522.dui.client;

public class Sprite_Manager extends Window {
    private static Sprite_Manager spriteManager;
    public Sprite[] sprites;
    private Sprite_Manager() {}
    public static Sprite_Manager getInstance() {
        if (spriteManager == null) {
            spriteManager = new Sprite_Manager();
        }
        return spriteManager;
    }
}
