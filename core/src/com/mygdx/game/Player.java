package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca gracza w grze.
 */
public class Player{

    int id;
    int cash;
    String name;
    int currentCircleId;
    SpriteObject sprite;
    List<Card> cards;
    List<Train> trains;
    List<Shop> shops;
    int turnsInPrison;

    public Player(int id, int cash, String name) {
        this.id = id;
        this.cash = cash;
        this.name = name;
        this.currentCircleId = 0;
        cards = new ArrayList<>();
        trains = new ArrayList<>();
        shops = new ArrayList<>();
        turnsInPrison = 0;

        sprite = new SpriteObject("pionek_" + this.id + ".bmp", 0);
    }
    public void setCurrentCircleId(int circleId) {
        this.currentCircleId = circleId;
    }

    public int getCurrentCircleId() {
        return currentCircleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void changeMoney(int amount)
    {
        this.cash += amount;
    }
    public void teleport(int id)
    {
        this.currentCircleId = id;
    }

    public SpriteObject getSprite() {
        return sprite;
    }

    public void setSprite(SpriteObject sprite) {
        this.sprite = sprite;
    }

    public static void movePlayer(Player player, int id, CircleSquareDrawer circleSquareDrawer) {
        float circleX = CircleSquareDrawer.circleMap.get(id).getX();
        float circleY = CircleSquareDrawer.circleMap.get(id).getY();
            float randomAngle = MathUtils.random(360);
            float randomRadius = MathUtils.random(0, 6);
            float playerX = 0;
            float playerY = 0;
            if (player.getCurrentCircleId() >= 1 && player.getCurrentCircleId() <= 10) {
                playerX = circleX + 20 + MathUtils.cosDeg(randomAngle) * randomRadius;
                playerY = circleY + 5 + MathUtils.sinDeg(randomAngle) * randomRadius;
            } else if (player.getCurrentCircleId() >= 11 && player.getCurrentCircleId() <= 20) {
                playerX = circleX + MathUtils.cosDeg(randomAngle) * randomRadius;
                playerY = circleY + 25 + MathUtils.sinDeg(randomAngle) * randomRadius;
            } else if (player.getCurrentCircleId() >= 21 && player.getCurrentCircleId() <= 30) {
                playerX = circleX - 20 + MathUtils.cosDeg(randomAngle) * randomRadius;
                playerY = circleY + 5 + MathUtils.sinDeg(randomAngle) * randomRadius;
            } else {
                playerX = circleX + MathUtils.cosDeg(randomAngle) * randomRadius;
                playerY = circleY - 20 + MathUtils.sinDeg(randomAngle) * randomRadius;
            }
            player.sprite.setPosition(Math.round(playerX - (40 / 2)), Math.round(playerY - (40 / 2)));
        }

}
