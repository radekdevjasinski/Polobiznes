package com.mygdx.game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SquareObject extends ShapeObject {
    private float x, y, rotation;
    private float sideLength;
    public SquareObject(float x, float y,float sideLength) {
        this.x = x;
        this.y = y;
        this.sideLength = sideLength;
        this.rotation = 0;
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        PrimitiveRenderer.drawSquare(shapeRenderer, x, y, sideLength, rotation, Color.BLUE);
    }

    @Override
    public void translate(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public void rotate(float degrees) {
        rotation += degrees;
    }

    @Override
    public void scale(float factor) {
        sideLength *= factor;
    }
}