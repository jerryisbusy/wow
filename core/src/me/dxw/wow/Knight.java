package me.dxw.wow;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

@SuppressWarnings({"SameParameterValue", "FieldMayBeFinal"})
public class Knight extends Actor {

	public static final String[] RED = {
			"images/red-O.png",
			"images/red-1.png",
			"images/red-2.png",
			"images/red-3.png",
			"images/red-4.png",
			"images/red-5.png",
			"images/red-6.png",
			"images/red-7.png",
			"images/red-8.png",
			"images/red-9.png",
	};

	public static final String[] BLUE = {
			"images/blue-O.png",
			"images/blue-1.png",
			"images/blue-2.png",
			"images/blue-3.png",
			"images/blue-4.png",
			"images/blue-5.png",
			"images/blue-6.png",
			"images/blue-7.png",
			"images/blue-8.png",
			"images/blue-9.png",
	};

	private Sprite sprite;

	public Knight(int number,boolean red) {
		this.sprite = new Sprite(new Texture(Gdx.files.internal(red ? RED[number] : BLUE[number])));
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		sprite.draw(batch, parentAlpha);
	}

	@Override
	public void setRotation(float degrees) {
		super.setRotation(degrees);
		sprite.setRotation(degrees);
	}

	@Override
	public void setSize(float width, float height) {
		super.setSize(width, height);
		sprite.setSize(width, height);
		sprite.setOrigin(width / 2, height / 2);
	}

	@Override
	public void setPosition(float x, float y) {
		super.setPosition(x, y);
		sprite.setPosition(x, y);
	}

	@Override
	public boolean remove() {
		sprite.getTexture().dispose();
		return super.remove();
	}
}
