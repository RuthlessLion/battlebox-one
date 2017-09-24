package ru.bulletbox.game.engine.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import ru.bulletbox.game.engine.Player;
import ru.bulletbox.game.engine.SceneManager;


/**
 * Created by ress on 20.09.17.
 */
public class SceneGame extends Scene {
    SpriteBatch batch;
    Texture texture;
    Sprite sprite;
    int x, y = 0;
    TiledMap map;
    OrthogonalTiledMapRenderer renderer;
    OrthographicCamera camera;
    Player player;


    @Override
    public void init(SceneManager sm) {
        super.init(sm); // NEED!!!
        x = y = -200;
        batch = new SpriteBatch();
        texture = new Texture(createPixmap());
        sprite = new Sprite(texture);
        sprite.setPosition(0,0);
        sprite.setSize(48,48);

        map = new TmxMapLoader().load("map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        player = new Player(new Sprite(new Texture("steve.png")),0,0);
        player.setPosition(500,500);

        return;
    }

    public void resize(float width, float height){
        camera.viewportWidth = Gdx.graphics.getWidth();
        camera.viewportHeight = Gdx.graphics.getHeight();
        camera.update();
        camera.update(true);
    }

    private Pixmap createPixmap(){
        Pixmap pixmap = new Pixmap(Gdx.files.internal("cursor.png"));
        return pixmap;
    }

    @Override
    public void step() {
        /*if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) camera.position.x -= 5;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) camera.position.x += 5;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) camera.position.y += 5;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) camera.position.y -= 5;*/

        camera.position.x = (int)player.x;
        camera.position.y = (int)player.y;


        Gdx.gl.glClearColor(127/255f , 140/255f, 141/255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //camera.setToOrtho(false,30, 20);

        //camera.position.set(0,0,0);
        resize(sceneManager.width, sceneManager.width);
        //camera.update();

        batch.begin();
        //batch.draw(sprite, x-7, reverseY(y+46),48,48);
        renderer.render();
        renderer.getBatch().begin();
        player.draw(renderer.getBatch());
        renderer.getBatch().end();
        batch.end();

        renderer.setView(camera);
        //camera.update();
        return;
    }

    @Override
    public void destroy() {
        batch.dispose();
        map.dispose();
        renderer.dispose();
        return;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        x = screenX;
        y = screenY;
        //Gdx.input.setCursorCatched(true);
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
