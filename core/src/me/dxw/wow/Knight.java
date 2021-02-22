package me.dxw.wow;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

@SuppressWarnings({"SameParameterValue", "FieldMayBeFinal"})
public class Knight extends Actor {

	public static final String[] RED = {
			"images/ff0000-ffffff-O.png",
			"images/ff0000-ffffff-1.png",
			"images/ff0000-ffffff-2.png",
			"images/ff0000-ffffff-3.png",
			"images/ff0000-ffffff-4.png",
			"images/ff0000-ffffff-5.png",
			"images/ff0000-ffffff-6.png",
			"images/ff0000-ffffff-7.png",
			"images/ff0000-ffffff-8.png",
			"images/ff0000-ffffff-9.png",
	};

	public static final String[] BLUE = {
			"images/0000ff-ffffff-O.png",
			"images/0000ff-ffffff-1.png",
			"images/0000ff-ffffff-2.png",
			"images/0000ff-ffffff-3.png",
			"images/0000ff-ffffff-4.png",
			"images/0000ff-ffffff-5.png",
			"images/0000ff-ffffff-6.png",
			"images/0000ff-ffffff-7.png",
			"images/0000ff-ffffff-8.png",
			"images/0000ff-ffffff-9.png",
	};

	private final int number;

	private Sprite sprite;

	public Knight(int number,boolean red) {
		this.number = number;
		this.sprite = new Sprite(new Texture(Gdx.files.internal(red ? RED[number] : BLUE[number])));
	}

	public int getNumber() {
		return number;
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
