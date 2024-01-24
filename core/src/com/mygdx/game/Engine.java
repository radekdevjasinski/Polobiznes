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
import com.badlogic.gdx.utils.Timer;
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
	private Graphics graphics;

	SpriteBatch batch;
	Texture logo;
	DiceControl diceControl;
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
	private Vector3 mousePosition = new Vector3();
	final int cooldown = 2;
	boolean commandReady = true;

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
		graphics = new Graphics();

		//primitiveRenderer = new PrimitiveRenderer();
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		circleObject = new CircleObject(500, 200, 50);
		squareObject = new SquareObject(300, 100, 50);



		closestCircleInfo = new ClosestCircleInfo(circleSquareDrawer);
		try {
			chance = new Chance();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		circleSquareDrawer = new CircleSquareDrawer(viewport, shapeRenderer);
		cardDisplay = new CardDisplay(new Card());

		diceControl = new DiceControl();

		try {
			chanceController = new ChanceController();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		game = new Game(circleSquareDrawer, chanceController);
		game.inicialization();

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
		graphics.Graphic();

		/*
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
		*/

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		for(Player player : game.getPlayerList())
		{
			batch.draw(player.sprite.getBitmap(), player.sprite.getX(), player.sprite.getY());

		}

		diceControl.draw(batch);
		diceControl.animate();


		batch.end();
		batch.begin();
		//closestCircleInfo.drawClosestCircleInfo(batch, player.getX(), player.getY());

		batch.end();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		circleSquareDrawer.drawCircles();
		shapeRenderer.end();

		//testowe wyświetlanie kart
		//UserInterface.drawCard(new CardDisplay(card), shapeRenderer, batch, camera);


		mousePosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(mousePosition);
		//Gdx.app.log("Debug", "Mouse Position: " + mousePosition.x + ", " + mousePosition.y);

		closestCircleInfo.updateClosestCircleInfo(mousePosition.x, mousePosition.y);

		float maxDistance = 50;

		if (!circleSquareDrawer.isMouseNearCircle((int) mousePosition.x, (int) mousePosition.y, maxDistance)) {
			//Gdx.app.log("Debug", "Myszka jest za daleko od kółek.");
		} else {
			CircleObject closestCircle = closestCircleInfo.findClosestCircleForMouse(mousePosition.x, mousePosition.y);
			//System.out.println("najblizsze kolo: " + closestCircle.getCityCard());
			if (closestCircle != null && closestCircle.getCityCard() != null) {
				//System.out.println("Circle Map: " + circleSquareDrawer.getCircleMap());
				UserInterface.drawCard(new CardDisplay(closestCircle.getCityCard()), shapeRenderer, batch, camera);
				//closestCircle.setCityCard(null); //czyszczenie (nie trzeba bo samo sie czysci ale moze sie przydac)
			}
		}
		//System.out.println("Circle Map: " + circleSquareDrawer.getCircleMap());
		UserInterface.drawPlayerPanel(game, shapeRenderer, batch, camera);

		if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) || Gdx.input.isButtonPressed(Input.Buttons.LEFT))
		{
			if (commandReady)
			{
				game.gameLoop(diceControl);
				commandReady = false;
				setCooldown();
			}
		}
		if (chanceController.randomChance != null)
		{
			UserInterface.drawChance(new ChanceDisplay(chanceController.randomChance), shapeRenderer, batch, camera);
		}


	}
	private void setCooldown() {
		// Ustawienie timera na opóźnienie 1 sekundy
		Timer.schedule(new Timer.Task() {
			@Override
			public void run() {
				// Kod do wykonania po upływie 1 sekundy
				commandReady = true; // Zmiana wartości boolean
			}
		}, cooldown); // Opóźnienie w sekundach
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
}
