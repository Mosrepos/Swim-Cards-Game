package serviceTest

import org.junit.jupiter.api.Test
import service.RootService
import service.PlayerService
import kotlin.test.BeforeTest
import kotlin.test.assertEquals


/**
 * Class that provides tests for [PlayerService]
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


    /**
     * test if the function pass works correctly
     */
    @Test
    fun testPass() {
        assertEquals(0, game.passes)
        playerService.pass()
        playerService.pass()
        assertEquals(2, game.passes)
    }


    /**
     * test if the function call works correctly
     */
    @Test
    fun testCall() {
        game.passes = 1
        assert(game.calledPlayer == null)
        playerService.call()
        assert(game.calledPlayer != null)
        assert(game.passes == 0)
    }


    /**
     * test if the function swapOneCard works correctly
     */
    @Test
    fun testSwapOneCard() {
        val playerCard = game.currentPlayer.playerHand.cards[0]
        val tableCard = game.tableDeck.cards[0]
        //println(playerCard.toString())
        //println(tableCard.toString())
    }

    /**
     * test if the function swapAllCards works correctly
     */
    @Test
    fun testSwapAllCards() {
        val hand = game.currentPlayer.playerHand.cards
        val table = game.tableDeck.cards


        //check if the variables assigned correctly
        assertEquals(hand,game.currentPlayer.playerHand.cards)
        assertEquals(table,game.tableDeck.cards)

        playerService.swapAllCards()

        //check if swapped correctly
        assertEquals(table,game.currentPlayer.playerHand.cards)
        assertEquals(hand,game.tableDeck.cards)

    }


    /**
     * test if the function calculatePoints works correctly
     */
    @Test
    fun testCalculatePoints() {
        for (i in game.players){
            println( playerService.calculatePoints(i))
        }

    }
}