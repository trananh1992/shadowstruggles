package br.edu.ifsp.lp2.shadowstruggles.object2d;

import br.edu.ifsp.lp2.shadowstruggles.Controller;
import br.edu.ifsp.lp2.shadowstruggles.data.Settings;
import br.edu.ifsp.lp2.shadowstruggles.screens.BaseScreen;
import br.edu.ifsp.lp2.shadowstruggles.screens.BattleScreen;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Map2D extends Image implements InputProcessor {

	Controller controller;
	private boolean touched;
	private boolean justTouched;
	private int touchX;

	public Map2D(final Controller controller, TextureRegion tRegion) {
		super(tRegion);
		/*this.scaleX = 2f;
		this.scaleY = 2f;*/
		touched = false;
		justTouched = false;
		this.controller = controller;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		int invertY = (int) ((controller.getCurrentScreen().getHeight() - y) * (float) ((float) controller
				.getCurrentScreen().getSettings().screenHeight / (float) controller
				.getCurrentScreen().getHeight()));
		x = (int) (x * (float) ((float) controller.getCurrentScreen()
				.getSettings().screenWidth / (float) controller
				.getCurrentScreen().getWidth()));

		if (x >= 0 && x <= this.width && invertY >= this.y
				&& invertY <= this.y + this.height) {
			touched = true;

			if (!justTouched) {
				justTouched = true;
				touchX = x;
			}

			return true;
		}

		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		int invertY = (int) ((controller.getCurrentScreen().getHeight() - y) * (float) ((float) controller
				.getCurrentScreen().getSettings().screenHeight / (float) controller
				.getCurrentScreen().getHeight()));
		x = (int) (x * (float) ((float) controller.getCurrentScreen()
				.getSettings().screenWidth / (float) controller
				.getCurrentScreen().getWidth()));
		
		if (touched) {
			if (x >= 0 && x <= this.width && invertY >= this.y
					&& invertY <= this.y + this.height) {
				
				controller.mapClicked(
						x + controller.getCurrentScreen().camera.position.x
								- 480, invertY - 160);
			}
			touched = false;
		} else if (this.controller.getPlatform().getSelectedCard() != null) {
			
			controller.mapClicked(x
					+ controller.getCurrentScreen().camera.position.x - 480,
					invertY - 160);
		}

		justTouched = false;

		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		int invertY = (int) ((controller.getCurrentScreen().getHeight() - y) * (float) ((float) controller
				.getCurrentScreen().getSettings().screenHeight / (float) controller
				.getCurrentScreen().getHeight()));
		x = (int) (x * (float) ((float) controller.getCurrentScreen()
				.getSettings().screenWidth / (float) controller
				.getCurrentScreen().getWidth()));
		if (touched) {
			if (x >= 0 && x <= this.width && invertY >= this.y
					&& invertY <= this.y + this.height) {

				Settings settings = controller.getCurrentScreen().getSettings();

				if (controller.getCurrentScreen().camera.position.x + touchX
						- x > BaseScreen.CAMERA_INITIAL_X
						&& controller.getCurrentScreen().camera.position.x
								+ touchX - x < settings.backgroundWidth
								- BaseScreen.CAMERA_INITIAL_X) {
					controller.getCurrentScreen().camera.position.x += touchX
							- x;

					// Render the screen again to avoid blinking.
					((BattleScreen)this.controller.getCurrentScreen()).moveFixedObjects();
					this.touchX = x;
				}
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {

		return false;
	}

}
