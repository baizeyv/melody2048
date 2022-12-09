package com.melody.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.melody.game.MelodyGame;
import com.melody.game.screen.base.BaseScreen;
import com.melody.game.stage.GameStage;

public class GameScreen extends BaseScreen {

    private GameStage gameStage;

    public GameScreen(MelodyGame melodyGame) {
        super(melodyGame);
        init();
    }

    private void init() {
        gameStage = new GameStage(getMelodyGame().getViewport(), getMelodyGame());
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(255, 255, 255, 1);
        gameStage.act();
        gameStage.draw();
    }

    public GameStage getGameStage() {
        return gameStage;
    }

    @Override
    public void dispose() {
        gameStage.dispose();
    }
}
