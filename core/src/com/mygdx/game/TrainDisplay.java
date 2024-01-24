package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TrainDisplay {
    private Train train;

    public TrainDisplay(Train train) {
        this.train = train;
    }

    public void displayTrainInfo(SpriteBatch batch) {
        BitmapFont font = Font.getFontInstance().getFont(0);
        int x = 800;
        int y = 560;

        font.setColor(Color.BLACK);
        font.draw(batch, "AKT ", x + 75, y);
        font.draw(batch, "POCIAGI ", x + 60, y - 30);
        font.draw(batch, train.getNameTrain(), x + 31, y - 52, 115, 1, true);
        font.draw(batch, train.getOwner(), x+66, y-320);

        font.getData().setScale(0.75f);
        y -= 20;
        font.setColor(Color.BLACK);
        font.draw(batch, "Cena zakupu: " + train.getCostOfPurchase(), x, y - 120);
        font.draw(batch, "Zarobki na stacji: ", x, y - 135);
        font.draw(batch, "1 stacja: " + train.getEarningOneStation(), x, y - 150);
        font.draw(batch, "2 stacje: " + train.getEarningTwoStations(), x, y - 165);
        font.draw(batch, "3 stacje: " + train.getEarningThreeStations(), x, y - 180);
        font.draw(batch, "4 stacje: " + train.getEarningFourStations(), x, y - 195);
    }

    public void drawTrainBackground(ShapeRenderer shapeRenderer) {
        PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.WHITE);
        PrimitiveRenderer.drawElipse(shapeRenderer, 890, 500, 90, 70, Color.BLUE);
    }

    public void drawTrainBorder(ShapeRenderer shapeRenderer) {
        PrimitiveRenderer.drawRectangle(shapeRenderer, 890, 400, 200, 350, 0, Color.BLACK);
    }
}
