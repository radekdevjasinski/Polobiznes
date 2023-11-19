package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class LineSegment {
    private Point2D start;
    private Point2D end;

    public LineSegment(Point2D start, Point2D end) {
        this.start = start;
        this.end = end;
    }

    public Point2D getStart() {
        return start;
    }

    public Point2D getEnd() {
        return end;
    }

    public void setStart(Point2D start) {
        this.start = start;
    }

    public void setEnd(Point2D end) {
        this.end = end;
    }

    public void setSegment(Point2D start, Point2D end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "LineSegment{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
