package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Pixmap;
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
  private Game game;
	private OrthographicCamera camera;
	private Viewport viewport;
	private SquareObject square;
	private Players player;
	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("planszaPolo.png");
		player = new Players("Player1", 1000, "D:\\Polobiznes\\assets\\pawn3.png");
		camera = new OrthographicCamera();
		viewport = new FitViewport(img.getWidth(), img.getHeight(), camera);
		viewport.apply();
		square = new SquareObject(0, 0, 50);
		game = new Game();
		game.setPlayers();
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
	public void render() {
		if (Gdx.graphics.getWidth() != viewport.getWorldWidth() || Gdx.graphics.getHeight() != viewport.getWorldHeight()) {
			viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		}

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(img, 0, 0);

		//rysowanie gracza
		Texture playerImg = new Texture(player.getImagePath());
		batch.draw(playerImg, player.getX(), player.getY());
		//playerImg.dispose();

    //Rolling
		if(timeSeconds < diceRoll1Timer)
		{
			timeSeconds += Gdx.graphics.getDeltaTime();
			diceRoll1.Roll();
		}
		if(timeSeconds < diceRoll2Timer)
		{
			timeSeconds += Gdx.graphics.getDeltaTime();
			diceRoll2.Roll();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			RollingAnimation();
		}
		dice1 = resizeTexture(diceRoll1.pngPath(), 100, 100);
		dice2 = resizeTexture(diceRoll2.pngPath(), 100, 100);
		batch.draw(dice1, 350, 50);
		batch.draw(dice2, 500, 50);
/*
		for (int i = 0; i < game.playerMap.size(); i++) {
			Players player = game.getPlayer(i);

			String imagePath = player.getImagePath();
			Texture playerImg = new Texture(imagePath);

			float playerX = (i + 1) * (viewport.getWorldWidth() / (game.playerMap.size() + 1)) - playerImg.getWidth() / 2;
			float playerY = (viewport.getWorldHeight() - playerImg.getHeight()) / 2;

			batch.draw(playerImg, playerX, playerY);

			playerImg.dispose();
		}*/
		batch.end();
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.moveLeft();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.moveRight();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			player.moveUp();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			player.moveDown();
		}
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}
	public void RollingAnimation()
	{
		Random r = new Random();
		timeSeconds = 0;
		diceRoll1Timer = 1 + r.nextFloat(1f);
		diceRoll2Timer = 1 + r.nextFloat(3f);
		System.out.println(diceRoll1Timer + " " + diceRoll2Timer);
	}
	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
