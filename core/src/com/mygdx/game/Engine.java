package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.DiceRoll;
import java.util.Random;

public class Engine extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	DiceRoll diceRoll1;
	DiceRoll diceRoll2;
	float diceRoll1Timer;
	float diceRoll2Timer;
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
	@Override
	public void create() {
		batch = new SpriteBatch();
		background = new Texture("planszaPoloTlo.png");
    	//player = new Players("Player1", 1000, "pawn3.png");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		viewport = new FitViewport(background.getWidth(), background.getHeight(), camera);
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

		card = new Card("Bialystok", 200, 50, 100, 20, 150, 200, 250, 300, 400, 50);
		cardDisplay = new CardDisplay(batch, new BitmapFont(), card);

	}
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Texture playerImg = new Texture(player.getImagePath());
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

		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			diceRoll1.RollingAnimation();
			diceRoll2.RollingAnimation();
		}

		diceRoll1.animate();
		diceRoll2.animate();
		player.animate();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		batch.draw(background, 0, 0);
		batch.draw(player.getBitmap(),player.getX(), player.getY());
		batch.draw(diceRoll1.textures[diceRoll1.value], 550, 50);
		batch.draw(diceRoll1.textures[diceRoll2.value], 700, 50);

		batch.end();


		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		//<editor-fold desc="Prymitywy">
		int x = 70;
		PrimitiveRenderer.drawCircle(shapeRenderer,x,50,20,0, Color.RED);
		PrimitiveRenderer.drawSquare(shapeRenderer,x,100,40,0, Color.GREEN);
		PrimitiveRenderer.drawTriangle(shapeRenderer,x,150,40, Color.BLUE);
		circleObject.draw();
		squareObject.draw();
		//circleObject.translate(1, 1);
		//circleObject.scale(1.1f);
		//squareObject.scale(1.1001f);
		squareObject.rotate(1.1001f);
		//circleObject.rotate(1);
		//</editor-fold>

		//<editor-fold desc="Rysowanie linii">
		shapeRenderer.setColor(Color.BLACK);
		Point2D point1 = new Point2D(x+20, 200);
		Point2D point2 = new Point2D(70, 400);
		LineSegment lineSegment = new LineSegment(point1,point2);
		PrimitiveRenderer.drawLineAlgorithm(shapeRenderer,lineSegment);
		Point2D point3 = new Point2D(x+30, 200);
		Point2D point4 = new Point2D(80, 400);
		LineSegment lineSegment2 = new LineSegment(point3,point4);
		PrimitiveRenderer.drawLine(shapeRenderer,lineSegment2,5);
		//</editor-fold>

		//<editor-fold desc="Okrąg i elipsa">
		PrimitiveRenderer.drawCircleWithSymmetry(shapeRenderer,new Point2D(x,500),20,8);
		PrimitiveRenderer.drawEllipseWithSymmetry(shapeRenderer,new Point2D(x,550),20,10,8);
		//</editor-fold>

		//<editor-fold desc="Rysowanie wielokątów">
		shapeRenderer.setAutoShapeType(true);
		Array<Point2D> point2Ds = new Array<>();
		point2Ds.add(new Point2D(14, 100));
		point2Ds.add(new Point2D(14, 25));
		point2Ds.add(new Point2D(50, 75));
		point2Ds.add(new Point2D(94, 25));
		point2Ds.add(new Point2D(94, 100));

		PrimitiveRenderer.drawPolygon(shapeRenderer, point2Ds);

		point2Ds.clear();
		point2Ds.add(new Point2D(10, 180));
		point2Ds.add(new Point2D(10, 110));
		point2Ds.add(new Point2D(100, 110));
		point2Ds.add(new Point2D(70, 180));
		point2Ds.add(new Point2D(45, 200));

		PrimitiveRenderer.drawPolygon(shapeRenderer, point2Ds);
		//</editor-fold>

		//PrimitiveRenderer.floodFill(shapeRenderer, 220, Color.WHITE, Color.BLUE);

		cardDisplay.displayCardInfo();


		shapeRenderer.end();
	}



	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void dispose() {
		batch.dispose();
		background.dispose();
	}
}
