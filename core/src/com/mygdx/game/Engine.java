package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Klasa Engine reprezentuje główny silnik gry.
 */
public class Engine extends ApplicationAdapter {
	private CardDisplay cardDisplay;
	private CircleSquareDrawer circleSquareDrawer;
	private ClosestCircleInfo closestCircleInfo;
	private boolean leftKeyProcessed = false;
	private boolean rightKeyProcessed = false;

	SpriteBatch batch;
	Texture logo;
	DiceRoll diceRoll1;
	DiceRoll diceRoll2;
    private Game game;
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;
	private Viewport viewport;
	private CircleObject circleObject;
	private SquareObject squareObject;
	//private Players player;
	private Card card;
	private Chance chance;
	private ChanceDisplay chanceDisplay;
	Texture pkpTexture;
	Texture QuestionMarkRed;
	private Vector3 mousePosition = new Vector3();

	/**
	 * Metoda inicjalizująca obiekty i parametry gry.
	 */
	@Override
	public void create() {

		batch = new SpriteBatch();
    	//player = new Players("Player1", 1000, "pawn3.png");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		viewport = new FitViewport(1000, 600, camera);
		viewport.apply();


		game = new Game();

		for (Player player : game.getPlayerList())
		{
			player.sprite.setPosition(500, 400);
		}

		//primitiveRenderer = new PrimitiveRenderer();
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		circleObject = new CircleObject(500, 200, 50);
		squareObject = new SquareObject(300, 100, 50);

		diceRoll1 = new DiceRoll();
		diceRoll2 = new DiceRoll();

		circleSquareDrawer = new CircleSquareDrawer(viewport);
		closestCircleInfo = new ClosestCircleInfo(circleSquareDrawer);
		card = new Card("Bialystok", 200, 50, 100, 20, 150, 200, 250, 300, 400, 50);
		try {
			chance = new Chance();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		pkpTexture = new Texture(Gdx.files.internal("pkp.png"));
		QuestionMarkRed = new Texture(Gdx.files.internal("znak_zapytania_czerwony.png"));
		circleSquareDrawer = new CircleSquareDrawer(viewport, shapeRenderer);
		cardDisplay = new CardDisplay(new Card());
	}

	/**
	 * Metoda odpowiedzialna za rysowanie klatek gry.
	 */
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Board board = new Board();
		board.drawBoard(shapeRenderer, viewport);
		board.drawHouseAreas(shapeRenderer, viewport);
		board.drawBoardText(batch, viewport);

		batch.begin();
		int[] specialFieldsTrain = {5, 15, 25, 35};
		for (int specialField : specialFieldsTrain) {
			CircleObject circle = circleSquareDrawer.getCircleMap().get("Circle_" + specialField);
			if (circle != null) {
				float width = 40;
				float height = 40;
				if (specialField == 15) {
					batch.draw(pkpTexture, circle.getX() - 19, circle.getY(), width / 2, height / 2, width, height, 1, 1, 180, 0, 0, pkpTexture.getWidth(), pkpTexture.getHeight(), false, false);
				} else if (specialField == 25) {
					batch.draw(pkpTexture, circle.getX() - 35, circle.getY() - 20, width / 2, height / 2, width, height, 1, 1, 270, 0, 0, pkpTexture.getWidth(), pkpTexture.getHeight(), false, false);
				} else if (specialField == 5) {
					batch.draw(pkpTexture, circle.getX(), circle.getY() - 20, width / 2, height / 2, width, height, 1, 1, 90, 0, 0, pkpTexture.getWidth(), pkpTexture.getHeight(), false, false);
				} else if (specialField == 35) {
					batch.draw(pkpTexture, circle.getX() - 20, circle.getY() - 37, width / 2, height / 2, width, height, 1, 1, 0, 0, 0, pkpTexture.getWidth(), pkpTexture.getHeight(), false, false);
				}
			}
		}
		batch.end();
		batch.begin();
		int[] specialFieldsQuestionMarkRed = {4, 12, 23, 33};
		for (int specialField : specialFieldsQuestionMarkRed) {
			CircleObject circle = circleSquareDrawer.getCircleMap().get("Circle_" + specialField);
			if (circle != null) {
				float width = 40;
				float height = 40;
				if (specialField == 4) {
					batch.draw(QuestionMarkRed, circle.getX() - 5, circle.getY() - 20, width / 2, height / 2, width, height, 1, 1, 90, 0, 0, QuestionMarkRed.getWidth(), QuestionMarkRed.getHeight(), false, false);
				}
			}
		}
		batch.end();

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && !leftKeyProcessed) {
			leftKeyProcessed = true;
			movePlayerToAdjacentCircle(-1);
		} else if (!Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			leftKeyProcessed = false;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !rightKeyProcessed) {
			rightKeyProcessed = true;
			movePlayerToAdjacentCircle(1);
		} else if (!Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			rightKeyProcessed = false;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			diceRoll1.RollingAnimation();
			diceRoll2.RollingAnimation();
		}

