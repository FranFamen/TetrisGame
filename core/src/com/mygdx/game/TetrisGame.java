package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.eventInterfaces.OnExitListener;
import com.mygdx.game.eventInterfaces.OnGameOverListener;
import com.mygdx.game.eventInterfaces.OnPauseListener;
import com.mygdx.game.eventInterfaces.OnNewGameListener;
import com.mygdx.game.eventInterfaces.OnResumeListener;
import com.mygdx.game.states.GameOverMenuState;
import com.mygdx.game.states.InitialMenuState;
import com.mygdx.game.states.PauseMenuState;
import com.mygdx.game.states.PlayState;

public class TetrisGame extends ApplicationAdapter implements OnExitListener, OnNewGameListener, OnPauseListener, OnResumeListener, OnGameOverListener{
	private GameStateManager gameStateManager;
	private InitialMenuState initialMenuState;
	private PlayState playState;
	private PauseMenuState pauseMenuState;
	private GameOverMenuState gameOverMenuState;
	@Override
	public void create () {
		Storage.batch = new SpriteBatch();
		gameStateManager = new GameStateManager();
		Storage.assetManager = new AssetManager();
		Storage.loadTexture(AssetsNames.START_TEXTURE);
		Storage.loadTexture(AssetsNames.EXIT_TEXTURE);
		Storage.loadTexture(AssetsNames.TETRIS_LOGO_TEXTURE);
		Storage.loadTexture(AssetsNames.MENU_TEXTURE);
		Storage.loadTexture(AssetsNames.PAUSED_BTN);
		Storage.loadTexture(AssetsNames.RESUME_BTN);
		Storage.loadTexture(AssetsNames.GAME_OVER);
		Storage.loadTexture(AssetsNames.REPLAY_BTN);
		Storage.loadTexture(AssetsNames.FIELD_CELL_TEXTURE);
		Storage.assetManager.finishLoading();
		initialMenuState = new InitialMenuState();
		initialMenuState.onExitListener = this;
		initialMenuState.onRestartListener = this;
		Storage.font = new BitmapFont();
		Storage.font.getData().setScale(5);
		gameStateManager.add(initialMenuState);

	}

	@Override
	public void render () {
		gameStateManager.update();

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Storage.batch.begin();
		gameStateManager.draw();
		Storage.batch.end();
	}
	
	@Override
	public void dispose () {
		Storage.batch.dispose();
		Storage.assetManager.dispose();
		Storage.font.dispose();
	}

    @Override
    public void onExitRequested() {
        System.exit(0);
    }

	@Override
	public void onNewGameRequested() {
		if(gameStateManager.contains(initialMenuState)) {
			gameStateManager.remove(initialMenuState);
			initialMenuState = null;
		}
		if(gameStateManager.contains(gameOverMenuState)){
			gameStateManager.remove(gameOverMenuState);
			gameOverMenuState = null;
		}
		playState = new PlayState();
		gameStateManager.add(playState);
		playState.onPauseListener = this;
		playState.onGameOverListener = this;

	}

	@Override
	public void onPauseRequested() {
		pauseMenuState = new PauseMenuState();
		gameStateManager.add(pauseMenuState);
		pauseMenuState.onExitListener = this;
		pauseMenuState.onResumeListener = this;
	}

	@Override
	public void onResumeRequested() {
		gameStateManager.remove(pauseMenuState);
		pauseMenuState = null;
	}

	@Override
	public void onGameOverRequested() {
		gameStateManager.remove(playState);
		playState = null;
		gameOverMenuState = new GameOverMenuState();
		gameOverMenuState.onExitListener = this;
		gameOverMenuState.onNewGameListener = this;
		gameStateManager.add(gameOverMenuState);
	}
}
