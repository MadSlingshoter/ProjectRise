package controller;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import model.ChurchTax;
import view.EventsPanel;
import view.messageGui.DeathGUI;

import model.player.Player;
import model.player.PlayerRanks;
import model.tiles.FortuneTeller;
import model.tiles.GoToJail;
import model.tiles.Jail;
import model.tiles.Property;
import model.tiles.SundayChurch;
import model.tiles.Tavern;
import model.tiles.Tax;
import model.tiles.Tile;
import model.tiles.Work;

/**
 * The class handles all the events that occur when a Model.player lands on a tile.
 * @author Seth Oberg, Rohan Samandari,Muhammad Abdulkhuder ,Sebastian Viro, Aevan Dino.
 * Updated 2022-02-22 by Mattias Bengtsson: Moved controller methods to GameLogic
 */

public class ManageEvents {
	private GameLogic controller;
	private DeathGUI deathGUI;
	private ChurchTax churchTax;
	private Random rand = new Random();
	private EventsPanel eventsPanel;

	/**
	 * Constructor initializes objects in the parameter. Creates Death -and MessageGUI.
	 * @param controller
	 */
	public ManageEvents(GameLogic controller) {
		this.controller = controller;

		churchTax = new ChurchTax();
		deathGUI = new DeathGUI();
		eventsPanel = new EventsPanel(this);
		controller.getMainWindow().getBoard().add(eventsPanel);
		controller.getMainWindow().getBoard().moveToFront(eventsPanel);
	}

	/**
	 * Method checks what type of tile the Model.player has landed on.
	 * @param tile the player landed on.
	 * @param player, player who landed on a tile.
	 */
	public void newEvent(Tile tile, Player player) {
		player.checkPlayerRank();

		if (player.getPlayerRank() == PlayerRanks.KINGS || controller.getPlayerList().getLength() == 1) {
			eventsPanel.setMessage("You won!", player.getName());
			eventsPanel.activateResetButton();
		}

		if (tile instanceof Property) {
			propertyEvent(tile, player);
		}

		if (tile instanceof Tax) {
			taxEvent(tile, player);
		}

		if (tile instanceof Jail) {
			jailEvent(tile, player);
		}

		if (tile instanceof GoToJail) {
			goToJailEvent(tile, player);
		}

		if (tile instanceof Tavern) {
			tavernEvent(tile, player);
		}

		if (tile instanceof SundayChurch) {
			churchEvent(player);
		}

		if (tile instanceof Work) {
			workEvent(tile, player);
		}

		if (tile instanceof FortuneTeller) {
			fortuneTellerEvent(tile, player);
		}
		controller.updatePlayerList();
	}

	public void hideEventPanels() {
		eventsPanel.hideEventpanel();
	}

	/**
	 * This method is supposed to be called from any class that requires the current
	 * player to pay any amount, if the user does not have the amount required they
	 * should be removed from the game
	 */
	public void control(Player player, int amount) {

		if (player.getBalance() < amount) {
			player.setIsAlive(false);
			controller.getPlayerList().switchToNextPlayer();
			controller.getPlayerList().eliminatePlayer(player);
			controller.getPlayerList().updatePlayerList();
			controller.updatePlayerList();
			controller.getMainWindow().getBoard().removePlayer(player);
			deathGUI.addGui();
		}
	}

