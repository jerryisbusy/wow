package me.dxw.wow;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

@SuppressWarnings("SameParameterValue")
public class WoW extends ApplicationAdapter {

	private final static int ROW = 4;
	private final static int COL = 5;

	private static final float WORLD_WIDTH = 480.0f;

	private static final float GUTTER = 30;
	private static final float KNIGHT_SIZE = (WORLD_WIDTH - (GUTTER * (ROW + 1))) / ROW;

	private Stage stage;

	private Array<Knight> knights;

	@Override
	public void create() {

		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();

		float worldHeight = 480.0f * screenHeight / screenWidth;

		knights = initNumbers(ROW, COL);

		stage = new Stage(new ScalingViewport(Scaling.stretch, WORLD_WIDTH, worldHeight));
		stage.getCamera().translate(0, -(worldHeight - KNIGHT_SIZE * COL - GUTTER * (COL + 1)) / 2, 0);

		for (int i = 0; i < knights.size; i++) {
			stage.addActor(knights.get(i));
		}
	}

	@Override
	public void render() {
		ScreenUtils.clear(Color.valueOf("#fcfdc0"));
		stage.draw();
		stage.act();
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	private Array<Knight> initNumbers(int row, int col) {
		Array<Knight> numbers = new Array<>(row * col);

		for (int i = 0; i < row * col; i++) {
			Knight knight = new Knight(i % 10, i < row * col / 2);
			knight.setSize(KNIGHT_SIZE, KNIGHT_SIZE);
			numbers.add(knight);
		}

		numbers.shuffle();

		for (int i = 0; i < row * col; i++) {
			Knight knight = numbers.get(i);
			int x = i % row;
			int y = i / row;

			float posX = x * KNIGHT_SIZE + (x == 0 ? GUTTER : GUTTER * (x + 1));
			float posY = y * KNIGHT_SIZE + (y == 0 ? GUTTER : GUTTER * (y + 1));

			knight.setPosition(posX, posY);
		}

		return numbers;
	}
}
