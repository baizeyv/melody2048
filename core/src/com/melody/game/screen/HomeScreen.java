package com.melody.game.screen;

import com.badlogic.gdx.Gdx;
import com.melody.game.MelodyGame;
import com.melody.game.screen.base.BaseScreen;
import com.melody.game.stage.HomeStage;

/**
 * Home Screen
 */
public class HomeScreen extends BaseScreen {

    private HomeStage homeStage;

    public HomeStage getHomeStage() {
        return homeStage;
    }

    public HomeScreen(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        /* load home stage */
        homeStage = new HomeStage(getMelodyGame().getViewport(), getMelodyGame());
        Gdx.input.setInputProcessor(homeStage);
    }

    @Override
    public void render(float delta) {
        homeStage.act();
        homeStage.draw();
    }

    @Override
    public void dispose() {
        homeStage.dispose();
    }
}
