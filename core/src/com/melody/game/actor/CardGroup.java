package com.melody.game.actor;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;

public class CardGroup extends BaseGroup {

    private Image card;

    private String numStr;

    private float height;

    private float width;

    public CardGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        card = new Image();
        this.addActor(card);

        Image tmp = new Image(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.GAME_CARD_EMPTY));
        width = tmp.getWidth();
        height = tmp.getHeight();

        this.setSize(width, height);

    }

    public void setNumStr(String numStr) {
        this.numStr = numStr;
        if(!numStr.equals("0")) {
            card.setDrawable(new TextureRegionDrawable(
                    getMelodyGame().getAtlas().findRegion(numStr)
            ));
            card.setSize(width, height);
        }

    }
}
