package ru.bulletbox.game.engine.scenes;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.bulletbox.game.engine.SceneManager;

/**
 * Created by RuthlessLion on 20.09.17.
 */

public class ScenePreload extends Scene {
    SpriteBatch batch;
    Texture texture;
    Texture texture2;
    Sprite sprite;
    Sprite sprite2;
    int x,y,width,height;
    double time;

    @Override
    public void init(SceneManager sm) {
        super.init(sm); // NEED!!!
        x = y =-200 ;
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        texture = new Texture(createPixmap());
        sprite = new Sprite(texture);
        sprite.setPosition(0,0);
        sprite.setSize(48,48);
        texture2 = new Texture(Gdx.files.internal("preload.png"));
        sprite2 = new Sprite(texture2, 0, 0, 900, 200);
        sprite2.setPosition((width-900)/2, (height-200)/2);
    }

    private Pixmap createPixmap(){
        Pixmap pixmap = new Pixmap(Gdx.files.internal("cursor.png"));
        return pixmap;
    }

    @Override
    public void step() {
        time += Gdx.graphics.getDeltaTime();
        System.out.println(time);
        if(time >=4)
            changeScene(new SceneGame());
        Gdx.gl.glClearColor(127/255f , 140/255f, 141/255f, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite2.draw(batch);
        batch.draw(sprite, x-7, reverseY(y+46),48,48);
        batch.end();
    }

    @Override
    public void destroy() {
        batch.dispose();
        texture.dispose();
    }

    public boolean mouseMoved(int screenX, int screenY) {
        x = screenX;
        y = screenY;
        Gdx.input.setCursorCatched(true);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        x = screenX;
        y = screenY;
        return super.touchDragged(screenX, screenY, pointer);
    }

    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ENTER)
            changeScene(new SceneMain());
        if (keycode == Input.Keys.SPACE)
            changeScene(new SceneGame());
        if (keycode == Input.Keys.ESCAPE)
            System.exit(0);
        return true;
    }
}
