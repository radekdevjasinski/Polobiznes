package com.mygdx.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Klasa reprezentująca kartę miasta
public class Card {
    // Atrybuty karty miasta
    String nameCity;
    int costOfPurchase;
    int costPerCottage;
    int costForHotel;
    int parkingCost;
    int costWithTheHouse1;
    int costWithTheHouse2;
    int costWithTheHouse3;
    int costWithTheHouse4;
    int costWithTheHotel;
    int mortgage;

    /**
     * Konstruktor klasy Card, inicjalizuje atrybuty karty na podstawie przekazanych wartości.
     *
     * @param nameCity          Nazwa miasta na karcie.
     * @param costOfPurchase    Koszt zakupu karty.
     * @param costPerCottage    Koszt za jedno domek.
     * @param costForHotel      Koszt za hotel.
     * @param parkingCost       Koszt parkowania.
     * @param costWithTheHouse1 Koszt z jednym domkiem.
     * @param costWithTheHouse2 Koszt z dwoma domkami.
     * @param costWithTheHouse3 Koszt z trzema domkami.
     * @param costWithTheHouse4 Koszt z czterema domkami.
     * @param costWithTheHotel  Koszt z hotelem.
     * @param mortgage          Wartość hipoteki.
     */
    // Konstruktor klasy Card, inicjalizuje atrybuty karty na podstawie przekazanych wartości
    public Card(String nameCity, int costOfPurchase, int costPerCottage, int costForHotel, int parkingCost,
                int costWithTheHouse1, int costWithTheHouse2, int costWithTheHouse3, int costWithTheHouse4,
                int costWithTheHotel, int mortgage) {
        this.nameCity = nameCity;
        this.costOfPurchase = costOfPurchase;
        this.costPerCottage = costPerCottage;
        this.costForHotel = costForHotel;
        this.parkingCost = parkingCost;
        this.costWithTheHouse1 = costWithTheHouse1;
        this.costWithTheHouse2 = costWithTheHouse2;
        this.costWithTheHouse3 = costWithTheHouse3;
        this.costWithTheHouse4 = costWithTheHouse4;
        this.costWithTheHotel = costWithTheHotel;
        this.mortgage = mortgage;
    }

    public Card() {

    }

    /**
     * Metoda zwracająca nazwę miasta karty.
     *
     * @return Nazwa miasta.
     */
    // Metoda zwracająca nazwę miasta karty
    public String getNameCity() {
        return nameCity;
    }

    // Metoda ustawiająca nazwę miasta karty
    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    // Metoda zwracająca koszt zakupu karty
    public int getCostOfPurchase() {
        return costOfPurchase;
    }

    // Metoda ustawiająca koszt zakupu karty
    public void setCostOfPurchase(int costOfPurchase) {
        this.costOfPurchase = costOfPurchase;
    }

    // Metoda zwracająca koszt za jedno domek
    public int getCostPerCottage() {
        return costPerCottage;
    }

    // Metoda ustawiająca koszt za jedno domek
    public void setCostPerCottage(int costPerCottage) {
        this.costPerCottage = costPerCottage;
    }

    // Metoda zwracająca koszt za hotel
    public int getCostForHotel() {
        return costForHotel;
    }

    // Metoda ustawiająca koszt za hotel
    public void setCostForHotel(int costForHotel) {
        this.costForHotel = costForHotel;
    }

    // Metoda zwracająca koszt parkowania
    public int getParkingCost() {
        return parkingCost;
    }

    // Metoda ustawiająca koszt parkowania
    public void setParkingCost(int parkingCost) {
        this.parkingCost = parkingCost;
    }

    // Metoda zwracająca koszt z jednym domkiem
    public int getCostWithTheHouse1() {
        return costWithTheHouse1;
    }

    // Metoda ustawiająca koszt z jednym domkiem
    public void setCostWithTheHouse1(int costWithTheHouse1) {
        this.costWithTheHouse1 = costWithTheHouse1;
    }

