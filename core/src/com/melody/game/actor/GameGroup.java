package com.melody.game.actor;

import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;

public class GameGroup extends BaseGroup {

    private GameTopGroup gameTopGroup;

    private GameFrameGroup gameFrameGroup;

    public GameGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    public GameFrameGroup getGameFrameGroup() {
        return gameFrameGroup;
    }

    private void init() {

        gameTopGroup = new GameTopGroup(getMelodyGame());
        gameTopGroup.setPosition(getMelodyGame().getWorldWidth() / 2 - gameTopGroup.getWidth() / 2,
                getMelodyGame().getWorldHeight() - gameTopGroup.getHeight() - 20);
        this.addActor(gameTopGroup);



        gameFrameGroup = new GameFrameGroup(getMelodyGame());
        gameFrameGroup.setPosition(getMelodyGame().getWorldWidth() / 2 - gameFrameGroup.getWidth() / 2,
                getMelodyGame().getWorldHeight() / 2 - gameFrameGroup.getHeight() / 2);
        this.addActor(gameFrameGroup);

    }

}
