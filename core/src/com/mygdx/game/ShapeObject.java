package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Klasa abstrakcyjna reprezentująca ogólny kształt.
 */
public abstract class ShapeObject extends GameObject implements DrawableObject, TransformableObject {
    protected ShapeRenderer shapeRenderer;

    /**
     * Konstruktor klasy ShapeObject.
     * Inicjalizuje obiekt ShapeRenderer.
     */
    public ShapeObject() {
        this.shapeRenderer = new ShapeRenderer();
    }

    /**
     * Metoda przesuwająca kształt o zadane wartości delta x i delta y.
     *
     * @param deltaX Wartość przesunięcia względem osi x.
     * @param deltaY Wartość przesunięcia względem osi y.
     */
    @Override
    public void translate(float deltaX, float deltaY) {
        // Implementacja w klasach dziedziczących
    }

    /**
     * Metoda obracająca kształt o zadany kąt.
     *
     * @param degrees Kąt obrotu w stopniach.
     */
    @Override
    public void rotate(float degrees) {
    }

    /**
     * Metoda skalująca kształt o zadany czynnik.
     *
     * @param factor Czynnik skalujący.
     */
    @Override
    public void scale(float factor) {
    }
}
