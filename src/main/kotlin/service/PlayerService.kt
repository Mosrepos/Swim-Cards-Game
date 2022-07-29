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
    fun pass() {
        val game = rootService.currentGame

        if (game.passes == game.players.size) {

            game.drawPile.cards.addAll(game.tableDeck.cards)
            game.drawPile.shuffle(Random(42))
            game.tableDeck.drawThreeCards()

            game.passes = 0

        } else {
            game.passes++
            nextPlayer()
            onAllRefreshables { refreshAfterPlayerChange() }
        }

    }

    /**
     * this function lets the player do the action [call]
     */
    fun call() {
        val game = rootService.currentGame

        if (game.calledPlayer == null) {
            game.calledPlayer = game.currentPlayer
        }
        game.passes = 0
        nextPlayer()
    }

    /**
     * this function lets the player do the action [swapOneCard]
     * it receives the @param [wantedCard] from the deck of the player and swaps it
     * with @param [selectedCard] from the table deck
     */
    fun swapOneCard(wantedCard: Card, selectedCard: Card): Boolean {

        val game = rootService.currentGame

        val tableCardIndex = game.tableDeck.cards.indexOf(wantedCard)
        val handCardIndex = game.currentPlayer.playerHand.cards.indexOf(selectedCard)

        if (tableCardIndex != -1 && handCardIndex != -1) {

            game.tableDeck.cards[tableCardIndex] = selectedCard
            game.currentPlayer.playerHand.cards[handCardIndex] = wantedCard
            onAllRefreshables { refreshAfterSwap() }
            game.passes = 0
            nextPlayer()

            return true
        }
        return false
    }

    /**
     * this function lets the player do the action [swapAllCards]
     */
    fun swapAllCards() {
        val game = rootService.currentGame


        val temp = game.tableDeck
        game.currentPlayer.playerHand = game.tableDeck
        game.currentPlayer.playerHand = temp

        game.passes = 0

        onAllRefreshables { refreshAfterSwap() }
        nextPlayer()

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
    private fun nextPlayer() {

        val game = rootService.currentGame

        val currentPlayerIndex = game.players.indexOf(game.currentPlayer)
        var nextPlayerIndex = currentPlayerIndex + 1
        if (nextPlayerIndex == game.players.size) {
            nextPlayerIndex = 0
        }
        game.currentPlayer = game.players[nextPlayerIndex]
        if (game.currentPlayer == game.calledPlayer) {
            rootService.swimService.endGame()
        } else {
            onAllRefreshables { refreshAfterPlayerChange() }
        }
    }
}