    // Metoda zwracająca koszt z dwoma domkami
    public int getCostWithTheHouse2() {
        return costWithTheHouse2;
    }

    // Metoda ustawiająca koszt z dwoma domkami
    public void setCostWithTheHouse2(int costWithTheHouse2) {
        this.costWithTheHouse2 = costWithTheHouse2;
    }

    // Metoda zwracająca koszt z trzema domkami
    public int getCostWithTheHouse3() {
        return costWithTheHouse3;
    }

    // Metoda ustawiająca koszt z trzema domkami
    public void setCostWithTheHouse3(int costWithTheHouse3) {
        this.costWithTheHouse3 = costWithTheHouse3;
    }

    // Metoda zwracająca koszt z czterema domkami
    public int getCostWithTheHouse4() {
        return costWithTheHouse4;
    }

    // Metoda ustawiająca koszt z czterema domkami
    public void setCostWithTheHouse4(int costWithTheHouse4) {
        this.costWithTheHouse4 = costWithTheHouse4;
    }

    // Metoda zwracająca koszt z hotelem
    public int getCostWithTheHotel() {
        return costWithTheHotel;
    }

    // Metoda ustawiająca koszt z hotelem
    public void setCostWithTheHotel(int costWithTheHotel) {
        this.costWithTheHotel = costWithTheHotel;
    }

    // Metoda zwracająca wartość hipoteki
    public int getMortgage() {
        return mortgage;
    }

    // Metoda ustawiająca wartość hipoteki
    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

    /**
     * Metoda przesłaniająca toString() dla reprezentacji tekstowej obiektu Card.
     *
     * @return Tekstowa reprezentacja obiektu Card.
     */
    @Override
    public String toString() {
        return "Card{" +
                "nameCity='" + nameCity + '\'' +
                ", costOfPurchase=" + costOfPurchase +
                ", costPerCottage=" + costPerCottage +
                ", costForHotel=" + costForHotel +
                ", parkingCost=" + parkingCost +
                ", costWithTheHouse1=" + costWithTheHouse1 +
                ", costWithTheHouse2=" + costWithTheHouse2 +
                ", costWithTheHouse3=" + costWithTheHouse3 +
                ", costWithTheHouse4=" + costWithTheHouse4 +
                ", costWithTheHotel=" + costWithTheHotel +
                ", mortgage=" + mortgage +
                '}';
    }
    public void readCardFromFile() {
        String filePath = "assets/kartyMiast.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Odczytujemy linie z pliku
            while ((line = reader.readLine()) != null) {
                // Dzielimy linię na poszczególne części (pola karty) - zakładamy, że są oddzielone spacją
                String[] parts = line.split(" ");

                // Sprawdzamy, czy mamy wystarczającą liczbę pól
                if (parts.length == 11) {
                    // Tworzymy nową kartę i dodajemy ją do listy
                    Card card = new Card(
                            parts[0], // Nazwa miasta
                            Integer.parseInt(parts[1]), // Koszt zakupu
                            Integer.parseInt(parts[2]), // Koszt za domek
                            Integer.parseInt(parts[3]), // Koszt za hotel
                            Integer.parseInt(parts[4]), // Koszt parkowania
                            Integer.parseInt(parts[5]), // Koszt z jednym domkiem
                            Integer.parseInt(parts[6]), // Koszt z dwoma domkami
                            Integer.parseInt(parts[7]), // Koszt z trzema domkami
                            Integer.parseInt(parts[8]), // Koszt z czterema domkami
                            Integer.parseInt(parts[9]), // Koszt z hotelem
                            Integer.parseInt(parts[10]) // Wartość hipoteki
                    );

                    // Wyświetlamy informacje na konsoli (możesz dostosować to według swoich potrzeb)
                    System.out.println("Wczytano kartę: " + card.toString());
                } else {
                    // W przypadku nieprawidłowego formatu linii ignorujemy ją
                    System.out.println("Nieprawidłowy format linii: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