	/**
	 * Method called when player lands on a property. Checks if it's availability and if the player has to pay rent or
	 * can purchase the property.
	 * @param tile tile
	 * @param player player
	 */
	public void propertyEvent(Tile tile, Player player) {
		Property tempProperty = (Property) tile;
		int tempInt = 0;
		boolean purchasable = tempProperty.getPurchaseable();

		if (purchasable) {
			if (player.getBalance() < tempProperty.getPrice()) {
				eventsPanel.setMessage("Not enough funds to purchase this property", "Sorry...");

			} else {
				propertyDialog(tempProperty, player);
			}
		} else {

			if (tempProperty.getLevel() == 0) {
				tempInt = tempProperty.getDefaultRent();

				control(player, tempInt);
				if (player.isAlive()) {
					eventsPanel.setMessage( player.getName() + " paid " + tempProperty.getTotalRent() + " GC to "
							+ tempProperty.getOwner().getName());

					controller.updateHistory(player.getName() + " paid " + tempProperty.getTotalRent() + " GC to "
							+ tempProperty.getOwner().getName() + "\n");
					player.decreaseBalace(tempInt);
					player.decreaseNetWorth(tempInt);
					tempProperty.getOwner().increaseBalance(tempInt);
				}
			} else {
				tempInt = tempProperty.getTotalRent();
				control(player, tempInt);
				if (player.isAlive() && !(player.equals(tempProperty.getOwner()))) {
					eventsPanel.setMessage( player.getName() + " paid " + tempProperty.getTotalRent() + " GC to "
							+ tempProperty.getOwner().getName());

					controller.updateHistory(player.getName() + " paid " + tempProperty.getTotalRent() + " GC to "
							+ tempProperty.getOwner().getName() + "\n");
					player.decreaseBalace(tempInt);
					tempProperty.getOwner().increaseBalance(tempInt);
				}
			}
		}
	}

	/**
	 * Method called when the player lands on a work tile.
	 * @param tile tile
	 * @param player Model.player
	 */
	public void workEvent(Tile tile, Player player) {

		Work tempWorkObject = (Work) tile;
		tempWorkObject.setPlayer(player);
		tempWorkObject.payPlayer(controller.getRoll());

		controller.updateHistory(player.getName() + " Got " + tempWorkObject.getPay() + " GC\n");
		eventsPanel.setMessage("The roll is " + controller.getRoll() + "\n" + "You got: " + tempWorkObject.getPay() + " GC for your hard work");
	}

	/**
	 * Method called when the Model.player lands on a tax tile.
	 * @param tile
	 * @param player
	 */
	public void taxEvent(Tile tile, Player player) {
		Tax tempTaxObject = (Tax) tile;
		int chargePlayer = tempTaxObject.getTax();

		control(player, chargePlayer);

		if (player.isAlive()) {
			controller.updateHistory(player.getName() + " paid 200 GC in tax\n");
			player.decreaseBalace(chargePlayer);
			player.decreaseNetWorth(chargePlayer);
			churchTax.increaseCounter();
			eventsPanel.setMessage("You paid 200 CG in taxes to the church. The pot is " + getChurchTax() + ".");
		}
	}

	/**
	 * Gets the total tax paid by players
	 * @return total tax
	 */
	public int getChurchTax() {
		return churchTax.getPot();
	}

	/**
	 * Method called when players lands on a tavern tile, checks it's availability. 
	 * @param tile
	 * @param player
	 */
	public void tavernEvent(Tile tile, Player player) {
		Tavern tempTavernObj = (Tavern) tile;

		if (tempTavernObj.getPurchaseable()) {
			if (player.getBalance() < tempTavernObj.getPrice()) {
				eventsPanel.setMessage("Not enough funds to purchase this tavern");

			} else {
				tavernDialog(tempTavernObj, player);
			}
		} else {
			int randomValue = 0;

			if (tempTavernObj.getOwner().getAmountOfTaverns() == 1) {
				randomValue = (controller.getRoll() * 10);
			} else if (tempTavernObj.getOwner().getAmountOfTaverns() == 2) {
				randomValue = (controller.getRoll() * 20);
			}
			
			control(player, randomValue);

			if (player.isAlive()) {
				eventsPanel.setMessage(player.getName() + " paid " + randomValue + " GC to " + tempTavernObj.getOwner().getName());

				controller.updateHistory(player.getName() + " paid " + randomValue + " GC to "
						+ tempTavernObj.getOwner().getName() + "\n");
				tempTavernObj.getOwner().increaseBalance(randomValue);
				tempTavernObj.getOwner().increaseNetWorth(randomValue);
				player.decreaseBalace(randomValue);
			}
		}
	}

