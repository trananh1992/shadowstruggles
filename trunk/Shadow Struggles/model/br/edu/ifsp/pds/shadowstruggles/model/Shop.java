package br.edu.ifsp.pds.shadowstruggles.model;

import br.edu.ifsp.pds.shadowstruggles.ShadowStruggles;
import br.edu.ifsp.pds.shadowstruggles.data.dao.EffectDAO;
import br.edu.ifsp.pds.shadowstruggles.data.dao.FighterDAO;
import br.edu.ifsp.pds.shadowstruggles.data.dao.TrapDAO;

import com.badlogic.gdx.utils.Array;

public class Shop {
	private Array<Card> availableCards;
	private Array<Card> lockedCards;
	private Profile profile;

	public Shop(ShadowStruggles game) {
		this.profile = game.getProfile();
		availableCards = new Array<Card>();
		for (Fighter fighter : FighterDAO.getFighters()) {
			availableCards.add(fighter);
		}
		for (Effect effect : EffectDAO.getEffects()) {
			availableCards.add(effect);
		}
		for (Trap trap : TrapDAO.getTraps()) {
			availableCards.add(trap);
		}

		// TODO: transferir cartas do lockedCards p/ availableCards de acordo
		// com progresso do profile
	}

	public boolean buyCard(Card card) {
		boolean suficientMoney = profile.moveMoney(-card.getBuyCost());
		if (suficientMoney) {
			profile.getTrunk().add(card);
			return true;
		} else
			return false;

	}

	public int getPlayerMoney() {
		return profile.getMoney();
	}

	public Array<Card> getAvailableCards() {
		return availableCards;
	}

}