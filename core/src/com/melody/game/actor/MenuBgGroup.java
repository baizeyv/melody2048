package com.melody.game.actor;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;

public class MenuBgGroup extends BaseGroup {

    private Image bgImg;

    public MenuBgGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        bgImg = new Image(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.MENU_BACKGROUND));
        bgImg.setSize(getMelodyGame().getWorldWidth(), getMelodyGame().getWorldHeight());
        this.addActor(bgImg);

        this.setSize(bgImg.getWidth(), bgImg.getHeight());
    }

}
