package ru.bulletbox.game.engine.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.bulletbox.game.engine.SceneManager;

/**
 * Created by ress on 20.09.17.
 */
public class SceneGame extends Scene {
    SpriteBatch batch;
    Texture img;
    int x, y;

    @Override
    public void init(SceneManager sm) {
        super.init(sm); // NEED!!!

        x = y = 180;

        batch = new SpriteBatch();
        img = new Texture("image.jpg");
        return;
    }

    @Override
    public void step() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, x, reverseY(y));
        batch.end();
        return;
    }

    @Override
    public void destroy() {
        batch.dispose();
        img.dispose();
        return;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        x = screenX;
        y = screenY;
        return true;
    }

    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ENTER)
            changeScene(new SceneMain());

        return true;
    }

}
