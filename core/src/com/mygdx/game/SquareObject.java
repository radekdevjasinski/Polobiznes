package com.mygdx.game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SquareObject extends ShapeObject {
    private float x, y;
    private float sideLength;

    public SquareObject(float x, float y,float sideLength) {
        this.x = x;
        this.y = y;
        this.sideLength = sideLength;
    }

    @Override
    public void draw() {
    }

    @Override
    public void translate(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public void rotate(float degrees) {
    }

    @Override
    public void scale(float factor) {
        sideLength *= factor;
    }
}