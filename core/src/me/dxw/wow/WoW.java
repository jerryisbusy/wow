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
	public static final float WORLD_WIDTH = 480.0f;
	public static final float KNIGHT_SIZE = WORLD_WIDTH / ROW;

	private Stage stage;

	private Array<Knight> knights;

	@Override
	public void create() {

		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();

		knights = initNumbers(ROW, COL);

		stage = new Stage(new ScalingViewport(Scaling.stretch, WORLD_WIDTH, 480.0f * screenHeight / screenWidth));
		stage.getCamera().translate(0, -(stage.getHeight() - stage.getWidth() - COL * KNIGHT_SIZE / 2), 0);

		for (int i = 0; i< knights.size; i++) {
			stage.addActor(knights.get(i));
		}
	}

	@Override
	public void render() {
		ScreenUtils.clear(Color.WHITE);
		stage.act();
		stage.draw();
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

		for (int i = 0; i< row * col; i++) {
			Knight knight = numbers.get(i);
			int x = i % row;
			int y = i / row;
			knight.setPosition(x * KNIGHT_SIZE, y * KNIGHT_SIZE);
		}

		return numbers;
	}
}
