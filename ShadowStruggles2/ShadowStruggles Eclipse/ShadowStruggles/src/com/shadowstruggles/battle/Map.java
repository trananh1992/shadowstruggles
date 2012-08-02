package com.shadowstruggles.battle;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

public class Map {

	private Image mapImage;
	private Array<Array<Object>> tiles;
	
	public Map(Image mapImage, Array<Array<Object>> tiles) {
		super();
		this.mapImage = mapImage;
		this.tiles = tiles;
	}
	
	public Image getMapImage() {
		return mapImage;
	}
	public void setMapImage(Image mapImage) {
		this.mapImage = mapImage;
	}
	public Array<Array<Object>> getTiles() {
		return tiles;
	}
	public void setTiles(Array<Array<Object>> tiles) {
		this.tiles = tiles;
	}
	
	public void setCard(Card card, int x, int y){
		tiles.get(x).set(y, card);
	}
	
	public void setSprite(Card card, int x, int y){
		//acho que isso eh desnecessário uma vez 
		//que a carta ja tem seu próprio sprite
	}

	
}
