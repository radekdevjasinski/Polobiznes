package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public class Board {

    public static void drawBoard(ShapeRenderer shapeRenderer)
    {
        float x = (float)(Gdx.graphics.getWidth()/2);
        float y = (float)(Gdx.graphics.getHeight()/2);

        float centerSize = 405;
        float outerSize = 555;

        float squareSizeX = 45f;
        float squareSizeY = 75;

        float shift = (centerSize / 2) + (squareSizeY / 2);


        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        PrimitiveRenderer.drawSquare(shapeRenderer,x,y,centerSize,0, Color.YELLOW);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        PrimitiveRenderer.drawSquare(shapeRenderer,x,y,outerSize,0, Color.BLACK);
        PrimitiveRenderer.drawSquare(shapeRenderer,x,y,centerSize,0, Color.BLACK);

        for(int i = 0; i < 5; i++)
        {
            PrimitiveRenderer.drawRectangle(shapeRenderer, x, y - shift, squareSizeX + (squareSizeX*i*2),squareSizeY,0,Color.BLACK);
            PrimitiveRenderer.drawRectangle(shapeRenderer, x, y + shift, squareSizeX + (squareSizeX*i*2),squareSizeY,0,Color.BLACK);

            PrimitiveRenderer.drawRectangle(shapeRenderer, x - shift, y, squareSizeY,squareSizeX + (squareSizeX*i*2),0,Color.BLACK);
            PrimitiveRenderer.drawRectangle(shapeRenderer, x + shift, y, squareSizeY,squareSizeX + (squareSizeX*i*2),0,Color.BLACK);

        }

        shapeRenderer.end();

    }
}
