package com.mygdx.game;

public class Players{
    String name;
    int cash;
    int x,y; //koordynaty gracza
    int budynki[];
    int chances[];
    String imagePath;


    public Players(String name, int cash, String imagePath){
        //super(new BitmapHandler(100, 100));
        this.name = name;
        this.cash = cash;
        this.imagePath = imagePath;
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
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void moveLeft() {
        x -= 5;
    }

    public void moveRight() {
        x += 5;
    }

    public void moveUp() {
        y += 5;
    }

    public void moveDown() {
        y -= 5;
    }
}
