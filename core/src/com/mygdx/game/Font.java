package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Font {
    private final BitmapFont defaultFont;
    private final BitmapFont chanceFont;
    private final BitmapFont boardFont;
    private final BitmapFont cashFont;
    private final BitmapFont infoFont;
    private final BitmapFont cityFont;
    private static Font instance;
    private Font()
    {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("arialblack.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 16;
        parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS + "ąćęłńóśźżĄĆĘŁŃÓŚŹŻ";
        this.defaultFont = generator.generateFont(parameter);

        parameter.size = 20;
        this.chanceFont = generator.generateFont(parameter);

        parameter.size = 22;
        this.infoFont = generator.generateFont(parameter);

        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 1.5f;
        parameter.size = 10;
        this.boardFont = generator.generateFont(parameter);

        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 1.5f;
        parameter.size = 16;
        this.cashFont = generator.generateFont(parameter);

        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 1f;
        parameter.size = 16;
        this.cityFont = generator.generateFont(parameter);



        generator.dispose();
    }
    public static Font getFontInstance()
    {
        if (instance == null)
        {
            instance = new Font();
        }
        return instance;
    }
    public BitmapFont getFont(int index)
    {
        if (index == 1) {
            return chanceFont;
        }
        else if(index == 2)
        {
            return boardFont;
        }
        else if (index == 3)
        {
            return cashFont;
        }
        else if (index == 4)
        {
            return infoFont;
        }
        else if (index == 5)
        {
            return cityFont;
        }
        return defaultFont;
    }
}
