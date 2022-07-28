package service

import entity.Card
import entity.Player

/**
 * this class handles the player actions and knows the [rootService]
 *
 * @param [rootService] is the service that connects to the entity layer
 */

class PlayerService(private val rootService: RootService) : AbstractRefreshingService() {
    /**
     * this function increments the passes
     */
    fun pass(): Unit {

    }

    /**
     * this function lets the [currentPlayer] do the action [call]
     *
     *@param [currentPlayer] is the current player that wants to call
     */
    fun call(currentPlayer: Player): Unit {

    }

    /**
     * this function lets the player do the action [swapOneCard]
     * it recieves the @param [wantedCard] from the deck of the player and swaps it
     * with @param [selectedCard] from the table deck
     */
    fun swapOneCard(wantedCard: Card, selectedCard: Card): Boolean {

        val game = rootService.currentGame

        if (rootService.currentGame.currentPlayer.playerHand.cards.contains(wantedCard) && rootService.currentGame.tableDeck.cards.contains(
                selectedCard
            )
        ) {

            rootService.currentGame.currentPlayer.playerHand.cards.remove(wantedCard)
            rootService.currentGame.tableDeck.cards.remove(selectedCard)
            rootService.currentGame.currentPlayer.playerHand.cards.add(wantedCard)
            rootService.currentGame.tableDeck.cards.add(selectedCard)
            return true
        } else {
            return false
        }
    }

    /**
     * this function lets the player do the action [swapAllCards]
     */
    fun swapAllCards(): Unit {
        val temp = rootService.currentGame.tableDeck
        rootService.currentGame.currentPlayer.playerHand = rootService.currentGame.tableDeck
        rootService.currentGame.currentPlayer.playerHand = temp
    }

    /**
     * this function calculates the score of the player
     */
    fun calculatePoints(player: Player): Double {
        val playerCards = player.playerHand.cards

        // check 30.5 points rule
        val maxCardCountPerValue = playerCards.groupBy { it.value }
        if (maxCardCountPerValue.keys.size == 1) {
            return 30.5
        }

        // group by card color
        val cardsPerColor = playerCards.groupBy { it.suit }
        // hearts -> list(Heart-8, Heart-K)
        // spades -> list(Spades-A)
        val pointsPerColor = cardsPerColor.map { it.key to it.value.sumOf { jt -> jt.value.valueOf() } }

        // List<Pair<CardValue, Int>>
        // Pair: first, second
        // hearts -> 18
        // spades -> 11
        return pointsPerColor.maxOf { it.second }.toDouble()
    }

    /**
     * this function sets the next player
     */
    private fun nextPlayer(): Unit {
        // rootService.currentGame.players.indexOf(rootService.currentGame.currentPlayer + 1) = rootService.currentGame.currentPlayer
    }
}