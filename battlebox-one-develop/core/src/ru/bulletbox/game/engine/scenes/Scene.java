package ru.bulletbox.game.engine.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import ru.bulletbox.game.engine.SceneManager;

/**
 * Created by ress on 20.09.17.
 */
public class Scene implements InputProcessor {
    protected SceneManager sceneManager;

    // HIDED METHODS

    protected int reverseY(int y) {
        return sceneManager.height - y;
    }

    protected void changeScene(Scene scene) {
        sceneManager.setScene(scene);
    }

    // INIT

    public void init(SceneManager sm) {
        sceneManager = sm;
        Gdx.input.setInputProcessor(this);
    }

    // ENGINE METHODS

    public void step() {

    }
    public void destroy() {

    }

    // INPUT METHODS

    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }
}
