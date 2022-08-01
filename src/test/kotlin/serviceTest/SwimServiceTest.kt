package serviceTest

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import service.RootService

/**
 * Class that provides tests for [SwimServiceTest]
 */
class SwimServiceTest {
    private val rootService = RootService()
    private val swimService = rootService.swimService
    private val refreshablesTest = RefreshablesTest()


    /**
     * function to test creating a game
     */
    @Test
    fun testCreateGame() {
        assertDoesNotThrow { swimService.createGame((listOf("player1", "player2", "player3"))) }

        val game = rootService.currentGame
        //create players for the game
        val players = listOf<String>("p1", "p2", "p3")
        swimService.createGame(players)
        //check if players list has a valid range
        assert(game.players.size > 2 && game.players.size < 4)


        //check if the correct amount of players is in the game
        assert(game.players.size == 3)
        //check if the drawPile has 29 cards
        assert(game.drawPile.cards.size == 32)
        //check if the table deck has 3 cards
        assert(game.tableDeck.cards.size == 0)
        //return the 3 cards to the draw pile

        //check if the draw pile has the right cards


        //test overwriting a current game with a new one

    }

    /**
     *test if the function startGame works correctly
     *
     * the table deck and each player should draw 3 cards from the pile
     */

    @Test
    fun testStartGame() {

        val game = rootService.currentGame
        //create players for the game
        val players = listOf<String>("p1", "p2", "p3")
        swimService.createGame(players)

        swimService.startGame()

        //check of all players drawn 3 cards
        for (i in 0..2) {
            //assertEquals(3,game.players[i].playerHand.cards.size)
        }
        //assertEquals(3, game.tableDeck.cards.size)

        rootService.addRefreshable(refreshablesTest)
        //assertTrue { refreshablesTest.refreshAfterStartGameCalled }
    }


}