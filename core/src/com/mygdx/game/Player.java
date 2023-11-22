package com.mygdx.game;

public class Player extends SpriteObject{

    String imagePath;
    float moveSpeed;
    public Player(String imagePath){
        super(imagePath, 9);
        this.imagePath = imagePath;
        moveSpeed = 2.5f;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void moveLeft() {
        x -= moveSpeed;
    }

    public void moveRight() {
        x += moveSpeed;
    }

    public void moveUp() {
        y += moveSpeed;
    }

    public void moveDown() {
        y -= moveSpeed;
    }
}
