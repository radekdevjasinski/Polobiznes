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

public class Engine extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Game game;
	private OrthographicCamera camera;
	private Viewport viewport;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("planszaPolo.png");


		camera = new OrthographicCamera();
		viewport = new FitViewport(img.getWidth(), img.getHeight(), camera);
		viewport.apply();

		game = new Game();
		game.setPlayers();
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
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
