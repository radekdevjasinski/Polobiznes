package com.mygdx.game;

public class CircleObject extends ShapeObject {
    private float radius;

    public CircleObject(float radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Rysowanie koła o promieniu " + radius);
    }

    @Override
    public void translate(float deltaX, float deltaY) {
        System.out.println("Przesunięcie koła o (" + deltaX + ", " + deltaY + ")");
    }

    @Override
    public void rotate(float degrees) {
        System.out.println("Obrót koła o " + degrees + " stopni");
    }

    @Override
    public void scale(float factor) {
        radius *= factor;
        System.out.println("Skalowanie koła o czynnik " + factor);
    }
}
