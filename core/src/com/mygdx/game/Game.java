package com.mygdx.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        String filePath = "assets/kartyMiast.txt";
        try {
            String fileContent = readFile(filePath);
            ;
            System.out.println(fileContent);
            System.out.println("Zawartość" + filePath);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas odczytu pliku: " + e.getMessage());
        }
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public void listCard() {
        List<Card> listCard = new ArrayList<>();
        String filePath = "assets/kartyMiast.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 11) {
                    String nameCity = parts[0];
                    int costOfPurchase = Integer.parseInt(parts[1]);
                    int costPerCottage = Integer.parseInt(parts[2]);
                    int costForHotel = Integer.parseInt(parts[3]);
                    int parkingCost = Integer.parseInt(parts[4]);
                    int costWithTheHouse1 = Integer.parseInt(parts[5]);
                    int costWithTheHouse2 = Integer.parseInt(parts[6]);
                    int costWithTheHouse3 = Integer.parseInt(parts[7]);
                    int costWithTheHouse4 = Integer.parseInt(parts[8]);
                    int costWithTheHotel = Integer.parseInt(parts[9]);
                    int  mortgage = Integer.parseInt(parts[10]);
                    Card card = new Card("Miasto", 120, 100, 100, 5, 40, 60, 180, 320, 500, 60
                    );
                    card.setNameCity(nameCity);
                    card.setCostOfPurchase(costOfPurchase);
                    card.setCostPerCottage(costPerCottage);
                    card.setCostForHotel(costForHotel);
                    card.setParkingCost(parkingCost);
                    card.setCostWithTheHouse1(costWithTheHouse1);
                    card.setCostWithTheHouse2(costWithTheHouse2);
                    card.setCostWithTheHouse3(costWithTheHouse3);
                    card.setCostWithTheHouse4(costWithTheHouse4);
                    card.setCostWithTheHotel(costWithTheHotel);
                    card.setMortgage(mortgage);
                    listCard.add(card);
                } else {
                    System.out.println("Nieprawidłowy format danych: " + line);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}