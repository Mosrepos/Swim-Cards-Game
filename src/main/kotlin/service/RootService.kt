package service


import entity.SwimApp
import view.Refreshable

/**
 * Main class of the service layer for the swim game.
 * It provides access to all other service classes and holds the [currentGame] state for these
 * services to access.
 *
 */
class RootService {

    val playerService = PlayerService(this)
    val swimService = SwimService(this)


    val currentGame: SwimApp = SwimApp()

    /**
     * Adds the provided [newRefreshable] to all services connected
     * to this root service
     */
    fun addRefreshable(newRefreshable: Refreshable) {
        swimService.addRefreshable(newRefreshable)
        playerService.addRefreshable(newRefreshable)
    }

    /**
     * Adds each of the provided [newRefreshables] to all services
     * connected to this root service
     */
    fun addRefreshables(vararg newRefreshables: Refreshable) {
        newRefreshables.forEach { addRefreshable(it) }
    }
}