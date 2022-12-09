package com.melody.game.actor;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.melody.game.MelodyGame;
import com.melody.game.actor.base.BaseGroup;
import com.melody.game.resource.Res;

public class MenuGroup extends BaseGroup {

    private MenuTitleGroup menuTitleGroup;

    private MenuBgGroup menuBgGroup;

    private MenuButtonGroup menuButtonGroup;

    public MenuGroup(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        menuBgGroup = new MenuBgGroup(getMelodyGame());
        this.addActor(menuBgGroup);

        menuTitleGroup = new MenuTitleGroup(getMelodyGame());
        menuTitleGroup.setX(getMelodyGame().getWorldWidth() / 2 - menuTitleGroup.getWidth() / 2);

        menuButtonGroup = new MenuButtonGroup(getMelodyGame());
        menuButtonGroup.setX(getMelodyGame().getWorldWidth() / 2 - menuButtonGroup.getWidth() / 2);
        menuButtonGroup.setY(getMelodyGame().getWorldHeight() / 2 - menuTitleGroup.getHeight() / 2 - menuButtonGroup.getHeight() / 2 - 50);
        this.addActor(menuButtonGroup);

        menuTitleGroup.setY(menuButtonGroup.getY() + menuButtonGroup.getHeight() + 100);
        this.addActor(menuTitleGroup);

        this.setSize(getMelodyGame().getWorldWidth(), getMelodyGame().getWorldHeight());
    }

}
