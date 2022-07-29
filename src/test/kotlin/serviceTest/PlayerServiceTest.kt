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
        playerService.pass()
        assertEquals(1, game.passes)
    }

    @Test
    fun testCall() {

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