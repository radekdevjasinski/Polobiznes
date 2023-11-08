package com.mygdx.game;
import com.badlogic.gdx.graphics.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceRoll {
    public int posX;
    public int posY;
    public int value;
    public boolean active;
    public DiceRoll()
    {
        posX = 0;
        posY = 0;
        active = true;
        for(int i = 1; i <=6; i++)
        {
            value = i;
            String path = "dice_" + Integer.toString(i) + ".png";
        }
        Roll();
    }
    public void Roll()
    {
        Random rand = new Random();
        value = 1 + rand.nextInt(6);
    }
    public String pngPath()
    {
        return  "dice_" + Integer.toString(value) + ".png";
    }
}
