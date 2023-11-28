package com.mygdx.game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


/**
 * Klasa reprezentująca obiekt kwadratu.
 */
public class SquareObject extends ShapeObject {
    private float x, y, rotation;
    private float sideLength;

    /**
     * Konstruktor obiektu kwadratu.
     *
     * @param x           Współrzędna x środka kwadratu.
     * @param y           Współrzędna y środka kwadratu.
     * @param sideLength  Długość boku kwadratu.
     */
    public SquareObject(float x, float y,float sideLength) {
        this.x = x;
        this.y = y;
        this.sideLength = sideLength;
        this.rotation = 0;
    }

    /**
     * Metoda odpowiedzialna za rysowanie kwadratu.
     */
    @Override
    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.identity();
        shapeRenderer.translate(x, y, 0);
        PrimitiveRenderer.drawSquare(shapeRenderer, -sideLength / 100, -sideLength / 100, sideLength, rotation, Color.BLUE);
        shapeRenderer.end();
    }

    /**
     * Metoda przesuwająca obiekt kwadratu o zadane wartości delta x i delta y.
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
     * Metoda obracająca obiekt kwadratu o zadany kąt.
     *
     * @param degrees Kąt obrotu w stopniach.
     */
    @Override
    public void rotate(float degrees) {
        rotation += degrees;
    }


    /**
     * Metoda skalująca obiekt kwadratu o zadany czynnik.
     *
     * @param factor Czynnik skalujący.
     */
    @Override
    public void scale(float factor) {
        sideLength *= factor;
    }
}