	/**
	 * Method for jailed players, giving them the option to pay bail if the have enough balance.
	 * @param tile
	 * @param player in jail
	 */
	public void jailEvent(Tile tile, Player player) {
		if (player.isPlayerInJail() && (player.getJailCounter()) < 2) {
			eventsPanel.setMessage(player.getName() + " is in jail for " + (2 - player.getJailCounter()) + " more turns\n", "Jail");
			controller.updateHistory(player.getName() + " is in jail for " + (2 - player.getJailCounter()) + " more turns\n");
			player.increaseJailCounter();
			if (player.getBalance() > (player.getJailCounter() * 50)) {
				jailDialog(player);
			} else {
				eventsPanel.setMessage("You can not afford the bail","Jail");

			}
		} else if (player.getJailCounter() >= 2) {
			player.setPlayerIsInJail(false);
			player.setJailCounter(0);
			controller.getMainWindow().getDice().activateRollDice();
		}
	}

	/**
	 * Message for the prisoner to choose if the player wants to pay the bail and
	 * get free
	 * @param player in jail.
	 */
	public void jailDialog(Player player) { //TODO flytta hela metoden till EventsPanel?
		eventsPanel.activeJailButtons();
		eventsPanel.setMessage("Do you want to pay the bail \n Which is " + (player.getJailCounter() * 50) + " GC?", "Jail");
		eventsPanel.setPlayer(player);
	}

	public void payJail(Player player) {
		int totalBail = player.getJailCounter() * 50;
		if ((totalBail <= player.getBalance())) {
			player.setJailCounter(0);
			player.setPlayerIsInJail(false);
			controller.updateHistory(player.getName() + " paid the bail and\ngot free from jail\n");
			controller.getMainWindow().getDice().activateRollDice();
		} else {
			controller.updateHistory(player.getName() + " could not pay the bail\n and is still in jail\n");
		}
	}

	public void noPayJail(Player player) {
		controller.updateHistory(player.getName() + " could not pay the bail\n and is still in jail\n");
	}

	/**
	 * Method to jail a player.
	 * @param tile
	 * @param player
	 */
	public void goToJailEvent(Tile tile, Player player) {
		player.setPlayerIsInJail(true);
		controller.getMainWindow().getBoard().removePlayer(player);
		player.setPositionInSpecificIndex(10);
		controller.getMainWindow().getBoard().setPlayer(player);

		eventsPanel.setMessage(player.getName() + " got in jail.");
		controller.updateHistory(player.getName() + " is in jail for " + (2 - player.getJailCounter()) + " more turns\n");
	}



	/**
	 * Method called if the player lands on sunday church. Pays out all the collected tax then resets the counter.
	 * @param player
	 */
	public void churchEvent(Player player) {
		int payout = churchTax.payout();
		player.increaseBalance(payout);
		player.increaseNetWorth(payout);
		controller.updateHistory(player.getName() + " got " + getChurchTax() + " GC from the church\n");
	}

	/**
	 * Method for a dialog if the player is able to purchase a property.
	 * @param property in question.
	 * @param player in question.
	 */
	public void propertyDialog(Property property, Player player) {
		eventsPanel.activatePropertyButtons();
		eventsPanel.setMessage(property.getName() + "\n" + "Do you want to purchase this property for " + property.getPrice() + " GC?", "Property");

		eventsPanel.setPlayer(player);
		eventsPanel.setProperty(property);
	}

	public void propertyBuy(Property property, Player player){
		if (property.getPrice() <= player.getBalance()) {
			property.setOwner(player);
			player.addNewProperty(property);
			property.setPurchaseable(false);
			player.decreaseBalace(property.getPrice());
			controller.updateHistory(player.getName() + " purchased " + property.getName() + "\n");
			controller.updatePlayerList();
		}

		else {
			controller.updateHistory(player.getName() + " did not have enough gold " + property.getName() + "\n");
		}
	}

	public void propertyNotBuy(Property property, Player player) {
		controller.updateHistory(player.getName() + " did not want to buy the property " + property.getName() + "\n");
	}

	/**
	 * Method for a dialog if the player wants to purchase a tavern.
	 * @param tavern, the to buy.
	 * @param player, Model.player who landed on the tavern.
	 */
	public void tavernDialog(Tavern tavern, Player player) {
		eventsPanel.setMessage("Do you want to purchase this tavern for " + tavern.getPrice() + " GC?", "Make your choice");
		eventsPanel.activateTavernButtons();

		eventsPanel.setPlayer(player);
		eventsPanel.setTavern(tavern);
	}

