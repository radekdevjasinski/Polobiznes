package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
	float timeSeconds;
    private Game game;
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;
	private Viewport viewport;
	private PrimitiveRenderer primitiveRenderer;
	@Override
	public void create() {
		batch = new SpriteBatch();
		background = new Texture("planszaPoloTlo.png");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		viewport = new FitViewport(background.getWidth(), background.getHeight(), camera);
		viewport.apply();
		primitiveRenderer = new PrimitiveRenderer();
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);

		game = new Game();
		game.setPlayers();
		diceRoll1 = new DiceRoll();
		diceRoll2 = new DiceRoll();

		RollingAnimation();
		timeSeconds = 0f;
	}
	public static Texture resizeTexture(String path, int width, int height)
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
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		batch.draw(background, 0, 0);

		batch.draw(diceRoll1.textures[diceRoll1.value], 550, 50);
		batch.draw(diceRoll1.textures[diceRoll2.value], 700, 50);

		batch.end();

		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		int x = 70;

		primitiveRenderer.drawCircle(shapeRenderer,x,50,20, Color.RED);
		primitiveRenderer.drawSquare(shapeRenderer,x,100,40, Color.GREEN);
		primitiveRenderer.drawTriangle(shapeRenderer,x,150,40, Color.BLUE);

		shapeRenderer.setColor(Color.BLACK);
		Point2D point1 = new Point2D(x+20, 200);
		Point2D point2 = new Point2D(70, 400);
		LineSegment lineSegment = new LineSegment(point1,point2);
		primitiveRenderer.drawLineAlgorithm(shapeRenderer,lineSegment);
		Point2D point3 = new Point2D(x+30, 200);
		Point2D point4 = new Point2D(80, 400);
		LineSegment lineSegment2 = new LineSegment(point3,point4);
		primitiveRenderer.drawLine(shapeRenderer,lineSegment2,5);

		shapeRenderer.end();
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
	}
	@Override
	public void dispose() {
		batch.dispose();
		background.dispose();
	}
}
