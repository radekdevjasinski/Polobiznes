package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceRoll extends AnimatedObject {
    public int posX;
    public int posY;
    public int value;
    public boolean active;
    public Texture[] textures;
    public DiceRoll()
    {
        super();
        posX = 0;
        posY = 0;
        active = true;
        textures = new Texture[6];
        for(int i = 0; i < 6; i++)
        {
            value = i+1;
            String path = "dice_" + Integer.toString(value) + ".png";
            textures[i] = BitmapHandler.resizeTexture(path, 100, 100);
        }
        Roll();
    }
    public void Roll()
    {
        Random rand = new Random();
        value = 1 + rand.nextInt(5);
    }
    public void RollingAnimation()
    {
        Random r = new Random();
        timeSeconds = 0;
        animationTimer = 1 + r.nextFloat(1f);
    }
    public void animate(){
        if(timeSeconds < animationTimer)
        {
            timeSeconds += Gdx.graphics.getDeltaTime();
            Roll();
        }
    }
}
