package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CircleObject extends ShapeObject {
    private float x, y;
    private float radius;
    private float rotation;
    public CircleObject( float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.rotation = 0;
    }

    @Override
    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.identity();
        shapeRenderer.translate(x, y, 0);
        shapeRenderer.rotate(0, 0, 1, rotation);
        PrimitiveRenderer.drawCircle(shapeRenderer, 0, 0, radius, 0, Color.BLACK);
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
        radius *= factor;
    }
}
