package com.melody.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;
import com.melody.game.screen.HomeScreen;

public class MenuButtonGroup extends BaseGroup {

    private Button resumeBtn;

    private Button menuBtn;

    private Button retryBtn;

    public MenuButtonGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {

        Button.ButtonStyle retryStyle = new Button.ButtonStyle();
        retryStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.MENU_RETRY));
        retryStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.MENU_RETRY));
        retryBtn = new Button(retryStyle);
        retryBtn.setPosition(0, 0);
        this.addActor(retryBtn);

        Button.ButtonStyle menuStyle = new Button.ButtonStyle();
        menuStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.MENU_MENU));
        menuStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.MENU_MENU));
        menuBtn = new Button(menuStyle);
        menuBtn.setPosition(0, retryBtn.getY() + retryBtn.getHeight() + 20);
        this.addActor(menuBtn);

        Button.ButtonStyle resumeStyle = new Button.ButtonStyle();
        resumeStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.MENU_RESUME));
        resumeStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.MENU_RESUME));
        resumeBtn = new Button(resumeStyle);
        resumeBtn.setPosition(0, menuBtn.getY() + menuBtn.getHeight() + 20);
        this.addActor(resumeBtn);

        this.setSize(resumeBtn.getPrefWidth(), retryBtn.getPrefHeight() + menuBtn.getHeight() + resumeBtn.getHeight() + 40);

        resumeBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getMelodyGame().removeMenu();
            }
        });

        menuBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getMelodyGame().showHomeScreen();
            }
        });

        retryBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getMelodyGame().removeMenu();
                getMelodyGame().menuRetry();
            }
        });
    }
}