		diceRoll1.animate();
		diceRoll2.animate();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		for(Player player : game.getPlayerList())
		{
			batch.draw(player.sprite.getBitmap(), player.sprite.getX(), player.sprite.getY());

		}

		batch.draw(diceRoll1.textures[diceRoll1.value], 790, 30);
		batch.draw(diceRoll1.textures[diceRoll2.value], 890, 30);


		batch.end();
		batch.begin();
		//closestCircleInfo.drawClosestCircleInfo(batch, player.getX(), player.getY());

		batch.end();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		circleSquareDrawer.drawCircles();
		shapeRenderer.end();

		//testowe wyświetlanie kart
		//UserInterface.drawCard(new CardDisplay(card), shapeRenderer, batch, camera);
		//UserInterface.drawChance(new ChanceDisplay(chance), shapeRenderer, batch, camera);

		mousePosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(mousePosition);
		Gdx.app.log("Debug", "Mouse Position: " + mousePosition.x + ", " + mousePosition.y);

		closestCircleInfo.updateClosestCircleInfo(mousePosition.x, mousePosition.y);

		float maxDistance = 50; // Maksymalna odległość od kółka, którą uznasz za akceptowalną

		if (!circleSquareDrawer.isMouseNearCircle((int) mousePosition.x, (int) mousePosition.y, maxDistance)) {
			//Gdx.app.log("Debug", "Myszka jest za daleko od kółek.");
		} else {
			CircleObject closestCircle = closestCircleInfo.findClosestCircle(mousePosition.x, mousePosition.y);

			if (closestCircle != null && closestCircle.getCityCard() != null) {
				UserInterface.drawCard(new CardDisplay(closestCircle.getCityCard()), shapeRenderer, batch, camera);
				//closestCircle.setCityCard(null); //czyszczenie (nie trzeba bo samo sie czysci ale moze sie przydac)
			}
		}

		UserInterface.drawPlayerPanel(game, shapeRenderer, batch, camera);

	}
	/**
	 * Metoda odpowiedzialna za dostosowanie widoku do zmiany rozmiaru ekranu.
	 *
	 * @param width  Nowa szerokość ekranu.
	 * @param height Nowa wysokość ekranu.
	 */
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void dispose() {
		batch.dispose();
		shapeRenderer.dispose();
	}

	private void movePlayerToAdjacentCircle(int direction) {
		int liczbaKolek = 40; // Ilość okręgów

		circleSquareDrawer.updateCircleInfo();
		for (Player player : game.getPlayerList()) {
			int noweIdKolka = (player.getCurrentCircleId() + direction + liczbaKolek) % liczbaKolek;
			player.setCurrentCircleId(noweIdKolka);
			CircleObject noweKolko = circleSquareDrawer.getCircleMap().get("Circle_" + noweIdKolka);
			if (noweKolko != null) {
				float randomAngle = MathUtils.random(360);
				float randomRadius = MathUtils.random(0, 6);
				float playerX = 0;
				float playerY = 0;
				if (player.getCurrentCircleId() >= 1 && player.getCurrentCircleId() <= 10) {
					playerX = noweKolko.getX()  + MathUtils.cosDeg(randomAngle) * randomRadius;
					playerY = noweKolko.getY() -20  + MathUtils.sinDeg(randomAngle) * randomRadius;
				} else if (player.getCurrentCircleId() >= 11 && player.getCurrentCircleId() <= 20) {
					playerX = noweKolko.getX()  - 25+ MathUtils.cosDeg(randomAngle) * randomRadius;
					playerY = noweKolko.getY() + 5 + MathUtils.sinDeg(randomAngle) * randomRadius;
				} else if (player.getCurrentCircleId() >= 21 && player.getCurrentCircleId() <= 30) {
					playerX = noweKolko.getX() -5 + MathUtils.cosDeg(randomAngle) * randomRadius;
					playerY = noweKolko.getY() +20 + MathUtils.sinDeg(randomAngle) * randomRadius;
				} else {
					playerX = noweKolko.getX() + 20 + MathUtils.cosDeg(randomAngle) * randomRadius;
					playerY = noweKolko.getY() + 5 + MathUtils.sinDeg(randomAngle) * randomRadius;
				}
				player.sprite.setPosition(Math.round(playerX - (40 / 2)), Math.round(playerY - (40 / 2)));
			}
		}
	}
}
