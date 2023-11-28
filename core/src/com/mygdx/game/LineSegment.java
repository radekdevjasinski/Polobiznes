package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Klasa LineSegment reprezentuje odcinek linii między dwoma punktami w przestrzeni 2D.
 */
public class LineSegment {

    /** Początkowy punkt odcinka. */
    private Point2D start;

    /** Końcowy punkt odcinka. */
    private Point2D end;

    /**
     * Konstruktor klasy LineSegment.
     *
     * @param start Początkowy punkt odcinka.
     * @param end   Końcowy punkt odcinka.
     */
    public LineSegment(Point2D start, Point2D end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Pobiera początkowy punkt odcinka.
     *
     * @return Początkowy punkt odcinka.
     */
    public Point2D getStart() {
        return start;
    }

    /**
     * Pobiera końcowy punkt odcinka.
     *
     * @return Końcowy punkt odcinka.
     */
    public Point2D getEnd() {
        return end;
    }

    /**
     * Ustawia początkowy punkt odcinka.
     *
     * @param start Nowy początkowy punkt odcinka.
     */
    public void setStart(Point2D start) {
        this.start = start;
    }

    /**
     * Ustawia końcowy punkt odcinka.
     *
     * @param end Nowy końcowy punkt odcinka.
     */
    public void setEnd(Point2D end) {
        this.end = end;
    }

    /**
     * Ustawia oba końce odcinka.
     *
     * @param start Nowy początkowy punkt odcinka.
     * @param end   Nowy końcowy punkt odcinka.
     */
    public void setSegment(Point2D start, Point2D end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Zwraca reprezentację tekstową obiektu LineSegment.
     *
     * @return Tekstowa reprezentacja obiektu LineSegment.
     */
    @Override
    public String toString() {
        return "LineSegment{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
