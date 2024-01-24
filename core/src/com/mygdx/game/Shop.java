package com.mygdx.game;

public class Shop {
    String shopName;
    int costOfPurchase;
    int earningFromAnotherPlayer;

    public Shop(String shopName, int costOfPurchase, int earningFromAnotherPlayer) {
        this.shopName = shopName;
        this.costOfPurchase = costOfPurchase;
        this.earningFromAnotherPlayer = earningFromAnotherPlayer;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getCostOfPurchase() {
        return costOfPurchase;
    }

    public void setCostOfPurchase(int costOfPurchase) {
        this.costOfPurchase = costOfPurchase;
    }

    public int getEarningFromAnotherPlayer() {
        return earningFromAnotherPlayer;
    }

    public void setEarningFromAnotherPlayer(int earningFromAnotherPlayer) {
        this.earningFromAnotherPlayer = earningFromAnotherPlayer;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopName='" + shopName + '\'' +
                ", costOfPurchase=" + costOfPurchase +
                ", earningFromAnotherPlayer=" + earningFromAnotherPlayer +
                '}';
    }
}
