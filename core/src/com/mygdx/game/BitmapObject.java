package com.mygdx.game;

public abstract class BitmapObject implements DrawableObject, TransformableObject {
    protected BitmapHandler bitmapHandler;

    public BitmapObject(BitmapHandler bitmapHandler) {
        this.bitmapHandler = bitmapHandler;
    }

    @Override
    public void draw() {
    }
}