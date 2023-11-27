package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Klasa obsługująca manipulacje bitmapami w grze.
 */
public class BitmapHandler {

    private Texture bitmap;
    private String fileName;

    /**
     * Konstruktor klasy BitmapHandler.
     *
     * @param fileName Ścieżka do pliku bitmapy.
     */
    BitmapHandler(String fileName) {
        this.fileName = fileName;
        // Ładowanie pliku do tekstury i zmiana rozmiaru na 40x40
        loadFromFile();
        bitmap = resizeTexture(bitmap, 40, 40);
    }

    /**
     * Metoda zwracająca teksturę bitmapy.
     *
     * @return Tekstura bitmapy.
     */
    public Texture getBitmap() {
        return bitmap;
    }

    /**
     * Metoda zwracająca nazwę pliku bitmapy.
     *
     * @return Nazwa pliku bitmapy.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Metoda ustawiająca teksturę bitmapy.
     *
     * @param bitmap Nowa tekstura bitmapy.
     */
    public void setBitmap(Texture bitmap) {
        this.bitmap = bitmap;
    }

    /**
     * Metoda ustawiająca nazwę pliku bitmapy.
     *
     * @param fileName Nowa nazwa pliku bitmapy.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Metoda wczytująca teksturę z pliku.
     */
    public void loadFromFile() {
        this.bitmap = new Texture(fileName);
    }

    /**
     * Metoda statyczna do zmiany rozmiaru tekstury z podanej ścieżki.
     *
     * @param path   Ścieżka do pliku bitmapy.
     * @param width  Nowa szerokość tekstury.
     * @param height Nowa wysokość tekstury.
     * @return Nowa tekstura o zmienionym rozmiarze.
     */
    public static Texture resizeTexture(String path, int width, int height) {
        Pixmap pixmap20 = new Pixmap(Gdx.files.internal(path));
        Pixmap pixmap10 = new Pixmap(width, height, pixmap20.getFormat());
        pixmap10.drawPixmap(pixmap20,
                0, 0, pixmap20.getWidth(), pixmap20.getHeight(),
                0, 0, pixmap10.getWidth(), pixmap10.getHeight()
        );
        return new Texture((pixmap10));
    }

    /**
     * Metoda statyczna do zmiany rozmiaru tekstury.
     *
     * @param texture Tekstura do zmiany rozmiaru.
     * @param width   Nowa szerokość tekstury.
     * @param height  Nowa wysokość tekstury.
     * @return Nowa tekstura o zmienionym rozmiarze.
     */
    public static Texture resizeTexture(Texture texture, int width, int height) {
        TextureData textureData = texture.getTextureData();
        if (!textureData.isPrepared()) {
            textureData.prepare();
        }
        Pixmap pixmap20 = texture.getTextureData().consumePixmap();
        Pixmap pixmap10 = new Pixmap(width, height, pixmap20.getFormat());
        pixmap10.drawPixmap(pixmap20,
                0, 0, pixmap20.getWidth(), pixmap20.getHeight(),
                0, 0, pixmap10.getWidth(), pixmap10.getHeight()
        );
        return new Texture((pixmap10));
    }
}
