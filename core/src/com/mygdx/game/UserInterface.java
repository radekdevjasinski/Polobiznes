package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.List;

public class UserInterface {
    static float x = (float) Gdx.graphics.getWidth() / 2;
    static float y = (float) Gdx.graphics.getHeight() / 2;
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
    public static void drawPlayerPanel(Game game, ShapeRenderer shapeRenderer, SpriteBatch batch, Camera camera)
    {

        
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        //background
        PrimitiveRenderer.drawRectangle(shapeRenderer, x-390, y, 200, 555, 0, Color.BLACK);

        for (int i = 0; i < game.getPlayerList().size(); i++)
        {
            PrimitiveRenderer.drawRectangle(shapeRenderer, x-390, y+73 - i*100, 200, 100, 0, Color.BLACK);

        }

        shapeRenderer.end();

        batch.begin();
        for (Player player : game.getPlayerList())
        {
            float posY = y+36.5f - player.getId() * 100;
            batch.draw(player.getSprite().getBitmap(), x-500, posY, 75, 75);
            BitmapFont font = Font.getFontInstance().getFont(1);
            font.setColor(Color.BLACK);
            font.draw(batch, player.getName(), x-420, posY+55);

            batch.end();

            if (player.getId() == game.turnOf)
            {
                shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                PrimitiveRenderer.drawCircle(shapeRenderer, x - 325, posY + 32.5f, 10, 0 , Color.RED);
                shapeRenderer.end();
            }


            batch.begin();
            BitmapFont font2 = Font.getFontInstance().getFont(3);
            font2.setColor(Color.GREEN);
            font2.draw(batch, player.getCash() + "$", x-420, posY+25);

        }

        BitmapFont font3 = Font.getFontInstance().getFont(4);
        font3.setColor(Color.BLACK);
        font3.draw(batch, game.gameMessage().toUpperCase(), x-485, y+260,190,1,true);

        batch.end();


    }
    public static void drawTrain(TrainDisplay trainDisplay, ShapeRenderer shapeRenderer, SpriteBatch batch, Camera camera)
    {
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        trainDisplay.drawTrainBackground(shapeRenderer);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        trainDisplay.drawTrainBorder(shapeRenderer);
        shapeRenderer.end();

        batch.begin();
        trainDisplay.displayTrainInfo(batch);
        batch.end();
    }

    public static void drawShop(ShopDisplay shopDisplay, ShapeRenderer shapeRenderer, SpriteBatch batch, Camera camera)
    {
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shopDisplay.drawShopBackground(shapeRenderer);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shopDisplay.drawShopBorder(shapeRenderer);
        shapeRenderer.end();

        batch.begin();
        shopDisplay.displayShopInfo(batch);
        batch.end();
    }
}
