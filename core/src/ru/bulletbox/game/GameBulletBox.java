package ru.bulletbox.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.bulletbox.game.engine.SceneManager;
import ru.bulletbox.game.engine.scenes.SceneMain;
import ru.bulletbox.game.engine.scenes.ScenePreload;

public class GameBulletBox extends ApplicationAdapter {
	SceneManager sceneManager;

	public void initSceneManager(int w, int h,  boolean fullscreen) {
		sceneManager = new SceneManager();
		sceneManager.setSize(w, h, true);
	}

	@Override
	public void create () {
		sceneManager.setScene(new ScenePreload());
	}

	@Override
	public void render () {
		sceneManager.step();
	}
	
	@Override
	public void dispose () {
		sceneManager.destroy();
	}

	@Override
	public void resize(int width, int height) {
		sceneManager.setSize(width, height);
	}
}
