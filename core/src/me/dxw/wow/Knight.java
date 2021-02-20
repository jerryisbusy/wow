package me.dxw.wow;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;

public class Knight extends Sprite implements Disposable {

    public Knight(Color color) {
        super(cell(color));
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
    }

    @Override
    public void dispose() {
        getTexture().dispose();
    }

    static private Texture cell(Color color) {

        Texture texture;
        Pixmap pixmap;

        pixmap = new Pixmap(140, 140, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.SourceOver);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, 0, 140, 140);

        texture = new Texture(pixmap, true);

        pixmap.dispose();

        return texture;
    }
}
