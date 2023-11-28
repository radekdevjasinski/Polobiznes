package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CardDisplay {
    private SpriteBatch batch;
    private BitmapFont font;
    private Card card;
    private ShapeRenderer shapeRenderer;

    public CardDisplay(SpriteBatch batch, BitmapFont font, Card card) {
        this.batch = batch;
        this.font = font;
        this.card = card;
        this.shapeRenderer = new ShapeRenderer();
    }

    public void displayCardInfo() {
        batch.begin();

        // Ustawienie koloru tekstu na czarny
        font.setColor(Color.BLACK);

        // Wyświetlanie informacji o karcie na ekranie wewnątrz prostokąta
        font.draw(batch, "Miasto: " + card.getNameCity(), 710, 540);
        font.draw(batch, "Koszt zakupu: " + card.getCostOfPurchase(), 710, 510);
        font.draw(batch, "Oplata za domek: " + card.getCostPerCottage(), 710, 480);
        font.draw(batch, "Oplata za hotel: " + card.getCostForHotel(), 710, 450);
        font.draw(batch, "Oplata za postój: " + card.getParkingCost(), 710, 420);
        font.draw(batch, "Oplata za postój z domkiem 1: " + card.getCostWithTheHouse1(), 710, 390);
        font.draw(batch, "Oplata za postój z domkiem 2: " + card.getCostWithTheHouse2(), 710, 360);
        font.draw(batch, "Oplata za postój z domkiem 3: " + card.getCostWithTheHouse3(), 710, 330);
        font.draw(batch, "Oplata za postój z domkiem 4: " + card.getCostWithTheHouse4(), 710, 300);
        font.draw(batch, "Oplata za postój z hotelem: " + card.getCostForHotel(), 710, 270);
        font.draw(batch, "Hipoteka: " + card.getMortgage(), 710, 240);

        batch.end();
    }
}
