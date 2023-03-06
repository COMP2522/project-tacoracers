package org.example;


import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;
import processing.event.KeyEvent;
import processing.core.*;


import java.awt.*;
public class UI_Manager extends UI {
    private static UI_Manager uiManager1;
    private UI ui;
    PApplet app;
    private String curUser;
    private long curScore;
    private long userHighScore;
    private String highestScoreOwner;

    private long highestScore;

    private Player player;

    UI_Manager() {
    }
    public void draw() {
        background(255);
        textFont(font,16);                  // STEP 3 Specify font to be used
        fill(0);                         // STEP 4 Specify font color
        text("Hello Strings!",10,100);   // STEP 5 Display Text
    }


    public static UI_Manager getInstance() {
        if (uiManager1 == null) {
            uiManager1 = new UI_Manager();
            System.out.println("in here");
        }
        return uiManager1;
    }

    public void generateUI(){

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
