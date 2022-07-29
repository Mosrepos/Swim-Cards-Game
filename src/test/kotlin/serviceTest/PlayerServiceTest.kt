package serviceTest

import org.junit.jupiter.api.Test
import service.RootService
import kotlin.test.assertEquals


/**
 * Class that provides tests for [PlayerServiceTest]
 */
class PlayerServiceTest {

    private val rootService = RootService()
    private val playerService = rootService.playerService
    private val refreshablesTest = RefreshablesTest()


    val game = rootService.currentGame

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

    }

    @Test
    fun testSwapAllCards() {

    }

    @Test
    fun testCalculatePoints() {

    }
}