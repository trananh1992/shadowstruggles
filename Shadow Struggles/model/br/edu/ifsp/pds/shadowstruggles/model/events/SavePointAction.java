package br.edu.ifsp.pds.shadowstruggles.model.events;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class SavePointAction extends EventAction {

	@Override
	public void act() {
		// TODO: Abrir tela de Save (usar inst�ncia global de ShadowStruggles
		// (ShadowStruggles.getInstance()) para mudar de tela).
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
	}

	@Override
	public void write(Json json) {
	}
}
