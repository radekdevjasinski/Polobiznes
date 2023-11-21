package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class ShapeObject extends GameObject implements DrawableObject, TransformableObject {
    protected ShapeRenderer shapeRenderer;
    public ShapeObject() {
        this.shapeRenderer = new ShapeRenderer();
    }
    @Override
    public void translate(float deltaX, float deltaY) {
    }

    @Override
    public void rotate(float degrees) {
    }

    @Override
    public void scale(float factor) {
    }
}
