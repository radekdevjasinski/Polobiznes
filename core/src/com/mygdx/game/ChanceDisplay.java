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

public class ChanceDisplay {
    private Chance chance;
    private final int x,y;
    private final Texture background;

    public ChanceDisplay(Chance chance) {
        this.chance = chance;
        x = Gdx.graphics.getWidth() / 2;
        y = Gdx.graphics.getHeight() / 2;
        background = new Texture("chanceBackground.png");
    }

    public void displayChance(SpriteBatch batch) {
        BitmapFont font = Font.getFontInstance().getFont(1);
        font.setColor(Color.BLACK);
        String string = chance.chances.get(11);
        font.draw(batch, string, x-150,y+30,300,1,true);
    }
    public void drawChanceBackground(SpriteBatch batch)
    {
        batch.draw(background, x-250, y-150);
    }
    public void drawChanceBackgroundCircle(ShapeRenderer shapeRenderer)
    {
        PrimitiveRenderer.drawElipse(shapeRenderer, x,y,200,100,Color.WHITE);

    }
    public void drawChanceBorder(ShapeRenderer shapeRenderer)
    {
        PrimitiveRenderer.drawRectangle(shapeRenderer, x,y,500,300, 0,Color.BLACK);//lewa strona, szansa

    }
}
