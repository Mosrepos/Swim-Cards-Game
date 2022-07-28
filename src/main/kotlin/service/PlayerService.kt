package service

import entity.Card
import entity.Player
import kotlin.random.Random

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
        val game = rootService.currentGame
        checkNotNull(game)

        if (game.passes == game.players.size) {

            game.drawPile.cards.addAll(game.tableDeck.cards)
            game.drawPile.shuffle(Random(42))
            game.tableDeck.drawThreeCards()

        }

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
        checkNotNull(game)


        for (i in 0..2) {
            if (game.currentPlayer.playerHand.cards[i].toString() == selectedCard.toString() && game.tableDeck.cards[i].toString() == wantedCard.toString()) {

                game.tableDeck.cards.add(selectedCard)
                game.currentPlayer.playerHand.cards.remove(selectedCard)
                game.currentPlayer.playerHand.cards.add(wantedCard)
                game.tableDeck.cards.remove(wantedCard)
            }
        }


        onAllRefreshables { refreshAfterSwap() }
        return true

    }

    /**
     * this function lets the player do the action [swapAllCards]
     */
    fun swapAllCards(): Unit {
        val game = rootService.currentGame
        checkNotNull(game)

        val temp = game.tableDeck
        game.currentPlayer.playerHand = game.tableDeck
        game.currentPlayer.playerHand = temp
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