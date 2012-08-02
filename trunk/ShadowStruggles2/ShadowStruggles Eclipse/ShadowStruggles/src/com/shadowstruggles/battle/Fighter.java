package com.shadowstruggles.battle;

public class Fighter extends Card{

	private int health;
	private int attack;
	private int speed;
	private int range;
	private boolean hasEffect;
	
	public Fighter()
	{
		this.health =0;
		this.attack = 0;
		this.speed = 0;
		this.range = 0;
		this.hasEffect = false;
	}
	
	public Fighter(int health, int attack, int speed, int range,
			boolean hasEffect) {
		super();
		this.health = health;
		this.attack = attack;
		this.speed = speed;
		this.range = range;
		this.hasEffect = hasEffect;
	}



	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public boolean isHasEffect() {
		return hasEffect;
	}

	public void setHasEffect(boolean hasEffect) {
		this.hasEffect = hasEffect;
	}
	
	
	
}
