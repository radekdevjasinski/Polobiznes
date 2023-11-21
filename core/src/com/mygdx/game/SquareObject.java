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
    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.identity();
        shapeRenderer.translate(x, y, 0);
        shapeRenderer.rotate(0, 0, 1, rotation);
        PrimitiveRenderer.drawSquare(shapeRenderer, -sideLength / 100, -sideLength / 100, sideLength, 0, Color.BLUE);
        shapeRenderer.end();
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