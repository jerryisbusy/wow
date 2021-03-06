package me.dxw.wow.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.dxw.wow.WoW;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 320;
		config.height = 640;
		config.resizable = false;
		config.samples = 2;
		new LwjglApplication(new WoW(), config);
	}
}
