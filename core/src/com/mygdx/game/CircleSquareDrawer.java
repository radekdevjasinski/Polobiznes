package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashMap;

public class CircleSquareDrawer {

    private ShapeRenderer shapeRenderer;
    private Viewport viewport;
    private HashMap<String, CircleObject> circleMap;

    public CircleSquareDrawer(Viewport viewport) {
        this.viewport = viewport;
        this.shapeRenderer = new ShapeRenderer();
        this.circleMap = new HashMap<>();
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
                x = startX + squareSize; // Zmieniamy kierunek rysowania dla pierwszej ćwiartki
                y = startY + i * step;
            } else if (i < circleCount / 2) {
                x = startX + squareSize - ((i - circleCount / 4) * step); // Zmieniamy kierunek rysowania dla drugiej ćwiartki
                y = startY + squareSize;
            } else if (i < circleCount * 3 / 4) {
                x = startX; // Zmieniamy kierunek rysowania dla trzeciej ćwiartki
                y = startY + squareSize - (i - circleCount / 2) * step;
            } else {
                x = startX + (i - circleCount * 3 / 4) * step; // Zmieniamy kierunek rysowania dla czwartej ćwiartki
                y = startY;
            }

            // Odwracamy kolejność id zgodnie z kierunkiem zegara
            int reversedId = (circleCount - i) % circleCount;

            CircleObject circle = new CircleObject(x, y, 5); // Przykładowy promień 10
            String circleId = "Circle_" + reversedId;
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

    public HashMap<String, CircleObject> getCircleMap() {
        return circleMap;
    }


}
