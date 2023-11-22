package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BitmapHandler {

    private Texture bitmap;
    private String fileName;

    BitmapHandler(String fileName) {
        this.fileName = fileName;
        loadFromFile();
        bitmap = resizeTexture(bitmap,40,40);
    }

    public Texture getBitmap() {
        return bitmap;
    }

    public String getFileName() {
        return fileName;
    }

    public void setBitmap(Texture bitmap) {
        this.bitmap = bitmap;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void loadFromFile() {
        this.bitmap = new Texture(fileName);
    }

    public static Texture resizeTexture(String path, int width, int height) {
        Pixmap pixmap20 = new Pixmap(Gdx.files.internal(path));
        Pixmap pixmap10 = new Pixmap(width, height, pixmap20.getFormat());
        pixmap10.drawPixmap(pixmap20,
                0, 0, pixmap20.getWidth(), pixmap20.getHeight(),
                0, 0, pixmap10.getWidth(), pixmap10.getHeight()
        );
        return new Texture((pixmap10));
    }
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