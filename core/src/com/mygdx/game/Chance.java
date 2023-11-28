package com.mygdx.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Chance reprezentuje objekt szans w grze.
 */
public class Chance {
    private  final String filePath = "kartySzansy.txt";
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
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Odczytaj plik linia po linii
            String line;
            while ((line = br.readLine()) != null) {
                chances.add(line);
            }
        }
        return chances;
    }
}
