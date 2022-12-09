package com.melody.game.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.melody.game.MelodyGame;
import com.melody.game.actor.GameGroup;
import com.melody.game.actor.GameOverGroup;
import com.melody.game.actor.MenuGroup;
import com.melody.game.stage.base.BaseStage;

public class GameStage extends BaseStage {

    private GameGroup gameGroup;

    private MenuGroup menuGroup;

    private GameOverGroup gameOverGroup;

    public GameGroup getGameGroup() {
        return gameGroup;
    }

    public GameStage(Viewport viewport, MelodyGame melodyGame) {
        super(viewport, melodyGame);
        init();
    }

    private void init() {
        gameGroup = new GameGroup(getMelodyGame());
        this.addActor(gameGroup);
    }

    public void openMenu() {
        Gdx.app.error("GAME STAGE", "open menu");
        menuGroup = new MenuGroup(getMelodyGame());
        menuGroup.setPosition(0, 0);
        this.addActor(menuGroup);
    }

    public void gameOver() {
        gameOverGroup = new GameOverGroup(getMelodyGame());
        gameOverGroup.setPosition(getMelodyGame().getWorldWidth() / 2 - gameOverGroup.getWidth() / 2, getMelodyGame().getWorldHeight() / 2 - gameOverGroup.getHeight() / 2);
        this.addActor(gameOverGroup);
    }

    public void removeMenu() {
        menuGroup.remove();
    }
}
