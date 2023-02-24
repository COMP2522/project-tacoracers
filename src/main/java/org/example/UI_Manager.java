package org.example;

import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;
public class UI_Manager {
    private UI_Manager uiManager;
    private String curUser;
    private long curScore;
    private long userHighScore;
    private String highestScoreOwner;

    private long highestScore;

    private Player player;

    private UI_Manager(){

    }

    public UI_Manager getInstance(){

        return null;
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
