package service

import entity.Deck

/**
 *
 *
 */

class SwimService(private val rootService: RootService) : AbstractRefreshingService() {

    /**
     *
     */
    public fun createGame(playersList: List<String>): Unit {
        val game = rootService.currentGame
    }

    /**
     *
     *
     */
    public fun startGame(deck: Deck): Unit {

    }

    /**
     *
     *
     */
    public fun endGame(): Unit {

    }

}