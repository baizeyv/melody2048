package com.melody.game.stage;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.melody.game.MelodyGame;
import com.melody.game.actor.HomeGroup;
import com.melody.game.stage.base.BaseStage;

public class HomeStage extends BaseStage {

    private HomeGroup homeGroup;

    public HomeStage(Viewport viewport, MelodyGame melodyGame) {
        super(viewport, melodyGame);
        init();
    }

    private void init() {
        homeGroup = new HomeGroup(getMelodyGame());
        homeGroup.setPosition(0, 0);
        this.addActor(homeGroup);
    }

    public HomeGroup getHomeGroup() {
        return homeGroup;
    }
}
