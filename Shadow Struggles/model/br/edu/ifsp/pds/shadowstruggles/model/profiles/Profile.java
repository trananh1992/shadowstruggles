package br.edu.ifsp.pds.shadowstruggles.model.profiles;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;

import br.edu.ifsp.pds.shadowstruggles.ShadowStruggles;
import br.edu.ifsp.pds.shadowstruggles.data.dao.EventDAO;
import br.edu.ifsp.pds.shadowstruggles.data.dao.FighterDAO;
import br.edu.ifsp.pds.shadowstruggles.model.cards.Deck;
import br.edu.ifsp.pds.shadowstruggles.model.cards.Fighter;
import br.edu.ifsp.pds.shadowstruggles.model.events.Event;
import br.edu.ifsp.pds.shadowstruggles.model.events.EventInGame;
import br.edu.ifsp.pds.shadowstruggles.model.items.Item;
import br.edu.ifsp.pds.shadowstruggles.model.quests.Quest;
import br.edu.ifsp.pds.shadowstruggles.model.rpg.Character;
import br.edu.ifsp.pds.shadowstruggles.model.scenes.Ending;

public class Profile implements Serializable, Comparable<Object> {
	private int id;
	private Player player;
	private Character character;
	private String language;
	private int storyPoints;
	private String path;
	private Deck selectedDeck;
	private int money;
	private int experience;
	private int level;
	private int distributionPoints;
	private int experienceNextLevel;

	private Array<Item> inventory;
	private Array<Deck> decks;
	private Array<Quest> quests;
	private Array<EnemyDefeat> defeatedEnemies;
	private Array<Ending> endings;
	private Array<Item> unlockedItems;

	/**
	 * Stores the game events (grouped by map) so that they can be manipulated
	 * dynamically.
	 */
	private ObjectMap<String, Array<EventInGame>> events;
	/**
	 * Relates the maps to the object layer which the player character will
	 * access when visiting them.
	 */
	private ObjectMap<String, String> mapLayers;

	private DistributionPointsFormula distributionPointsFormula;
	private AttributePointsFormula attributePointsFormula;
	private ExperienceNextLevelFormula experienceNextLevelFormula;

	public Profile() {
		this.id = 1;
		this.player = new Player();
		this.character = new Character();
		this.language = "en_us";
		this.storyPoints = 0;
		this.path = "";
		this.selectedDeck = new Deck();
		this.money = 100;
		this.experience = 0;
		this.level = 1;
		this.distributionPoints = 0;
		this.experienceNextLevel = 1;

		this.inventory = new Array<Item>();
		this.decks = new Array<Deck>();
		this.quests = new Array<Quest>();
		this.defeatedEnemies = new Array<EnemyDefeat>();
		this.endings = new Array<Ending>();
		this.unlockedItems = new Array<Item>();
		this.events = new ObjectMap<String, Array<EventInGame>>();
		this.mapLayers = new ObjectMap<String, String>();
		this.distributionPointsFormula = null;
		this.attributePointsFormula = null;
		this.experienceNextLevelFormula = null;
	}

	public Profile(int id) {
		this();
		this.setId(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Profile)
			return ((Profile) obj).getId() == this.id;
		return false;
	}

