package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Klasa reprezentująca obiekt koła.
 */
public class CircleObject extends ShapeObject {
    private float x, y;
    private float radius;
    private float rotation;

    /**
     * Konstruktor obiektu koła.
     *
     * @param x      Współrzędna x środka koła.
     * @param y      Współrzędna y środka koła.
     * @param radius Promień koła.
     */
    public CircleObject( float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.rotation = 0;
    }

    /**
     * Metoda odpowiedzialna za rysowanie koła.
     */
    @Override
    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.identity();
        shapeRenderer.translate(x, y, 0);
        PrimitiveRenderer.drawCircle(shapeRenderer, 0, 0, radius, rotation, Color.BLACK);
        shapeRenderer.end();
    }

    /**
     * Metoda przesuwająca obiekt koła o zadane wartości delta x i delta y.
     *
     * @param deltaX Wartość przesunięcia względem osi x.
     * @param deltaY Wartość przesunięcia względem osi y.
     */
    @Override
    public void translate(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;
    }


    /**
     * Metoda obracająca obiekt koła o zadany kąt.
     *
     * @param degrees Kąt obrotu w stopniach.
     */
    @Override
    public void rotate(float degrees) {
        rotation += degrees;
    }

    /**
     * Metoda skalująca obiekt koła o zadany czynnik.
     *
     * @param factor Czynnik skalujący.
     */
    @Override
    public void scale(float factor) {
        radius *= factor;
    }
}
