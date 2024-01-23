// SpriteObject.java
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca obiekt animowany z użyciem klatek (sprite).
 * Dziedziczy po BitmapHandler i implementuje interfejsy TransformableObject oraz Animation.
 */
public class SpriteObject extends BitmapHandler implements TransformableObject, Animation {
    private static final float FRAME_DURATION = 0.2f; // Czas trwania jednej klatki animacji
    private float stateTime; // Czas trwania animacji
    private float timeSeconds;
    private List<BitmapHandler> frames; // Lista zawierająca wszystkie klatki animacji
    private int currentFrame;
    private int frameCount;
    protected int x, y;

    /**
     * Konstruktor klasy SpriteObject.
     *
     * @param baseFileName Nazwa pliku bazowego dla klatek animacji.
     * @param frameCount   Liczba klatek animacji.
     */
    public SpriteObject(String baseFileName, int frameCount) {
        super(baseFileName);
        stateTime = 0.1f;
        timeSeconds = 0;
        currentFrame = 0;
        this.frameCount = frameCount;
        x = 0;
        y = 0;
        loadFrames(baseFileName);
    }

    /**
     * Metoda wczytująca klatki animacji na podstawie nazwy pliku bazowego.
     *
     * @param baseFileName Nazwa pliku bazowego dla klatek animacji.
     */
    private void loadFrames(String baseFileName) {
        frames = new ArrayList<>();
        for (int i = 0; i < frameCount; i++) {
            String fileName = baseFileName + "_" + i + ".bmp";
            BitmapHandler frameBitmap = new BitmapHandler(fileName);
            frames.add(frameBitmap);
        }
    }

    /**
     * Metoda ustawiająca pozycję obiektu.
     *
     * @param x Współrzędna X.
     * @param y Współrzędna Y.
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Metoda obsługująca animację.
     */
    public void animate() {
        if (timeSeconds < stateTime) {
            timeSeconds += Gdx.graphics.getDeltaTime();
        } else {
            timeSeconds = 0;
            if (currentFrame >= frameCount)
                currentFrame = 0;
            setBitmap(frames.get(currentFrame).getBitmap());
            currentFrame++;
        }
    }

    /**
     * Metoda przesuwająca obiekt o określoną wartość wzdłuż osi X i Y.
     *
     * @param deltaX Przesunięcie wzdłuż osi X.
     * @param deltaY Przesunięcie wzdłuż osi Y.
     */
    @Override
    public void translate(float deltaX, float deltaY) {
        // Implementacja przesunięcia obiektu
    }

    /**
     * Metoda obracająca obiekt o określony kąt.
     *
     * @param degrees Kąt obrotu w stopniach.
     */
    @Override
    public void rotate(float degrees) {
        // Implementacja obrotu obiektu
    }

    /**
     * Metoda skalująca obiekt o określony współczynnik.
     *
     * @param factor Współczynnik skalowania.
     */
    @Override
    public void scale(float factor) {
        // Implementacja skalowania obiektu
    }

    /**
     * Metoda zwracająca wartość współrzędnej X obiektu.
     *
     * @return Współrzędna X obiektu.
     */
    public int getX() {
        return x;
    }

    /**
     * Metoda zwracająca wartość współrzędnej Y obiektu.
     *
     * @return Współrzędna Y obiektu.
     */
    public int getY() {
        return y;
    }
}
