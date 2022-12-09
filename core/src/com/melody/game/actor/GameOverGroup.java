package com.melody.game.actor;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;

public class GameOverGroup extends BaseGroup {

    private Image img;

    public GameOverGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        img = new Image(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.GAME_OVER));
        img.setPosition(0, 0);
        this.addActor(img);

        this.setSize(img.getWidth(), img.getHeight());

        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getMelodyGame().showHomeScreen();
            }
        });
    }

}
