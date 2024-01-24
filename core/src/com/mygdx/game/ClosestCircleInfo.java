package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class ClosestCircleInfo {

    private CircleSquareDrawer circleSquareDrawer;
    private BitmapFont font;
    private CircleObject closestCircle;

    public ClosestCircleInfo(CircleSquareDrawer circleSquareDrawer) {
        this.circleSquareDrawer = circleSquareDrawer;
        this.font = new BitmapFont();
        this.font.setColor(Color.BLACK);
    }

    public void updateClosestCircleInfo(float mouseX, float mouseY) {
        CircleObject newClosestCircle = findClosestCircle(mouseX, mouseY);

        if (closestCircle == null || !closestCircle.equals(newClosestCircle)) {
            closestCircle = newClosestCircle;
            int closestCircleId = getClosestCircleId(closestCircle);
            //Gdx.app.log("Debug", "Closest Circle ID: " + closestCircleId);
        }
    }
    public void drawClosestCircleInfo(SpriteBatch spriteBatch, float touchX, float touchY) {
        if (closestCircle != null) {
            Integer closestCircleId = getClosestCircleId(closestCircle);
            font.draw(spriteBatch, "Closest Circle ID: " + closestCircleId, 20, 20);
        }
    }

    public CircleObject findClosestCircle(float touchX, float touchY) {
        return findClosestCircleForMouse(touchX, touchY);
    }

    public CircleObject findClosestCircleForMouse(float mouseX, float mouseY) {
        CircleObject closestCircle = null;
        float closestDistance = Float.MAX_VALUE;

        for (CircleObject circle : circleSquareDrawer.getCircleMap().values()) {
            float distance = calculateDistance(mouseX, mouseY, circle.getX(), circle.getY());
            if (distance < closestDistance) {
                closestDistance = distance;
                closestCircle = circle;
            }
        }
        //Gdx.app.log("Debug", "Closest Circle: " + closestCircle);
        return closestCircle;
    }

    private float calculateDistance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private Integer getClosestCircleId(CircleObject closestCircle) {
        for (HashMap.Entry<Integer, CircleObject> entry : circleSquareDrawer.getCircleMap().entrySet()) {
            if (entry.getValue().equals(closestCircle)) {
                return entry.getKey();
            }
        }
        System.out.println("Closest circle not found.");
        return null;
    }
}
