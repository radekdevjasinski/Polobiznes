package com.mygdx.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Klasa reprezentująca logikę gry.
 */
public class Game {
    // Mapa przechowująca graczy
    HashMap<Integer, Players> playerMap = new HashMap<Integer, Players>();

    /**
     * Metoda główna programu.
     *
     * @param args Argumenty wiersza poleceń (nie używane w tym przypadku).
     */
    public static void main(String[] args) {
        // Ścieżka do pliku z danymi kart miast
        String filePath = "assets/kartyMiast.txt";
        try {
            // Odczytaj zawartość pliku
            String fileContent = readFile(filePath);
            System.out.println(fileContent);
        } catch (IOException e) {
            // Obsługa błędu odczytu pliku
            System.err.println("Wystąpił błąd podczas odczytu pliku: " + e.getMessage());
        }
    }

    /**
     * Metoda odczytująca zawartość pliku tekstowego.
     *
     * @param filePath Ścieżka do pliku do odczytu.
     * @return Zawartość pliku jako ciąg znaków.
     * @throws IOException Wyjątek rzucany w przypadku błędu odczytu pliku.
     */
    public static String readFile(String filePath) throws IOException {
        // Zmienna przechowująca zawartość pliku
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Odczytaj linie z pliku i dodaj do zawartości
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        // Zwróć zawartość pliku jako string
        return content.toString();
    }

    /**
     * Metoda do listowania kart miast.
     */
    public void listCard() {
        // Lista przechowująca obiekty Card
        ArrayList<Card> listCard = new ArrayList<Card>();
        String filePath = "assets/kartyMiast.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Odczytaj linie z pliku
            while ((line = br.readLine()) != null) {
                // ... (bez zmian)
            }
        } catch (IOException e) {
            // Rzuć wyjątek RuntimeException w przypadku błędu odczytu
            throw new RuntimeException(e);
        }
    }

    /**
     * Metoda dodająca gracza do mapy graczy.
     *
     * @param id     Identyfikator gracza.
     * @param player Obiekt gracza do dodania.
     */
    public void addPlayer(int id, Players player) {
        // Dodaj gracza do mapy
        playerMap.put(id, player);
    }

    /**
     * Metoda pobierająca gracza z mapy graczy.
     *
     * @param id Identyfikator gracza.
     * @return Obiekt gracza z mapy.
     */
    public Players getPlayer(int id) {
        // Pobierz gracza z mapy na podstawie identyfikatora
        return playerMap.get(id);
    }

    /**
     * Metoda ustawiająca początkowych graczy.
     */
    public void setPlayers() {
        // Utwórz trzech początkowych graczy i dodaj do mapy
        Players p1 = new Players("Kuba", 5000, "D:/Polobiznesrel/assets/pawn1.png");
        Players p2 = new Players("Radek", 4999, "D:/Polobiznesrel/assets/pawn2.png");
        Players p3 = new Players("Eliza", 4998, "D:/Polobiznesrel/assets/pawn3.png");
        addPlayer(0, p1);
        addPlayer(1, p2);
        addPlayer(3, p3);
    }
}
