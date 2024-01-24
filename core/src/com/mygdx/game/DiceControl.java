package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DiceControl {
    DiceRoll diceRoll1;
    DiceRoll diceRoll2;
    public DiceControl()
    {
        diceRoll1 = new DiceRoll();
        diceRoll2 = new DiceRoll();
    }
    public void animate()
    {
        diceRoll1.animate();
        diceRoll2.animate();
    }
    public void draw(SpriteBatch batch)
    {
        batch.draw(diceRoll1.textures[diceRoll1.value-1], 790, 30);
        batch.draw(diceRoll1.textures[diceRoll2.value-1], 890, 30);
    }
    public void rollingSetup()
    {
        diceRoll1.RollingAnimation();
        diceRoll2.RollingAnimation();
    }
    public void roll()
    {
        diceRoll1.Roll();
        diceRoll2.Roll();
    }
    public int value()
    {
        return diceRoll1.value + diceRoll2.value;
    }
}
