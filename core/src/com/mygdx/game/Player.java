package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;

/**
 * Klasa reprezentująca gracza w grze.
 */
public class Player{

    int id;
    int cash;
    String name;
    int currentCircleId;
    SpriteObject sprite;

    public Player(int id, int cash, String name) {
        this.id = id;
        this.cash = cash;
        this.name = name;
        this.currentCircleId = 0;

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

    public static void movePlayerToAdjacentCircle(Player player, int direction, CircleSquareDrawer circleSquareDrawer) {
        int liczbaKolek = 40; // Ilość okręgów

        circleSquareDrawer.updateCircleInfo();
        int noweIdKolka = (player.getCurrentCircleId() + direction + liczbaKolek) % liczbaKolek;
        player.setCurrentCircleId(noweIdKolka);
        CircleObject noweKolko = circleSquareDrawer.getCircleMap().get(noweIdKolka);
        if (noweKolko != null) {
            float randomAngle = MathUtils.random(360);
            float randomRadius = MathUtils.random(0, 6);
            float playerX = 0;
            float playerY = 0;
            if (player.getCurrentCircleId() >= 1 && player.getCurrentCircleId() <= 10) {
                playerX = noweKolko.getX() + 20 + MathUtils.cosDeg(randomAngle) * randomRadius;
                playerY = noweKolko.getY() + 5 + MathUtils.sinDeg(randomAngle) * randomRadius;
            } else if (player.getCurrentCircleId() >= 11 && player.getCurrentCircleId() <= 20) {
                playerX = noweKolko.getX() + MathUtils.cosDeg(randomAngle) * randomRadius;
                playerY = noweKolko.getY() + 25 + MathUtils.sinDeg(randomAngle) * randomRadius;
            } else if (player.getCurrentCircleId() >= 21 && player.getCurrentCircleId() <= 30) {
                playerX = noweKolko.getX() - 20 + MathUtils.cosDeg(randomAngle) * randomRadius;
                playerY = noweKolko.getY() + 5 + MathUtils.sinDeg(randomAngle) * randomRadius;
            } else {
                playerX = noweKolko.getX() + MathUtils.cosDeg(randomAngle) * randomRadius;
                playerY = noweKolko.getY() - 20 + MathUtils.sinDeg(randomAngle) * randomRadius;
            }
            player.sprite.setPosition(Math.round(playerX - (40 / 2)), Math.round(playerY - (40 / 2)));
        }
    }

}
