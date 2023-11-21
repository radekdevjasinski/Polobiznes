// SpriteObject.java
package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import java.util.ArrayList;
import java.util.List;

public class SpriteObject extends BitmapObject implements TransformableObject, Animation {
    private static final float FRAME_DURATION = 0.2f; // Czas trwania jednej klatki animacji
    private float stateTime; // Czas trwania animacji
    private List<BitmapHandler> frames; // Lista zawierająca wszystkie klatki animacji
    private int x, y;

    public SpriteObject(String baseFileName, int frameCount) {
        super(new BitmapHandler(100, 100)); // Pusty BitmapHandler na początku
        stateTime = 0f;
        x = 0;
        y = 0;
        loadFrames(baseFileName, frameCount);
    }

    private void loadFrames(String baseFileName, int frameCount) {
        frames = new ArrayList<>();
        for (int i = 1; i <= frameCount; i++) {
            String fileName = baseFileName + "_" + i + ".bmp";
            BitmapHandler frameBitmap = new BitmapHandler(100, 100);
            frameBitmap.loadFromFile(fileName);
            frames.add(frameBitmap);
        }
    }
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void animate() {
        stateTime += Gdx.graphics.getDeltaTime();

        // Przykładowa animacja zmieniająca klatki co FRAME_DURATION sekundy
        int frameIndex = (int) (stateTime / FRAME_DURATION) % getFrameCount();

        // Ustaw odpowiednią klatkę animacji
        frames.get(frameIndex).copyTo(bitmapHandler);
    }

    private int getFrameCount() {
        return frames.size();
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
    public BitmapHandler getBitmap() {
        return bitmapHandler;
    }
}
