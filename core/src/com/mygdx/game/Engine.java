package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DiceRoll;
import java.util.Random;

public class Engine extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	//Dice
	Texture dice1;
	Texture dice2;
	DiceRoll diceRoll1;
	DiceRoll diceRoll2;
	float diceRoll1Timer;
	float diceRoll2Timer;
	float timeSeconds;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("board.jpg");

		diceRoll1 = new DiceRoll();
		diceRoll2 = new DiceRoll();

		RollingAnimation();
		timeSeconds = 0f;
	}
	public Texture resizeTexture(String path, int width, int height)
	{
		Pixmap pixmap20 = new Pixmap(Gdx.files.internal(path));
		Pixmap pixmap10 = new Pixmap(width, height, pixmap20.getFormat());
		pixmap10.drawPixmap(pixmap20,
				0, 0, pixmap20.getWidth(), pixmap20.getHeight(),
				0, 0, pixmap10.getWidth(), pixmap10.getHeight()
		);
		return new Texture((pixmap10));
	}
	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		//Rolling
		if(timeSeconds < diceRoll1Timer || timeSeconds < diceRoll2Timer)
		{
			timeSeconds += Gdx.graphics.getDeltaTime();
			diceRoll1.Roll();
			diceRoll2.Roll();
			System.out.println("Roll");
		}
		dice1 = resizeTexture(diceRoll1.pngPath(), 100, 100);
		dice2 = resizeTexture(diceRoll2.pngPath(), 100, 100);
		batch.draw(dice1, 350, 50);
		batch.draw(dice2, 500, 50);
		batch.end();
	}
	public void RollingAnimation()
	{
		Random r = new Random();
		diceRoll1Timer = 1 + r.nextFloat(5f);
		diceRoll2Timer = 1 + r.nextFloat(5f);

	}
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
