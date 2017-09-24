package ru.bulletbox.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.bulletbox.game.GameBulletBox;



public class DesktopLauncher {
    static final int WORLD_WIDTH = 640;
    static final int WORLD_HEIGHT = 480;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();


        config.title = "BattleBox - One";
        config.width = WORLD_WIDTH;
        config.height = WORLD_HEIGHT;

		GameBulletBox game = new GameBulletBox();
		game.initSceneManager(config.width, config.height, config.fullscreen = false);
		new LwjglApplication(game, config);
	}
}
