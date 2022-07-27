package service

import entity.Card
import entity.Player

/**
 * this class handles the player actions and knows the [rootService]
 *
 * @param [rootService] is the service that connects to the entity layer
 */

class PlayerService(private val rootService: RootService) {
    /**
     * this function increments the passes
     */
    public fun pass(): Unit {
        rootService.swimApp.passes++
    }

    /**
     * this function lets the [currentPlayer] do the action [call]
     *
     *@param [currentPlayer] is the current player that wants to call
     */
    public fun call(currentPlayer: Player): Unit {
        rootService.swimApp.calledPlayer = currentPlayer
    }

    /**
     * this function lets the player do the action [swapOneCard]
     * it recieves the @param [wantedCard] from the deck of the player and swaps it
     * with @param [selectedCard] from the table deck
     */
    public fun swapOneCard(wantedCard: Card, selectedCard: Card): Boolean {

        if (rootService.swimApp.currentPlayer.playerHand.cards.contains(wantedCard) && rootService.swimApp.tableDeck.cards.contains(
                selectedCard
            )
        ) {

            rootService.swimApp.currentPlayer.playerHand.cards.remove(wantedCard)
            rootService.swimApp.tableDeck.cards.remove(selectedCard)
            rootService.swimApp.currentPlayer.playerHand.cards.add(wantedCard)
            rootService.swimApp.tableDeck.cards.add(selectedCard)
            return true
        } else {
            return false
        }
    }

    /**
     * this function lets the player do the action [swapAllCards]
     */
    public fun swapAllCards(): Unit {
        val temp = rootService.swimApp.tableDeck
        rootService.swimApp.currentPlayer.playerHand = rootService.swimApp.tableDeck
        rootService.swimApp.currentPlayer.playerHand = temp
    }

    /**
     * this function calculates the score of the player
     */
    public fun calculatePoints(): Double {
        val scoreCardOne = rootService.swimApp.currentPlayer.playerHand.cards[0].valueOf().toDouble()
        val scoreCardTwo = rootService.swimApp.currentPlayer.playerHand.cards[1].valueOf().toDouble()
        val scoreCardThree = rootService.swimApp.currentPlayer.playerHand.cards[2].valueOf().toDouble()

        return scoreCardOne + scoreCardTwo + scoreCardThree
    }

    /**
     * this function sets the next player
     */
    private fun nextPlayer(): Unit {
        // rootService.swimApp.players.indexOf(rootService.swimApp.currentPlayer + 1) = rootService.swimApp.currentPlayer
    }
}