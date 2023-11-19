package com.mygdx.game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PrimitiveRenderer{

    public void drawSquare(ShapeRenderer shapeRenderer,float x, float y, float size, Color color) {
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x - size / 2, y - size / 2, size, size);
    }
    public void drawTriangle(ShapeRenderer shapeRenderer,float x, float y, float size, Color color) {
        shapeRenderer.setColor(color);
        float halfSize = size / 2;
        shapeRenderer.triangle(x, y + halfSize, x - halfSize, y - halfSize, x + halfSize, y - halfSize);
    }
    public void drawCircle(ShapeRenderer shapeRenderer,float x, float y, float radius, Color color) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(x, y, radius);
    }
    public void drawLineAlgorithm(ShapeRenderer shapeRenderer, LineSegment lineSegment) {
        float dx = lineSegment.getEnd().getX() - lineSegment.getStart().getX();
        float dy = lineSegment.getEnd().getY() - lineSegment.getStart().getY();
        float steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xIncrement = dx / steps;
        float yIncrement = dy / steps;

        float x = lineSegment.getStart().getX();
        float y = lineSegment.getStart().getY();

        for (int i = 0; i <= steps; i++) {
            shapeRenderer.rect(x - 1, y - 1, 2, 2); // Rysowanie punktu o wymiarach 2x2 jako odcinek

            x += xIncrement;
            y += yIncrement;
        }
    }
    public void drawLine(ShapeRenderer shapeRenderer, LineSegment lineSegment, float size) {
        shapeRenderer.rectLine(lineSegment.getStart().getX(), lineSegment.getStart().getY(), lineSegment.getEnd().getX(), lineSegment.getEnd().getY(), size);
    }

}
