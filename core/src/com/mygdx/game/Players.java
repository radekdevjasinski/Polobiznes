package com.mygdx.game;

public class Players {
    String name;
    int cash;
    int x,y; //koordynaty gracza
    int budynki[];
    int chances[];


    public Players(String name, int cash){
        this.name = name;
        this.cash = cash;
    }
    public String getName(){
        return name;
    }
    public int getCash(){
        return cash;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCash(int cash) {
        this.cash = cash;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
