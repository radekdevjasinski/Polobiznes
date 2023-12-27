package com.mygdx.game;


/**
 * Klasa reprezentująca gracza w grze.
 */
public class Player extends SpriteObject{
    String imagePath;
    float moveSpeed;
    private int currentCircleId;

    /**
     * Konstruktor klasy Player.
     *
     * @param imagePath Ścieżka do obrazka reprezentującego gracza.
     */
    public Player(String imagePath){
        super(imagePath, 9);
        this.imagePath = imagePath;
        moveSpeed = 2.5f;
        currentCircleId = 0;
    }

    /**
     * Metoda zwracająca ścieżkę do obrazka gracza.
     *
     * @return Ścieżka do obrazka gracza.
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Metoda ustawiająca ścieżkę do obrazka gracza.
     *
     * @param imagePath Nowa ścieżka do obrazka gracza.
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Metoda przemieszczająca gracza w lewo.
     */
    public void moveLeft() {
        x -= moveSpeed;
    }

    /**
     * Metoda przemieszczająca gracza w prawo.
     */
    public void moveRight() {
        x += moveSpeed;
    }

    /**
     * Metoda przemieszczająca gracza w górę.
     */
    public void moveUp() {
        y += moveSpeed;
    }

    /**
     * Metoda przemieszczająca gracza w dół.
     */
    public void moveDown() {
        y -= moveSpeed;
    }

    public void setCurrentCircleId(int circleId) {
        this.currentCircleId = circleId;
    }

    public int getCurrentCircleId() {
        return currentCircleId;
    }


}
