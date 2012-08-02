package com.shadowstruggles.battle;

public class Trap extends Card{

	private int duration;
	private boolean hasImediateEffect;
	private boolean isActivated = false;
	
	public Trap(){
		this.duration = 0;
		this.hasImediateEffect = false;
		this.isActivated = false;
	}
	
	public Trap(int duration, boolean hasImediateEffect, boolean isActivated) {
		super();
		this.duration = duration;
		this.hasImediateEffect = hasImediateEffect;
		this.isActivated = isActivated;
	}



	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isHasImediateEffect() {
		return hasImediateEffect;
	}

	public void setHasImediateEffect(boolean hasImediateEffect) {
		this.hasImediateEffect = hasImediateEffect;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	
	
	
}
