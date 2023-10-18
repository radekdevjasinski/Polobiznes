package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DiceRoll;
public class Engine extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	DiceRoll diceRoll1;
	DiceRoll diceRoll2;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("board.jpg");
		diceRoll1 = new DiceRoll();
		diceRoll2 = new DiceRoll();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(diceRoll1.rollTexture, 350, 50);
		batch.draw(diceRoll2.rollTexture, 500, 50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
