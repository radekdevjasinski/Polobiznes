package com.mygdx.game;

public class Train {
    String nameTrain;
    int costOfPurchase;
    int earningOneStation;
    int earningTwoStations;
    int earningThreeStations;
    int earningFourStations;

    public Train(String nameTrain, int costOfPurchase, int earningOneStation, int earningTwoStations,
                 int earningThreeStations, int earningFourStations) {
        this.nameTrain = nameTrain;
        this.costOfPurchase = costOfPurchase;
        this.earningOneStation = earningOneStation;
        this.earningTwoStations = earningTwoStations;
        this.earningThreeStations = earningThreeStations;
        this.earningFourStations = earningFourStations;
    }

    public String getNameTrain() {
        return nameTrain;
    }

    public void setNameTrain(String nameTrain) {
        this.nameTrain = nameTrain;
    }

    public int getCostOfPurchase() {
        return costOfPurchase;
    }

    public void setCostOfPurchase(int costOfPurchase) {
        this.costOfPurchase = costOfPurchase;
    }

    public int getEarningOneStation() {
        return earningOneStation;
    }

    public void setEarningOneStation(int earningOneStation) {
        this.earningOneStation = earningOneStation;
    }

    public int getEarningTwoStations() {
        return earningTwoStations;
    }

    public void setEarningTwoStations(int earningTwoStations) {
        this.earningTwoStations = earningTwoStations;
    }

    public int getEarningThreeStations() {
        return earningThreeStations;
    }

    public void setEarningThreeStations(int earningThreeStations) {
        this.earningThreeStations = earningThreeStations;
    }

    public int getEarningFourStations() {
        return earningFourStations;
    }

    public void setEarningFourStations(int earningFourStations) {
        this.earningFourStations = earningFourStations;
    }

    @Override
    public String toString() {
        return "Train{" +
                "nameTrain='" + nameTrain + '\'' +
                ", costOfPurchase=" + costOfPurchase +
                ", earningOneStation=" + earningOneStation +
                ", earningTwoStations=" + earningTwoStations +
                ", earningThreeStations=" + earningThreeStations +
                ", earningFourStations=" + earningFourStations +
                '}';
    }
}
