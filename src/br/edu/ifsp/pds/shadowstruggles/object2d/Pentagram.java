package br.edu.ifsp.pds.shadowstruggles.object2d;

import br.edu.ifsp.pds.shadowstruggles.ShadowStruggles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * A Pentagram object is shown when the human player selects a card, in order to
 * inform him where it's possible to place his cards.
 */
public class Pentagram extends Image {

	public Pentagram(float x, float y, ShadowStruggles game) {
		super(new TextureRegion(game.getAssets().get("data/images/objects/pentagram.png", Texture.class), 0, 0, 128, 128));
		this.setScaleX (((float) game.getManager().getSettings().tileWidth*2 / (float) 128));
		this.setScaleY( ((float) game.getManager().getSettings().tileHeight / (float) 128));
		this.setX(x);
		this.setY(y);
		this.setVisible(false);
	}

	public void update() {

	}

}
