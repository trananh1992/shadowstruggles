package com.shadostruggles.games;

import com.shadowstruggles.Profile;
import com.shadowstruggles.ShadowStruggles;
import com.shadowstruggles.screens.BattleScreen;

public class Test extends BattleScreen{
	
	
	public Test(ShadowStruggles game) {		
		super(game, "data/images/maps/testmap.png",new Profile(null,null,null,0,0,0), game.getController());
	}
	
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
		//dr.walk();
	}
	
	@Override
	public void show() {		
		super.show();		
	}

}