	public void buyTavern(Tavern tavern, Player player) {
		if (tavern.getPrice() <= player.getBalance()) {
			tavern.setOwner(player);
			player.addNewTavern(tavern);
			tavern.setPurchaseable(false);
			player.decreaseBalace(tavern.getPrice());
			controller.updateHistory(player.getName() + " purchased " + tavern.getName() + "\n");
			controller.updatePlayerList();
		} else {
			controller.updateHistory(player.getName() + " could not afford to not purchase " + tavern.getName() + "\n");
		}
	}

	public void noBuyTavern(Tavern tavern, Player player) {
		controller.updateHistory(player.getName() + " did not purchase " + tavern.getName() + "\n");
	}
	
	/**
	 * Method for FortuneTeller, small chance for a secret event to trigger.
	 * @param tile, tile the player landed on.
	 * @param player, player in question.
	 */
	private void fortuneTellerEvent(Tile tile, Player player) {
		FortuneTeller tempCard = (FortuneTeller) tile;
		if (rand.nextInt(10) == 0) {
			//new SecretGui();

			new Thread(new SecretSleeper(tempCard, player));
			controller.updatePlayerList();

		} else {
			fortune(tempCard, player);
		}
	}

	/**
	 * Method that either withdraws or adds gold coins to a Model.player depending on the type of fortune.
	 * @param tempCard, instance of FortuneTeller 
	 * @param player, player who landed on the tile
	 */
	public void fortune(FortuneTeller tempCard, Player player) {
		tempCard.setAmount(rand.nextInt(600) - 300);
		if (tempCard.getAmount() < 0) {
			int pay = (tempCard.getAmount() * -1);
			tempCard.setIsBlessing(false);
			tempCard.setFortune("CURSE");
			control(player, pay);
			if (player.isAlive()) {
				controller.updateHistory(player.getName() + " paid " + pay + " GC\n");
				player.decreaseBalace(pay);
				player.decreaseNetWorth(pay);
				newFortune(false, pay);
			}

		} else {
			tempCard.setIsBlessing(true);
			tempCard.setFortune("BLESSING");
			player.increaseBalance(tempCard.getAmount());
			player.increaseNetWorth(tempCard.getAmount());
			controller.updateHistory(player.getName() + " received " + tempCard.getAmount() + " CG\n");
			newFortune(true, tempCard.getAmount());
		}
	}

	public void newFortune(boolean b, int amount) {
		if(b) {
			eventsPanel.setMessage("Fortune smiles upon you. \n"
					+ "You recived " + amount + " GC","Blessing" );

		} else {
			eventsPanel.setMessage("You have been cursed! \n"
					+ "You pay " + amount + " GC","Curse");
		}
	}



	/**
	 * This class is an easter egg. That gives the Model.player 5 fortunes.
	 * @author Sebastian viro ,Muhammad Abdulkhuder
	 *
	 */
	private class SecretSleeper extends Thread {

		private FortuneTeller tempCard;
		private Player player;
//		private Clip clip;
			
		/**
		 * @param tempCard
		 * @param player
		 * Starts the sleeper
		 */
		public SecretSleeper(FortuneTeller tempCard, Player player) {
			this.tempCard = tempCard;
			this.player = player;
			start();

		}
		
		public void run() {
			try {
				eventsPanel.deactivateAllButtons();
				controller.getMainWindow().getDice().deactivateAllDiceBtn();
				eventsPanel.setMessage("Draw 5 cards","Secret fortune");

				Thread.sleep(4000);
				for (int i = 0; i < 5; i++) {
//					File musicPath = new File("music/duraw.wav");
//					AudioInputStream ais = AudioSystem.getAudioInputStream(musicPath);
//					clip = AudioSystem.getClip();
//					clip.open(ais);
//					clip.start();
					fortune(tempCard, player);
					Thread.sleep(2500);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				controller.getMainWindow().getDice().activateEndTurnDice();
			}
		}
	}
}
