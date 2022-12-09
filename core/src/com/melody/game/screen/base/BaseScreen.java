package com.melody.game.screen.base;

import com.badlogic.gdx.ScreenAdapter;
import com.melody.game.MelodyGame;

/**
 * Base Screen
 */
public class BaseScreen extends ScreenAdapter {

    private MelodyGame melodyGame;

    public BaseScreen(MelodyGame melodyGame) {
        this.melodyGame = melodyGame;
    }

    public MelodyGame getMelodyGame() {
        return melodyGame;
    }

}
