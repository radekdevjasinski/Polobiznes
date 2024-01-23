package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Board {
    float centerSize = 405;
    float outerSize = 555;
    float squareSizeX = 45f;
    float squareSizeY = 75;
    float houseArea = 20f;
    //float x = (float)(Gdx.graphics.getWidth()/2);
    //float y = (float)(Gdx.graphics.getHeight()/2);

    final int[] squaresToSkip = {0,3,5,6,8,10,12,14,15,17,20,22,25,28,30,33,35,38};

    public void drawBoard(ShapeRenderer shapeRenderer, Viewport viewport)
    {
        float x = viewport.getWorldWidth() / 2;
        float y = viewport.getWorldHeight() / 2;
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
    public void drawBoardText(SpriteBatch batch, Viewport viewport)
    {
        float x = viewport.getWorldWidth() / 2;
        float y = viewport.getWorldHeight() / 2;


        BitmapFont font = Font.getFontInstance().getFont(2);


        batch.begin();
        font.setColor(Color.WHITE);
        font.draw(batch, "ŚWIĘTOKRZYSKIE", x - 170, y-180);
        font.draw(batch, "PODLASKIE", x + 100, y-180);
        drawDownText("LUBELSKIE",x-180, y-65, font, batch);
        drawDownText("WIELKOPOLSKIE", x-180, y+160, font,batch);
        font.draw(batch, "MAŁOPOLSKIE", x - 140, y+180);
        font.draw(batch, "POMORSKIE", x + 60, y+180);
        drawDownText("DOLNOŚLĄSKIE", x + 180, y+160, font, batch);
        drawDownText("MAZOWIECKIE", x+180, y-65, font, batch);
        batch.end();

        Texture logo = new Texture("logo.png");
        batch.begin();
        batch.draw(logo, x-centerSize/2, y-centerSize/2);
        batch.end();

    }
    void drawDownText(String text, float startx, float starty, BitmapFont font, SpriteBatch batch)
    {
        for (int i = 0; i < text.length(); i++)
        {
            String letter = String.valueOf(text.charAt(i));
            font.draw(batch,letter, startx, starty - i*10,5,1,false);
        }
    }
    public void drawHouseAreas(ShapeRenderer shapeRenderer, Viewport viewport) {
        float squareSize = 450f;
        int squareCount = 40;

        float startX = viewport.getWorldWidth() / 2 - squareSize / 2;
        float startY = viewport.getWorldHeight() / 2 - squareSize / 2;

        float step = squareSize / ((float) squareCount / 4); // Zwiększamy krok między okręgami
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        boolean draw;
        for (int i = 0; i < squareCount; i++) {
            draw = true;
            float x, y;
            for (int j = 0; j < squaresToSkip.length; j++)
            {
                if (squaresToSkip[j] == i) {
                    draw = false;
                    break;
                }
            }
            if (draw)
            {
                if (i < squareCount / 4) {
                    x = startX + i * step;
                    y = startY;
                    PrimitiveRenderer.drawRectangle(shapeRenderer, x ,y + 12.5f ,squareSizeX,houseArea,0,Color.BLACK);
                } else if (i < squareCount / 2) {
                    x = startX + squareSize;
                    y = startY + (i - squareCount / 4) * step;
                    PrimitiveRenderer.drawRectangle(shapeRenderer, x - 12.5f ,y ,houseArea,squareSizeX,0,Color.BLACK);
                } else if (i < squareCount * 3 / 4) {
                    x = startX + squareSize - (i - squareCount / 2) * step;
                    y = startY + squareSize;
                    PrimitiveRenderer.drawRectangle(shapeRenderer, x ,y - 12.5f ,squareSizeX,houseArea,0,Color.BLACK);
                } else {
                    x = startX;
                    y = startY + squareSize - (i - squareCount * 3 / 4) * step;
                    PrimitiveRenderer.drawRectangle(shapeRenderer, x + 12.5f ,y,houseArea,squareSizeX,0,Color.BLACK);
                }
            }
        }
        shapeRenderer.end();
    }
}
