package br.edu.ifsp.pds.shadowstruggles.screens;

import br.edu.ifsp.pds.shadowstruggles.Controller;
import br.edu.ifsp.pds.shadowstruggles.ShadowStruggles;
import br.edu.ifsp.pds.shadowstruggles.ShadowStruggles.RunMode;
import br.edu.ifsp.pds.shadowstruggles.model.Card;
import br.edu.ifsp.pds.shadowstruggles.model.Deck;
import br.edu.ifsp.pds.shadowstruggles.object2d.TransitionControl;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

public class EditDeckScreen extends BaseScreen {
	private BaseScreen previousScreen;

	private Image background;
	private Image box;
	private Label name;
	private Label description;
	private Label decks;
	private Label deckName;
	private TransitionControl right;
	private TransitionControl left;
	private TextButton exit;
	private TextButton moveCard;
	private Card selectedCard;
	private Deck selectedDeck;
	private Array<Image> cardImages;
	private Array<Card> trunk;
	private static EditDeckScreen instance;

	public static EditDeckScreen getInstance(ShadowStruggles game,
			Controller controller, BaseScreen previousScreen) {
		if (instance != null)
			return instance;
		else {
			instance = new EditDeckScreen(game, controller, previousScreen);
			return instance;
		}
	}

	private EditDeckScreen(ShadowStruggles game, Controller controller,
			BaseScreen previousScreen) {
		super(game, controller);
		this.previousScreen = previousScreen;
	}

	public void setPreviousScreen(BaseScreen previousScreen) {
		this.previousScreen = previousScreen;
	}

	public void initComponents() {
		stage.clear();
		
		final BaseScreen menu = this.previousScreen;
		this.selectedDeck = game.getProfile().getDeck(game.getManager());
		this.trunk = game.getProfile().getTrunk();
		background = new Image(game.getAssets()
				.get("data/images/objects/objects.atlas", TextureAtlas.class)
				.findRegion("msbackground"));
		background.setScaleX(960f / 512f);
		background.setScaleY(640f / 380f);

		Table menuTable = new Table();
		menuTable.defaults().padTop(10).width(160).height(50);
		
		if (game.getMode() == RunMode.DEBUG)
			menuTable.debug();
		
		deckName = new Label("", super.getSkin());
		deckName.setText("Select a Deck");
		deckName.setStyle(new LabelStyle(super.getSkin().getFont("andalus-font"),
				Color.BLACK));
		
		decks = new Label("", super.getSkin());
		decks.setText("Deck B");
		decks.setStyle(new LabelStyle(super.getSkin().getFont("andalus-font"),
				Color.BLACK));
		
		exit = new TextButton("", super.getSkin().get("blur", TextButtonStyle.class));
		exit.setText("Back");
		exit.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.getAudio().playSound("button_6");
				game.setScreenWithTransition(menu);
				game.getManager().writeProfile(game.getProfile());
			}
		});
		
		
		
		menuTable.add(deckName);
		menuTable.row();
		menuTable.add(decks).height(400);
		menuTable.row();
		menuTable.add(exit);
		
		menuTable.setPosition(100, 350);
		
		Table deckTable = new Table();
		if (game.getMode() == RunMode.DEBUG)
			deckTable.debug();
		box = new Image(game.getAssets()
				.get("data/images/objects/objects.atlas", TextureAtlas.class)
				.findRegion("box"));
		deckTable.defaults().width(600).height(400);
		box.setWidth(600);
		box.setHeight(400);
//		box.setScaleX(0.9f);
//		box.setScaleY(0.76f);
		
		deckTable.add(box);
		
		deckTable.setPosition(580, 380);

		
		Table cardTable = new Table();
		if (game.getMode() == RunMode.DEBUG)
			cardTable.debug();
		
		cardTable.defaults().width(100).height(100);
		
		right = new TransitionControl(1, this.getSkin());
		right.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.getAudio().playSound("button_6");
				moveCards(1);

			}
		});
		
		left = new TransitionControl(-1, this.getSkin());
		left.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.getAudio().playSound("button_6");
				moveCards(-1);

			}
		});
		
		int count = 0;
		cardImages = new Array<Image>();
		for (Card card : trunk) {
			Image cardImage = new Image(game.getAssets()
					.get("data/images/cards/cards.atlas", TextureAtlas.class)
					.findRegion(card.getName().toLowerCase()));
			cardImage.setY(5);
			cardImage.setX(180 + count * 120);
			cardImage.setScaleX(0.3f);
			cardImage.setScaleY(0.3f);
			final Card card2 = card;
			cardImage.addListener(new ClickListener() {

				@Override
				public void clicked(InputEvent event, float x, float y) {
					game.getAudio().playSound("button_2");
					changeCard(card2);
				}
			});
			cardImages.add(cardImage);
			if (cardImage.getX() >= 180 && cardImage.getX() < 900)
				stage.addActor(cardImage);
			count++;
		}
		
		cardTable.add(left).left();
//		cardTable.add(cardImages);
		cardTable.add(right);
		
		cardTable.setPosition(300, 100);
		
		stage.addActor(background);
		stage.addActor(menuTable);
		stage.addActor(deckTable);
		stage.addActor(cardTable);
		
	}

	private void moveCards(int side) {
		boolean movableToRight = false, movableToLeft = false;
		for (Image card : cardImages) {
			if (card.getX() < 180)
				movableToRight = true;
			if (card.getX() > 780)
				movableToLeft = true;
		}

		if ((side > 0 && movableToLeft) || (side < 0 && movableToRight))
			for (Image card : cardImages) {
				card.setX(card.getX() - 120 * side);
				if (card.getX() >= 120 && card.getX() < 900)
					stage.addActor(card);
				else {
					try {
						stage.removeActor(card);

					} catch (Exception e) {
					}
				}
			}

	}

	private void changeCard(Card card) {
		this.selectedCard = card;

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		Table.drawDebug(stage);
	}
}
