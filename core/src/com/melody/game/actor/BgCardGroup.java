package com.melody.game.actor;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;

public class BgCardGroup extends BaseGroup {

    private Image bgImg;

    public BgCardGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        bgImg = new Image(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.GAME_CARD_EMPTY));
        this.addActor(bgImg);

        this.setSize(bgImg.getWidth(), bgImg.getHeight());
    }
}
