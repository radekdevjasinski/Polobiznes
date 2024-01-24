package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CircleSquareDrawer {

    private ShapeRenderer shapeRenderer;
    private Viewport viewport;
    private static HashMap<Integer, CircleObject> circleMap;

    public CircleSquareDrawer(Viewport viewport) {
        this.viewport = viewport;
        this.shapeRenderer = new ShapeRenderer();
        circleMap = new HashMap<>();
        drawCirclesInSquare();
        loadCityCardsFromFile("D:/PoloBiznesNew/assets/kartyMiast.txt");
    }
    public CircleSquareDrawer(Viewport viewport, ShapeRenderer shapeRenderer) {
        this.viewport = viewport;
        this.shapeRenderer = shapeRenderer;
        circleMap = new HashMap<>();
        drawCirclesInSquare();
        loadCityCardsFromFile("D:/PoloBiznesNew/assets/kartyMiast.txt");
    }

    private void drawCirclesInSquare() {
        float squareSize = 450f;
        int circleCount = 40;

        float startX = viewport.getWorldWidth() / 2 + squareSize / 2;
        float startY = viewport.getWorldHeight() / 2 - squareSize / 2;

        float step = squareSize / (circleCount / 4);

        for (int i = 0; i < circleCount; i++) {
            float x, y;

            if (i < circleCount / 4) {
                x = startX - i * step;
                y = startY;
            } else if (i < circleCount / 2) {
                x = startX - squareSize;
                y = startY + (i - circleCount / 4) * step;
            } else if (i < circleCount * 3 / 4) {
                x = startX - squareSize + (i - circleCount / 2) * step;
                y = startY + squareSize;
            } else {
                x = startX;
                y = startY + squareSize - (i - circleCount * 3 / 4) * step;
            }

            CircleObject circle = new CircleObject(x, y, 0);
            circleMap.put(i, circle);
        }
    }

    public void drawCircles() {
        shapeRenderer.end();
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (CircleObject circle : circleMap.values()) {
            shapeRenderer.setColor(Color.RED); // Przykładowy kolor czerwony
            PrimitiveRenderer.drawCircle(shapeRenderer, circle.getX(), circle.getY(), circle.getRadius(), 0, Color.RED);
        }

        shapeRenderer.end();
    }
    public void updateCircleInfo() {
        drawCirclesInSquare(); // Aktualizujemy informacje o kółkach
    }

    public static HashMap<Integer, CircleObject> getCircleMap() {
        return circleMap;
    }

    public boolean isMouseNearCircle(int mouseX, int mouseY, float maxDistance) {
        for (CircleObject circle : circleMap.values()) {
            float distance = calculateDistance(mouseX, mouseY, circle.getX(), circle.getY());

            if (distance < maxDistance) {
                return true;
            }
        }

        return false;
    }

    private float calculateDistance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    public void loadCityCardsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentCircleId = 0;

            while ((line = br.readLine()) != null) {
                String[] cardInfo = line.split(";");
                if (currentCircleId < circleMap.size()) {
                    if (!cardInfo[0].equals("-")) {
                        Card cityCard = readCityCardFromLine(cardInfo);
                        circleMap.get(currentCircleId).setCityCard(cityCard);
                    }
                }

                currentCircleId++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Card readCityCardFromLine(String[] cardInfo) {
        String nameCity = cardInfo[0];
        String nameState = cardInfo[1];
        int costOfPurchase = Integer.parseInt(cardInfo[2]);
        int costPerCottage = Integer.parseInt(cardInfo[3]);
        int costForHotel = Integer.parseInt(cardInfo[4]);
        int parkingCost = Integer.parseInt(cardInfo[5]);
        int costWithTheHouse1 = Integer.parseInt(cardInfo[6]);
        int costWithTheHouse2 = Integer.parseInt(cardInfo[7]);
        int costWithTheHouse3 = Integer.parseInt(cardInfo[8]);
        int costWithTheHouse4 = Integer.parseInt(cardInfo[9]);
        int costWithTheHotel = Integer.parseInt(cardInfo[10]);
        int mortgage = Integer.parseInt(cardInfo[11]);
        int color = Integer.parseInt(cardInfo[12]);

        return new Card(nameCity, nameState, costOfPurchase, costPerCottage, costForHotel, parkingCost,
                costWithTheHouse1, costWithTheHouse2, costWithTheHouse3, costWithTheHouse4,
                costWithTheHotel, mortgage, color);
    }
    public Train readTrainFromLine(String[] trainInfo) {
        String trainName = trainInfo[0];
        int costOfPurchase = Integer.parseInt(trainInfo[1]);
        int earningOneStation = Integer.parseInt(trainInfo[2]);
        int earningTwoStations = Integer.parseInt(trainInfo[3]);
        int earningThreeStations = Integer.parseInt(trainInfo[4]);
        int earningFourStations = Integer.parseInt(trainInfo[5]);

        return new Train(trainName, costOfPurchase, earningOneStation, earningTwoStations, earningThreeStations, earningFourStations);
    }
    public Shop readShopFromLine(String[] shopInfo) {
        String shopName = shopInfo[0];
        int costOfPurchase = Integer.parseInt(shopInfo[1]);
        int earningsFromAnotherPlayer = Integer.parseInt(shopInfo[2]);

        return new Shop(shopName, costOfPurchase, earningsFromAnotherPlayer);
    }


}
