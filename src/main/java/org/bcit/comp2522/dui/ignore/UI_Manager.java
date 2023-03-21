package org.bcit.comp2522.dui.ignore;


import org.bcit.comp2522.dui.client.Player;
import org.bcit.comp2522.dui.client.Window;
import org.bcit.comp2522.dui.ui.UI;

public class UI_Manager {
    private static UI_Manager uiManager1;
    private UI ui;
    Window window;
    private String curUser;
    private long curScore;
    private long userHighScore;
    private String highestScoreOwner;

    private long highestScore;

    private Player player;

    public UI_Manager(Window window) {
        ui = new UI(window);

    }
    private UI_Manager() {}

    public static UI_Manager getInstance() {
        if (uiManager1 == null) {
            uiManager1 = new UI_Manager();
            System.out.println("in here");
        }
        return uiManager1;
    }

    public void generateUI() {
        ui.init();
    }
    public void setHighScore(long score){}

    public String getCurUser(){

        return null;
    }

    public long getCurScore(){

        return 0;
    }

    public long getUserHighScore(){

        return 0;
    }

    public String getHighestScoreOwner(){

        return null;
    }

    public long getHighestScore(){

        return 0;
    }
}
