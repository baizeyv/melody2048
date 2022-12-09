package com.melody.game.actor.base;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.melody.game.MelodyGame;

public class BaseGroup extends Group {

    private MelodyGame melodyGame;

    public MelodyGame getMelodyGame() {
        return melodyGame;
    }

    public BaseGroup(MelodyGame melodyGame) {
        this.melodyGame = melodyGame;
    }
}
