package com.mygdx.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BitmapHandler {

    private BufferedImage bitmap;

    // Konstruktor - tworzy nową bitmapę o zadanych wymiarach
    public BitmapHandler(int width, int height) {
        this.bitmap = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    // Wczytywanie bitmapy z pliku w folderze "assets"
    public void loadFromFile(String fileName) {
        try {

            this.bitmap = ImageIO.read(new File("assets/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Zapisywanie bitmapy do pliku
    public void saveToFile(String filePath, String format) {
        try {
            ImageIO.write(bitmap, format, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Kopiowanie zawartości jednej bitmapy do drugiej
    public void copyTo(BitmapHandler destination) {
        int width = this.bitmap.getWidth();
        int height = this.bitmap.getHeight();

        // Sprawdzanie, czy bitmapy mają takie same wymiary
        if (width != destination.getWidth() || height != destination.getHeight()) {
            throw new IllegalArgumentException("Bitmapy muszą mieć takie same wymiary.");
        }

        // Kopiowanie piksel po pikselu
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixelColor = this.bitmap.getRGB(x, y);
                destination.setPixel(x, y, pixelColor);
            }
        }
    }

    // Ustawianie koloru piksela na danej pozycji
    public void setPixel(int x, int y, int color) {
        this.bitmap.setRGB(x, y, color);
    }

    // Pobieranie koloru piksela z danej pozycji
    public int getPixel(int x, int y) {
        return this.bitmap.getRGB(x, y);
    }

    // Pobieranie szerokości bitmapy
    public int getWidth() {
        return this.bitmap.getWidth();
    }

    // Pobieranie wysokości bitmapy
    public int getHeight() {
        return this.bitmap.getHeight();
    }

    // Wyświetlanie bitmapy w nowym oknie
    public void displayBitmap() {
        JFrame frame = new JFrame("Bitmap Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(bitmap);
        JLabel label = new JLabel(icon);
        frame.add(label);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        BitmapHandler[] pionki = new BitmapHandler[10];

        for (int i = 0; i < 10; i++) {
            String fileName = "pionek_" + i + ".bmp";
            pionki[i] = new BitmapHandler(100, 100);
            pionki[i].loadFromFile(fileName);


        }


        pionki[0].copyTo(pionki[1]);


        pionki[1].saveToFile("pionek_1_modified.bmp", "bmp");


        pionki[1].displayBitmap();
    }
}
