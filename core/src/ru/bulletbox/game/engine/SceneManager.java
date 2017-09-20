package ru.bulletbox.game.engine;

import ru.bulletbox.game.engine.scenes.Scene;

/**
 * Created by ress on 20.09.17.
 */
public class SceneManager {
    private Scene currentScene;
    public int width;
    public int height;

    public void step() {
        currentScene.step();
        return;
    }

    public void destroy() {
        currentScene.destroy();
        return;
    }

    public void setScene(Scene scene) {
        if (currentScene != null)
            currentScene.destroy();

        currentScene = scene;
        currentScene.init(this);
        return;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

}
