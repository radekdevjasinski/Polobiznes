package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Font {
    private final BitmapFont defaultFont;
    private final BitmapFont chanceFont;
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
        return defaultFont;
    }
}
