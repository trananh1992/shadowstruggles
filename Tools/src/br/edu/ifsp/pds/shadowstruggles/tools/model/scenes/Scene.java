package br.edu.ifsp.pds.shadowstruggles.tools.model.scenes;

import java.util.ArrayList;
import java.util.logging.Logger;

import br.edu.ifsp.pds.shadowstruggles.tools.data.SerializationHelper;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.Json.Serializable;
import com.esotericsoftware.jsonbeans.JsonValue;

public class Scene implements Serializable {
	public int id;
	public Ending ending;
	public String name;
	public String description;
	public ArrayList<SceneItem> items;

	public Scene() {
		this.id = 1;
		this.ending = new Ending();
		this.name = "";
		this.description = "";
		this.items = new ArrayList<SceneItem>();
	}

	public Scene(int id, Ending ending, String name, String description,
			ArrayList<SceneItem> items) {
		this.id = id;
		this.ending = ending;
		this.name = name;
		this.description = description;
		this.items = items;
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
			SerializationHelper
					.writeToJson(this, arg0, new ArrayList<String>());
		} catch (IllegalArgumentException e) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe(e.toString());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe(e.toString());
			e.printStackTrace();
		}
	}

}
