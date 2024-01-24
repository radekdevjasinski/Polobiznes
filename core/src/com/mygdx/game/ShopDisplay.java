package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ShopDisplay {
    private Shop shop;

    public ShopDisplay(Shop shop) {
        this.shop = shop;
    }

    public void displayShopInfo(SpriteBatch batch) {
        BitmapFont font = Font.getFontInstance().getFont(0);
        int x = 800;
        int y = 560;

        font.setColor(Color.BLACK);
        font.draw(batch, "SKLEP ", x + 70, y);
        font.draw(batch, shop.getShopName(), x + 31, y - 52, 115, 1, true);

        font.getData().setScale(0.75f);
        y -= 20;
        font.setColor(Color.BLACK);
        font.draw(batch, "Cena zakupu: " + shop.getCostOfPurchase(), x, y - 120);
        font.draw(batch, "Oplata za wejscie: " + shop.getEarningFromAnotherPlayer(), x, y - 135);
    }

    public void drawShopBackground(ShapeRenderer shapeRenderer) {
        PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.WHITE);
        PrimitiveRenderer.drawElipse(shapeRenderer, 890, 500, 90, 70, Color.GREEN);
    }

    public void drawShopBorder(ShapeRenderer shapeRenderer) {
        PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.BLACK);
    }
}
