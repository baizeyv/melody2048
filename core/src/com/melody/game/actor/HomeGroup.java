package com.melody.game.actor;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;

public class HomeGroup extends BaseGroup {
    private HomeTopGroup homeTopGroup;

    private HomeButtonGroup homeButtonGroup;

    private Image background;

    private Image titleImg;


    public HomeGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        /* background picture */
        background = new Image(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.BACKGROUND));
        background.setSize(getMelodyGame().getWorldWidth(), getMelodyGame().getWorldHeight());
        background.setPosition(0, 0);
        this.addActor(background);

        /* init top button */
        homeTopGroup = new HomeTopGroup(getMelodyGame());
        homeTopGroup.setPosition(getMelodyGame().getWorldWidth() / 2 - homeTopGroup.getWidth() / 2, getMelodyGame().getWorldHeight() - homeTopGroup.getHeight() - 20);
        this.addActor(homeTopGroup);

        /* init title picture */
        titleImg = new Image(getMelodyGame().getAtlas().findRegion(Res.ATLAS_RES.HOME_TITLE_NEW));
        titleImg.setPosition(0, homeTopGroup.getY() - titleImg.getHeight() - 50);
        this.addActor(titleImg);

        /* init main button */
        homeButtonGroup = new HomeButtonGroup(getMelodyGame());
        homeButtonGroup.setPosition(getMelodyGame().getWorldWidth() / 2 - homeButtonGroup.getWidth() / 2, titleImg.getY() - homeButtonGroup.getHeight() - 50);
        this.addActor(homeButtonGroup);

        this.setSize(getMelodyGame().getWorldWidth(), getMelodyGame().getWorldHeight());
    }
}
