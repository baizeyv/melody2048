package com.melody.game.actor;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;
import com.melody.game.screen.GameScreen;

public class HomeButtonGroup extends BaseGroup {

    private Button classicBtn;

    private Button timeBtn;

    private Button moreBtn;

    public HomeButtonGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        Button.ButtonStyle moreStyle = new Button.ButtonStyle();
        moreStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_BTN_MORE_UP));
        moreStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_BTN_MORE_DOWN));
        moreBtn = new Button(moreStyle);
        moreBtn.setPosition(0, 0);
        this.addActor(moreBtn);

        Button.ButtonStyle timeStyle = new Button.ButtonStyle();
        timeStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_BTN_TIME_UP));
        timeStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_BTN_TIME_DOWN));
        timeBtn = new Button(timeStyle);
        timeBtn.setPosition(0, moreBtn.getY() + moreBtn.getHeight() + 20);
        this.addActor(timeBtn);

        Button.ButtonStyle classicStyle = new Button.ButtonStyle();
        classicStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_BTN_CLASSIC_UP));
        classicStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_BTN_CLASSIC_DOWN));
        classicBtn = new Button(classicStyle);
        classicBtn.setPosition(0, timeBtn.getY() + timeBtn.getHeight() + 20);
        this.addActor(classicBtn);

        this.setSize(moreBtn.getPrefWidth(), moreBtn.getHeight() + timeBtn.getHeight() + classicBtn.getHeight() + 40);

        classicBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getMelodyGame().showGameScreen();
            }
        });
    }
}
