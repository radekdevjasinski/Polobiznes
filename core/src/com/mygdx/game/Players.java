package com.mygdx.game;

/**
 * Klasa reprezentująca gracza w grze.
 */
public class Players{
    String name;
    int cash;
    int x,y; //koordynaty gracza
    int budynki[];
    int chances[];
    String imagePath;

    /**
     * Konstruktor klasy Players.
     *
     * @param name      Nazwa gracza.
     * @param cash      Początkowa ilość gotówki gracza.
     * @param imagePath Ścieżka do obrazka reprezentującego gracza.
     */
    public Players(String name, int cash, String imagePath){
        //super(new BitmapHandler(100, 100));
        this.name = name;
        this.cash = cash;
        this.imagePath = imagePath;
    }


    /**
     * Metoda zwracająca nazwę gracza.
     *
     * @return Nazwa gracza.
     */
    public String getName(){
        return name;
    }

    /**
     * Metoda zwracająca ilość gotówki gracza.
     *
     * @return Ilość gotówki gracza.
     */
    public int getCash(){
        return cash;
    }

    /**
     * Metoda ustawiająca nazwę gracza.
     *
     * @param name Nowa nazwa gracza.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metoda ustawiająca ilość gotówki gracza.
     *
     * @param cash Nowa ilość gotówki gracza.
     */
    public void setCash(int cash) {
        this.cash = cash;
    }

    /**
     * Metoda zwracająca współrzędną x gracza.
     *
     * @return Współrzędna x gracza.
     */
    public int getX() {
        return x;
    }

    /**
     * Metoda zwracająca współrzędną y gracza.
     *
     * @return Współrzędna y gracza.
     */
    public int getY() {
        return y;
    }

    /**
     * Metoda ustawiająca współrzędną x gracza.
     *
     * @param x Nowa współrzędna x gracza.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Metoda ustawiająca współrzędną y gracza.
     *
     * @param y Nowa współrzędna y gracza.
     */
    public void setY(int y) {
        this.y = y;
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
        x -= 5;
    }

    /**
     * Metoda przemieszczająca gracza w prawo.
     */
    public void moveRight() {
        x += 5;
    }

    /**
     * Metoda przemieszczająca gracza w górę.
     */
    public void moveUp() {
        y += 5;
    }

    /**
     * Metoda przemieszczająca gracza w dół.
     */
    public void moveDown() {
        y -= 5;
    }
}
