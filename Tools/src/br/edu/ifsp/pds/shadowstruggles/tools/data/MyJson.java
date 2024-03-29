package br.edu.ifsp.pds.shadowstruggles.tools.data;

import br.edu.ifsp.pds.shadowstruggles.tools.model.*;
import br.edu.ifsp.pds.shadowstruggles.tools.model.cards.*;
import br.edu.ifsp.pds.shadowstruggles.tools.model.enemies.*;
import br.edu.ifsp.pds.shadowstruggles.tools.model.events.*;
import br.edu.ifsp.pds.shadowstruggles.tools.model.items.*;
import br.edu.ifsp.pds.shadowstruggles.tools.model.modifiers.*;
import br.edu.ifsp.pds.shadowstruggles.tools.model.profiles.*;
import br.edu.ifsp.pds.shadowstruggles.tools.model.profiles.conditions.*;
import br.edu.ifsp.pds.shadowstruggles.tools.model.quests.*;
import br.edu.ifsp.pds.shadowstruggles.tools.model.scenes.*;

import com.esotericsoftware.jsonbeans.Json;

/**
 * Class used for initializing a single Json object in the application and
 * attributing tags to classes for compatibility purposes.
 */
public class MyJson {

	private static Json json;

	public static Json getJson() {
		if (json != null)
			return json;
		else {
			json = new Json();

			json.addClassTag("Languages", Languages.class);
			json.addClassTag("MenuText", MenuText.class);
			json.addClassTag("Settings", Settings.class);

			json.addClassTag("BattleMap", BattleMap.class);
			json.addClassTag("BattlePlatform", BattlePlatform.class);
			json.addClassTag("DefaultRules", DefaultRules.class);
			json.addClassTag("TutorialDialog", TutorialDialog.class);

			json.addClassTag("Card", Card.class);
			json.addClassTag("Fighter", Fighter.class);
			json.addClassTag("Effect", Effect.class);
			json.addClassTag("Trap", Trap.class);
			json.addClassTag("CardAction", CardAction.class);
			json.addClassTag("Deck", Deck.class);
			json.addClassTag("DefaultAction", DefaultAction.class);
			json.addClassTag("RecoveryAction", RecoveryAction.class);
			json.addClassTag("MineralogyAction", MineralogyAction.class);
			json.addClassTag("HackingAction", HackingAction.class);
			json.addClassTag("EletricCurrent1Action", EletricCurrent1Action.class);
			

			json.addClassTag("Action", Action.class);
			json.addClassTag("Condition", Condition.class);
			json.addClassTag("Enemy", Enemy.class);
			json.addClassTag("Sequence", Sequence.class);

			json.addClassTag("Event", Event.class);
			json.addClassTag("EventAction", EventAction.class);
			json.addClassTag("SavePointAction", SavePointAction.class);
			json.addClassTag("SceneAction", SceneAction.class);
			json.addClassTag("ShopAction", ShopAction.class);
			json.addClassTag("WarpAction", WarpAction.class);
			json.addClassTag("ModifierAction", ModifierAction.class);

			json.addClassTag("Item", Item.class);
			json.addClassTag("ModifierItem", ModifierItem.class);
			json.addClassTag("Pack", Pack.class);
			json.addClassTag("Shop", Shop.class);
			json.addClassTag("TextItem", TextItem.class);

			json.addClassTag("AmountModifier", AmountModifier.class);
			json.addClassTag("InventoryModifier", InventoryModifier.class);
			json.addClassTag("Modifier", Modifier.class);
			json.addClassTag("QuestModifier", QuestModifier.class);
			json.addClassTag("UnlockModifier", UnlockModifier.class);

			json.addClassTag("AttributePointsFormula",
					AttributePointsFormula.class);
			json.addClassTag("DistributionPointsFormula",
					DistributionPointsFormula.class);
			json.addClassTag("EnemyDefeat", EnemyDefeat.class);
			json.addClassTag("ExperienceNextLevelFormula",
					ExperienceNextLevelFormula.class);
			json.addClassTag("Player", Player.class);
			json.addClassTag("Profile", Profile.class);

			json.addClassTag("BattleCondition", BattleCondition.class);
			json.addClassTag("ItemCondition", ItemCondition.class);
			json.addClassTag("ProfileCondition", ProfileCondition.class);
			json.addClassTag("QuestCondition", QuestCondition.class);
			json.addClassTag("StoryCondition", StoryCondition.class);
			json.addClassTag("HealthCondition", HealthCondition.class);
			json.addClassTag("CardOnHand", CardOnHand.class);
			json.addClassTag("CardOnMap", CardOnMap.class);
			json.addClassTag("BaseAttacked", BaseAttacked.class);
			
			json.addClassTag("EnemyDefeatRequirement",
					EnemyDefeatRequirement.class);
			json.addClassTag("ItemRequirement", ItemRequirement.class);
			json.addClassTag("MoneyRequirement", MoneyRequirement.class);
			json.addClassTag("Quest", Quest.class);
			json.addClassTag("Requirement", Requirement.class);
			json.addClassTag("SecondaryQuest", SecondaryQuest.class);

			json.addClassTag("BattleControl", BattleControl.class);
			json.addClassTag("Decision", Decision.class);
			json.addClassTag("Dialogue", Dialogue.class);
			json.addClassTag("Ending", Ending.class);
			json.addClassTag("EventControl", EventControl.class);
			json.addClassTag("LayerControl", LayerControl.class);
			json.addClassTag("MovementControl", MovementControl.class);
			json.addClassTag("NovelScene", NovelScene.class);
			json.addClassTag("ProfileControl", ProfileControl.class);
			json.addClassTag("Scene", Scene.class);
			json.addClassTag("SceneControl", SceneControl.class);
			json.addClassTag("SceneItem", SceneItem.class);
			json.addClassTag("TeleportControl", TeleportControl.class);

			return json;
		}
	}

}
