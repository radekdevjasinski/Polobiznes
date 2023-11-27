package com.mygdx.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Chance {

    public static void main(String[] args) {
        // Ścieżka do pliku tekstowego zawierającego karty Szansy
        String filePath = "assets/kartySzansy.txt";

        try {
            // Odczytaj zawartość pliku
            String fileContent = readFile(filePath);

            // Wyświetl zawartość pliku
            System.out.println(fileContent);
            System.out.println("Zawartość " + filePath);
        } catch (IOException e) {
            // Obsługa błędów podczas odczytu pliku
            System.err.println("Wystąpił błąd podczas odczytu pliku: " + e.getMessage());
        }
    }

    /**
     * Metoda do odczytu zawartości pliku tekstowego.
     *
     * @param filePath Ścieżka do pliku tekstowego
     * @return Zawartość pliku jako ciąg znaków
     * @throws IOException Wyjątek w przypadku problemów z odczytem pliku
     */
    public static String readFile(String filePath) throws IOException {
        // Inicjalizacja obiektu do przechowywania zawartości pliku
        StringBuilder content = new StringBuilder();

        // Używamy try-with-resources, aby automatycznie zamknąć BufferedReader po zakończeniu
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Odczytaj plik linia po linii
            String line;
            while ((line = br.readLine()) != null) {
                // Dodaj każdą linię do obiektu StringBuilder
                content.append(line).append("\n");
            }
        }

        // Zwróć zawartość pliku jako ciąg znaków
        return content.toString();
    }
}
