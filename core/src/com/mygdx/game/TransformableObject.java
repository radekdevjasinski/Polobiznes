package com.mygdx.game;

public interface TransformableObject {
    void translate(float deltaX, float deltaY);
    void rotate(float degrees);
    void scale(float factor);
}
