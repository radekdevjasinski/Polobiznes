// SpriteObject.java
package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import java.util.ArrayList;
import java.util.List;

public class SpriteObject extends BitmapHandler implements TransformableObject, Animation {
    private static final float FRAME_DURATION = 0.2f; // Czas trwania jednej klatki animacji
    private float stateTime; // Czas trwania animacji
    private float timeSeconds;
    private List<BitmapHandler> frames; // Lista zawierająca wszystkie klatki animacji
    private int currentFrame;
    private int frameCount;
    protected int x, y;



    public SpriteObject(String baseFileName, int frameCount) {
        super(baseFileName+"_0.bmp");
        stateTime = 0.1f;
        timeSeconds = 0;
        currentFrame = 0;
        this.frameCount = frameCount;
        x = 0;
        y = 0;
        loadFrames(baseFileName);
    }

    private void loadFrames(String baseFileName) {
        frames = new ArrayList<>();
        for (int i = 0; i <= frameCount; i++) {
            String fileName = baseFileName + "_" + i + ".bmp";
            BitmapHandler frameBitmap = new BitmapHandler(fileName);
            frames.add(frameBitmap);
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void animate(){
        if(timeSeconds < stateTime)
        {
            timeSeconds += Gdx.graphics.getDeltaTime();
        }
        else
        {
            timeSeconds = 0;
            if(currentFrame >= frameCount)
                currentFrame = 0;
            setBitmap(frames.get(currentFrame).getBitmap());
            currentFrame++;
        }
    }
    @Override
    public void translate(float deltaX, float deltaY) {

    }

    @Override
    public void rotate(float degrees) {

    }

    @Override
    public void scale(float factor) {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
