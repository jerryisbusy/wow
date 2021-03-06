package me.dxw.wow;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.utils.ScreenUtils;

@SuppressWarnings("SameParameterValue")
public class WoW extends ApplicationAdapter {

	private SpriteBatch batch;
	private Knight sprite;

	private OrthographicCamera camera;

	private static final float WORLD_WIDTH = 960.0f;

	private float deltaAcc = 0.0f;

	@Override
	public void create() {
		batch = new SpriteBatch();

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(WORLD_WIDTH, WORLD_WIDTH * (h / w));
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		camera.update();

		sprite = new Knight(Color.WHITE);
		sprite.setRotation(45);
		sprite.setOriginCenter();
		sprite.setPosition(camera.position.x - sprite.getWidth() / 2, camera.position.y - sprite.getHeight() / 2);
	}

	@Override
	public void render() {

		float delta = Gdx.graphics.getDeltaTime();

		float scale = Interpolation.bounceOut.apply(0.1f, 8.0f, deltaAcc+=delta);

		sprite.setScale(scale);
		batch.setProjectionMatrix(camera.combined);

		ScreenUtils.clear(Color.BLACK);

		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		sprite.dispose();
	}
}
