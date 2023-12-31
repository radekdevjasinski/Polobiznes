package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashMap;

public class CircleSquareDrawer {

    private ShapeRenderer shapeRenderer;
    private Viewport viewport;
    private static HashMap<String, CircleObject> circleMap;

    public CircleSquareDrawer(Viewport viewport) {
        this.viewport = viewport;
        this.shapeRenderer = new ShapeRenderer();
        circleMap = new HashMap<>();
        drawCirclesInSquare();
    }

    private void drawCirclesInSquare() {
        float squareSize = 450f; // Zwiększamy rozmiar kwadratu
        int circleCount = 40; // Ilość okręgów

        float startX = viewport.getWorldWidth() / 2 - squareSize / 2;
        float startY = viewport.getWorldHeight() / 2 - squareSize / 2;

        float step = squareSize / (circleCount / 4); // Zwiększamy krok między okręgami

        for (int i = 0; i < circleCount; i++) {
            float x, y;

            if (i < circleCount / 4) {
                x = startX + i * step;
                y = startY;
            } else if (i < circleCount / 2) {
                x = startX + squareSize;
                y = startY + (i - circleCount / 4) * step;
            } else if (i < circleCount * 3 / 4) {
                x = startX + squareSize - (i - circleCount / 2) * step;
                y = startY + squareSize;
            } else {
                x = startX;
                y = startY + squareSize - (i - circleCount * 3 / 4) * step;
            }

            CircleObject circle = new CircleObject(x, y, 0); // Przykładowy promień 10
            String circleId = "Circle_" + i;
            circleMap.put(circleId, circle);
        }
    }


    public void drawCircles() {
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (CircleObject circle : circleMap.values()) {
            shapeRenderer.setColor(Color.RED); // Przykładowy kolor czerwony
            PrimitiveRenderer.drawCircle(shapeRenderer, circle.getX(), circle.getY(), circle.getRadius(), 0, Color.RED);
        }

        shapeRenderer.end();
    }

    public static HashMap<String, CircleObject> getCircleMap() {
        return circleMap;
    }


}
