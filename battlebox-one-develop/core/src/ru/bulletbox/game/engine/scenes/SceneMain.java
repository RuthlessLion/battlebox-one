package ru.bulletbox.game.engine.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.bulletbox.game.engine.SceneManager;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.Input.Buttons;


/**
 * Created by ress on 20.09.17.
 */
public class SceneMain extends Scene {
    SpriteBatch batch;
    Texture texture;
    Sprite sprite;
    int x,y;

    @Override
    public void init(SceneManager sm) {
        super.init(sm); // NEED!!!
        x = y =-200 ;
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
        Gdx.gl.glClearColor(0 , 255, 255, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(sprite, x-7, reverseY(y+46),48,48);
        batch.end();
        return;
    }

    @Override
    public void destroy() {
        batch.dispose();
        texture.dispose();
        return;
    }

    @Override
    protected int reverseY(int y) {
        return super.reverseY(y);
    }

    public boolean mouseMoved(int screenX, int screenY) {
        x = screenX;
        y = screenY;
        Gdx.input.setCursorCatched(true);
        return true;
    }
    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.SPACE)
            changeScene(new SceneGame());
        if (keycode == Input.Keys.ESCAPE)
            System.exit(0);
        return true;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return true;
    }

}