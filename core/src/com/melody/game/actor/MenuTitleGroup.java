package com.melody.game.actor;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;

public class MenuTitleGroup extends BaseGroup {

    private Image titleImg;

    public MenuTitleGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        titleImg = new Image(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.MENU_TITLE));
        this.addActor(titleImg);

        this.setSize(titleImg.getWidth(), titleImg.getHeight());
    }

}
