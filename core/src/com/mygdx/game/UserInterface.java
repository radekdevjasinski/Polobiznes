package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class UserInterface {
    public static void drawCard(CardDisplay cardDisplay, ShapeRenderer shapeRenderer, SpriteBatch batch, Camera camera)
    {
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        cardDisplay.drawCardBackground(shapeRenderer);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        cardDisplay.drawCardBorder(shapeRenderer);
        shapeRenderer.end();

        batch.begin();
        cardDisplay.displayCardInfo(batch);
        batch.end();
    }
    public static void drawChance(ChanceDisplay chanceDisplay, ShapeRenderer shapeRenderer, SpriteBatch batch, Camera camera)
    {
        batch.begin();
        chanceDisplay.drawChanceBackground(batch);
        batch.end();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        chanceDisplay.drawChanceBorder(shapeRenderer);
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        chanceDisplay.drawChanceBackgroundCircle(shapeRenderer);
        shapeRenderer.end();

        batch.begin();
        chanceDisplay.displayChance(batch);
        batch.end();
    }
}
