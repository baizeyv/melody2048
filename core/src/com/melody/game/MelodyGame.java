package com.melody.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.melody.game.resource.Res;
import com.melody.game.screen.GameScreen;
import com.melody.game.screen.HomeScreen;

public class MelodyGame extends Game {

	private AssetManager assetManager;

	private OrthographicCamera camera;

	private Viewport viewport;

	private TextureAtlas atlas;

	private float worldWidth;

	private float worldHeight;

	private HomeScreen homeScreen;

	private GameScreen gameScreen;

	private Music music;

	public HomeScreen getHomeScreen() {
		return homeScreen;
	}

	public Music getMusic() {
		return music;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	@Override
	public void create () {

		/* calculate the width and height of game world */
		worldWidth = Res.WORLD_WIDTH_FIXED;
		worldHeight = Gdx.graphics.getHeight()  * worldWidth / Gdx.graphics.getWidth();

		camera = new OrthographicCamera(worldWidth / 2, worldHeight / 2);

		viewport = new StretchViewport(worldWidth, worldHeight, camera);

		/* init assets manager */
		assetManager = new AssetManager();
		// load image resource
		assetManager.load(Res.ATLAS_PATH, TextureAtlas.class);
		// load audio resource
		assetManager.load(Res.AUDIO_RES.BGM, Music.class);
		assetManager.load(Res.AUDIO_RES.BUTTON_SOUND, Sound.class);
		assetManager.load(Res.AUDIO_RES.COLLISION_1, Sound.class);
		assetManager.load(Res.AUDIO_RES.COLLISION_2, Sound.class);
		assetManager.load(Res.AUDIO_RES.HIGHER_NUM, Sound.class);
		assetManager.finishLoading();
		atlas = assetManager.get(Res.ATLAS_PATH, TextureAtlas.class);
		music = assetManager.get(Res.AUDIO_RES.BGM, Music.class);

		music.setLooping(true);
		music.play();

		showHomeScreen();
	}

	public void showHomeScreen() {
		setScreen(homeScreen = new HomeScreen(this));
		if(gameScreen != null) {
			gameScreen.dispose();
			gameScreen = null;
		}
	}

	public void showGameScreen() {
		setScreen(gameScreen = new GameScreen(this));
		if(homeScreen != null) {
			homeScreen.dispose();
			homeScreen = null;
		}
	}

	public void showMenu() {
		getGameScreen().getGameStage().openMenu();
	}

	public void removeMenu() {
		getGameScreen().getGameStage().removeMenu();
	}

	public void menuRetry() {
		getGameScreen().getGameStage().getGameGroup().getGameFrameGroup().restart();
		getGameScreen().getGameStage().getGameGroup().getGameFrameGroup().scoreSync();
	}

	@Override
	public void dispose () {
		assetManager.dispose();
		homeScreen.dispose();
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public Viewport getViewport() {
		return viewport;
	}

	public TextureAtlas getAtlas() {
		return atlas;
	}

	public float getWorldWidth() {
		return worldWidth;
	}

	public float getWorldHeight() {
		return worldHeight;
	}
}
