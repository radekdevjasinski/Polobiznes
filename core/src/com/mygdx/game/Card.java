package com.mygdx.game;

public class Card {
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

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public int getCostOfPurchase() {
        return costOfPurchase;
    }

    public void setCostOfPurchase(int costOfPurchase) {
        this.costOfPurchase = costOfPurchase;
    }

    public int getCostPerCottage() {
        return costPerCottage;
    }

    public void setCostPerCottage(int costPerCottage) {
        this.costPerCottage = costPerCottage;
    }

    public int getCostForHotel() {
        return costForHotel;
    }

    public void setCostForHotel(int costForHotel) {
        this.costForHotel = costForHotel;
    }

    public int getParkingCost() {
        return parkingCost;
    }

    public void setParkingCost(int parkingCost) {
        this.parkingCost = parkingCost;
    }

    public int getCostWithTheHouse1() {
        return costWithTheHouse1;
    }

    public void setCostWithTheHouse1(int costWithTheHouse1) {
        this.costWithTheHouse1 = costWithTheHouse1;
    }

    public int getCostWithTheHouse2() {
        return costWithTheHouse2;
    }

    public void setCostWithTheHouse2(int costWithTheHouse2) {
        this.costWithTheHouse2 = costWithTheHouse2;
    }

    public int getCostWithTheHouse3() {
        return costWithTheHouse3;
    }

    public void setCostWithTheHouse3(int costWithTheHouse3) {
        this.costWithTheHouse3 = costWithTheHouse3;
    }

    public int getCostWithTheHouse4() {
        return costWithTheHouse4;
    }

    public void setCostWithTheHouse4(int costWithTheHouse4) {
        this.costWithTheHouse4 = costWithTheHouse4;
    }

    public int getCostWithTheHotel() {
        return costWithTheHotel;
    }

    public void setCostWithTheHotel(int costWithTheHotel) {
        this.costWithTheHotel = costWithTheHotel;
    }

    public int getMortgage() {
        return mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

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
}
