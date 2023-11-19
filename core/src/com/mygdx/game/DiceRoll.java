package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mygdx.game.Engine.resizeTexture;

public class DiceRoll {
    public int posX;
    public int posY;
    public int value;
    public boolean active;
    public Texture[] textures;
    public DiceRoll()
    {
        posX = 0;
        posY = 0;
        active = true;
        textures = new Texture[6];
        for(int i = 0; i < 6; i++)
        {
            value = i+1;
            String path = "dice_" + Integer.toString(value) + ".png";
            textures[i] = resizeTexture(path, 100, 100);
        }
        Roll();
    }
    public void Roll()
    {
        Random rand = new Random();
        value = 1 + rand.nextInt(5);
    }
}
