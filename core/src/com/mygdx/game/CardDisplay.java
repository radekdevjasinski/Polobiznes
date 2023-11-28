package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CardDisplay {
    private BitmapFont font;
    private Card card;

    public CardDisplay(BitmapFont font, Card card) {
        this.font = font;
        this.card = card;
    }

    public void displayCardInfo(SpriteBatch batch) {
        // Ustawienie koloru tekstu na czarny
        font.setColor(Color.BLACK);
        font.getData().setScale(1);
        // Wyświetlanie informacji o karcie na ekranie wewnątrz prostokąta
        int x = 800;
        int y = 560;
        font.draw(batch, "AKT ", x+80, y);
        font.draw(batch, "WLASNOSCI ", x+50, y-30);
        font.draw(batch, card.getNameCity().toUpperCase(), x+57, y-60);
        font.draw(batch, "SWIETOKRZYSKIE ", x+30, y-90);
        font.getData().setScale(0.75f);
        y -= 20;
        font.draw(batch, "Cena zakupu: " + card.getCostOfPurchase(), x, y-120);
        font.draw(batch, "Oplaty za postoj: ", x, y-135);
        font.draw(batch, "-niezabudowany: " + card.getParkingCost(), x, y-150);
        font.draw(batch, "-z 1 domem " + card.getCostWithTheHouse1(), x, y-165);
        font.draw(batch, "-z 2 domami " + card.getCostWithTheHouse2(), x, y-180);
        font.draw(batch, "-z 3 domami " + card.getCostWithTheHouse3(), x, y-195);
        font.draw(batch, "-z 4 domami " + card.getCostWithTheHouse4(), x, y-210);
        font.draw(batch, "-z 1 hotelem " + card.getCostWithTheHotel(), x, y-225);

        font.draw(batch, "1 dom kosztuje: " + card.getCostPerCottage(), x, y-240);
        font.draw(batch, "1 hotel kosztuje:: " + card.getCostForHotel(), x, y-255);
        font.draw(batch, "Hipoteka: " + card.getMortgage(), x, y-270);
    }
    public void drawCardBackground(ShapeRenderer shapeRenderer)
    {
        PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200,350, 0,Color.WHITE);
        PrimitiveRenderer.drawElipse(shapeRenderer, 890, 500, 90, 70, Color.GOLD);
    }
    public void drawCardBorder(ShapeRenderer shapeRenderer)
    {
        PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200,350, 0,Color.BLACK);//prawa strona, karta
    }
}
