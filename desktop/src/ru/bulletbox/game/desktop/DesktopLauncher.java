package ru.bulletbox.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.bulletbox.game.GameBulletBox;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		GameBulletBox game = new GameBulletBox();
		game.initSceneManager(config.width, config.height);
		new LwjglApplication(game, config);
	}
}
