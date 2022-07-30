package serviceTest

import org.junit.jupiter.api.Test
import service.RootService
import kotlin.test.BeforeTest
import kotlin.test.assertEquals


/**
 * Class that provides tests for [PlayerServiceTest]
 */
class PlayerServiceTest {

    private val rootService = RootService()
    private val playerService = rootService.playerService
    private val swimService = rootService.swimService
    private val refreshablesTest = RefreshablesTest()
    private val game = rootService.currentGame

    /**
     * create a game for testing
     */
    @BeforeTest
    fun setUpGame() {
        val players = listOf<String>("player1", "player2")

        swimService.createGame(players)
        swimService.startGame()
    }

    @Test
    fun testPass() {
        assertEquals(0, game.passes)
        playerService.pass()
        playerService.pass()
        assertEquals(2, game.passes)
    }

    @Test
    fun testCall() {
        game.passes = 1
        assert(game.calledPlayer == null)
        playerService.call()
        assert(game.calledPlayer != null)
        assert(game.passes == 0)
    }

    @Test
    fun testSwapOneCard() {
        val playerCard = game.currentPlayer.playerHand.cards[0]
        val tableCard = game.tableDeck.cards[0]
        //println(playerCard.toString())
        //println(tableCard.toString())
    }

    @Test
    fun testSwapAllCards() {

    }

    @Test
    fun testCalculatePoints() {
        for (i in game.players){
            println( playerService.calculatePoints(i))
        }

    }
}