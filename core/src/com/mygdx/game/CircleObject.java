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
    public void draw(ShapeRenderer shapeRenderer) {
        PrimitiveRenderer.drawCircle(shapeRenderer,x,y,radius,rotation, Color.BLACK);
    }

    @Override
    public void translate(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public void rotate(float degrees) {
        System.out.println("Obrót koła o " + degrees + " stopni");
    }

    @Override
    public void scale(float factor) {
        radius *= factor;
    }
}
