package service

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

        /**
        val deck1 = Deck()
        val deck2 = Deck()
        val player1 = Player()
        val player2 = Player()

        val players: List<Player> =




        val game = SwimApp()


        rootService.currentGame = game
        onAllRefreshables { refreshAfterStartGame() }
         */
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