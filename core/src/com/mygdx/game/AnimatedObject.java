package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class AnimatedObject implements Animation{
    float timeSeconds = 0;
    float animationTimer = 1;
    public void animate(){
        if(timeSeconds < animationTimer)
        {
            timeSeconds += Gdx.graphics.getDeltaTime();
        }
    }
}
