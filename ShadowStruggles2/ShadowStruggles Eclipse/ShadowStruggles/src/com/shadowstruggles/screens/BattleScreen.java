package com.shadowstruggles.screens;

import java.util.ArrayList;
import java.util.Collections;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.shadowstruggles.Controller;
import com.shadowstruggles.Profile;
import com.shadowstruggles.ShadowStruggles;
import com.shadowstruggles.characters.BaseCharacter;

public class BattleScreen extends BaseScreen {
	private Image background;
	private Profile player;
	private ArrayList<BaseCharacter> playerDeck;
	private ArrayList<BaseCharacter> handCards;
	private OrthographicCamera camera;
	private long lastRender;
	private int lastTouchedX;
	private int lastTouchedY;
	
	public BattleScreen(ShadowStruggles game, String BG, Profile player, Controller controller) {
		super(game,controller);
		this.camera= new OrthographicCamera(width, height);
		camera.position.set(0, 0, 0);
		//this.player = player;
		//this.playerDeck=player.getDeck();
		//Collections.shuffle(playerDeck);
		this.background = new Image(new TextureRegion(new Texture(
				Gdx.files.internal(BG)), 0, 0, 1920, 480));
		lastRender = System.nanoTime();
	}
	
	public void drawCard(ArrayList<BaseCharacter> playerDeck, ArrayList<BaseCharacter> handCards){
		
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		initComponents();
	}
	
	
	@Override
	public void render(float delta) {		
		super.render(delta);
		long now = System.nanoTime();		
		if (Gdx.input.justTouched()) {
			lastTouchedX = Gdx.input.getX();
			lastTouchedY = Gdx.input.getY();
		} else if (Gdx.input.isTouched()) {
			camera.position.x += lastTouchedX
					- Gdx.input.getX();

			
			 // Camera y is opposite of Gdx.input y, so the subtraction is
			  //swapped.
			 
			camera.position.y += Gdx.input.getY()
					- lastTouchedY;

			lastTouchedX = Gdx.input.getX();
			lastTouchedY = Gdx.input.getY();
		}

		
		// Ensure that the camera is only showing the map, nothing outside.
		
		if (camera.position.x < width / 2) {
			camera.position.x = width / 2;
		}
		if (camera.position.x >= background.width
				- width / 2) {
			camera.position.x = background.width
					- width / 2;
		}

		if (camera.position.y < height / 2) {
			camera.position.y = height / 2;
		}
		if (camera.position.y >= background.height
				- height / 2) {
			camera.position.y = background.height
					- height / 2;
		}

		camera.update();
		now = System.nanoTime();
		if (now - lastRender < 30000000) { // 30 ms, ~33FPS
			try {
				Thread.sleep(30 - (now - lastRender) / 1000000);
			} catch (InterruptedException e) {
			}
		}

		lastRender = now;
	}
	
	
	private void initComponents() {
		background.width = 1920;
		background.height = 480;
		background.x = 0;
		background.y = 160;
		stage.addActor(background);
	}
	
	private void cardClicked() {
		// TODO Auto-generated method stub

	}
	
	private void deckClicked() {
		// TODO Auto-generated method stub

	}
	private void menuClicked() {
		// TODO Auto-generated method stub

	}
	private void pauseClicked() {
		// TODO Auto-generated method stub

	}
	private void muteDesmuteClicked() {
		// TODO Auto-generated method stub

	}
	private void cardDragged() {
		// TODO Auto-generated method stub

	}
	private void cardDropped() {
		// TODO Auto-generated method stub

	}
	private void tileClicked() {
		// TODO Auto-generated method stub

	}

}
