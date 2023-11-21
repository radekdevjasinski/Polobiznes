package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class PrimitiveRenderer {

    public static void drawSquare(ShapeRenderer shapeRenderer, float x, float y, float size, float rotation, Color color) {
        shapeRenderer.setColor(color);
        shapeRenderer.rotate(0, 0, 1, rotation);
        shapeRenderer.rect(x - size / 2, y - size / 2, size, size);
    }

    public static void drawTriangle(ShapeRenderer shapeRenderer, float x, float y, float size, Color color) {
        shapeRenderer.setColor(color);
        float halfSize = size / 2;
        shapeRenderer.triangle(x, y + halfSize, x - halfSize, y - halfSize, x + halfSize, y - halfSize);
    }

    public static void drawCircle(ShapeRenderer shapeRenderer, float x, float y, float radius, float rotation, Color color) {
        shapeRenderer.setColor(color);
        shapeRenderer.rotate(0, 0, 1, rotation);
        shapeRenderer.circle(x, y, radius);
    }

    public static void drawLineAlgorithm(ShapeRenderer shapeRenderer, LineSegment lineSegment) {
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

    public static void drawLine(ShapeRenderer shapeRenderer, LineSegment lineSegment, float size) {
        shapeRenderer.rectLine(lineSegment.getStart().getX(), lineSegment.getStart().getY(), lineSegment.getEnd().getX(), lineSegment.getEnd().getY(), size);
    }

    public static void drawCircleWithSymmetry(ShapeRenderer shapeRenderer, Point2D point2D, float radius, int segments) {
        float angleIncrement = 360.0f / segments;

        for (float angle = 0; angle < 360; angle += angleIncrement) {
            float x1 = point2D.getX() + radius * (float) Math.cos(Math.toRadians(angle));
            float y1 = point2D.getY() + radius * (float) Math.sin(Math.toRadians(angle));

            float x2 = point2D.getX() + radius * (float) Math.cos(Math.toRadians(angle + 180));
            float y2 = point2D.getY() + radius * (float) Math.sin(Math.toRadians(angle + 180));

            float x3 = point2D.getX() + radius * (float) Math.cos(Math.toRadians(angle + 90));
            float y3 = point2D.getY() + radius * (float) Math.sin(Math.toRadians(angle + 90));

            float x4 = point2D.getX() + radius * (float) Math.cos(Math.toRadians(angle + 270));
            float y4 = point2D.getY() + radius * (float) Math.sin(Math.toRadians(angle + 270));

            shapeRenderer.circle(x1, y1, 2); // rysowanie punktu zamiast segmentu dla lepszej widoczności
            shapeRenderer.circle(x2, y2, 2);
            shapeRenderer.circle(x3, y3, 2);
            shapeRenderer.circle(x4, y4, 2);
        }
    }

    public static void drawEllipseWithSymmetry(ShapeRenderer shapeRenderer, Point2D point2D, float rx, float ry, int segments) {
        float angleIncrement = 360.0f / segments;

        for (float angle = 0; angle < 360; angle += angleIncrement) {
            float x1 = point2D.getX() + rx * (float) Math.cos(Math.toRadians(angle));
            float y1 = point2D.getY() + ry * (float) Math.sin(Math.toRadians(angle));

            float x2 = point2D.getX() + rx * (float) Math.cos(Math.toRadians(angle + 180));
            float y2 = point2D.getY() + ry * (float) Math.sin(Math.toRadians(angle + 180));

            float x3 = point2D.getX() + rx * (float) Math.cos(Math.toRadians(angle + 90));
            float y3 = point2D.getY() + ry * (float) Math.sin(Math.toRadians(angle + 90));

            float x4 = point2D.getX() + rx * (float) Math.cos(Math.toRadians(angle + 270));
            float y4 = point2D.getY() + ry * (float) Math.sin(Math.toRadians(angle + 270));

            shapeRenderer.circle(x1, y1, 2);
            shapeRenderer.circle(x2, y2, 2);
            shapeRenderer.circle(x3, y3, 2);
            shapeRenderer.circle(x4, y4, 2);
        }
    }

    public static void drawPolygon(ShapeRenderer shapeRenderer, Array<Point2D> points) {
        if (points.size < 3) {
            System.out.println("Wielokąt musi składać się z co najmniej trzech punktów.");
            return;
        }

        shapeRenderer.setColor(Color.BLACK);

        for (int i = 0; i < points.size; i++) {
            Point2D startPoint = points.get(i);
            Point2D endPoint = points.get((i + 1) % points.size);
            //shapeRenderer.line(, );
            shapeRenderer.rectLine(new Vector2(startPoint.getX(), startPoint.getY()), new Vector2(endPoint.getX(), endPoint.getY()),2);
        }
    }
    public static void boundryFill(Point2D point, Color fillColor, Color boundryColor)
    {
        Color pixelColor = getPixelColor((int)point.getX(),(int)point.getY());
        if (pixelColor == fillColor)
            return;
        if (pixelColor != boundryColor)
        {
            changePixelColor((int)point.getX(),(int)point.getY(),fillColor);
            boundryFill(new Point2D((int)point.getX(), (int)point.getY()+1), fillColor, boundryColor);
            boundryFill(new Point2D((int)point.getX(), (int)point.getY()-1), fillColor, boundryColor);
            boundryFill(new Point2D((int)point.getX()-1, (int)point.getY()), fillColor, boundryColor);
            boundryFill(new Point2D((int)point.getX()+1, (int)point.getY()), fillColor, boundryColor);
        }
    }
    public static void floodFill(Point2D point, Color fillColor, Color backgroundColor)
    {
        Color pixelColor = getPixelColor((int)point.getX(),(int)point.getY());
        if (pixelColor == fillColor)
            return;
        if (pixelColor == backgroundColor)
        {
            changePixelColor((int)point.getX(),(int)point.getY(),fillColor);
            boundryFill(new Point2D((int)point.getX(), (int)point.getY()+1), fillColor, backgroundColor);
            boundryFill(new Point2D((int)point.getX(), (int)point.getY()-1), fillColor, backgroundColor);
            boundryFill(new Point2D((int)point.getX()-1, (int)point.getY()), fillColor, backgroundColor);
            boundryFill(new Point2D((int)point.getX()+1, (int)point.getY()), fillColor, backgroundColor);
        }
    }
    private static Color getPixelColor(int x, int y) {
        Pixmap pixmap = Pixmap.createFromFrameBuffer(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        if (x >= 0 && x < pixmap.getWidth() && y >= 0 && y < pixmap.getHeight()) {
            int pixel = pixmap.getPixel(x, y);
            Color color = new Color();
            Color.rgba8888ToColor(color, pixel);
            return color;
        } else {
            return Color.CLEAR;
        }
    }
    private static void changePixelColor(int x, int y, Color newColor) {
        Pixmap pixmap = Pixmap.createFromFrameBuffer(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        if (x >= 0 && x < pixmap.getWidth() && y >= 0 && y < pixmap.getHeight()) {
            int colorInt = Color.rgba8888(newColor);
            pixmap.drawPixel(x, y, colorInt);
        }
    }

}
