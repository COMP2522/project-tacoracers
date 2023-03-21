package org.bcit.comp2522.dui.ignore;

import org.bcit.comp2522.dui.client.Sprite;
import org.bcit.comp2522.dui.client.Window;

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

    public void init() {

    }
}