	@Override
	public int compareTo(Object o) {
		return this.id - ((Profile) o).getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void read(Json json, JsonValue jsonData) {
		this.id = json.readValue("id", Integer.class, jsonData);
		this.player = json.readValue("player", Player.class, jsonData);
		this.character = json.readValue("character", Character.class, jsonData);
		this.language = json.readValue("language", String.class, jsonData);
		this.storyPoints = json.readValue("storyPoints", Integer.class,
				jsonData);
		this.path = json.readValue("path", String.class, jsonData);
		this.selectedDeck = json
				.readValue("selectedDeck", Deck.class, jsonData);
		this.money = json.readValue("money", Integer.class, jsonData);
		this.experience = json.readValue("experience", Integer.class, jsonData);
		this.level = json.readValue("level", Integer.class, jsonData);
		this.distributionPoints = json.readValue("distributionPoints",
				Integer.class, jsonData);
		this.experienceNextLevel = json.readValue("experienceNextLevel",
				Integer.class, jsonData);

		this.inventory = json.readValue("inventory", Array.class, jsonData);
		this.decks = json.readValue("decks", Array.class, jsonData);
		this.quests = json.readValue("quests", Array.class, jsonData);
		this.defeatedEnemies = json.readValue("defeatedEnemies", Array.class,
				jsonData);
		this.endings = json.readValue("endings", Array.class, jsonData);
		this.unlockedItems = json.readValue("unlockedItems", Array.class,
				jsonData);

		this.events = json.readValue("events", ObjectMap.class, jsonData);
		this.mapLayers = json.readValue("mapLayers", ObjectMap.class, jsonData);

		this.distributionPointsFormula = json.readValue(
				"distributionPointsFormula", DistributionPointsFormula.class,
				jsonData);
		this.attributePointsFormula = json.readValue("attributePointsFormula",
				AttributePointsFormula.class, jsonData);
		this.experienceNextLevelFormula = json.readValue(
				"experienceNextLevelFormula", ExperienceNextLevelFormula.class,
				jsonData);
	}

	@Override
	public void write(Json json) {
		json.writeValue("id", this.id);
		json.writeValue("player", this.player);
		json.writeValue("character", this.character);
		json.writeValue("language", this.language);
		json.writeValue("storyPoints", this.storyPoints);
		json.writeValue("path", this.path);
		json.writeValue("selectedDeck", this.selectedDeck);
		json.writeValue("money", this.money);
		json.writeValue("experience", this.experience);
		json.writeValue("level", this.level);
		json.writeValue("distributionPoints", this.distributionPoints);
		json.writeValue("experienceNextLevel", this.experienceNextLevel);

		json.writeValue("inventory", this.inventory);
		json.writeValue("decks", this.decks);
		json.writeValue("quests", this.quests);
		json.writeValue("defeatedEnemies", this.defeatedEnemies);
		json.writeValue("endings", this.endings);
		json.writeValue("unlockedItems", this.unlockedItems);

		json.writeValue("events", this.events);
		json.writeValue("mapLayers", this.mapLayers);

		json.writeValue("distributionPointsFormula",
				this.distributionPointsFormula);
		json.writeValue("attributePointsFormula", this.attributePointsFormula);
		json.writeValue("experienceNextLevelFormula",
				this.experienceNextLevelFormula);
	}

	/**
	 * Returns the event with the specified ID, searching all the maps.
	 */
	public EventInGame getEvent(int id) {
		for (String map : events.keys()) {
			for (EventInGame event : events.get(map)) {
				if (event.getId() == id)
					return event;
			}
		}

		return null;
	}

	/**
	 * Returns the event with the specified ID, searching the specified map.
	 */
	public EventInGame getEvent(String map, int id) {
		for (EventInGame event : events.get(map)) {
			if (event.getId() == id)
				return event;
		}

		return null;
	}

	public void unlockItems() {

		if (unlockedItems.size < 1) {
			System.out.println("Unlocking items");
			Array<Fighter> fighters = FighterDAO.getFighters();
			for (Fighter fighter : fighters) {
				if (fighter.getName().contains("DR")) {
					System.out.println("Unlocking " + fighter.getName());
					unlockedItems.add(fighter);
				}
			}
		}
	}

	/**
	 * Returns the events on the specified object layer of the specified map.
	 */
	public Array<EventInGame> getEvents(String map, String layer) {
		Array<EventInGame> layerEvents = new Array<EventInGame>();
		for (EventInGame event : events.get(map)) {
			if (event.getLayer().equals(layer))
				layerEvents.add(event);
		}

		if (layerEvents.size > 0)
			return layerEvents;

		return null;
	}

	/**
	 * Turns the Event objects into EventInGame objects and stores them.
	 */
	public void createEventsInGame(ShadowStruggles game) {
		Array<Event> retrievedEvents = EventDAO.getAll();

		for (Event event : retrievedEvents) {
			EventInGame eventInGame = new EventInGame();
			String map = event.getMap();

			eventInGame.setId(event.getId());
			eventInGame.setMap(map);
			eventInGame.setLayer(event.getLayer());
			eventInGame.setSprite(event.getSprite());
			eventInGame.setActions(event.getActions());
			eventInGame.setTriggerType(event.getConvertedTriggerType());
			eventInGame.setCharacter(event.getCharacter(game));
			eventInGame.setCollidable(event.isCollidable());

			if (this.events.containsKey(map)) {
				this.events.get(map).add(eventInGame);
			} else {
				Array<EventInGame> eventArray = new Array<EventInGame>();
				eventArray.add(eventInGame);
				this.events.put(map, eventArray);
			}
		}
	}

	public int getExperience() {
		return experience;
	}

	/**
	 * Sets experience points, leveling up appropriately, and informs whether or
	 * not the character has leveled up.
	 */
	public boolean setExperience(int experience) {
		boolean leveledUp = false;
		this.experience = experience;

		if (this.experienceNextLevelFormula != null) {
			while (this.experience > experienceNextLevel) {
				level += 1;
				distributionPoints += distributionPointsFormula
						.getDistributionPoints(this);
				experienceNextLevel = experienceNextLevelFormula
						.getExperienceNextLevel(this);
				leveledUp = true;
			}
		}

		return leveledUp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}

	public Array<Item> getInventory() {
		return inventory;
	}

	public Array<Deck> getDecks() {
		return decks;
	}

	public Deck getSelectedDeck() {
		return selectedDeck;
	}

	public Player getPlayer() {
		return this.player;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Array<Quest> getQuests() {
		return quests;
	}

	public Array<EnemyDefeat> getDefeatedEnemies() {
		return defeatedEnemies;
	}

	public ObjectMap<String, Array<EventInGame>> getEvents() {
		return events;
	}

	public ObjectMap<String, String> getMapLayers() {
		return mapLayers;
	}

	public Array<Item> getUnlockedItems() {
		return unlockedItems;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setUnlockedItems(Array<Item> unlockedItems) {
		this.unlockedItems = unlockedItems;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Array<Ending> getEndings() {
		return endings;
	}

	public DistributionPointsFormula getDistributionPointsFormula() {
		return distributionPointsFormula;
	}

	public void setDistributionPointsFormula(
			DistributionPointsFormula distributionPointsFormula) {
		this.distributionPointsFormula = distributionPointsFormula;
	}

	public AttributePointsFormula getAttributePointsFormula() {
		return attributePointsFormula;
	}

	public void setAttributePointsFormula(
			AttributePointsFormula attributePointsFormula) {
		this.attributePointsFormula = attributePointsFormula;
	}

	public ExperienceNextLevelFormula getExperienceNextLevelFormula() {
		return experienceNextLevelFormula;
	}

	public void setExperienceNextLevelFormula(
			ExperienceNextLevelFormula experienceNextLevelFormula) {
		this.experienceNextLevelFormula = experienceNextLevelFormula;
	}
}
