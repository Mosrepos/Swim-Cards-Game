package service

import entity.*
import kotlin.random.Random

/**
 * this class handles the game actions and knows the [rootService]
 *
 * @param [rootService] is the service that connects to the entity layer
 */

class SwimService(private val rootService: RootService) : AbstractRefreshingService() {

    /**
     * this function receives the @param [playersList] containing the names of the players and creates the player objects
     *
     * it creates a swim game
     */
    fun createGame(playersList: List<String>) {

        require(playersList.size in 2..4) { "the list size is not valid" }
        val players = mutableListOf<Player>()
        for (i in playersList) {
            players.add(Player(i))
        }

        // Creates a deck to draw cards from (drawPile).
        val drawPile = Deck()
        drawPile.cards = ArrayDeque(List(32) { index ->
            Card(
                CardSuit.values()[index / 8],
                CardValue.values()[index % 8]
            )
        })
        drawPile.shuffle(Random)

        val tableDeck = Deck()
        tableDeck.cards = ArrayDeque(drawPile.drawThreeCards())
        val game = SwimApp(players = players, drawPile = drawPile, tableDeck = tableDeck)

        rootService.currentGame = game
    }

    /**
     * this function distributes the cards to the players
     */
    fun startGame() {
        val game = rootService.currentGame

        game.tableDeck.cards = ArrayDeque(game.drawPile.drawThreeCards())

        for (i in game.players) {
            i.playerHand.cards = ArrayDeque(game.drawPile.drawThreeCards())
        }
        onAllRefreshables { refreshAfterStartGame() }
    }

    /**
     * this function ends the game
     */
    fun endGame() {
        onAllRefreshables { refreshAfterEndGame() }
    }

}