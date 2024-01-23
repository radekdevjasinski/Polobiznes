package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import java.util.Random;

/**
 * Klasa DiceRoll reprezentuje obiekt kostki do gry z funkcjonalnością animowania rzutów.
 * Rozszerza klasę AnimatedObject.
 */
public class DiceRoll extends AnimatedObject {

    /** Współrzędna x kostki na ekranie. */
    public int posX;

    /** Współrzędna y kostki na ekranie. */
    public int posY;

    /** Aktualna wartość kostki (od 1 do 6). */
    public int value;

    public boolean rolling;

    /** Tablica tekstur reprezentujących każdą ścianę kostki. */
    public Texture[] textures;

    /**
     * Konstruktor obiektu DiceRoll.
     * Inicjalizuje pozycję, status aktywności i tekstury kostki.
     * Wykonuje również początkowy rzut kostką.
     */
    public DiceRoll() {
        super(); // Wywołuje konstruktor klasy AnimatedObject
        posX = 0;
        posY = 0;
        rolling = true;
        textures = new Texture[6];

        // Ładuje tekstury dla każdej ściany kostki i zmienia ich rozmiar
        for (int i = 0; i < 6; i++) {
            value = i + 1;
            String path = "dice_" + Integer.toString(value) + ".png";
            textures[i] = BitmapHandler.resizeTexture(path, 100, 100);
        }

        Roll(); // Wykonuje początkowy rzut kostką
    }

    /**
     * Symuluje rzut kostką, ustawiając wartość pola 'value' na losową liczbę od 1 do 6.
     */
    public void Roll() {
        Random rand = new Random();
        value = 1 + rand.nextInt(5);
        rolling = true;
    }

    /**
     * Rozpoczyna animację rzutu, ustawiając licznik animacji.
     */
    public void RollingAnimation() {
        Random r = new Random();
        timeSeconds = 0;
        animationTimer = 1 + r.nextFloat(1f);
    }

    /**
     * Animuje rzut kostką, aktualizując upłynięty czas i wykonując rzut, jeśli animacja jest w trakcie.
     */
    public void animate() {
        if (timeSeconds < animationTimer) {
            timeSeconds += Gdx.graphics.getDeltaTime();
            Roll(); // Wykonuje rzut podczas trwania animacji
        }
        rolling = false;
    }

    public int getValue() {
        return value;
    }
}
