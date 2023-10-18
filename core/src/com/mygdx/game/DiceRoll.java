package com.mygdx.game;
import com.badlogic.gdx.graphics.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceRoll {
    public int posX;
    public int posY;
    public boolean active;
    public List<Texture> pngs;
    public Texture rollTexture;
    public int value;
    public DiceRoll()
    {
        posX = 0;
        posY = 0;
        active = true;
        pngs = new ArrayList<>();
        for(int i = 1; i <=6; i++)
        {
            String path = "dice_" + Integer.toString(i) + ".png";
            pngs.add(new Texture(path));
        }
        Roll();
    }
    public void Roll()
    {
        Random rand = new Random();
        rollTexture =  pngs.get(rand.nextInt(pngs.size()));
    }
}
