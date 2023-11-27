package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Klasa Point2D reprezentuje punkt w przestrzeni 2D o współrzędnych (x, y).
 */
public class Point2D {

    /** Współrzędna x punktu. */
    private float x;

    /** Współrzędna y punktu. */
    private float y;

    /**
     * Konstruktor klasy Point2D.
     *
     * @param x Współrzędna x punktu.
     * @param y Współrzędna y punktu.
     */
    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Pobiera współrzędną x punktu.
     *
     * @return Współrzędna x punktu.
     */
    public float getX() {
        return x;
    }

    /**
     * Pobiera współrzędną y punktu.
     *
     * @return Współrzędna y punktu.
     */
    public float getY() {
        return y;
    }

    /**
     * Ustawia współrzędną x punktu.
     *
     * @param x Nowa współrzędna x punktu.
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Ustawia współrzędną y punktu.
     *
     * @param y Nowa współrzędna y punktu.
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Zwraca reprezentację tekstową obiektu Point2D.
     *
     * @return Tekstowa reprezentacja obiektu Point2D.
     */
    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
