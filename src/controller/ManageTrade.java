package controller;

import model.player.Player;
import model.player.PlayerList;
import model.tiles.Property;

import javax.swing.*;

/**
 * @author Muhammad Abdulkhuder Aevan Dino sebastian Viro.
 * Updated 2022-02-05 by Mattias Bengtsson: MVC architecture restructuring. Moved here from PlayerPropertyPanel.
 */
public class ManageTrade {
    GameLogic controller;

    /**
     * Constructor
     * @param controller
     */
    public ManageTrade(GameLogic controller) {
        this.controller = controller;
    }

    public void startTrade() {
        int otherPlayerInt = 0;
        int whichPropertyToGive = 0;
        int whichPropertyYouWant = 0;
        int offer = 0;
        int type = 0;
        int confirm;

        PlayerList playerList = controller.getPlayerList();

        do {
            otherPlayerInt = (Integer
                    .parseInt(JOptionPane.showInputDialog(null,
                            "Which player do you want to trade with?\n 1 for player 1 \n 2 for player 2 and so on..."))
                    - 1);




        } while(otherPlayerInt == playerList.getActivePlayer().getPlayerIndex() || otherPlayerInt > playerList.getLength()-1);

        Player activePlayer = playerList.getActivePlayer();
        Player otherPlayer = playerList.getPlayerFromIndex(otherPlayerInt);

        if ( otherPlayer.getProperties().size() > 0) {


            do {
                type = (Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Pick a trade type\n 1 = Property for property \n 2 = Money for property\n 3 = Both")));
            } while (type<0 ||type >3);


            if (type == 1 || type == 3) {

                do {
                    whichPropertyToGive = (Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Which property do you want to give away \n 1 for property 1 \n 2 for property 2 and so on..."))
                            - 1);
                } while (whichPropertyToGive > activePlayer.getProperties().size());

            }

            if (type == 2 || type == 3) {
                do {
                    offer = (Integer.parseInt(JOptionPane.showInputDialog(null,
                            "How much do you offer " + otherPlayer.getName() + "?")));
                } while (offer > activePlayer.getBalance());

            }

            do {
                whichPropertyYouWant = (Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Which property do you want \n 1 for property 1 \n 2 for property 2 and so on...")) - 1);
            } while (whichPropertyYouWant > otherPlayer.getProperties().size());


            Property activePlayerProperty = playerList.getActivePlayer().getPropertyAt(whichPropertyToGive);

            Property otherPlayersProperty = playerList.getPlayerFromIndex(otherPlayerInt)
                    .getPropertyAt(whichPropertyYouWant);



            if (type == 1 || type == 3) {
                confirm = JOptionPane.showConfirmDialog(null,
                        otherPlayer.getName() + " Are you okay with this trade?" + "\n You are getting " + offer
                                + "Gold coins" + "\n and are trading away " + otherPlayersProperty.getName() + "\n for "
                                + activePlayerProperty.getName());

                if (confirm == 0) {

                    activePlayer.removeProperty(activePlayerProperty);
                    otherPlayer.removeProperty(otherPlayersProperty);

                    activePlayer.decreaseBalance(offer);
                    activePlayer.decreaseNetWorth(offer);

                    otherPlayer.increaseBalance(offer);
                    otherPlayer.increaseNetWorth(offer);

                    activePlayerProperty.setOwner(otherPlayer);
                    activePlayer.addNewProperty(otherPlayersProperty);

                    otherPlayersProperty.setOwner(activePlayer);
                    otherPlayer.addNewProperty(activePlayerProperty);

                    JOptionPane.showMessageDialog(null, "Trade Complete! Omedetou gozaimasu!!!");

                }

            }

            if (type == 2) {
                confirm = JOptionPane.showConfirmDialog(null, otherPlayer.getName() + " Are you okay with this trade?"
                        + "\n You are getting " + offer + "Gold coins for " + otherPlayersProperty.getName());

                if (confirm == 0) {

                    otherPlayer.removeProperty(otherPlayersProperty);
                    activePlayerProperty.setOwner(otherPlayer);
                    activePlayer.addNewProperty(otherPlayersProperty);

                    activePlayer.decreaseBalance(offer);
                    activePlayer.decreaseNetWorth(offer);

                    otherPlayer.increaseBalance(offer);
                    otherPlayer.increaseNetWorth(offer);
                    JOptionPane.showMessageDialog(null, "Trade Complete! Omedetou gozaimasu!!!");

                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Trade can not be done! The player you picked does not own any properties!");
        }
    }

}
