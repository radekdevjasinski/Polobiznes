package com.mygdx.game;
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
}
