package serviceTest

import org.junit.jupiter.api.Test
import service.RootService
import kotlin.test.assertTrue

/**
 * Class that provides tests for [SwimServiceTest]
 */
class SwimServiceTest {
    private val rootService = RootService()
    private val swimService = rootService.swimService
    private val refreshablesTest = RefreshablesTest()

    @Test
    fun testCreateGame() {
        //check if players list has a valid range
        //assertDoesNotThrow { swimService.createGame((listOf("player1", "player2", "player3"))) }


        //check if the correct amount of players is in the game
        //assert(rootService.currentGame.players.size == 3)
        //check if the drawPile has 29 cards

        //check if the table deck has 3 cards
        //return the 3 cards to the drawpile

        //check if the drawpile has the right cards


        //test overwriting a current game with a new one

    }

    @Test
    fun testStartGame() {
        rootService.addRefreshable(refreshablesTest)
        rootService.swimService.startGame()
        assertTrue { refreshablesTest.refreshAfterStartGameCalled }
        //check of all players drawn 3 cards
        //check if view refreshes
    }


}