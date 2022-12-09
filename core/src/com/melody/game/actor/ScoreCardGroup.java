package com.melody.game.actor;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;

public class ScoreCardGroup extends BaseGroup {

    private Image scoreCard;

    private String numStr;

    public ScoreCardGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        scoreCard = new Image(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.SCORE_EMPTY));
        this.addActor(scoreCard);

        this.setSize(scoreCard.getWidth(), scoreCard.getHeight());
    }

    public void setNumStr(String numStr) {
        this.numStr = numStr;
        scoreCard.setDrawable(
                new TextureRegionDrawable(
                        getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.SCORE_NUMBER_PREFIX + numStr)
                )
        );
    }

}
