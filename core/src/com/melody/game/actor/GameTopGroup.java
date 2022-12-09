package com.melody.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;

public class GameTopGroup extends BaseGroup {

    private Button volBtn;

    private Button menuBtn;

    private Image scoreTitle;

    public GameTopGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        /* init vol button */
        final Button.ButtonStyle volStyle = new Button.ButtonStyle();
        if(getMelodyGame().getMusic().isPlaying()) {
            volStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_ON));
            volStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_OFF));
        } else {
            volStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_ON));
            volStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_OFF));
        }
        volBtn = new Button(volStyle);
        volBtn.setPosition(0, 0);
        this.addActor(volBtn);

        /* init menu button */
        Button.ButtonStyle menuStyle = new Button.ButtonStyle();
        menuStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.GAME_BTN_MENU));
        menuStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.GAME_BTN_MENU));
        menuBtn = new Button(menuStyle);
        menuBtn.setPosition(getMelodyGame().getWorldWidth() - menuBtn.getPrefWidth() - 40, volBtn.getY());
        this.addActor(menuBtn);

        /* init score title */
        scoreTitle = new Image(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.GAME_SCORE_TITLE));
        scoreTitle.setPosition(volBtn.getX() + volBtn.getWidth() + (menuBtn.getX() - volBtn.getX() - volBtn.getPrefWidth()) / 2 - scoreTitle.getWidth() / 2, volBtn.getY());
        this.addActor(scoreTitle);

        this.setSize(getMelodyGame().getWorldWidth() - 40, Math.max(volBtn.getHeight(), menuBtn.getHeight()));

        volBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Music mc = getMelodyGame().getMusic();
                if(mc.isPlaying()) {
                    volStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_OFF));
                    volStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_ON));
                    volBtn.setStyle(volStyle);
                    mc.stop();
                } else {
                    volStyle.up = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_ON));
                    volStyle.down = new TextureRegionDrawable(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TOP_VOL_OFF));
                    volBtn.setStyle(volStyle);
                    mc.play();
                }
            }
        });

        menuBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getMelodyGame().showMenu();
            }
        });

    }
}
