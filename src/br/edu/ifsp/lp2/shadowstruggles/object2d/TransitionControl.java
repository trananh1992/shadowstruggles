package br.edu.ifsp.lp2.shadowstruggles.object2d;

import br.edu.ifsp.lp2.shadowstruggles.data.Assets;
import br.edu.ifsp.lp2.shadowstruggles.screens.BattleScreen;
import br.edu.ifsp.lp2.shadowstruggles.screens.SceneScreen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * A TransitionControl object is an arrow pointing either to the right or left,
 * moving the camera to the specified direction in a {@link BattleScreen}. It
 * has been replaced by the A-D and arrow keys and scrolling on the
 * {@link Map2D} due to usability decisions and currently is being used for
 * advancing the story in a {@link SceneScreen}.
 */

public class TransitionControl extends FixedObject {
	

	public TransitionControl(int side) {
		super(new TextureRegion(Assets.cameraController, 64, 64),
				480 + 440 * side);
		if (side == -1)
			this.getRegion().flip(true, false);
		this.y = 340;
		this.width = 32;
		this.height = 32;
		

	}
	@Override
	public boolean touchDown(float x, float y, int pointer) {
		
		return super.touchDown(x, y, pointer);
	}

	

}
