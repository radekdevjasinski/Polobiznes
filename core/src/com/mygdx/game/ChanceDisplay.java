package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChanceDisplay {

    private final Texture background;

    private final Chance chance;

    public ChanceDisplay(Chance chance) {
        this.chance = chance;

        background = new Texture("chanceBackground.png");
    }



    public void displayChance(SpriteBatch batch) {
        BitmapFont font = Font.getFontInstance().getFont(1);
        font.setColor(Color.BLACK);
        font.draw(batch, chance.getDesc(), 350,330,300,1,true);
    }
    public void drawChanceBackground(SpriteBatch batch)
    {
        batch.draw(background, 250, 150);
    }
    public void drawChanceBackgroundCircle(ShapeRenderer shapeRenderer)
    {
        PrimitiveRenderer.drawElipse(shapeRenderer, 500,300,200,100,Color.WHITE);

    }
    public void drawChanceBorder(ShapeRenderer shapeRenderer)
    {
        PrimitiveRenderer.drawRectangle(shapeRenderer, 500,300,500,300, 0,Color.BLACK);//lewa strona, szansa

    }
}
