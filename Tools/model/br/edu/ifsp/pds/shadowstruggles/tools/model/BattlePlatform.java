package br.edu.ifsp.pds.shadowstruggles.tools.model;

import java.util.ArrayList;
import java.util.logging.Logger;

import br.edu.ifsp.pds.shadowstruggles.tools.data.SerializationHelper;
import br.edu.ifsp.pds.shadowstruggles.tools.model.enemies.Enemy;
import br.edu.ifsp.pds.shadowstruggles.tools.model.modifiers.Modifier;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.Json.Serializable;
import com.esotericsoftware.jsonbeans.JsonValue;

public class BattlePlatform implements Serializable {
	public int id;
	public boolean tutorial;
	public Enemy opponent;
	public ArrayList<Modifier> rewards;
	public BattleMap map;
	public DefaultRules rules;
	
	public BattlePlatform() {
		this.id = 1;
		this.tutorial = false;
		this.opponent = new Enemy();
		this.rewards = new ArrayList<Modifier>();
		this.map = new BattleMap();
		this.rules = new DefaultRules();
	}
	
	public BattlePlatform(int id, boolean tutorial, Enemy opponent,
			ArrayList<Modifier> rewards, BattleMap map, DefaultRules rules) {
		this.id = id;
		this.tutorial = tutorial;
		this.opponent = opponent;
		this.rewards = rewards;
		this.map = map;
		this.rules = rules;
	}

	@Override
	public void read(Json arg0, JsonValue arg1) {
		try {
			SerializationHelper.read(this, arg0, arg1, new ArrayList<String>());
		} catch (IllegalArgumentException e) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe(e.toString());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe(e.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void write(Json arg0) {
		try {
			SerializationHelper.writeToJson(this, arg0, new ArrayList<String>());
		} catch (IllegalArgumentException e) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe(e.toString());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe(e.toString());
			e.printStackTrace();
		}
	}
}
