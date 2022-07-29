package service

import entity.SwimApp
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
    fun createGame(playersList: List<String>): Unit {

        val game = SwimApp()


        game.drawPile.shuffle(Random(42))




        rootService.currentGame = game
        onAllRefreshables { refreshAfterStartGame() }

    }

    /**
     * this function distributes the cards to the players
     */
    fun startGame(): Unit {

    }

    /**
     * this function ends the game
     */
    fun endGame(): Unit {

    }

}