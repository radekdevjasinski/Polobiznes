package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Graphics {
    private Texture pkpTexture;
    private Texture QuestionMarkRed;
    private Texture QuestionMarkBlue;
    private Texture Monkey;
    private Texture Frog;
    private Texture Policeman;
    private Texture Parking;
    private Texture Prison;
    private SpriteBatch batch;
    private CircleSquareDrawer circleSquareDrawer;

    public Graphics() {
        pkpTexture = new Texture(Gdx.files.internal("pkp.png"));
        QuestionMarkRed = new Texture(Gdx.files.internal("znakZapytaniaCzerwony.png"));
        QuestionMarkBlue = new Texture(Gdx.files.internal("znakZapytaniaNiebieski.png"));
        Monkey = new Texture(Gdx.files.internal("malpa.png"));
        Frog = new Texture(Gdx.files.internal("zabka.png"));
        Policeman = new Texture(Gdx.files.internal("policjant.png"));
        Parking = new Texture(Gdx.files.internal("parking.png"));
        Prison = new Texture(Gdx.files.internal("wiezienie.png"));
        batch = new SpriteBatch();
    }
public void Graphic() {
    batch.begin();
    int[] specialFieldsTrain = {5, 15, 25, 35};
    for (int specialField : specialFieldsTrain) {
        CircleObject circle = circleSquareDrawer.getCircleMap().get(specialField);
        if (circle != null) {
            float width = 40;
            float height = 40;
            if (specialField == 25) {
                batch.draw(pkpTexture, circle.getX() - 19, circle.getY(), width / 2, height / 2, width, height, 1, 1, 180, 0, 0, pkpTexture.getWidth(), pkpTexture.getHeight(), false, false);
            } else if (specialField == 15) {
                batch.draw(pkpTexture, circle.getX() - 35, circle.getY() - 20, width / 2, height / 2, width, height, 1, 1, 270, 0, 0, pkpTexture.getWidth(), pkpTexture.getHeight(), false, false);
            } else if (specialField == 35) {
                batch.draw(pkpTexture, circle.getX() - 5, circle.getY() - 20, width / 2, height / 2, width, height, 1, 1, 90, 0, 0, pkpTexture.getWidth(), pkpTexture.getHeight(), false, false);
            } else if (specialField == 5) {
                batch.draw(pkpTexture, circle.getX() - 20, circle.getY() - 37, width / 2, height / 2, width, height, 1, 1, 0, 0, 0, pkpTexture.getWidth(), pkpTexture.getHeight(), false, false);
            }
        }
    }
    batch.end();
    batch.begin();
    int[] specialFieldsQuestionMarkRed = {4, 17, 22, 33};
    for (int specialField : specialFieldsQuestionMarkRed) {
        CircleObject circle = circleSquareDrawer.getCircleMap().get(specialField);
        if (circle != null) {
            float width = 40;
            float height = 40;
            if (specialField == 33) {
                batch.draw(QuestionMarkRed, circle.getX() - 5, circle.getY() - 20, width / 2, height / 2, width, height, 1, 1, 90, 0, 0, QuestionMarkRed.getWidth(), QuestionMarkRed.getHeight(), false, false);
            } else if (specialField == 22) {
                batch.draw(QuestionMarkRed, circle.getX() - 19, circle.getY(), width / 2, height / 2, width, height, 1, 1, 180, 0, 0, QuestionMarkRed.getWidth(), QuestionMarkRed.getHeight(), false, false);
            } else if (specialField == 17) {
                batch.draw(QuestionMarkRed, circle.getX() - 35, circle.getY() - 20, width / 2, height / 2, width, height, 1, 1, 270, 0, 0, QuestionMarkRed.getWidth(), QuestionMarkRed.getHeight(), false, false);
            } else if (specialField == 4) {
                batch.draw(QuestionMarkRed, circle.getX() - 20, circle.getY() - 37, width / 2, height / 2, width, height, 1, 1, 0, 0, 0, QuestionMarkRed.getWidth(), QuestionMarkRed.getHeight(), false, false);
            }
        }
    }
    batch.end();
    batch.begin();
    int[] specialFieldsQuestionMarkBlue = {7, 28, 38};
    for (int specialField : specialFieldsQuestionMarkBlue) {
        CircleObject circle = circleSquareDrawer.getCircleMap().get(specialField);
        if (circle != null) {
            float width = 40;
            float height = 40;
            if (specialField == 38) {
                batch.draw(QuestionMarkBlue, circle.getX() - 5, circle.getY() - 20, width / 2, height / 2, width, height, 1, 1, 90, 0, 0, QuestionMarkBlue.getWidth(), QuestionMarkBlue.getHeight(), false, false);
            } else if (specialField == 28) {
                batch.draw(QuestionMarkBlue, circle.getX() - 19, circle.getY(), width / 2, height / 2, width, height, 1, 1, 180, 0, 0, QuestionMarkBlue.getWidth(), QuestionMarkBlue.getHeight(), false, false);
            } else if (specialField == 7) {
                batch.draw(QuestionMarkBlue, circle.getX() - 20, circle.getY() - 37, width / 2, height / 2, width, height, 1, 1, 0, 0, 0, QuestionMarkBlue.getWidth(), QuestionMarkBlue.getHeight(), false, false);
            }
        }
    }
    batch.end();
    batch.begin();
    int[] specialFieldsMonkey = {36};
    for (int specialField : specialFieldsMonkey) {
        CircleObject circle = circleSquareDrawer.getCircleMap().get(specialField);
        if (circle != null) {
            float width = 40;
            float height = 40;
            if (specialField == 36) {
                batch.draw(Monkey, circle.getX() - 5, circle.getY() - 20, width / 2, height / 2, width, height, 1, 1, 90, 0, 0, Monkey.getWidth(), Monkey.getHeight(), false, false);
            }
        }
    }
    batch.end();
    batch.begin();
    int[] specialFieldsFrog = {12};
    for (int specialField : specialFieldsFrog) {
        CircleObject circle = circleSquareDrawer.getCircleMap().get(specialField);
        if (circle != null) {
            float width = 40;
            float height = 40;
            if (specialField == 12) {
                batch.draw(Frog, circle.getX() - 35, circle.getY() - 20, width / 2, height / 2, width, height, 1, 1, 270, 0, 0, Frog.getWidth(), Frog.getHeight(), false, false);
            }
        }
    }
    batch.end();
    batch.begin();
    int[] specialFieldsPoliceman = {30};
    for (int specialField : specialFieldsPoliceman) {
        CircleObject circle = circleSquareDrawer.getCircleMap().get(specialField);
        if (circle != null) {
            float width = 40;
            float height = 40;
            if (specialField == 30) {
                batch.draw(Policeman, circle.getX() - 5, circle.getY() - 5, width / 2, height / 2, width, height, 1, 1, 130, 0, 0, Policeman.getWidth(), Policeman.getHeight(), false, false);
            }
        }
    }
    batch.end();
    batch.begin();
    int[] specialFieldsParking = {20};
    for (int specialField : specialFieldsParking) {
        CircleObject circle = circleSquareDrawer.getCircleMap().get(specialField);
        if (circle != null) {
            float width = 40;
            float height = 40;
            if (specialField == 20) {
                batch.draw(Parking, circle.getX() - 35, circle.getY() - 5, width / 2, height / 2, width, height, 1, 1, 230, 0, 0, Parking.getWidth(), Parking.getHeight(), false, false);
            }
        }
    }
    batch.end();
    batch.begin();
    int[] specialFieldsPrison = {10};
    for (int specialField : specialFieldsPrison) {
        CircleObject circle = circleSquareDrawer.getCircleMap().get(specialField);
        if (circle != null) {
            float width = 60;
            float height = 60;
            if (specialField == 10) {
                batch.draw(Prison, circle.getX() - 35, circle.getY() - 40, width / 2, height / 2, width, height, 1, 1, 320, 0, 0, Prison.getWidth(), Prison.getHeight(), false, false);
            }
        }
    }
    batch.end();
}

}
