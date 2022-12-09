package com.melody.game.stage.base;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.melody.game.MelodyGame;

/**
 * Base Stage
 */
public class BaseStage extends Stage {

    private MelodyGame melodyGame;

    public BaseStage(Viewport viewport, MelodyGame melodyGame) {
        super(viewport);
        this.melodyGame = melodyGame;
    }

    public MelodyGame getMelodyGame() {
        return melodyGame;
    }

}
