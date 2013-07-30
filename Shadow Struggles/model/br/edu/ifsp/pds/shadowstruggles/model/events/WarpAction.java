package br.edu.ifsp.pds.shadowstruggles.model.events;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class WarpAction extends EventAction {
	private int destinyX, destinyY;
	private String destinyMap;
	private String destinyLayer;
	private Event target;

	public WarpAction() {
		this.destinyX = 0;
		this.destinyY = 0;
		this.destinyMap = "";
		this.destinyLayer = "";
		this.target = null;
	}

	@Override
	public void act() {
		// TODO: Se target n�o for nulo, teletransportar o evento at� a
		// localiza��o desejada. Sen�o, teletransportar o personagem do jogador;
		// para ter acesso ao personagem, deve ser utilizada a inst�ncia global
		// de ShadowStruggles (ShadowStruggles.getInstance()), e da� acessar
		// Profile, para enfim chegar ao Character. No caso do personagem do
		// jogador, a tela deve ser atualizada para a nova localiza��o.
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		this.destinyX = json.readValue("destinyX", Integer.class, jsonData);
		this.destinyY = json.readValue("destinyY", Integer.class, jsonData);
		this.destinyMap = json.readValue("destinyMap", String.class, jsonData);
		this.destinyLayer = json.readValue("destinyLayer", String.class,
				jsonData);
		this.target = json.readValue("target", Event.class, jsonData);
	}

	@Override
	public void write(Json json) {
		json.writeValue("destinyX", this.destinyX);
		json.writeValue("destinyY", this.destinyY);
		json.writeValue("destinyMap", this.destinyMap);
		json.writeValue("destinyLayer", this.destinyLayer);
		json.writeValue("target", this.target);
	}

}
