package serviceTest

import org.junit.jupiter.api.Test
import service.PlayerService
import service.RootService
import service.SwimService

/**
 * Class that provides tests for [SwimService] and [PlayerService] (both at the same time,
 * as their functionality is not easily separable)
 */
class ServiceTest {
    private val rootService = RootService()
    private val swimService = rootService.swimService

    @Test
    fun testCreateGame() {

    }


}