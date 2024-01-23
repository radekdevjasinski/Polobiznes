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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.io.IOException;


/**
 * Klasa Engine reprezentuje główny silnik gry.
 */
public class Engine extends ApplicationAdapter {

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
	private Player player;
	private Card card;
	private CardDisplay cardDisplay;
	private Chance chance;
	private ChanceDisplay chanceDisplay;
	Texture pkpTexture;
	Texture QuestionMarkRed;

	/**
	 * Metoda inicjalizująca obiekty i parametry gry.
	 */
	@Override
	public void create() {
		batch = new SpriteBatch();
    	//player = new Players("Player1", 1000, "pawn3.png");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//background = new Texture("planszaPoloTlo.png");
		viewport = new FitViewport(1000, 600, camera);
		viewport.apply();

		player = new Player("pionek");
		player.setPosition(500, 400); // Ustawienie pozycji pionka

		//primitiveRenderer = new PrimitiveRenderer();
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		circleObject = new CircleObject(500, 200, 50);
		squareObject = new SquareObject(300, 100, 50);
		game = new Game();
		game.setPlayers();
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
		player.animate();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		batch.draw(player.getBitmap(),player.getX(), player.getY());
		batch.draw(diceRoll1.textures[diceRoll1.value], 790, 30);
		batch.draw(diceRoll1.textures[diceRoll2.value], 890, 30);


		batch.end();
		batch.begin();
		//closestCircleInfo.drawClosestCircleInfo(batch, player.getX(), player.getY());

		batch.end();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		circleSquareDrawer.drawCircles();
		shapeRenderer.end();

		//UserInterface.drawCard(new CardDisplay(card), shapeRenderer, batch, camera);
		//UserInterface.drawChance(new ChanceDisplay(chance), shapeRenderer, batch, camera);


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
	}

	private void movePlayerToAdjacentCircle(int direction) {
		int liczbaKolek = 40; // Ilość okręgów

		circleSquareDrawer.updateCircleInfo();

		int noweIdKolka = (player.getCurrentCircleId() + direction + liczbaKolek) % liczbaKolek;

		player.setCurrentCircleId(noweIdKolka);

		CircleObject noweKolko = circleSquareDrawer.getCircleMap().get("Circle_" + noweIdKolka);
		if (noweKolko != null) {
			float randomAngle = MathUtils.random(360);
			float randomRadius = MathUtils.random(0, 10);

			float playerX = noweKolko.getX() + MathUtils.cosDeg(randomAngle) * randomRadius;
			float playerY = noweKolko.getY() + MathUtils.sinDeg(randomAngle) * randomRadius;

			player.setPosition(Math.round(playerX - (40 / 2)), Math.round(playerY - (40 / 2)));
		}
	}


}
