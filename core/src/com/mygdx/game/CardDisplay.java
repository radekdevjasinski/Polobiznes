package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CardDisplay {
    private Card card;

    public CardDisplay(Card card) {
        this.card = card;
    }

    public void displayCardInfo(SpriteBatch batch) {
        BitmapFont font = Font.getFontInstance().getFont(0);
        switch (card.getColor()) {
            case 1:
                font.setColor(Color.BLACK);
                break;
            case 2:
                font.setColor(Color.WHITE);
                break;
            case 3:
                font.setColor(Color.WHITE);
                break;
            case 4:
                font.setColor(Color.BLACK);
                break;
            case 5:
                font.setColor(Color.YELLOW);
                break;
            case 6:
                font.setColor(Color.PINK);
                break;
            case 7:
                font.setColor(Color.BLACK);
                break;
            case 8:
                font.setColor(Color.WHITE);
                break;
        }
        int x = 800;
        int y = 560;

        font.draw(batch, "AKT ", x+75, y);
        font.draw(batch, "WLASNOSCI ", x+50, y-30);
        font.draw(batch, card.getNameCity(), x+35, y-52, 115, 1, true);
        font.draw(batch, card.getNameState(), x+31, y-90, 120, 1,true);
        font.getData().setScale(0.75f);
        y -= 20;
        font.setColor(Color.BLACK);
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
    public void drawCardBackground(ShapeRenderer shapeRenderer) {
        switch (card.getColor()) {
            case 1:
                PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.WHITE);
                PrimitiveRenderer.drawElipse(shapeRenderer, 890, 500, 90, 70, Color.GOLD);
                break;
            case 2:
                PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.WHITE);
                PrimitiveRenderer.drawElipse(shapeRenderer, 890, 500, 90, 70, Color.RED);
                break;
            case 3:
                PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.WHITE);
                PrimitiveRenderer.drawElipse(shapeRenderer, 890, 500, 90, 70, Color.BLUE);
                break;
            case 4:
                PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.WHITE);
                PrimitiveRenderer.drawElipse(shapeRenderer, 890, 500, 90, 70, Color.ORANGE);
                break;
            case 5:
                PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.WHITE);
                PrimitiveRenderer.drawElipse(shapeRenderer, 890, 500, 90, 70, Color.GREEN);
                break;
            case 6:
                PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.WHITE);
                PrimitiveRenderer.drawElipse(shapeRenderer, 890, 500, 90, 70, Color.PURPLE);
                break;
            case 7:
                PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.WHITE);
                PrimitiveRenderer.drawElipse(shapeRenderer, 890, 500, 90, 70, Color.BROWN);
                break;
            case 8:
                PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.WHITE);
                PrimitiveRenderer.drawElipse(shapeRenderer, 890, 500, 90, 70, Color.BLACK);
                break;
        }
    }
    public void drawCardBorder(ShapeRenderer shapeRenderer)
    {
        PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200,350, 0,Color.BLACK);//prawa strona, karta
    }
}
