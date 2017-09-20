package ru.bulletbox.game.engine.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.bulletbox.game.engine.SceneManager;

/**
 * Created by ress on 20.09.17.
 */
public class SceneGame extends Scene {
    SpriteBatch batch;
    Texture texture;
    Sprite sprite;
    int x, y;

    @Override
    public void init(SceneManager sm) {
        super.init(sm); // NEED!!!
        x = y = -200;
        batch = new SpriteBatch();
        texture = new Texture(createPixmap());
        sprite = new Sprite(texture);
        sprite.setPosition(0,0);
        sprite.setSize(48,48);
        return;
    }

    private Pixmap createPixmap(){
        Pixmap pixmap = new Pixmap(Gdx.files.internal("cursor.png"));
        return pixmap;
    }

    @Override
    public void step() {
        Gdx.gl.glClearColor(255, 0, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(sprite, x-7, reverseY(y+46),48,48);
        batch.end();
        return;
    }

    @Override
    public void destroy() {
        batch.dispose();
        return;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        x = screenX;
        y = screenY;
        Gdx.input.setCursorCatched(true);
        return true;
    }

    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ENTER)
            changeScene(new SceneMain());
        if (keycode == Input.Keys.ESCAPE)
            System.exit(0);
        return true;
    }

}
