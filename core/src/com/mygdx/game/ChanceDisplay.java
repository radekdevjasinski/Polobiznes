package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;

public class ChanceDisplay {
    private Chance chance;

    public ChanceDisplay(Chance chance) {
        this.chance = chance;
    }

    public void displayChance(SpriteBatch batch, BitmapFont font) {
        // Ustawienie koloru tekstu na czarny
        font.setColor(Color.BLACK);
        font.getData().setScale(1.5f);
        int x = 20;
        int y = 460;

        font.draw(batch, chance.chances.get(0), x,y,150,0,true);
    }
    public void drawChanceBackground(ShapeRenderer shapeRenderer)
    {
        PrimitiveRenderer.drawRectangle(shapeRenderer, 100,400,200,350, 0,Color.valueOf("#1826c9"));//lewa strona, szansa

    }
    public void drawChanceBorder(ShapeRenderer shapeRenderer)
    {
        PrimitiveRenderer.drawRectangle(shapeRenderer, 100,400,200,350, 0,Color.BLACK);//lewa strona, szansa

    }
}
