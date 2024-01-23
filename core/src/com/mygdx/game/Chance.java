package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Chance reprezentuje objekt szans w grze.
 */
public class Chance {
    private  final String filePath = "kartySzansy.txt"; //D:\PoloBiznesNew\assets\kartySzansy.txt
    public List<String> chances;

    public Chance() throws IOException {
        chances = readFile(filePath);
    }

    /**
     * Metoda do odczytu zawartości pliku tekstowego.
     *
     * @param filePath Ścieżka do pliku tekstowego
     * @return Zawartość pliku jako ciąg znaków
     * @throws IOException Wyjątek w przypadku problemów z odczytem pliku
     */
    public static List<String> readFile(String filePath) throws IOException {
        List<String> chances = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                chances.add(line);
            }
        }

        return chances;
    }
}
